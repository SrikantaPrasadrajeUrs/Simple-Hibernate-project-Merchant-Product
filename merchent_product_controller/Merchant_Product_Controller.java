package merchent_product_controller;

import java.util.List;
import java.util.Scanner;

import dao.MerchantDao;
import dao.ProductDao;
import dto.Merchant;
import dto.Product;

/**
 * This class represents the main controller for managing merchants and products
 * through a console-based interface.
 */
public class Merchant_Product_Controller {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MerchantDao merchantDao = new MerchantDao();
		ProductDao productDao = new ProductDao();

		// Infinite loop for continuous user interaction
		while (true) {
			// Displaying menu options
			System.out.println("Enter 1 to save merchant");
			System.out.println("Enter 2 to update merchant");
			System.out.println("Enter 3 to verify merchant phone number and password");
			System.out.println("Enter 4 to verify merchant email and password");
			System.out.println("Enter 5 to Delete by merchant id");
			System.out.println("Enter 6 to save products");
			System.out.println("Enter 7 to update Products");
			System.out.println("Enter 8 to find products by brand");
			System.out.println("Enter 9 to find products by category");
			System.out.println("Enter 10 to find products by merchantId");
			System.out.println("Enter 11 to exit");

			System.out.println("enter your choice");

			// Switch statement for handling user choices
			switch (sc.nextInt()) {
			case 1:
				// Save Merchant
				Merchant m = new Merchant();
				System.out.println("enter your name");
				m.setName(sc.next());
				System.out.println("enter your password");
				m.setPassword(sc.next());
				System.out.println("enter phone number");
				m.setPhone(sc.nextLong());
				System.out.println("enter your email");
				m.setEmail(sc.next());
				System.out.println("enter your gst number");
				m.setGst_number(sc.next());
				Merchant savedMerchant = merchantDao.saveMerchant(m);
				System.out.println("merchant saved with id: " + savedMerchant.getId());
				break;
			case 2:
				// Update Merchant
				Merchant m1 = new Merchant();
				System.out.println("Enter your id");
				m1.setId(sc.nextInt());
				System.out.println("enter your name");
				m1.setName(sc.next());
				System.out.println("enter your password");
				m1.setPassword(sc.next());
				System.out.println("enter phone number");
				m1.setPhone(sc.nextLong());
				System.out.println("enter your email");
				m1.setEmail(sc.next());
				System.out.println("enter your gst number");
				m1.setGst_number(sc.next());
				merchantDao.updateMerchant(m1);
				break;
			case 3:
				// Verify Merchant by phone and password
				System.out.println("enter ur phone number");
				Long phone = sc.nextLong();
				String password = sc.next();
				Merchant m3 = merchantDao.verifyMerchant(phone, password);
				if (m3 != null) {
					// ... (similar display and processing for verified merchant)
				} else {
					System.out.println("Merchant not found");
				}
				break;
			case 4:
				// Verify Merchant by email and password
				System.out.println("enter ur email number");
				String email = sc.next();
				System.out.println("enter ur password number");
				String password1 = sc.next();
				Merchant m4 = merchantDao.verifyMerchant(email, password1);
				if (m4 != null) {
					// ... (similar display and processing for verified merchant)
				} else {
					System.out.println("Merchant not found");
				}
				break;
			case 5:
				// Delete Merchant by id
				System.out.println("enter your id to delete your account");
				int id = sc.nextInt();
				Merchant m5 = merchantDao.deleteMerchant(id);
				if (m5 != null) {
					System.out.println("account deleted successfully with id: " + m5.getId());
				} else {
					System.err.println("account not found");
				}
				break;
			case 6:
				// Save Product
				Product p = new Product();
				System.out.println("Enter your merchant id");
				int merchantId = sc.nextInt();
				System.out.println("enter product name");
				p.setName(sc.next());
				// ... (similar prompts for other product attributes)
				Product savedProduct = productDao.saveProduct(p, merchantId);
				System.out.println("Product saved with id: " + savedProduct.getId());
				break;
			case 7:
				// Update Product
				Product p2 = new Product();
				System.out.println("Enter your merchant id");
				int merchantId1 = sc.nextInt();
				System.out.println("enter product id");
				p2.setId(sc.nextInt());
				System.out.println("enter your name");
				p2.setName(sc.next());
				// ... (similar prompts for other product attributes)
				Product updatedProduct = productDao.updateProduct(p2, merchantId1);
				System.out.println("Product updated with id: " + updatedProduct.getId());
				break;
			case 8:
				// Find Products by Brand
				System.out.println("Enter the brand to find products");
				List<Product> products = productDao.findProductsByBrand(sc.next());
				if (products != null) {
					for (Product p4 : products) {
						System.out.println("products");
						System.out.println(p4.getName());
					}
				} else {
					System.out.println("brand not found");
				}
				break;
			case 9:
				// Find Products by Category
				System.out.println("Enter the category to find products");
				List<Product> products1 = productDao.findProductsByCategory(sc.next());
				if (products1 != null) {
					for (Product p4 : products1) {
						System.out.println("products");
						System.out.println(p4.getName());
					}
				} else {
					System.out.println("category not found");
				}
				break;
			case 10:
				// Find Products by MerchantId
				System.out.println("Enter the Merchant id to find products");
				List<Product> products2 = productDao.findProductsByMerchantId(sc.nextInt());
				if (products2 != null) {
					for (Product p4 : products2) {
						System.out.println("products");
						System.out.println(p4.getName());
					}
				} else {
					System.out.println("category not found");
				}
			case 11:
				//Used to exit the console
				System.out.println("Thank you using the application");
				System.exit(0);
			}
		}
	}
}