package it.objectmethod.springboot.dto;

import java.util.List;

public class CountryDTO {

	private Long id;
	private String name;
	private String code;

	public CountryDTO() {

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "{ id:" + id + ", name:\"" + name + "\", code:\"" + code + "\" }";
	}
}
