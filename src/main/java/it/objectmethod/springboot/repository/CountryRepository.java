package it.objectmethod.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.springboot.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	public Country findTopByOrderByIdDesc();
}
