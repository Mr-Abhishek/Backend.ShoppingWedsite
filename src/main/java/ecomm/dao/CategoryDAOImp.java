package ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ecomm.model.Category;
@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImp implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			System.out.println("Done!!");
			return true;
		}catch(Exception e) 
		{
			System.out.println("Not Done");
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public Category getCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryId);
		session.close();
		return category;
	}

	public List<Category> listCategories() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Category> listcategory=(List<Category>)session.createQuery("from Category").list();
		session.close();
		return listcategory;
	}

}
