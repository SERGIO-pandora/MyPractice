package com.serhii.practice.controller;

import com.serhii.practice.Meeting;
import com.serhii.practice.service.MeetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {
    private final MeetingService service;

    public MeetingController(MeetingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Meeting> getAllMeetings() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getMeetingById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public Meeting createMeeting(@RequestBody Meeting meeting) {
        return service.save(meeting);
    }

    @PutMapping("/{id}")
    public Meeting updateMeeting(@PathVariable Long id, @RequestBody Meeting meeting) {
        Meeting existingMeeting = service.findById(id);
        existingMeeting.setCandidateName(meeting.getCandidateName());
        existingMeeting.setMeetingNumberInDay(meeting.getMeetingNumberInDay());
        existingMeeting.setMeetingDate(meeting.getMeetingDate());
        existingMeeting.setCandidateSpecialization(meeting.getCandidateSpecialization());
        existingMeeting.setMeetingLocation(meeting.getMeetingLocation());
        return service.save(existingMeeting);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
