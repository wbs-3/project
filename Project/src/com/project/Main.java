package com.project;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

		public static ArrayList<Product> products = new ArrayList<Product>();
	
	
	public static void main(String[] args) throws SQLException {
		char option = 'q';
		
		do {
		//ask for input from user
		System.out.println("\n**********************************");	
		System.out.println("Welcome to Christopher's Cakes, Cookies and Candy Shop");
		System.out.println("Add Cake - type A and press enter");
		System.out.println("Add Cookie - type O and press enter");
		System.out.println("Add Candy - type L and press enter");
		System.out.println("View Cake List - type C and press enter");
		System.out.println("View Cookie List - type K and press enter");
		System.out.println("View Candy List - type D and press enter");
		System.out.println("To exit please press q");
		System.out.println("**********************************\n");
		
		//Get input from user
		
		Scanner kb = new Scanner (System.in);
		option = kb.next().charAt(0);
		
		if (option == 'A' || option == 'a') {
			System.out.println("Lets add a new Cake!\nPlease enter new Cake:");
			String cakeName = kb.next();
			System.out.println("\nPlease enter Cake qty:");
			int cakeQty = kb.nextInt();
			System.out.println("\nPlease enter Cake price with 2 decimal places:");
			double cakeCost = kb.nextDouble();
			AddCake(cakeName, cakeQty, cakeCost);
			
		}
		
		if (option == 'O' || option == 'o') {
			System.out.println("Lets add a new Cookie!\nPlease enter new Cookie:");
			String cookieName = kb.next();
			System.out.println("\nPlease enter Cookie qty:");
			int cookieQty = kb.nextInt();
			System.out.println("\nPlease enter Cookie price with 2 decimal places:");
			double cookieCost = kb.nextDouble();
			AddCookie(cookieName, cookieQty, cookieCost);
			
		}
		
		if (option == 'L' || option == 'l') {
			System.out.println("Lets add a new Candy!\nPlease enter new Candy:");
			String candyName = kb.next();
			System.out.println("\nPlease enter Candy qty:");
			int candyQty = kb.nextInt();
			System.out.println("\nPlease enter Candy price with 2 decimal places:");
			double candyCost = kb.nextDouble();
			AddCandy(candyName, candyQty, candyCost);
			
		}
				
		if (option == 'C' || option == 'c') {
			System.out.println("Displaying all of our Cakes:");
			getAllCakes();
		}	
		if (option == 'K' || option == 'k') {
			System.out.println("Displaying all of our Cookies:");
			getAllCookies();
		}	
		if (option == 'D' || option == 'd') {
			System.out.println("Displaying all of our Candies:");
			getAllCandies();
		}	
		if (option == 'q') {
			System.out.println("Thanks for visiting Christopher's Cakes, Cookies and Candy Shop");
			
		}
		}while (option != 'q');
	}
	//add product to db
	public static void AddCake(String cakeName, int cakeQty, double cakeCost) throws SQLException {
				
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chris", "root", "root");
		PreparedStatement sql = conn.prepareStatement("insert into cakes(name, qty, cost) values(?,?,?)");
		sql.setString(1,cakeName);
		sql.setInt(2,cakeQty);
		sql.setDouble(3, cakeCost);
		
		sql.executeUpdate();
		System.out.println("Insert Successful");
		
		}
	public static void AddCookie(String cookieName, int cookieQty, double cookieCost) throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chris", "root", "root");
		PreparedStatement sql = conn.prepareStatement("insert into cookies(name, qty, cost) values(?,?,?)");
		sql.setString(1,cookieName);
		sql.setInt(2,cookieQty);
		sql.setDouble(3, cookieCost);
		sql.executeUpdate();
		
			
		System.out.println("Insert Successful");
		}
	public static void AddCandy(String candyName, int candyQty, double candyCost) throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chris", "root", "root");
		PreparedStatement sql = conn.prepareStatement("insert into caramels(name, qty, cost) values(?,?,?)");
		sql.setString(1,candyName);
		sql.setInt(2,candyQty);
		sql.setDouble(3, candyCost);
		
		sql.executeUpdate();
		System.out.println("Insert Successful");
	}
	
	public static void getAllCakes() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chris", "root", "root");
		Statement sql = conn.createStatement();
		ResultSet rs = sql.executeQuery("Select * from cakes");
		while(rs.next()) {
			System.out.println(rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4));
		}
	}
		public static void getAllCandies() throws SQLException {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chris", "root", "root");
			Statement sql = conn.createStatement();
			ResultSet rs = sql.executeQuery("Select * from candies");
			while(rs.next()) {
				System.out.println(rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4));
			}
		}
		public static void getAllCookies() throws SQLException {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chris", "root", "root");
				Statement sql = conn.createStatement();
				ResultSet rs = sql.executeQuery("Select * from cookies");
				while(rs.next()) {
					System.out.println(rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4));
				}
	}
}
