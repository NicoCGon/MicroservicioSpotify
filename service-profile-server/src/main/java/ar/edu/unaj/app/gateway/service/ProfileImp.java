package ar.edu.unaj.app.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unaj.app.gateway.clients.SpotifyClient;
import ar.edu.unaj.app.gateway.models.UserProfile;

@Service
public class ProfileImp implements ProfileService {

	@Autowired
	private SpotifyClient client;
	
	@Override
	public UserProfile getProfile(String token, String idProfile) {
		UserProfile obj =client.getProfileItems(token, idProfile);
		return obj ;		
	}

}
