package pl.ksokolowski.movierental.dao;

import java.util.List;

import pl.ksokolowski.movierental.domain.Director;


public interface DirectorDAO {
	public void addDirector(Director director);
	public List<Director> listDirector();
	public Director getDirector(int id);
	public void editDirector(Director director);
}
