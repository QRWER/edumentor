package com.spring.edumentor.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "solution")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "time_end")
    private Timestamp timeEnd;

    public Solution() {
    }

    public Solution(byte[] photo, Timestamp timeEnd) {
        this.photo = photo;
        this.timeEnd = timeEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ", photo=" + Arrays.toString(photo) +
                ", timeEnd=" + timeEnd +
                '}';
    }
}
