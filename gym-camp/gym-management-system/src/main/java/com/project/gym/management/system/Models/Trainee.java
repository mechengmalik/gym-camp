package com.project.gym.management.system.Models;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private int age;
    private Date subscriptionStart;
    private Date endOFSubscription;
    private String email;
    @ManyToMany
    private List<Session>  sessions;
    @ManyToMany
    private List<Trainer> trainers;

    public Trainee() {
    }

    public Trainee(String name, String gender, int age, Date subscriptionStart, Date endOFSubscription, String email, List<Session> sessions) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.subscriptionStart = subscriptionStart;
        this.endOFSubscription = endOFSubscription;
        this.email = email;
        this.sessions = sessions;
    }

    public Trainee(String name, String gender, int age, Date subscriptionStart, Date endOFSubscription, String email, List<Session> sessions, List<Trainer> trainers) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.subscriptionStart = subscriptionStart;
        this.endOFSubscription = endOFSubscription;
        this.email = email;
        this.sessions = sessions;
        this.trainers = trainers;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(Date subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    public Date getEndOFSubscription() {
        return endOFSubscription;
    }

    public void setEndOFSubscription(Date endOFSubscription) {
        this.endOFSubscription = endOFSubscription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }
}
