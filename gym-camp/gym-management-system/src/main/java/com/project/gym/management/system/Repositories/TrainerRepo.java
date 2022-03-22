package com.project.gym.management.system.Repositories;

import com.project.gym.management.system.Models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepo extends JpaRepository<Trainer,Integer> {

    Trainer getByName(String name);
}
