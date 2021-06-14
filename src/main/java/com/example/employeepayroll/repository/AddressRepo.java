package com.example.employeepayroll.repository;

import com.example.employeepayroll.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {

    List<Address> findByCity(String city);

    List<Address> findByState(String state);

    List<Address> findByPinCode(String pinCode);

}
