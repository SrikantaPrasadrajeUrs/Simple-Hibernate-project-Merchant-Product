package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Merchant;
import dto.Product;

	/**
	 * This class provides Data Access Object (DAO) methods for interacting with the
	 * Product entity.
	 */
public class ProductDao {
	// EntityManager for managing entities
	EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();

	// EntityTransaction for managing transactions
	EntityTransaction t = manager.getTransaction();

	/**
	 * Saves a new product in the database and associates it with a merchant.
	 * 
	 * @param p          The Product object to be saved.
	 * @param merchantId The ID of the associated merchant.
	 * @return The saved Product object.
	 */
	public Product saveProduct(Product p, int merchantId) {
		Merchant m = manager.find(Merchant.class, merchantId);
		m.getProducts().add(p);
		p.setMerchant(m);
		manager.persist(p);
		t.begin();
		t.commit();
		return p;
	}

	/**
	 * Updates an existing product in the database and associates it with a
	 * merchant.
	 * 
	 * @param p          The Product object to be updated.
	 * @param merchantId The ID of the associated merchant.
	 * @return The updated Product object.
	 */
	public Product updateProduct(Product p, int merchantId) {
		Merchant m = manager.find(Merchant.class, merchantId);
		if (m != null) {
			p.setMerchant(m);
			manager.merge(p);
			t.begin();
			t.commit();
			return p;
		}
		return null;
	}

	/**
	 * Finds products by brand.
	 * 
	 * @param brand The brand name to search for.
	 * @return A list of Product objects with the specified brand.
	 */
	public List<Product> findProductsByBrand(String brand) {
		String jpql = "select p from Product p where p.brand=:brand";
		Query q = manager.createQuery(jpql);
		q.setParameter("brand", brand);
		List<Product> products = q.getResultList();
		return products;
	}

	/**
	 * Finds products by category.
	 * 
	 * @param category The category to search for.
	 * @return A list of Product objects with the specified category.
	 */
	public List<Product> findProductsByCategory(String category) {
		String jpql = "select p from Product p where p.category=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, category);
		t.begin();
		t.commit();
		List<Product> products = q.getResultList();
		return products;
	}

	/**
	 * Finds products associated with a merchant by merchant ID.
	 * 
	 * @param merchantId The ID of the merchant.
	 * @return A list of Product objects associated with the specified merchant.
	 */
	public List<Product> findProductsByMerchantId(int merchantId) {
		Merchant m = manager.find(Merchant.class, merchantId);
		if (m != null) {
			return m.getProducts();
		} else {
			System.out.println("No Merchant found with the given id");
			return null;
		}
	}
}
