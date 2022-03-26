package com.project.gym.management.system.Repositories;


import com.project.gym.management.system.Models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser,Integer> {
    ApplicationUser findByUsername(String username);


    ApplicationUser findUserById(int id);

}
