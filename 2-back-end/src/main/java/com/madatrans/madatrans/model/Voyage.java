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
public  class Voyage {
    private int id;
    private String destination;
    private Timestamp departure_date;
    private int available_seats;
    private float fare;
}