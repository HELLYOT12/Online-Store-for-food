package inventory;
import java.util.Scanner;

public class Inventory {
	public static final String NAME = "House Market";
	public static Scanner sc = new Scanner(System.in);
	private static double treasuryMoney = 0;
	public Inventory() {
		addProduct();
	}
	
	
	public static void addProduct() {
		Product product = new Product();
		System.out.println("Enter Product name");
		product.setName(sc.next());
		System.out.println("Enter quantity");
		product.setQuantity(sc.nextInt());
		System.out.println("Enter Kind");
		System.out.println("1- Dairys , 2-fruits , 3-Meats , 4-Starches , 5-Snacks");
		product.setcategory(sc.nextInt());
		product.setSerialNumber();
		product.setId();
		product.setPrice();
		
		Product.getProducts().add(product);
	}
	
	public static void  buyProduct(Client clientAccount) {
		System.out.println("Enter Product Name for Payment");
		Product product =Product.serachForProduct(sc.next());
		if (product != null) {
			if (clientAccount.getBalance() > 0) {
				if (product.getQuantity() > 0 ) {
					if (clientAccount.getBalance() >= product.getPrice()) {
						clientAccount.setBalance(-product.getPrice());
						treasuryMoney+=product.getPrice();
						product.setQuantity(product.getQuantity()-1);
						System.out.println("The purchase was successfully completed");
					}
					else {
						System.out.println("No money for product");
					}
				}
				else {
					System.out.println("sold out");
				}
			}
			else {
				System.out.println("No blanace For Payment");
			}
		}
	}
	
	public static void showProducts() {
		if (Product.getProducts().isEmpty()) {
			System.out.println("No Available products");
		}
		else 
		for (Product p:Product.getProducts()) {
			System.out.println(p);
		}
	}
	


	
	
	public static double getTreasuryMoney() {
		return treasuryMoney;
	}

	public static void productsadded() {
		// String name, integer categoryNum, integer quantity
//	case 1: category = "Dairys"; break;
//	case 2: category = "fruits"; break;
//	case 3: category = "Meats";  break;
//	case 4:	category = "Starches"; break;
//	case 5: category = "Snacks"; break;
//	default:category = "Unknown"; break;
		Product p1 = new Product("Meat" , 3 , 200 );
		Product p2 = new Product("banana" , 2 , 100 );
		Product p3 = new Product("CowMeat" , 3 , 200 );
		Product p4 = new Product("pototo" , 2 , 200 );
		Product p5 = new Product("pototo chips" , 5 , 200 );
		Product p6 = new Product("malik" , 1 , 200 );
		Product p7 = new Product("cheese" , 1 , 200 );
		Product p8 = new Product("Pasta" , 4 , 200 );
		Product p9 = new Product("macaroni" , 4 ,1000);
		Product p10 = new Product("Pizza" , 4 , 200 );
		Product p11 = new Product("Spaghetti" , 4 , 200 );
		Product p12 = new Product("yogert" , 1 , 500 );
		Product p13 = new Product("Meat" , 3 , 200 );
		Product.getProducts().add(p1);
		Product.getProducts().add(p2);
		Product.getProducts().add(p3);
		Product.getProducts().add(p4);
		Product.getProducts().add(p5);
		Product.getProducts().add(p6);
		Product.getProducts().add(p7);
		Product.getProducts().add(p8);
		Product.getProducts().add(p9);
		Product.getProducts().add(p10);
		Product.getProducts().add(p11);
		Product.getProducts().add(p12);
		Product.getProducts().add(p13);
	}
	public static void clientsadded() {
		// name , password , balance;
		Client c1 = new Client("Yomen" , "PASSword12" , 2133);
		Client c2 = new Client("sarah" , "lilGirlmaybe22" , 2133);
		Client c3 = new Client("Ali" , "AllahAkbar" , 2133);
		Client c4 = new Client("yousef" , "sha12099d" , 2133);
		Client c5 = new Client("Amen" , "iLovepototo" , 2133);

	}
	
	public static void editProduct() {
		System.out.println("Enter the name of product");
		Product currentProduct = Product.serachForProduct(sc.next());
		if (currentProduct != null) {
			System.out.println("-1 Edit Name -2 Edit Price -3 Edit Category -4 Edit quantity");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:currentProduct.setName(sc.next());break;
			case 2:currentProduct.changePrice(sc.nextDouble());
			case 3:System.out.println("1- Dairys , 2-fruits , 3-Meats , 4-Starches , 5-Snacks"); currentProduct.setcategory(sc.nextInt());break;
			case 4:currentProduct.setQuantity(sc.nextInt());break;
			default:System.out.println("Wrong Input");
			}
		}
	}
	
	
}
