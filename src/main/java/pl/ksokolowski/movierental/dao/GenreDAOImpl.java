package pl.ksokolowski.movierental.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.ksokolowski.movierental.dao.GenreDAO;
import pl.ksokolowski.movierental.domain.Genre;
import pl.ksokolowski.movierental.domain.User;

@Repository
public class GenreDAOImpl implements GenreDAO{

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public void addGenre(Genre genre) {
		sessionFactory.getCurrentSession().save(genre);
	}

	@Override
	public List<Genre> listGenre() {
		return sessionFactory.getCurrentSession().createQuery("from Genre order by id").list();
	}

	@Override
	public Genre getGenre(int id) {
		return (Genre) sessionFactory.getCurrentSession().get(Genre.class, id);
	}

	@Override
	public void editGenre(Genre genre) {
		sessionFactory.getCurrentSession().update(genre);
	}

}
