package it.objectmethod.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.springboot.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	public Country findTopByOrderByIdDesc();

	public List<Country> findByIdGreaterThanEqual(Long id);

	public List<Country> findByCodeContaining(String code);

	public List<Country> findByNameIsNull();

	public List<Country> findByNameStartingWithOrderById(String name);

	public Country findByCode(String code);

	public List<Country> findByNameEndingWithOrderByCodeDesc(String name);
}
