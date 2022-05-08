package com.project.gym.management.system.Models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String traineeName;
    private String bio;
//    private Date dob;
//    private Date subscriptionStart;
//    private Date endOFSubscription;
    private String email;



    @ManyToMany( fetch = FetchType.LAZY,
                 cascade  = {CascadeType.PERSIST,
                             CascadeType.MERGE,
                             CascadeType.REFRESH,
                             CascadeType.DETACH})
    @JoinTable(
            name = "session_trainee",
            joinColumns = @JoinColumn(name = "trainee_id"),
            inverseJoinColumns = @JoinColumn(name = "session_id")
    )

    private List <Session> sessions;



    public Trainee() {
    }

    public Trainee(String traineeName, String bio, String email) {
        this.traineeName = traineeName;
        this.bio = bio;
//        this.dob = dob;
//        this.subscriptionStart = subscriptionStart;
//        this.endOFSubscription = endOFSubscription;
        this.email = email;
//        this.sessions = sessions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trainee(int id , String traineeName, String bio, String email) {
        this.id = id;
        this.traineeName = traineeName;
        this.bio = bio;
//        this.subscriptionStart = subscriptionStart;
//        this.endOFSubscription = endOFSubscription;
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

//    public Date getDob() {
//        return dob;
//    }
//
//    public void setDob(Date dob) {
//        this.dob = dob;
//    }

//    public Date getSubscriptionStart() {
//        return subscriptionStart;
//    }
//
//    public void setSubscriptionStart(Date subscriptionStart) {
//        this.subscriptionStart = subscriptionStart;
//    }
//
//    public Date getEndOFSubscription() {
//        return endOFSubscription;
//    }
//
//    public void setEndOFSubscription(Date endOFSubscription) {
//        this.endOFSubscription = endOFSubscription;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
//    public List<Trainer> getTrainers() {
//        return trainers;
//    }

//    public void setTrainers(List<Trainer> trainers) {
//        this.trainers = trainers;
//    }
}
