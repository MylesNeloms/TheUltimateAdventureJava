package wheetbred.superadventure.gamepack.gameboard.Panels;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


import wheetbred.superadventure.gamepack.entities.*;
import wheetbred.superadventure.gamepack.map.GameMap;

import java.awt.Component;
import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.util.List;



public class GamePanel extends JPanel {
    /*
    Changed to use GridBag constraints as this will display my Map(array of Characters) in 
    a simpler way than painting each element
    */ 
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagLayout gridBounds =  new GridBagLayout();


    private Player player;

    //Initialize key Bindings
    KeyBindings kb;


    // String[][] gamemap1 = map1.generateAlternateMap();

    public GamePanel(GameMap gameMap) {
        // get a reference to the player object
        player = GameMap.getPlayer(gameMap);
        // adding keybindings to listen to keyboard inputs and update player position and visible map
        kb = new KeyBindings(player, this, gameMap);

        // Creating an invisible label to add key bindings set to size of gameframe
        JLabel label = new JLabel();
        label.setBounds(0,0,600,600);

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
        // Add label to panel
        this.add(label);

        // set size and layout then display grid
        this.setBounds(0,0, 430, 540);
        this.setFocusable(true);
        this.setLayout(gridBounds);
        refreshGrid(gameMap);
    }


    // Method used to update GameFrame...panel as player moves over the map
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
            // Use default list mode for even spacing add each model to a JList then add that to the panel. 
            // panel Fills from top to bottom
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
    }

}


