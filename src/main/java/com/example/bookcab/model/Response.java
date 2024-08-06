package com.example.bookcab.model;

import java.util.List;

public class Response {
    private int code;
    private String message;
    private List<BookCab> bookings;

    public Response() {}

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(int code, String message, List<BookCab> bookings) {
        this.code = code;
        this.message = message;
        this.bookings = bookings;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BookCab> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookCab> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
