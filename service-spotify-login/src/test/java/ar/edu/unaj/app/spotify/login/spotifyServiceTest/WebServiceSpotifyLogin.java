package ar.edu.unaj.app.spotify.login.spotifyServiceTest;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.SSLContext;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


@SuppressWarnings("deprecation")
public class WebServiceSpotifyLogin {
	private String URL_SPOTIFY = "https://accounts.spotify.com/authorize?client_id=c444f9c5b8ed428380e8c1453a2878cb&response_type=code&redirect_uri=http://localhost:8080/Java-Web-Login/login&scope=user-read-private%20user-read-email%20user-follow-read%20playlist-modify-public%20playlist-modify-private%20playlist-read-collaborative%20playlist-read-private";
	
	@Test
	public void webServiceSpotifyTest() {
		try {
			SSLContext context = SSLContexts.custom().useTLS().build();
			SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(context,new String[]{"TLSv1","TLSv1.2"},null,new NoopHostnameVerifier());
			RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).build();
			CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(socketFactory).setDefaultRequestConfig(config).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
			
			CloseableHttpResponse response = client.execute(new HttpGet(URL_SPOTIFY)); 
			try (InputStream is = response.getEntity() == null ? null : response.getEntity().getContent()) {
				System.out.println(IOUtils.toString(response.getEntity().getContent(),StandardCharsets.UTF_8.name()));
		  	}

		}
		catch (Exception e) {
			Assert.assertTrue(e.getMessage(), false);
		}
	}
}
