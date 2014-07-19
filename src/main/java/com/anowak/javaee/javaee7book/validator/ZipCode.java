/*
 * Copyright (c) 2014 by Alexander Nowak
 * To be used only with permission.
 */
package com.anowak.javaee.javaee7book.validator;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Alexander Nowak
 */
@Constraint(validatedBy = ZipCodeValidator.class)
@Target({METHOD,FIELD,ANNOTATION_TYPE,CONSTRUCTOR,PARAMETER})
@Retention(RUNTIME)
public @interface ZipCode {
    String message() default "{com.anowak.javaee.javaee7book.ZipCode.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    @Target({METHOD,FIELD,ANNOTATION_TYPE,CONSTRUCTOR,PARAMETER})
    @Retention(RUNTIME)
    @interface List {
	ZipCode[] value();
    }

    

}
