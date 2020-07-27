package ar.edu.unaj.app.gateway.service;

import ar.edu.unaj.app.gateway.models.UserPlaylist;

public interface PlaylistService {
	
	public UserPlaylist getPLaylist(String token ,String idPlaylist);

}
