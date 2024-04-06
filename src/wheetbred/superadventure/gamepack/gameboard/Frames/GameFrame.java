package wheetbred.superadventure.gamepack.gameboard.Frames;

import wheetbred.superadventure.gamepack.gameboard.Panels.GamePanel;
import wheetbred.superadventure.gamepack.gameboard.Panels.InfoPanel;
import wheetbred.superadventure.gamepack.mapgenerator.GameMap;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.text.BadLocationException;

public class GameFrame extends JFrame {
    private GamePanel gPanel;
    private InfoPanel iPanel;
    // Constructor to create this Jframe to display the game window
    public GameFrame(GameMap gameMap) {

        gPanel = new GamePanel(gameMap);
        this.add(gPanel, BorderLayout.CENTER);
        iPanel= new InfoPanel(gPanel);

        this.add(iPanel, BorderLayout.SOUTH);

        this.setBounds(0,0,700,60);
        this.setSize(new Dimension(620, 550));
        // This creates game screen, which includes:
        // keybindings to update the gamemap and "gribag" to display visible map



        this.setTitle("The Ultimate Adventure");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }
}
