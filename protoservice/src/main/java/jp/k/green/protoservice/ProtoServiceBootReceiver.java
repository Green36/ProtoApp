package jp.k.green.protoservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ProtoServiceBootReceiver extends BroadcastReceiver {
    private static final String TAG = "ServiceBootReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "### onReceive() ###");
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            // サービスの起動
            Intent service = new Intent(context, jp.k.green.protoservice.ProtoService.class);
            context.startService(service);
        }
    }
}
