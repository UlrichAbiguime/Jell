package experta.jell;

import android.app.Application;
import android.os.SystemClock;
import android.test.ApplicationTestCase;

import experta.jell.commonLogs.L;
import experta.jell.utilz.Functionz;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testfibonacci () {
        long time1 = SystemClock.currentThreadTimeMillis();
        for (int i = 100; i >= 0; i--) {
            L.d(Functionz.fibJR(i)+"");
            if (i % 10 == 0)
                L.d("\n");
        }
        L.d("XXX java -- "+(SystemClock.currentThreadTimeMillis() - time1)+"\n");
        time1 = SystemClock.currentThreadTimeMillis();
        for (int i = 100; i >= 0; i--) {
            L.d(Functionz.fibNr(i)+"");
            if (i % 10 == 0)
                L.d("\n");
        }
        L.d("XXX java -- "+(SystemClock.currentThreadTimeMillis() - time1)+"\n");
    }

}