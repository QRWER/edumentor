package com.spring.edumentor.dao;

import com.spring.edumentor.entity.Mentor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MentorDAO implements DAO<Mentor>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Mentor> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Mentor", Mentor.class).getResultList();
    }

    @Override
    public Mentor getById(int id) {
        return null;
    }

    @Override
    public Mentor save(Mentor obj) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
