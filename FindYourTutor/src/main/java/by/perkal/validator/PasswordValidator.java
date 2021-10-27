package by.perkal.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public void initialize(Password paramA) {
    }
    @Override
    public boolean isValid(String password, ConstraintValidatorContext ctx) {
        if(password == null){
            return false;
        }
        return password.matches("^(?=.*[0-9])(?=.*[a-z]).{5,500}$");
    }
}