package com.example.bookcab.controller;

import com.example.bookcab.model.BookCab;
import com.example.bookcab.model.Response;
import com.example.bookcab.service.BookCabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/cab")
public class BookCabController {

    @Autowired
    BookCabService bookCabService;

    @PostMapping(path="/bookCab")
    public String bookCab (@RequestParam String name, @RequestParam String phoneNumber,
                                             @RequestParam String fromLocation, @RequestParam String toLocation,
                                             @RequestParam String typeOfCab, Model page) {

        BookCab cab = new BookCab();
        cab.setName(name);
        cab.setPhoneNumber(phoneNumber);
        cab.setFromLocation(fromLocation);
        cab.setToLocation(toLocation);
        cab.setTypeOfCab(typeOfCab);

        ResponseEntity<Response> response = bookCabService.bookCab(cab);
        page.addAttribute("response", response.getBody());
        page.addAttribute("bookingDetails", cab);

        return "success.html";

    }

    @PostMapping(path="/calculateFare")
    public String calculate (@RequestParam String fromLocation, @RequestParam String toLocation,
                           @RequestParam String typeOfCab, Model page) {
        BookCab cab = new BookCab();
        cab.setFromLocation(fromLocation);
        cab.setToLocation(toLocation);
        cab.setTypeOfCab(typeOfCab);

        ResponseEntity<Response> response = bookCabService.calculateFare(cab);
        page.addAttribute("response", response.getBody());
        page.addAttribute("bookingDetails", cab);

        return "success.html";
    }

    @GetMapping(path="/bookACab")
    public String bookACab (Model page) {
        List<String> cabs = bookCabService.allCabs();
        page.addAttribute("cabs", cabs);
        return "bookACab.html";

    }

    @GetMapping(path="/calculateTripFare")
    public String calculateTripFare (Model page) {
        List<String> cabs = bookCabService.allCabs();
        page.addAttribute("cabs", cabs);
        return "calculateTripFare.html";

    }
}
