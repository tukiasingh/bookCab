package com.example.bookcab.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "cabFare", url = "http://localhost:8282")

public interface CabFareProxy {

    @RequestMapping(method = RequestMethod.GET, value="/cab/all")
    public List<String> allCabs();

    @RequestMapping(method = RequestMethod.GET, value="/cab/findCabFareByType/{typeOfCab}")
    public List<Double> findCabFareByType(@PathVariable("typeOfCab") String typeOfCab);
}
