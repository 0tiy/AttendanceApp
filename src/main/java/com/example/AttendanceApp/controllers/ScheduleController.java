package com.example.AttendanceApp.controllers;

import com.example.AttendanceApp.console.Printer;
import com.example.AttendanceApp.models.Schedule;
import com.example.AttendanceApp.services.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.LocalDateTime;

@Controller
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedule")
    public String getMainPage(Model model){
        model.addAttribute("schedule", scheduleService.getSchedule());
        return "schedule";
    }

    @GetMapping("/add-schedule")
    public String getScheduleForm() {
        return "add-schedule";
    }


    @PostMapping("/add-schedule")
    public String createSchedule(@RequestParam long employeeId,
                                 @RequestParam LocalDateTime shiftStart,
                                 @RequestParam LocalDateTime shiftEnd) {

        Double workedHours = scheduleService.workedHours(shiftStart,shiftEnd);
        boolean isPresent = scheduleService.isPresent(workedHours);
        Schedule schedule = new Schedule(employeeId, shiftStart, shiftEnd, workedHours, isPresent);

        Printer.green("Received Data: " + employeeId + ", " + shiftStart + ", " + shiftEnd + ", " + workedHours + ", " + isPresent);

        if (!scheduleService.scheduleExists(employeeId, shiftStart, shiftEnd)) {
            scheduleService.saveSchedule(schedule);
            Printer.green("Adding schedule");
        } else Printer.red("Schedule already exists!");

        return "redirect:/schedule";
    }

    @PostMapping("/delete-schedule/{id}")
    public String deleteSchedule(@PathVariable long id) {
        scheduleService.deleteScheduleById(id);
        return "redirect:/schedule";
    }
}
