package experta.jell.commonLogs;

import android.util.Log;

import experta.jell.MyApplication;

/**
 * Created by ulrich on 15-9-14.
 */
public class L {

    public static void d (String log) {
        if (MyApplication.debug)
            Log.d(MyApplication.appname, log);
    }

    public static void v (String log) {
        if (MyApplication.debug)
            Log.v(MyApplication.appname, log);
    }

    public static void e (String log) {
        if (MyApplication.debug)
            Log.e(MyApplication.appname, log);
    }

}
