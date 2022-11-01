package com.project.gym.management.system.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String sessionName;
    private int capacity;
    private String type;
    private String description;
    private float price;
    private String imgUrl;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REFRESH,
                          CascadeType.DETACH,},
                          fetch = FetchType.LAZY )
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToMany( fetch = FetchType.LAZY,
               cascade  = {CascadeType.PERSIST,
                             CascadeType.MERGE,
                             CascadeType.REFRESH,
                             CascadeType.DETACH})
    @JoinTable(
            name = "session_trainee",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "trainee_id")
    )
    private List <Trainee> trainee;

    public Session() {
    }


    public Session(String sessionName, int capacity, String type, String description, float price, String imgUrl, Trainer trainer) {
        this.sessionName = sessionName;
        this.capacity = capacity;
        this.type = type;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.trainer = trainer;
    }

    public Session(String sessionName, String type, String description, float price, String imgUrl) {
        this.sessionName = sessionName;
        this.type = type;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Session(String sessionName, int capacity, String type, String description, float price, String imgUrl) {
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setTrainee(List<Trainee> trainee) {
        this.trainee = trainee;
    }

    public List <Trainee> getTrainee() {
        return trainee;
    }


}
