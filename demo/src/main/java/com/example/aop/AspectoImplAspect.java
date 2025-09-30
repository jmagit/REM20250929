package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectoImplAspect {
	@Pointcut("execution(public * com.example.ioc..*.*(..))")
	public void miPuntoDeCorte() {}

//	@Before("miPuntoDeCorte()")
//	public void consejoAntesDelMetodo(JoinPoint jp) {
//		System.out.println(">>> Soy un consejo antesDelMetodo " + jp.getSignature());
//	}
	
//	@After("miPuntoDeCorte()")
//	public void consejoDespuesDelMetodo(JoinPoint jp) {
//		System.out.println(">>> Soy un consejo despuesDelMetodo " + jp.getSignature());
//	}

//	@AfterReturning(pointcut="execution(int com.example.ioc..*.get*(..))",	returning="retVal")
//	public void consejoDespuesDeGetPropiedad(JoinPoint jp, int retVal) {
//		System.out.println(">>> La funcion '" + jp.getSignature() + "' ha devuelto " + retVal);
//	}

//	@Around("miPuntoDeCorte()")
//	public Object consejoQueEnvuelveAlMetodo(ProceedingJoinPoint jp) throws Throwable {
//		System.out.println(">>> Soy el previo queEnvuelveAlMetodo " + jp.getSignature());
//		var o = jp.proceed();
//		System.out.println(">>> Soy el posterior queEnvuelveAlMetodo " + jp.getSignature());
//		return o;
//	}

}
