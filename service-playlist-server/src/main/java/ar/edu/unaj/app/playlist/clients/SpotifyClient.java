package ar.edu.unaj.app.gateway.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unaj.app.gateway.models.UserPlaylist;
import feign.Headers;

@FeignClient(value = "spotify", url = "https://api.spotify.com/v1/")
public interface SpotifyClient {
	
	String AUTH_TOKEN = "Authorization";
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{user_id}/playlists", produces = "application/json")
	@Headers ("Content-Type: application/json") 
	public UserPlaylist getPlaylistItems(@RequestHeader(AUTH_TOKEN) String bearerToken,@PathVariable String user_id);
}
