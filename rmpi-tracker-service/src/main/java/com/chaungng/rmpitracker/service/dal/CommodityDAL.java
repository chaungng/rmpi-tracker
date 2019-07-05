package com.chaungng.rmpitracker.service.dal;

import com.chaungng.rmpitracker.service.dao.Commodity;

import java.util.List;

public interface CommodityDAL {
    List<String> add(Commodity[] commodities);
    Commodity[] get(String name, String startDate, String endDate);
}
