package com.project.gym.management.system.Repositories;

import com.project.gym.management.system.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session,Integer> {
}
