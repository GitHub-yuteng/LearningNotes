package Review_Java.OOP.Logger;

import java.util.logging.Level;

/**
 * @Auther: YT
 * @Date: 2021/02/19/19:36
 * @Description: 抽象类更多的是为了代码复用，而接口就更侧重于解耦
 */
public abstract class Logger {

    private String name;
    private boolean enabled;
    private Level minPermittedLevel;

    public Logger(String name, boolean enabled, Level minPermittedLevel) {
        this.name = name;
        this.enabled = enabled;
        this.minPermittedLevel = minPermittedLevel;
    }

    public void log(Level level, String message) {
        boolean loggable = enabled && (minPermittedLevel.intValue() <= level.intValue());
        if (!loggable) {
            return;
        }
        doLog(level, message);
    }

    protected abstract void doLog(Level level, String message);
}
