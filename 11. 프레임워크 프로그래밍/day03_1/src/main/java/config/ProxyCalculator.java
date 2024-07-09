package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//공통 기능이 들어갈 곳엔 @Aspect 애노테이션을 붙여야한다.
@Aspect
public class ProxyCalculator {

    //범위는 exam01 패키지
    @Pointcut("execution(* exam01..*(..))")
    public void publicTarget() {}

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("유입!!");

        Object result = joinPoint.proceed(); //핵심 기능 대신 실행★ -> factorial

        return result;
    }
}
