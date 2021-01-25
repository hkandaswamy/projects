/**
 * This is a class that contains an AI which will make the most
 * optimal move in a game of Tic-Tac-Toe against a human. The
 * player will pass in the current board and a character to represent
 * the AI, and then the AI will place the given character in an optimal
 * position on the board that was given.
 *
 * @author Harish Kandaswamy (3265)
 * @version 16 April 2019
 */
public class TTTAI {
        
        /**
         * This is the main method that the program will use to make
         * its move. It calls some helper methods to ensure that it
         * does not make more than one move on the same turn.
         *
         * @throws IllegalArgumentException when the board is full or already
         * has a winner.
         * @param board represents the current game board.
         * @param who represents the character of the AI.
         * @param winner holds the character that is the winner of the match.
         * @param player represents the character of the human player.
         * @param moved is used to prevent the AI making more than one move on its turn.
         */
        public static void move(TTTBoard board, char who) {
                char winner = board.winner();
                if(winner != ' ' || isFull(board) == true) {
                        throw new IllegalArgumentException();
                }
                else {
                        char player = playerChar(board, who);
                        int moved = 0;
                        moved += pickWin(board,who);
                        if(moved == 0) {
                                moved += blockWin(board,who,player);
                                if(moved == 0) {
                                        moved += pickAnyEmpty(board,who);
                                }
                        }
                }       
        }
        
        /**
         * This helper method is used by the AI to make a winning
         * move, if possible. This is accomplished by checking each
         * empty spot for a win; if it is a win, the AI
         * places its character there.
         * 
         * @param board represents the current game board.
         * @param who represents the character of the AI.
         * @return 1 if a move was made, else returns 0.
         */
        private static int pickWin(TTTBoard board, char who) {
                for(int r = 0; r < board.size(); r++) {
                        for(int c = 0; c < board.size(); c++) {
                                if(board.get(r,c) == ' ') {
                                        board.set(r,c,who);
                                        if(board.winner() == who) {
                                                return 1;
                                        }
                                        else if(board.winner() == ' ') {
                                                board.set(r,c,' ');
                                        }
                                }        
                        }
                }
                return 0;
        }
        
        /**
         * This helper method is used by the AI to block the
         * player's winning move. This is accomplished by checking
         * each empty spot for a win; if a win is found, the AI
         * will block it by placing its character there.
         *
         * @param board represents the current game board.
         * @param who represents the character of the AI.
         * @param player represents the character of the human player.
         * @return 1 if a move was made, else returns 0.
         */
        private static int blockWin(TTTBoard board, char who, char player) {
                for(int r = 0; r < board.size(); r++) {
                        for(int c = 0; c < board.size(); c++) {
                                if(board.get(r,c) == ' ') {
                                        board.set(r,c,player);
                                        if(board.winner() == player) {
                                                board.set(r,c,who);
                                                return 1;
                                        }
                                        else if(board.winner() == ' ') {
                                                board.set(r,c,' ');
                                        }
                                }     
                        }
                }
                return 0;
        }
        
        /**
         * This is a helper method used by the AI to place
         * its character in any empty spot provided that there
         * is no spot where it can win or block the human player
         * from winning.
         *
         * @param board represents the current game board.
         * @param who represents the character of the AI.
         * @return 1 if a move was made, else return 0.
         */
        private static int pickAnyEmpty(TTTBoard board, char who) {
                for(int r = 0; r < board.size(); r++) {
                        for(int c = 0; c < board.size(); c++) {
                                if(board.get(r,c) == ' ') {
                                        board.set(r,c,who);
                                        return 1;
                                }
                        }
                }
                return 0;
        }        
        
        /**
         * This is a helper method used by the AI to determine
         * if the game board is already full. It does this by
         * checking for an empty spot; if there is one, then it
         * considers the board not full.
         *
         * @param board represents the current game board.
         * @return true if the board is full, false if it's not.
         */
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
        
        /**
         * This is a helper method used by the AI to determine
         * what the character being used by the human player is.
         * This is done by finding whichever character is not an
         * empty space or the character being used by the AI.
         *
         * @param board represents the current game board.
         * @param who represents the character of the AI.
         * @return the character being used by the human player.
         */
        private static char playerChar(TTTBoard board, char who) {
                for(int r = 0; r < board.size(); r++) {
                        for(int c = 0; c < board.size(); c++) {
                                if(board.get(r,c) != ' ' && board.get(r,c) != who) {
                                        return board.get(r,c);
                                }
                        }
                }
                return ' ';
        }
}