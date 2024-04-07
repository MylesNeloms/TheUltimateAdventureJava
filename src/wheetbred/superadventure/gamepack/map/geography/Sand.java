package wheetbred.superadventure.gamepack.map.geography;

import java.util.ArrayList;

public class Sand extends LandMark {
    final String sandTile = "  s  ";
    public Sand () {
        spawnRate = 0.001;
        size = 8;
    }


    @Override
    public String[][] draw(int count, String[][] gameMap, int... Xy) {
        String[][] ammendedMap = gameMap;
        int[][] mapValues = new int[gameMap.length][gameMap[0].length];
        for (int i = 0; i < ammendedMap.length; i++) {
            for (int j = 0; j < ammendedMap[i].length; j++) {
                double randomValue = Math.random();
                if (randomValue < spawnRate) {
                    ammendedMap[i][j] = sandTile;
                    int[] spawnpoint = {j,i};
                    spawnList.add(spawnpoint);
                }
            }
        }
        ammendedMap = grow(ammendedMap, spawnList);

        return ammendedMap;
    }
    @Override
    protected String[][] grow(String [][] gameMap, ArrayList<int[]> spawnList) {
        System.out.println("Sand spawn count: " + spawnList.size());
        spawnList.forEach(Xy -> {
            int X = Xy[0];
            int xSize = X + size + (int)(Math.random() * 3);
            int xNSize = X - size + (int)(Math.random() * 3);
            int Y = Xy[1];
            int ySize = Y + size + (int)(Math.random() * 3);
            int yNSize = Y - size + (int)(Math.random() * 3);
            for (int i = xNSize; i <= xSize; i++) {
                for (int j = yNSize; j <= ySize + size; j++) {
                    boolean isNotOuterLoop = (i < xSize && i > xNSize) && (j < ySize && j >yNSize);
                    if (isNotOuterLoop) {
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
                        if (chance < spawnRate * 700) {
                            gameMap[y][x] = sandTile;
                        }
                    }
                }
            }
        });
        return gameMap;
    }

}
