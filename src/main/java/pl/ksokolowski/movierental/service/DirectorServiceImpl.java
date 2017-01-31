package pl.ksokolowski.movierental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ksokolowski.movierental.dao.DirectorDAO;
import pl.ksokolowski.movierental.domain.Director;
import pl.ksokolowski.movierental.service.DirectorService;

@Service
public class DirectorServiceImpl implements DirectorService {
	
	@Autowired
	DirectorDAO directorDAO;
	
	@Transactional
	@Override
	public void addDirector(Director director) {
		directorDAO.addDirector(director);
	}

	@Transactional
	@Override
	public List<Director> listDirector() {
		return directorDAO.listDirector();
	}

	@Transactional
	@Override
	public Director getDirector(int id) {
		return directorDAO.getDirector(id);
	}

	@Transactional
	@Override
	public void editDirector(Director director) {
directorDAO.editDirector(director);
	}

}
