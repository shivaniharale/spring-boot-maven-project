package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> getAddressByCity(String city);

    List<AddressDTO> getAddressByState(String state);

    List<AddressDTO> getAddressByPinCode(String pinCode);

}
