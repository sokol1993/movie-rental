package pl.ksokolowski.movierental.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.ksokolowski.movierental.domain.AgeCategory;
import pl.ksokolowski.movierental.service.AgeCategoryService;

public class AgeCategoryConverter implements Converter <String, AgeCategory>{

	@Autowired
	AgeCategoryService ageCategoryService;
	
	@Override
	public AgeCategory convert(String source) {
		// TODO Auto-generated method stub
		return ageCategoryService.getAgeCategory(Integer.parseInt(source));
	}

}
