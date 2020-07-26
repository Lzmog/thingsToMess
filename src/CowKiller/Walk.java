package CowKiller;

import CowKiller.Common.CowCommon;
import CowKiller.Common.PathCommon;
import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.concurrent.Callable;

public class Walk extends Task {
    public Area cowArea = new CowCommon().getArea();
    public Tile[] path = new PathCommon().getPath();

    Walker walker = new Walker(ctx);

    public Walk(ClientContext ctx) {

        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.bank.nearest().tile().distanceTo(ctx.players.local()) > 4 && ctx.inventory.isFull())
                || (false == ctx.inventory.isFull() && false == cowArea.contains(ctx.players.local()));
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

                    Callable<Boolean> booleanCallable = new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return false == ctx.players.local().tile().equals(currentTile);
                        }
                    };
                    Condition.wait(booleanCallable);
                }

                Tile currentTile = ctx.players.local().tile();
                walker.walkPath(path);

                Callable<Boolean> booleanCallable = new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ctx.players.local().tile().equals(currentTile);
                    }
                };

                Condition.wait(booleanCallable);
            } else if (false == cowArea.contains(ctx.players.local())) {
                Tile currentTile = ctx.players.local().tile();
                walker.walkPathReverse(path);

                Callable<Boolean> booleanCallable = new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ctx.players.local().tile().equals(currentTile);
                    }
                };

                Condition.wait(booleanCallable);
            }
        }
    }
}
