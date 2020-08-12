package com.cs.order.manager.dto.inner;

/**
 * @author fabrix
 */
public class ProcessedBookStatsDto extends BookStatsDto {

	private Boolean valid;
	private Long executionQuantity;
	private Long price;

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public Long getExecutionQuantity() {
		return executionQuantity;
	}

	public void setExecutionQuantity(Long executionQuantity) {
		this.executionQuantity = executionQuantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProcessedBookStatsDto{" +
			"valid=" + valid +
			", executionQuantity=" + executionQuantity +
			", price=" + price +
			'}';
	}
}
