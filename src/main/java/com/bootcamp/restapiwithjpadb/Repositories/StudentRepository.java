package com.bootcamp.restapiwithjpadb.Repositories;

import com.bootcamp.restapiwithjpadb.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
