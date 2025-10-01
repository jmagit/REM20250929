package com.example.domain.entities.models;

import com.example.domain.entities.Actor;

import lombok.Data;

@Data
public class ActorDTO {
	private int id;
	private String nombre;
	private String apellidos;

	public ActorDTO(int actorId, String firstName, String lastName) {
		super();
		this.id = actorId;
		this.nombre = firstName;
		this.apellidos = lastName;
	}
	
	public static ActorDTO from(Actor item) {
		return new ActorDTO(item.getActorId(), item.getFirstName(), item.getLastName());
	}
	public static Actor from(ActorDTO item) {
		return new Actor(item.getId(), item.getNombre(), item.getApellidos());
	}
	

}
