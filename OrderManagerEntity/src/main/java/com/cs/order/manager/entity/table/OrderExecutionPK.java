package com.cs.order.manager.entity.table;

import java.io.Serializable;
import java.util.Objects;

public class OrderExecutionPK implements Serializable {

	private Long financialOrder;

	private Long execution;

	public OrderExecutionPK() {
	}

	public OrderExecutionPK(Long financialOrder, Long execution) {
		this.financialOrder = financialOrder;
		this.execution = execution;
	}

	public Long getFinancialOrder() {
		return financialOrder;
	}

	public void setFinancialOrder(Long financialOrder) {
		this.financialOrder = financialOrder;
	}

	public Long getExecution() {
		return execution;
	}

	public void setExecution(Long execution) {
		this.execution = execution;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!Objects.equals(getClass(), obj.getClass())) {
			return false;
		}
		final OrderExecutionPK other = (OrderExecutionPK) obj;
		if (!java.util.Objects.equals(this.getFinancialOrder(), other.getFinancialOrder())) {
			return false;
		}
		if (!java.util.Objects.equals(this.getExecution(), other.getExecution())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + Objects.hashCode(this.getFinancialOrder());
		hash = 31 * hash + Objects.hashCode(this.getExecution());
		return hash;
	}

	@Override
	public String toString() {
		return "OrderExecutionPK{" + " financialOrder=" + financialOrder + ", execution=" + execution + '}';
	}

}