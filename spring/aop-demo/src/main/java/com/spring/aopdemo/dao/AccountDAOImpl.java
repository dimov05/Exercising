package com.spring.aopdemo.dao;

import com.spring.aopdemo.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    public String getName() {
        System.out.println(getClass() + " is called");
        return name;
    }

    public AccountDAOImpl setName(String name) {
        System.out.println(getClass() + " is called");

        this.name = name;
        return this;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " is called");

        return serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account("Dimo", "Gold");
        Account account2 = new Account("Petyo", "Plat");
        Account account3 = new Account("Ivan", "Silver");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }

    public AccountDAOImpl setServiceCode(String serviceCode) {
        System.out.println(getClass() + " is called");

        this.serviceCode = serviceCode;
        return this;
    }
}
