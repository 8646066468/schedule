package org.example.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule.dto.ScheduleRequest;
import org.example.schedule.dto.ScheduleResponse;
import org.example.schedule.entity.Schedule;
import org.example.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponse saveSchedule(ScheduleRequest scheduleRequest) {
        Schedule schedule = new Schedule(scheduleRequest.getContent(), scheduleRequest.getName(), scheduleRequest.getPassword(),scheduleRequest.getTitle());
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getName(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }


}
