package bingo;

import javax.swing.*;
import java.awt.*;

/**
 * creates a gui representation of an individual players board
 */
public class BoardGui extends JFrame {

    final int GUI_SIZE = 800;
    final int ROWS = 6;
    final int COLUMN = 5;
    JButton bingoButton = new JButton("I have Bingo!");
    JPanel boardPanel = new JPanel()

    public BoardGui() {
        super("Bingo Board");
    }

    /**
     * sets up the size and dimensions of the bingo board gui
     */
    public void prepareGui() {
        this.setSize(GUI_SIZE, GUI_SIZE);
        this.setLayout(new GridLayout(ROWS, COLUMN));
        this.add(bingoButton);
        this.setVisible(true);
    }

    public void setUpBoard() {
        prepareGui();
        this.setBackground(Color.white);
        this.add(new JLabel("B", SwingConstants.HORIZONTAL));
        this.add(new JLabel("I", SwingConstants.HORIZONTAL));
        this.add(new JLabel("N", SwingConstants.HORIZONTAL));
        this.add(new JLabel("G", SwingConstants.HORIZONTAL));
        this.add(new JLabel("O", SwingConstants.HORIZONTAL));
    }

    //TODO Space[][] to gui method 

}
