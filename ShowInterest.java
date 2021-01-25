/* 
Harish Kandaswamy
11-4-18
This program shows interest/inflation over time.
*/

import java.util.*;

public class ShowInterest
{
        public static void main(String[] args) // This is the main method of the program, which only calls the run method.
        {
                run();
        }
  
        public static void run() // Combines all the other methods to create the working program.
        {
                Scanner kb = new Scanner(System.in);
                boolean customer = true;
                while(customer)
                {
                        description();
                        String option = getOption(kb);
                        if(option.equalsIgnoreCase("interest"))
                        {
                                getInterest(kb);
                                boolean flag = true;
                                while(flag)
                                {
                                        kb.nextLine();
                                        String yesOrNo = getYesOrNo(kb,"Do you have another bank to compare: ");
                                        if(yesOrNo.equalsIgnoreCase("yes"))
                                        {
                                                kb.nextLine();
                                                getInterest(kb);
                                        }
                                        else
                                        {
                                                flag = false;
                                        }
                                }
                        }
                        else if(option.equalsIgnoreCase("future value"))
                        {
                                getFutureValue(kb);
                        }
                        kb.nextLine();
                        String repeat = getYesOrNo(kb,"Is there another customer? ");
                        if(repeat.equalsIgnoreCase("no"))
                        { 
                                customer = false;
                        }
                        kb.nextLine();
                } 
        } 
   
        public static void description() // Prints a description of the program.
        {  
                for(int i = 0; i<=100;i++)
                {
                        System.out.print("=");
                }  
                System.out.println();
                System.out.println("Using this software you can see how money increases over time given particular");
                System.out.println("interest rate and a regular deposit amount. The program is written with parameters");
                System.out.println("so that these values could be changed to compute a different interest rate,");
                System.out.println("number of years, starting amount or deposit amount.\n");
                for(int j = 0; j <= 100 ; j++)
                {
                        System.out.print("=");
                }  
                System.out.println();
        }
   
        public static String getOption(Scanner kb) // Loops until the user types a valid option.
        {
                System.out.println("Choose one of the following options");
                System.out.println("Interest");
                System.out.println("Future value");
                String option = "";
                boolean flag = true;
                while(flag)
                {
                        System.out.print("Enter your option --> ");
                        option = kb.nextLine();
                        if(option.equalsIgnoreCase("interest"))
                        {
                                flag = false;
                                return option;
                        }
                        else if(option.equalsIgnoreCase("Future value"))
                        {
                                flag = false;
                                return option;
                        }
                        else
                        {
                                System.out.println("Invalid option");
                        }
                }
                return null;
        }
   
        public static void getInterest(Scanner kb) // Asks the user for info to calculate interest.
        {
                System.out.println();      
                System.out.println();
                System.out.print("Enter the name of the bank: ");
                String bank = kb.nextLine();
                System.out.println();
                double amount = getValidDouble(kb,"Enter the starting amount to deposit: ");
                System.out.println();
                int years = getValidInt(kb,"Enter number of years: ");
                System.out.println();
                double interestRate = getValidDouble(kb, "Enter interest rate: ");
                System.out.println();
                double yearlyDeposit = getValidDouble(kb, "Enter yearly deposit amount: ");
                printTable(amount, years, interestRate, yearlyDeposit, bank);
        }
   
        public static int getValidInt(Scanner kb, String prompt) // Loops until the user enters a valid integer.
        {                                                        
                System.out.print(prompt);
                while(!kb.hasNextInt())
                {
                        kb.next();
                        System.out.print(prompt);
                }
                return kb.nextInt();
        }
   
        public static double getValidDouble(Scanner kb, String prompt) // Loops until the user enters a valid double.
        {                                                              
                System.out.print(prompt);
                while(!kb.hasNextDouble())
                {
                        kb.next();
                        System.out.print(prompt);
                }
                return kb.nextDouble();
        }
   
        public static void printTable(double amount, int time, double rate, double deposit, String name) // Prints a formatted table of the calculated results.
        {
                for(int k = 0; k <= 100; k++)
                {
                        System.out.print("=");
                }
                System.out.println();
                System.out.println();
                System.out.println("Summary of yearly growth for the bank: "+name);
                System.out.println("Interest Rate: " + rate);
                System.out.println("Initial Amount: " + amount);
                System.out.println("Number of years: " + time);
                System.out.println("Yearly Deposit: " + deposit);
                System.out.println();
                for(int j = 0; j <= 100 ; j++)
                {
                        System.out.print("=");
                } 
                System.out.printf("\n%s%19s%19s%22s","Year","Interest","Deposit","New Balance");
                for(int i = 0; i <= time; i++)
                {
                        if(i == 0)
                        {
                                System.out.printf("\n%d%63.2f",i,amount);
                        }
                        else if(i > 0 && i <= 9)
                        { 
                                System.out.printf("\n%d%22.2f%19.2f%22.2f",i,interest(amount,rate),deposit,amount=amount + deposit + interest(amount,rate));
                        }
                        else if(i >= 10)
                        {
                                System.out.printf("\n%d%21.2f%19.2f%22.2f",i,interest(amount,rate),deposit,amount=amount + deposit + interest(amount,rate));
                        }
                }
        }
   
        public static double interest(double amount, double rate) // Performs calculation for interest.
        {
                double interest = ((rate/100)/365)*365*amount;  
                return interest;
        }    
  
        public static String getYesOrNo(Scanner kb, String prompt) // Loops until the user enters a valid yes/no option.
        {
                System.out.println();
                System.out.print(prompt);
	        String yesOrNo = kb.next();
	        while(!(yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("no")))
	        {
	                System.out.print("Invalid option, enter yes or no: ");
	                yesOrNo = kb.next(); 
	        }
	        if(yesOrNo.equalsIgnoreCase("yes"))
	        {
	                return "yes";
	        }
	        else
	        {
	                return "no";
	        }
        }
  
        public static void getFutureValue(Scanner kb) // Calculates the future value of an item based on inflation.
        {
                double item = getValidDouble(kb,"Enter the cost of the item in the present as a decimal with no dollar sign: ");
                int years = getValidInt(kb,"Enter the number of years from now you will be purchasing the item: ");
                System.out.println("Enter the rate of inflation as a decimal number.");
                double inflation = getValidDouble(kb,"For example, enter 5.6 for 5.6%: ");
                double convert = item * Math.pow((1+(inflation/100)),10);
                System.out.printf("In %d years, your item that costs $%.2f now, will cost $%.2f ",years,item,convert); 
        }
}