package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {


		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("\n=== TEST 1: seller findById ====");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		
		System.out.println("\n=== TEST 2: seller findByDepartment ====");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(x -> System.out.println(x));
		
		System.out.println("\n=== TEST 3: seller findAll ====");
		
		List<Seller> listSeller = sellerDao.findAll();
		listSeller.forEach(x -> System.out.println(x));
		
		System.out.println("\n=== TEST 4: seller insert ====");
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(6, null));
		//sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		

		System.out.println("\n=== TEST 5: seller update ====");
		
		seller = sellerDao.findById(2);
		seller.setName("Matha");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller delete ====");
		
		sellerDao.deleteById(11);
		System.out.println("Delete completed");

	}

}
