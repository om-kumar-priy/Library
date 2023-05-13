package com.LIBRARY_Manegment.Library.Repository;

import com.LIBRARY_Manegment.Library.Modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Integer> {
}
