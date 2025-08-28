package com.sanjiban.restapi.respository;

import com.sanjiban.restapi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

}
