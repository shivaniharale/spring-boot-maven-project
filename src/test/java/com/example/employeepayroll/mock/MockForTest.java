package com.example.employeepayroll.mock;

import com.example.employeepayroll.dto.AddressDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Address;
import com.example.employeepayroll.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MockForTest {

    private static String getTablesFromSchemaQuery="SELECT table_name FROM information_schema.tables WHERE table_schema = SCHEMA()";


    public static Employee getEmployee(){

        Employee e=new Employee();
        e.setId(1);
        e.setFirstName("sg");
        e.setLastName("harale");
        e.setPhone("909348566");
        e.setEmail("saga@yahoo.com");
        e.setPost("developer");
        e.setSalary(10987);
        e.setEmployeeNumber(77383);
        e.setAddress(getAddress());

        return e;

    }

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

    public static AuthenticationVM generateAuthenticationVM() {
        AuthenticationVM authenticationVM=new AuthenticationVM();
        authenticationVM.setUser("shivani");
        authenticationVM.setPass("$2a$10$4Xn3EM4w9GtoO6qyySRwse2uLqMrLephkg1T4NTde6EWX726aCB/C");

        return authenticationVM;
    }

    public static void clearDB(JdbcTemplate jdbcTemplate){
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        jdbcTemplate.execute("Use employee_payroll");
//        jdbcTemplate.query(getTablesFromSchemaQuery, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet rs) throws SQLException {
//                jdbcTemplate.execute("truncate table employee_payroll."+rs.getString(1));
////                jdbcTemplate.execute("truncate table employee_payroll.address"+rs.getString(1));
//
//            }
//        });
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");

    }

}
