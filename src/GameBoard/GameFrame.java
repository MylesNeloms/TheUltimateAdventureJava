package GameBoard;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    GameFrame() {
    this.setBounds(10,10,512,512);
    this.add(new GamePanel());
    this.setTitle("The Ultimate Adventure");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.pack();
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    }
}
