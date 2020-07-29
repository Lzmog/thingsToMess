package LogomeFisher.task;

import LogomeFisher.AbstractTask;
import org.powerbot.script.rt4.ClientContext;

public class FishingTask extends AbstractTask {

    public FishingTask(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return true;
    }

    @Override
    public int execute() {
//        Npc fishingSpot = Npcs.getNearest(new Filter<Npc>() {
//            public boolean accept(Npc npc) {
//                return Arrays.binarySearch(AreaCommon.getFishingSpotArea(), npc.modelIds()) == 0;
//            }
//        });
//
//
//
//        if (fishingSpot != null) {
//            if (!fishingSpot.isOnScreen()) {
//                Camera.turnTo(fishingSpot);
//                normalSleep();
//            }
//            stats.setStatus("Fishing");
//            fishingSpot.interact("Net");
//        }
//
//        Time.sleep(Random.nextGaussian(200, 1000, STD));
//
        return 0;
    }
}
