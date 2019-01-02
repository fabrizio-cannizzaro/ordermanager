package com.cs.order.manager.entity.view;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author fabrix
 */
public class ProcessedBookStatsPK implements Serializable {

	private Long bookId;
	private Boolean valid;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 83 * hash + Objects.hashCode(this.bookId);
		hash = 83 * hash + Objects.hashCode(this.valid);
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
		final ProcessedBookStatsPK other = (ProcessedBookStatsPK) obj;
		if (!Objects.equals(this.bookId, other.bookId)) {
			return false;
		}
		if (!Objects.equals(this.valid, other.valid)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProcessedBookStatsPK{" + "bookId=" + bookId + ", valid=" + valid + '}';
	}

}
