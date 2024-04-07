package wheetbred.superadventure.gamepack.map.geography;

import java.util.ArrayList;

public class Rock extends LandMark {
    final int size = (int)(Math.random()* 3);
    final String rockTile = "rrr";
    public Rock() {
        spawnRate = 0.003;
        
    }

    @Override
    public String[][] draw(int count, String[][] gameMap, int... Xy) {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                double randomValue = Math.random();
                if (randomValue < spawnRate) {
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
        System.out.println("Rock spawn count: " + spawnList.size());
        spawnList.forEach(Xy -> {
            int X = Xy[0];
            int Y = Xy[1];


            for (int i = 0; i <= size; i++) {
                for (int j = 0; j <= size; j++) {
                    boolean rocksNotTooClose = true;
                    for (int l = 0; l <= 4; l++) {
                        if (X < 0) {
                            X = (gameMap[0].length - 1) + X;
                        } else if (X > (gameMap[0].length - 1)) {
                            X = X - (gameMap[0].length - 1);
                        }
                        if (Y < 0) {
                            Y = (gameMap.length - 1) + Y;
                        } else if (Y > (gameMap.length - 1)) {
                            Y = Y - (gameMap.length - 1);
                        }

                        if (gameMap[Y][X].equals(rockTile)) {
                            rocksNotTooClose = false;
                        }
                        switch(l) {
                            case(1):
                                Y--;
                                break;
                            case(2):
                                X--;
                                break;
                            case(3):
                                Y++;
                                break;
                        }
                    }

                if (rocksNotTooClose) {
                    X = Xy[0];
                    Y = Xy[1];
                    for (int l = 0; l <= 4; l++) {
                        if (X < 0) {
                            X = (gameMap[0].length - 1) + X;
                        } else if (X > (gameMap[0].length - 1)) {
                            X = X - (gameMap[0].length - 1);
                        }
                        if (Y < 0) {
                            Y = (gameMap.length - 1) + Y;
                        } else if (Y > (gameMap.length - 1)) {
                            Y = Y - (gameMap.length - 1);
                        }
                            gameMap[Y][X] = rockTile;
                        switch(l) {
                            case(1):
                                Y--;
                                break;
                            case(2):
                                X--;
                                break;
                            case(3):
                                Y++;
                                break;
                        }
                    }
                }

                }
            }
        });
        return gameMap;
    }
}
