package com.sda.javagda31.students.repository;

import com.sda.javagda31.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//java persistance api DAO- CRUD
public interface StudentRepository extends JpaRepository<Student, Long> {
}
