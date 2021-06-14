package com.example.employeepayroll.service;

import com.example.employeepayroll.Converter.AddressConverter;
import com.example.employeepayroll.repository.AddressRepo;
import com.example.employeepayroll.dto.AddressDTO;
import com.example.employeepayroll.mock.MockForTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
class AddressServiceImplTest {

    private final Logger log = LoggerFactory.getLogger(AddressServiceImplTest.class);

    @BeforeEach
    public void init() {
        initMocks(this);
    }

    @InjectMocks
    AddressServiceImpl addressServiceImpl;

    @Mock
    AddressRepo addressRepo;

    @Mock
    AddressConverter addressConverter;

    List<AddressDTO> list=new ArrayList<AddressDTO>();

    AddressDTO z=new AddressDTO("vineth engrove","gopalnagar","panjim","north goa","goa","403521");
    AddressDTO x=new AddressDTO("vineth ","nagar","panjim","south goa","goa","403521");

    List<AddressDTO> mockList=new ArrayList<AddressDTO>();


    @Test

    void getAddressByCity() {

        mockList.add(z);
        mockList.add(x);

        Mockito.when(addressConverter.addressEntityToDTO(addressRepo.findByCity(any()))).thenReturn(MockForTest.getMockAddressDTOList());

        list=addressServiceImpl.getAddressByCity(any());

        Assert.assertEquals(mockList.get(0).getCity(),list.get(0).getCity());
        Assert.assertEquals(mockList.get(1).getCity(),list.get(1).getCity());


        Assert.assertNotNull(list);
    }

    @Test
    void getAddressByState() {
        mockList.add(z);
        mockList.add(x);

        Mockito.when(addressConverter.addressEntityToDTO(addressRepo.findByState(any()))).thenReturn(MockForTest.getMockAddressDTOList());

        list=addressServiceImpl.getAddressByState(any());

        Assert.assertEquals(mockList.get(0).getCity(),list.get(0).getCity());
        Assert.assertEquals(mockList.get(1).getCity(),list.get(1).getCity());



    }

}