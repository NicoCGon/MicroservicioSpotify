package ar.edu.unaj.app.gateway.service;

import ar.edu.unaj.app.gateway.models.UserPlaylist;
import ar.edu.unaj.app.gateway.models.UserToken;

public interface PlaylistService {
	
	public UserPlaylist getPLaylist(String token ,String idPlaylist);
	
	public UserToken getTokenforUser(String id );

}
