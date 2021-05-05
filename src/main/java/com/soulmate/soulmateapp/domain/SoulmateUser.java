package com.soulmate.soulmateapp.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SoulmateUser {
    @Id
    private int id;
    private int age;
    private String name;
    private String gender;


    public SoulmateUser() {
    }

    public SoulmateUser(int id, int age, String name, String gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
