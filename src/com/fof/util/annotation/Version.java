package com.fof.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
public @interface Version {
    String ver();

    int ver_int();
}
