package wheetbred.superadventure.gamepack.gameboard;

import wheetbred.superadventure.gamepack.mapgenerator.GameMap;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    // Constructor to create this Jframe to display the game window
    public GameFrame(GameMap gameMapRef) {
    GridBagLayout gridBounds =  new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    
    this.setBounds(10,10,700,620);
    GamePanel panel = new GamePanel(gameMapRef.gameMap);
    this.add(panel);
    this.setTitle("The Ultimate Adventure");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    }
}
