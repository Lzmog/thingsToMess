package CowKiller;

import CowKiller.antiban.CollectionAntiBanTask;
import CowKiller.antiban.SwitchWorldTask;
import CowKiller.task.*;
import CowKiller.ui.CowhideSummaryUi;
import CowKiller.utils.DateTimeUtils;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

@Script.Manifest(name = "Cow Killer", description = "Kills Cows and Banks Cowhides")

public class CowKiller extends PollingScript<ClientContext> implements PaintListener {
    private static final int MAJOR_VERSION = 1;
    private static final int MINOR_VERSION = 0;
    private static final int PATCH_VERSION = 0;

    private int totalCowHidesFeathersPickedUp;
    ArrayList<AbstractTask> abstractTask = new ArrayList<AbstractTask>();
    private static final long START_TIME = System.currentTimeMillis();
    private final DateTimeUtils running = new DateTimeUtils(180000);
//    private final DateTimeUtils running = new DateTimeUtils(900000);

    @Override
    public void start() {
        log.info("Welcome to the basic cow killer!");

        totalCowHidesFeathersPickedUp = 0;

        abstractTask.addAll(
                Arrays.asList(
                new FightTask(ctx),
                new LootTask(ctx),
                new WalkTask(ctx),
                new BankTask(ctx),
                new CollectionAntiBanTask(ctx)
//                new SwitchWorldTask(ctx) //Have to be improved
            )
        );
    }

    @Override
    public void poll() {
        for (AbstractTask t : abstractTask) {
            if (t.activate()) {
                t.execute();
            }
        }
    }

    @Override
    public void repaint(Graphics graphics) {
        CowhideSummaryUi.ShowStatisticsSummary(
                graphics,
                MAJOR_VERSION + "." + MINOR_VERSION + "." + PATCH_VERSION,
                START_TIME,
                totalCowHidesFeathersPickedUp
        );
    }
}
