package com.cs.order.manager.bl.mapper;

import com.cs.order.manager.dto.inner.BookStatsDto;
import com.cs.order.manager.dto.inner.LimitedDemand;
import com.cs.order.manager.entity.view.BookStats;

import java.util.List;

/**
 *
 * @author fabrix
 */
public class BookStatsMapper {

	public static BookStatsDto map(BookStats bookStats, List<LimitedDemand> demands) {
		BookStatsDto bsd = new BookStatsDto();
		bsd.setBiggest(bookStats.getBiggest());
		bsd.setBookId(bookStats.getBookId());
		bsd.setDemand(bookStats.getDemand());
		bsd.setEarliest(bookStats.getEarliest());
		bsd.setInstrument(bookStats.getInstrument());
		bsd.setLatest(bookStats.getLatest());
		bsd.setLimitedDemands(demands);
		bsd.setSmallest(bookStats.getSmallest());
		return bsd;
	}

}
