package pl.ksokolowski.movierental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ksokolowski.movierental.dao.GenreDAO;
import pl.ksokolowski.movierental.domain.Genre;
import pl.ksokolowski.movierental.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	GenreDAO genreDAO;

	@Transactional
	@Override
	public void addGenre(Genre genre) {
		genreDAO.addGenre(genre);
	}

	@Transactional
	@Override
	public List<Genre> listGenre() {
		return genreDAO.listGenre();
	}

	@Transactional
	@Override
	public Genre getGenre(int id) {
		return genreDAO.getGenre(id);
	}

	@Transactional
	@Override
	public void editGenre(Genre genre) {
		genreDAO.editGenre(genre);
	}

}
