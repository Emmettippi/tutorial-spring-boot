package it.objectmethod.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(ModelMap map) {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String home2(ModelMap map) {
		return "home";
	}

	@GetMapping("/country")
	public String country(ModelMap map) {
		return "country/country";
	}
}
