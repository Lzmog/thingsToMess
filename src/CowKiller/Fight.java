package CowKiller;

import org.powerbot.script.Condition;
import org.powerbot.script.Filter;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

import java.util.Random;
import java.util.concurrent.Callable;

public class Fight extends Task {
    int[] cowIds = {2790, 2791, 2793};

    public Fight(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().healthBarVisible() == false
                && false == ctx.players.local().interacting().valid()
                && ctx.players.local().healthPercent() >= 35;
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
