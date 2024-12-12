package com.serhii.practice.controller;

import com.serhii.practice.dto.MeetingDTO;
import com.serhii.practice.service.MeetingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/meetings")
@Validated
public class MeetingController {
    private final MeetingService service;

    public MeetingController(MeetingService service) {
        this.service = service;
    }

    @GetMapping
    public List<MeetingDTO> getAllMeetings() {
        return service.findAllDTOs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingDTO> getMeetingById(@PathVariable Long id) {
        MeetingDTO meeting = service.findDTOById(id);
        if (meeting == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meeting);
    }

    @PostMapping
    public ResponseEntity<MeetingDTO> createMeeting(@Valid @RequestBody MeetingDTO meetingDTO) {
        MeetingDTO createdMeeting = service.saveDTO(meetingDTO);
        return ResponseEntity.created(URI.create("/api/meetings/" + createdMeeting.getId()))
                .body(createdMeeting);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeetingDTO> updateMeeting(@PathVariable Long id, @Valid @RequestBody MeetingDTO meetingDTO) {
        MeetingDTO existingMeeting = service.findDTOById(id);
        if (existingMeeting == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.updateDTO(id, meetingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable Long id) {
        MeetingDTO meeting = service.findDTOById(id);
        if (meeting == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
