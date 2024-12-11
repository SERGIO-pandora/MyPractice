package com.serhii.practice;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedule")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "candidate_name", nullable = false)
    private String candidateName;

    @Column(name = "meeting_number_in_day", nullable = false)
    private int meetingNumberInDay;

    @Column(name = "meeting_date", nullable = false)
    private LocalDate meetingDate;

    @Column(name = "candidate_specialization", nullable = false)
    private String candidateSpecialization;

    @Column(name = "meeting_location", nullable = false)
    private String meetingLocation;

    public Meeting() {
    }

    public Meeting(String candidateName, int meetingNumberInDay, LocalDate meetingDate,
                   String candidateSpecialization, String meetingLocation) {
        this.candidateName = candidateName;
        this.meetingNumberInDay = meetingNumberInDay;
        this.meetingDate = meetingDate;
        this.candidateSpecialization = candidateSpecialization;
        this.meetingLocation = meetingLocation;
    }

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

    public int getMeetingNumberInDay() {
        return meetingNumberInDay;
    }

    public void setMeetingNumberInDay(int meetingNumberInDay) {
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

    @Override
    public String toString() {
        return "Meeting{" +
                "candidateName='" + candidateName + '\'' +
                ", meetingNumberInDay=" + meetingNumberInDay +
                ", meetingDate=" + meetingDate +
                ", candidateSpecialization='" + candidateSpecialization + '\'' +
                ", meetingLocation='" + meetingLocation + '\'' +
                '}';
    }
}
