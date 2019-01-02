package com.cs.order.manager.entity.table;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * @author fabrix
 */

@Entity
public class Book {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;

	@Basic
	@Column(nullable = false)
	private boolean opened;

	@Basic(optional = false)
	@Column(nullable = false)
	@NotNull
	private boolean executed = false;

	@OneToOne(optional = false)
	@NotNull
	private Instrument instrument;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<FinancialOrder> financialOrders;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<Execution> executions;

	public Book() {
	}

	public Book(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public List<FinancialOrder> getFinancialOrders() {
		if (financialOrders == null) {
			financialOrders = new ArrayList<>();
		}
		return financialOrders;
	}

	public void setFinancialOrders(List<FinancialOrder> financialOrders) {
		this.financialOrders = financialOrders;
	}

	public void addFinancialOrder(FinancialOrder financialOrder) {
		getFinancialOrders().add(financialOrder);
		financialOrder.setBook(this);
	}

	public void removeFinancialOrder(FinancialOrder financialOrder) {
		getFinancialOrders().remove(financialOrder);
		financialOrder.setBook(null);
	}

	public List<Execution> getExecutions() {
		if (executions == null) {
			executions = new ArrayList<>();
		}
		return executions;
	}

	public void setExecutions(List<Execution> executions) {
		this.executions = executions;
	}

	public void addExecution(Execution execution) {
		getExecutions().add(execution);
		execution.setBook(this);
	}

	public void removeExecution(Execution execution) {
		getExecutions().remove(execution);
		execution.setBook(null);
	}

}