package by.perkal.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LogAspect {
    Logger logger=Logger.getLogger(LogAspect.class);

    @Pointcut("execution(public * by.perkal.controller.SubjectController.*(..))")
    public void showSubjectsController() {
    }

    @Before("showSubjectsController()")
    public void beforeshowSubjectsController(JoinPoint jp) {
        logger.info("beforeshowSubjectsController " + jp.toString());
    }
    @After("showSubjectsController()")
    public void aftershowSubjectsController(JoinPoint jp) {
        logger.info("beforeshowSubjectsController " + jp.toString());
    }
}
