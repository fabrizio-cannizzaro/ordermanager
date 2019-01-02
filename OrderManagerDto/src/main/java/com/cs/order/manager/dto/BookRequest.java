package com.cs.order.manager.dto;

/**
 *
 * @author fabrix
 */
public class BookRequest {

	private Long instrumentId;

	public BookRequest() {
	}

	public BookRequest(Long instrumentId) {
		this.instrumentId = instrumentId;
	}

	public Long getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(Long instrumentId) {
		this.instrumentId = instrumentId;
	}

	@Override
	public String toString() {
		return "BookRequest{" + "instrumentId=" + instrumentId + '}';
	}

}
