package com.guru.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guru.entity.Courses;
import com.guru.exception.CourseNotFoundException;
import com.guru.service.CourseService;

@RestController
public class CourseController {
	@Autowired CourseService courseService;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/save")
	public Courses save(@RequestBody Courses courses) {
		logger.info("Save method");
		return courseService.saveCourse(courses);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Courses> findById(@PathVariable Long id) { 
		logger.info("CourseController -> find by id ");
		return  courseService.findById(id);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Courses courses) {
		logger.info("update method");
		return courseService.updateCourse(courses, id);
	}
	
	@GetMapping("/test")
	public String est() {
		return "COURSE";
	}
	
	@GetMapping("/ex/{id}")
	public String excception(@PathVariable Integer id) throws Exception {
		if(id != 0)throw new Exception();
		return "COURSE";
	}
	
	@GetMapping("delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) { 
		logger.info("CourseController -> find by id ");
		return  courseService.deleteById(id);
	}
}
