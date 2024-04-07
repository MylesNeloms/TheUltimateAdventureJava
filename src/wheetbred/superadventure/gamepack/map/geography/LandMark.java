package wheetbred.superadventure.gamepack.map.geography;

import java.util.ArrayList;

public abstract class LandMark {
    protected double spawnRate;
    protected int size;
    protected int Tile;
    protected ArrayList<int[]> spawnList = new ArrayList<int[]>();

    protected abstract String[][] grow(String[][] gameMap,ArrayList<int[]> spawnList);
    public abstract String[][] draw(int count, String[][] gameMap, int... Xy);
}