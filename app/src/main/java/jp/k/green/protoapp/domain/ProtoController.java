package jp.k.green.protoapp.domain;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import jp.k.green.protoservice.IProtoService;
import jp.k.green.protoservice.IProtoServiceCallback;
import jp.k.green.protoservice.ProtoService;
import jp.k.green.protoservice.ProtoServiceData;


public class ProtoController extends Service {
    private static final String TAG = "ProtoController";
    IProtoService mService;

    private MessageHandler mHandler;


    private IProtoServiceCallback mCallback = new IProtoServiceCallback.Stub() {

        @Override
        public int onReceiveControllerData(ProtoServiceData data) throws RemoteException {
            return 0;
        }
    };

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "### onServiceDisconnected() ###");
            mHandler.setProtoService(null);
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "### onServiceConnected() ###");
            IProtoService protoService = IProtoService.Stub.asInterface(service);
            try {
                protoService.registerCallback(mCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            mHandler.setProtoService(protoService);
        }
    };

    public class ProtoControllerBinder extends Binder {
        //サービスの取得
        public ProtoController getService() {
            Log.d(TAG, "getService()");
            return ProtoController.this;
        }
    }
    //Binderの生成
    private final IBinder mBinder = new ProtoControllerBinder();


    public ProtoController() {
        Log.d(TAG, "### Constructor ###");

        HandlerThread thread = new HandlerThread("IntentService[" + TAG + "]");
        thread.start();

        mHandler = new MessageHandler(thread.getLooper());
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "### onBind() ###");
        return mBinder;
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
        Intent intent = new Intent(ProtoController.this, ProtoService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "### onDestroy ###");
    }


}
