package com.example.bookcab.service;

import com.example.bookcab.model.BookCab;
import com.example.bookcab.model.Response;
import com.example.bookcab.proxy.CabFareProxy;
import com.example.bookcab.repository.BookCabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookCabService {

    @Autowired
    BookCabRepository BookCabRepository;
    @Autowired
    CabFareProxy cabFareProxy;

    public ResponseEntity<Response> bookCab(BookCab bookCab) {
        try {
            BookCab cab = new BookCab();
            cab.setName(bookCab.getName());
            cab.setPhoneNumber(bookCab.getPhoneNumber());
            cab.setFromLocation(bookCab.getFromLocation());
            cab.setToLocation(bookCab.getToLocation());
            cab.setTypeOfCab(bookCab.getTypeOfCab());


            BookCabRepository.save(cab);
            Optional<BookCab> result = BookCabRepository.findById(cab.getBookingId());
            String bookCabResult = "";
            if(result.isPresent()) {
                bookCabResult = result.get().toString();

            }

            String message = "Your cab is booked Successfully! \nCab details: " + bookCabResult +
                   "Amount to be Paid: $" + cabFareProxy.findCabFareByType(cab.getTypeOfCab());
            int code = 200;
            Response response = new Response(code, message);
            System.out.println("My Response is: "+response);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        } catch (Exception e) {
            String message = "Your cab cannot be booked Now!" +
                    "Sorry for the inconvenience. Please try later!";
            System.out.println("Exception: " + e);
            int code = 500;
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public ResponseEntity<Response> calculateFare(BookCab bookCab) {
        try {
            BookCab cab = new BookCab();
            cab.setFromLocation(bookCab.getFromLocation());
            cab.setToLocation(bookCab.getToLocation());
            cab.setTypeOfCab(bookCab.getTypeOfCab());



            String message = "Cab Fare details: " +
                    "From Location: " + cab.getFromLocation()  +
                    "To Location: " + cab.getFromLocation()  +
                    "Amount to be Paid: $" + cabFareProxy.findCabFareByType(cab.getTypeOfCab());
            int code = 200;
            Response response = new Response(code, message);
            System.out.println("My Response is: "+response);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        } catch (Exception e) {
            String message = "Your cab fare cannot be calculated!" +
                    "Sorry for the inconvenience. Please try later!";
            int code = 500;
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public List<String> allCabs(){
        return cabFareProxy.allCabs();
    }




}
