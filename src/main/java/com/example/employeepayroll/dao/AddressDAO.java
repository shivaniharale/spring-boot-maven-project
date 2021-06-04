package com.example.employeepayroll.dao;

import com.example.employeepayroll.dto.AddressDTO;
import com.example.employeepayroll.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDAO extends JpaRepository<Address,Integer> {

    List<Address> findByCity(String city);

    List<Address> findByState(String state);

    List<Address> findByPinCode(String pinCode);

}
