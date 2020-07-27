package ar.edu.unaj.app.spotify.login.spotifyServiceTest;

import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.SSLContext;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


@SuppressWarnings("deprecation")
public class WebServiceSpotifyFindToken {
	private String URL_SPOTIFY_CODE_TEMP = "AQBLxiEBugyagAX-YU4w9uWA2ahqdgLoOotYeTddw-AI_F_me7lKEev4PE7PtA6K8I-JSaYzqGrjnvT5gcDrIGVgMo-7aWwVXxV5YXmpm374Q0fZ_i8KpcrkkVCbjl1dIIj_F1KSoKKAaP3u3cLh9hqIOGF8M1Qyz12RZZmbkgmT9qjKYd2TfeCTtZccPpdAOx9OOBrDd1nPLWYIV7tt0DX1caOv5xPs2HqR3crdbcsCGv099uHRiMLpZRwgc0jFQdpcYNrTbHqduSMwledp73WCnNhKHrMChSK8t_vravl1J8GakBNwMSDZ8dZaWmMPyIODWy1N7gmJZwCd1pEHPVam-J-qZGxUU6g6JdzQoUyORm8mXiDQ4ahXTRNDSIOq1TnZA8QsG-7R";
	private String URL_SPOTIFY_TOKEN = "https://accounts.spotify.com/api/token";
	private String URL_SPOTIFY_CLIENT_ID = "Basic YzQ0NGY5YzViOGVkNDI4MzgwZThjMTQ1M2EyODc4Y2I6MzFlMGRkYTYwZTFkNGNjOWIyNmEwZjJkOTE0MjhhMjE=";
	private String URL_REDIRECT_URI = "http://localhost:8080/Java-Web-Login/login";
	
	@Test
	public void webServiceSpotifyFindProfile() {
		try {
			SSLContext context = SSLContexts.custom().useTLS().build();
			SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(context,new String[]{"TLSv1","TLSv1.2"},null,new NoopHostnameVerifier());
			RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).build();
			CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(socketFactory).setDefaultRequestConfig(config).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
			
			URIBuilder builder = new URIBuilder(URL_SPOTIFY_TOKEN);
		    builder.setParameter("grant_type", "authorization_code")
		    .setParameter("code", URL_SPOTIFY_CODE_TEMP)
		    .setParameter("redirect_uri", URL_REDIRECT_URI);
			URI uri = builder.build();
			HttpPost getToken = new HttpPost(uri);
			getToken.addHeader("Content-Type", "application/x-www-form-urlencoded");
			getToken.addHeader("Authorization", URL_SPOTIFY_CLIENT_ID);
			
			CloseableHttpResponse response = client.execute(getToken);
			try (InputStream is = response.getEntity() == null ? null : response.getEntity().getContent()) {
				System.out.println(IOUtils.toString(response.getEntity().getContent(),StandardCharsets.UTF_8.name()));
		  	}
		}
		catch (Exception e) {
			Assert.assertTrue(e.getMessage(), false);
		}
	}
}
