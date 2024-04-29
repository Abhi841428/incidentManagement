package com.system.repository;

import com.system.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IncidentRepository extends JpaRepository<Incident , Long> {

@Query("select Max(id) from Incident")
    Long getMaxId();
}




