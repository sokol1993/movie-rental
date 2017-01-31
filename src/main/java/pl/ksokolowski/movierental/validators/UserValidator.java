package pl.ksokolowski.movierental.validators;

import java.util.Date;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.ksokolowski.movierental.domain.User;

public class UserValidator implements Validator {

	private static String loginRegex = "[a-zA-Z]*";
	private static String digitsRegex = ".*\\p{Digit}.*";
	private static String specialCharactersRegex = ".*[!£$#%^&*@?<>+_].*";
	private static String telephoneRegex = "[+]\\d{2}-\\d{3}-\\d{3}-\\d{3}";

	EmailValidator emailValidator = EmailValidator.getInstance();

	@Override
	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
	}

	public void validate(User user, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "telephone", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "dateOfBirth", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "street", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "streetNumber", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "city", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "login", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");

		
		if (errors.getErrorCount() == 0) {
			if (StringUtils.hasText(user.getEmail()) && emailValidator.isValid(user.getEmail()) == false) {
				errors.rejectValue("email", "error.email.invalid");
			}
			if (StringUtils.hasText(user.getTelephone()) && (validateTelephone(user.getTelephone()) == false)) {
				errors.rejectValue("telephone", "error.telephone");
			}
			
			if (StringUtils.hasText(user.getStreetNumber()) && (validateDigits(user.getStreetNumber()) == false)) {
				errors.rejectValue("streetNumber", "error.streetNumber");
			}
			if (StringUtils.hasText(user.getHomeNumber()) && (validateDigits(user.getHomeNumber()) == false)) {
				errors.rejectValue("homeNumber", "error.homeNumber");
			}
		}
	}
	
	public boolean validateTelephone(String telephone) {
		return telephone.matches(telephoneRegex);
	}
	
	public boolean validateDigits(String digits){
		return digits.matches(digitsRegex);
	}
}
