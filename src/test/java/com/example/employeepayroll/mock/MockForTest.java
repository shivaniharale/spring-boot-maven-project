package com.example.employeepayroll.mock;

import com.example.employeepayroll.dto.AddressDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Address;
import java.util.ArrayList;
import java.util.List;

public class MockForTest {

    public static Address getAddress(){

        Address address=new Address();
        address.setCity("porvorim");
        address.setPinCode("123456");
        address.setState("goa");

        return address;
    }

    public static List<EmployeeDTO> getMockEmployeeDtoList(){
        EmployeeDTO e=new EmployeeDTO(1,"shivani","harale","989866658","hhh@gmail",76657);
        EmployeeDTO e2=new EmployeeDTO(1,"shivani","naik","985666645","snn@yahoo",98968);

        List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
        list.add(e);
        list.add(e2);

        return list;
    }

    public static List<AddressDTO> getMockAddressDTOList(){
        AddressDTO z=new AddressDTO("vineth engrove","gopalnagar","panjim","north goa","goa","403521");
        AddressDTO x=new AddressDTO("vineth ","nagar","panjim","south goa","goa","403521");

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
