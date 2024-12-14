package com.serhii.practice.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class MeetingDTO {

    private Long id;

    @NotNull
    @Size(min = 2, max = 100, message = "Candidate name must be between 2 and 100 characters")
    private String candidateName;

    @NotNull
    @Min(value = 1, message = "Meeting number must be at least 1")
    @Max(value = 10, message = "Meeting number cannot exceed 10")
    private Integer meetingNumberInDay;

    @NotNull
    @FutureOrPresent(message = "Meeting date cannot be in the past")
    private LocalDate meetingDate;

    @NotNull
    @Size(min = 2, max = 100, message = "Specialization must be between 2 and 100 characters")
    private String candidateSpecialization;

    @NotNull
    @Size(min = 2, max = 100, message = "Meeting location must be between 2 and 100 characters")
    private String meetingLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Integer getMeetingNumberInDay() {
        return meetingNumberInDay;
    }

    public void setMeetingNumberInDay(Integer meetingNumberInDay) {
        this.meetingNumberInDay = meetingNumberInDay;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getCandidateSpecialization() {
        return candidateSpecialization;
    }

    public void setCandidateSpecialization(String candidateSpecialization) {
        this.candidateSpecialization = candidateSpecialization;
    }

    public String getMeetingLocation() {
        return meetingLocation;
    }

    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation;
    }
}
