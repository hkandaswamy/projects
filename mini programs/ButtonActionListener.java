import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is a class used by TTTGUI to help the buttons
 * determine which action needs to be taken on a button
 * press.
 *
 * @author Harish Kandaswamy (3265)
 * @version 11 May 2019
 */
public class ButtonActionListener implements ActionListener {
        private static TTTBoard board = new TTTBoard(4);
        private static TTTBoard board2 = new TTTBoard(4);
        private char user;
        private char computer;
        private JLabel message;
        private JButton[][] buttons;
        private int r;
        private int c;
        
        /**
         * This is the constructor for the action listener. It
         * takes in the JButton array, status message, row, and
         * column to use in determining which actions need to be
         * taken.
         * 
         * @param user the character representing the player.
         * @param computer the character representing the AI.
         * @param message the status message of the game.
         * @param buttons the JButton array that was passed in.
         * @param r the column corresponding to the button press.
         * @param c the column corresponding to the button press.
         */
        public ButtonActionListener(JButton[][] buttons, JLabel message, int r, int c) {
                this.user = 'X';
                this.computer = 'O';
                this.message = message;
                this.buttons = buttons;
                this.r = r;
                this.c = c;
        }
                
        /**
         * This method determines which action needs to be performed
         * based on which button was pressed.
         *
         * @param board the board used for user inputs.
         * @param board2 the board used for AI inputs.
         * @param message the status message of the game.
         * @param r the row corresponding to the button press.
         * @param c the column corresponding to the button press.
         * @param user the character representing the player.
         * @param computer the character representing the AI.
         */
        public void actionPerformed(ActionEvent event) {
                if(isFull(board2) != true && board2.winner() != 'X' && board2.winner() != 'O') {                
                        buttons[r][c].setText("X");
                        board.set(r, c, user);
                        board2.set(r, c, user);
                        if(board.winner() == 'X') {
                                message.setText("YOU WON!");
                        }
                        else {
                                TTTAI.move(board2, computer);
                                for(int i = 0; i < 4; i++) {
                                        for(int j = 0; j < 4; j++) {
                                                if(board.get(i, j) != board2.get(i, j)) {
                                                        buttons[i][j].setText("O");
                                                }
                                        }
                                }
                        }
                        if(board2.winner() == 'O') {
                                message.setText("SORRY, THE COMPUTER WON!");
                        }
                        else if(isFull(board2) == true && board2.winner() != 'O') {
                                message.setText("IT'S A DRAW!");
                        }
                }
        }
        
        private boolean isFull(TTTBoard board) {
                for(int i = 0; i < board.size(); i++) {
                        for(int j = 0; j < board.size(); j++) {
                                if(board.get(i, j) == ' ') {
                                        return false;
                                }
                        }
                }
                return true;
        }
}