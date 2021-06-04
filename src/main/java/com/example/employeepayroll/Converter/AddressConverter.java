package com.example.employeepayroll.Converter;

import com.example.employeepayroll.dto.AddressDTO;
import com.example.employeepayroll.entity.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {

    public AddressDTO addressEntityToDTO(Address address) {

        AddressDTO dto=new AddressDTO();
        dto.setHouseNumber(address.getHouseNumber());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setDistrict(address.getDistrict());
        dto.setState(address.getState());
        dto.setPinCode(address.getPinCode());

        return dto;
    }


    public List<AddressDTO> addressEntityToDTO(List<Address> addresses) {

        return addresses.stream().map(x->addressEntityToDTO(x)).collect(Collectors.toList());

    }


    public Address addressDtoToEntity(AddressDTO dto) {

        Address address=new Address();
        address.setHouseNumber(dto.getHouseNumber());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setDistrict(dto.getDistrict());
        address.setState(dto.getState());
        address.setPinCode(dto.getPinCode());

        return address;

    }

    public List<Address> addressDtoToEntity(List<AddressDTO> dtos) {

        return dtos.stream().map(x->addressDtoToEntity(x)).collect(Collectors.toList());

    }

}
