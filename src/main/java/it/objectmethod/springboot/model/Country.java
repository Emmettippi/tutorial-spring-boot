package it.objectmethod.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@Column(name = "idcountry", insertable = true, updatable = true, unique = true, nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	public Country() {

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
