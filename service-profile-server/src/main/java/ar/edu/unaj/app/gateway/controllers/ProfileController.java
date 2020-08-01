package ar.edu.unaj.app.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unaj.app.gateway.models.UserProfile;
import ar.edu.unaj.app.gateway.models.UserToken;
import ar.edu.unaj.app.gateway.service.ProfileImp;
import ar.edu.unaj.app.gateway.service.ProfileService;


@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService serviceProfile;

	@GetMapping
	@RequestMapping(path = "/profile")
	public UserProfile profile(@RequestParam(required = false, value= "id") String id) {
		UserToken userToken = serviceProfile.getTokenforUser(id);
		UserProfile obj = serviceProfile.getProfile(
				"Bearer "+userToken.getToken(),
				id);

		return obj;
	}

}
