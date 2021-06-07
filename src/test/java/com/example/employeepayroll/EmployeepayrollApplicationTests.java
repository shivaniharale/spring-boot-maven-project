package com.example.employeepayroll;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes =EmployeepayrollApplication.class )
//@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
class EmployeepayrollApplicationTests {

	@Test
	void contextLoads() {
	}

}
