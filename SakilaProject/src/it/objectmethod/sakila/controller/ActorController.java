package it.objectmethod.sakila.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.sakila.dao.ActorDao;
import it.objectmethod.sakila.dao.FilmDao;
import it.objectmethod.sakila.domain.Actor;

@Controller
public class ActorController {

	@Autowired
	ActorDao actorDao;

	@Autowired
	FilmDao filmDao;

	@RequestMapping("films-actors")
	public String getActorsByFilm(ModelMap map,@RequestParam("filmId")int idFilm) {
		List<Actor> actorList = actorDao.getActorsByFilm(idFilm);
		map.addAttribute("actorList", actorList);
		return "forward:/categories";
	}

	@RequestMapping("actors-search")
	public String getActorByLastName(ModelMap map,@RequestParam("actorLastName")String actorLastName
			) {
		List<Actor> actorList = actorDao.getActorsByLastName(actorLastName);
		map.addAttribute("actorList", actorList);
		return "films-actors";
	}
}
