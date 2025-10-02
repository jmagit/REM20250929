package com.example.contracts.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.core.contracts.domain.repositories.ProjectionsAndSpecificationJpaRepository;
import com.example.domain.entities.Film;
import com.example.domain.entities.models.PeliCorta;

public interface PeliculasRepository extends JpaRepository<Film, Integer> {
	@RestResource(path = "por-duracion")
	List<Film> findByLengthLessThan(int maximo);
}
