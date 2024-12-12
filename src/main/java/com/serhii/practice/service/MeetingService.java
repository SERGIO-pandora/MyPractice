package com.serhii.practice.service;

import com.serhii.practice.Meeting;
import com.serhii.practice.dto.MeetingDTO;
import com.serhii.practice.repository.MeetingRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MeetingService {
    private final MeetingRepository repository;

    public MeetingService(MeetingRepository repository) {
        this.repository = repository;
    }

    private MeetingDTO toDTO(Meeting meeting) {
        MeetingDTO dto = new MeetingDTO();
        dto.setId(meeting.getId()); // Добавлено присвоение значения ID
        dto.setCandidateName(meeting.getCandidateName());
        dto.setMeetingNumberInDay(meeting.getMeetingNumberInDay());
        dto.setMeetingDate(meeting.getMeetingDate());
        dto.setCandidateSpecialization(meeting.getCandidateSpecialization());
        dto.setMeetingLocation(meeting.getMeetingLocation());
        return dto;
    }

    private Meeting fromDTO(MeetingDTO dto) {
        return new Meeting(
                dto.getCandidateName(),
                dto.getMeetingNumberInDay(),
                dto.getMeetingDate(),
                dto.getCandidateSpecialization(),
                dto.getMeetingLocation()
        );
    }

    public List<MeetingDTO> findAllDTOs() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public MeetingDTO findDTOById(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Meeting not found"));
    }

    public MeetingDTO saveDTO(MeetingDTO dto) {
        Meeting savedMeeting = repository.save(fromDTO(dto));
        return toDTO(savedMeeting);
    }

    public MeetingDTO updateDTO(Long id, MeetingDTO dto) {
        Meeting existingMeeting = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meeting not found"));
        existingMeeting.setCandidateName(dto.getCandidateName());
        existingMeeting.setMeetingNumberInDay(dto.getMeetingNumberInDay());
        existingMeeting.setMeetingDate(dto.getMeetingDate());
        existingMeeting.setCandidateSpecialization(dto.getCandidateSpecialization());
        existingMeeting.setMeetingLocation(dto.getMeetingLocation());
        return toDTO(repository.save(existingMeeting));
    }

    public Map<DayOfWeek, List<MeetingDTO>> getScheduleGroupedByDayOfWeek() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.groupingBy(meeting -> meeting.getMeetingDate().getDayOfWeek()));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
