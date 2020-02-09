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
		if (country != null && country.getId() == null) {
			Country c = countryRepository.findTopByOrderByIdDesc();
			country.setId(c == null ? 1L : (c.getId() + 1));
		}
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

	public List<CountryDTO> findByIdGreaterOrEqualsThan(Long id) {
		return countryMapper.toDto(countryRepository.findByIdGreaterThanEqual(id));
	}

	public List<CountryDTO> findByCodeContaining(String code) {
		return countryMapper.toDto(countryRepository.findByCodeContaining(code));
	}

	public List<CountryDTO> findByNameIsNull() {
		return countryMapper.toDto(countryRepository.findByNameIsNull());
	}

	public List<CountryDTO> findByNameStartingWithOrderById(String name) {
		return countryMapper.toDto(countryRepository.findByNameStartingWithOrderById(name));
	}

	public CountryDTO findByCode(String code) {
		Country country = countryRepository.findByCode(code);
		return countryMapper.toDto(country);
	}

	public List<CountryDTO> findByNameEndingWithOrderByCodeDesc(String name) {
		List<Country> countries = countryRepository.findByNameEndingWithOrderByCodeDesc(name);
		return countryMapper.toDto(countries);
	}
}
