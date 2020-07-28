package ar.edu.unaj.app.spotify.login.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ar.edu.unaj.app.spotify.login.entities.User;
import ar.edu.unaj.app.spotify.login.entities.UserToken;
import ar.edu.unaj.app.spotify.login.interfaces.ILoginService;
import ar.edu.unaj.app.spotify.login.interfaces.ISpotifyService;
import ar.edu.unaj.app.spotify.login.repositories.UserRepository;
import ar.edu.unaj.app.spotify.login.repositories.UserTokenRepository;
import ar.edu.unaj.app.spotify.login.webservice.entities.UserSpotify;
import ar.edu.unaj.app.spotify.login.webservice.entities.UserTokenSpotify;

@Service
public class LoginService implements ILoginService{
	
	@Autowired 
	private ISpotifyService spotifyService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTokenRepository userTokenRepository;
	
	@Value("${configuration.urlSpotifyToken}")
	private String urlSpotifyToken;

	@Override
	public String userFindToken() {
		return urlSpotifyToken;
	}

	@SuppressWarnings("unused")
	public UserSpotify saveUserToken(String code) throws Exception{
		UserSpotify userSpotify = spotifyService.findWebServiceUser(code);
		if(userSpotify != null) {
			Optional<User> user = userRepository.findById(userSpotify.getId());
			if(!user.isPresent()) {
				userRepository.save(new User(userSpotify.getId(), userSpotify.getDisplay_name(), userSpotify.getEmail(), userSpotify.getCountry()));
			}
			Optional<UserToken> userToken = userTokenRepository.findById(userSpotify.getId());
			//TODO: FALTA Logica para respetar una hora el token
			UserTokenSpotify userTokenSpotify = (UserTokenSpotify) userSpotify.getExplicit_content();
			userTokenRepository.save(new UserToken(userSpotify.getId(), userTokenSpotify.getAccess_token(), new Date()));
		}
		return userSpotify;
	}
}
