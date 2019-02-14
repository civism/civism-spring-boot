package com.civism.service.impl;

import com.civism.dao.sqlserver.TradeDao;
import com.civism.model.TradeDo;
import com.civism.service.TradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author star
 * @date 2019-02-14 17:39
 */
@Service
public class TradeServiceImpl implements TradeService {

    @Resource
    private TradeDao tradeDao;

    @Override
    public List<TradeDo> loadAll() {
        return tradeDao.loadAll();
    }
}
