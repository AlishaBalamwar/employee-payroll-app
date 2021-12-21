package com.bridgelabz.employeepayrollapp.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Purpose: This is AOP(Aspect Oriented Programming) class which holds all the logging application
 *
 * @author: ALISHA BALAMWAR
 * @since: 2021-12-20
 */
@Component
@Aspect
public class LoggingAdvice {

    Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

    /**
     * Purpose: This method is created to implement the logging mechanism through out the application
     */
    @Pointcut(value = "execution (* com.bridgelabz.employepayrollapp.*.*.*(..) )")
    public void myPointCut(){
    }

    /**
     * Purpose: This method is created to centralize the logging statement
     * to track the application flow through out the program
     *
     * @param proceedingJoinPoint: It manages the reflection of the program for getting the method details and input
     *                           parameter
     * @return: The JSON format of logger statement before and after the advice
     * @throws Throwable: when there is any exception
     */
    @Around("myPointCut()")
    private Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        ObjectMapper mapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] array = proceedingJoinPoint.getArgs();
        logger.info("Method invoked: " + className + " : " + methodName + "()" + "arguments :"
                + mapper.writeValueAsString(array));
        Object objectAfterProceeding = proceedingJoinPoint.proceed();
        logger.info(className + " : " + methodName + "()" + "Response :" + objectAfterProceeding);
        return  objectAfterProceeding;
    }
}
