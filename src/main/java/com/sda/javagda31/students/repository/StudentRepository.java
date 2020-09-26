package com.sda.javagda31.students.repository;

import com.sda.javagda31.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//java persistance api DAO- CRUD
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByFirstNameLike(String phrase);
    List<Student> findAllByFirstNameLikeAndLastNameLike(String phrase, String lastPhrase);
}
