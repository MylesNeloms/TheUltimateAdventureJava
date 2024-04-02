package wheetbred.superadventure.gamepack.gameboard;

import wheetbred.superadventure.gamepack.mapgenerator.GameMap;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameFrame extends JFrame {

    // Constructor to create this Jframe to display the game window
    public GameFrame() {
    GridBagLayout gridBounds =  new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();


    GameMap map = new GameMap();
    String gamemap[][] = map.generateBaseMap();
    
    this.setBounds(10,10,530,530);
    this.add(new GamePanel());
    this.setTitle("The Ultimate Adventure");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // githis.setResizable(false);


    


    // GamePanel panel = new GamePanel();
    // this.add(panel);
    // this.pack();
    // panel.startGameThread();

    // this.setLocation(null);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    }
}
