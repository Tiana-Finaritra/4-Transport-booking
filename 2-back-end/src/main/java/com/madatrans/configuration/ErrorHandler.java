package com.madatrans.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorHandler {
    private String errorStatus;
    private String error;
}
