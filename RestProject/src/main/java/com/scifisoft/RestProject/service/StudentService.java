package com.scifisoft.RestProject.service;

import java.util.List;

import com.scifisoft.RestProject.dto.StudentDTO;

public interface StudentService {

	StudentDTO createOrUpdate(StudentDTO StudentDTO);

	StudentDTO getById(String studentId);

	List<StudentDTO> getALL();

	boolean deleteById(String studentId);

}
