package experta.jell.utilz;

import android.annotation.TargetApi;
import android.nfc.cardemulation.HostApduService;
import android.os.Build;
import android.os.Bundle;

/**
 * Created by ulrich on 15-9-19.
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class MyHostPduService extends HostApduService {
    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {

  /* called whenever a nfc reader sends a request to the tag.*/

        return new byte[0];
    }

    @Override
    public void onDeactivated(int reason) {

    }
}
