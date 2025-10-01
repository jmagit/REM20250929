package com.example.contracts.domain.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.entities.Actor;
import com.example.domain.entities.models.ActorDTO;
import com.example.domain.entities.models.ActorShort;

public interface ActoresRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor> {
	List<Actor> findTop10ByFirstNameStartsWithOrderByLastNameDesc(String prefijo);
	List<Actor> findTop10ByFirstNameStartsWith(String prefijo, Sort orderBy);
	
	List<Actor> findByActorIdGreaterThan(int id);
	@Query(value = "FROM Actor a WHERE a.actorId > ?1")
	List<Actor> findNuevosJPQL(int id);
	@Query(value = "SELECT * FROM actor a WHERE a.actor_id > :id", nativeQuery = true)
	List<Actor> findNuevosSQL(int id);

	List<ActorDTO> readByActorIdGreaterThan(int id);
	List<ActorShort> queryByActorIdGreaterThan(int id);
	<T> List<T> searchByActorIdGreaterThan(int id, Class<T> tipo);

}
