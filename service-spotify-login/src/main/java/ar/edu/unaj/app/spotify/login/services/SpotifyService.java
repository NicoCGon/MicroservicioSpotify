package ar.edu.unaj.app.spotify.login.services;

import java.net.URI;

import javax.net.ssl.SSLContext;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.edu.unaj.app.spotify.login.constants.Constant;
import ar.edu.unaj.app.spotify.login.interfaces.ISpotifyService;
import ar.edu.unaj.app.spotify.login.webservice.entities.UserSpotify;
import ar.edu.unaj.app.spotify.login.webservice.entities.UserTokenSpotify;

@Service
public class SpotifyService implements ISpotifyService{
	
	@Value("${configuration.urlSpotifyUserProfile}")
	private String urlSpotifyUserProfile;
	
	@Value("${configuration.urlSpotifyFindToken}")
	private String urlSpotifyFindToken;
	
	@Value("${configuration.urlSpotifyClientID}")
	private String urlSpotifyClientID;
	
	@Value("${configuration.urlRedirectURI}")
	private String urlRedirectURI;

	@SuppressWarnings("deprecation")
	private CloseableHttpClient clientPrepare() throws Exception {
		SSLContext context = org.apache.http.conn.ssl.SSLContexts.custom().useTLS().build();
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(context,new String[]{"TLSv1","TLSv1.2"},null,new NoopHostnameVerifier());
		RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).build();
		CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(socketFactory).setDefaultRequestConfig(config).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		return client;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public UserSpotify findWebServiceUser(String code) throws Exception {
		CloseableHttpClient client = clientPrepare();
		UserTokenSpotify userToken = findWebServiceToken(code);

		HttpGet getProfile = new HttpGet(urlSpotifyUserProfile);
		getProfile.addHeader("Accept", "application/json");
		getProfile.addHeader("Content-Type", "application/json");
		getProfile.addHeader("Authorization", String.join(Constant.INTERL, Constant.BEARER, userToken.getAccess_token()));
		
		CloseableHttpResponse response = client.execute(getProfile);
		JsonParser parser= new JsonFactory().createJsonParser(response.getEntity().getContent());
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT); 
		UserSpotify userSpotify = objectMapper.readValue(parser, UserSpotify.class);
		userSpotify.setExplicit_content(userToken);
		return userSpotify;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public UserTokenSpotify findWebServiceToken(String code) throws Exception {
		CloseableHttpClient client = clientPrepare();
		
		URIBuilder builder = new URIBuilder(urlSpotifyFindToken);
	    builder.setParameter("grant_type", "authorization_code")
	    .setParameter("code", code)
	    .setParameter("redirect_uri", urlRedirectURI);
		URI uri = builder.build();
		HttpPost getToken = new HttpPost(uri);
		getToken.addHeader("Content-Type", "application/x-www-form-urlencoded");
		getToken.addHeader("Authorization", String.join(Constant.INTERL, Constant.BASIC, urlSpotifyClientID));
		
		CloseableHttpResponse response = client.execute(getToken);
		JsonParser parser= new JsonFactory().createJsonParser(response.getEntity().getContent());
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT); 
		return objectMapper.readValue(parser, UserTokenSpotify.class);
	}
	
}
