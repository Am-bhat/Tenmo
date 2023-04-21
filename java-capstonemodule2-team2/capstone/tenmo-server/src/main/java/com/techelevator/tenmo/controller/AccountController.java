package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferRequest;
import com.techelevator.tenmo.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
//@PreAuthorize("isAuthenticated")
public class AccountController {
    private UserDao userDao;
    private AccountDao accountDao;

    public AccountController(UserDao userDao, AccountDao accountDao) {
        this.userDao = userDao;
        this.accountDao = accountDao;
    }

    @RequestMapping(path = "balance/{id}", method = RequestMethod.GET)
//    @PreAuthorize("permitAll")
    public BigDecimal getBalance(@PathVariable int id) {
        BigDecimal balance = accountDao.getBalance(id);
        return balance;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userDao.findAll();
    }

//    @RequestMapping(path = "/transfer", method = RequestMethod.POST)
//    public boolean makeTransfer(String sender, String recipient, BigDecimal amount) {
//        User sendingUser = userDao.getUserById(userDao.findIdByUsername(sender));
//        User receivingUser = userDao.getUserById(userDao.findIdByUsername(recipient));
//        if ((sendingUser.getId() != receivingUser.getId()) &&
//                (accountDao.getBalance(sendingUser.getId()).compareTo(amount) < 1) &&
//                        (amount.compareTo(BigDecimal.valueOf(0)) < 0)){
//            accountDao.updateBalance(accountDao.getAccountIdByUserId(sendingUser.getId()), amount.negate());
//            accountDao.updateBalance(accountDao.getAccountIdByUserId(receivingUser.getId()), amount);
//            accountDao.createTransfer(sendingUser, receivingUser, amount);

            @RequestMapping(path = "/transfer", method = RequestMethod.POST)
            public boolean makeTransfer(@Valid @RequestBody TransferRequest transferRequest) {
                User sendingUser = userDao.getUserById(userDao.findIdByUsername(transferRequest.getFromUserName()));
                User receivingUser = userDao.getUserById(userDao.findIdByUsername(transferRequest.getToUserName()));
                if ((sendingUser.getId() != receivingUser.getId()) &&
                        (accountDao.getBalance(sendingUser.getId()).compareTo(transferRequest.getAmount()) < 1) &&
                        (transferRequest.getAmount().compareTo(BigDecimal.valueOf(0)) < 0)){
                    //this method needs an accountId and an amount
                    accountDao.updateBalance(accountDao.getAccountIdByUserId(sendingUser.getId()), transferRequest.getAmount().negate());
                    accountDao.updateBalance(accountDao.getAccountIdByUserId(receivingUser.getId()), transferRequest.getAmount());
                    accountDao.createTransfer(sendingUser, receivingUser, transferRequest.getAmount());



        }
        return false;
    }


    }

