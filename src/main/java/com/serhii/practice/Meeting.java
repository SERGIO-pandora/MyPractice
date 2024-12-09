package com.serhii.practice;

import java.time.LocalDate;

public class Meeting {
    private String candidateName;
    private int meetingNumberlnDay;
    private LocalDate meetingDate;
    private String candidateSpecialization;
    private String meetingLocation;

    public Meeting(String candidateName, int meetingNumberlnDay, LocalDate meetingDate, String candidateSpecialization, String meetingLocation){

        this.candidateName = candidateName;
        this.meetingNumberlnDay = meetingNumberlnDay;
        this.meetingDate = meetingDate;
        this.candidateSpecialization = candidateSpecialization;
        this.meetingLocation = meetingLocation;

    }

    public void setCandidateName(String candidateName){
        this.candidateName = candidateName;
    }

    public String getCandidateName(){
        return candidateName;
    }

    public void setMeetingNumberlnDay(int meetingNumberlnDay){
        this.meetingNumberlnDay = meetingNumberlnDay;
    }

    public int getMeetingNumberlnDay(){
        return meetingNumberlnDay;
    }


    public void setMeetingDate(LocalDate meetingDate){
        this.meetingDate = meetingDate;
    }

    public LocalDate getMeetingDate(){
        return  meetingDate;
    }

    public void setCandidateSpecialization(String candidateSpecialization){
        this.candidateSpecialization = candidateSpecialization;
    }


    public String getCandidateSpecialization(){
        return candidateSpecialization;
    }

    public void setMeetingLocation(String meetingLocation){
        this.meetingLocation = meetingLocation;
    }

    public String getMeetingLocation(){
        return meetingLocation;
    }


    public String getMeeting(){
        String all_info = "Candidate Name: " + candidateName + "\n" + "Meeting Numberln Day: " + meetingNumberlnDay + "\n" +
                "Meeting Date: " + meetingDate + "\n" + "Candidate Specialization: " + candidateSpecialization + "\n" +
                "Meeting Location: " + meetingLocation;

        return all_info;
    }
}
