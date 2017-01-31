package pl.ksokolowski.movierental.service;

import java.util.List;

import pl.ksokolowski.movierental.domain.User;
import pl.ksokolowski.movierental.domain.UserRole;

public interface UserService {
	
	public void addUser(User user);
	public List<User> listUser();
	public void removeUser (int id);
	public User getUser(int id);
	public User getUserByLogin(String login);
	public void editUser(User user);
	
	public String hashPassword(String password);
	
	public void addUserRole(UserRole userRole);
	public List<UserRole> listUserRole();
	public void removeUserRole (int id);
	public UserRole getUserRole(int id);
	public boolean userExist(User user);
}
