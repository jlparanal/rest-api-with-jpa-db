package com.bootcamp.restapiwithjpadb.Repositories;

import com.bootcamp.restapiwithjpadb.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
