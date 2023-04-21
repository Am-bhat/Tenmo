package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.security.Principal;


@Component
public class JdbcAccountDao implements AccountDao {

    private UserDao userDao;

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
   public void createTransfer(User sender, User recipient, BigDecimal amount){
        String sql = "INSERT INTO transfer (transfer_type, transfer_status, account_from, account_to, amount) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, "Send", "Approved", sender.getId(), recipient.getId(), amount);
   }
    @Override
   public void updateBalance(int accountId, BigDecimal amount) {
        String sql = "UPDATE account SET balance = balance + ? WHERE account_id = ?";
        jdbcTemplate.update(sql, amount, accountId);
   }


    @Override
    public BigDecimal getBalance(int id) {
        String sql = "SELECT balance FROM account WHERE user_id = ?";
                BigDecimal balance = jdbcTemplate.queryForObject(sql, BigDecimal.class, id);
                return balance;
    }
    @Override
    public int getAccountIdByUserId (int userId) {
        String sql = "SELECT account_id FROM account JOIN tenmo_user ON account.user_id = tenmo_user.user_id WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, int.class, userId);


    }


    }
