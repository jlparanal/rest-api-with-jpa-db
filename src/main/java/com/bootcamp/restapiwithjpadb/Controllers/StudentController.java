package com.bootcamp.restapiwithjpadb.Controllers;

import com.bootcamp.restapiwithjpadb.Model.Course;
import com.bootcamp.restapiwithjpadb.Model.Student;
import com.bootcamp.restapiwithjpadb.Services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(addedStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateById(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = studentService.updateStudentById(id, updatedStudent);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/enroll")
    public ResponseEntity<Student> enroll(@PathVariable Long id, @RequestBody Course course) {
        Student enrolledStudent = studentService.enrollCourse(id, course.getId(), course.getName());
        if (enrolledStudent != null) {
            return ResponseEntity.ok(enrolledStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/drop")
    public ResponseEntity<Student> drop(@PathVariable Long id, @RequestBody Course course) {
        Student droppedStudent = studentService.dropCourse(id, course.getId());
        if (droppedStudent != null) {
            return ResponseEntity.ok(droppedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

