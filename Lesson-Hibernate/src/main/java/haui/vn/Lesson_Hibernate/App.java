package haui.vn.Lesson_Hibernate;

import java.util.List;
import java.util.Scanner;

import haui.vn.model.Product;
import haui.vn.util.dao.ProductDao;

public class App {
	
	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(System.in);
		ProductDao productDao  = new ProductDao();
		int choise;
		do {
			System.out.print(
					"====> MENU <====\n" + 
					"1.Get all product\n"+
					"2.Search product by id\n"+
					"3.Create new product\n"+
					"4.Update product by id\n"+
					"5.Delete product by id\n"+
					"6.Finish program !!!\n" +
					"Enter your choise : ");
			choise = sc.nextInt();
		switch(choise) {
				
			case 1: {
				List<Product> list = productDao.selectAll();
				for(Product item : list) System.out.println(item.toString());
				break;
				}
			case 2:{
				System.out.println("Enter id want to search : ");
				Integer searchId = sc.nextInt();
				Product p = productDao.selectById(new Product(searchId));
				if(p != null) {
					System.out.println(p.toString());
				}else {
					System.out.println("Can not find product with id : " + searchId);
				}
				break;
			}
			case 3:{
				System.out.println("Enter infor of product");
				sc.nextLine();
				System.out.print("Name : ");
				String name = sc.nextLine();
				
				System.out.print("Brand : ");
				String brand = sc.nextLine();
				
				System.out.print("Price :");
				Double price = sc.nextDouble();
				
			
				if(productDao.saveOrUpdate(new Product(null ,name , brand , price))) {
					System.out.println("Create new product success!");
				}else {
					System.out.println("Create new product faild!");	
				}
				break;
			}	
				
			case 4:{
				System.out.println("Enter id want to update : ");
				Integer searchId = sc.nextInt();
				Product p = productDao.selectById(new Product(searchId));
				if(p != null) {
					System.out.println("Enter infor of product want to update");
					sc.nextLine();
					System.out.print("Name : ");
					String name = sc.nextLine();
					
					System.out.print("Brand : ");
					String brand = sc.nextLine();
					
					System.out.print("Price :");
					Double price = sc.nextDouble();
					
					if(productDao.saveOrUpdate(new Product(searchId , name , brand , price))) {
						System.out.println("Update product by id success!");
					}else {
						System.out.println("Update product by id faild!");	
					}
				}else {
					System.out.println("Can not find product with id : " + searchId);
				}
				break;
			}
				
			case 5:{
				System.out.println("Enter id want to delete : ");
				Integer searchId = sc.nextInt();
				Product p = productDao.selectById(new Product(searchId));
				if(p != null) {
					if(productDao.delete(p)) {
						System.out.println("Delete product by id success!");
					}else {
						System.out.println("Delete product by id faild!");
					}
				}else {
					System.out.println("Can not find product with id : " + searchId);
				}
				break;
			}
			
			case 6:
				System.out.println("Finish program");
				System.exit(0);  
			default:
				System.out.println("Your choise not valid!");
				break;
			}	
			}while(true);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}
