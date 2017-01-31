package pl.ksokolowski.movierental.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.ksokolowski.movierental.domain.CountryOfProduction;
import pl.ksokolowski.movierental.domain.Director;

public class DirectorValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Director.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

	public void validate(Director director, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.field.required");
	}
}
