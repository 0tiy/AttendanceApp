package com.example.AttendanceApp.repositories;

import com.example.AttendanceApp.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    boolean existsByEmployeeIdAndShiftStartAndShiftEnd(
            long employeeId,
            LocalDateTime shiftStart,
            LocalDateTime shiftEnd
    );
}
