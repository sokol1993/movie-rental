package pl.ksokolowski.movierental.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.ksokolowski.movierental.domain.ProducitonYear;
import pl.ksokolowski.movierental.service.ProducitonYearService;

public class ProducitonYearConverter implements Converter<String, ProducitonYear>{

	@Autowired
	ProducitonYearService producitonYearService;
	
	@Override
	public ProducitonYear convert(String source) {
		// TODO Auto-generated method stub
		return producitonYearService.getYear(Integer.parseInt(source));
	}

}
