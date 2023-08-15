package com.spring.aopdemo.dao;

import com.spring.aopdemo.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);

    public String getName();

    public AccountDAOImpl setName(String name);

    public String getServiceCode();

    public List<Account> findAccounts();

    public AccountDAOImpl setServiceCode(String serviceCode);
}
