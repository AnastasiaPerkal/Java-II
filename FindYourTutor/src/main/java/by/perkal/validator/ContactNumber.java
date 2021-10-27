package by.perkal.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ContactNumber {
    String message() default "{ContactNumber}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
