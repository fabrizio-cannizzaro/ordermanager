package com.cs.order.manager.dto;

import com.cs.order.manager.dto.inner.BookStatsDto;
import java.util.List;

/**
 *
 * @author fabrix
 */
public class BookStatsResponse {

	private List<BookStatsDto> bookStatsDtos;

	public BookStatsResponse() {
	}

	public BookStatsResponse(List<BookStatsDto> bookStatsDtos) {
		this.bookStatsDtos = bookStatsDtos;
	}

	public List<BookStatsDto> getBookStatsDtos() {
		return bookStatsDtos;
	}

	public void setBookStatsDtos(List<BookStatsDto> bookStatsDtos) {
		this.bookStatsDtos = bookStatsDtos;
	}

}
