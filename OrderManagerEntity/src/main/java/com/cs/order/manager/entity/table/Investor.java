package com.cs.order.manager.entity.table;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author fabrix
 */

@Entity
public class Investor {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;

	@Basic
	@Column(unique = true, nullable = false)
	@NotNull
	private String name;

	@OneToMany(mappedBy = "investor")
	private List<FinancialOrder> financialOrders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		financialOrder.setInvestor(this);
	}

	public void removeFinancialOrder(FinancialOrder financialOrder) {
		getFinancialOrders().remove(financialOrder);
		financialOrder.setInvestor(null);
	}

}