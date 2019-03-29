package com.scifisoft.RestProject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scifisoft.RestProject.dao.StudentDao;
import com.scifisoft.RestProject.dto.StudentDTO;
import com.scifisoft.RestProject.models.Student;
import com.scifisoft.RestProject.service.StudentService;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public StudentDTO createOrUpdate(StudentDTO studentDTO) {

		Student student = new Student();

		try {
			String studentId = studentDTO.getStudentId();

			int size = studentDao.findAll().size();
			size = size + 1;
			if (studentId == null) {

				student.setStudentId("" + size);

			} else {

				Student studentEntity = studentDao.findById(studentId);
				student.setStudentId(studentEntity.getStudentId());

			}
			student.setStuName(studentDTO.getStuName());
			student.setStuClass(studentDTO.getStuClass());
			student.setStuAdress(studentDTO.getStuAdress());
			studentDao.saveOrUpdate(student);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return studentDTO;
	}

	@Override
	public StudentDTO getById(String studentId) {

		StudentDTO dto = new StudentDTO();

		try {
			Student student = studentDao.findById(studentId);
			dto.setStudentId(student.getStudentId());
			dto.setStuName(student.getStuName());
			dto.setStuClass(student.getStuClass());
			dto.setStuAdress(student.getStuAdress());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<StudentDTO> getALL() {

		List<StudentDTO> dtoList = new ArrayList<>();

		try {
			List<Student> studentList = studentDao.findAll();
			for (Student student : studentList) {
				StudentDTO dto = new StudentDTO();
				dto.setStudentId(student.getStudentId());
				dto.setStuName(student.getStuName());
				dto.setStuClass(student.getStuClass());
				dto.setStuAdress(student.getStuAdress());
				dtoList.add(dto);

			}

		} catch (Exception e) {

		}
		return dto;

	}

	@Override
	public boolean deleteById(String studentId) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
