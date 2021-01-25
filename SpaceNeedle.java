/*
Harish Kandaswamy
9-25-2018
This is a program that draws the Space Needle in various sizes.
*/

public class SpaceNeedle
{
        public static final int SIZE=4; // This is the class constant whose value can be changed to any integer greater than one to produce various size Space Needles.
        
        public static void main(String[]args) // This is the main method of the program which combines all the other methods to draw the full image.
        {
                stemNeedle();
                colonNeedle();
                slashNeedle();
                stemNeedle();
                percentNeedle();
                colonNeedle();
        }
        public static void stemNeedle() // This method is for drawing the "stem" of two vertical lines that appears at the top and middle.
        {
                for(int tip=1;tip<=SIZE;tip++)
                {
                        for(int space=1;space<=SIZE*3;space++)
                        {
                                System.out.print(" ");
                        }
                        System.out.println("||");
                }
        }
        public static void colonNeedle() // This method is for drawing the "pyramid" section with colons and a row of quotes at the bottom.
        {
                for(int line=1;line<=SIZE;line++)
                {
                        for(int space=1;space<=SIZE*3-(3*line);space++)
                        {
                                System.out.print(" ");
                        }      
                        System.out.print("__/");
                        for(int colon=1;colon<=3*(line-1);colon++)
                        {
                                System.out.print(":");
                        }
                        System.out.print("||");
                        for(int colon=1;colon<=3*(line-1);colon++)
                        {
                                System.out.print(":");
                        }
                        System.out.println("\\__");
                }
                System.out.print("|");
                for(int quotes=1;quotes<=SIZE*6;quotes++)
                {
                        System.out.print("\"");
                }
                System.out.print("|");       
        }
        public static void slashNeedle() // This method is for drawing the "upside-down pyramid" section containing numerous forward and back slashes.
        {
                System.out.println();
                for(int line=1;line<=SIZE;line++)
                {
                        for(int space=1;space<=2*(line-1);space++)
                        {
                                System.out.print(" ");
                        }
                        System.out.print("\\_");
                        for(int slash=1;slash<=(SIZE*3)-((2*(line-1))+1);slash++)
                        {
                                System.out.print("/\\");
                        }
                        System.out.println("_/");
                }
        }  
        public static void percentNeedle() // This method is for drawing the section that contains the percent symbols.
        {
                for(int line=1;line<=SIZE*SIZE;line++)
                {
                        for(int space=1;space<=(SIZE*2)+1;space++)
                        {
                                System.out.print(" ");
                        }
                        System.out.print("|");
                        for(int percent=1;percent<=SIZE-2;percent++)
                        {
                                System.out.print("%");
                        }
                        System.out.print("||");
                        for(int percent=1;percent<=SIZE-2;percent++)
                        {
                                System.out.print("%");
                        }
                        System.out.println("|");
                }
        }
}               
    