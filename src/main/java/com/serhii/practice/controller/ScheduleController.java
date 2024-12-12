package com.serhii.practice.controller;

import com.serhii.practice.dto.MeetingDTO;
import com.serhii.practice.service.MeetingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final MeetingService meetingService;

    public ScheduleController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    public ResponseEntity<Map<DayOfWeek, List<MeetingDTO>>> getScheduleGroupedByDayOfWeek() {
        Map<DayOfWeek, List<MeetingDTO>> schedule = meetingService.getScheduleGroupedByDayOfWeek();
        return ResponseEntity.ok(schedule);
    }

    @PostMapping
    public ResponseEntity<MeetingDTO> createMeeting(@RequestBody @Valid MeetingDTO meetingDTO) {
        MeetingDTO createdMeeting = meetingService.saveDTO(meetingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMeeting);
    }
}