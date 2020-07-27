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
public class WebServiceSpotifyFindProfile {
	private String URL_SPOTIFY_PROFILE = "https://api.spotify.com/v1/me";
	private String URL_SPOTIFY_TOKEN_TEMP = "Bearer BQDUfPsoPXVcNYxEhIC9VKoE84o-oHoQZUGkDTmDOW8zBIXcL_gIiJxhB8BZrB5jnkS7bvGpdDWFQihtzm5xT0YrpuvZMZeMoYL8M_sHmHiV8u7SBZc000df5jo0vbegKiqF7W4UGh1tl19dBuXv5pIOe-zW7MP4OzvVLdoEO-Dn79r4cWhnxbe_6Ygm76wtgOPa47XQkRAnNGLKc8x2c2ga_iwi9_xJtbfaDCApuVUFoNE3MpnMv3K9qhlYsuT0PzkqPVnXZ4Hnxcl54LAZ2THjdibcSvnS";
	
	@Test
	public void webServiceSpotifyFindProfile() {
		try {
			SSLContext context = SSLContexts.custom().useTLS().build();
			SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(context,new String[]{"TLSv1","TLSv1.2"},null,new NoopHostnameVerifier());
			RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).build();
			CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(socketFactory).setDefaultRequestConfig(config).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
			
			HttpGet getProfile = new HttpGet(URL_SPOTIFY_PROFILE);
			getProfile.addHeader("Accept", "application/json");
			getProfile.addHeader("Content-Type", "application/json");
			getProfile.addHeader("Authorization", URL_SPOTIFY_TOKEN_TEMP);
			CloseableHttpResponse response = client.execute(getProfile);
			try (InputStream is = response.getEntity() == null ? null : response.getEntity().getContent()) {
				System.out.println(IOUtils.toString(response.getEntity().getContent(),StandardCharsets.UTF_8.name()));
		  	}

		}
		catch (Exception e) {
			Assert.assertTrue(e.getMessage(), false);
		}
	}
}
