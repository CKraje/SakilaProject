package it.objectmethod.sakila.dao;

import java.util.List;

import it.objectmethod.sakila.domain.Category;

public interface CategoryDao {

		public List<Category> getAllCategories();
		public Category getCategoryById(int id);
		//public List<Integer> getAllCategoriesId() ;
}
