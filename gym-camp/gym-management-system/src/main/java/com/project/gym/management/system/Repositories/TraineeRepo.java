package com.project.gym.management.system.Repositories;

import com.project.gym.management.system.Models.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TraineeRepo extends CrudRepository<Trainee,Integer> {

}
