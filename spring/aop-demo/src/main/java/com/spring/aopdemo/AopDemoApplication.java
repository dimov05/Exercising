package com.spring.aopdemo;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;
import com.spring.aopdemo.model.Account;
import com.spring.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class AopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TrafficFortuneService trafficFortuneService, AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
//            demoTheBeforeAdvice(accountDAO, membershipDAO);
//            demoTheAfterReturningAdvice(accountDAO);
//demoTheAfterAdvice(accountDAO);
        demoTheAroundAdvice(trafficFortuneService);
        };
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) throws InterruptedException {
        System.out.println("\n Main program : demoAroundAdvice");

        System.out.println("Calling getFortune()");
        String data = trafficFortuneService.getFortune();
        System.out.println("\n My fortune is " + data);
        System.out.println("Finished");
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts();
        } catch (Exception exception) {
            System.out.println("\n\nMain program : caught exception" + exception);

        }
        System.out.println("\n\n Main program : demoTheAfterThrowingAdvice");
        System.out.println("----");
        System.out.println(accounts);

        System.out.println("\n");

    }

    public void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("\n\n Main Program : demoTheAfterReturningAdvice()");
        System.out.println("\n------------------");
        System.out.println(accounts);
        System.out.println("\n------------------");
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        Account account = new Account("Ivan", "Beginner");
        accountDAO.addAccount(account, true);

        accountDAO.setName("Foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();


        membershipDAO.addAccount();
    }
}
