package LogomeFisher.common;


import org.powerbot.script.Tile;

public class AreaCommon {
    /**
     * @return bank area tiles
     */
    public static Tile[] getBankArea() {
        return new Tile[]{
                new Tile(3094, 3240, 0),
                new Tile(3092, 3246, 0),
        };
    }

    /**
     * @return fishing spot area tiles
     */
    public static Tile[] getFishingSpotArea() {
        return new Tile[]{
                new Tile(3092, 3243, 0),
                new Tile(3086, 3231, 0),
        };
    }
}
