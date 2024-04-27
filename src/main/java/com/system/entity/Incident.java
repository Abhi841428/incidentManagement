package com.system.entity;

import com.system.Enum.IncidentStatus;
import com.system.Enum.Priority;
import com.system.common.Util;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "incident")
@Getter
@Setter

public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;

    @Column(name="incidentId")
    private String incidentId;

    @Column(name="enterpriseOrGovernment", nullable = false)
    private String enterpriseOrGovernment;

    @Column(name="reporter_name", length = 100, nullable = false)
    private String reporterName;


    @Column(columnDefinition = "TEXT" , nullable = false)
    private String incidentDetails;


    @Column(name="reportedDateTime", nullable = false)
    private LocalDateTime reportedDateTime;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private com.system.Enum.Priority priority;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getEnterpriseOrGovernment() {
        return enterpriseOrGovernment;
    }

    public void setEnterpriseOrGovernment(String enterpriseOrGovernment) {
        this.enterpriseOrGovernment = enterpriseOrGovernment;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getIncidentDetails() {
        return incidentDetails;
    }

    public void setIncidentDetails(String incidentDetails) {
        this.incidentDetails = incidentDetails;
    }

    public LocalDateTime getReportedDateTime() {
        return reportedDateTime;
    }

    public void setReportedDateTime(LocalDateTime reportedDateTime) {
        this.reportedDateTime = reportedDateTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public IncidentStatus getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(IncidentStatus incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentStatus incidentStatus;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    private User user;

//    public Incident(){
//        String prefix = "RMG";
//        Long currentYear = Util.getCurrentYear();
//        Long random = 10000l;
//        this.setIncidentId((prefix+(random+this.getId()+1) + currentYear).toString());
//    }

}
