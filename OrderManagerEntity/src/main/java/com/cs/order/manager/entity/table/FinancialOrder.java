package com.cs.order.manager.entity.table;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author fabrix
 */
@Entity
public class FinancialOrder {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;

	@Basic
	@Column(nullable = false)
	private long quantity;

	@Basic
	@Column(nullable = false)
	private Date entryDate;

	@Basic
	private Long limitPrice;

	@Basic
	private boolean valid;

	@ManyToOne(optional = false)
	@NotNull
	private Investor investor;

	@ManyToOne
	private Book book;

	@ManyToOne(optional = false)
	@NotNull
	private Instrument instrument;

	@OneToMany(mappedBy = "financialOrder", cascade = CascadeType.ALL)
	private List<OrderExecution> orderExecutions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Long getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(Long limitPrice) {
		this.limitPrice = limitPrice;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public List<OrderExecution> getOrderExecutions() {
		if (orderExecutions == null) {
			orderExecutions = new ArrayList<>();
		}
		return orderExecutions;
	}

	public void setOrderExecutions(List<OrderExecution> orderExecutions) {
		this.orderExecutions = orderExecutions;
	}

	public void addOrderExecution(OrderExecution orderExecution) {
		getOrderExecutions().add(orderExecution);
		orderExecution.setFinancialOrder(this);
	}

	public void removeOrderExecution(OrderExecution orderExecution) {
		getOrderExecutions().remove(orderExecution);
		orderExecution.setFinancialOrder(null);
	}

	public long getExecutedQuantity() {
		return this.orderExecutions.stream().mapToLong(OrderExecution::getQuantity).sum();
	}

	public boolean isFullExecuted() {
		return this.getExecutedQuantity() == this.getQuantity();
	}

	public long getExecutingQuantity() {
		return this.getQuantity() - this.getExecutedQuantity();
	}

	// TODO this is valid only when there is only one execution for order.
	public Long getExecutionPrice() {
		List<OrderExecution> executions = this.getOrderExecutions();
		return executions.isEmpty() ? null : executions.get(0).getExecution().getPrice();
	}

}
