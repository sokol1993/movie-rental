package pl.ksokolowski.movierental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ksokolowski.movierental.dao.MovieDAO;
import pl.ksokolowski.movierental.domain.Movie;
import pl.ksokolowski.movierental.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDAO movieDAO;

	@Transactional
	@Override
	public void addMovie(Movie movie) {
		movieDAO.addMovie(movie);
	}

	@Transactional
	@Override
	public List<Movie> listMovie() {
		return movieDAO.listMovie();
	}

	@Transactional
	@Override
	public void removeMovie(int id) {
		movieDAO.removeMovie(id);
	}

	@Transactional
	@Override
	public Movie getMovie(int id) {
		return movieDAO.getMovie(id);
	}

	@Transactional
	@Override
	public void editMovie(Movie movie) {
		movieDAO.editMovie(movie);
	}
}
