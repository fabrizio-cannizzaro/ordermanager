package com.cs.order.manager.dto.inner;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fabrix
 */
public class BookStatsDto implements Serializable {

	private Long bookId;
	private String instrument;
	private Long demand;
	private Long biggest;
	private Long smallest;
	private Date earliest;
	private Date latest;
	private List<LimitedDemand> limitedDemands;

	public BookStatsDto() {
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

	public List<LimitedDemand> getLimitedDemands() {
		return limitedDemands;
	}

	public void setLimitedDemands(List<LimitedDemand> limitedDemands) {
		this.limitedDemands = limitedDemands;
	}

	@Override
	public String toString() {
		return "BookStatsDto{" +
			"bookId=" + bookId +
			", instrument='" + instrument + '\'' +
			", demand=" + demand +
			", biggest=" + biggest +
			", smallest=" + smallest +
			", earliest=" + earliest +
			", latest=" + latest +
			", limitedDemands=" + limitedDemands +
			'}';
	}
}
