package it.objectmethod.springboot.dto.mapper;

import it.objectmethod.springboot.dto.CountryDTO;
import it.objectmethod.springboot.model.Country;

public class CountryMapper extends Mapper<Country, CountryDTO> {

	@Override
	public Country toEntity(CountryDTO dto) {
		Country country = null;
		if (dto != null) {
			country = new Country();
			country.setId(dto.getId());
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
