package ar.edu.unaj.app.playlist.clients;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unaj.app.playlist.models.UserPlaylist;
import ar.edu.unaj.app.playlist.response.data.ListItemsTracks;
import ar.edu.unaj.app.playlist.resquest.data.MyTracksParams;
import ar.edu.unaj.app.playlist.resquest.data.TracksDelete;
import feign.Headers;

@FeignClient(value = "spotify", url = "https://api.spotify.com/v1/")
public interface SpotifyClient {

	String AUTH_TOKEN = "Authorization";

	@RequestMapping(method = RequestMethod.GET, value = "/users/{user_id}/playlists", produces = "application/json")
	@Headers("Content-Type: application/json")
	public UserPlaylist getPlaylistItems(@RequestHeader(AUTH_TOKEN) String bearerToken, @PathVariable String user_id);

	@RequestMapping(method = RequestMethod.PUT, value = "/playlists/{playlist_id}")
	@Headers("Content-Type: application/json")
	public Object changePlaylist(@RequestHeader(AUTH_TOKEN) String bearerToken, @PathVariable String playlist_id,
			Map data);

	@RequestMapping(method = RequestMethod.POST, value = "/users/{user_id}/playlists")
	@Headers("Content-Type: application/json")
	public Object CreatedPlaylist(@RequestHeader(AUTH_TOKEN) String bearerToken, @PathVariable String user_id,
			Map data);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/playlists/{playlist_id}/tracks")
	@Headers("Content-Type: application/json")
	public Object deleteTrackPlaylist(@RequestHeader(AUTH_TOKEN) String bearerToken, @PathVariable String playlist_id,
			TracksDelete data);
	
	@RequestMapping(method = RequestMethod.POST, value = "/playlists/{playlist_id}/tracks")
	@Headers("Content-Type: application/json")
	public Object addTrackPlaylist(@RequestHeader(AUTH_TOKEN) String bearerToken, @PathVariable String playlist_id,
			Map uris);

	
	@RequestMapping(method = RequestMethod.GET, value = "/playlists/{playlist_id}/tracks")
	@Headers("Content-Type: application/json")
	public ListItemsTracks listTracks(@RequestHeader(AUTH_TOKEN) String bearerToken, @PathVariable String playlist_id,
			@SpringQueryMap MyTracksParams data);
}
