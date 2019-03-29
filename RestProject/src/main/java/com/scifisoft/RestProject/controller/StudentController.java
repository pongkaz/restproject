package com.scifisoft.RestProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scifisoft.RestProject.dto.StudentDTO;
import com.scifisoft.RestProject.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("createOrUpdate")
	StudentDTO createOrUpdate(@RequestBody StudentDTO studentDTO) {
		StudentDTO dto = studentService.createOrUpdate(studentDTO);
		return dto;
	};

	@GetMapping("getById")
	StudentDTO getById(@RequestHeader(value = "studentId", defaultValue = "") String studentId) {
		StudentDTO dto = studentService.getById(studentId);
		return dto;
	}

	@GetMapping("getALL")

	List<StudentDTO> getALL() {
		List<StudentDTO> studentDTOList = studentService.getALL();
		return studentDTOList;

	}

	@DeleteMapping("deleteById")
	boolean deleteById(@RequestHeader(value = "studentId", defaultValue = "") String studentId) {
		boolean flag = studentService.deleteById(studentId);
		return flag;
	}

}
