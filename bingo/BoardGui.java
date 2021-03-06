package bingo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * creates a gui representation of an individual players board
 */
public class BoardGui extends JFrame {
    Dealer dealer = new Dealer();
    final int GUI_SIZE = 800;
    final int SIZE = 5;
    final int BUTTON_SIZE = 200;
    JButton bingoButton = new JButton();
    JButton skipButton = new JButton("Skip");
    JButton[][] spaces = new JButton[SIZE][SIZE];
    JLabel drawingLabel = new JLabel(dealer.drawing());
    JPanel boardPanel = new JPanel(new GridLayout(SIZE + 1, SIZE));
    JPanel drawingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel bingoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    public BoardGui() {
        super("Bingo Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        setSize(GUI_SIZE, GUI_SIZE);
        drawingPanel.add(drawingLabel);
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayNextDrawing();
            }
        });
        drawingPanel.add(skipButton);
    }

    /**
     * generates the gui version of the player's board
     *
     * @param board the board that was generated by the dealer
     */
    public void setUpBoard(Space[][] board) {
        bingoButton.setText("I Have Bingo!");
        bingoButton.setSize(BUTTON_SIZE, BUTTON_SIZE);
        bingoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dealer.checkForBingo(board);
            }
        });
        bingoPanel.add(bingoButton);
        boardPanel.add(new JLabel("\tB"));
        boardPanel.add(new JLabel("\tI"));
        boardPanel.add(new JLabel("\tN"));
        boardPanel.add(new JLabel("\tG"));
        boardPanel.add(new JLabel("\tO"));
        for (int i = 0; i < SIZE; i++) {
            fillGuiRow(i, board, spaces);
        }

        this.add(drawingPanel);
        this.add(boardPanel);
        this.add(bingoPanel);
        this.setVisible(true);
    }


    /**
     * makes a row of gui buttons with the id set as its text
     *
     * @param rowId    the id of the row that will be filled
     * @param board    the space board generated by the dealer
     * @param btnBoard the button board that will be filled up
     */
    public void fillGuiRow(int rowId, Space[][] board, JButton[][] btnBoard) {
        for (Space s : dealer.getRow(rowId, board)) {
            JButton spaceButton;
            if (rowId == 2 && s.column == 2) {
                spaceButton = new JButton("FREE");
                spaceButton.setForeground(Color.RED);
            } else {
                spaceButton = new JButton(Integer.toString(s.id));
                btnBoard[s.column][rowId] = spaceButton;
            }

            spaceButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    markSpace(spaceButton);
                    displayNextDrawing();
                }
            });
            boardPanel.add(spaceButton);


        }
    }

    /**
     * marks the gui by changing the text color to red
     *
     * @param spaceButton the button that is marked
     */
    public void markSpace(JButton spaceButton) {
        spaceButton.setForeground(Color.RED);
        spaceButton.setOpaque(true);
        spaceButton.setContentAreaFilled(false);

        spaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spaceButton.setForeground(Color.BLACK);
                spaceButton.setOpaque(true);
            }
        });
    }

    /**
     * updates the drawing everytime the player clicks skip or on a space
     */
    public void displayNextDrawing() {
        drawingLabel.setText(dealer.drawing());
        drawingPanel.add(drawingLabel, CENTER_ALIGNMENT);
        this.add(drawingPanel);
    }




}

