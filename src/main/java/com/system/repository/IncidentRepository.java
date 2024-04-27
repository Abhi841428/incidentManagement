package com.system.repository;

import com.system.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IncidentRepository extends JpaRepository<Incident , Long> {

//    Optional<Incident> findByIncidentId(Long id)
    @Query("Select max(i.id) from Incident i")
    long findMaxId();

}




