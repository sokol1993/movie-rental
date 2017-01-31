package pl.ksokolowski.movierental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ksokolowski.movierental.dao.CountryOfProductionDAO;
import pl.ksokolowski.movierental.domain.CountryOfProduction;
import pl.ksokolowski.movierental.service.CountryOfProductionService;

@Service
public class CountryOfProductionServiceImpl implements CountryOfProductionService {

	@Autowired
	CountryOfProductionDAO countryDAO;

	@Transactional
	@Override
	public void addCountry(CountryOfProduction country) {
		countryDAO.addCountry(country);

	}

	@Transactional
	@Override
	public List<CountryOfProduction> listCountry() {
		return countryDAO.listCountry();
	}

	@Transactional
	@Override
	public CountryOfProduction getCountry(int id) {
		return countryDAO.getCountry(id);
	}

	@Transactional
	@Override
	public void editCountry(CountryOfProduction country) {
		countryDAO.editCountry(country);
	}

}
