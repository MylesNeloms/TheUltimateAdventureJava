package wheetbred.superadventure.gamepack.gameboard;

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
        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();
    }

    // Action event on up input
    private class UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int newPosition = playerRef.getY()+1;
            int cross = 0;
            if (newPosition == gameMap.gameMap.length - 1) {
                newPosition = 0;
                cross = 1;
            }
            int unchanged = playerRef.getX();
            int[] oldPosition = playerRef.move(unchanged,newPosition,cross,"  ^  ");
            gameMap.setPlayer(playerRef,oldPosition[0],oldPosition[1]);
            // System.out.println(" UpAction X: " + p.playerX + "Y: " + p.playerY);
            
            
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
            int cross = 0;
            if (newPosition < 0) {
                newPosition = gameMap.gameMap.length - 2;
                cross = 2;
            }
            int unchanged = playerRef.getX();
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
            int cross = 0;
            if (newPosition < 0) {
                newPosition = gameMap.gameMap[0].length - 2;
                cross = 3;
            }
            int unchanged = playerRef.getY();
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
            int cross = 0;
            if (newPosition == gameMap.gameMap[0].length - 1) {
                newPosition =  0;
                cross = 4;
            }
            int unchanged = playerRef.getY();
            int[] oldPosition = playerRef.move(newPosition,unchanged,cross,"  >  ");
            gameMap.setPlayer(playerRef,oldPosition[0],oldPosition[1]);
            
            gPanelRef.refreshGrid(gameMap);
            System.out.println("X: " + newPosition);
            System.out.println("Y: " + unchanged);
            System.out.println("-------------------");
        }
        
    }
    
}
