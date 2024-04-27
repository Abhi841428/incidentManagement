package com.system.service;


import com.system.entity.Incident;
import com.system.entity.User;
import com.system.payload.IncidentDto;
import com.system.payload.LoginDto;
import com.system.payload.UserDto;
import com.system.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;





    public User addUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setAddress(userDto.getAddress());
        user.setPinCode(userDto.getPinCode());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        User  savedUser  = userRepository.save(user);
        return savedUser;

    }


//    public String  verifyLogin(LoginDto loginDto) {
//        Optional<User> byUsername = userRepository.findByUsername(loginDto.getUsername());
//        if (byUsername.isPresent()) {
//            User user = byUsername.get();
//            if(BCrypt.checkpw(loginDto.getPassword(), user.getPassword())){
//                return jwtService.generateToken(user);
//            }
//
//        }
//        return  null;
//    }
//
////    public User LoginUser(LoginDto loginDto) {
////        Optional byUsername = userRepository.findByUsername(loginDto.getUserName());
//        if(byUsername.isPresent()){
//           User user = (User) byUsername.get();
//           return user;
//
//        }
//
//        return null;
//    }






//        public Incident createIncidentForUser(String username, IncidentDto incidentDto) {
//            Optional<User> optionalUser = userRepository.findByUsername(username);
//
//            if (optionalUser.isPresent()) {
//                User user = optionalUser.get();
//
//                // Create new Incident for the user
//                Incident newIncident = incidentService.createIncident(incidentDto);
//
//                // Set user for the incident
//                newIncident.setUser(user);
//
//                // Add incident to user's incidents list
//                user.getIncidents().add(newIncident);
//
//                // Save user with the new incident to the database
//                userRepository.save(user);
//
//                return newIncident;
//            } else {
//                // User not found
//                throw new IllegalArgumentException("User not found");
//            }
//        }
    }




