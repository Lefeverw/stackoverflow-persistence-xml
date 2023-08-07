package com.wouterlefever.stackoverflow.persistence;

import com.wouterlefever.stackoverflow.persistence.entities.Accounts;

public class Main {
    private final AccountsDAO accountsDAO;

    public Main(AccountsDAO accountsDAO) {
        this.accountsDAO = accountsDAO;
    }

    public static void main(String[] args) {
        Main main = new Main(new AccountsDAO());
        main.insertAccounts();
        main.readAccounts();
    }

    private void readAccounts() {
        Accounts accountsById = accountsDAO.getAccountsById(1);
    }

    private void insertAccounts() {
        Accounts accounts = new Accounts(1, "account1");
        accountsDAO.addAccounts(accounts);
    }
}
