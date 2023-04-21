package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private int transferTypeId;
    private int transferStatusId;
    private int accountFrom;
    private int accountTo;
    private BigDecimal amount;
    private String transferStatus;
    private String transferType;
    private String fromUser;
    private String toUser;

    public Transfer (int transferTypeId, int transferStatusId, int accountFrom, int accountTo, BigDecimal amount, String transferStatus, String transferType, String fromUser, String toUser) {
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.transferStatus = transferStatus;
        this.transferType = transferType;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public int getTransferTypeId() {
        return transferTypeId;
    }
    public int getTransferStatusId() {
        return transferStatusId;
    }
    public int getAccountFrom() {
        return accountFrom;
    }
    public int getAccountTo() {
        return accountTo;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public String getTransferType() {
        return transferType;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setTransferTypeId(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public void setTransferStatusId(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
}


