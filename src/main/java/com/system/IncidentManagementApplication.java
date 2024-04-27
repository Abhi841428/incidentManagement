package com.system;

import com.system.payload.PinCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IncidentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncidentManagementApplication.class, args);
	}

//		@Bean
//		public PinCode pinCode() {
//			return new PinCode();
//		}

	}


