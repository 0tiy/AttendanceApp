package com.example.AttendanceApp.repositories;

import com.example.AttendanceApp.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
