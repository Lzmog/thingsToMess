package LogomeFisher;

import LogomeFisher.task.FishingTask;
import LogomeFisher.ui.Stats;
import LogomeFisher.ui.StatsPaint;
import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

@Script.Manifest(name = "Logome Fisher", description = "Be a fisherman")

public class Main extends PollingScript<ClientContext> implements MessageListener, PaintListener {
    public static final int INVETORY_SIZE = 28;
    private Stats stats;
    private StatsPaint paint;

    ArrayList<AbstractTask> abstractTask = new ArrayList<>();


    @Override
    public void start() {
        String[] userOptions = {"Draynor", "Barbarian"};
        String userChoice = ""+ JOptionPane.showInputDialog(
                null,
                "Location Picker",
                "Fish and Bank",
                JOptionPane.PLAIN_MESSAGE,
                null,
                userOptions,
                userOptions[0]
        );

        stats = Stats.getInstance();
        stats.setFishLevel(ctx.skills.level(Constants.SKILLS_FISHING));

        abstractTask.addAll(
                Collections.singletonList(
                        new FishingTask(ctx)
                )
        );
    }

    @Override
    public void poll() {
        for (AbstractTask task : abstractTask ) {
            if (task.activate()) {
                task.execute();
            }
        }
    }

    @Override
    public void repaint(Graphics graphics) {
        paint.draw(graphics);
    }

    @Override
    public void messaged(MessageEvent messageEvent) {

    }
}
