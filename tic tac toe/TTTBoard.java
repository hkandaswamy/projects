/**
 * A class that creates a Tic-Tac-Toe board based on a size
 * specified by the user. If no size is specified, it defaults
 * to a size of 3x3. This class provides the set method for setting a
 * character to a location on the board, and get method for getting a
 * character from a location on the board. The winner method will return
 * the character that wins the game, and the toString method  will
 * return a string image of the board. Pass only the proper data types
 * into the methods, or else an error will occur.
 *
 * @author Harish Kandaswamy (3265)
 * @version 13 March 2019
 */

public class TTTBoard {

        public static final int DEFAULT_SIZE = 3;
        private char[][] board;
        private int boardSize;
        
         /**
          * Constructs a Tic-Tac-Toe board array of default
          * size, 3x3.
          *
          * @param boardSize contains the dimension of the board,
          * which in this case is 3.
          * @param board contains the array of the Tic-Tac-Toe
          * board.
          * @param DEFAULT_SIZE contains the default class constant
          * for the size of the board, which in this case is 3.
          */
         public TTTBoard() {
                boardSize = DEFAULT_SIZE;
                board = new char[boardSize][boardSize];
                for(int r = 0; r < boardSize; r++) {
                        for(int c = 0; c < boardSize; c++) {
                                board[r][c] = ' ';
                        }
                }
        }
        
         /**
          * Constructs a Tic-Tac-Toe board array of a size
          * specified by the user.
          *
          * @throws IllegalArgumentException if the size is less than 1.
          * @param size is the size of the board passed in by the user.
          * @param boardSize contains the dimension of the board
          * as specified by the user.
          * @param board contains the array of the Tic-Tac-Toe
          * board.
          */
         public TTTBoard(int size) throws IllegalArgumentException {
                if(size < 1) {
                        throw new IllegalArgumentException("Size cannot be less than 1.");
                }
                boardSize = size;
                board = new char[boardSize][boardSize];
                for(int r = 0; r < boardSize; r++) {
                        for(int c = 0; c < boardSize; c++) {
                                board[r][c] = ' ';
                        }
                }
        }
        
        /**
         * Gets the character value at a specific
         * location on the game board only if the values
         * passed in are greater than or equal to boardSize.
         * Values passed in must correspond to the same type
         * as specified in this method, or an error will occur.
         *
         * @param r corresponds to the row number.
         * @param c corresponds to the column number.
         * @param board is the array of the game board.
         * @param boardSize is the dimension of the game board.
         * @throws IndexOutOfBoundsException if the values
         * passed into the method equal or exceed boardSize.
         * @return Returns the character value at specified location.
         */
        public char get(int r, int c) throws IndexOutOfBoundsException {
                if(r >= boardSize || c >= boardSize) {
                        throw new IndexOutOfBoundsException("Location out of bounds.");
                }
                return board[r][c];
        }
        
        /** 
         * Sets a character at a location in the game board
         * only if the values passed in are less than boardSize.
         * Values passed in must correspond to the same type as
         * specified in this method, or else an error will occur.
         * 
         * @param r is the row of the game board.
         * @param c is the column of the game board.
         * @param ch is the character to set at the location.
         * @param board is the array representing the game board.
         */
        public void set(int r, int c, char ch) {
                if(r < boardSize && c < boardSize) {
                        board[r][c] = ch;
                }
        }
        
        /**
         * Returns the size of the current game board.
         * 
         * @param boardSize is the dimension of the current
         * game board.
         * @return Returns boardSize, which is the size of the
         * current game board.
         */
        public int size() {
                return boardSize;
        }
        
        /**
         * Determines the winner of the Tic-Tac-Toe game
         * by checking for a full row, column, or diagonal
         * with all locations containing the same character.
         *
         * @param counter counts how many matches of a character
         * exist to determine a winner if it equals boardSize - 1.
         * @param currentChar stores the current character being
         * evaluated.
         * @param tempChar stores the next character to compare to the currentChar
         * for a match.
         * @param r represents the row of the board location.
         * @param c represents the column of the board location.
         * @boardSize contains the dimension of the game board.
         * @board contains the array of the game board.
         * @return returns the winning character if one exists,
         * otherwise it returns a space character (' ').
         */
        public char winner() {
                int counter = 0;
                char currentChar;
                char tempChar;
                for(int c = 0; c < boardSize; c++) {
                        for(int r = 0; r < boardSize; r++) {                
                                if(board[r][c] != ' ') {
                                        currentChar = board[r][c];
                                        if((r + 1) < boardSize) {
                                                tempChar = board[r + 1][c];
                                                if(currentChar == tempChar) {
                                                        counter++;
                                                }
                                        }
                                        if(counter == boardSize - 1) {
                                                return currentChar;
                                        }        
                                }
                        }
                        counter = 0;
                }
                counter = 0;
                for(int r = 0; r < boardSize; r++) {
                        for(int c = 0; c < boardSize; c++) {                
                                if(board[r][c] != ' ') {
                                        currentChar = board[r][c];
                                        if((c + 1) < boardSize) {
                                                tempChar = board[r][c + 1];
                                                if(currentChar == tempChar) {
                                                        counter++;
                                                }
                                        }
                                        if(counter == boardSize - 1) {
                                                return currentChar;
                                        }                          
                                }
                        }
                        counter = 0;
                }
                counter = 0;
                for(int d = 0; d < boardSize; d++) {
                        if(board[d][d] != ' ') {
                                currentChar = board[d][d];
                                if((d + 1) < boardSize) {
                                        tempChar = board[d + 1][d + 1];
                                        if(currentChar == tempChar) {
                                                counter++;
                                        }
                                        if(counter == (boardSize - 1)) {
                                                return currentChar;
                                        }
                                }
                        }
                }
                counter = 0;
                int c = 0;
                for(int r = boardSize - 1; r >= 0 ; r--) {
                        if(board[r][c] != ' ') {
                                currentChar = board[r][c];
                                if((r - 1) >= 0 && (c + 1) < boardSize) {
                                        tempChar = board[r - 1][c + 1];
                                        c++;
                                        if(currentChar == tempChar) {
                                                counter++;
                                        }
                                        if(counter == (boardSize - 1)) {
                                                return currentChar;
                                        }
                                }
                        }                        
                }
                return ' ';
        }
        
        /**
         * Returns a string representation of the current
         * Tic-Tac-Toe game board by updating a displayBoard
         * string variable over time.
         * 
         * @param displayBoard is the string containing the game
         * board which gets updates throughout the method.
         * @param boardSize contains the size of the current
         * game board.
         * @return Returns a formatted representation of the game board.
         */
        public String toString() {
                String displayBoard = "";
                for(int r = 0; r < boardSize; r++) {
                        for(int c = 0; c < boardSize; c++) {
                                displayBoard += board[r][c] + "|";
                        }
                        displayBoard = displayBoard.substring(0, displayBoard.length() - 1);
                        displayBoard += "\n";
                        if(r != boardSize - 1) {
                                for(int i = 0; i < boardSize; i++){
                                        displayBoard += "-+";
                                }
                                displayBoard = displayBoard.substring(0, displayBoard.length() - 1);
                        }        
                        displayBoard+= "\n";
                }
                return displayBoard.substring(0, displayBoard.length() - 2);
       }
}