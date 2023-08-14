package com.madatrans.madatrans.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Payment {
    private int id;
    private int reservation_id;
    private Timestamp payment_date;
    private float amount;
    private String payment_status;
}