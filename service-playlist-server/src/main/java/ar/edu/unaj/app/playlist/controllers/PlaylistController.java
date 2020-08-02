package ar.edu.unaj.app.playlist.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unaj.app.playlist.clients.SpotifyClient;
import ar.edu.unaj.app.playlist.models.UserPlaylist;
import ar.edu.unaj.app.playlist.models.UserToken;
import ar.edu.unaj.app.playlist.response.data.ListItemsTracks;
import ar.edu.unaj.app.playlist.resquest.data.MyTracksParams;
import ar.edu.unaj.app.playlist.resquest.data.NewPlaylist;
import ar.edu.unaj.app.playlist.resquest.data.ParamsChangePlaylist;
import ar.edu.unaj.app.playlist.resquest.data.TracksDelete;
import ar.edu.unaj.app.playlist.resquest.data.Uri;
import ar.edu.unaj.app.playlist.service.PlaylistService;

@RestController
public class PlaylistController {

	@Autowired
	private PlaylistService servicePlaylist;

	@Autowired
	private SpotifyClient client;

	@PostMapping("/playlist/new")
	public ResponseEntity<?> createdPlaylist(@RequestBody NewPlaylist playlist) {

		UserToken usertoken = servicePlaylist.getTokenforUser(playlist.getIdUser());
		Map<String, Object> params = new HashMap<>();
		params.put("name", playlist.getName());
		params.put("description", playlist.getDescription());
		params.put("public", playlist.isTipo());

		client.CreatedPlaylist("Bearer " + usertoken.getToken(), playlist.getIdUser(), params);
		return ResponseEntity.status(HttpStatus.OK).body("ok");
	}

	@GetMapping
	@RequestMapping(path = "/playlist")
	public UserPlaylist playlist(@RequestParam(required = false, value = "id") String id) {

		String user = "21ie6rh6bayixiczazk3iqbsq";
		UserToken usertoken = servicePlaylist.getTokenforUser(id);
		UserPlaylist obj = servicePlaylist.getPLaylist("Bearer " + usertoken.getToken(), id);
		return obj;
	}

	@PutMapping("/playlists/{playlist_id}")
	public ResponseEntity<?> changePlaylist(@RequestBody NewPlaylist paramsPlaylist,
			@PathVariable String playlist_id) {

		UserToken usertoken = servicePlaylist.getTokenforUser(paramsPlaylist.getIdUser());

		Map<String, Object> params = new HashMap<>();
		params.put("name", paramsPlaylist.getName());
		params.put("description", paramsPlaylist.getDescription());
		params.put("public", false);

		client.changePlaylist("Bearer " + usertoken.getToken(), playlist_id, params);
		return ResponseEntity.status(HttpStatus.OK).body("ok");
	}

	@DeleteMapping("/playlists/{playlist_id}/delete/tracks/{idUser}")
	public ResponseEntity<?> deleteTracks(@RequestBody TracksDelete traks, @PathVariable String playlist_id,
			@PathVariable String idUser) {

		UserToken usertoken = servicePlaylist.getTokenforUser(idUser);

		client.deleteTrackPlaylist("Bearer " + usertoken.getToken(), playlist_id, traks);
		return ResponseEntity.status(HttpStatus.OK).body("ok");

	}

	@PostMapping("/playlists/{playlist_id}/add/tracks/{idUser}")
	public ResponseEntity<?> addSong(@RequestBody Uri uri, @PathVariable String playlist_id,
			@PathVariable String idUser) {

		Map<String, String> track = new HashMap<>();
		track.put("uris", uri.getUri());
		UserToken usertoken = servicePlaylist.getTokenforUser(idUser);
		client.addTrackPlaylist("Bearer " + usertoken.getToken(), playlist_id, track);
		return ResponseEntity.status(HttpStatus.OK).body("ok");
	}

	@GetMapping("/playlists/{playlist_id}/tracks/{idUser}")
	public ResponseEntity<?> listTrackPlaylist( @PathVariable String playlist_id,@PathVariable String idUser) {

		UserToken usertoken = servicePlaylist.getTokenforUser(idUser);
		MyTracksParams params = new MyTracksParams("AR", "", "100", "0");
		ListItemsTracks listTracks= (ListItemsTracks) client.listTracks("Bearer " + usertoken.getToken(), playlist_id, params);
		
		return ResponseEntity.status(HttpStatus.OK).body(listTracks);

	}
}
