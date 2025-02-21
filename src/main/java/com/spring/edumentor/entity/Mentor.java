package com.spring.edumentor.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mentor")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "subject")
    private String subject;

    @Column(name = "education")
    private String education;

    @OneToMany(cascade = CascadeType.ALL) //возможно поменять тип каскада
    @JoinColumn(name = "id_mentor")
    private List<Homework> homeworks;

    public Mentor() {
    }

    public Mentor(String fullName, String subject, String education) {
        this.fullName = fullName;
        this.subject = subject;
        this.education = education;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", subject='" + subject + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
