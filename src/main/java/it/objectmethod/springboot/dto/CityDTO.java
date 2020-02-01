package it.objectmethod.springboot.dto;

public class CityDTO {

	private Long id;
	private String name;
	private Long population;
	private Long countryId;

	public CityDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "{ id:" + id + ", name:\"" + name + "\", population:" + population + ", countryId:" + countryId + " }";
	}
}
