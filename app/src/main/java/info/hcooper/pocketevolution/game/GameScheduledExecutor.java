package info.hcooper.pocketevolution.game;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class GameScheduledExecutor extends ScheduledThreadPoolExecutor {

    public GameScheduledExecutor(int corePoolSize) {
        super(corePoolSize);
    }
}
