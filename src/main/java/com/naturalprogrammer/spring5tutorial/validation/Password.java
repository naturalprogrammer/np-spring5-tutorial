package com.naturalprogrammer.spring5tutorial.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Constraint(validatedBy={})
@NotBlank
@Size(min=6, max=32)
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface Password {

    String message() default "{duplicateEmail}";

    Class[] groups() default {};
    
    Class[] payload() default {};
}
