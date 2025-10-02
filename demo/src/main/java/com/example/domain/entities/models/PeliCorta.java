package com.example.domain.entities.models;

import org.springframework.data.rest.core.config.Projection;

import com.example.domain.entities.Film;

@Projection(name = "peli", types = {Film.class})
public interface PeliCorta {
	int getFilmId();
	String getTitle();
}
