package com.civism.controller;

import com.civism.model.TradeDo;
import com.civism.model.UserDo;
import com.civism.service.TradeService;
import com.civism.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author star
 * @date 2019-02-13 10:58
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private UserService userService;

    @Resource
    private TradeService tradeService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public UserDo index() {
        UserDo load = userService.load(1046);
        return load;
    }


    @RequestMapping(value = "trade", method = RequestMethod.GET)
    public List<TradeDo> trade() {
        List<TradeDo> tradeDos = tradeService.loadAll();
        return tradeDos;
    }

}
