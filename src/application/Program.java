package application;

import java.util.Date;

import model.entitie.Department;
import model.entitie.Seller;

public class Program {

	public static void main(String[] args) {

		Department dp = new Department(1, "Books");
		Seller sl = new Seller(1, "Bob", "bob@gmail.com", new Date(), 3000.00, dp);
		System.out.println(sl);

	}

}
