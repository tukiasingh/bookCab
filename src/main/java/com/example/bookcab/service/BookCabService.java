package com.example.bookcab.service;

import com.example.bookcab.model.BookCab;
import com.example.bookcab.model.Response;
import com.example.bookcab.repository.BookCabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class BookCabService {

    @Autowired
    BookCabRepository BookCabRepository;

    public ResponseEntity<Response> addBookCab(BookCab bookCab) {
        return ResponseEntity.ok().body(new Response(101,"Cab Booked!"));
    }
}
