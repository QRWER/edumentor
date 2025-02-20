package com.spring.edumentor.controller;

import com.spring.edumentor.dao.MentorDAO;
import com.spring.edumentor.entity.Mentor;
import com.spring.edumentor.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class RESTController {

    @Autowired
    private MyService<Mentor> service;

    @GetMapping("/mentors")
    public List<Mentor> showAllMentor(){
        return service.getAll();
    }
}
