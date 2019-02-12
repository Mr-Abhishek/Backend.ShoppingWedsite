package ecomm.dao;

import java.util.List;

import ecomm.model.User;

public interface UserDAO 
{

	public User getUser(int userId);
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public List<User> listUser();
	
}
