package com.cs.order.manager.entity.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author fabrix
 */

@Entity
@IdClass(OrderExecutionPK.class)
public class OrderExecution {

	@Basic
	@Column(nullable = false)
	private long quantity;

	@Id
	@ManyToOne(optional = false)
	@NotNull
	private FinancialOrder financialOrder;

	@Id
	@ManyToOne(optional = false)
	@NotNull
	private Execution execution;

	public OrderExecution() {
	}

	public OrderExecution(long quantity, FinancialOrder financialOrder, Execution execution) {
		this.quantity = quantity;
		this.financialOrder = financialOrder;
		this.execution = execution;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public FinancialOrder getFinancialOrder() {
		return financialOrder;
	}

	public void setFinancialOrder(FinancialOrder financialOrder) {
		this.financialOrder = financialOrder;
	}

	public Execution getExecution() {
		return execution;
	}

	public void setExecution(Execution execution) {
		this.execution = execution;
	}

}