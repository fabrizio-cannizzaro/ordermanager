package com.cs.order.manager.entity.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author fabrix
 */

@Entity
public class Instrument {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	@NotNull
	private Long id;

	@Basic
	@Column(unique = true, nullable = false)
	private String name;

	public Instrument() {
	}

	public Instrument(Long id) {
		this.id = id;
	}

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

}