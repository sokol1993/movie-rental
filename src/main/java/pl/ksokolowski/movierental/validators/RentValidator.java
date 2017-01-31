package pl.ksokolowski.movierental.validators;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.ksokolowski.movierental.domain.ProducitonYear;
import pl.ksokolowski.movierental.domain.Rent;

public class RentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Rent.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

	public void validate(Rent rent, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "returnDate", "error.field.required");
	}
}

