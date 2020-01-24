package it.objectmethod.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import it.objectmethod.springboot.dao.DaoNazioni;

@Controller
public class HomeController {

	@Autowired
	private DaoNazioni daoNazioni;

	@GetMapping("/index")
	public String home(ModelMap map) {
		List<String> conts = daoNazioni.getAllContinenti();
		map.addAttribute("primo", conts.get(0));

		return "home";
	}
}
