package com.project.gym.management.system.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String trainerName;
    private String bio;
    private String education;
    private String specialTraining;
    private int experience;
    private String imgUrl;

    @OneToMany
    private List<Session> sessions;

    public Trainer() {
    }

    public Trainer(String trainerName, String bio, String education, String specialTraining, int experience, String imgUrl) {
        this.trainerName = trainerName;
        this.bio = bio;
        this.education = education;
        this.specialTraining = specialTraining;
        this.experience = experience;
        this.imgUrl = imgUrl;
    }

    public Trainer(String trainerName, String bio, String education, String specialTraining, int experience) {
        this.trainerName = trainerName;
        this.bio = bio;
        this.education = education;
        this.specialTraining = specialTraining;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpecialTraining() {
        return specialTraining;
    }

    public void setSpecialTraining(String specialTraining) {
        this.specialTraining = specialTraining;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
