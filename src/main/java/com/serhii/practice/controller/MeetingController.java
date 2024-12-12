package com.serhii.practice.controller;

import com.serhii.practice.dto.MeetingDTO;
import com.serhii.practice.service.MeetingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/meetings")
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
        return ResponseEntity.ok(service.findDTOById(id));
    }

    @PostMapping
    public ResponseEntity<MeetingDTO> createMeeting(@Valid @RequestBody MeetingDTO meetingDTO) {
        return ResponseEntity.status(201).body(service.saveDTO(meetingDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeetingDTO> updateMeeting(@PathVariable Long id, @Valid @RequestBody MeetingDTO meetingDTO) {
        return ResponseEntity.ok(service.updateDTO(id, meetingDTO));
    }

    @GetMapping("/schedule")
    public Map<DayOfWeek, List<MeetingDTO>> getScheduleGroupedByDayOfWeek() {
        return service.getScheduleGroupedByDayOfWeek();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
