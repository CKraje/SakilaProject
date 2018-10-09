package it.objectmethod.sakila.dao;

import java.util.List;

import it.objectmethod.sakila.domain.Actor;

public interface ActorDao {

		public List<Actor> getActorsByFilm(int idFilm);
		public Actor getActorByActorId(int actorId);
		public List<Actor> getActorsByLastName(String actorLastName);
}
