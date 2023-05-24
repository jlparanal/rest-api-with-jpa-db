package com.bootcamp.restapiwithjpadb.Services;

import com.bootcamp.restapiwithjpadb.Repositories.StudentRepository;
import com.bootcamp.restapiwithjpadb.Model.Course;
import com.bootcamp.restapiwithjpadb.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudentById(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            // Update other properties as needed

            return studentRepository.save(student);
        } else {
            return null;
        }
    }

    public Student enrollCourse(Long studentId, Long courseId, String courseName) {
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            Course course = new Course();
            course.setId(courseId);
            course.setName(courseName);
            student.setCourse(course);
            return studentRepository.save(student);
        } else {
            return null;
        }
    }

    public Student dropCourse(Long studentId, Long courseId) {
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setCourse(null);
            return studentRepository.save(student);
        } else {
            return null;
        }
    }
}
