package pl.ksokolowski.movierental.service;

import java.util.List;

import pl.ksokolowski.movierental.domain.CountryOfProduction;

public interface CountryOfProductionService {
	public void addCountry(CountryOfProduction country);
	public List<CountryOfProduction> listCountry();
	public CountryOfProduction getCountry(int id);
	public void editCountry(CountryOfProduction country);
}
