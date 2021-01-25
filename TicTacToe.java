/* 
Harish Kandaswamy
11-27-2018
This program plays a game of tic tac toe with two users.
*/

import java.util.*;

public class TicTacToe
{
   public static void main(String[]args) //Main method of the program passes scanner and random to run method.
   {
      Scanner kb = new Scanner(System.in);
      Random rand = new Random();
      run(kb, rand);
   }
   
   public static void run(Scanner kb, Random rand) //Method that combines all other methods to create final program.
   {
      boolean repeat = true;
      do
      {
      String playerOne = getName(kb,"Enter the first Player's name --> " );
      String playerTwo = getName(kb,"Enter the second Player's name --> " );
      while(playerOne.equalsIgnoreCase(playerTwo))
      {
         System.out.println("You cannot play against yourself");
         playerTwo = getName(kb, "Enter the second Player's name --> " );
      }
      
      System.out.println("Wait, flipping the coin to see who goes first");
      String firstPlayer = chooseFirstPlayer(rand, playerOne, playerTwo);
      System.out.println("Hit enter to see the result");
      String enter = kb.nextLine();
      System.out.println("The player " + firstPlayer + " will start the game");
      char[][] board = initializeBoard();
      printBoard(board);
      System.out.println(playerOne + ", you will be 'x'");
      System.out.println(playerTwo + ", you will be 'o'");
      char win = ' ';
      int turn = 0;
      String playerTurn = "";
         while(win == ' ' && turn < 9)
         {
            char mark = 'o';
            if(turn % 2 == 0)
            {
               playerTurn = playerOne;
               mark = 'x';
            }
            else
            {
               playerTurn = playerTwo;
            }
            board = doUserMove(kb, board, playerTurn, mark);
            printBoard(board);
            if (turn >= 4)
            {
               win = isWinner(board);
            }
            turn++;
        }
        if (win != ' ')
        {
           System.out.println("Congratulations " + playerTurn + ", you are the winner!!!!!");
        }
        else
        {
           System.out.println("Cat's Game");
        }
        repeat = yesTo(kb);
      }
      while (repeat == true);
   }
   
   public static String getName(Scanner kb, String nameF) //Gets valid name from the user.
   {
         boolean nameV = false;
	      String name = "";
	      int space = 0;
	      boolean flag = true; 
	      while (space > 1 || !nameV) 
	      {
	         space = 0;
	         flag = true;  
	         System.out.print(nameF);
	         name = kb.nextLine();
	         for(int i = 0; i < name.length(); i++) 
	         {
	            char a = name.charAt(i); 
	            if (a == ' ') 
	            {
	               space++; 
	            }
	            if (!Character.isLetter(a) && a != ' ') 
	            {
	               flag = false;
	            }
	                        
	         }
	         if (flag && space == 0) 
	         {
	            nameV = true;
	         }
	      }
	      return name;         
   }
   public static int flipCoin(Random rand) //Generates a random integer representing a coin flip.
   {
      return rand.nextInt(2);
   }
   
   public static String chooseFirstPlayer(Random rand, String name1, String name2) //Chooses which player goes first based on the "coin flip".
   {
      int coin = flipCoin(rand);
      if(coin == 0)
      {
         return name1;
      } 
      else 
      {
         return name2;
      }
   }
   
   public static char[][] initializeBoard() //Initializes an array representing the game board.
   {
      char[][] board = new char[3][3];
      for(int i = 0; i < 3; i++)
      { 
         for(int j = 0; j < 3; j++)
         {  
            board[i][j]= ' '; 
         }
      }
      return board;
   }
   
   public static char[][] printBoard(char[][]board) //Formats and prints the game board using the array.
   {
        System.out.println("-------------");
    	for (int i = 0; i < board.length; i++) 
        {
           for (int j = 0; j < board[i].length; j++) 
           {
              System.out.print("| "+board[i][j]+" ");
           }
           System.out.print("|\n");
           System.out.println("-------------");
        }
        System.out.println(); 
	return board;
   }
   
   public static int getPos(Scanner kb, String name, String prompt) //Gets the position in which the user wants to play their mark.
   {  
      int a = 0;
      while(a < 1 || a > 3)
      { 
         System.out.print(name + " enter the " + prompt);
         while(!kb.hasNextInt())
         {
            kb.next();
            System.out.print(name + " enter a valid number");
         }
         a = kb.nextInt();
      }
      a--;
      return a;
   }
   
   public static char[][] doUserMove(Scanner kb, char[][] board, String name, char marker) //Applies the user's mark onto the game board based on their input.
   {
      int row = getPos(kb,name, " row --> ");
      int column = getPos(kb,name, " col --> ");
      char[][]updater = board;
      while (board[row][column] != ' ')
      { 
         System.out.println("The box is already taken ");
         row = getPos(kb, name,"  row--> ");
         column = getPos(kb,name, "  col--> ");
      }
   
      updater[row][column] = marker;
      return updater;
   }
   
   public static char isWinner(char[][] winner) //Runs tests to see if there is a winner.
   {
      char[][] board = winner;
      int a = 0;
      char c = ' ';           
      while (a < 3){
         if (winner[a][0] == winner[a][1] && winner[a][1] == winner[a][2] && winner[a][0] != ' ')
         {
            return winner[a][0];
         }
         else if(winner[0][a] == winner[1][a] && winner[1][a] == winner[2][a] && winner[0][a] != ' ')      
         {
            return winner[0][a];
         }
         a++;
      }
      if(winner[0][0] == winner[1][1] && winner[1][1] == winner[2][2] && winner[1][1] != ' ')
      {
         return winner[1][1];
      }
      else if(winner[0][2] == winner[1][1] && winner[1][1] == winner[2][0] && winner[1][1] != ' ')
      {
         return winner[1][1];
      }
      return c;   
   }
   
   public static boolean yesTo(Scanner kb) //Asks user if they want to play again and repeats the program if user answers yes.
   {
      boolean option = false;
      String yesOrNo = "";
      System.out.println("Want to play again?");
      yesOrNo = kb.nextLine(); 
      while(!yesOrNo.equalsIgnoreCase("y") && !yesOrNo.equalsIgnoreCase("n"))
      {
         System.out.print("Please enter y or n: ");
         yesOrNo = kb.nextLine();
      }
      if (yesOrNo.equalsIgnoreCase("y"))
      {
         option = true;
      }
      else 
      {
         option = false;
      }
      return option;
   }
}