package com.ecomm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecomm.config.ConfigurationFile;
import ecomm.dao.CategoryDAO;
import ecomm.model.Category;

public class AppTest {

		
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigurationFile.class);
		context.scan("ecomm.model");
		//context.refresh();
		CategoryDAO categoryDAO=context.getBean(CategoryDAO.class);
		Category category=context.getBean(Category.class);
		category.setCategoryName("Abhishek");
		category.setCategoryDes("Good Man");
		categoryDAO.addCategory(category);
		context.close();
	}
}
