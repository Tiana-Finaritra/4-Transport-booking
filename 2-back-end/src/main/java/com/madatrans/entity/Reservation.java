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
public class Reservation  {
    private int id;
    private Timestamp reservationDate;
    private int clientId;
    private int voyageId;
}
