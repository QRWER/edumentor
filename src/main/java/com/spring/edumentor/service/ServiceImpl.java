package com.spring.edumentor.service;

import com.spring.edumentor.dao.MentorDAO;
import com.spring.edumentor.entity.Mentor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements MyService<Mentor> {

    @Autowired
    private MentorDAO mentorDAO;

    @Override
    @Transactional
    public List<Mentor> getAll() {
        return mentorDAO.getAll();
    }

    @Override
    @Transactional
    public Mentor getById(int id) {
        return null;
    }

    @Override
    @Transactional
    public Mentor save(Mentor obj) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {

    }
}
