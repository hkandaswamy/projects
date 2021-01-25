/*
Harish Kandaswamy
10/21/2018
This program has two different calculator methods and asks the user for which one they want to use.
*/

import java.util.Scanner;

public class ProblemSolver
{
        public static void main(String[]args) // This is the main method of the program.
        {
                Scanner kb = new Scanner(System.in);
                run(kb);
        }
        
        public static void run(Scanner kb) // This is the method that asks the user for input and displays results based on the selected program.
        {
                System.out.print(" How many times do you want to run this program? ");
                int timesToRun = kb.nextInt();
                for(int i = 1; i <= timesToRun; i++)
                {
                        System.out.println("count: " + i);
                        String option = getOption(kb);
                        if(option.equalsIgnoreCase("Sentence analyzer"))
                        {
                                System.out.print("Enter a sentence: ");
                                String sentence = kb.nextLine();
                                String a = sentenceAnalyzer(sentence);
                                if(a.equals("exclamatory") || a.equals("interrogative") || a.equals("unknown"))
                                        System.out.println("Sentence \"" + sentence + "\" is an " + a + " sentence");
                                else
                                        System.out.println("Sentence \"" + sentence + "\" is a " + a + " sentence");       
                        }
                        else if(option.equalsIgnoreCase("Probable season"))
                        {
                                System.out.print("Enter a temperature in Fahrenheit: ");
                                double temperature = kb.nextDouble();
                                String b = probableSeason(temperature);
                                if(b == null)
                                {
                                        System.out.println("The temp is out of range");
                                }
                                else
                                {
                                        System.out.println("The probable season associated with " + temperature + " Fahrenheit is " + b);
                                }
                        }
                        else
                                System.out.println("unknown choice");
                }
         }
                
         public static String getOption(Scanner kb) // Gets which option the user wants and returns that to the run method.
         {
                System.out.println("Choose one of the following options:\n1.Sentence analyzer\n2.Probable season");
                System.out.print("Enter your option--> ");
                kb.nextLine();
                String option = kb.nextLine();
                return option;
         }
                 
         public static String sentenceAnalyzer(String sentence) // Analyzes the users input for sentence and returns a result to the run method.
         {
                int lengthOfSentence = sentence.length();
                lengthOfSentence--;
                char endCharacter = sentence.charAt(lengthOfSentence);
                if(endCharacter == '.')
                {
                        String a = "declarative";
                        return a;
                }
                else if(endCharacter == '?')
                {
                        String b = "interrogative";
                        return b;
                }
                else if(endCharacter == '!')
                {
                        String c = "exclamatory";
                        return c;
                }
                else
                {
                        String d = "unknown";
                        return d;
                }
         }
                
         public static String probableSeason(double temp) // Analyzes the users input for temperature and returns a result to the run method.
         {
                if(temp >= 90.0 && temp < 110.0)
                {
                        String a = "Summer";
                        return a;
                }
                else if(temp < 90.0 && temp >= 70.0)
                {
                        String b = "Spring";
                        return b;
                }
                else if(temp < 70.0 && temp >= 50.0)
                {
                        String c = "Fall";
                        return c;
                }
                else if(temp < 50.0 && temp > -5.0)
                {
                        String d = "Winter";
                        return d;
                }
                else
                {
                        return null;
                }        
         }
}            