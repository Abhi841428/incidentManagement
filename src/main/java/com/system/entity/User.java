package com.system.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;

    @Column(name="username" , unique = true, nullable = false)
    private String username;

    @Column(name = "password")
    private  String password;

    @Column(name="email" , unique = true, nullable = false)
    private String email;

    @Column(name="phoneNumber",nullable = false)
    private String phoneNumber;

    @Column(name="address", length= 250 ,nullable = false)
    private String address;

    @Column(name="pinCode", nullable = false)
    private String pinCode;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Incident> incidents = new ArrayList<>();
//

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Incident> getIncidents() {
//        return incidents;
//    }
//
//    public void setIncidents(List<Incident> incidents) {
//        this.incidents = incidents;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
