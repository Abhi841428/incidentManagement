package com.system.service;


import com.system.Enum.IncidentStatus;
import com.system.Enum.Priority;
import com.system.common.Util;
import com.system.entity.Incident;
import com.system.payload.IncidentDto;
import com.system.repository.IncidentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Random;

import static com.system.Enum.Priority.*;

@Service
@AllArgsConstructor
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private  IncidentGenerationService incidentGenerationService;

    public Incident createIncident(IncidentDto incidentDto) {
//        String incidentId = incidentGenerationService.generateIncidentId();

        Incident incident = new Incident();
        incident.setEnterpriseOrGovernment(incidentDto.getEnterpriseOrGovernment());
        incident.setReporterName(incidentDto.getReporterName());
        incident.setIncidentDetails(incidentDto.getIncidentDetails());
        incident.setReportedDateTime(LocalDateTime.now());
        incident.setPriority(incidentDto.getPriority());
        incident.setIncidentStatus(incidentDto.getIncidentStatus());

        Long maxId = getMaxId();

        if(maxId == null){
            Long RmdId =(10000+0l);
            incident.setIncidentId("RMD"+RmdId+ Util.getCurrentYear());
        }
        else {
            Long RmdId = (10000 + maxId);
            incident.setIncidentId("RMD" + RmdId + Util.getCurrentYear());
        }
        return incidentRepository.save(incident);


    }

    public Long getMaxId(){
       return incidentRepository.getMaxId();
    }






//    public Incident getIncidentById(Long incidentId) {
//        return incidentRepository.findByIncidentId(incidentId)
//                .orElseThrow(() -> new IllegalArgumentException("Incident not found"));
//    }
}





//        public Incident updateIncident(Long incidentId, IncidentDto incidentDto) {
//            Incident existingIncident = incidentRepository.findById(incidentId)
//                    .orElseThrow(() -> new IllegalArgumentException("Incident not found"));
//
//            if (existingIncident.getIncidentStatus() == IncidentStatus.CLOSED) {
//                throw new IllegalArgumentException("Closed incidents cannot be edited");
//            }
//
//            existingIncident.setPriority(Priority.valueOf(incidentDto.getPriority())); // Update priority
//
//            return incidentRepository.save(existingIncident); // Save updated incident
//        }
//
//    }




