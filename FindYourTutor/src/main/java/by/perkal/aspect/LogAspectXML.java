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
public class LogAspectXML {
    Logger logger=Logger.getLogger(LogAspectXML.class);

    public void showSubjects() {
    }
    public void aroundShowSubjects(JoinPoint jp) {
        logger.info("aroundShowSubjects " + jp.toString());
    }
    public void afterThrowingShowSubjects(JoinPoint jp) {
        logger.info("afterThrowingShowSubjects" + jp.toString());
    }
}
