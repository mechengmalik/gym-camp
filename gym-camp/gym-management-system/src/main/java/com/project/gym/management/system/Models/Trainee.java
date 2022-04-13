package com.project.gym.management.system.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String traineeName;
    private String bio;
    private Date dob;
    private Date subscriptionStart;
    private Date endOFSubscription;
    private String email;

    @JoinColumn(name = "trainer_id")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Trainer> trainers;

    @JoinColumn(name = "session_id")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Session> sessions;

    public Trainee() {
    }

    public Trainee(String traineeName, String bio, Date dob, Date subscriptionStart, Date endOFSubscription, String email, List<Session> sessions) {
        this.traineeName = traineeName;
        this.bio = bio;
        this.dob = dob;
        this.subscriptionStart = subscriptionStart;
        this.endOFSubscription = endOFSubscription;
        this.email = email;
        this.sessions = sessions;
    }

    public Trainee(int id ,String traineeName, String bio, Date dob, Date subscriptionStart, Date endOFSubscription, String email) {
        this.id = id;
        this.traineeName = traineeName;
        this.bio = bio;
        this.dob = dob;
        this.subscriptionStart = subscriptionStart;
        this.endOFSubscription = endOFSubscription;
        this.email = email;

    }

    public Trainee(String traineeName, String bio, Date dob, Date subscriptionStart, Date endOFSubscription, String email) {
        this.traineeName = traineeName;
        this.bio = bio;
        this.dob = dob;
        this.subscriptionStart = subscriptionStart;
        this.endOFSubscription = endOFSubscription;
        this.email = email;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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
