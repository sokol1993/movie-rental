package pl.ksokolowski.movierental.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.ksokolowski.movierental.domain.Director;
import pl.ksokolowski.movierental.domain.Genre;

public class GenreValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Genre.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

	public void validate(Genre genre, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "genreName", "error.field.required");

	}
}
