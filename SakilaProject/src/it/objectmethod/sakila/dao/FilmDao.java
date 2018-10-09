package it.objectmethod.sakila.dao;

import java.util.List;

import it.objectmethod.sakila.domain.Category;
import it.objectmethod.sakila.domain.Film;

public interface FilmDao {
	public List<Film> getFilmsByCategory(Category category);
	public List<Film> getFilmsByActor(int idActor);
	public List<Film> getFilmsByName(String name);

}
