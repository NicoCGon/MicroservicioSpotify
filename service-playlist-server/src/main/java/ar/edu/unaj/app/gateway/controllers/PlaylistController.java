package ar.edu.unaj.app.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unaj.app.gateway.models.UserPlaylist;
import ar.edu.unaj.app.gateway.service.PlaylistImp;

@RestController
public class PlaylistController {
	
	@Autowired
	private PlaylistImp servicePlaylist;

	@GetMapping
	@RequestMapping(path = "/playlist")
	public UserPlaylist playlist() {

		String user = "21ie6rh6bayixiczazk3iqbsq";
//		Object obj = client.getPlaylistItems(
//				"Bearer BQBQzawCslI6-_lx9K1CAr0PPrMXeDVQd6hcks0DV56OtxZ0AqrKSnkYs_lAJh2yoXlJkP32L8CKVC1aebELub8zhPK8-ZvJSdmbOXlHrGpIkHEhx4zXBPe5MLvclSaDw-q4CxReRFDVX5eQgA59ZsahYQASs0Dm18V9xSvjN8T9MBF-55pacZRI_oAbqfRmkDhS65dIO0_aLlnh_HKDyBR1QgEDSlgdSLEZabtOtsV8Qd_u6iTIxFNsfNDP8ImQobxEQDTWw4utedm7ZH9FSmXm_FUB_vdkFjfD",
//				"0TnOYISbd1XYRBk9myaseg");
		UserPlaylist obj = servicePlaylist.getPLaylist(
				"Bearer BQDfCKKD8ClAA2yD85UW0Ilfv1VxABQF2NbUry4iFVSYmSppX-2H4HoHaVs2mXEmR5JBorfBRr6-c9IgTFTr5oZkVpqlJum9WfyppW1qqvGGirERwZbKKaAgNTjUwOm1aT0V1lSkpVc5RnAANDmx1DLphv8LyYQdFwa1ATikScc2OiHGHOnUvSHEab0ajaIUWByfJhxqDwKk5xPXX7HXbcwvzYO_GtMevMfZfRvjWRzWxaUusWxr7ZtKO7Zp8OBzj1Y",
				user);

		return obj;
	}

}
