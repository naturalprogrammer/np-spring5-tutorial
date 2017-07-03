package com.naturalprogrammer.spring5tutorial.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Constraint(validatedBy=UniqueEmailValidator.class)
@NotBlank(message="{blankEmail}")
@Email
@Size(min=4, max=250, message="{emailSizeError}")
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueEmail {

    String message() default "{duplicateEmail}";

    Class[] groups() default {};
    
    Class[] payload() default {};
}
