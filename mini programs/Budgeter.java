/*
Harish Kandaswamy
10/23/2018
This program calculates expenses.
*/
import java.util.Scanner;

public class Budgeter
{
        public static void main(String[] args) //Main method
        {
                Scanner kb = new Scanner(System.in);
                run(kb);
        }
        
        public static void run(Scanner kb) //Call all methods
        {       
                description();
                System.out.println("it also informs you if you are spending too much money or not");
                int i = 1;
                for(i = 1; i <= 54; i++)
                {
                        System.out.print("*");
                }
                System.out.println();
                System.out.println();
                System.out.print("How many times do you want to run this software? ");
                int timesToRun = kb.nextInt();
                for(int j = 1; j <= timesToRun; j++)
                {
                        System.out.println();
                        System.out.println("Customer " + j + ":");
                        System.out.println();
                        double income = earning(kb);
                        double spending = spending(kb);
                        System.out.println();
                        double incomeDay = income/30;
                        double expensesDay = spending/30;
                        System.out.printf("Total income = $%.2f ($%.2f/day)\n\n", income,incomeDay);
                        System.out.printf("Total expenses = $%.2f ($%.2f/day)\n\n", spending,expensesDay);
                        double difference = spenderOrSaver(income, spending);
                        finalResult(difference);
                        System.out.println();
                }
        }
        
        public static void description() //Displays a description
        {
                System.out.println();
                int i = 0;
                for(i = 0; i <= 652; i++)
                {
                        System.out.print("_");
                }
                System.out.println();
                System.out.println("This program asks for your monthly income and expenses,");
                System.out.println("then tells you your net monthly income.");
        }
        
        public static double earning(Scanner kb) //Calculates earning
        {
                System.out.print("How many categories of income? ");
                int categories = kb.nextInt();
                System.out.println();
                double income = 0.0;
                for(int i = 1; i <= categories; i++)
                {
                        System.out.print("Next income amount? $");
                        income += kb.nextDouble();
                        System.out.println();
                }
                return income;
        }
        
        public static double spending(Scanner kb) //Calculates spending
        {
                System.out.print("Enter monthly or daily expenses? ");
                String monthlyOrDaily = kb.next();
                System.out.print("How many categories of expense? ");
                int categories = kb.nextInt();
                double spending = 0.0;
                if(monthlyOrDaily.equalsIgnoreCase("monthly"))
                {
                        for(int i = 1; i <= categories; i++)
                        {
                                System.out.print("Next expense amount? $");
                                double amount = kb.nextDouble();
                                spending += amount;
                        }
                }
                else if(monthlyOrDaily.equalsIgnoreCase("daily"))
                {
                        for(int j = 1; j <= categories; j++)
                        {
                                System.out.print("Next expense amount? $");
                                double amount = kb.nextDouble();
                                spending += amount * 30; //The number can be changed depending on how many days there are in that month.
                        }
                }
                else
                {
                        return 0.0;
                }
                return spending;
        }
        
        public static double spenderOrSaver(double earn, double spend) //Determines whether spending or earning is higher
        {
                return earn - spend;
        }
        
        public static void finalResult(double difference) //Displays final type of customer
        {
                if(difference >= 250.00)
                {
                        System.out.printf("You earned $%.2f more than you spent this month. You're a big saver.", difference);
                }
                else if(difference >= 0.0 && difference <= 249.99)
                {
                        System.out.printf("You earned $%.2f more than you spent this month. You're a saver.", difference);
                }
                else if(difference <= -.01 && difference >= -249.99)
                {
                        double difference2 = Math.abs(difference);
                        System.out.printf("You spent $%.2f more than you earned this month. You're a spender.", difference2);
                }
                else if(difference <= -250.00)
                {
                        double difference2 = Math.abs(difference);
                        System.out.printf("You spent $%.2f more than you earned this month. You're a big spender.", difference);
                }
        }
}