package com.example;

import com.brownfield.pss.book.Application;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


	@Test
	public void contextLoads() {
	}

}
