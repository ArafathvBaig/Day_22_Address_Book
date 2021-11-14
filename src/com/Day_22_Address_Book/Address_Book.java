package com.Day_22_Address_Book;

import java.util.*;

public class Address_Book 
{
	String firstName;
	String lastName;
	String email;
	String address;
	String city;
	int zip;
	long phoneNo;
	
	private static ArrayList<Contacts>list = new ArrayList<>();
	
	/*
	 * This Method Allows You To Delete Any Specific Contact From The Array List
	 * With The Help Of The First Name.
	 */
	
	public void deleteContact()
	{
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Name to Delete Contact: ");
        String name=sc.nextLine();
        for (Contacts C : list) 
        {
            if (name.equalsIgnoreCase(C.getFirstName()))
            {
                System.out.println("Entered Name found in the Address Book, deleting contact");
                list.remove(C);
            }
            else
            {
                System.out.println("Entered Name not found in the Address Book");
            }
        }
    }
	
	/*
	 * This Method Allows You To Edit The Details Of a Specific Contact and
	 * Adds That Edited Contact Details To The Array List.
	 */
	
	public void editContact()
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Name to Edit Contact: ");
        String name=sc.nextLine();
        for (Contacts C : list) 
        {
            if (name.equalsIgnoreCase(C.getFirstName())) 
            {
                System.out.println("Entered Name found in the Contacts");
                System.out.println("Enter the updated first name");
                this.firstName=sc.next();
                C.setFirstName(firstName);
                System.out.println("Enter the updated last name");
                this.lastName=sc.next();
                C.setLastName(lastName);
                System.out.println("Enter the updated emailID");
                this.email = sc.next();
                C.setEmailId(email);
                System.out.println("Enter the updated address");
                this.address=sc.next();
                C.setAddress(address);
                System.out.println("Enter the updated city");
                this.city=sc.next();
                C.setCity(city);
                System.out.println("Enter the updated zipcode");
                this.zip = sc.nextInt();
                C.setZip(zip);
                System.out.println("Enter the updated phoneNumber");
                this.phoneNo = sc.nextInt();
                C.setPhoneNo(phoneNo);
                C.display();
            } 
            else
            {
                System.out.println("Entered name not  found in the AddressBook");
            }
        }
    }
	
	/*
	 * This Method will Get The Details From the USER and
	 * ADD those details to the Array List Name Contacts through the object
	 */
	
	public void ContactsDetails()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("First Name:: ");
		this.firstName = sc.nextLine();
		System.out.println("Last Name:: ");
		this.lastName = sc.nextLine();
		for (Contacts C : list) 
        {
			while(firstName.equalsIgnoreCase(C.getFirstName()) && lastName.equalsIgnoreCase(C.getLastName())) 
			{
				System.out.println("First Name:: ");
				this.firstName = sc.nextLine();
				System.out.println("Last Name:: ");
				this.lastName = sc.nextLine();
			}
        }
		
		System.out.println("Email:: ");
		this.email = sc.nextLine();	
		System.out.println("Address:: ");
		this.address = sc.nextLine();
		System.out.println("City Name:: ");
		this.city = sc.nextLine();
		System.out.println("Zip Code:: ");
		this.zip = sc.nextInt();
		System.out.println("Phone Number:: ");
		this.phoneNo = sc.nextLong();
		Contacts person = new Contacts(firstName, lastName, email, address, city, zip, phoneNo);
        list.add(person);
        person.display();
	}
	public void showAllContacts()
	{
		for(Contacts c: list)
		{
			System.out.println(" ");
			System.out.println("First Name:: "+c.getFirstName());
			System.out.println("Last Name:: "+c.getLastName());
			System.out.println("Email:: "+c.getEmailId());
			System.out.println("Address:: "+c.getAddress());
			System.out.println("City Name:: "+c.getCity());
			System.out.println("Zip Code:: "+c.getZip());
			System.out.println("Phone Number:: "+c.getPhoneNo());
		}
	}
	public static void main(String[] args) 
	{
		HashMap<String, Address_Book> addressBooks = new HashMap<>();
		Address_Book  book1 = new Address_Book ();
		Address_Book  book2 = new Address_Book ();
		Address_Book  book3 = new Address_Book ();
		addressBooks.put("AddressBook1", book1);
		addressBooks.put("AddressBook2", book2);
		addressBooks.put("AddressBook3", book3);
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose Address Book");
		System.out.println("1. Address Book 1");
		System.out.println("2. Address Book 2");
		System.out.println("3. Address Book 3");
		int chooseAddressBook = sc.nextInt();
		System.out.println("Choose What to do in this Address Book");
		System.out.println("0. Exit");
		System.out.println("1. Add Contacts");
		System.out.println("2. Show All Contacts");
		System.out.println("3. Edit Contact");
		System.out.println("4. Delete Contact");
		System.out.println("Enter Your Choice");
		int choice = sc.nextInt();
		while(choice>=1)
		{
			switch(choice)
			{
				case 1:
					if(chooseAddressBook == 1)
					{
						book1.ContactsDetails();
					}
					else if(chooseAddressBook == 2)
					{
						book2.ContactsDetails();						
					}
					else if(chooseAddressBook == 3)
					{
						book3.ContactsDetails();
					}
					break;
					
				case 2:
					if(chooseAddressBook == 1)
					{
						book1.showAllContacts();
					}
					else if(chooseAddressBook == 2)
					{
						book2.showAllContacts();						
					}
					else if(chooseAddressBook == 3)
					{
						book3.showAllContacts();						
					}				
					break;
					
				case 3:
					if(chooseAddressBook == 1)
					{
						book1.editContact();
					}
					else if(chooseAddressBook == 2)
					{
						book2.editContact();						
					}
					else if(chooseAddressBook == 3)
					{
						book3.editContact();						
					}
					break;
					
				case 4:
					if(chooseAddressBook == 1)
					{
						book1.deleteContact();
					}
					else if(chooseAddressBook == 2)
					{
						book2.deleteContact();						
					}
					else if(chooseAddressBook == 3)
					{
						book3.deleteContact();						
					}					
					break;
		
				default:
					System.out.println("Wrong InPut");
					break;
			}
			System.out.println(" ");
			System.out.println("Choose Address Book");
			System.out.println("1. Address Book 1");
			System.out.println("2. Address Book 2");
			System.out.println("3. Address Book 3");
			chooseAddressBook = sc.nextInt();
			System.out.println(" ");
			System.out.println("Choose What to do in this Address Book");
			System.out.println("0. Exit");
			System.out.println("1. Add Contacts");
			System.out.println("2. Show All Contacts");
			System.out.println("3. Edit Contact");
			System.out.println("4. Delete Contact");
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
		}
		System.out.println("The Program Got Exit.");		
	}
}

