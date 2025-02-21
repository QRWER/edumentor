package com.spring.edumentor.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "id_mentor")
    private int idMentor;

    @Column(name = "id_student")
    private int idStudent;

    @Column(name = "task")
    private byte[] task;

    @Column(name = "id_solution")
    private int idSolution;

    @Column(name = "review")
    private String review;

    @Column(name = "timeStart")
    private Timestamp timeStart;

    @ManyToMany(cascade = CascadeType.ALL ) //изменить тип каскада
    @JoinTable(
            name = "homework",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_student")
    )
    private List<Student> students;

    public Homework() {
    }

    public Homework(int idMentor, int idStudent, byte[] task, int idSolution,
                    String review, Timestamp timeStart) {
        this.idMentor = idMentor;
        this.idStudent = idStudent;
        this.task = task;
        this.idSolution = idSolution;
        this.review = review;
        this.timeStart = timeStart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public byte[] getTask() {
        return task;
    }

    public void setTask(byte[] task) {
        this.task = task;
    }

    public int getIdSolution() {
        return idSolution;
    }

    public void setIdSolution(int idSolution) {
        this.idSolution = idSolution;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", idMentor=" + idMentor +
                ", idStudent=" + idStudent +
                ", task=" + Arrays.toString(task) +
                ", idSolution=" + idSolution +
                ", review='" + review + '\'' +
                ", timeStart=" + timeStart +
                '}';
    }
}
