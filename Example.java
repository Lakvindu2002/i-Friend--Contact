
import java.util.*;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Example{
	
	public static Scanner sc=new Scanner(System.in);
	public static int userInput=0;
	public static int counter=1;
	public static String CustomerId="";
	public static String phoneNumber="";
	public static String userName="";
	public static String birthDay="";
	public static String comapnyName="";
	public static double salary=0;
	
	
	//Array Declorations
	
	public static String [] customerIdArray=new String[0];
	public static String [] phoneNumberArray=new String[0];
	public static String [] userNameArray=new String[0];
	public static String [] birthDayArray=new String[0];
	public static String [] comapnyNameArray=new String[0];
	public static double [] salaryArray=new double[0];
	
	
	//method for home page
	public static void HomePage(){
		
		
    
        System.out.println("\n\n					 /$$       /$$$$$$$$        /$$                           /$$");
        System.out.println("					|__/      | $$_____/       |__/                          | $$");
        System.out.println("				 	/$$      | $$     /$$$$$$  /$$  /$$$$$$  /$$$$$$$   /$$$$$$$");
        System.out.println("					| $$      | $$$$$ /$$__  $$| $$ /$$__  $$| $$__  $$ /$$__  $$");
        System.out.println("					| $$      | $$__/| $$  \\__/| $$| $$$$$$$$| $$  \\ $$| $$  | $$");
        System.out.println("					| $$      | $$   | $$      | $$| $$_____/| $$  | $$| $$  | $$");
        System.out.println("					| $$      | $$   | $$      | $$|  $$$$$$$| $$  | $$|  $$$$$$$");
        System.out.println("					|__/      |__/   |__/      |__/ \\_______/|__/  |__/ \\_______/");
        System.out.println("		                                                             ");
        System.out.println("		 		                                                            ");
        System.out.println("		 		                                ");
    
    
    System.out.println("		   _____            _             _      ____                        _              ");
System.out.println("		  / ____|          | |           | |    / __ \\                      (_)             ");
System.out.println("		 | |     ___  _ __ | |_ __ _  ___| |_  | |  | |_ __ __ _  __ _ _ __  _ _______ _ __ ");
System.out.println("		 | |    / _ \\| '_ \\| __/ _` |/ __| __| | |  | | '__/ _` |/ _` | '_ \\| |_  / _ \\ '__|");
System.out.println("		 | |___| (_) | | | | || (_| | (__| |_  | |__| | | | (_| | (_| | | | | |/ /  __/ |   ");
System.out.println("		  \\_____\\___/|_| |_|\\__\\__,_|\\___|\\__|  \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___|_|   ");
System.out.println("		                                                    __/ |                           ");
System.out.println("		                                                   |___/                            ");

System.out.println("		=================================================================================\n\n");


System.out.println("[1] ADD Contacts\n\n[2] UPDATE Contacts\n\n[3] DELETE Contacts\n\n[4] SEARCH Contacts\n\n[5] LIST Contacts\n\n[5] Exit");

System.out.print("\n\nEnter Oprion --> ");
userInput=sc.nextInt();

	L1:while(true){
		switch(userInput){
	
	case 1->{
		
			addContacts();
			break L1;
		}
	case 2 ->{
			updateContacts();
			break L1;
		}	
		
	case 3 ->{
			deleteContacts();
			break L1;
		}	
		
	default ->{
				HomePage();
				break L1;
		}	
	
	
	
	}
		}

}

//----------------------add contact main function---------------//

public static void addContacts(){
	
	
	L1: while(true){
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("|                             Add Contact List                            |");
		System.out.println("--------------------------------------------------------------------------");
		
		
		CustomerId=generateCustomerID();
	System.out.println("\nCustomer id : "+CustomerId);
	System.out.print("\n Enter Name : ");
	userName=sc.next();
	L2 :while(true){
		
		System.out.print("\nPhone number : ");
        phoneNumber=sc.next();
		
		if(!phoneNumberValidation(phoneNumber)){
			System.out.println("\nPlease Enter valid Phone number...!\n");
			continue L2;
			}else{
				break L2;
				}
		
		}
		
		L3:while(true){
			System.out.print("\nEnter Birth Day (YYYY/MM/DD) : ");
			birthDay=sc.next();
			if(birthdayValidation(birthDay)){
				break L3;
				}else{
					
					System.out.println("\nPlease Enter Valid Birth Day..!\n");
					continue L3;
					}
			
			}
		L5:	
			while(true){
				
			System.out.print("\nEnter Salary : ");
			salary=sc.nextDouble();
			
			if(salary>=0){
				break L5;
				
				}else{
					System.out.println("\n Please check the value..!");
					continue L5;
					
					}
				
				}
			
			
			L4:while(true){
				
				System.out.print("\nEnter Company Name : ");
				comapnyName=sc.next();
				
				if(checkNotNull(comapnyName)){
					break L4;
					
					}else{
						
						System.out.println("\nYou Must Complete This field....!");
						continue L4;
						}
				
				}
				
				extendArrays();
				
				customerIdArray[customerIdArray.length-1]=CustomerId;
				phoneNumberArray[phoneNumberArray.length-1]=phoneNumber;
				birthDayArray[birthDayArray.length-1]=birthDay;
				comapnyNameArray[comapnyNameArray.length-1]=comapnyName;
				userNameArray[userNameArray.length-1]=userName;
				salaryArray[salaryArray.length-1]=salary;
				
				System.out.println("\n\t\t\tContact has been added Successfully...!");
				
				L5:
				while(true){
				System.out.print("\nDo you want to add annother Data.?(y/n) : ");
				char choice=sc.next().toUpperCase().charAt(0);
				
				
					
					if(choice=='Y'){
						continue L1;
						
						}else if(choice=='N'){
							
							HomePage();
							break L1;
							
							}else{
								continue L5;
								
								}
					
					}
		
		
		
		}
	
	
	
	
	}

//generate customer id

public static String generateCustomerID() {
        return String.format("C%04d", counter++);
    }	
public static void decrementCustomerID() {
        if (counter > 1) { 
            counter--;
        }
    }			

//phone number validation

public static boolean phoneNumberValidation(String number){
	
		if(number!=null && number.length()==10 && number.charAt(0)=='0'){
			return true;
			}
	return false;
	}	

//birth day validation

public static boolean birthdayValidation(String birthDay){
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            
            LocalDate birthDate = LocalDate.parse(birthDay, formatter);

            
            LocalDate today = LocalDate.now();

            
            if (!birthDate.isAfter(today) && birthDate.isAfter(today.minusYears(100))) {
                return true;
            }
        } catch (DateTimeParseException e) {
            
        }

        return false; 
	
	}	
	
