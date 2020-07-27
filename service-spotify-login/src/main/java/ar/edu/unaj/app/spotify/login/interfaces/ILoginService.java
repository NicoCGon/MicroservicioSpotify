package ar.edu.unaj.app.spotify.login.interfaces;

public interface ILoginService {
	public String userFindToken();
	public void saveUserToken(String token) throws Exception;
}
