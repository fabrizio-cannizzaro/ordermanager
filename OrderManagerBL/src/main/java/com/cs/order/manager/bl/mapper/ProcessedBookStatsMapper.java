package com.cs.order.manager.bl.mapper;

import com.cs.order.manager.dto.inner.LimitedDemand;
import com.cs.order.manager.dto.inner.ProcessedBookStatsDto;
import com.cs.order.manager.entity.view.ProcessedBookStats;
import java.util.List;

public class ProcessedBookStatsMapper  {

	public static ProcessedBookStatsDto map(ProcessedBookStats processedBookStats, List<LimitedDemand> demands) {
		ProcessedBookStatsDto pbsd = new ProcessedBookStatsDto();
		pbsd.setBiggest(processedBookStats.getBiggest());
		pbsd.setBookId(processedBookStats.getBookId());
		pbsd.setDemand(processedBookStats.getDemand());
		pbsd.setEarliest(processedBookStats.getEarliest());
		pbsd.setInstrument(processedBookStats.getInstrument());
		pbsd.setLatest(processedBookStats.getLatest());
		pbsd.setLimitedDemands(demands);
		pbsd.setSmallest(processedBookStats.getSmallest());
		pbsd.setExecutionQuantity(processedBookStats.getExecutionQuantity());
		pbsd.setPrice(processedBookStats.getPrice());
		pbsd.setValid(processedBookStats.getValid());
		return pbsd;
	}


	
}
