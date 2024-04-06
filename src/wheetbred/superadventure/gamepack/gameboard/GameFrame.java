package wheetbred.superadventure.gamepack.gameboard;

import wheetbred.superadventure.gamepack.mapgenerator.GameMap;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    // Constructor to create this Jframe to display the game window
    public GameFrame(GameMap gameMap) {

        this.setBounds(10,10,700,620);
        // This creates game screen, which includes:
        // keybindings to update the gamemap and "gribag" to display visible map
        GamePanel panel = new GamePanel(gameMap);
        this.add(panel);
        this.setTitle("The Ultimate Adventure");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
