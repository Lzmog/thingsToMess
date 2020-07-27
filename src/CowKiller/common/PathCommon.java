package CowKiller.common;

import org.powerbot.script.Random;
import org.powerbot.script.Tile;

public class PathCommon {
    /**
     * @return Tile[]
     */
    public Tile[] getPath() {
        int randomNumber = Random.nextInt(0, 3);

        switch (randomNumber) {
            default:
                System.out.println("Taking path");

                return getFirstPath();
            case 0:
                System.out.println("Taking first path");

                return getFirstPath();
            case 1:

                System.out.println("Taking second path");

                return getSecondPath();
            case 2:
                System.out.println("Taking third path");

                return getThirdPathBridge();
            case 3:
                System.out.println("Taking fourth path");

                return getFourthPath();
//            case 5:
//                return getFithPath();
        }
    }

    /**
     * @return Tile[]
     */
    private Tile[] getFirstPath() {
        return new Tile[] {
                new Tile(3253, 3267, 0),
                new Tile(3250, 3266, 0),
                new Tile(3250, 3263, 0),
                new Tile(3250, 3260, 0),
                new Tile(3250, 3257, 0),
                new Tile(3250, 3254, 0),
                new Tile(3252, 3251, 0),
                new Tile(3255, 3249, 0),
                new Tile(3257, 3246, 0),
                new Tile(3258, 3243, 0),
                new Tile(3259, 3240, 0),
                new Tile(3259, 3237, 0),
                new Tile(3259, 3234, 0),
                new Tile(3259, 3231, 0),
                new Tile(3258, 3228, 0),
                new Tile(3255, 3226, 0),
                new Tile(3252, 3226, 0),
                new Tile(3249, 3226, 0),
                new Tile(3246, 3226, 0),
                new Tile(3243, 3226, 0),
                new Tile(3240, 3226, 0),
                new Tile(3238, 3223, 0),
                new Tile(3235, 3222, 0),
                new Tile(3232, 3219, 0),
                new Tile(3229, 3218, 0),
                new Tile(3226, 3218, 0),
                new Tile(3223, 3218, 0),
                new Tile(3220, 3218, 0),
                new Tile(3217, 3218, 0),
                new Tile(3215, 3215, 0),
                new Tile(3215, 3212, 0),
                new Tile(3212, 3211, 0),
                new Tile(3209, 3211, 0),
                new Tile(3206, 3209, 0),
                new Tile(3205, 3209, 1),
                new Tile(3205, 3209, 2),
                new Tile(3205, 3212, 2),
                new Tile(3205, 3215, 2),
                new Tile(3206, 3218, 2),
                new Tile(3209, 3220, 2),
        };
    }

    /**
     * @return Tile[]
     */
    private Tile[] getSecondPath() {
        return new Tile[] {
                new Tile(3253, 3266, 0),
                new Tile(3250, 3264, 0),
                new Tile(3251, 3257, 0),
                new Tile(3254, 3250, 0),
                new Tile(3257, 3245, 0),
                new Tile(3259, 3234, 0),
                new Tile(3257, 3227, 0),
                new Tile(3252, 3226, 0),
                new Tile(3246, 3226, 0),
                new Tile(3240, 3226, 0),
                new Tile(3237, 3221, 0),
                new Tile(3231, 3219, 0),
                new Tile(3224, 3218, 0),
                new Tile(3218, 3219, 0),
                new Tile(3214, 3221, 0),
                new Tile(3215, 3225, 0),
                new Tile(3209, 3228, 0),
                new Tile(3206, 3228, 0),
                new Tile(3206, 3229, 1),
                new Tile(3206, 3229, 2),
                new Tile(3206, 3225, 2),
                new Tile(3206, 3221, 2),
                new Tile(3208, 3218, 2),
                new Tile(3209, 3220, 2),
        };
    }

    /**
     * @return Tile[]
     */
    private Tile[] getThirdPathBridge() {
        return new Tile[] {
                new Tile(3253, 3266, 0),
                new Tile(3247, 3266, 0),
                new Tile(3242, 3264, 0),
                new Tile(3236, 3262, 0),
                new Tile(3224, 3260, 0),
                new Tile(3219, 3257, 0),
                new Tile(3217, 3252, 0),
                new Tile(3218, 3247, 0),
                new Tile(3221, 3241, 0),
                new Tile(3225, 3235, 0),
                new Tile(3229, 3232, 0),
                new Tile(3232, 3221, 0),
                new Tile(3228, 3218, 0),
                new Tile(3222, 3218, 0),
                new Tile(3217, 3218, 0),
                new Tile(3215, 3220, 0),
                new Tile(3214, 3227, 0),
                new Tile(3210, 3227, 0),
                new Tile(3206, 3229, 0),
                new Tile(3206, 3229, 1),
                new Tile(3206, 3229, 2),
                new Tile(3206, 3225, 2),
                new Tile(3209, 3220, 2),
        };
    }

    /**
     * @return Tile[]
     */
    private Tile[] getFourthPath() {
        return new Tile[] {
                new Tile(3253, 3266, 0),
                new Tile(3249, 3267, 0),
                new Tile(3245, 3266, 0),
                new Tile(3241, 3261, 0),
                new Tile(3236, 3261, 0),
                new Tile(3230, 3262, 0),
                new Tile(3231, 3257, 0),
                new Tile(3231, 3253, 0),
                new Tile(3231, 3249, 0),
                new Tile(3231, 3245, 0),
                new Tile(3235, 3241, 0),
                new Tile(3234, 3237, 0),
                new Tile(3234, 3233, 0),
                new Tile(3234, 3229, 0),
                new Tile(3234, 3225, 0),
                new Tile(3233, 3221, 0),
                new Tile(3231, 3218, 0),
                new Tile(3227, 3219, 0),
                new Tile(3221, 3219, 0),
                new Tile(3217, 3219, 0),
                new Tile(3215, 3215, 0),
                new Tile(3212, 3209, 0),
                new Tile(3208, 3210, 0),
                new Tile(3206, 3209, 0),
                new Tile(3205, 3209, 1),
                new Tile(3205, 3209, 2),
                new Tile(3205, 3212, 2),
                new Tile(3205, 3215, 2),
                new Tile(3206, 3218, 2),
                new Tile(3209, 3220, 2),
        };
    }

    /**
     * @return Tile[]
     */
    private Tile[] getFithPath() {
        return new Tile[] {
                new Tile(3253, 3267, 0),
        };
    }
}
