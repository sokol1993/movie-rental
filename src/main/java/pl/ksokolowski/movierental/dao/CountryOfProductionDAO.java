package pl.ksokolowski.movierental.dao;

import java.util.List;

import pl.ksokolowski.movierental.domain.CountryOfProduction;

public interface CountryOfProductionDAO {
	public void addCountry(CountryOfProduction country);
	public List<CountryOfProduction> listCountry();
	public CountryOfProduction getCountry(int id);
	public void editCountry(CountryOfProduction country);
}
