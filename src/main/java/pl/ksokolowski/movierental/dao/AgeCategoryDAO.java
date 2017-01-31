package pl.ksokolowski.movierental.dao;

import java.util.List;

import pl.ksokolowski.movierental.domain.AgeCategory;





public interface AgeCategoryDAO {
	public void addAgeCategory(AgeCategory age);
	public List<AgeCategory> listAgeCategory();
	public AgeCategory getAgeCategory(int id);
	public void editAgeCategory(AgeCategory age);
}
