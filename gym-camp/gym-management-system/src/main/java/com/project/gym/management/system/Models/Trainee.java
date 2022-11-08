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
    private String gender;
    private int socialNumber;
    private int phoneNumber;
    private String email;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH})
    @JoinTable(
            name = "session_trainee",
            joinColumns = @JoinColumn(name = "trainee_id"),
            inverseJoinColumns = @JoinColumn(name = "session_id")
    )

    private List<Session> sessions;


    public Trainee() {
    }

    public void addSession(Session session){
        this.sessions.add(session);
    }
    public Trainee(String traineeName, String gender, int socialNumber, int phoneNumber, String email) {
        this.traineeName = traineeName;
        this.gender = gender;
        this.socialNumber = socialNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Trainee(String traineeName, String gender, int socialNumber, int phoneNumber, String email, List<Session> sessions) {
        this.traineeName = traineeName;
        this.gender = gender;

        this.socialNumber = socialNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sessions = sessions;
    }

    public Trainee(String traineeName, String email) {
        this.traineeName = traineeName;

        this.email = email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public int getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(int socialNumber) {
        this.socialNumber = socialNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public void addSessions (List<Session> addedSession) {
        this.sessions.add((Session) addedSession);
    }
}












