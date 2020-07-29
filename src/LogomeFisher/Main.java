package LogomeFisher;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import javax.swing.*;
import java.awt.*;

@Script.Manifest(name = "Logome Fisher", description = "Be a fisherman")

public class Main extends PollingScript<ClientContext> implements PaintListener {

    @Override
    public void start() {
        String[] userOptions = {"Draynor", "Barbarian"};
        String userChoice = ""+(String) JOptionPane.showInputDialog(
                null,
                "Location Picker",
                "Fish and Bank",
                JOptionPane.PLAIN_MESSAGE,
                null,
                userOptions,
                userOptions[0]
        );
    }

    @Override
    public void repaint(Graphics graphics) {

    }

    @Override
    public void poll() {

    }
}
