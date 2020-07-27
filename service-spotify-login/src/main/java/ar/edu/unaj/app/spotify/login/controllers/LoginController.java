package ar.edu.unaj.app.spotify.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unaj.app.spotify.login.interfaces.ILoginService;

@Controller
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@GetMapping
	@RequestMapping(path = "/login")
	public String login(@RequestParam(required = false, value= "code") String code, Model model){
		try {
			if(code  != null) {
				loginService.saveUserToken(code);
				return "general/login";
			}
			else {
				return "redirect:"+loginService.userFindToken();
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
			model.addAttribute("reason", exception);
			return "general/error";
		}
	}
}
