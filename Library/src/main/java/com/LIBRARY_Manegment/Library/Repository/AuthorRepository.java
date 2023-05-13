package com.LIBRARY_Manegment.Library.Repository;

import com.LIBRARY_Manegment.Library.Modal.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    Author findByEmail(String email);

}
