package com.wouterlefever.stackoverflow.persistence;


import com.wouterlefever.stackoverflow.persistence.entities.Accounts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AccountsDAO {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");

    public void addAccounts(Accounts accounts) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(accounts);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Accounts getAccountsById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Accounts accounts = entityManager.find(Accounts.class, id);
        entityManager.close();
        return accounts;
    }

    // Add additional methods for update and delete if needed
}
