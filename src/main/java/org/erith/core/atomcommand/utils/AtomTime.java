package org.erith.core.atomcommand.utils;

import java.util.Date;

/**
 * Created by user on 2/10/2017.
 */
public class AtomTime {
    private static long realtimeSinceStartup = 0;

    static {
        realtimeSinceStartup = new Date().getTime();
    }

    public static long getRealtimeSinceStartup() {
        return getCurrentTime() - realtimeSinceStartup;
    }

    public static long getCurrentTime() {
        return new Date().getTime();
    }
}
