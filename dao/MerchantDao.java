package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Merchant;

	/**
	 * This class provides Data Access Object (DAO) methods for interacting with the Merchant entity.
	 */
public class MerchantDao {
    // EntityManager for managing entities
    EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
    
    // EntityTransaction for managing transactions
    EntityTransaction t = manager.getTransaction();

    /**
     * Saves a new merchant in the database.
     * 
     * @param m The Merchant object to be saved.
     * @return The saved Merchant object.
     */
    public Merchant saveMerchant(Merchant m) {
        manager.persist(m);
        t.begin();
        t.commit();
        return m;
    }

    /**
     * Updates an existing merchant in the database.
     * 
     * @param m The Merchant object to be updated.
     * @return The updated Merchant object.
     */
    public Merchant updateMerchant(Merchant m) {
        manager.merge(m);
        t.begin();
        t.commit();
        return m;
    }

    /**
     * Verifies a merchant by phone number and password.
     * 
     * @param phno The phone number of the merchant.
     * @param password The password of the merchant.
     * @return The verified Merchant object or null if not found.
     */
    public Merchant verifyMerchant(long phno, String password) {
        String jpql = "select m from Merchant m where m.phone=?1 and m.password=?2";
        Query q = manager.createQuery(jpql);
        q.setParameter(1, phno);
        q.setParameter(2, password);
        try {
            return (Merchant) q.getSingleResult();
        } catch (NoResultException e) {
            System.err.println("Account not found");
            return null;
        }
    }

    /**
     * Verifies a merchant by email and password.
     * 
     * @param email The email of the merchant.
     * @param password The password of the merchant.
     * @return The verified Merchant object or null if not found.
     */
    public Merchant verifyMerchant(String email, String password) {
        String jpql = "select m from Merchant m where m.email=?1 and m.password=?2";
        Query q = manager.createQuery(jpql);
        q.setParameter(1, email);
        q.setParameter(2, password);
        try {
            return (Merchant) q.getSingleResult();
        } catch (NoResultException e) {
            System.err.println("Account not found");
            return null;
        }
    }

    /**
     * Deletes a merchant by ID from the database.
     * 
     * @param id The ID of the merchant to be deleted.
     * @return The deleted Merchant object or null if not found.
     */
    public Merchant deleteMerchant(int id) {
        String jpql = "select m from Merchant m where m.id=?1";
        Query q = manager.createQuery(jpql);
        q.setParameter(1, id);
        Merchant m = (Merchant) q.getSingleResult();
        if (m != null) {
            manager.remove(m);
            t.begin();
            t.commit();
            return m;
        } else {
            System.err.println("Account not found with given id");
            return null;
        }
    }
}
