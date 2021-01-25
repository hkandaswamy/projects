import java.util.*;

/**
 * This is a program that plays a text-based game
 * of Tic-Tac-Toe with the user. An AI is used to make
 * the moves of the computer.
 * 
 * @author Harish Kandaswamy (3265)
 * @version 19 May 2019
 */
public class TTT {
        public static void main(String[]args) {
                Scanner kb = new Scanner(System.in);
                int r = 0;
                int c = 0;
                int size = 0;
                System.out.println("Welcome to Tic-Tac-Toe!");
                System.out.println("You will be playing as 'X' and the AI will be 'O'.");
                System.out.print("Enter your desired board size as an integer (must be greater than 1): ");
                while(size <= 1) {
                        while(!(kb.hasNextInt())) {
                                kb.next();
                                kb.nextLine();
                                System.out.print("Error, invalid entry. Please try again: ");
                        }
                        size = kb.nextInt();
                        if(size <= 1) {
                                kb.nextLine();
                                System.out.print("Error, invalid entry. Please try again: ");
                        }
                }
                TTTBoard board = new TTTBoard(size);
                System.out.println("\n" + board);
                while(board.winner() != 'X' && board.winner() != 'O' && !(isFull(board))) {
                        System.out.print("\nEnter the row where you would like to play: ");
                        while(r < 1 || r > size) {
                                while(!(kb.hasNextInt())) {
                                        kb.next();
                                        kb.nextLine();
                                        System.out.print("Error, invalid entry. Please try again: ");
                                }
                                r = kb.nextInt();
                                if(r < 1 || r > size) {
                                        kb.nextLine();
                                        System.out.print("Error, invalid entry. Please try again: ");
                                }
                        }
                        System.out.print("Enter the column where you would like to play: ");
                        while(c < 1 || c > size) {
                                while(!(kb.hasNextInt())) {
                                        kb.next();
                                        kb.nextLine();
                                        System.out.print("Error, invalid entry. Please try again: ");
                                }
                                c = kb.nextInt();
                                if(c < 1 || c > size) {
                                        kb.nextLine();
                                        System.out.print("Error, invalid entry. Please try again: ");
                                }
                        }
                        if(board.get(r - 1, c - 1) != 'X' && board.get(r - 1, c - 1) != 'O') {
                                board.set(r - 1, c - 1, 'X');
                                r = 0;
                                c = 0;
                                if(board.winner() == 'X') {
                                        System.out.println("\n" + board);
                                        System.out.print("\nCongratulations, you won!");
                                }
                                else if(!(isFull(board))) {
                                        TTTAI.move(board, 'O');
                                        System.out.println("\n" + board);
                                }
                        }
                        else {
                                System.out.println("\nThis position is taken. Please try again.");
                                r = 0;
                                c = 0;
                        }
                }
                if(board.winner() == 'O') {
                        System.out.print("\nSorry, the AI won!");
                }
                else if(board.winner() != 'X' && board.winner() != 'O') {
                        System.out.println("\n" + board);
                        System.out.print("\nIt's a draw.");
                }
        }
        
        private static boolean isFull(TTTBoard board) {
                for(int r = 0; r < board.size(); r++) {
                        for(int c = 0; c < board.size(); c++) {
                                if(board.get(r,c) == ' ') {
                                        return false;
                                }
                        }
                }
                return true;
        }
}