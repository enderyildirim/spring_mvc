package com.example.spring.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Customer c) {
        currentSession().save(c);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> list() {
        return currentSession().createQuery("FROM Customer").getResultList();
    }

}
