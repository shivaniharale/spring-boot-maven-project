package com.example.employeepayroll.mock;

import com.example.employeepayroll.dto.AddressDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Address;
import com.example.employeepayroll.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class MockForTest {


    public static List<EmployeeDTO> getMockEmployeeDtoList(){
        EmployeeDTO e=new EmployeeDTO("shivani","harale","1234567898","gmail",10531);
        EmployeeDTO e2=new EmployeeDTO("shivani","naik","23451234","yahoo",1232);

        List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
        list.add(e);
        list.add(e2);

        return list;
    }


    public static List<AddressDTO> getMockAddressDTOList(){
        AddressDTO z=new AddressDTO(1,"vineth engrove","gopalnagar","panjim","north goa","goa","403521");
        AddressDTO x=new AddressDTO(2,"vineth ","nagar","panjim","south goa","goa","403521");

        List<AddressDTO> mockList=new ArrayList<AddressDTO>();
        mockList.add(z);
        mockList.add(x);

        return mockList;

    }


    public static List<Address> getMockAddressList(){

        Address a=new Address(1,"vineth engrove","gopalnagar","panjim","north goa","goa","403521");
        Address b=new Address(2,"vineth ","nagar","panjim","south goa","goa","403521");

        List<Address> listPanjim=new ArrayList<>();
        listPanjim.add(a);
        listPanjim.add(b);

        return listPanjim;

    }



}
