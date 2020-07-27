package CowKiller.task;


import CowKiller.common.CowCommon;
import CowKiller.common.ItemCommon;
import org.powerbot.script.Condition;
import org.powerbot.script.Filter;
import org.powerbot.script.rt4.*;

import java.util.concurrent.Callable;

public class FightTask extends AbstractTask {
    public FightTask(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        double healthPercent = (double) ctx.skills.level(Constants.SKILLS_HITPOINTS) / (double) ctx.skills.realLevel(Constants.SKILLS_HITPOINTS);

        return !ctx.players.local().healthBarVisible()
                && !ctx.players.local().interacting().valid()
//                && healthPercent >= 0.35
                && !ctx.inventory.isFull()
                && (new CowCommon()).getArea().contains(ctx.players.local());
    }

    @Override
    public void execute() {
        int[] cowIds = (new CowCommon()).getCowIds();

        Filter<Npc> filter = new Filter<Npc>() {
            public boolean accept(Npc npc) {
                boolean fighting = npc.healthBarVisible();

                return !fighting;
            }
        };

        Npc cow = ctx.npcs.select().id(cowIds).nearest().select(filter).poll();


        if (cow.inViewport()) {
            if (ctx.inventory.select().id(ItemCommon.BRONZE_SWORD_ID).count(true) == 1
                    || ctx.inventory.select().id(ItemCommon.WOODEN_SHIELD_ID).count(true) == 1)
            {
                if (!ctx.game.tab().equals(Game.Tab.INVENTORY)) {
                    ctx.game.tab(Game.Tab.INVENTORY);
                }

                for (Item i : ctx.inventory.select().id(ItemCommon.WOODEN_SHIELD_ID, ItemCommon.BRONZE_SWORD_ID)) {
                    i.interact("Wield");
                }
            }

            cow.interact("Attack");

            Callable<Boolean> booleanCallable = new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.players.local().interacting().valid()
                            && !ctx.players.local().inMotion();
                }
            };

            Condition.wait(booleanCallable, 100, 25);
        } else {
            ctx.camera.turnTo(cow);
        }
    }
}
