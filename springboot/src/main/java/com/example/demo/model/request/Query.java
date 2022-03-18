package com.example.demo.model.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Query {
    private String key;
    private String value;
}