package com.chaungng.rmpitracker.service.dal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.chaungng.rmpitracker.service.dao.Commodity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DDBCommodityImplement extends DynamoDBDAL implements CommodityDAL {
    public List<String> add(Commodity[] commodities) {
        List<DynamoDBMapper.FailedBatch> fails = add(Arrays.asList(commodities));
        return fails.stream().map(failedBatch -> {
            try {
                return new ObjectMapper().writeValueAsString(failedBatch.getException().getMessage());
            } catch (JsonProcessingException e) {
                return null;
            }
        }).collect(Collectors.toList());
    }

    public Commodity[] get(String name, String startDate, String endDate) {
        return null;
    }
}