//company validation (check not null)

public static boolean checkNotNull(String comapnyName){
	
	if(comapnyName!=null){
		return true;
		
		}
		return false;
	
	}	
	
	
//method for extend array

public static void extendArrays(){
	 String [] TempcustomerIdArray=new String[customerIdArray.length+1];
	 String [] TempphoneNumberArray=new String[customerIdArray.length+1];
	 String [] TempuserNameArray=new String[customerIdArray.length+1];
	 String [] TempbirthDayArray=new String[customerIdArray.length+1];
	 String [] TempcomapnyNameArray=new String[customerIdArray.length+1];
	 double [] TempsalaryArray=new double[salaryArray.length+1];
	 
	 for(int i=0;i<customerIdArray.length;i++){
		 TempcustomerIdArray[i]=customerIdArray[i];
		 TempphoneNumberArray[i]=phoneNumberArray[i];
		 TempuserNameArray[i]=userNameArray[i];
		 TempbirthDayArray[i]=birthDayArray[i];
		 TempcomapnyNameArray[i]=comapnyNameArray[i];
		 TempsalaryArray[i]=salaryArray[i];
		 
		 }
		 
		 birthDayArray=TempbirthDayArray;
		 customerIdArray=TempcustomerIdArray;
		 phoneNumberArray=TempphoneNumberArray;
		 userNameArray=TempuserNameArray;
		 comapnyNameArray=TempcomapnyNameArray;
		 salaryArray=TempsalaryArray;
		 
		
	
	
	}	


//---------------------------Update Customer Contacts----------------------------------------//

