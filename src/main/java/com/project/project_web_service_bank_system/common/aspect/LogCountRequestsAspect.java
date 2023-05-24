package com.project.project_web_service_bank_system.common.aspect;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
Аспект, логирует время выполнения метода на которого будет повешена аннотация, указанная в @Around
 */

@Aspect
@Log4j2
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LogCountRequestsAspect {

    @NonFinal
    int count;

    @Around("@annotation(com.project.project_web_service_bank_system.common.annotation.LogCountRequests)")
    public Object count(ProceedingJoinPoint point) throws Throwable {
        String nameMethod = String.format("%s.%s",
                point.getStaticPart().getSignature().getDeclaringType().getName(),
                point.getSignature().getName()
        );

        try {
            return point.proceed(point.getArgs());
        }
        finally {
            count++;
            log.info("This method is called {}. Current requests: {}", nameMethod, count);
        }
    }
}
