package com.system.service;

import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Random;
@Service
public class IncidentGenerationService {

    public String generateIncidentId() {
        final Random random = new Random();
        String prefix = "RMG";
        int randomNumber = random.nextInt(90000) + 10000;
        int currentYear = Year.now().getValue();

        return prefix + randomNumber + currentYear;
    }

}
