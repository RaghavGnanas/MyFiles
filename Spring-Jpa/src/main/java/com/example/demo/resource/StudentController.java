package com.example.demo.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;


@RestController
public class StudentController {
	
	StudentRepository repository;
	
	@Autowired
	StudentService studentService;

	@GetMapping("/student")
	private List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping("/student/{id}")
	private Student getStudent(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}

	@DeleteMapping("/student/delete/{id}")
	private String deleteStudent(@PathVariable("id") int id) {
		studentService.delete(id);
		return "Deleted the student field with id: " + id;
	}	
	
	@DeleteMapping("/deleteall")
	private void deleteAllStudent() {
		studentService.deleteAll();
	}

	@PostMapping("/student")
	private int saveStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		System.out.println("Updated");
		return student.getId();
		
	}
	
}
