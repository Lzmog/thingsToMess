package CowKiller;

import CowKiller.ui.CowhideSummaryUi;
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
    ArrayList<Task> task = new ArrayList<Task>();
    private static final long START_TIME = System.currentTimeMillis();

    @Override
    public void start() {
        log.info("Welcome to the basic cow killer!");

        totalCowHidesFeathersPickedUp = 0;

        task.addAll(Arrays.asList(
                new Fight(ctx),
                new Loot(ctx),
                new Walk(ctx),
                new Bank(ctx)
        ));
    }

    @Override
    public void poll() {
        for (Task t : task) {
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
