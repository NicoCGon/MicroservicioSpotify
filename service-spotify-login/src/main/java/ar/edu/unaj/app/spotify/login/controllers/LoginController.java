package ar.edu.unaj.app.spotify.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unaj.app.spotify.login.interfaces.ILoginService;
import ar.edu.unaj.app.spotify.login.webservice.entities.UserSpotify;

@RestController
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@GetMapping
	@RequestMapping(path = "/login")
	public UserSpotify login(@RequestParam(required = false, value= "code") String code){
		try {
			if(code  != null) {
				UserSpotify idUser =loginService.saveUserToken(code);
				return idUser;
			}

		}
		catch (Exception exception) {
			exception.printStackTrace();
//			model.addAttribute("reason", exception);
			return  null ;
		}
		return null;
	}
}
