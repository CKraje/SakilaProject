package it.objectmethod.sakila.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.sakila.dao.CategoryDao;
import it.objectmethod.sakila.dao.FilmDao;
import it.objectmethod.sakila.domain.Category;
import it.objectmethod.sakila.domain.Film;

@Controller
public class FilmController {
	@Autowired
	FilmDao filmDao;
	@Autowired
	CategoryDao categoryDao;
	@RequestMapping("categories-films")

	public String getFilmsByCategory(ModelMap map, @RequestParam("Genres")int id,
			HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("categoryId", id);
		Category category = categoryDao.getCategoryById(id);
		List<Film> listFilms= filmDao.getFilmsByCategory(category);
		map.addAttribute("listaFilms", listFilms);
		return "forward:/categories";
	}
	@RequestMapping("actors-films")
	public String getFilmsByActor (ModelMap map,@RequestParam("actorId")int id) {
		List<Film> filmList = filmDao.getFilmsByActor(id);
		map.addAttribute("listaFilms", filmList);
		return "films-actors";
	}
	
	@RequestMapping("search-films")
	public String getFilmsByName (ModelMap map,@RequestParam("film_Name")String filmName) {
		List<Film> filmList = filmDao.getFilmsByName(filmName);
		map.addAttribute("listaFilms", filmList);
		return "films-actors";
	}
}
