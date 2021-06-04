package com.example.employeepayroll.service;

import com.example.employeepayroll.Converter.AddressConverter;
import com.example.employeepayroll.dao.AddressDAO;
import com.example.employeepayroll.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressConverter addressConverter;

    @Autowired
    private AddressDAO addressDAO;


    @Override
    public List<AddressDTO> getAddressByCity(String city) {
        try {
            return addressConverter.addressEntityToDTO(addressDAO.findByCity(city));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AddressDTO> getAddressByState(String state) {
        try {
            return addressConverter.addressEntityToDTO(addressDAO.findByState(state));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AddressDTO> getAddressByPinCode(String pinCode) {
        try {
            return addressConverter.addressEntityToDTO(addressDAO.findByPinCode(pinCode));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
