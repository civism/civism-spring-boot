package com.civism.dao.sqlserver;

import com.civism.model.TradeDo;

import java.util.List;

/**
 * @author star
 * @date 2019-02-14 17:33
 */
public interface TradeDao {

    List<TradeDo> loadAll();

}
