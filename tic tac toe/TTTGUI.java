import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program displays a 4x4 Tic-Tac-Toe game board
 * with buttons and a game status message at the bottom.
 * It uses an AI to play an interactive match of
 * Tic-Tac-Toe with the user.
 *
 * @author Harish Kandaswamy (3265)
 * @version 11 May 2019
 */
public class TTTGUI {
        
        /**
         * This is the main method of the program which sets
         * up the game board display and hooks a custom
         * action listener method to each of the buttons.
         *
         * @param frame the main window of the display.
         * @param message the status message of the game.
         * @param centerPanel a panel containing the buttons.
         * @param buttons a JButton array used for the display.
         * @param southPanel a panel containing the status message.
         */
        public static void main(String[] args) {
                JFrame frame = new JFrame();
                JLabel message = new JLabel("YOUR TURN");
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(400, 400));
                frame.setTitle("Tic-Tac-Toe");
                frame.setLayout(new BorderLayout());
                
                JPanel centerPanel = new JPanel(new GridLayout(4, 4));
                JButton[][] buttons = new JButton[4][4];
                for(int r = 0; r < 4; r++) {
                        for(int c = 0; c < 4; c++) {
                                buttons[r][c] = new JButton(" ");
                                centerPanel.add(buttons[r][c]);
                                buttons[r][c].addActionListener(new ButtonActionListener(buttons, message, r, c));
                        }
                }
                frame.add(centerPanel, BorderLayout.CENTER);
                
                JPanel southPanel = new JPanel(new FlowLayout());
                southPanel.add(message);
                frame.add(southPanel, BorderLayout.SOUTH);
                
                frame.setVisible(true);
        }
}