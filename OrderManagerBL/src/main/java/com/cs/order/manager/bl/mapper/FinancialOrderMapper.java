package com.cs.order.manager.bl.mapper;

import com.cs.order.manager.dto.inner.FinancialOrderDto;
import com.cs.order.manager.entity.table.FinancialOrder;

/**
 *
 * @author fabrix
 */
public class FinancialOrderMapper {

	public static FinancialOrderDto map(FinancialOrder fo) {
		FinancialOrderDto fod = new FinancialOrderDto();
		fod.setExecutionPrice(fo.getExecutionPrice());
		fod.setExecutionQuantity(fo.getExecutedQuantity());
		fod.setId(fo.getId());
		fod.setLimitPrice(fo.getLimitPrice());
		fod.setValid(fo.isValid());
		return fod;
	}

}
