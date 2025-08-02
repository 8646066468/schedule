package org.example.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule.dto.ScheduleRequest;
import org.example.schedule.dto.ScheduleResponse;
import org.example.schedule.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    public final ScheduleService scheduleService;

    //생성
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponse> saveSchedule(
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        return ResponseEntity.ok(scheduleService.saveSchedule(scheduleRequest));
    }

    // 전체 조회
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponse>> getFindAllList(
            @RequestParam(required = false) String name
    ) {
        List<ScheduleResponse> schedule = scheduleService.getSchedule(name);
        return ResponseEntity.ok(schedule);
    }

    // 단건 조회
    @GetMapping("/schedules/{schedulesId}")
    public ResponseEntity<ScheduleResponse> getFindId(@PathVariable Long schedulesId) {
        return ResponseEntity.ok(scheduleService.getScheduleById(schedulesId));
    }

    // 업데이트 수정
    @PatchMapping("/schedules/{schedulesId}")
    public ResponseEntity<ScheduleResponse> updateSchedule(
            @PathVariable Long schedulesId,
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        return ResponseEntity.ok(scheduleService.updateSchedule(schedulesId, scheduleRequest));
    }

    @DeleteMapping("/schedules/{schedulesId}")
    public void DeleteSchedule(
            @PathVariable Long schedulesId,
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        scheduleService.deleteScheduleById(schedulesId, scheduleRequest);
    }
}





