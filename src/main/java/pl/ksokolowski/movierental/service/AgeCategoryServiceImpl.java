package pl.ksokolowski.movierental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ksokolowski.movierental.dao.AgeCategoryDAO;
import pl.ksokolowski.movierental.domain.AgeCategory;


@Service
public class AgeCategoryServiceImpl implements AgeCategoryService{

	@Autowired
	AgeCategoryDAO ageCategoryDAO;
	
	
	@Override
	@Transactional
	public void addAgeCategory(AgeCategory age) {
		ageCategoryDAO.addAgeCategory(age);
	}
	
	@Override
	@Transactional
	public List<AgeCategory> listAgeCategory() {
		return ageCategoryDAO.listAgeCategory();
	}
	
	@Override
	@Transactional
	public AgeCategory getAgeCategory(int id) {
		return ageCategoryDAO.getAgeCategory(id);
	}
	
	@Override
	@Transactional
	public void editAgeCategory(AgeCategory age) {
		ageCategoryDAO.editAgeCategory(age);
	}

}
