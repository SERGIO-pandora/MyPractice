package com.serhii.practice.controller;

import com.serhii.practice.dto.MeetingDTO;
import com.serhii.practice.service.MeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    private final MeetingService meetingService;

    public ScheduleController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }


    @GetMapping("/page")
    public String schedulePage(Model model) {
        Map<DayOfWeek, List<MeetingDTO>> schedule = meetingService.getScheduleGroupedByDayOfWeek();
        model.addAttribute("schedule", schedule);
        return "schedule";
    }

}
