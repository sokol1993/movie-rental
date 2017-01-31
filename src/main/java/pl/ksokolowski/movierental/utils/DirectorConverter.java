package pl.ksokolowski.movierental.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.ksokolowski.movierental.domain.Director;
import pl.ksokolowski.movierental.service.DirectorService;

public class DirectorConverter implements Converter<String, Director>{

	@Autowired
	DirectorService directorService;
	
	@Override
	public Director convert(String source) {
		// TODO Auto-generated method stub
		return directorService.getDirector(Integer.parseInt(source));
	}

}
