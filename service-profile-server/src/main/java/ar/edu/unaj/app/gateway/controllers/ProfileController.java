package ar.edu.unaj.app.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unaj.app.gateway.models.UserProfile;
import ar.edu.unaj.app.gateway.service.ProfileImp;


@RestController
public class ProfileController {
	
	@Autowired
	private ProfileImp serviceProfile;

	@GetMapping
	@RequestMapping(path = "/profile")
	public UserProfile profile() {

		String user_id = "11156568004";
		
		UserProfile obj = serviceProfile.getProfile(
				"Bearer BQCNGv1tB6zXDPrIhA9h7Z7GaScHG9XCd65ycc_iJOMdBJR38GeeZW4HqUOnxo3T9EtDwVAk5JCJfKYoseixGWTuL1BBX9VRsfMOFNf8UZFSDU-xYFiU3myGQPNTgC5KdBoaeLk1rnt7u1YLYqvO1lPkiA_qSKE2aBfv7qNRo9148ZATTem73O_jryPOH8eEZmUSVdbA9uOtc8hhf6nEevEJBVkeDLeyqaxJgAisoNkoHyaLcGGECVPmjKevBXbeAusWkdKwF35ewg",
				user_id);

		return obj;
	}

}
