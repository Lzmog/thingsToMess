package CowKiller;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Filter;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.*;

import java.util.concurrent.Callable;

public class Fight extends Task {
    int shieldId = 1171;
    int swordId = 1277;
    int[] cowIds = {2790, 2791, 2793};
    Area cowField = new Area(
            new Tile(3242, 3298, 0),
            new Tile(3246, 3279, 0),
            new Tile(3253, 3278, 0),
            new Tile(3253, 3255, 0),
            new Tile(3265, 3255, 0),
            new Tile(3265, 3296, 0)
    );

    public Fight(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {

        double healthPercent = (double) ctx.skills.level(Constants.SKILLS_HITPOINTS) / (double) ctx.skills.realLevel(Constants.SKILLS_HITPOINTS);

        return ctx.players.local().healthBarVisible() == false
                && false == ctx.players.local().interacting().valid()
//                && healthPercent >= 0.35
                && false == ctx.inventory.isFull()
                && cowField.contains(ctx.players.local());
    }

    @Override
    public void execute() {
        Filter<Npc> filter = new Filter<Npc>() {
            public boolean accept(Npc npc) {
                boolean fighting = npc.healthBarVisible();

                return false == fighting;
            }
        };

        Npc cow = ctx.npcs.select().id(cowIds).nearest().select(filter).poll();


        if (cow.inViewport()) {
            if (ctx.inventory.select().id(swordId).count(true) == 1
                    || ctx.inventory.select().id(shieldId).count(true) == 1) {
                for (Item i : ctx.inventory.select().id(shieldId, swordId)) {
                    i.interact("Wield");
                }
            }

            cow.interact("Attack");

//            Random random = new Random();
//            int randomDegree = random.nextInt((360 - 1) + 1);
//
//            System.out.println(randomDegree);

            ctx.camera.angle('n'); //moving camera sometime makes confuse

            Callable<Boolean> booleanCallable = new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.players.local().interacting().valid()
                            && false == ctx.players.local().inMotion();
                }
            };

            Condition.wait(booleanCallable, 100, 25);
        } else {
            ctx.camera.turnTo(cow);
        }
    }
}
