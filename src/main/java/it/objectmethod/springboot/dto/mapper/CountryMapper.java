package it.objectmethod.springboot.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import it.objectmethod.springboot.dto.CountryDTO;
import it.objectmethod.springboot.model.Country;
import it.objectmethod.springboot.repository.CountryRepository;

public class CountryMapper extends Mapper<Country, CountryDTO> {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country toEntity(CountryDTO dto) {
		Country country = null;
		if (dto != null) {
			if (dto.getId() != null) {
				country = countryRepository.findOne(dto.getId());
			} else {
				country = new Country();
			}
			country.setName(dto.getName());
			country.setCode(dto.getCode());
		}
		return country;
	}

	@Override
	public CountryDTO toDto(Country entity) {
		CountryDTO country = null;
		if (entity != null) {
			country = new CountryDTO();
			country.setId(entity.getId());
			country.setName(entity.getName());
			country.setCode(entity.getCode());
		}
		return country;
	}

}
