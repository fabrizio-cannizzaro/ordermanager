package com.cs.order.manager.entity.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author fabrix
 */
@Entity
@IdClass(ProcessedBookStatsPK.class)
@Table(name = "PROCESSED_BOOK_STATS")
public class ProcessedBookStats implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "BOOK_ID")
	private Long bookId;
	@Id
	@Column(name = "VALID")
	private Boolean valid;
	@Size(max = 255)
	@Column(name = "INSTRUMENT")
	private String instrument;
	@Column(name = "DEMAND")
	private Long demand;
	@Column(name = "BIGGEST")
	private Long biggest;
	@Column(name = "SMALLEST")
	private Long smallest;
	@Column(name = "EARLIEST")
	@Temporal(TemporalType.DATE)
	private Date earliest;
	@Column(name = "LATEST")
	@Temporal(TemporalType.DATE)
	private Date latest;
	@Column(name = "EXECUTION_QUANTITY")
	private Long executionQuantity;
	@Column(name = "PRICE")
	private Long price;

	public ProcessedBookStats() {
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public Long getDemand() {
		return demand;
	}

	public void setDemand(Long demand) {
		this.demand = demand;
	}

	public Long getBiggest() {
		return biggest;
	}

	public void setBiggest(Long biggest) {
		this.biggest = biggest;
	}

	public Long getSmallest() {
		return smallest;
	}

	public void setSmallest(Long smallest) {
		this.smallest = smallest;
	}

	public Date getEarliest() {
		return earliest;
	}

	public void setEarliest(Date earliest) {
		this.earliest = earliest;
	}

	public Date getLatest() {
		return latest;
	}

	public void setLatest(Date latest) {
		this.latest = latest;
	}

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

}
