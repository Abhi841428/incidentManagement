package com.system.payload;

import com.system.Enum.IncidentStatus;
import com.system.Enum.Priority;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class IncidentDto {
    private Long incidentId;
    private String enterpriseOrGovernment;
    private String reporterName;
    private String incidentDetails;
    private LocalDateTime reportedDateTime;
    private Priority priority;
    private IncidentStatus incidentStatus;

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
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
}

