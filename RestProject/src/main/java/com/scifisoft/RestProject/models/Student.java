package com.scifisoft.RestProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students", catalog = "scifidb")
public class Student {

	private String studentId;

	private String stuName;

	private String stuClass;

	private String stuAdress;

	public Student() {

	}

	@Id
	@Column(name = "student_id", unique = true, nullable = false, length = 255)
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Column(name = "stu_name", length = 255)
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	@Column(name = "stu_class", length = 255)
	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	@Column(name = "stu_adress", length = 255)
	public String getStuAdress() {
		return stuAdress;
	}

	public void setStuAdress(String stuAdress) {
		this.stuAdress = stuAdress;
	}

	public Student(String stuName, String stuClass, String stuAdress) {

		this.stuName = stuName;
		this.stuClass = stuClass;
		this.stuAdress = stuAdress;
	}

}
