package pl.ksokolowski.movierental.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.ksokolowski.movierental.domain.CountryOfProduction;
import pl.ksokolowski.movierental.service.CountryOfProductionService;

public class CountryOfProductionConverter implements Converter<String, CountryOfProduction> {

	@Autowired
	CountryOfProductionService countryOfProductionService;
	
	@Override
	public CountryOfProduction convert(String source) {
		// TODO Auto-generated method stub
		return countryOfProductionService.getCountry(Integer.parseInt(source));
	}

}
