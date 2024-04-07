package wheetbred.superadventure.gamepack.map.geography;

import java.util.ArrayList;

public class Tree extends LandMark{

    final String treeTile = " T ";
    final String branchTile = " b ";
    final int size = 2;
    final int branchSize = (int)(Math.random()* size + 3);
    final int limit = 4;

    public Tree() {
        spawnRate = 0.0005;
    }


    @Override
    public String[][] draw(int count, String[][] gameMap, int... Xy) {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                double randomValue = Math.random();
                if (randomValue < spawnRate) {
                    gameMap[i][j] = treeTile;
                    int[] spawnpoint = {j,i};
                    spawnList.add(spawnpoint);
                }
            }
        }
        gameMap = grow(gameMap, spawnList);

        return gameMap;
    }
    @Override
    protected String[][] grow(String [][] gameMap, ArrayList<int[]> spawnList) {
        System.out.println("Tree spawn count: " + spawnList.size());
        spawnList.forEach(Xy -> {
            int X = Xy[0];
            int xSize = X + size + (int)(Math.random() * 3);
            int xNSize = X - size - (int)(Math.random() * 3);
            int Y = Xy[1];
            int ySize = Y + size + (int)(Math.random() * 3);
            int yNSize = Y - size - (int)(Math.random() * 3);
            for (int i = xNSize; i <= xSize; i++) {
                for (int j = yNSize; j <= ySize; j++) {
                    boolean isNotOuterLoop = (i < xSize && i > xNSize) && (j < ySize && j >yNSize);
                    if (isNotOuterLoop) {
                        int x = i;
                        int y = j;

                        if (i < 0) {
                            x = (gameMap[0].length - 1) + x;
                        } else if (i > (gameMap[0].length - 1)) {
                            x = x - (gameMap[0].length);
                        }
                        if (j < 0) {
                            y = (gameMap.length - 1) + y;
                        } else if (j > (gameMap.length - 1)) {
                            y = y - (gameMap.length);
                        }

                        
                        // if (chance < spawnRate * 700) {
                            gameMap[y][x] = treeTile;
                        // }
                    } else {
                        int x = i;
                        int y = j;

                        if (i < 0) {
                            x = (gameMap[0].length - 1) + x;
                        } else if (i > (gameMap[0].length - 1)) {
                            x = x - (gameMap[0].length - 1);
                        }
                        if (j < 0) {
                            y = (gameMap.length - 1) + y;
                        } else if (j > (gameMap.length - 1)) {
                            y = y - (gameMap.length - 1);
                        }

                        double chance = Math.random();
                        if (chance < spawnRate * 500) {
                            gameMap[y][x] = treeTile;
                        }
                    }
                }
            }
        });
        return gameMap;
    }
}