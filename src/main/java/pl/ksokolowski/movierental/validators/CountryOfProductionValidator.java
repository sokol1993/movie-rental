package pl.ksokolowski.movierental.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.ksokolowski.movierental.domain.AgeCategory;
import pl.ksokolowski.movierental.domain.CountryOfProduction;

public class CountryOfProductionValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return CountryOfProduction.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

	public void validate(CountryOfProduction country, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "country", "error.field.required");
	}
}
