package CowKiller.task;

import CowKiller.CowKiller;
import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

public abstract class AbstractTask extends ClientAccessor {
    public AbstractTask(ClientContext ctx) {
        super(ctx);
    }

    public abstract boolean activate();

    public abstract void execute();
}
