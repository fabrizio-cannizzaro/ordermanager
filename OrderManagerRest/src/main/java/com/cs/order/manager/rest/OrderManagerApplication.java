/**
 *
 * @author fabrix
 */
package com.cs.order.manager.rest;

import com.cs.order.manager.entity.table.Book;
import com.cs.order.manager.entity.view.BookStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ImportResource(value="classpath:/hsql.xml")
@EntityScan(basePackageClasses = {Book.class, BookStats.class})
@ComponentScan(basePackages = "com.cs.order.manager")
@EnableJpaRepositories(basePackages={"com.cs.order.manager.dao"})
@SpringBootApplication
public class OrderManagerApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderManagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderManagerApplication.class, args);
		LOGGER.info("App started");
	}

}
