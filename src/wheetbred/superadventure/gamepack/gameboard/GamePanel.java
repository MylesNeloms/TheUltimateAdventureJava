package wheetbred.superadventure.gamepack.gameboard;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import wheetbred.superadventure.gamepack.entities.*;
import wheetbred.superadventure.gamepack.mapgenerator.GameMap;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;



public class GamePanel extends JPanel implements ActionListener {
    /*
    Changed to use GridBag constraints as this will display my Map(array of Characters) in 
    a simpler way than painting each element
    */ 
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagLayout gridBounds =  new GridBagLayout();
    
    Timer timer;

    // Default Player Position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 3;
    Player player = new Player();

    //Initialize key Bindings
    KeyBindings kb;


    // String[][] gamemap1 = map1.generateAlternateMap();

    public GamePanel(GameMap gameMap) {
        // adding keybindings to listen to keyboard inputs
        kb = new KeyBindings(player, this, gameMap);
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

        this.setPreferredSize(new Dimension(super.getWidth(),super.getHeight()));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        // this.requestFocusInWindow();
        this.setLayout(gridBounds);
        refreshGrid(gameMap);
        System.out.println(gameMap.visibleMap[0].length);
        // System.out.println(Arrays.deepToString(gameMap.visibleMap));
    }



    public void refreshGrid(GameMap newGameMap) {
        // get and remove all grid components
        List<DefaultListModel> models;
        List<JList> rows;
        Component[] compList = this.getComponents();
        for(Component c : compList) {
            if (c instanceof JList) {
                c.setVisible(false);
                this.remove(c);
            }
        }
        // display new game map
        for (int i = 0; i < newGameMap.visibleMap.length; i++) {
            DefaultListModel<String> model = new DefaultListModel<>();
            for (int j = 0; j < newGameMap.visibleMap[i].length; j++) {
                try {
                    model.set(j, newGameMap.visibleMap[i][j]);
                } catch ( Exception e) {
                    model.add(j, newGameMap.visibleMap[i][j]);
                } 
                // models.add(model);
        }
        JList<String> row  = new JList<>(model);
        row.setFixedCellHeight(20);
        row.setFixedCellWidth(30);
        row.setEnabled(false);
        this.add(row);
        }

        // for (DefaultListModel model : models) {

        // }

        }
    
    // public void update(String[][] gamemap) {

    //     refreshGrid(gamemap);
    // }


    public void paintComponent(Graphics g) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // update();
    }
}


