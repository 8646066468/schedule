package org.example.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule.dto.ScheduleRequest;
import org.example.schedule.dto.ScheduleResponse;
import org.example.schedule.entity.Schedule;
import org.example.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    //생성
    @Transactional

    public ScheduleResponse saveSchedule(ScheduleRequest scheduleRequest) {
        Schedule schedule = new Schedule(scheduleRequest.getContent(), scheduleRequest.getTitle(), scheduleRequest.getPassword(), scheduleRequest.getName());
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

    //전체 조회
    @Transactional(readOnly = true)
    public List<ScheduleResponse> getSchedule(String name) {
        List<Schedule> schedulesList;
        //name이 null 이 아니고! name이 비어있지 않다면
        if (name != null && !name.isEmpty()) {
            //findAllByNameOrderByModifiedAtDesc 메서드를 통해 수정일 기준 내림차순으로 이름에 해당하는 일정을 조회
            schedulesList = scheduleRepository.findAllByNameOrderByModifiedAtDesc(name);

        } else
            //아니면 그냥 다 조회해!
            schedulesList = scheduleRepository.findAllByOrderByModifiedAtDesc();

        List<ScheduleResponse> scheduleResponses = new ArrayList<>();
        for (Schedule schedule : schedulesList) {
            scheduleResponses.add(new ScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getName(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            ));
        }
        return scheduleResponses;
    }

    //단건 조회
    @Transactional(readOnly = true)
    public ScheduleResponse getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 일정이 없는데?")
        );
        return new ScheduleResponse(schedule.getId(), schedule.getTitle(), schedule.getContent(), schedule.getName(), schedule.getCreatedAt(), schedule.getModifiedAt());
    }

    // 일정 수정
    @Transactional
    public ScheduleResponse updateSchedule(Long id, ScheduleRequest scheduleRequest) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 일정이 없는데?")
        );
        if (!scheduleRequest.getPassword().equals(schedule.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않다");
        }

        schedule.updateSchedule(scheduleRequest.getContent(), scheduleRequest.getTitle());
        return new ScheduleResponse(schedule.getId(), schedule.getTitle(), schedule.getContent(), schedule.getName(), schedule.getCreatedAt(), schedule.getModifiedAt());
    }

    // 조건 삭제
    @Transactional
    public void deleteScheduleById(Long id, ScheduleRequest scheduleRequest) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 아이디 없는데요?")
        );
        {
            if (!scheduleRequest.getPassword().equals(schedule.getPassword())) {
                throw new IllegalArgumentException("비밀번호가 일치하지 않다");
            }
            scheduleRepository.delete(schedule);
        }
    }
}
