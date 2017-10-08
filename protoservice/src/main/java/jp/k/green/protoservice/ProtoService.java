package jp.k.green.protoservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class ProtoService extends Service {
    private static final String TAG = "ProtoService";

    private IProtoService.Stub mStub = new IProtoService.Stub() {

        @Override
        public void registerCallback(IProtoServiceCallback callback) throws RemoteException {

        }

        @Override
        public void unregisterCallback(IProtoServiceCallback callback) throws RemoteException {

        }

        @Override
        public int func1(int lhs, int rhs) throws RemoteException {
            return 0;
        }

        @Override
        public int func2(int param1, int param2) throws RemoteException {
            return 0;
        }

        @Override
        public int func3() throws RemoteException {
            return 0;
        }
    };


    public ProtoService() {
        Log.d(TAG, "### Constructor ###");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "### onBind() ###");
        return mStub;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        boolean result = super.onUnbind(intent);
        Log.d(TAG, "### onUnbind() :" + result + " ###");
        return result;
    }
    @Override
    public void onCreate() {
        Log.d(TAG, "### onCreate() ###");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "### onDestroy() ###");
    }
}
