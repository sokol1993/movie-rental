package pl.ksokolowski.movierental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ksokolowski.movierental.dao.UserDAO;
import pl.ksokolowski.movierental.domain.User;
import pl.ksokolowski.movierental.domain.UserRole;
import pl.ksokolowski.movierental.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Transactional
	public void addUser(User user) {
		user.getUserRole().add(userDAO.findRoleByName("ROLE_USER"));
		user.setPassword(hashPassword(user.getPassword()));
		userDAO.addUser(user);
	}
	
	@Transactional
	public void editUser(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		userDAO.editUser(user);
	}

	@Transactional
	@Override
	public List<User> listUser() {
		return userDAO.listUser();
	}

	@Transactional
	@Override
	public void removeUser(int id) {
		userDAO.removeUser(id);
	}

	@Transactional
	@Override
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Transactional
	public String hashPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

	@Transactional
	public void addUserRole(UserRole userRole) {
		userDAO.addRole(userRole);
	}

	@Transactional
	public List<UserRole> listUserRole() {
		return userDAO.listUserRole();
	}

	@Transactional
	public void removeUserRole(int id) {
		userDAO.removeUserRole(id);
	}

	@Transactional
	public UserRole getUserRole(int id) {
		return userDAO.getUserRole(id);
	}
	
	@Transactional
	public boolean userExist(User user){
		return userDAO.findByLogin(user.getLogin())!=null;
	}
	@Transactional
	public User getUserByLogin(String login){
		return userDAO.findByLogin(login);
	}
}