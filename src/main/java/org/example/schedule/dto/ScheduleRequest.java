package org.example.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class ScheduleRequest {

    private String title;
    private String content;
    private String name;
    private String password;
}
