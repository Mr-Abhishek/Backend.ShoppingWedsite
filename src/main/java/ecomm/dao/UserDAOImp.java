package ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ecomm.model.User;

public class UserDAOImp implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public User getUser(int userId) 
	{
		Session session=sessionFactory.openSession();
		User user=session.get(User.class, userId);
		session.close();
		return user;
	}

	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(User user) 
	{
		try {
		sessionFactory.getCurrentSession().delete(user);
		return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) 
	{
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public List<User> listUser() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings({"unchecked" })
		List<User>listuser=session.createQuery("from User").list();
		session.close();
		return listuser;
	}

}
