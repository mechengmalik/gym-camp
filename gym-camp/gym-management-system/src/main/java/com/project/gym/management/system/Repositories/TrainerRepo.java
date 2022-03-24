package com.project.gym.management.system.Repositories;

import com.project.gym.management.system.Models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TrainerRepo extends CrudRepository<Trainer,Integer> {


    Trainer getById(int id);

    Trainer getByTrainerName(String TrainerName);
}
