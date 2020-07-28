package ar.edu.unaj.app.gateway.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unaj.app.gateway.clients.SpotifyClient;
import ar.edu.unaj.app.gateway.models.UserPlaylist;
import ar.edu.unaj.app.gateway.models.UserToken;
import ar.edu.unaj.app.gateway.repository.UserTokenRepository;

@Service
public class PlaylistImp implements PlaylistService {

	@Autowired
	private SpotifyClient client;
	
	@Autowired
	private UserTokenRepository userTokenRepository;
	
	@Override
	public UserPlaylist getPLaylist(String token, String idPlaylist) {
		UserPlaylist obj =client.getPlaylistItems(token, idPlaylist);
		return obj ;		
	}

	@Override
	public UserToken getTokenforUser(String id) {
		Optional<UserToken> userToken = userTokenRepository.findById(id);
		return userToken.get();
	}

}
