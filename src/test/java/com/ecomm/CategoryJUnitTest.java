package com.ecomm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecomm.dao.CategoryDAO;
import ecomm.model.Category;

public class CategoryJUnitTest {
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void executeFirst() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("ecomm");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("CategoryDAO");
		
	}
	/*@Test
	public void addcategoryUnitTest() {
		Category category=new Category();
		category.setCategoryName("Samsung");
		category.setCategoryDes("This is mobile brand");
		assertTrue("This addcategory", categoryDAO.addCategory(category));
	}*/
	@Ignore
	@Test
	public void updateCategoryUnitTest()
	{
		Category category=categoryDAO.getCategory(1);
		category.setCategoryDes("All Samsung Smart Phone Mobiles");
		
		assertTrue("Problem in Updating the Category",categoryDAO.updateCategory(category));
	}
	@Ignore
	@Test
	public void deletcategoryUnitTest() {
		Category category=categoryDAO.getCategory(5);
		assertTrue("problem in Deleting Category",categoryDAO.deleteCategory(category));
	}
	@Test
	public void listCategoryUnitTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		
		assertTrue("Problem in Listing Category:",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+"\t");
			System.out.print(category.getCategoryName()+"\t");
			System.out.println(category.getCategoryDes());
		}
	}
}
