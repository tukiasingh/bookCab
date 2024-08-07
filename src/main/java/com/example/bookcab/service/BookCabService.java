package com.example.bookcab.service;

import com.example.bookcab.model.BookCab;
import com.example.bookcab.model.Response;
import com.example.bookcab.repository.BookCabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class BookCabService {

    @Autowired
    BookCabRepository BookCabRepository;

    public ResponseEntity<Response> bookCab(BookCab bookCab) {
        try {
            BookCab cab = new BookCab();
//            cab.setBookingId(bookCab.getBookingId());
            cab.setName(bookCab.getName());
            cab.setPhoneNumber(bookCab.getPhoneNumber());
            cab.setFromLocation(bookCab.getFromLocation());
            cab.setToLocation(bookCab.getToLocation());
            cab.setTypeOfCab(bookCab.getTypeOfCab());

            System.out.println("Values we have just before saving to the database: "+
                    "Name: " +cab.getName() +
                    ", Phone Name: " +cab.getName() +
                    ", From Location: " +cab.getFromLocation() +
                    ", To Location: " +cab.getToLocation() +
                    ", Type of Cab: " +cab.getTypeOfCab() );
            BookCabRepository.save(cab);
            String message = "Your cab is booked Successfully! Cab details: " +
//                    "Booking Id: " + bookCab.getBookingId() +
                    "From Location: " + bookCab.getFromLocation() +
                    "To Location: " + bookCab.getToLocation();
            int code = 200;
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        } catch (Exception e) {
            String message = "Your cab cannot be booked Now!" +
                    "Sorry for the inconvenience. Please try later!";
            int code = 500;
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}
