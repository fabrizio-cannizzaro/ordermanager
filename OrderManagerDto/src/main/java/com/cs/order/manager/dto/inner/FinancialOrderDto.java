package com.cs.order.manager.dto.inner;

/**
 *
 * @author fabrix
 */
public class FinancialOrderDto {

	private Long id;
	private boolean valid;
	private Long limitPrice;
	private Long executionQuantity;
	private Long executionPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Long getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(Long limitPrice) {
		this.limitPrice = limitPrice;
	}

	public Long getExecutionQuantity() {
		return executionQuantity;
	}

	public void setExecutionQuantity(Long executionQuantity) {
		this.executionQuantity = executionQuantity;
	}

	public Long getExecutionPrice() {
		return executionPrice;
	}

	public void setExecutionPrice(Long executionPrice) {
		this.executionPrice = executionPrice;
	}
}
