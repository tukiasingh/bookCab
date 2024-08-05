package com.example.bookcab.repository;

import com.example.bookcab.model.BookCab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookCabRepository extends JpaRepository<BookCab, Integer> {

}
