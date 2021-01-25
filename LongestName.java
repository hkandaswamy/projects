/*
Harish Kandaswamy
10-30-2018
This program compares names and tells which is longest.
*/

import java.util.*;

public class LongestName
{
        public static void main(String[] args) // Main method of the program.
        {
                Scanner kb = new Scanner(System.in);
                run(kb);
        }
        
        public static void run(Scanner kb) // Method that calls all other methods.
        {
                boolean play = true;
                while(play)
                {
                        String playAgain = "";
                        description();
                        longestName(kb);
                        playAgain = getYesOrNo(kb,"Do you want to play again? ");
                        System.out.println("\n");
                        if(playAgain.equalsIgnoreCase("yes"))
                        {
                                play = true;
                        }
                        else if(playAgain.equalsIgnoreCase("no"))
                        {
                                play = false;
                        }
                 }       
        }
        
        public static String getYesOrNo(Scanner kb, String prompt) // Asks user for a correct yes/no input.
        {
                String s = "";
                while(!(s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("no")))
                {
                        System.out.print(prompt);
                        s = kb.nextLine();
                }
                return s;
        }
        
        public static String getValidName(Scanner kb) // Asks user for a name and checks whether the input is valid.
        {
                
                String name = "";
                boolean correct = false;
                int space = 0;
                int notLetter = 0;
                while(!correct || space > 1 || space < 1 || notLetter >=1)
                {
                        System.out.print("Enter a valid name--> ");
                        name = kb.nextLine();
                        space = 0;
                        notLetter = 0;
                        for(int i = 0; i <= name.length() - 1; i++)
                        {
                                char c = name.charAt(i);
                                if(c == ' ')
                                {
                                        space++;
                                }                        
                                if(!Character.isLetter(c) && c != ' ')
                                {
                                        notLetter++;
                                }
                        }
                        correct = true;
                }
                System.out.println("Name you entered: " + name);
                return name;
        }
        
        public static void description() // Prints a description of the program.
        {
                System.out.println("This program asks for a series of names and");
                System.out.println("and displays the longest name entered by the user.");
                System.out.println("If two names are with the same length, a message");
                System.out.println("will be printed.Enter a valid name containing only letters a-z ,A-Z and only one space.\n\n");
        }
        public static void longestName(Scanner kb) // Keeps asking for names as long as user wants, then calculates which is longest.
        {
                String longest = "";
                boolean tie = false;
                String name = getValidName(kb);
                boolean flag = true;
                String yesOrNo = "";
                while(flag)
                {        
                        if(name.length() == longest.length())
                        {        
                                tie = true;
                        
                        }
                        else if(name.length() > longest.length())
                        {       
                                tie = false;
                                longest = name;
                        }
                        yesOrNo = getYesOrNo(kb,"Do you have another name? ");
                        if(yesOrNo.equalsIgnoreCase("yes"))
                        {
                                name = getValidName(kb);
                        }
                        else if(yesOrNo.equalsIgnoreCase("no"))
                        {
                                flag = false;
                        }               
                 }
                 System.out.println(longest + "'s name is longest");
                 if(tie)
                 {
                        System.out.println("(There was a tie!)");
                 }      
         }               
}