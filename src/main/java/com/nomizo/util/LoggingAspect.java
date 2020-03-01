package com.nomizo.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nomizo.logs.Logging;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    Logging logging;

    @Pointcut(value = "execution(* com.nomizo.*.*.*(..))")
    public void myPointcut(){ }

    @Around("myPointcut()")
    public Object applicationLogger (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] array = proceedingJoinPoint.getArgs();
        logging.logger.info("Method Invoked "
                + className + " : "
                + methodName + " () "
                + "arguments : "
                + objectMapper.writeValueAsString(array));

        //  Enables the code to properly come in as an Array
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        Object object = proceedingJoinPoint.proceed();
        logging.logger.info(className + " : "
                + methodName + " () "
                + "Response : "
                + objectMapper.writeValueAsString(object));

        return object;
     }





}
