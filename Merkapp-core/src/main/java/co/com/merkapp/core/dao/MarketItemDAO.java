package co.com.merkapp.core.dao;

import co.com.merkapp.core.entity.MarketItem;

public interface MarketItemDAO {
	
	/**
	 * Insert an market item.
	 * @param marketItem
	 * @return
	 */
	public int insertItem(MarketItem marketItem);
}
