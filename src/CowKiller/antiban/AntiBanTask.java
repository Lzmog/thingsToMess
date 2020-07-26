package CowKiller.antiban;

import CowKiller.Common.CowCommon;
import CowKiller.Task;
import CowKiller.utils.CommonUtil;
import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

import java.awt.*;

public class AntiBanTask extends Task {
    int[] cowIds = (new CowCommon()).getCowIds();
    Area area = new CowCommon().getArea();

    public AntiBanTask(ClientContext ctx) {
        super(ctx);
    }

    /**
     * When player is idle, perform anti-ban actions.
     * @return true to perform anti-ban action
     */
    @Override
    public boolean activate() {
        return ctx.players.local().animation() == CommonUtil.PLAYER_IDLE
                && Random.nextInt(0, 25) == 3;
    }

    /**
     * Execute the anti-ban action in the getArea. Not all anti-ban actions will always be executed.
     * Poor man's attempt at randomizing.
     */
    @Override
    public void execute() {

//        int numberOfAntiBanActions = 0;

        // Move camera to a random cow
        if (Random.nextInt(0, 20) == 3) {
            for (Npc c : ctx.npcs.within(area).select().id(cowIds).shuffle()) {
                if (c.valid()) {
                    System.out.println("Turning towards a random cow.");

                    ctx.camera.turnTo(c);
//                    numberOfAntiBanActions++;
                    Condition.sleep(Random.nextInt(50, 1500));
                    break;
                }
            }
        }

        // Move mouse to the edges of the client
        if (Random.nextInt(0, 15) == 3) {
            System.out.println("moving mouse.");
            int x;
            int y;
            switch (Random.nextInt(0, 4)) {
                case 0:
                    // North
                    x = Random.nextInt(CommonUtil.ClientCornerPoint.NW.x, CommonUtil.ClientCornerPoint.NE.x + 1);
                    y = CommonUtil.ClientCornerPoint.NE.y;
                    break;
                case 1:
                    // East
                    x = CommonUtil.ClientCornerPoint.NE.x;
                    y = Random.nextInt(CommonUtil.ClientCornerPoint.NE.y, CommonUtil.ClientCornerPoint.SE.y + 1);
                    break;
                case 2:
                    // SOUTH
                    x = Random.nextInt(CommonUtil.ClientCornerPoint.SW.x, CommonUtil.ClientCornerPoint.SE.x + 1);
                    y = CommonUtil.ClientCornerPoint.SE.y;
                    break;
                default:
                    // West
                    x = CommonUtil.ClientCornerPoint.NW.x;
                    y = Random.nextInt(CommonUtil.ClientCornerPoint.NW.y, CommonUtil.ClientCornerPoint.SW.y + 1);
                    break;
            }

            System.out.println("Moving mouse to the edge of the screen.");

            ctx.input.move(new Point(x, y));
//            numberOfAntiBanActions++;
            Condition.sleep(Random.nextInt(10, 1500));
        }
//        return numberOfAntiBanActions;
    }
}
