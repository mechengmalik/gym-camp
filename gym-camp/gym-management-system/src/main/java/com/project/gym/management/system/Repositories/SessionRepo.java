package com.project.gym.management.system.Repositories;

import com.project.gym.management.system.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepo extends CrudRepository<Session,Integer> {
    Session getById(int id);
}
