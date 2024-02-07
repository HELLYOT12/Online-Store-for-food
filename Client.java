package inventory;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	private String userName;
	private String password;
	private double balance;
	private static ArrayList<Client> clients = new ArrayList<>();
	Client  (String name , String password , double balance){
		this.userName = name;
		this.password = password;
		this.balance = balance;
	}
		Client (){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter User Name");
			userName = sc.next();
			System.out.println("Enter Password");
			password = sc.next();
			clients.add(this);
		}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance+= balance;
	}
	public static  ArrayList<Client> getClients() {
		return clients;
	}
	
	public  static Client SignIn(String username , String password) {
		for (Client client:clients) {
			if (client.userName.equals(username) && client.password.equals(password)) {
				return client;
			}
		}
		return null;
	}
	
	public  static Client SignIn(String username) {
		for (Client client:clients) {
			if (client.userName.equals(username)) {
				return client;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Client [userName=" + userName + ", password=" + password + ", balance=" + balance + ", clients="
				+ clients + "]";
	}
	
	
	
}
