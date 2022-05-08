package com.project.gym.management.system.Repositories;

import com.project.gym.management.system.Models.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TraineeRepo extends CrudRepository<Trainee,Integer> {

    Trainee getById(int id);

    Trainee getByTraineeName(String name);


    Trainee getByEmail(String email);
}
