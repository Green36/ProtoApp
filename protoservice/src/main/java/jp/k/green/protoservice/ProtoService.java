package jp.k.green.protoservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

public class ProtoService extends Service {
    private static final String TAG = "ProtoService";
    private RemoteCallbackList<IProtoServiceCallback> mCallbacks = new RemoteCallbackList<IProtoServiceCallback>();

    private IProtoService.Stub mStub = new IProtoService.Stub() {

        @Override
        public void registerCallback(IProtoServiceCallback callback) throws RemoteException {
            Log.d(TAG, "registerCallback()");
            mCallbacks.register(callback);
        }

        @Override
        public void unregisterCallback(IProtoServiceCallback callback) throws RemoteException {
            Log.d(TAG, "unregisterCallback()");
            mCallbacks.unregister(callback);
        }

        @Override
        public int func1(int param1, int param2) throws RemoteException {
            Log.d(TAG, "func2( " + String.valueOf(param1) + ", " + String.valueOf(param2) + ")");
            notifyControllerData();
            return 0;
        }

        @Override
        public int func2(int param1, int param2) throws RemoteException {
            Log.d(TAG, "func2( " + String.valueOf(param1) + ", " + String.valueOf(param2) + ")");
            notifyControllerData();
            return 0;
        }

        @Override
        public int func3() throws RemoteException {
            Log.d(TAG, "func3()");
            notifyControllerData();
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

    public void notifyControllerData(){
        int observerNum = mCallbacks.beginBroadcast();
        Parcel p = Parcel.obtain();
        ProtoServiceData data = new ProtoServiceData(p);
        for(int i = 0; i < observerNum; i++){
            try {
                //RemoteCallbackList#getBroadcastItem()でCallback interfaceを取り出し
                //Callback methodを呼び出す
                mCallbacks.getBroadcastItem(i).onReceiveControllerData(data);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        //RemoteCallbackList#finishBroadcast()でbroadcast stateをclear
        mCallbacks.finishBroadcast();
    }
}
