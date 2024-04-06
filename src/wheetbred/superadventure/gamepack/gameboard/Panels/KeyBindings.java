package wheetbred.superadventure.gamepack.gameboard.Panels;

import wheetbred.superadventure.gamepack.entities.Player;
import wheetbred.superadventure.gamepack.mapgenerator.GameMap;
import wheetbred.superadventure.gamepack.mapgenerator.Generator;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class KeyBindings {
    // classes and vars to be used in the constructor
    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;
    private Player playerRef;
    private GamePanel gPanelRef;
    private GameMap gameMap;

    // generator for testing map changes.
    Generator map = new Generator();
    public KeyBindings(Player player, GamePanel panel, GameMap map) {
        // reference to player and Jframe to update the display and user locations
        this.playerRef = player;
        this.gPanelRef = panel;
        this.gameMap = map;
        // Initialize Actions
        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();
    }

    // Action event on up input. Comments here apply to all abstract actions added to this class
    private class UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Calculate new player position
            // set cross to default value of 0. This var tracks when the player crosses map borders
            int newPosition = playerRef.getY()+1;
            int unchanged = playerRef.getX();
            int cross = 0;
            // Check if the new position crosses the gamemap border
            // reset position to accurate val,
            if (newPosition > gameMap.gameMap.length - 2) {
                newPosition = 0;
                cross = 1;
            }

            
            // Update the player with the new position value. Move returns an array of the old position 
            // so that gamemap can reset that index to it's previous value while updating map to move player character
            int[] oldPosition = playerRef.move(unchanged,newPosition,cross,"  ^  ");
            gameMap.setPlayer(playerRef,oldPosition[0],oldPosition[1]);

            
            // Refresh the grid with the newly updated gameMap
            gPanelRef.refreshGrid(gameMap);
            System.out.println("X: " + unchanged);
            System.out.println("Y: " + newPosition);
            System.out.println("-------------------");
        }
        
    }

    // Action event on down input
    private class DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int newPosition = playerRef.getY()-1;
            int unchanged = playerRef.getX();
            int cross = 0;
            if (newPosition < 0) {
                newPosition = gameMap.gameMap.length - 2;
                cross = 2;
            }

            int[] oldPosition = playerRef.move(unchanged,newPosition,cross,"  v  ");
            gameMap.setPlayer(playerRef,oldPosition[0],oldPosition[1]);

            gPanelRef.refreshGrid(gameMap);
            System.out.println("X: " + unchanged);
            System.out.println("Y: " + newPosition);
            System.out.println("-------------------");
        }
        
    }

    // Action event on left input
    private class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int newPosition = playerRef.getX()-1;
            int unchanged = playerRef.getY();
            int cross = 0;
            if (newPosition < 0) {
                newPosition = gameMap.gameMap[0].length - 2;
                cross = 3;
            }

            int[] oldPosition = playerRef.move(newPosition,unchanged,cross, "  <  ");
            gameMap.setPlayer(playerRef,oldPosition[0],oldPosition[1]);

            gPanelRef.refreshGrid(gameMap);
            System.out.println("X: " + newPosition);
            System.out.println("Y: " + unchanged);
            System.out.println("-------------------");
        }
        
    }

    // Action event on right input
    private class RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int newPosition = playerRef.getX()+1;
            int unchanged = playerRef.getY();
            int cross = 0;
            if (newPosition > gameMap.gameMap[0].length - 2) {
                newPosition =  0;
                cross = 4;
            }

            int[] oldPosition = playerRef.move(newPosition,unchanged,cross,"  >  ");
            gameMap.setPlayer(playerRef,oldPosition[0],oldPosition[1]);
            
            gPanelRef.refreshGrid(gameMap);
            System.out.println("X: " + newPosition);
            System.out.println("Y: " + unchanged);
            System.out.println("-------------------");
        }
        
    }
    
}
