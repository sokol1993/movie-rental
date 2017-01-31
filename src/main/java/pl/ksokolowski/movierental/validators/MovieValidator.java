package pl.ksokolowski.movierental.validators;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.ksokolowski.movierental.domain.Genre;
import pl.ksokolowski.movierental.domain.Movie;

public class MovieValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Movie.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

	public void validate(Movie movie, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "genre", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "ageCategory", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "countryOfProduction", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "producitonYear", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "director", "error.field.required");
		if(-1==(movie.getGenre().getId())){
			 errors.rejectValue("genre", "error.field.required");
		}
		if(-1==(movie.getAgeCategory().getId())){
			 errors.rejectValue("ageCategory", "error.field.required");
		}
		if(-1==(movie.getCountryOfProduction().getId())){
			 errors.rejectValue("countryOfProduction", "error.field.required");
		}
		if(-1==(movie.getProducitonYear().getId())){
			 errors.rejectValue("producitonYear", "error.field.required");
		}
		if(-1==(movie.getDirector().getId())){
			 errors.rejectValue("director", "error.field.required");
		}
	}
}
