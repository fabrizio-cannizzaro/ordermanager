package com.cs.order.manager.entity.table;

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
public class Execution {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;

	@Basic
	@Column(nullable = false)
	@NotNull
	private long price;

	@Basic(optional = false)
	@Column(nullable = false)
	@NotNull
	private long quantity;

	@ManyToOne
	private Book book;

	@OneToMany(mappedBy = "execution", cascade = CascadeType.ALL)
	private List<OrderExecution> orderExecutions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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
		orderExecution.setExecution(this);
	}

	public void removeOrderExecution(OrderExecution orderExecution) {
		getOrderExecutions().remove(orderExecution);
		orderExecution.setExecution(null);
	}

}