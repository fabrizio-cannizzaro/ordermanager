package com.cs.order.manager.entity.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author fabrix
 */
@Entity
@Table(name = "BOOK_STATS")
public class BookStats implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "BOOK_ID")
	private Long bookId;
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

	public BookStats() {
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
	
}