public static void updateContacts(){
	

	L1:
	while(true){
	System.out.println("\n\n\n-----------------------------------------------------------");
	System.out.println("|                     UPDATE CONTACT                        |");
	System.out.println("-------------------------------------------------------------\n");
	
	System.out.print("Enter phone number or name : ");
	String input=sc.next();
	
		int numberLength=input.length();
		char firsNumber=input.charAt(0);
		
		if(numberLength==10 && firsNumber=='0'){
			
			printUsingNumber(input);
			break L1;
			
			}else{
				if(checkNotNull(input)){
					printUsingName(input);
					break L1;
					}
				
				
				}
	
		}
	
	
	}
	
//print using name

public static void printUsingName(String name){
	
	int index=searchCustomerByname(name);
    if(index!=-1){
		
		System.out.println("\n ID                  : "+customerIdArray[index]);
		System.out.println("\nName                 : "+userNameArray[index]);
		System.out.println("\nPhone Number         : "+phoneNumberArray[index]);
		System.out.println("\nCompany Name         : "+comapnyNameArray[index]);
		System.out.println("\nSalary               : "+salaryArray[index]);
		System.out.println("\nB'Day(YYYY-MM-DD)    : "+birthDayArray[index]);
		
			askFunction(index);
			
		
		}else{
			L1:	while(true){
			
			System.out.println("There Is no Result for this name..!\n\n");
			System.out.print("Do you want to Search Again(y/n) : ");
			
			char choice=sc.next().toUpperCase().charAt(0);
			
			if(choice=='Y'){
				updateContacts();
				break;
				}else if(choice=='N'){
					HomePage();
					break;
					}else{
						continue L1;
						}
			
			
			}
			
			}
		
	
	
	
	}
	
//Function to Ask what they want to update

	public static void askFunction(int index){
		
		System.out.println("\n\n\nWhat Do You Want to Update ...! \n\n\n\n\n \t\t[1]Name\n\n\t\t[2]Phone Number\n\n\t\t[3]Company Name\n\n\t\t[4]Salary\n\n\t\t");
		System.out.print("\n\n Enter an option to continue ->  ");
		userInput=sc.nextInt();
		
			L1:while(true){
				
						switch(userInput){
			
			case 1->{
						updateName(index);
						break L1;
						
				}
			case 2 ->{
						updatePhoneNumber(index);
						break L1;
				  }	
			
			case 3 ->{
						updateCompanyName(index);
						break L1;
				  }	
			
			case 4 ->{
						updateSalary(index);
						break L1;
				  }	
			default ->{
						System.out.println("\n\nPlease Enter Valid Input...!\n\n");
						continue L1;
					}	  
			
			
			}
				
				
				}
		
		}
		
//----------------function to updatesingle detail------------
		
public static void updateName(int index){
	
	System.out.print("\n\nEnter New Name : ");
	String uInput=sc.next();
	
	userNameArray[index]=uInput;
	
	System.out.println("\n\n Updated Succsessfullly");
	
	while(true){
		System.out.print("\n\nDo you want to Update another contact(y/n) : ");
		char choice=sc.next().toUpperCase().charAt(0);
		
		if(choice=='Y'){
			updateContacts();
			break;
			
			}else if(choice=='N'){
				HomePage();
				break;
				
				}else{
					continue;
					}
		
		}
	
	}
public static void updatePhoneNumber(int index){
	
	System.out.print("\n\nEnter New Phone number : ");
	String uInput=sc.next();
	
	phoneNumberArray[index]=uInput;
	
	System.out.println("\n\n Updated Succsessfullly");
	
	while(true){
		System.out.print("\n\nDo you want to Update another contact(y/n) : ");
		char choice=sc.next().toUpperCase().charAt(0);
		
		if(choice=='Y'){
			updateContacts();
			break;
			
			}else if(choice=='N'){
				HomePage();
				break;
				
				}else{
					continue;
					}
		
		}
	
	
	}
public static void updateCompanyName(int index){
	
	System.out.print("\n\nEnter New Name : ");
	String uInput=sc.next();
	
	comapnyNameArray[index]=uInput;
	
	System.out.println("\n\n Updated Succsessfullly");
	
	while(true){
		System.out.print("\n\nDo you want to Update another contact(y/n) : ");
		char choice=sc.next().toUpperCase().charAt(0);
		
		if(choice=='Y'){
			updateContacts();
			break;
			
			}else if(choice=='N'){
				HomePage();
				break;
				
				}else{
					continue;
					}
		
		}
	
	
	}
