package pl.ksokolowski.movierental.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.ksokolowski.movierental.dao.DirectorDAO;
import pl.ksokolowski.movierental.domain.Director;
import pl.ksokolowski.movierental.domain.User;

@Repository
public class DirectorDAOImpl implements DirectorDAO{

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public void addDirector(Director director) {
		sessionFactory.getCurrentSession().save(director);
	}

	@Override
	public List<Director> listDirector() {
		return sessionFactory.getCurrentSession().createQuery("from Director order by id").list();
	}

	@Override
	public Director getDirector(int id) {
		return (Director) sessionFactory.getCurrentSession().get(Director.class, id);
	}

	@Override
	public void editDirector(Director director) {
		sessionFactory.getCurrentSession().update(director);
	}

}
