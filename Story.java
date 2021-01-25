/*
Harish Kandaswamy
10/8/2018
This program interacts with the user to tell a story.
*/
import java.util.Scanner;

public class Story
{
        public static final int CURRENT_YEAR = 2018;
        
        public static void main(String[]args)
        {
                run();
        }
        public static void description() // Retrieves inputs from user and interacts with them using those inputs.
        {
                        Scanner kb2 = new Scanner(System.in);
                        System.out.print("what is your name: ");
                        String name = kb2.nextLine();
                        System.out.print("In what year were you born? ");
                        int year = kb2.nextInt();
                        int age = getAge(year);
                        System.out.println("You are " + age + " years old.");
                        int spaceInName = name.indexOf(" ");
                        int lengthOfName = name.length();
                        String firstName = name.substring(0,spaceInName);
                        int lengthOfFirstName = firstName.length();
                        System.out.println("Oh you have " + lengthOfFirstName + " letters in your first name.");
                        char firstLetterLastName = name.charAt(spaceInName + 1);
                        System.out.println("Your last name starts with the letter \"" + firstLetterLastName + "\".");
                        String firstNameCaps = firstName.toUpperCase();
                        System.out.println("OH, I'm sorry " + firstNameCaps + ", how rude of me!");
                        System.out.println("Let me introduce myself.");
                        System.out.println("This is your computer speaking.");
                        System.out.println("I need a good sounding name.");
                        System.out.println("What do you think would be a good name for me that starts");
                        char firstLetterFirstName = name.charAt(0);
                        System.out.print("with the first letter of your first name " + firstLetterFirstName + "? ");
                        String computerName = kb2.next();
                        String computerNameLowerCase = computerName.toLowerCase();
                        System.out.println("Oh, Mr. " + computerNameLowerCase + "... that's good!");
                        System.out.println("Please, let me start over.");
                        System.out.println("Hello " + firstNameCaps + ", let me introduce myself.");
                        System.out.println("I am Mr. " + computerNameLowerCase + ", your computer.");
                        int spaceInName1 = spaceInName + 1;
                        String lastName = name.substring(spaceInName1,lengthOfName);
                        System.out.println(lastName + ", you know what?");
                        System.out.println("I can tell you what day Easter will be on");
                        System.out.println("for any year (on the Gregorian calendar) from 1900 to 2099.");
                        int easterDayCurrent = easter(CURRENT_YEAR);
                        String easterDateCurrent = "4/" + easterDayCurrent + "/" + CURRENT_YEAR;
                        int easterDayBorn = easter(year);
                        String easterDateBorn = "4/" + easterDayBorn + "/" + year;
                        System.out.println("This year Easter was on " + easterDateCurrent + ". In " + year + ", the year you were born, Easter was on " + easterDateBorn);
                        System.out.print("For what year are you interested in finding out when Easter is? ");
                        int customEasterYear = kb2.nextInt();
                        int easterDayCustom = easter(customEasterYear);
                        String easterDateCustom = "4/" + easterDayCustom + "/" + customEasterYear;
                        System.out.println("In the " + customEasterYear + " Easter is on " + easterDateCustom);
                        System.out.print("Oh " + firstNameCaps + ", give me a word and I can write it for you backward? ");
                        kb2.nextLine();
                        String customWord = kb2.nextLine();
                        String reverseWord = reverse(customWord);
                        System.out.println();
                        System.out.println("Here is your word in the reverse order \"" + reverseWord + "\"");
                        System.out.println();
                        System.out.println("Well " + lastName + " " + firstNameCaps + " it has been nice talking with you.");
                        System.out.println("I am sure we will be spending a lot of time together this semester.");
                        System.out.println("I hope you enjoy CSc15.");
                        System.out.println();
                        System.out.println("let's start the story all over again\n\n");        
        }
        public static int getAge(int year)
        {
                return CURRENT_YEAR - year;
        }     
        public static int easter(int year) //Calculates the day of Easter depending on year.
        {
                int h = (24 + 19*(year%19))%30;
                int i = h - h/28;
                int j = (year + year/4 + i - 13)%7;
                int k = i - j;
                int monthEaster = 3 + (k + 40)/44;
                int dayEaster = k + 28 - 31*(monthEaster/4);
                int dayEasterInt = (int)dayEaster;
                return dayEasterInt;
        }
        public static String reverse(String s) // Reverses user inputted string.
        {
                String backwards = "";
                for (int i = s.length() - 1;i >= 0;i--)
                {
                        backwards = backwards + s.charAt(i);
                }
                return backwards;
        }
        public static void run() // Runs the program.
        {
                Scanner kb = new Scanner(System.in);
                System.out.print("How many times do you want to tell the story: ");
                int timesToTell = kb.nextInt();
                for (int i = 1;i <= timesToTell; i++);
                {
                        description();
                }
                System.out.print("Oh I am so tired. Good bye until next time");    
        }
}       