package wheetbred.superadventure.gamepack.gameboard;

import wheetbred.superadventure.gamepack.entities.Player;
import wheetbred.superadventure.gamepack.mapgenerator.GameMap;
import wheetbred.superadventure.gamepack.mapgenerator.Generator;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

public class KeyBindings {
    // classes and vars to be used in the constructor
    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;
    private Player playerRef;
    private GamePanel gPanelRef;

    // generator for testing map changes.
    Generator map = new Generator();
    public KeyBindings(Player player, GamePanel panel) {
        // reference to player and Jframe to update the display and user locations
        playerRef = player;
        gPanelRef = panel;
        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();
    }

    // Action event on up input
    private class UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int newPosition = playerRef.getplayerY()+1;
            playerRef.setPlayerY(newPosition);
            // System.out.println(" UpAction X: " + p.playerX + "Y: " + p.playerY);
            gPanelRef.refreshGrid(map.generateAlternateMap("U"));
        }
        
    }

    // Action event on down input
    private class DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int newPosition = playerRef.getplayerY()-1;
            playerRef.setPlayerY(newPosition);
            gPanelRef.refreshGrid(map.generateAlternateMap("D"));
        }
        
    }

    // Action event on left input
    private class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int newPosition = playerRef.getplayerX()-1;
            playerRef.setPlayerX(newPosition);
            gPanelRef.refreshGrid(map.generateAlternateMap("L"));
        }
        
    }

    // Action event on right input
    private class RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int newPosition = playerRef.getplayerX()+1;
            playerRef.setPlayerX(newPosition);
            gPanelRef.refreshGrid(map.generateAlternateMap("R"));
        }
        
    }
    
}
