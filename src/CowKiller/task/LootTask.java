package CowKiller.task;

import CowKiller.common.CowCommon;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.GroundItem;
import org.powerbot.script.rt4.Npc;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class LootTask extends AbstractTask {
    Tile cow_tile = Tile.NIL;
    ArrayList<Tile> cowLootTile = new ArrayList<Tile>();
    private boolean statsChecker;

    public LootTask(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        if (ctx.players.local().interacting().valid()
                && !ctx.players.local().interacting().tile().equals(cow_tile)
                && !ctx.players.local().inMotion()
                && ctx.players.local().speed() == 0
        ) {
            cow_tile = ctx.players.local().interacting().tile();
            Npc cow = (Npc) ctx.players.local().interacting();

            Tile newTile = new Tile(cow_tile.x() - 1, cow_tile.y() - 1, cow_tile.floor());

            cowLootTile.add(newTile);
            System.out.println("We just added tile: " + newTile + " The cows tile was " + cow.tile());
        }

        boolean lootExists = false;

        for (Tile tile : cowLootTile) {
            if (!ctx.groundItems.select().at(tile).id(CowCommon.COWHIDE_ID).isEmpty()) {
                lootExists = true;
                break;
            }
        }

        return cowLootTile != null
                && lootExists
                && !ctx.players.local().interacting().valid()
                && !ctx.inventory.isFull()
                && this.statsChecker;
    }

    @Override
    public void execute() {
        ArrayList<Tile> toRemove = new ArrayList<Tile>();

        for (Tile tile : cowLootTile) {
            if (!ctx.groundItems.select().at(tile).id(CowCommon.COWHIDE_ID).isEmpty()) {
                GroundItem hide = ctx.groundItems.select().at(tile).id(CowCommon.COWHIDE_ID).poll();

                System.out.println("Picking cowhide");

                hide.interact("Take", hide.name());

                Callable<Boolean> booleanCallable = new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return !hide.valid();
                    }
                };

                Condition.wait(booleanCallable, 300, 10);

                toRemove.add(tile);
            }
        }

        cowLootTile.removeAll(toRemove);
    }

    private boolean statsChecker() {
        return ctx.skills.level(Constants.SKILLS_DEFENSE) == 20
                && ctx.skills.level(Constants.SKILLS_ATTACK) == 20
                && ctx.skills.level(Constants.SKILLS_STRENGTH) == 20;
    }
}
