package inventory;

import java.util.Scanner;

public class Store {
	private Scanner sc = new Scanner(System.in);
	private Admin defultAdmins = new Admin();
	private Admin ad= new Admin("Yeman" ,"212121");
		Store(){
				Inventory.productsadded();
				Inventory.clientsadded();
				Client CurrentUser = null;
			    Admin CurrentAdmin = null;
			    do {
			        System.out.println("-1 Sign in -2 Create Account");
			        int Choice = sc.nextInt();
			        switch (Choice) {
			            case 1:
			                System.out.println("Enter User Name And Password");
			                String userName = sc.next();
			                String password = sc.next();
			                CurrentUser = Client.SignIn(userName, password);
			                CurrentAdmin = Admin.searchAdmins(userName.trim(), password.trim());
			                break;
			            case 2:
			                Client newAccount = new Client();
			                CurrentUser = newAccount;
			                break;
			            default:
			                System.out.println("Enter Valid Input");
			        }
			    } while (CurrentUser == null && CurrentAdmin == null);
			    if (CurrentUser != null) {
			    	System.out.println("You have been logged in successfully Mr "+CurrentUser.getUserName());
			    }
			    else {
			    	System.out.println("You have been logged in successfully Admin "+CurrentAdmin.getUserName());
			    }
			boolean flag = true;
			while (flag) {
				if (CurrentUser != null) {
					System.out.println("-1 Buy Items -2 Show balance -3 add Balance -4 Change Password -5 Change UserName");
					System.out.println("-6 Exit");
					int choice = sc.nextInt(); 
					switch (choice) {
					case 1:
						Inventory.showProducts();
						Inventory.buyProduct(CurrentUser);
						break;
					case 2:System.out.println("Your Current Balance Is:"+CurrentUser.getBalance()+"$");
						break;
					case 3:System.out.println("Enter the Amout That You want to add");
						   CurrentUser.setBalance(sc.nextDouble());
						   System.out.println("The operation was completed successfully");
						break;
					case 4:System.out.println("Enter new Password");
						   CurrentUser.setPassword(sc.next());
						break;
					case 5:System.out.println("Enter new User Name");
							CurrentUser.setUserName(sc.next());
						break;
					case 6: flag = false;break;
					default:System.out.println("Wrong Input ya 7abebe");
					}
				}
				else if (CurrentAdmin != null) {
					System.out.println("-1 Add Item -2 Show Available Money  -3 Show products -4 Serach For product to edit");
					System.out.println("-5 ban Client -6 Exit");
					int choice = sc.nextInt(); 
					switch (choice) {
					case 1:Inventory.addProduct();break;
					case 2:System.out.println("Money in Treasury is = "+Inventory.getTreasuryMoney()); break;
					case 3:Inventory.showProducts();break;
					case 4:Inventory.editProduct();break;
					case 5:System.out.println("Enter Client User Name");
					Client	ClientBannded = Client.SignIn(sc.next());
					if (ClientBannded != null) {
						Client.getClients().remove(ClientBannded);
						   System.out.println("The operation was completed successfully");
					}
					else {
						System.out.println("User Not Found");
					}break;
					case 6: flag = false;break;
					}
				}
			}
		}

}
