package com.example.employeepayroll.service;

import com.example.employeepayroll.Converter.AddressConverter;
import com.example.employeepayroll.repository.AddressRepo;
import com.example.employeepayroll.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressConverter addressConverter;

    @Autowired
    private AddressRepo addressRepo;


    @Override
    public List<AddressDTO> getAddressByCity(String city) {
        try {
            return addressConverter.addressEntityToDTO(addressRepo.findByCity(city));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AddressDTO> getAddressByState(String state) {
        try {
            return addressConverter.addressEntityToDTO(addressRepo.findByState(state));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AddressDTO> getAddressByPinCode(String pinCode) {
        try {
            return addressConverter.addressEntityToDTO(addressRepo.findByPinCode(pinCode));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
