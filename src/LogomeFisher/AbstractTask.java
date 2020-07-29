package LogomeFisher;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

public abstract class AbstractTask extends ClientAccessor {

    public AbstractTask(ClientContext ctx) {
        super(ctx);
    }

    public abstract boolean activate();

    public abstract int execute();

    public void normalSleep() {
        Condition.sleep(Random.nextGaussian(700, 2000, 95));
    }
}
