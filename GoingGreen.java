/*
Harish Kandaswamy
11-20-2018
This program calculates your savings after going green.
*/

import java.util.*;

public class GoingGreen

{
        public static final String[] MONTHS = {"January","February","March","April","May","June","July","August","September","October","November","December"};
   
        public static void main(String[]args) // Main method of the program.
        {
                Scanner kb = new Scanner(System.in);
                run(kb);
        }

        public static void run(Scanner kb) // Run method that combines all other methods.
        {
                double[] firstYear = new double[12];
                double[] secondYear = new double[12];
                dashes();
                System.out.println();
                description();
                dashes();
                System.out.println();
                boolean flag = false;
                while(!flag)
                {
                        double[] beforeGreen = fillArray(kb, firstYear, "Enter the amount for Before going green:\nYou must enter a positive amount for each month.");
                        double[] afterGreen = fillArray(kb, secondYear, "Enter the amount for After going green:\nYou must enter a positive amount for each month.");
                        double[] difference = getDiff(beforeGreen,afterGreen);
                        print(beforeGreen,afterGreen,difference);
                        String repeat = getYesOrNo(kb,"Do you want to continue: ");
                        kb.nextLine();
                        if(repeat.equalsIgnoreCase("no"))
                        {
                                flag = true;
                        }
                }
        }
   
        public static void dashes() // Prints 40 dashes.
        {
                for(int i = 1; i <= 40; i++)
                {
                        System.out.print("-");
                }
        }
   
        public static int getValidInt(Scanner kb, String month) // Gets a valid integer from the user that is greater than 0.
        {
                int test = 0;
                while(test <= 0)
                {
                        System.out.print(month + "--> ");
                        while(!kb.hasNextInt())
                        {
                                kb.next();
                                System.out.print(month + "--> ");
                        }
                        test = kb.nextInt();
                }
                return test;
        }
   
        public static double[] fillArray(Scanner kb, double[] a, String prompt) // Fills the array with user inputs.
        {
                System.out.println(prompt);
                for (int i = 0; i < a.length; i++)
                {
                        a[i] = getValidInt(kb, MONTHS[i]);   
	        }
                return a;
        }
   
        public static double[] getDiff(double[] a, double[] b) // Calculates the difference to find out the savings.
        {
                double[] thirdYear = new double[a.length]; 
                for(int i = 0; i < a.length; i++)
                { 
        	        thirdYear[i] = a[i] - b[i]; 
	        } 
	        return thirdYear;  
        }
        
        public static void print(double[] noGreen, double[] green, double[] diff) // Prints the results in a formatted table.
        {
                System.out.println("Here is the summary of your saving");
                System.out.printf("%s%16s%9s%10s\n","Month","No Green", "Green", "Saving");
                dashes();
                System.out.println();
                int length = 0;
                double sum = 0;
                for(int i = 0; i < MONTHS.length; i++)
                {
                        length = ((((MONTHS[i].length()*2)+9)-3)/2)-MONTHS[i].length();
                        System.out.printf("%-"+(length+8)+"s%9.2f%10.2f%10.2f\n",MONTHS[i],noGreen[i],green[i],diff[i]);
                        sum = sum + diff[i];
                }
                dashes();
                System.out.println("\n\nThe total money you save: " + sum + "\n");
                dashes(); 
        }
  
        public static void description() // Prints a description of the program.
        {
                System.out.println("This program calculates how much you'll save after going green.");
        }
        
        public static String getYesOrNo(Scanner kb, String prompt) // Asks the user for a valid "yes" or "no" input.
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
}