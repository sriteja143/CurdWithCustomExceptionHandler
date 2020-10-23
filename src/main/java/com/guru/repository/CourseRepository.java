package com.guru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guru.entity.Courses;

@Repository
public interface CourseRepository extends CrudRepository<Courses, Long> {

}
