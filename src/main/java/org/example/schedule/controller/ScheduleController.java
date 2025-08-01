package org.example.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule.dto.ScheduleRequest;
import org.example.schedule.dto.ScheduleResponse;
import org.example.schedule.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    public final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponse> saveSchedule(
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        return ResponseEntity.ok(scheduleService.saveSchedule(scheduleRequest));
    }
}
