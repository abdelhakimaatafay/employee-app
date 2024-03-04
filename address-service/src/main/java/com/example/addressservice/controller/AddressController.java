package com.example.addressservice.controller;

import com.example.addressservice.entity.Address;
import com.example.addressservice.response.AddressResponse;
import com.example.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId) {
        AddressResponse addressResponse = addressService.findAddressByEmployeeId(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @PostMapping("/create-address")
    public ResponseEntity<AddressResponse> postAddress(@RequestBody AddressResponse addressResponse){
        AddressResponse createdAddress = addressService.createAddress(addressResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

}

