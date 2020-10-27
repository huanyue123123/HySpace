package com.gm.wj.annotations;

import com.gm.wj.enums.MethodLogType;

import java.lang.annotation.*;
import java.util.Date;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String content() default "";
    MethodLogType operType() default MethodLogType.QUERY;


}