class Contacts
{
    private String firstName = " ";
    private String lastName = " ";
    private String email = " ";
    private String address = " ";
    private String city = " ";
    private int zip = 0;
    private long phoneNo = 0;

    Contacts(String firstName, String lastName, String email, String address, String city, int zip, long phoneNo) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phoneNo = phoneNo;
    }
    
    /*
     * These Get Methods get the data from Address Book Class to Contacts.
     * These Set Methods set the data from Address Book variables to the Contacts variable.
     */
    
    public String getFirstName() 
    {
        return firstName;
    }
    public void setFirstName(String firstName) 
    {
        this.firstName=firstName;
    }
    public String getLastName() 
    {
        return lastName;
    }
    public void setLastName(String lastName) 
    {
        this.lastName=lastName;
    }
    public String getEmailId() 
    {
        return email;
    }
    public void setEmailId(String email) 
    {
        this.email=email;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getCity() 
    {
        return city;
    }
    public void setCity(String city) 
    {
        this.city=city;
    }
    public int getZip()
    {
        return zip;
    }
    public void setZip(int zip)
    {
        this.zip=zip;
    }
    public long getPhoneNo() 
    {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) 
    {
        this.phoneNo=phoneNo;
    }
    
    /*
     *This Display Method Displays Details Just Got Added To The Array List. 
     */
    
    public void display()
	{
    	System.out.println(" ");
		System.out.println("First Name:: "+firstName);
		System.out.println("Last Name:: "+lastName);
		System.out.println("Email:: "+email);
		System.out.println("Address:: "+address);
		System.out.println("City Name:: "+city);
		System.out.println("Zip Code:: "+zip);
		System.out.println("Phone Number:: "+phoneNo);
	}
}










