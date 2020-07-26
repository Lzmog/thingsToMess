package CowKiller.common;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class CowCommon {
    public static final int COWHIDE_ID = 1739;

    /**
     * @return Area
     */
    public Area getArea() {
        return new Area(
                new Tile(3242, 3298, 0),
                new Tile(3246, 3279, 0),
                new Tile(3253, 3278, 0),
                new Tile(3253, 3255, 0),
                new Tile(3265, 3255, 0),
                new Tile(3265, 3296, 0)
        );
    }

    /**
     * @return int[]
     */
    public int[] getCowIds() {
        return new int[]{
                2790,
                2791,
                2793
        };
    }
}