public static void updateSalary(int index){
	
	System.out.print("\n\nEnter New Salary : ");
	double uInput=sc.nextDouble();
	
	salaryArray[index]=uInput;
	
	System.out.println("\n\n Updated Succsessfullly");
	
	while(true){
		System.out.print("\n\nDo you want to Update another contact(y/n) : ");
		char choice=sc.next().toUpperCase().charAt(0);
		
		if(choice=='Y'){
			updateContacts();
			break;
			
			}else if(choice=='N'){
				HomePage();
				break;
				
				}else{
					continue;
					}
		
		}
	
	}
		
	
//search customer by name

public static int searchCustomerByname(String name){
	
	for(int i=0;i<userNameArray.length;i++){
		if(userNameArray[i].equals(name)){
			return i;
			}
		
		}
		return -1;
	
	
	}	
	

//print  using number

public static void printUsingNumber(String pNum){
	
    int index=searchCustomerindex(pNum);
	
	if(index!=-1){
		
		System.out.println("\n ID                  : "+customerIdArray[index]);
		System.out.println("\nName                 : "+userNameArray[index]);
		System.out.println("\nPhone Number         : "+phoneNumberArray[index]);
		System.out.println("\nCompany Name         : "+comapnyNameArray[index]);
		System.out.println("\nSalary               : "+salaryArray[index]);
		System.out.println("\nB'Day(YYYY-MM-DD)    : "+birthDayArray[index]);
		
		
		
		
		}else{
						L1:	while(true){
			
			System.out.println("There Is no Result for this name..!\n\n");
			System.out.print("Do you want to Delete Another Contact(y/n) : ");
			
			char choice=sc.next().toUpperCase().charAt(0);
			
			if(choice=='Y'){
				deleteContacts();
				break;
				}else if(choice=='N'){
					HomePage();
					break;
					}else{
						continue L1;
						}
			
			
			}
			
			
			}
	
	}

//searchUsing phone number method

public static int searchCustomerindex(String pNum){
	
	for(int i=0;i<phoneNumberArray.length;i++){
		if(phoneNumberArray[i].equals(pNum)){
			return i;
			}
		
		}
		return -1;
	
	}


//-------------------------------main function to delete contacts---------------------------------

public static void deleteContacts(){
	
	L1:
	while(true){
	System.out.println("\n\n-------------------------------------------------------");
	System.out.println("|                   Delete Contacts                   |");
	System.out.println("------------------------------------------------------\n\n");
	
	System.out.print("Enter phone number or name : ");
	String input=sc.next();
	
		int numberLength=input.length();
		char firsNumber=input.charAt(0);
		
		if(numberLength==10 && firsNumber=='0'){
			
			printUsingNumber2(input);
			break L1;
			
			}else{
				if(checkNotNull(input)){
					printUsingName2(input);
					break L1;
					}
				
				
				}
	
		}
	
	}
	
//delete customer function print details using name

public static void printUsingName2(String name){
	
	int index=searchCustomerByname(name);
    if(index!=-1){
		
		System.out.println("\n ID                  : "+customerIdArray[index]);
		System.out.println("\nName                 : "+userNameArray[index]);
		System.out.println("\nPhone Number         : "+phoneNumberArray[index]);
		System.out.println("\nCompany Name         : "+comapnyNameArray[index]);
		System.out.println("\nSalary               : "+salaryArray[index]);
		System.out.println("\nB'Day(YYYY-MM-DD)    : "+birthDayArray[index]);
		

		
		}else{
			L1:	while(true){
			
			System.out.println("\n\nThere Is no Result for this name..!\n\n");
			System.out.print("\n\nDo you want to Delete another contact (y/n) : ");
			
			char choice=sc.next().toUpperCase().charAt(0);
			
			if(choice=='Y'){
				deleteContacts();
				break;
				}else if(choice=='N'){
					HomePage();
					break;
					}else{
						continue L1;
						}
			
			
			}
			
			}
			
			L2 : while(true){
				
				System.out.print("\n\nDo you want to delete this contact (y/n) : ");
				
				char choice=sc.next().toUpperCase().charAt(0);
				
				if(choice=='Y'){
					deleteCustomerPerment(index);
					break L2;
					}else if(choice=='N'){
						HomePage();
						break L2;
						
						}else{
							
							continue L2;
							}
				
				}
				L3 :while(true){
					System.out.print("\n\nDo you want to delete another contact (y/n) : ");
				
				char choice=sc.next().toUpperCase().charAt(0);
				
				if(choice=='Y'){
					deleteContacts();
					break L3;
					}else if(choice=='N'){
						HomePage();
						break L3;
						
						}else{
							
							continue L3;
							}
					}
		
	
	
	
	}


