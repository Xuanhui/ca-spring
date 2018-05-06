package sa45.t6.sims.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.validator.RegexValidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sa45.t6.sims.model.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);

	}

	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static boolean IsAlphabet(String str) {
		String regex = "^[a-zA-Z\\s]{1,16}$";
		return match(regex, str);
	}

	public static boolean IsPhonenumber(String str) {
		String regex = "^[0-9]{8,8}$";
		return match(regex, str);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer u = (Customer) target;
		// ValidationUtils.rejectIfEmpty(errors, "userId", "error.user.userid.empty");
		// ValidationUtils.rejectIfEmpty(errors, "employeeId",
		// "error.user.employeeid.empty");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name",
		// "Course name is required.");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nick", "error.nick", "From
		// Date is required.");

		ValidationUtils.rejectIfEmpty(errors, "name", "error.user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.user.password.empty");
		if (u.getLastname() != null) {

			ValidationUtils.rejectIfEmpty(errors, "lastname", "error.user.lastname.empty");
		}

		if (u.getFirstname() != null) {

			ValidationUtils.rejectIfEmpty(errors, "firstname", "error.user.firstname.empty");
		}
		// ValidationUtils.rejectIfEmpty(errors, "lastname",
		// "error.user.lastname.empty");
		// ValidationUtils.rejectIfEmpty(errors, "firstname",
		// "error.user.firstname.empty");
		if (u.getName() != null) {
			if (IsAlphabet(u.getName()) == false) {

				errors.rejectValue("name", "error.dates", "Must be alphabet");

			}
		}

		String phonenumber = String.valueOf(u.getPhonenumber());
		if (u.getPhonenumber() != 0 && phonenumber != "") {
			if (IsPhonenumber(phonenumber) == false) {
				errors.rejectValue("phonenumber", "error.phonenumber", "must be number and 8 digits");
			}
		}
		
		// String phonenumber=String.valueOf(u.getPhonenumber());
		// if (IsPhonenumber(phonenumber)==false) {
		//
		// errors.rejectValue("phonenumber", "error.phonenumber", "must be number and 8
		// digits");
		//
		// }

		System.out.println(u.toString());
	}

}
