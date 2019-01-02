package com.cs.order.manager.dao;

import com.cs.order.manager.entity.table.Book;
import com.cs.order.manager.entity.table.Instrument;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fabrix
 */
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findByInstrument(Instrument i);
	
}
