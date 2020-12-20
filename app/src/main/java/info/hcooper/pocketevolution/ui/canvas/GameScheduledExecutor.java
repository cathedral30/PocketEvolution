package info.hcooper.pocketevolution.ui.canvas;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class GameScheduledExecutor extends ScheduledThreadPoolExecutor {


    public GameScheduledExecutor(int corePoolSize) {
        super(corePoolSize);
    }
}
