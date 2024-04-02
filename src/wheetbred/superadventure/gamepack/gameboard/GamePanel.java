package wheetbred.superadventure.gamepack.gameboard;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import wheetbred.superadventure.gamepack.gameboard.KeyBindings.UpAction;
import wheetbred.superadventure.gamepack.mapgenerator.GameMap;
import wheetbred.superadventure.gamepack.gameboard.KeyBindings.DownAction;
import wheetbred.superadventure.gamepack.gameboard.KeyBindings.RightAction;
import wheetbred.superadventure.gamepack.gameboard.KeyBindings.LeftAction;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    /*
    Changed to use GridBag constraints as this will display my Map(array of Characters) in 
    a simpler way than painting each element
    */ 
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagLayout gridBounds =  new GridBagLayout();
    
    
    int BodyLength = 6;
    int miceDevoured;
    String direction = "R";
    Boolean running = false;
    Timer timer;
    Random random;

    // Default Player Position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 3;

    //Initialize key Bindings
    UpAction upAction;
    RightAction RightAction;
    LeftAction LeftAction;
    DownAction DownAction;


    GameMap map = new GameMap();
    String gamemap[][] = map.generateBaseMap();


    public GamePanel() {
        
        random = new Random();
        this.setPreferredSize(new Dimension(super.getWidth(),super.getHeight()));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        // this.requestFocusInWindow();
        
        this.setLayout(gridBounds);
        refreshGrid();
        
    }



    public void refreshGrid () {
    for (int i = 0; i < gamemap.length; i++) {
        for (int j = 0; j < gamemap[i].length; j++) {
            JTextArea gridpoint  = new JTextArea(gamemap[i][j]);
            gridpoint.setEditable(false);
            gridpoint.setHighlighter(null);
            gbc.gridx = i;
            gbc.gridy = j;
            // System.out.println(i + " ::::::  "+j);
            this.add(gridpoint,gbc);
        }
    }
    }
    public void update() {

        refreshGrid();
    }


    public void paintComponent(Graphics g) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        update();
    }
}

