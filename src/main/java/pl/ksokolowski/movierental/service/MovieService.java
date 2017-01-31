package pl.ksokolowski.movierental.service;

import java.util.List;

import pl.ksokolowski.movierental.domain.Movie;

public interface MovieService {
	public void addMovie (Movie movie);
	public List<Movie> listMovie();
	public void removeMovie (int id);
	public Movie getMovie(int id);
	public void editMovie(Movie movie);
}
