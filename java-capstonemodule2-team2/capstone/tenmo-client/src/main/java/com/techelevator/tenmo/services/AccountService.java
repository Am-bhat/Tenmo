package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.security.Principal;
import java.sql.SQLOutput;


public class AccountService {
    private final String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;
    private AuthenticatedUser user;


    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
    public AccountService (String url, AuthenticatedUser user) {
        this.baseUrl = url;
        this.user = user;
    }



    public BigDecimal getBalance() {
       BigDecimal totalBalance = new BigDecimal(0);
        try {
            totalBalance = restTemplate.exchange(baseUrl + "balance/" + user.getUser().getId(),
                            HttpMethod.GET, makeAuthEntity(), BigDecimal.class).getBody();
            System.out.println("Your current balance is: $" + totalBalance);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return totalBalance;
    }

        private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

//    public BigDecimal getBalance() {
//        Account account = null;
//        try {
//            ResponseEntity<Account> responce = restTemplate.exchange(baseUrl + "/balance/",
//                            HttpMethod.GET, makeAuthEntity(), Account.class);
//            account = responce.getBody();
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return account.getBalance();
//    }
//    private HttpEntity<Void> makeAuthEntity() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(authToken);
//        return new HttpEntity<>(headers);
//    }




}

