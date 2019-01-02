package com.cs.order.manager.rest.controller;

import com.cs.order.manager.dto.BookRequest;
import com.cs.order.manager.dto.BookStatsResponse;
import com.cs.order.manager.dto.FinancialOrderResponse;
import com.cs.order.manager.dto.ProcessedBookStatsResponse;
import com.cs.order.manager.rest.OrderManagerApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author fabrix
 */
//TODO put assertions
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderManagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrderManagerControllerIT {

	@LocalServerPort
	private int port;

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private TestRestTemplate restTemplate;

	private static HttpHeaders headers;

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@BeforeClass
	public static void setUp() {
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	}

	/**
	 * Test of openBook method, of class OrderManagerController.
	 *
	 * @throws com.fasterxml.jackson.core.JsonProcessingException
	 */
	@Test
	public void testAOpenBook() throws JsonProcessingException {
		System.out.println("testOpenBook");
		BookRequest bookRequest = new BookRequest(1L);
		HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(bookRequest), headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/open-book"), HttpMethod.POST, entity, String.class);
	}

	/**
	 * Test of closeBook method, of class OrderManagerController.
	 *
	 * @throws com.fasterxml.jackson.core.JsonProcessingException
	 */
	@Test
	public void testBCloseBook() throws JsonProcessingException {
		System.out.println("testCloseBook");
		BookRequest bookRequest = new BookRequest(1L);
		HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(bookRequest), headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/close-book"), HttpMethod.POST, entity, String.class);
	}

	/**
	 * Test of fetchStatistics method, of class OrderManagerController.
	 *
	 * @throws java.io.IOException
	 */
	@Test
	public void testCFetchStatistics() throws IOException {
		System.out.println("fetchStatistics");
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/fetch-statistics"), HttpMethod.GET, entity, String.class);
		BookStatsResponse r = objectMapper.readValue(response.getBody(), BookStatsResponse.class);
	}

	/**
	 * Test of fetchProcessedStatistics method, of class OrderManagerController.
	 *
	 * @throws java.io.IOException
	 */
	@Test
	public void testDFetchProcessedStatistics() throws IOException {
		System.out.println("fetchProcessedStatistics");
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/fetch-processed-statistics"), HttpMethod.GET, entity, String.class);
		ProcessedBookStatsResponse r = objectMapper.readValue(response.getBody(), ProcessedBookStatsResponse.class);
	}

	/**
	 * Test of fetchProcessedStatistics method, of class OrderManagerController.
	 *
	 * @throws java.io.IOException
	 */
	@Test
	public void testFFetchOrder() throws IOException {
		System.out.println("fetchProcessedStatistics");
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/fetch-order?id=1"), HttpMethod.GET, entity, String.class);
		FinancialOrderResponse r = objectMapper.readValue(response.getBody(), FinancialOrderResponse.class);
	}
}
