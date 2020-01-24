package it.objectmethod.esempio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import it.objectmethod.esempio.dao.IDaoNazioni;

@Controller
public class HomeController {
	
	@Autowired
	private IDaoNazioni daoNaz;

	@GetMapping("/index")
	public String home(ModelMap map) {
		List<String> conts = daoNaz.getAllContinenti();
		map.addAttribute("primo", conts.get(0));
		
		
		return "home";	
	}
}
