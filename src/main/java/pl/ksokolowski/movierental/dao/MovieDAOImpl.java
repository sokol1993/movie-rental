package pl.ksokolowski.movierental.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.ksokolowski.movierental.dao.MovieDAO;
import pl.ksokolowski.movierental.domain.Movie;
import pl.ksokolowski.movierental.domain.User;

@Repository
public class MovieDAOImpl implements MovieDAO{

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public void addMovie(Movie movie) {
		sessionFactory.getCurrentSession().save(movie);
	}

	@Override
	public List<Movie> listMovie() {
		return sessionFactory.getCurrentSession().createQuery("from Movie order by id").list();
	}

	@Override
	public void removeMovie(int id) {
		Movie movie = (Movie) sessionFactory.getCurrentSession().load(Movie.class, id);
		if (null != movie) {
			sessionFactory.getCurrentSession().delete(movie);
		}
	}

	@Override
	public Movie getMovie(int id) {
		return (Movie) sessionFactory.getCurrentSession().get(Movie.class, id);
	}

	@Override
	public void editMovie(Movie movie) {
		sessionFactory.getCurrentSession().update(movie);
	}
}
