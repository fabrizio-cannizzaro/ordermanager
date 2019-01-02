package com.cs.order.manager.dto.inner;

/**
 *
 * @author fabrix
 */
public class LimitedDemand {

	private long limitPrice;
	private long demand;

	public LimitedDemand() {
	}

	public LimitedDemand(long limitPrice, long demand) {
		this.limitPrice = limitPrice;
		this.demand = demand;
	}

	public long getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(long limitPrice) {
		this.limitPrice = limitPrice;
	}

	public long getDemand() {
		return demand;
	}

	public void setDemand(long demand) {
		this.demand = demand;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 79 * hash + (int) (this.limitPrice ^ (this.limitPrice >>> 32));
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final LimitedDemand other = (LimitedDemand) obj;
		if (this.limitPrice != other.limitPrice) {
			return false;
		}
		return true;
	}

}
