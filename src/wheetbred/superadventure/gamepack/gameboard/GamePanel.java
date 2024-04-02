package wheetbred.superadventure.gamepack.gameboard;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import wheetbred.superadventure.gamepack.mapgenerator.GameMap;
import wheetbred.superadventure.gamepack.mapgenerator.Generator;
import wheetbred.superadventure.gamepack.entities.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel implements ActionListener {
    /*
    Changed to use GridBag constraints as this will display my Map(array of Characters) in 
    a simpler way than painting each element
    */ 
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagLayout gridBounds =  new GridBagLayout();
    
    Timer timer;
    Random random;

    // Default Player Position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 3;
    Player player = new Player();

    //Initialize key Bindings
    KeyBindings kb;
    DefaultListModel<String> model = new DefaultListModel<>();

    // String[][] gamemap1 = map1.generateAlternateMap();

    public GamePanel(String[][] gamemap) {
        // adding keybindings to listen to keyboard inputs
        kb = new KeyBindings(player, this);
        JLabel label = new JLabel();
        label.setBounds(super.getBounds());

        // Add keybindings to invisible label
        label.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"),"upAction");
        label.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('w'),"upAction");
        label.getActionMap().put("upAction", kb.upAction);
        label.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"),"downAction");
        label.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'),"downAction");
        label.getActionMap().put("downAction", kb.downAction);
        label.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"),"leftAction");
        label.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('a'),"leftAction");
        label.getActionMap().put("leftAction", kb.leftAction);
        label.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"),"rightAction");
        label.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('d'),"rightAction");
        label.getActionMap().put("rightAction", kb.rightAction);
        this.add(label);

        random = new Random();
        this.setPreferredSize(new Dimension(super.getWidth(),super.getHeight()));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        // this.requestFocusInWindow();
        this.setLayout(gridBounds);
        refreshGrid(gamemap);
        
    }



    public void refreshGrid(String[][] newGameMap) {
        // get and remove all grid components
        Component[] compList = this.getComponents();
        for(Component c : compList) {
            if (c instanceof JList) {
                c.setVisible(false);
                this.remove(c);
            }
        }
        // display new game map
        for (int i = 0; i < newGameMap.length; i++) {
            for (int j = 0; j < newGameMap[i].length; j++) {
                try {
                    model.set(j, newGameMap[i][j]);
                } catch ( Exception e) {
                    model.add(j, newGameMap[i][j]);
                }                  
        }
            JList<String> row  = new JList<>(model);
            row.setFixedCellHeight(20);
            row.setFixedCellWidth(30);
            this.add(row);
        }
        }
    
    public void update(String[][] gamemap) {

        refreshGrid(gamemap);
    }


    public void paintComponent(Graphics g) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // update();
    }
}


