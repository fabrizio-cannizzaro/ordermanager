package com.cs.order.manager.dao;

import com.cs.order.manager.entity.table.Book;
import com.cs.order.manager.entity.table.FinancialOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author fabrix
 */
public interface FinancialOrderRepository extends CrudRepository<FinancialOrder, Long> {
	List<FinancialOrder> findByBookAndLimitPriceNotNullOrderByLimitPriceDesc(Book book);
		List<FinancialOrder> findByBookAndValidAndLimitPriceNotNullOrderByLimitPriceDesc(Book book, boolean valid);
}
