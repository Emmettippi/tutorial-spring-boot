package it.objectmethod.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.springboot.dto.CountryDTO;
import it.objectmethod.springboot.dto.mapper.CountryMapper;
import it.objectmethod.springboot.model.Country;
import it.objectmethod.springboot.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	private final CountryMapper countryMapper;

	public CountryService() {
		this.countryMapper = new CountryMapper();
	}

	public CountryDTO save(CountryDTO countryDto) {
		Country country = countryMapper.toEntity(countryDto);
		country = countryRepository.save(country);
		return countryMapper.toDto(country);
	}

	public CountryDTO findOne(Long id) {
		Country country = countryRepository.findOne(id);
		return countryMapper.toDto(country);
	}

	public List<CountryDTO> findAll() {
		return countryMapper.toDto(countryRepository.findAll());
	}

	public void delete(Long id) {
		countryRepository.delete(id);
	}

}
