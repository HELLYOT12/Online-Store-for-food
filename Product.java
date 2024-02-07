package inventory;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Product {
	private static int idIncrement=0;
	private static int numberOfProducts;
	private String name;
	private  double price;
	private String category;
	private int quantity;
	private int id;
	private String serialNumber;
	private static Set<Product> Products = new HashSet<>();
	

	
	
	
	
	public Product() {
		
	}
	
	public Product(String name, int categoryNum, int quantity) {
		this.name = name;
		setcategory(categoryNum);
		this.quantity = quantity;
		setId();
		setPrice();
		setSerialNumber();

	}
	public void setcategory(int choice) {
		if (choice > 5) {
			System.out.println("pick Number Between 1-5");
			return;
		}
		switch (choice) {
		case 1: category = "Dairys"; break;
		case 2: category = "fruits"; break;
		case 3: category = "Meats";  break;
		case 4:	category = "Starches"; break;
		case 5: category = "Snacks"; break;
		default:category = "Unknown"; break;
		}
	}
	// not finished
	public void setSerialNumber() {
	    Random randomNumber = new Random();
	    String NUMBERS = "0123456789";
	    StringBuilder code = new StringBuilder();
	    do {
	        for (int i = 0; i < 10; i++) {
	            char currentChar = NUMBERS.charAt(randomNumber.nextInt(NUMBERS.length()));
	            code.append(currentChar);
	        }
	    } while (checkSerialNumber(code.toString()).equals("0"));

	    serialNumber = code.toString();
	}
	public String getSerialNumber() {
		return serialNumber;
	}


	// Check
	private String checkSerialNumber(String serialNumber) {
	    if (!Products.isEmpty()) {
	        for (Product p : Products) {
	            if (p.getSerialNumber().equals(serialNumber)) {
	                return "0"; // Serial number already exists
	            }
	        }
	    }
	    return serialNumber; // Serial number is unique
	}
	
	
	public static int getNumberOfProducts() {
		return numberOfProducts;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCategory() {
		return category;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getId() {
		return id;
	}
	public void setId() {
		idIncrement++;
	 String newId = String.valueOf("2023"+idIncrement);
	 this.id = Integer.parseInt(newId);
	}


	public void setPrice() {
		Scanner sc = new Scanner(System.in);
		switch(category) {
		case "Dairys": price = 25; break;
		case "Meats": price = 50; break;
		case "fruits": price = 15; break;
		case "Starches": price = 35; break;
		case "Snacks": price = 5; break;
		default: System.out.println("Enter Price"); price = sc.nextInt();
		}
	}
	public double getPrice() {
		return price;
	}
	
	public void changePrice(double newPrice) {
		price = newPrice;
	}






	public static  Set<Product> getProducts() {
		return Products;
	}


	public static Product serachForProduct(String productName) {
		for (Product product:Products) {
			if (product.getName().equalsIgnoreCase(productName)) {
				return product;
			}
		}
		 return null;
	}



	@Override
	public String toString() {
		return "Product [name=" + name + " category=" + category +" id=" + id +" price="+ price+ "$" +"]";
	}

	
}


