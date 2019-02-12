package ecomm.dao;

import java.util.List;

import ecomm.model.Category;

public interface CategoryDAO 
{
	boolean addCategory(Category category);
	boolean deleteCategory(Category category);
	boolean updateCategory(Category category);
	Category getCategory(int categoryId);
	List<Category> listCategories();
	
}
