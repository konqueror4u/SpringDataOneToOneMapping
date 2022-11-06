package com.visu.springdataonetoonemapping.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class AccountId implements Serializable {
    private String accountNumber;
    private String accountType;

    public AccountId() {
    }

    public AccountId(String accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return accountNumber.equals(accountId.getAccountNumber()) &&
                accountType.equals(accountId.getAccountType());
    }

    public int getHashCode() {
        return Objects.hash(accountNumber,accountType);
    }
}
