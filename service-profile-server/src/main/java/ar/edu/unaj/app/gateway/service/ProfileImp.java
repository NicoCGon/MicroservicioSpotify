package ar.edu.unaj.app.gateway.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unaj.app.gateway.clients.SpotifyClient;
import ar.edu.unaj.app.gateway.models.UserProfile;
import ar.edu.unaj.app.gateway.models.UserToken;
import ar.edu.unaj.app.gateway.repository.UserTokenRepository;

@Service
public class ProfileImp implements ProfileService {

	@Autowired
	private SpotifyClient client;
	
	@Autowired
	private UserTokenRepository userTokenRepository;
	
	@Override
	public UserProfile getProfile(String token, String idProfile) {
		UserProfile obj =client.getProfileItems(token, idProfile);
		return obj ;		
	}

	@Override
	public UserToken getTokenforUser(String id) {
		Optional<UserToken> userToken = userTokenRepository.findById(id);
		return userToken.get();
	}

}
