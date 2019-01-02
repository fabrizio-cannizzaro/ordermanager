package com.cs.order.manager.bl.generator;

import com.cs.order.manager.entity.table.Book;
import com.cs.order.manager.entity.table.FinancialOrder;
import com.cs.order.manager.entity.table.Investor;
import java.sql.Date;
import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.stereotype.Component;

/**
 *
 * @author fabrix
 */
@Component
public class OrderGenerator {

	private final RandomDataGenerator rdg;
	private final Random random;

	public OrderGenerator() {
		this.rdg = new RandomDataGenerator();
		this.random = new Random();
	}

	public FinancialOrder generate(Book b, Investor i) {
		FinancialOrder fo = new FinancialOrder();
		fo.setBook(b);
		fo.setEntryDate(new Date(System.currentTimeMillis()));
		fo.setInstrument(b.getInstrument());
		fo.setInvestor(i);
		if (this.random.nextBoolean()) {
			fo.setLimitPrice(rdg.nextLong(90, 100));
		}
		fo.setQuantity(rdg.nextLong(100, 1000));
		fo.setValid(true);
		return fo;
	}

}
