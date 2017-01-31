package pl.ksokolowski.movierental.service;

import java.util.List;

import pl.ksokolowski.movierental.domain.Genre;

public interface GenreService {
	public void addGenre(Genre genre);
	public List<Genre> listGenre();
	public Genre getGenre(int id);
	public void editGenre(Genre genre);
}
