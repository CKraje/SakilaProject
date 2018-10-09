package it.objectmethod.sakila.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.sakila.dao.CategoryDao;
import it.objectmethod.sakila.domain.Category;

public class CategoryDaoImpl extends NamedParameterJdbcDaoSupport implements CategoryDao{
	private final String GET_ALL_CATEGORIES="SELECT name,last_update, category_id  FROM category ";
	
	private final String GET_CATEGORY_BY_ID="SELECT *FROM category  "
			+ "WHERE category_id = :valore";
	
	public List<Category> getAllCategories() {
		List<Category> listCategoriesFilms=null;
		BeanPropertyRowMapper<Category> rm = new BeanPropertyRowMapper<>(Category.class);
		listCategoriesFilms= getNamedParameterJdbcTemplate().query(GET_ALL_CATEGORIES, rm);
		return listCategoriesFilms;
	}
	
	public Category getCategoryById(int id) {
		Category category = null;
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("valore", Integer.valueOf(id));
		BeanPropertyRowMapper<Category> rm = new BeanPropertyRowMapper<>(Category.class);
		category = (Category)getNamedParameterJdbcTemplate().queryForObject(GET_CATEGORY_BY_ID,
				map,rm);
		return category;
	}

}
