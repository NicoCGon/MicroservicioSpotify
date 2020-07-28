package ar.edu.unaj.app.gateway.service;

import ar.edu.unaj.app.gateway.models.UserProfile;

public interface ProfileService {
	
	public UserProfile getProfile(String token ,String idProfile);

}
