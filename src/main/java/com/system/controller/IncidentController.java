package com.system.controller;


import com.system.entity.Incident;
import com.system.payload.IncidentDto;
import com.system.service.IncidentGenerationService;
import com.system.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.Random;

@RestController
@RequestMapping("/incident")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;
    @Autowired
    private IncidentGenerationService incidentGenerationService;

    @PostMapping("/create")
    public ResponseEntity<?> createIncident(@RequestBody  IncidentDto incidentDto){

//        String username = authentication.getName();

        Incident incident = incidentService.createIncident(incidentDto);

        return new ResponseEntity<>(incident, HttpStatus.CREATED);
    }


//    @GetMapping("{incidentId}")
//    public  ResponseEntity<?> getIncidentById(@PathVariable Long incidentId){
//     Incident incident  = incidentService.getIncidentById(incidentId);
//        return new ResponseEntity<>(incident , HttpStatus.OK);
//    }


//    @PutMapping("/api/{incidentId}")
//    public  ResponseEntity<?> updateIncident(@PathVariable long incidentId  IncidentDto incidentDto ){
//        Incident  incident = incidentService.updateIncident(incidentId);
//        return  new ResponseEntity<>(incident, HttpStatus.OK);
//
//    }



}
