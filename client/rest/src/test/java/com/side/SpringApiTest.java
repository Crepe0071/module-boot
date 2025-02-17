package com.side;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = {SpringApiTestConfiguration.class})
@SpringBootTest
public @interface SpringApiTest {
}

@ComponentScan
@EnableAutoConfiguration
class SpringApiTestConfiguration {
}