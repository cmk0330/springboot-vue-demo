package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MatchQueryMultiple {
    private String value;
    private String[] keys;
}