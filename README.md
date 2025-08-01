# 일정 관리

## 1. API 명세서

| 메서드 | URL                      | 설명          | 요청 데이터                        | 응답 데이터                                 |
|--------|--------------------------|---------------|----------------------------------|---------------------------------------------|
| POST   | /schedules               | 일정 생성     | title, content, name, password   | id, title, content, name, createdAt, modifiedAt |
| GET    | /schedules               | 전체 일정 조회 | -                                | 일정 리스트                                 |
| GET    | /schedules/{scheduleId}  | 선택 일정 조회 | scheduleId                      | title, content, name, createdAt, modifiedAt |
| PUT    | /schedules/{scheduleId}  | 선택 일정 수정 | scheduleId + password            | 수정된 일정 정보                           |
| DELETE | /schedules/{scheduleId}  | 선택 일정 삭제 | scheduleId + password            | 삭제 성공 메시지 또는 결과                 |

### 2. ER 다이어그램
<img width="321" height="153" alt="image" src="https://github.com/user-attachments/assets/afbad70c-1749-4a0b-a5d4-ed8518830f86" />


CREATE TABLE schedule (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      task VARCHAR(255) NOT NULL,
      content TEXT  NOT NULL,
      password VARCHAR(255) NOT NULL,
      member_name VARCHAR(255) NOT NULL,
      created_at DATETIME NOT NULL,
      updated_at DATETIME NOT NULL
)
