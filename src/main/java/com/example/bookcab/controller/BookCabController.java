package com.example.bookcab.controller;

import com.example.bookcab.model.BookCab;
import com.example.bookcab.model.Response;
import com.example.bookcab.service.BookCabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookCabController {

    @Autowired
    BookCabService bookCabService;

    @RequestMapping(path="/bookCab", method= RequestMethod.POST)
    public String bookCab (Model page, @RequestParam String name, @RequestParam String phoneNumber,
                                             @RequestParam String fromLocation, @RequestParam String toLocation,
                                             @RequestParam String typeOfCab) {

        BookCab cab = new BookCab();
        cab.setName(name);
        cab.setPhoneNumber(phoneNumber);
        cab.setFromLocation(fromLocation);
        cab.setToLocation(toLocation);
        cab.setTypeOfCab(typeOfCab);

        ResponseEntity<Response> response = bookCabService.bookCab(cab);
        page.addAttribute("response", response);
        page.addAttribute("bookingDetails", cab);

        return "success.html";



    }
}
