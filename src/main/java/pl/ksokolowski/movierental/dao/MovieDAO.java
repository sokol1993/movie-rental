package pl.ksokolowski.movierental.dao;

import java.util.List;

import pl.ksokolowski.movierental.domain.Movie;
import pl.ksokolowski.movierental.domain.User;

public interface MovieDAO {

	public void addMovie (Movie movie);
	public List<Movie> listMovie();
	public void removeMovie (int id);
	public Movie getMovie(int id);
	public void editMovie(Movie movie);
}
