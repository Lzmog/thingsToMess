package CowKiller;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import java.awt.*;
import java.util.ArrayList;

@Script.Manifest(name="Cow Killer", description="Kills Cows and Banks Cowhides")

public class CowKiller extends PollingScript<ClientContext> implements PaintListener
{
    ArrayList<Task> task = new ArrayList<Task>();

    @Override
    public void start() {
        Fight fight = new Fight(ctx);
        Loot loot = new Loot(ctx);

        task.add(fight);
        task.add(loot);
    }

    @Override
    public void poll() {
        for (Task t: task) {
            if (t.activate()) {
                t.execute();
            }
        }
    }

    @Override
    public void repaint(Graphics graphics) {
        graphics.setColor(new Color(0,0,0,180));
        graphics.fillRect(0,0,300,100);

        graphics.setColor(new Color(255, 255, 255));
        graphics.drawRect(0,0,300,100);

        graphics.drawString("Marcius nupiso sitiek karviu", 20, 20);
    }
}
