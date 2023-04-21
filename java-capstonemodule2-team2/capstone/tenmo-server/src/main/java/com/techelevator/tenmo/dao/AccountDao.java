package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;

import java.math.BigDecimal;

public interface AccountDao {

    BigDecimal getBalance (int id);

    void createTransfer(User sender, User recipient, BigDecimal amount);

    void updateBalance (int accountId, BigDecimal amount);

    public int getAccountIdByUserId (int userId);






}
