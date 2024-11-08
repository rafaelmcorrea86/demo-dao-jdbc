package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entitie.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: seller findById ====");
		Seller sl = sellerDao.findById(3);
		System.out.println(sl);

	}

}
