package com.cs.order.manager.dao;

import com.cs.order.manager.entity.table.Book;
import com.cs.order.manager.entity.table.Execution;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fabrix
 */
public interface ExecutionRepository extends CrudRepository<Execution, Long> {

	Iterable<Execution> findByBook(Book b);
}
