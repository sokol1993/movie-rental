package pl.ksokolowski.movierental.validators;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.ksokolowski.movierental.domain.AgeCategory;
import pl.ksokolowski.movierental.domain.User;

public class AgeCategoryValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return AgeCategory.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

	public void validate(AgeCategory age, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "age", "error.field.required");
	}
}
