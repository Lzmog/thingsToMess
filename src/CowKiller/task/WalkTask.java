package CowKiller.task;

import CowKiller.common.CowCommon;
import CowKiller.common.PathCommon;
import CowKiller.utils.WalkerUtil;
import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.concurrent.Callable;

public class WalkTask extends AbstractTask {
    public Area cowArea = new CowCommon().getArea();

    WalkerUtil walkerUtil = new WalkerUtil(ctx);
    Tile[] path = new PathCommon().getPath();

    public WalkTask(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.bank.nearest().tile().distanceTo(ctx.players.local()) > 4 && ctx.inventory.isFull())
                || (!ctx.inventory.isFull() && !cowArea.contains(ctx.players.local()));
    }

    @Override
    public void execute() {

        if (ctx.movement.energyLevel() > 20) {
            ctx.movement.running(true);
        }

        if (ctx.movement.destination().equals(Tile.NIL)
                || ctx.movement.destination().distanceTo(ctx.players.local()) < 5) {
            if (ctx.inventory.isFull()) {
                if (path[0].distanceTo(ctx.players.local()) > 5 && cowArea.contains(ctx.players.local())) {
                    Tile currentTile = ctx.players.local().tile();

                    ctx.movement.step(path[0]);

                    Callable<Boolean> booleanCallable = () -> !ctx.players.local().tile().equals(currentTile);
                    Condition.wait(booleanCallable);
                }

                Tile currentTile = ctx.players.local().tile();
                walkerUtil.walkPath(path);

                Callable<Boolean> booleanCallable = () -> ctx.players.local().tile().equals(currentTile);

                Condition.wait(booleanCallable);
            } else if (!cowArea.contains(ctx.players.local())) {
                Tile currentTile = ctx.players.local().tile();
                walkerUtil.walkPathReverse(path);

                Callable<Boolean> booleanCallable = () -> ctx.players.local().tile().equals(currentTile);

                Condition.wait(booleanCallable);
            }
        }
    }
}
