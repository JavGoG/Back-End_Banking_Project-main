package com.javier.cc.bank.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private char[] password;
    @Column(name = "email")
    private String email;


    @JsonIgnoreProperties({"customer"})
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Account> accounts;

    public Customer(Long id, String name, String address, char[] password, String email, String userName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.accounts = new ArrayList<>();
        this.password = password;
        this.email = email;
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", password=" + Arrays.toString(password) +
                ", email='" + email + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    public void setName(String mame) {
        this.name = mame;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
