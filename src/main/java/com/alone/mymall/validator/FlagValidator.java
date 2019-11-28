package com.alone.mymall.validator;

import org.springframework.stereotype.Controller;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
    String[] value() default {};
    String message() default "flag is not fount";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
