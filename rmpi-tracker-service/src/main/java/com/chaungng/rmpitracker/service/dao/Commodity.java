package com.chaungng.rmpitracker.service.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;

@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
@DynamoDBTable(tableName = Commodity.TABLE_NAME)
public class Commodity {
    public static final String TABLE_NAME = "commodity_table";
    // commodity-date example: copper-19-09-2019
    @Getter(onMethod_ = @DynamoDBHashKey(attributeName = "Id"))
    private String id;
    @Getter(onMethod_ = @DynamoDBRangeKey(attributeName = "Name"))
    private String name;
    @Getter(onMethod_ = @DynamoDBAttribute(attributeName = "Date"))
    private String date;
    @Getter(onMethod_ = @DynamoDBAttribute(attributeName = "High"))
    private String high;
    @Getter(onMethod_ = @DynamoDBAttribute(attributeName = "Low"))
    private String low;
    @Getter(onMethod_ = @DynamoDBAttribute(attributeName = "Open"))
    private String open;
    @Getter(onMethod_ = @DynamoDBAttribute(attributeName = "Price"))
    private String price;
    @Getter(onMethod_ = @DynamoDBAttribute(attributeName = "Volume"))
    private String volume;
}
