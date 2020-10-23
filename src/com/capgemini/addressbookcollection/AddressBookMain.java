package com.capgemini.addressbookcollection;

import java.util.*;

public class AddressBookMain {
	
	
	public static void AddressBookList() {
		Scanner sc = new Scanner(System.in);
		if(AddressBook.hm.isEmpty())
		{
			System.out.println("No AddressBook Exists, add new AddressBook First");
			System.out.println("Enter name of address book to be created");
			   String name=sc.next();
			   AddressBook obj=new AddressBook();
			   AddressBook.hm.put(name, obj);
			   System.out.println("Address Book Created");
		}
		for(Map.Entry<String, AddressBook> ab : AddressBook.hm.entrySet())
			System.out.println(ab.getKey());
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);
		String firstName, lastName, address, city, state, ph_no, email;
		int zip;
		while(true) {
			
		   System.out.println("Choose your option");
		   System.out.println("1.Add a contact");
		   System.out.println("2.Edit a contact");
		   System.out.println("3.Delete a contact");
		   System.out.println("4.Create new address book");
		   System.out.println("5.Exit");
		   
		   int choice = sc.nextInt();
		   
		   if(choice == 5)
			   break;
		   
		   switch(choice) {
		   
		   case 1:
			    
			    AddressBookList();
				System.out.println("Enter the name of address book to add contact");
				String abook1 = sc.next();
				AddressBook a1 = AddressBook.hm.get(abook1);
			    boolean flag = true;
				while(flag) {	
			     System.out.println("Enter the first name");
				 firstName = sc.next();
				 System.out.println("Enter the last name");
				 lastName = sc.next();
				 System.out.println("Enter the Address");
				 address = sc.next();
				 System.out.println("Enter the city");
				 city = sc.next();
				 System.out.println("Enter the state");
				 state = sc.next();
				 System.out.println("Enter the zip");
				 zip = sc.nextInt();
				 System.out.println("Enter the Phone Number");
				 ph_no = sc.next();
				 System.out.println("Enter the Email Id");
				 email = sc.next();
				 AddressBookContacts c = a1.create(firstName, lastName, address, city, state, zip, ph_no, email);
				 a1.addContactDetails(c);
				 
				 System.out.println("Do You want to add more Contacts?(Y/N)");
				 String response = sc.next();
				 if(response.equals("Y"))
					 flag = true;
				 else
					 flag = false;
				}
				
				break;
		   case 2:
			   AddressBookList();
			   System.out.println("Enter the name of address book to add contact");
			   String abook2 = sc.next();
			   AddressBook a2 = AddressBook.hm.get(abook2);
			   System.out.println("Enter the first name to edit");
		       firstName = sc.next();
			   a2.editContactDetails(firstName);
			   System.out.println("Contact Details Editted");
			   break;
			  
		   case 3:
			   AddressBookList();
			   System.out.println("Enter the name of address book to add contact");
			   String abook3 = sc.next();
			   AddressBook a3 = AddressBook.hm.get(abook3);
			   System.out.println("Enter the first name to Delete");
			   firstName = sc.next();
			   a3.deleteContactDetails(firstName);
			   System.out.println("Contact Details Deleted");
			   break;
			   
		   case 4:
			   
			   System.out.println("Enter name of address book to be created");
			   String name=sc.next();
			   AddressBook obj=new AddressBook();
			   AddressBook.hm.put(name, obj);
			   System.out.println("Address Book Created");
			   break;
		   }
			
			 
		}
	}

}