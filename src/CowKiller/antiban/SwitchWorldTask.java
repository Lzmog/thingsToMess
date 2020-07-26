package CowKiller.antiban;

import CowKiller.task.AbstractTask;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.World;

public class SwitchWorldTask extends AbstractTask {
    public SwitchWorldTask(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Random.nextInt(0, 15) == 3
                && !ctx.players.local().interacting().valid();
    }

    @Override
    public void execute() {
        this.hopWorld(ctx);
    }

    public void hopWorld(ClientContext ctx) {
            System.out.println("Hopping worlds");

            ctx.worlds.open();
            ctx.worlds.select().types(World.Type.MEMBERS);
            ctx.worlds.select().joinable();
            ctx.worlds.shuffle();
            ctx.worlds.peek().hop();
            Condition.sleep(2000);
        }

//        final Worlds currentWorld = ctx.widgets.component(69, 2);
//        final Worlds newWorld = ctx.worlds.select().types(World.Type.FREE).joinable();
//
//
//        ctx.worlds.select(new Filter<World>() {
//            @Override
//            public boolean accept(World world) {
//                return World.Type.MEMBERS != Integer.parseInt(ctx.widgets.get(550, 18).getText().substring(26));
//            }
//        }).types(World.Type.FREE).joinable().hop();
}
