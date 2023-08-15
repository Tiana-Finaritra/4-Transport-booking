package com.madatrans.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Voyage {
    private int id;
    private String destination;
    private Timestamp departureDate;
    private int availableSeats;
    private float fare;
}