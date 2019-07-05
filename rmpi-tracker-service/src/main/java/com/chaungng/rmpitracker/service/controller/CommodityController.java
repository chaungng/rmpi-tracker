package com.chaungng.rmpitracker.service.controller;

import com.chaungng.rmpitracker.service.dal.CommodityDAL;
import com.chaungng.rmpitracker.service.dal.DDBCommodityImplement;
import com.chaungng.rmpitracker.service.dao.Commodity;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@EnableWebMvc
@Log4j2
public class CommodityController {
    private final CommodityDAL commodityDAL = new DDBCommodityImplement();
    @RequestMapping(path = "/commodity", method = RequestMethod.POST)
    public List<String> add(@RequestBody Commodity[] commodities) {
        try {
            Arrays.stream(commodities).forEach(commodity -> {
                log.info(String.format("commodity id: %s", commodity.getId()));
            });
            return commodityDAL.add(commodities);
        } catch (Exception ex) {
            log.error("add commodity error", ex);
            throw new RuntimeException("add commodity error", ex);
        }
    }

    @RequestMapping(path = "/commodity/{commodityName}", method = RequestMethod.GET)
    public Commodity[] get(@RequestParam("start_date") Optional<String> startDate,
                           @RequestParam("end_date") Optional<String> endDate,
                           Principal principal) {
        return null;
    }


}
