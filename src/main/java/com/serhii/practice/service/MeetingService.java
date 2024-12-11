package com.serhii.practice.service;

import com.serhii.practice.Meeting;
import com.serhii.practice.repository.MeetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    private final MeetingRepository repository;

    public MeetingService(MeetingRepository repository) {
        this.repository = repository;
    }

    public List<Meeting> findAll() {
        return repository.findAll();
    }

    public Meeting findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Meeting not found"));
    }

    public Meeting save(Meeting meeting) {
        return repository.save(meeting);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
