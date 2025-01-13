
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
	
	
	//Array Declorations
	
	public static String [] customerIdArray=new String[0];
	public static String [] phoneNumberArray=new String[0];
	public static String [] userNameArray=new String[0];
	public static String [] birthDayArray=new String[0];
	public static String [] comapnyNameArray=new String[0];
	
	
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

switch(userInput){
	
	case 1->{
		
			addContacts();
		}
	case 2 ->{
			updateContacts();
		}	
		
	default ->{
				HomePage();
		}	
	
	
	
	}

}

//add contats

public static void addContacts(){
	
	
	L1: while(true){
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("|                             Add Contact List                            |");
		System.out.println("--------------------------------------------------------------------------");
		
		
		CustomerId=generateCustomerID();
	System.out.println("\nCustomer id : "+CustomerId);
	System.out.print("\nEnter Name : ");
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
			L4:while(true){
				
				System.out.print("\nEnter Company Name : ");
				comapnyName=sc.next();
				
				if(checkNotNull(comapnyName)){
					break L4;
					
					}else{
						
						System.out.println("You Must Complete This field....!");
						continue L4;
						}
				
				}
				
				extendArrays();
				
				customerIdArray[customerIdArray.length-1]=CustomerId;
				phoneNumberArray[phoneNumberArray.length-1]=phoneNumber;
				birthDayArray[birthDayArray.length-1]=birthDay;
				comapnyNameArray[comapnyNameArray.length-1]=comapnyName;
				userNameArray[userNameArray.length-1]=userName;
				
				System.out.println("\n\t\t\tContact has been added Successfully...!");
				
				System.out.print("\nDo you want to add annother Data.?(y/n) : ");
				char choice=sc.next().toUpperCase().charAt(0);
				
				L5:while(true){
					
					if(choice=='Y'){
						continue L1;
						
						}else if(choice=='N'){
							
							HomePage();
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
	 
	 for(int i=0;i<customerIdArray.length;i++){
		 TempcustomerIdArray[i]=customerIdArray[i];
		 TempphoneNumberArray[i]=phoneNumberArray[i];
		 TempuserNameArray[i]=userNameArray[i];
		 TempbirthDayArray[i]=birthDayArray[i];
		 TempcomapnyNameArray[i]=comapnyNameArray[i];
		 
		 }
		 
		 birthDayArray=TempbirthDayArray;
		 customerIdArray=TempcustomerIdArray;
		 phoneNumberArray=TempphoneNumberArray;
		 userNameArray=TempuserNameArray;
		 comapnyNameArray=TempcomapnyNameArray;
		 
		
	
	
	}	


//---------------------------Update Customer Contacts----------------------------------------//

public static void updateContacts(){
	
	
	}



	
	public static void main(String [] args){
		
		HomePage();
		
		}
	
	}
