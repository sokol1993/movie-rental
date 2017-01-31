package pl.ksokolowski.movierental.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.ksokolowski.movierental.domain.Genre;
import pl.ksokolowski.movierental.service.GenreService;

public class GenreConverter implements Converter<String, Genre> {

	@Autowired
	GenreService genreService;
	
	@Override
	public Genre convert(String source) {
		// TODO Auto-generated method stub
		return genreService.getGenre(Integer.parseInt(source));
	}

}
