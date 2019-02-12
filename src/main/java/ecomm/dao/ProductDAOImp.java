package ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ecomm.model.Product;

public class ProductDAOImp implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, productId);
		session.close();
		return product;
	}

	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteProduct(Product product) 
	{
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		}

	public boolean updateProduct(Product product) 
	{
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public List<Product> listProduct() 
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Product>listproduct=session.createQuery("from Product").list();
		session.close();
		return listproduct;
	}

}
