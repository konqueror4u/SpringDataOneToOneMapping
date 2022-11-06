package com.visu.springdataonetoonemapping.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
@IdClass(AccountId.class)
@Setter
@Getter
public class Account implements Serializable {
    @Id
    private String accountNumber;

    @Id
    private String accountType;

    private Double balance;
    public Account() {
    }

    public Account(String accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

}
