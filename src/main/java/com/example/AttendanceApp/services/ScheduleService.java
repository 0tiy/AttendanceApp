package com.example.AttendanceApp.services;

import com.example.AttendanceApp.models.Schedule;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleService {
    boolean scheduleExists(long employeeId, LocalDateTime shiftStart, LocalDateTime shiftEnd, Double workedHours, boolean isPresent);

    List<Schedule> getSchedule();

    Schedule getScheduleById(long id);

    void saveSchedule(Schedule schedule);

    void deleteScheduleById(long id);

    void updateScheduleById(long id);

    Double workedHours(LocalDateTime start, LocalDateTime end);

    boolean isPresent(Double workedHours);
}
