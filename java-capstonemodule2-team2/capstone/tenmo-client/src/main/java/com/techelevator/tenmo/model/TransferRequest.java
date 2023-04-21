package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class TransferRequest {

    private String fromUserName;
    private String toUserName;
    private BigDecimal amount;

    public TransferRequest(String fromUserName, String toUserName, BigDecimal amount){
        this.fromUserName = fromUserName;
        this.toUserName = toUserName;
        this.amount = amount;

    }

    public String getFromUserName(){
        return fromUserName;
    }
    public String getToUserName(){
        return toUserName;
    }
    public BigDecimal getAmount(){
        return amount;
    }
}
