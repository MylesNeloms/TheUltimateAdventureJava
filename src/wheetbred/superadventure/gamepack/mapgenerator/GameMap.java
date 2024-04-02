package wheetbred.superadventure.gamepack.mapgenerator;

/* 

The map will be an array of characters, intended to be organized by a grid. Map will be generated to hold 

*/ 

public class GameMap {
    private final static Generator mapGen = new Generator();
    public String[][] gameMap;
    public GameMap() {
        this.gameMap = mapGen.generateBaseMap();
    }
}
