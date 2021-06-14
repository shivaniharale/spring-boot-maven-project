package com.example.employeepayroll.rest;

import com.example.employeepayroll.dto.AddressDTO;
import com.example.employeepayroll.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressController addressController;

    @GetMapping("/city/{city}")
    public List<AddressDTO> getAddressByCity(@PathVariable String city) {
        try {
            return addressService.getAddressByCity(city);
        } catch (Exception e) {
            System.out.println("Address not found" + e.toString());
            return null;
        }
    }

    @GetMapping("/state/{state}")
    public List<AddressDTO> getAddressByState(@PathVariable String state) {
        try {
            return addressService.getAddressByState(state);
        } catch (Exception e) {
            System.out.println("Address not found" + e.toString());
            return null;
        }
    }

    @GetMapping("/pinCode/{pinCode}")
    public List<AddressDTO> getAddressByPinCode(@PathVariable String pinCode) {
        try {
            return addressService.getAddressByPinCode(pinCode);
        } catch (Exception e) {
            System.out.println("Address not found" + e.toString());
            return null;
        }
    }


}
