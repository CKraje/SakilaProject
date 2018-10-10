package it.objectmethod.sakila.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.sakila.dao.FilmDao;
import it.objectmethod.sakila.domain.Category;
import it.objectmethod.sakila.domain.Film;

public class FilmDaoImpl extends NamedParameterJdbcDaoSupport implements FilmDao{

	private final String GET_FILMS_BY_CATEGORY= "SELECT * FROM  film  as f" + 
			"			JOIN film_category ON film_category.film_id= f.film_id " + 
			"			JOIN category as c  ON film_category.category_id=c.category_id " + 
			"			WHERE c.name= :genere";

	private String GET_FILMS_BY_ACTOR = "  SELECT f.film_id, f.title,f.description,f.release_year, e.first_name, e.last_name "
			+ "FROM film AS f " + 
			"  JOIN film_actor AS d ON d.film_id=f.film_id" + 
			"  JOIN actor as e ON e.actor_id=d.actor_id "+
			"WHERE e.actor_id= :idAttore";
	
	private String GET_FILMS_BY_NAME = "SELECT * FROM film WHERE Title LIKE :name";
	
	public List<Film> getFilmsByCategory(Category category) {
		List<Film> listFilms=null;
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("genere", category.getName());
		BeanPropertyRowMapper<Film> rm = new BeanPropertyRowMapper<>(Film.class);
		listFilms= getNamedParameterJdbcTemplate().query(GET_FILMS_BY_CATEGORY,map, rm);
		return listFilms;
	}

	@Override
	public List<Film> getFilmsByActor(int idActor) {
		List<Film> listFilms=null;
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("idAttore", idActor);
		BeanPropertyRowMapper<Film> rm = new BeanPropertyRowMapper<>(Film.class);
		listFilms= getNamedParameterJdbcTemplate().query(GET_FILMS_BY_ACTOR,map, rm);
		return listFilms;
	}

	@Override
	public List<Film> getFilmsByName(String name) {
		List<Film> listFilms=null;
		if(!(name.equals(""))) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("name", name+"%");
		BeanPropertyRowMapper<Film> rm = new BeanPropertyRowMapper<>(Film.class);
		listFilms= getNamedParameterJdbcTemplate().query(GET_FILMS_BY_NAME,map, rm);
		}
		return listFilms;
	}
}
