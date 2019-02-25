package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Web based Application to crawl and web application and display the internal links, 
 * external links, static content and other resource
 * 
 * @author rv
 *
 */
@SpringBootApplication
public class SpringBootCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrawlerApplication.class, args);
	}

}
