package com.spring.aopdemo.aspect;

import com.spring.aopdemo.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Around("execution(* com.spring.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();

        System.out.println("\n==>> Executing @Around");
        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n==>> Duration = : " + duration / 1000.0 + " seconds");


        return result;
    }


    @After("execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts())")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===>>> Executing after (finaly) on method " + method);
    }

    //    @Before("execution(* add*(com.spring.aopdemo.model.Account,boolean ))")
//    @Before("execution(public void updateAccount())")

    @Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
    private void getter() {
    }

    @Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
    private void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {
    }

    @AfterReturning(
            pointcut = "execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=> Executing @AfterReturning on method " + method);

        System.out.println("\n==>> result is : " + result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n==>> result is : " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account acc : result) {
            acc.setName(acc.getName().toUpperCase());
        }
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n==>> Executing @Before advice on addAccount()");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method:" + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println(account.getName());
                System.out.println(account.getLevel());
            }
        }
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n==>> Performing API analytics");
    }

}
