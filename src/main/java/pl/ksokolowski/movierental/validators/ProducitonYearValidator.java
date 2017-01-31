package pl.ksokolowski.movierental.validators;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.ksokolowski.movierental.domain.Movie;
import pl.ksokolowski.movierental.domain.ProducitonYear;

public class ProducitonYearValidator implements Validator{

	private static String digitsRegex = "\\d{4}";
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ProducitonYear.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

	public void validate(ProducitonYear year, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "year", "error.field.required");
		
		if (errors.getErrorCount() == 0) {
			if (StringUtils.hasText(year.getYear()) && (validateDigits(year.getYear()) == false)) {
				errors.rejectValue("year", "error.year");
			}
		}
	}
	
	public boolean validateDigits(String digits){
		return digits.matches(digitsRegex);
	}
}
