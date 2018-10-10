package it.objectmethod.sakila.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.sakila.dao.CategoryDao;
import it.objectmethod.sakila.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;

	@RequestMapping("/categories")
	public String getAllCategories(HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<Category> listcategoriesFilms= categoryDao.getAllCategories();
		session.setAttribute("listaCategoriesFilms", listcategoriesFilms);
		return "films-actors";
	}
}
