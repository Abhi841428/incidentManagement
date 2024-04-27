package com.system.controller;


import com.system.entity.User;
import com.system.payload.*;
import com.system.service.PinCodeDetailService;
import com.system.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/register")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PinCodeDetailService pinCodeDetailService;

    @PostMapping(value = "/addUserDetail")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        if (userDto != null) {
            String pinCode = userDto.getPinCode();
            PinCodeDetail detail = pinCodeDetailService.getDetail(pinCode);
            userDto.setCountry(detail.getCountry());
            userDto.setCity(detail.getDistrict());
            User user = userService.addUser(userDto);
            return new ResponseEntity<>("Registration is successful", HttpStatus.CREATED);

        }

        return new ResponseEntity<>("Registration is not successful" , HttpStatus.INTERNAL_SERVER_ERROR);
    }

//@PostMapping(value = "/login")
//public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
//    String token = userService.verifyLogin(loginDto);
//    if (token != null) {
//        TokenResponse tokenResponse = new TokenResponse();
//        tokenResponse.setToken(token);
//        return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
//
//    }
//
//    return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
//
//}
}






//    @PostMapping(value = "/login")
//    public ResponseEntity<?> LoginUser(@RequestBody LoginDto loginDto){
//       User user = userService.LoginUser(loginDto);
//       return new ResponseEntity<>(user, HttpStatus.OK);
//    }

//    @PostMapping("/{username}/incidents")
//    public ResponseEntity<Incident> createIncident(@PathVariable String username, @RequestBody IncidentDto incidentDto) {
//        try {
//            Incident newIncident = userService.createIncidentForUser(username, incidentDto);
//            return new ResponseEntity<>(newIncident, HttpStatus.CREATED);
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // User not found
//        }
//    }
//





