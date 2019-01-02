package com.cs.order.manager.bl;

import com.cs.order.manager.bl.mapper.BookStatsMapper;
import com.cs.order.manager.bl.mapper.FinancialOrderMapper;
import com.cs.order.manager.bl.mapper.ProcessedBookStatsMapper;
import com.cs.order.manager.dao.BookStatsRepository;
import com.cs.order.manager.dao.FinancialOrderRepository;
import com.cs.order.manager.dao.ProcessedBookStatsRepository;
import com.cs.order.manager.dto.BookStatsResponse;
import com.cs.order.manager.dto.FinancialOrderResponse;
import com.cs.order.manager.dto.ProcessedBookStatsResponse;
import com.cs.order.manager.dto.inner.BookStatsDto;
import com.cs.order.manager.dto.inner.LimitedDemand;
import com.cs.order.manager.dto.inner.ProcessedBookStatsDto;
import com.cs.order.manager.entity.table.Book;
import com.cs.order.manager.entity.table.FinancialOrder;
import com.cs.order.manager.entity.view.BookStats;
import com.cs.order.manager.entity.view.ProcessedBookStats;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabrix
 */
@Service
public class StatisticalService {

	@Autowired
	private FinancialOrderRepository financialOrderRepository;
	@Autowired
	private BookStatsRepository bookStatsRepository;
	@Autowired
	private ProcessedBookStatsRepository processedBookStatsRepository;

	public BookStatsResponse fetchStatistics() {
		List<BookStatsDto> bookStatsDtos = new ArrayList<>();
		Iterable<BookStats> bookStatses = this.bookStatsRepository.findAll();
		bookStatses.forEach(bs -> {
			List<FinancialOrder> financialOrders = this.financialOrderRepository.findByBookAndLimitPriceNotNullOrderByLimitPriceDesc(new Book(bs.getBookId()));
			List<LimitedDemand> limitedDemands = buildBreakDownTable(financialOrders);
			bookStatsDtos.add(BookStatsMapper.map(bs, limitedDemands));
		});
		return new BookStatsResponse(bookStatsDtos);
	}

	public ProcessedBookStatsResponse fetchProcessedStatistics() {
		List<ProcessedBookStatsDto> processedBookStatsDtos = new ArrayList<>();
		Iterable<ProcessedBookStats> processedBookStatses = this.processedBookStatsRepository.findAll();
		processedBookStatses.forEach(pbs -> {
			List<FinancialOrder> financialOrders = this.financialOrderRepository.findByBookAndValidAndLimitPriceNotNullOrderByLimitPriceDesc(new Book(pbs.getBookId()), pbs.getValid());
			List<LimitedDemand> limitedDemands = buildBreakDownTable(financialOrders);
			processedBookStatsDtos.add(ProcessedBookStatsMapper.map(pbs, limitedDemands));
		});
		return new ProcessedBookStatsResponse(processedBookStatsDtos);
	}

	public FinancialOrderResponse findOrder(long id) {
		Optional<FinancialOrder> fo = this.financialOrderRepository.findById(id);
		return fo.isPresent() ? new FinancialOrderResponse(FinancialOrderMapper.map(fo.get())) : new FinancialOrderResponse();
	}

	private List<LimitedDemand> buildBreakDownTable(List<FinancialOrder> financialOrders) {
		List<LimitedDemand> limitedDemands = new ArrayList<>();
		financialOrders.forEach(fo -> {
			long limitPrice = fo.getLimitPrice();
			long demand = financialOrders.stream().filter(fo1 -> fo1.getLimitPrice() >= limitPrice).mapToLong(FinancialOrder::getQuantity).sum();
			LimitedDemand ld = new LimitedDemand(limitPrice, demand);
			if (!limitedDemands.contains(ld)) {
				limitedDemands.add(ld);
			}
		});
		return limitedDemands;
	}

}
