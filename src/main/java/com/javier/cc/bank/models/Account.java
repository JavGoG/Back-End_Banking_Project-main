package com.javier.cc.bank.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;


@Table(name = "accounts")
@Entity
public class Account{

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Column(name = "number")
    private long number;

    @Embeddable
    public enum TypeAccount{
        SAVINGS, MARKET, BROKERAGE;
        @Autowired
        TypeAccount(){}
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private TypeAccount typeAccount;

    @Getter
    @ManyToOne
    @JsonIgnoreProperties({"accounts"})
    @JoinColumn(name = "customer_id", nullable = false )
    private com.javier.cc.bank.models.Customer customer;

    public Account(long number, TypeAccount type, com.javier.cc.bank.models.Customer customer) {
        this.number = number;
        TypeAccount typeAccount = type;

        this.customer = customer;
    }

    public Account(){}

    public Account(TypeAccount type){
        this.typeAccount = type;
    }

    public void setCustomer(com.javier.cc.bank.models.Customer customer) {
        this.customer = customer;
    }
    public void setNumber(long number) {
        this.number = number;
    }
    public void setType(TypeAccount type) {
        TypeAccount typeAccount = type;
    }
    public TypeAccount getType(TypeAccount typeAccount) {
        return typeAccount;
    }


}
