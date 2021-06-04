package com.example.employeepayroll.service;

import com.example.employeepayroll.dao.AddressDAO;
import com.example.employeepayroll.entity.Address;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class AddressServiceImplTest {

    @InjectMocks
    AddressService addressService;

    @Mock
    AddressDAO addressDAO;

    @Test
    void getAddressByCity() {

        Address a=new Address(1,"vineth engrove","gopalnagar","panjim","north goa","goa","403521");
        Address b=new Address(1,"vineth ","nagar","panjim","south goa","goa","403321");

        List<Address> listPanjim=new ArrayList<>();
        listPanjim.add(a);
        listPanjim.add(b);

        when(addressDAO.findByCity("panjim")).thenReturn(listPanjim);
        assertEquals(listPanjim,addressDAO.findByCity("panjim"));

        when(addressDAO.findByCity("mumbai")).thenThrow(new NullPointerException("Not found")) ;

        addressDAO.findByCity("mumbai");

    }

    @Test
    void getAddressByState() {
        Address a=new Address(1,"vineth engrove","gopalnagar","panjim","north goa","goa","403521");
        Address b=new Address(1,"vineth ","nagar","panjim","south goa","goa","403321");

        List<Address> listGoa=new ArrayList<>();
        listGoa.add(a);
        listGoa.add(b);

        when(addressDAO.findByCity("goa")).thenReturn(listGoa);
        assertEquals(listGoa,addressDAO.findByCity("goa"));
    }

    @Test
    void getAddressByPinCode() {

        Address a=new Address(1,"vineth engrove","gopalnagar","panjim","north goa","goa","403521");
        Address b=new Address(1,"vineth ","nagar","panjim","south goa","goa","403321");

        List<Address> listGoa=new ArrayList<>();
        listGoa.add(a);
        listGoa.add(b);

        List<Address> listPin=new ArrayList<>();

        listPin.add(a);
        when(addressDAO.findByPinCode("403521")).thenReturn(listPin);
        assertEquals(listGoa,addressDAO.findByPinCode("403521"));


    }
}