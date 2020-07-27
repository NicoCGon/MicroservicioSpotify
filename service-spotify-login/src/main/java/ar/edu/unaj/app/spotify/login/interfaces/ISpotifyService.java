package ar.edu.unaj.app.spotify.login.interfaces;

import ar.edu.unaj.app.spotify.login.webservice.entities.UserSpotify;
import ar.edu.unaj.app.spotify.login.webservice.entities.UserTokenSpotify;

public interface ISpotifyService {
	public UserTokenSpotify findWebServiceToken(String code) throws Exception;
	public UserSpotify findWebServiceUser(String code) throws Exception;
}
