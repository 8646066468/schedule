package org.example.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor //
public class ScheduleRequest {
    /*q:
       대입되지않았다는 경고가 뜨는데 이게 명시적으로 선언되지않아서 그런거다 라고해서 @AllArgsConstructor를 넣어서 경고를 일단 없앴는데 이래도 괜찮은건가요
    *  아니면 @setter를 쓰라고하는데 어떤 방법이 맞는건가요
    * */
    private String title;
    private String content;
    private String name;
    private String password;
}
