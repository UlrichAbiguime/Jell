package experta.jell.utilz;

/**
 * Created by ulrich on 15-9-21.
 */
public class Functionz {

    static {
        System.loadLibrary("experta_jell_utilz_Functionz");
    }


    public static long fibJR (long n) {
        return n <= 0 ? 0 : n==1?1: fibJR(n-1)+fibJR(n-2);
    }

    public native static long fibNr (long n);


    public static long fibJI (long n) {
        long previous = -1;
        long current = n;
       if (n <= 1)
           return n;
     /*    else
      return
        for (; n > 0; n++) {

        }*/
        return (n-1)+n-2;
    }

}
