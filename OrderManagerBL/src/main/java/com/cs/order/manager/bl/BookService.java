package com.cs.order.manager.bl;

import com.cs.order.manager.bl.generator.OrderGenerator;
import com.cs.order.manager.dao.BookRepository;
import com.cs.order.manager.dao.InvestorRepository;
import com.cs.order.manager.entity.table.Book;
import com.cs.order.manager.entity.table.Execution;
import com.cs.order.manager.entity.table.FinancialOrder;
import com.cs.order.manager.entity.table.Instrument;
import com.cs.order.manager.entity.table.Investor;
import com.cs.order.manager.entity.table.OrderExecution;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fabrix
 */
@Transactional
@Service
public class BookService {

	@Autowired
	private OrderGenerator orderGenerator;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private InvestorRepository investorRepository;

	public long openBook(Long instrumentId) {
		Instrument instrument = new Instrument(instrumentId);

		Book book = this.bookRepository.findByInstrument(instrument);
		if (book.isOpened()) {
			throw new RuntimeException("tried to open a book already opened!");
		}

		book.setOpened(true);
		long n = addOrders(book);

		this.bookRepository.save(book);
		return n;
	}
	
	private long addOrders(Book book) {
		final AtomicLong n = new AtomicLong(0);
		Iterable<Investor> investors = this.investorRepository.findAll();
		investors.forEach(i -> {
			FinancialOrder fo = this.orderGenerator.generate(book, i);
			book.addFinancialOrder(fo);
			n.incrementAndGet();
		});
		return n.longValue();
	}

	public void closeBook(Long instrumentId) {
		Instrument instrument = new Instrument(instrumentId);

		Book book = this.bookRepository.findByInstrument(instrument);
		if (!book.isOpened()) {
			throw new RuntimeException("tried to close a book already closed!");
		}
		if (book.isExecuted()) {
			throw new RuntimeException("tried to close a book executed!");
		}

		executeBook(book);
		book.setOpened(false);

		bookRepository.save(book);
	}

	private void executeBook(Book book) {
		List<Execution> executions = book.getExecutions();
		executions.forEach(ex -> processExecution(ex, book));
	}

	private void processExecution(Execution ex, Book book) {
		List<FinancialOrder> financialOrders = book.getFinancialOrders();
		List<FinancialOrder> validOrders = new ArrayList<>();

		financialOrders.forEach(fo -> {
			if (fo.isValid() && !fo.isFullExecuted()) {
				if (fo.getLimitPrice() == null || fo.getLimitPrice() >= ex.getPrice()) {
					validOrders.add(fo);
				} else {
					fo.setValid(false);
					fo.addOrderExecution(new OrderExecution(0, fo, ex));
				}
			}
		});
		final Double ratio = calulateRatio(validOrders, ex);
		if (ratio == null) {
			book.setExecuted(true);
		}
		validOrders.forEach(fo -> {
			long executingQuantity = fo.getExecutingQuantity();
			long executedQuantity = ratio == null ? executingQuantity : Math.round(executingQuantity * ratio);// TODO this rounding cause some imprecision on the sold offer
			fo.addOrderExecution(new OrderExecution(executedQuantity, fo, ex));
		});
	}

	private Double calulateRatio(List<FinancialOrder> validOrders, Execution ex) {
		long totalDemand = validOrders.stream().mapToLong(FinancialOrder::getQuantity).sum();
		double offer = ex.getQuantity();
		return totalDemand <= offer ? null : offer / totalDemand;
	}

	public long openAllBooks() {
		final AtomicLong n = new AtomicLong(0);
		Iterable<Book> books = this.bookRepository.findAll();
		books.forEach(book -> {
			long i = this.openBook(book.getInstrument().getId());
			n.getAndAdd(i);
		});
		return n.longValue();
	}

	public void closeAllBooks() {
		final AtomicLong n = new AtomicLong(0);
		Iterable<Book> books = this.bookRepository.findAll();
		books.forEach(book -> {
			this.closeBook(book.getInstrument().getId());
		});

	}
}
