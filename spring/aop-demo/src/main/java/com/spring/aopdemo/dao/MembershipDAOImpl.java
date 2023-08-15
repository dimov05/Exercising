package com.spring.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass()
                + " : DOING MY DB WORK: ADDING AN MEMBERSHIP");
    }

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass()
        + " : DOING MY DB WORK: ADDING SILLY MEMBER");
        return true;
    }
}
