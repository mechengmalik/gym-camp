package com.project.gym.management.system.Models;

import javax.persistence.*;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sessionName;
    private int capacity;
    private String type;
    private String description;
    private float price;
    private String imgUrl;

    @ManyToOne
    private Trainer trainer;

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
}
