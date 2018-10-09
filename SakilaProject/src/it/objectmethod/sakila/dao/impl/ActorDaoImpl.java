package it.objectmethod.sakila.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.sakila.dao.ActorDao;
import it.objectmethod.sakila.domain.Actor;

public class ActorDaoImpl extends NamedParameterJdbcDaoSupport implements ActorDao{

	private final String GET_ACTORS_BY_FILM = "SELECT f.title, f.release_year, c.name,e.first_name,e.last_name,"
			+ "e.actor_id "
			+ "FROM  film  as f " + 
			"JOIN film_category ON film_category.film_id= f.film_id" + 
			" JOIN category as c  ON film_category.category_id=c.category_id" + 
			" JOIN film_actor as d ON d.film_id=f.film_id" + 
			" JOIN actor as e ON d.actor_id=e.actor_id" + 
			" WHERE f.film_id= :idFilm";
	
	private final String GET_ACTOR_BY_ACTOR_ID="SELECT * FROM actor WHERE actor_id= :actorId";
	private final String GET_ACTORS_BY_LAST_NAME = "SELECT * FROM actor "
			+ "WHERE actor.last_name LIKE :lastName";
	
	@Override
	public List<Actor> getActorsByFilm(int idFilm) {
		List<Actor> actorList=null;
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("idFilm", idFilm);
		BeanPropertyRowMapper<Actor> rm = new BeanPropertyRowMapper<>(Actor.class);
		actorList= getNamedParameterJdbcTemplate().query(GET_ACTORS_BY_FILM,map,rm);
		return actorList;
	}

	@Override
	public Actor getActorByActorId(int actorId) {
		Actor actor = null;
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("actorId",actorId);
		BeanPropertyRowMapper<Actor> rm = new BeanPropertyRowMapper<>(Actor.class);
		actor= (Actor) getNamedParameterJdbcTemplate().query(GET_ACTOR_BY_ACTOR_ID,map,rm);
		return actor;
	}

	@Override
	public List<Actor> getActorsByLastName(String actorLastName) {
		List<Actor> actorList=null;
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("lastName", actorLastName+"%");
		BeanPropertyRowMapper<Actor> rm = new BeanPropertyRowMapper<>(Actor.class);
		actorList=getNamedParameterJdbcTemplate().query(GET_ACTORS_BY_LAST_NAME,map,rm);
		return actorList;
	}

}
