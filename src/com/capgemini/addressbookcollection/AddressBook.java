package com.capgemini.addressbookcollection;


import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
	public static Map<String,AddressBook> hm= new HashMap<String, AddressBook>(); 
	
	String addressBookName;
	Scanner sc =new Scanner(System.in);
	
	  ArrayList<AddressBookContacts> list;
	  
	    public AddressBook( ) {
		  list = new ArrayList<AddressBookContacts>();
		  
	      }
	    
	    public AddressBook(String addressBookName) {
			list=new ArrayList<AddressBookContacts>();
			this.addressBookName=addressBookName;
			
		  }
	  
		
		public AddressBookContacts create(String firstName,String lastName,String address,
				  String city,String state,int zip,String ph_no,String email ) {
			  
			  AddressBookContacts contact = new AddressBookContacts(firstName,lastName,address,city,state,zip,ph_no,email );
			  return contact;
		  }
		  
		  
		public void addContactDetails(AddressBookContacts contact) {
			
			  int count = (int) list.stream().filter(i->i.equals(contact)).count();
			  if(count>0)
				  System.out.println("You tried to add duplicate contact, Contact already exits");
			  
			  else
			    list.add(contact);
		  }
		
		
		public void editContactDetails(String firstName) {

			int pos=0;

			for(int i=0;i<list.size();i++) 
				if(list.get(i).getFirstName().equals(firstName))
					pos = i;
				
			
			while(true)
			  {	
			      System.out.println("Choose the option to edit");
			      System.out.println("1.Edit Last name");
			      System.out.println("2.Edit Address");
			      System.out.println("3.Edit City");
			      System.out.println("4.Edit State");
			      System.out.println("5.Edit Zip");
			      System.out.println("6.Edit Phone Number");
			      System.out.println("7.Edit Email");
			      System.out.println("8.Exit");
			      
			      int choice=sc.nextInt();
			
			      if(choice==8)
			    	break;
			
			      switch(choice) {
			       case 1:
			       System.out.println("Enter Last name for editing");
				   list.get(pos).setLastName(sc.next());
				   break;
				   
			       case 2:
			       System.out.println("Enter Address for editing");
			   	   list.get(pos).setaddress(sc.next());
			   	   break;
			   	   
			       case 3:
			       System.out.println("Enter city for editing");
				   list.get(pos).setCity(sc.next());
				   break;
				   
			       case 4:
			       System.out.println("Enter state for editing");
			 	   list.get(pos).setState(sc.next());
				   break;
				   
			       case 5:
			       System.out.println("Enter Zip for editing");
				   list.get(pos).setZip(sc.nextInt());
				   break;
				   
			       case 6:
			       System.out.println("Enter Phone Number for editing");
				   list.get(pos).setPh_no(sc.next());
				   break;
				   
			       case 7:
			       System.out.println("Enter email for editing");
				   list.get(pos).setEmail(sc.next());
				   break;
			   	   
			    }
			  }
		}
		
		
		public void deleteContactDetails(String firstName) {
	         int pos=0;
	    		
	    	 for(int i=0;i<list.size();i++) {
	    			if(list.get(i).getFirstName().equals(firstName))
	    				pos = i;
	    	 }
	    	 list.remove(pos);
	  	  }
		
		

}