//--------delete customer function print details using number-----


public static void printUsingNumber2(String pNum){
	
    int index=searchCustomerindex(pNum);
	
	if(index!=-1){
		
		System.out.println("\n ID                  : "+customerIdArray[index]);
		System.out.println("\nName                 : "+userNameArray[index]);
		System.out.println("\nPhone Number         : "+phoneNumberArray[index]);
		System.out.println("\nCompany Name         : "+comapnyNameArray[index]);
		System.out.println("\nSalary               : "+salaryArray[index]);
		System.out.println("\nB'Day(YYYY-MM-DD)    : "+birthDayArray[index]);
		
		
		
		
		}else{
			L1:	while(true){
			
			System.out.println("\n\nThere Is no Result for this number..!\n\n");
			System.out.print("\n\nDo you want to Delete another contact(y/n) : ");
			
			char choice=sc.next().toUpperCase().charAt(0);
			
			if(choice=='Y'){
				deleteContacts();
				break L1;
				}else if(choice=='N'){
					HomePage();
					break L1;
					}else{
						continue L1;
						}
			
			
			}
			
			
			}
			
			L2 : while(true){
				
				System.out.print("\n\nDo you want to delete this contact (y/n) : ");
				
				char choice=sc.next().toUpperCase().charAt(0);
				
				if(choice=='Y'){
					deleteCustomerPerment(index);
					break L2;
					}else if(choice=='N'){
						HomePage();
						break L2;
						
						}else{
							
							continue L2;
							}
				
				}
				L3 :while(true){
					System.out.print("\n\nDo you want to delete another contact (y/n) : ");
				
				char choice=sc.next().toUpperCase().charAt(0);
				
				if(choice=='Y'){
					deleteContacts();
					break L3;
					}else if(choice=='N'){
						HomePage();
						break L3;
						
						}else{
							
							continue L3;
							}
					}
	
	}

//function to delete customerPerment

public static void deleteCustomerPerment(int index){
	
	 String [] TempcustomerIdArray=new String[customerIdArray.length-1];
	 String [] TempphoneNumberArray=new String[customerIdArray.length-1];
	 String [] TempuserNameArray=new String[customerIdArray.length-1];
	 String [] TempbirthDayArray=new String[customerIdArray.length-1];
	 String [] TempcomapnyNameArray=new String[customerIdArray.length-1];
	 double [] TempsalaryArray=new double[salaryArray.length-1];
	 
	 for(int i=0;i<index;i++){
		 TempcustomerIdArray[i]=customerIdArray[i];
		 TempphoneNumberArray[i]=phoneNumberArray[i];
		 TempuserNameArray[i]=userNameArray[i];
		 TempbirthDayArray[i]=birthDayArray[i];
		 TempcomapnyNameArray[i]=comapnyNameArray[i];
		 TempsalaryArray[i]=salaryArray[i];
		 
		 }
		 
		 for(int i=index;i<TempcustomerIdArray.length;i++){
			
			TempcustomerIdArray[i]=customerIdArray[i];
		    TempphoneNumberArray[i]=phoneNumberArray[i];
		    TempuserNameArray[i]=userNameArray[i];
		    TempbirthDayArray[i]=birthDayArray[i];
		    TempcomapnyNameArray[i]=comapnyNameArray[i];
		    TempsalaryArray[i]=salaryArray[i];
			
			 }
			 customerIdArray=TempcustomerIdArray;
			 phoneNumberArray=TempphoneNumberArray;
			 userNameArray=TempuserNameArray;
			 birthDayArray=TempbirthDayArray;
			 comapnyNameArray=TempcomapnyNameArray;
			 salaryArray=TempsalaryArray;


		System.out.println("\n\n\t\tContact Deleted Successfully...!\n\n");
	
	}


	public static void main(String [] args){
		
		HomePage();
		
		}
	
	}
