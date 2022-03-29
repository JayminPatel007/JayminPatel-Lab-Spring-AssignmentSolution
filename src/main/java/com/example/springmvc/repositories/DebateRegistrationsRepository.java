package com.example.springmvc.repositories;

import com.example.springmvc.entities.DebateRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebateRegistrationsRepository extends JpaRepository<DebateRegistration, Long> {
}
