package com.Day_22_Address_Book;

import java.util.*;
import java.util.stream.Stream;

public class Address_Book 
{
	String firstName;
	String lastName;
	String email;
	String address;
	String city;
	String state;
	int zip;
	long phoneNo;
	
	public ArrayList<Contacts>list = new ArrayList<>();
	public static HashMap<String, Address_Book> addressBooks = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	
	/*
	 * This Method Allows You To Delete Any Specific Contact From The Array List
	 * With The Help Of The First Name.
	 */
	
	public void deleteContact()
	{
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
                System.out.println("Enter the updated State");
                this.state=sc.next();
                C.setState(state);
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
		System.out.println();
		System.out.println("First Name:: ");
		this.firstName = sc.nextLine();
		System.out.println("Last Name:: ");
		this.lastName = sc.nextLine();
		System.out.println("Email:: ");
		this.email = sc.nextLine();	
		System.out.println("Address:: ");
		this.address = sc.nextLine();
		System.out.println("City Name:: ");
		this.city = sc.nextLine();
		System.out.println("State Name:: ");
		this.state = sc.nextLine();
		System.out.println("Zip Code:: ");
		this.zip = sc.nextInt();
		System.out.println("Phone Number:: ");
		this.phoneNo = sc.nextLong();
		Contacts person = new Contacts(firstName, lastName, email, address, city, state, zip, phoneNo);
        list.add(person);
        person.display();
	}
	
	/*
	 * This method is used to search by first name
	 */
	public void searchByFirstName(String firstName)
	{
        for (Map.Entry<String, Address_Book> entry : addressBooks.entrySet()) 
        {
            System.out.println(entry.getKey());
            Stream<Contacts> search = entry.getValue().list.stream().filter(i -> i.getFirstName().equals(firstName));
            search.forEach(str -> System.out.println(str.toString()));
        }
    }
	
	 /*
     * This method is used to search by city or state
     * */
    public void searchByCityOrState() 
    {
        System.out.println("1. Search by City:");
        System.out.println("2. Search by State");
        int option = sc.nextInt();
        if (option == 1)
        {
            System.out.println("Enter City Name:");
            String city = sc.next();
            for (Map.Entry<String, Address_Book> entry : addressBooks.entrySet())
            {
                System.out.println(entry.getKey());
                Stream<Contacts> search = entry.getValue().list.stream().filter(i -> i.getCity().equals(city));
                search.forEach(str -> System.out.println(str.toString()));
            }
        } 
        else if (option == 2)
        {
            System.out.println("Enter State Name:");
            String state = sc.next();
            for (Map.Entry<String, Address_Book> entry : addressBooks.entrySet()) 
            {
                System.out.println(entry.getKey());
                Stream<Contacts> search = entry.getValue().list.stream().filter(i -> i.getState().equals(state));
                search.forEach(str -> System.out.println(str.toString()));
            }
        } 
        else 
        {
        	System.out.println("Wrong Input");
        }
    }
    
    /*
     * This method is used to search number of contacts by city or state
     * */
    public void countByCityOrState() 
    {
    	System.out.println("1. Count by City:");
        System.out.println("2. Count by State");
        int option = sc.nextInt();
        if (option == 1)
        {
            System.out.println("Enter City Name:");
            String city = sc.next();
            for (Map.Entry<String, Address_Book> entry : addressBooks.entrySet()) 
            {
                System.out.println(entry.getKey());
                Stream<Contacts> search = entry.getValue().list.stream().filter(i -> i.getCity().equals(city));
                System.out.println("Number of contacts in " + city + " are : " + search.count());
            }
        } 
        else if (option == 2)
        {
            System.out.println("Enter State Name:");
            String state = sc.next();
            for (Map.Entry<String, Address_Book> entry : addressBooks.entrySet()) 
            {
                System.out.println(entry.getKey());
                Stream<Contacts> search = entry.getValue().list.stream().filter(i -> i.getState().equals(state));
                System.out.println("Number of contacts in " + state + " are : " + search.count());
            }
        } 
        else
        {
        	System.out.println("Wrong Input");
        }
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
			System.out.println("City :: "+c.getCity());
			System.out.println("State :: "+c.getState());
			System.out.println("Zip Code:: "+c.getZip());
			System.out.println("Phone Number:: "+c.getPhoneNo());
		}
	}
	
	/**
     * showContacts is used to display contacts
     */
    public void showContacts() 
    {
        int i = 1;
        for (Contacts contact : list)
        {
            System.out.println("Contact Details of :: "+i);
            System.out.println(contact.toString());
            i++;
        }
    }
	
	public static void main(String[] args) 
	{	
		Address_Book  address_Book = new Address_Book();
		Scanner sc = new Scanner(System.in);
		Address_Book  book1 = new Address_Book();
		Address_Book  book2 = new Address_Book();
		Address_Book  book3 = new Address_Book();
		addressBooks.put("AddressBook1", book1);
		addressBooks.put("AddressBook2", book2);
		addressBooks.put("AddressBook3", book3);
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
		System.out.println("5. Search By City or State");
		System.out.println("6. Count By City or State");
		System.out.println("Enter Your Choice");
		int choice = sc.nextInt();
		while(choice!=0)
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
						book1.showContacts();
					}
					else if(chooseAddressBook == 2)
					{
						book2.showContacts();						
					}
					else if(chooseAddressBook == 3)
					{
						book3.showContacts();						
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
					
				case 5:
					address_Book.searchByCityOrState();
					break;
					
				case 6:
					address_Book.countByCityOrState();
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
			System.out.println("5. Search By City or State");
			System.out.println("6. Count By City or State");
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
    private String state = " ";
    private int zip = 0;
    private long phoneNo = 0;

    Contacts(String firstName, String lastName, String email, String address, String city, String state, int zip, long phoneNo) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
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
    public String getState() 
    {
        return state;
    }
    public void setState(String state) 
    {
        this.state=state;
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
		System.out.println("First Name :: "+firstName);
		System.out.println("Last Name :: "+lastName);
		System.out.println("Email :: "+email);
		System.out.println("Address :: "+address);
		System.out.println("City :: "+city);
		System.out.println("State :: "+state);
		System.out.println("Zip Code :: "+zip);
		System.out.println("Phone Number :: "+phoneNo);
	}
    
    @Override
	public String toString() 
    {		
		return "\nPerson Details:"+
				"\nFirst Name :: "+firstName+
				"\nLast Name :: "+lastName+
				"\nEmail :: "+email+
				"\nAddress :: "+address+
				"\nCity :: "+city+
				"\nState :: "+state+
				"\nZip Code :: "+zip+
				"\nPhone Number :: "+phoneNo;				
	}
}










