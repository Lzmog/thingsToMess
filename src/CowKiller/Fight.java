package CowKiller;

import CowKiller.common.CowCommon;
import CowKiller.common.ItemCommon;
import CowKiller.antiban.AntiBanTask;
import org.powerbot.script.Condition;
import org.powerbot.script.Filter;
import org.powerbot.script.rt4.*;

import java.util.concurrent.Callable;

public class Fight extends Task {
    public Fight(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {

        double healthPercent = (double) ctx.skills.level(Constants.SKILLS_HITPOINTS) / (double) ctx.skills.realLevel(Constants.SKILLS_HITPOINTS);

        (new AntiBanTask(ctx)).execute();

        return ctx.players.local().healthBarVisible() == false
                && false == ctx.players.local().interacting().valid()
                && healthPercent >= 0.35
                && false == ctx.inventory.isFull()
                && (new CowCommon()).getArea().contains(ctx.players.local());
    }

    @Override
    public void execute() {
        int[] cowIds = (new CowCommon()).getCowIds();

        Filter<Npc> filter = new Filter<Npc>() {
            public boolean accept(Npc npc) {
                boolean fighting = npc.healthBarVisible();

                return false == fighting;
            }
        };

        Npc cow = ctx.npcs.select().id(cowIds).nearest().select(filter).poll();


        if (cow.inViewport()) {
            if (ctx.inventory.select().id(ItemCommon.BRONZE_SWORD_ID).count(true) == 1
                    || ctx.inventory.select().id(ItemCommon.WOODEN_SHIELD_ID).count(true) == 1) {
                for (Item i : ctx.inventory.select().id(ItemCommon.WOODEN_SHIELD_ID, ItemCommon.BRONZE_SWORD_ID)) {
                    i.interact("Wield");
                }
            }

            cow.interact("Attack");

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
