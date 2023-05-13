package com.LIBRARY_Manegment.Library.Repository;

import com.LIBRARY_Manegment.Library.Modal.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
