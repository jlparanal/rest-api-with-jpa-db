package com.bootcamp.restapiwithjpadb.Services;

import com.bootcamp.restapiwithjpadb.Repositories.CourseRepository;
import com.bootcamp.restapiwithjpadb.Model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {

        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {

        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourseById(Long id) {

        courseRepository.deleteById(id);
    }

    public Course updateCourseById(Long id, Course updatedCourse) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setName(updatedCourse.getName());
            // Update other properties as needed

            return courseRepository.save(course);
        } else {
            return null;
        }
    }
}
