package com.chaungng.rmpitracker.service.dal;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public abstract class DynamoDBDAL {
    protected final DynamoDBMapper mapper;

    protected DynamoDBDAL() {
        this.mapper = new DynamoDBMapper(AmazonDynamoDBClientBuilder.defaultClient(),
                new DynamoDBMapperConfig.Builder()
                        .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
                        .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.CLOBBER)
                        .build());
    }

    public List<DynamoDBMapper.FailedBatch> add(final List<? extends Object> object) {
        try {
            return mapper.batchSave(object);
        } catch (final Exception ex) {
            log.error("Exception occurred while batch saving to DynamoDb", ex);
            throw new RuntimeException("Exception occurred while batch saving to DynamoDb", ex);
        }
    }
}
