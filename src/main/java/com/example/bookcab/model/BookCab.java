package com.example.bookcab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookCab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    private String name;
    private String phoneNumber;
    private String fromLocation;
    private String toLocation;
    private String typeOfCab;

    public BookCab() {
    }

    public BookCab(int bookingId, String fromLocation, String toLocation, String typeOfCab) {
        this.bookingId = bookingId;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.typeOfCab = typeOfCab;
    }

    public BookCab(int bookingId, String name, String phoneNumber, String fromLocation, String toLocation, String typeOfCab) {
        this.bookingId = bookingId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.typeOfCab = typeOfCab;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getTypeOfCab() {
        return typeOfCab;
    }

    public void setTypeOfCab(String typeOfCab) {
        this.typeOfCab = typeOfCab;
    }

    @Override
    public String toString() {
        return "BookCab{" +
                "bookingId=" + bookingId +
                ", Name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fromLocation='" + fromLocation + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", typeOfCab='" + typeOfCab + '\'' +
                '}';
    }
}
