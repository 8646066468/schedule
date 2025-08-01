# 일정 관리

## 1. API 명세서

| 메서드 | URL                      | 설명          | 요청 데이터                        | 응답 데이터                                 |
|--------|--------------------------|---------------|----------------------------------|---------------------------------------------|
| POST   | /schedules               | 일정 생성     | title, content, name, password   | id, title, content, name, createdAt, modifiedAt |
| GET    | /schedules               | 전체 일정 조회 | -                                | 일정 리스트                                 |
| GET    | /schedules/{scheduleId}  | 선택 일정 조회 | scheduleId                      | title, content, name, createdAt, modifiedAt |
| PUT    | /schedules/{scheduleId}  | 선택 일정 수정 | scheduleId + password            | 수정된 일정 정보                           |
| DELETE | /schedules/{scheduleId}  | 선택 일정 삭제 | scheduleId + password            | 삭제 성공 메시지 또는 결과                 |

---

## 2. ER 다이어그램

![ER 다이어그램](./images/er_diagram.png)

> `schedule` 테이블은 일정의 제목(title), 상세내용(content), 작성자명(name), 비밀번호(password),  
> 생성 및 수정 일시(createdAt, modifiedAt)를 저장합니다.

---

## 3. 데이터베이스 테이블 (MySQL)

```sql
CREATE TABLE schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    modifiedAt DATETIME NOT NULL
);
