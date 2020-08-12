package com.cs.order.manager.dto;

import com.cs.order.manager.dto.inner.FinancialOrderDto;

/**
 *
 * @author fabrix
 */
public class FinancialOrderResponse {

	private FinancialOrderDto financialOrderDto;

	public FinancialOrderResponse() {
	}

	public FinancialOrderResponse(FinancialOrderDto financialOrderDto) {
		this.financialOrderDto = financialOrderDto;
	}

	public FinancialOrderDto getFinancialOrderDto() {
		return financialOrderDto;
	}

	@Override
	public String toString() {
		return "FinancialOrderResponse{" +
			"financialOrderDto=" + financialOrderDto +
			'}';
	}
}
