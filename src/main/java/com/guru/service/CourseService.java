package com.guru.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guru.entity.Courses;
import com.guru.exception.CourseNotFoundException;
import com.guru.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired CourseRepository courseRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public Courses saveCourse(Courses courses) {
		logger.info("From course  service");
		return courseRepository.save(courses);
	}

	public ResponseEntity<Courses> findById(Long id) {
		logger.info("From course  service");
		//ResponseEntity<?> resp = new ResponseEntity<>(HttpStatus.OK);
		Optional<Courses> courOptional = courseRepository.findById(id);
		if(courOptional == null || !courOptional.isPresent()) {
			logger.error("No course found with provided id :{}",id);
			throw new CourseNotFoundException("course not found with id" + id);
		}
		return new ResponseEntity<Courses>(courOptional.get(), HttpStatus.OK);
	}

	public ResponseEntity<?> updateCourse(Courses courses, Long id) {
		logger.info("From updateCourse");
		try {
			findById(id);
		} catch (CourseNotFoundException e) {
			logger.warn("COURSE is not avaiable with provided id :{}", id);
			return new ResponseEntity<String>("COURSE_NOT_FOUND", HttpStatus.OK);
		}
		courseRepository.save(courses);
		return new ResponseEntity<String>("UPADATE_SUCESS", HttpStatus.OK);
	}

	public ResponseEntity<String> deleteById(Long id) {
		logger.info("From deleteById");
		ResponseEntity<Courses> resp = null;
		try {
			resp = findById(id);
		} catch (CourseNotFoundException e) {
			logger.warn("COURSE is not avaiable with provided id :{}", id);
			return new ResponseEntity<String>("COURSE_NOT_FOUND", HttpStatus.OK);
		}
		courseRepository.deleteById(id);
		return new ResponseEntity<String>("DELETE_SUCESS", HttpStatus.OK);
	}
	
}
