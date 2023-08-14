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
public class Payment {
    private int id;
    private int reservationId;
    private Timestamp paymentDate;
    private float amount;
    private String paymentStatus;
}