package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AttendanceRequestDTO;
import com.example.demo.entity.Attendance;
import com.example.demo.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

	private final AttendanceService attendanceService;

	@PostMapping
	public Attendance markAttendance(@RequestBody AttendanceRequestDTO request) {
		return attendanceService.markAttendance(request);
	}

	@GetMapping("/student/{studentId}")
	public List<Attendance> getByStudent(@PathVariable Long studentId) {
		return attendanceService.getAttendanceByStudent(studentId);
	}

	@GetMapping("/date/{date}")
	public List<Attendance> getByDate(@PathVariable LocalDate date) {
		return attendanceService.getAttendanceByDate(date);
	}

	@GetMapping
	public List<Attendance> getAll() {
		return attendanceService.getAllAttendance();
	}
}