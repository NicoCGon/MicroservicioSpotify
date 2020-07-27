package ar.edu.unaj.app.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unaj.app.gateway.clients.SpotifyClient;
import ar.edu.unaj.app.gateway.models.UserPlaylist;

@Service
public class PlaylistImp implements PlaylistService {

	@Autowired
	private SpotifyClient client;
	
	@Override
	public UserPlaylist getPLaylist(String token, String idPlaylist) {
		UserPlaylist obj =client.getPlaylistItems(token, idPlaylist);
		return obj ;		
	}

}
