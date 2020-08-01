package ar.edu.unaj.app.playlist.service;

import ar.edu.unaj.app.playlist.models.UserPlaylist;
import ar.edu.unaj.app.playlist.models.UserToken;

public interface PlaylistService {
	
	public UserPlaylist getPLaylist(String token ,String idPlaylist);
	
	public UserToken getTokenforUser(String id );

}
