package com.example.addressservice.service;

import com.example.addressservice.entity.Address;
import com.example.addressservice.repository.AddressRepo;
import com.example.addressservice.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper mapper;

    public AddressResponse findAddressByEmployeeId(int employeeId) {
        Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);
        AddressResponse addressResponse = mapper.map(addressByEmployeeId, AddressResponse.class);
        return addressResponse;
    }

    public AddressResponse createAddress(AddressResponse addressResponse) {
        // Implementation to create a new address
        // Replace this with your actual implementation
        AddressResponse createdAddress = addressResponse;
        createdAddress.setId(addressResponse.getId());
        createdAddress.setCity(addressResponse.getCity());
        createdAddress.setState(addressResponse.getState());
        // Populate createdAddress based on the addressRequest
        return createdAddress;
    }

}

