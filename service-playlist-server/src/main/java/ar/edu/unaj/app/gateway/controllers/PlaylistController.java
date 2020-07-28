package ar.edu.unaj.app.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unaj.app.gateway.models.UserPlaylist;
import ar.edu.unaj.app.gateway.models.UserToken;
import ar.edu.unaj.app.gateway.service.PlaylistImp;
import ar.edu.unaj.app.gateway.service.PlaylistService;

@RestController
public class PlaylistController {
	
	@Autowired
	private PlaylistService servicePlaylist;

	@GetMapping
	@RequestMapping(path = "/playlist")
	public UserPlaylist playlist(@RequestParam(required = false, value= "id") String id) {

		String user = "21ie6rh6bayixiczazk3iqbsq";
		UserToken usertoken = servicePlaylist.getTokenforUser(user);
		UserPlaylist obj = servicePlaylist.getPLaylist(
				"Bearer "+usertoken.getToken(),
				id);
		return obj;
	}
}
