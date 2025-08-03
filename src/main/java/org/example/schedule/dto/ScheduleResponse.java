package org.example.schedule.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponse {//q: 레코드란건 도대체 뭔가요? 무시해도되는 걸까요?
    private final Long id;
    private final String title;
    private final String content;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

}
