package ar.edu.unaj.app.gateway.service;

import ar.edu.unaj.app.gateway.models.UserProfile;
import ar.edu.unaj.app.gateway.models.UserToken;

public interface ProfileService {
	
	public UserProfile getProfile(String token ,String idProfile);
	
	public UserToken getTokenforUser(String id); 

}
