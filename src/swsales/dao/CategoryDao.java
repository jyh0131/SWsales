package swsales.dao;

import java.util.List;

import swsales.model.Category;



public interface CategoryDao {
	List<Category> selectCategoryByAll();
}
