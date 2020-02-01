package it.objectmethod.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.springboot.dto.CountryDTO;
import it.objectmethod.springboot.service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@PostMapping("/country")
	public CountryDTO save(@RequestBody CountryDTO country) {
		return countryService.save(country);
	}

	@GetMapping("/country/all")
	public List<CountryDTO> findAll() {
		return countryService.findAll();
	}

	@GetMapping("/country/{id}")
	public CountryDTO findById(@PathVariable Long id) {
		return countryService.findOne(id);
	}

	@DeleteMapping("/country/{id}")
	public void deleteCountry(@PathVariable Long id) {
		countryService.delete(id);
	}

}
