package com.cs.order.manager.rest.controller;

import com.cs.order.manager.bl.BookService;
import com.cs.order.manager.bl.StatisticalService;
import com.cs.order.manager.dto.BookRequest;
import com.cs.order.manager.dto.BookStatsResponse;
import com.cs.order.manager.dto.FinancialOrderResponse;
import com.cs.order.manager.dto.ProcessedBookStatsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fabrix
 */
@Controller
public class OrderManagerController {

	private final BookService bookService;

	private final StatisticalService statisticalService;

	public OrderManagerController(BookService bookService, StatisticalService statisticalService) {
		this.bookService = bookService;
		this.statisticalService = statisticalService;
	}

	@PostMapping("/open-book")
	@ResponseBody
	public void openBook(@RequestBody BookRequest bookRequest) {
		this.bookService.openBook(bookRequest.getInstrumentId());
	}

	@PostMapping("/close-book")
	@ResponseBody
	public void closeBook(@RequestBody BookRequest bookRequest) {
		this.bookService.closeBook(bookRequest.getInstrumentId());
	}

	@GetMapping("/fetch-statistics")
	@ResponseBody
	public BookStatsResponse fetchStatistics() {
		return this.statisticalService.fetchStatistics();
	}

	@GetMapping("/fetch-processed-statistics")
	@ResponseBody
	public ProcessedBookStatsResponse fetchProcessedStatistics() {
		return this.statisticalService.fetchProcessedStatistics();
	}

	@GetMapping("/fetch-order")
	@ResponseBody
	public FinancialOrderResponse fetchOrder(@RequestParam(name = "id") long id) {
		return this.statisticalService.findOrder(id);
	}

}
