package org.example.schedule.repository;

import org.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    // 작성자명(name)으로 필터링 + 수정일 내림차순 정렬
    List<Schedule> findAllByNameOrderByModifiedAtDesc(String name);
    // 전체 조회 + 수정일 내림차순 정렬
    List<Schedule> findAllByOrderByModifiedAtDesc();


}