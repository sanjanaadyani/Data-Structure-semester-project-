import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


//Developed By :
//Ali-------023-21-0056
//Muhammad Aijaz---023-21-0055
//Sanjana Bai-------023-21-0035


class PhoneBook 
{
    Scanner s = new Scanner(System.in);
    Contact contact[] = new Contact[100];
    int contr;
    String fileName;
    

    PhoneBook(String fileName)
    {
        this.fileName = fileName;
    	for (int j = 0; j < 100; j++)
		{
        contact[j] = new Contact();
        }
    }
    
    
    boolean add(Contact c)
    {
        if(contr <= 100)
        { 
            contact[contr] = c;
            contr++;
                return true;
        }
        else 
            System.out.println("The Directory is full\n\n"); 
                return false;
        
    }
    
    
    boolean remove(String fullName)
    {
        int ind = -1;
        for(int i = 0; i < contr; i++)
        {
            if (fullName.equalsIgnoreCase(contact[i].getFname()))
            {
                ind = i;
                for(int j=ind; j<contr; j++)
                {
                    contact[j] = contact[j+1];
                }
                    contr--;
                        return true;
            }
        }
            return false;
    }
    
    
    Contact search(String fullName)
    {
    	for(int i = 0; i <contr; i++)
            if(fullName.equalsIgnoreCase(contact[i].getFname()))
            {
                System.out.println("Name\t\t       Phone Number\n" + 
                                   "*************************************");
                            System.out.print(contact[i].getFname() + " " +
                            contact[i].getLname() + "\t\t");
                            System.out.println(contact[i].getPhone());
                System.out.println("***********************************\n");
            }
                else
                    System.out.println("Contact Not Found.\n");
    	return null;
    }
    
     
    
    void print()
    {
        
            System.out.println("Name\t\t       Phone Number\n" + 
                               "****************************************");
        for(int i = 0;  i < contr; i++) 
        {
            System.out.print(contact[i].getFname() + " " + contact[i].getLname());
            System.out.format("%21s%n", contact[i].getPhone());
        }
            System.out.println("*****************************************\n");
    }
    
    
    boolean load()
    {
        try {
            contr = 0;
            int lineNumber = 3;
            Scanner s = new Scanner(new File(fileName));
            while(s.hasNext())
            {
                if(lineNumber % 3 == 0 )
                    this.contact[contr].setFname(s.next());
                if(lineNumber % 3 == 1 )
                    this.contact[contr].setLname(s.next());
                if(lineNumber % 3 == 2 ) 
                {
                    this.contact[contr].setPhone(s.next());
                    contr++;
                }
                lineNumber++;
            }
            s.close();
            return true;
        } 
        catch (FileNotFoundException c) 
        {
            System.out.println("Unable to read file.\n");
            System.exit(0);
        }
        return false;
    }
    
    
    boolean save()
    {
        try 
        {
            FileWriter writer = new FileWriter(new File(fileName));
            for(int i = 0; i < contr; i++)
            {
                writer.write(contact[i].getFname());
                writer.write("\n");
                writer.write(contact[i].getLname());
                writer.write("\n");
                writer.write(contact[i].getPhone());
                writer.write("\n\n");
            }
            writer.close();
            return true;
        } 
            catch (IOException c) 
            {
            System.out.println("Not saved.\n");
            }
        return false;
    }
  
}


class Contact 
{
    String Fname;
    String Lname;
    String phone;
    
    

    Contact() 
    {
        this.Fname = "";
        this.Lname = "";
        this.phone = "";
    }
        
    
    Contact(String Fname, String Lname, String phone)
    {
        this.Fname = Fname;
        this.Lname = Lname;
        this.phone = phone;
    }

    
    String getFname() 
    {
        return Fname;
    }


    void setFname(String Fname) 
    {
        this.Fname = Fname;
    }


    String getLname() 
    {
        return Lname;
    }

    
    void setLname(String Lname) 
    {
        this.Lname = Lname;
    }


    String getPhone() 
    {
        return phone;
    }


    void setPhone(String phone) 
    {
        this.phone = phone;
    }
   
    
    boolean equals(){
        if(Lname.equals(Fname))
        {
            return true;
        }
        else
            return false;
    }
   
    
    String tostring() 
    {
        return (this.Fname + " "+ this.Lname + " " + this.phone);
    }


    
}



class Project
{
    static Scanner s = new Scanner(System.in);
    static String first = "";
    static String last = "";
    static String number = "";
        
    
     
    static int functions()
    {
        System.out.println("What would you like to do?\n"+
                            "1) Show all contacts\n"+
                            "2) Add new  contact\n"+
                            "3) Delete any contact\n"+
                            "4) Search any contact\n"+
                            "5) Update any contact\n"+
                            "6) Exit Directory");
        System.out.print("Your choice: ");
        return s.nextInt();
    }
        

    
    static Contact userInfo() 
    {
            System.out.print("Enter First Name: ");
            first = s.next();
            System.out.print("Enter Last Name: ");
            last = s.next();
            System.out.print("Enter Phone Number: ");
            number = s.next();
            System.out.println("Contact Saved Succesfully.\n");
            Contact contact = new Contact(first, last, number);
            return contact;
    }
    
    
    
    static String userFullNametoRemove() 
    {
        System.out.print("Enter First name to Remove: ");
        return s.next();
    }
        
    
    
    static String userFullNametoSearch() 
    {
        System.out.print("Enter First name to Search: ");
        return s.next();
    }
    
    
    
    static String userFullNametoUpdate() 
    {
        System.out.print("Enter First Name of Contact: ");
        return s.next();
    }
    
    
    
    static Contact updateContact() 
    {
            System.out.print("Updated First Name: ");
            first = s.next();
            System.out.print("Updated Last Name: ");
            last = s.next();
            System.out.println("Contact Successfully saved.");
            Contact contact = new Contact(first, last, number);
            return contact;
    }
    
    
    
    public static void main(String[] args) 
    {
        PhoneBook phoneBook = new PhoneBook("C:\\Users\\MV\\Desktop\\contact.txt");
        if(phoneBook.load())
        {
            System.out.println("Welcome. Contact Directory .\n");
        }
        
        while(true)
        {        
            
            loop:switch(functions()) 
            {
                case 1: 
                    phoneBook.print();
                    break;        
                case 2:
                    phoneBook.add(userInfo());
                    break;
                case 3:
                   if(phoneBook.remove(userFullNametoRemove()))
                    {
                        phoneBook.print();
                    } 
                        else 
                        {
                            System.out.println(" Contact Not found.");
                        }
                    break;
                case 4:
                    phoneBook.search(userFullNametoSearch());
                    break;
                case 5:
                    if(phoneBook.remove(userFullNametoUpdate()))
                    {
                        phoneBook.add(updateContact());
                    }
                        else
                            System.out.println("Not Found");
                        break;
                case 6:
                    if (phoneBook.save()){
                        System.out.println("Program End.");
                        System.exit(0);
                    }
                    break loop;
                default: 
                    System.out.print("you choosed invalid functions number!\n\n");

            }
        }
       
    }
}