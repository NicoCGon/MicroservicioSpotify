package ar.edu.unaj.app.spotify.login.interfaces;

import ar.edu.unaj.app.spotify.login.webservice.entities.UserSpotify;

public interface ILoginService {
	public String userFindToken();
	public UserSpotify saveUserToken(String token) throws Exception;
}
