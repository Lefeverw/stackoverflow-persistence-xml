package com.wouterlefever.stackoverflow.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {
    @Id
    private int id;
    private String name;

    public Accounts(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Accounts() {

    }
}
