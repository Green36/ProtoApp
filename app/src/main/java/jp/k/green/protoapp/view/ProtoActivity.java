package jp.k.green.protoapp.view;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import jp.k.green.protoapp.R;
import jp.k.green.protoapp.domain.IProtoController;
import jp.k.green.protoapp.domain.IProtoControllerCallback;
import jp.k.green.protoapp.domain.ProtoController;
import jp.k.green.protoapp.domain.ProtoControllerData;
import jp.k.green.protoapp.view.fragment.ProtoFirstFragment;
import jp.k.green.protoapp.view.fragment.ProtoSecondFragment;
import jp.k.green.protoapp.view.reactive.ScreenTransitionObservable;

public class ProtoActivity
        extends FragmentActivity
        implements ProtoFirstFragment.OnFragmentInteractionListener,
        ProtoSecondFragment.OnFragmentInteractionListener{
    private static final String TAG = "ProtoActivity";
    IProtoController mController;

    ScreenTransitionObservable mScreenTransitionObservable = new ScreenTransitionObservable();
    ScreenTransitionObservable.OnChangeScreenListener mChangeScreenListener = new ScreenTransitionObservable.OnChangeScreenListener() {
        @Override
        public void onChangeScreen(int id) {

        }
    };

    private IProtoControllerCallback mCallback = new IProtoControllerCallback.Stub() {

        @Override
        public int onReceiveControllerData(ProtoControllerData data) throws RemoteException {
            return 0;
        }
    };

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "### onServiceDisconnected ###");
            mController = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "### onServiceConnected ###");
            mController = IProtoController.Stub.asInterface(service);
            try {
                mController.registerCallback(mCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "### onCreate ###");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proto);

        ProtoFirstFragment firstFragment = ProtoFirstFragment.newInstance(null, null);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_frame, firstFragment)
                .commit();

        Intent intent = new Intent(ProtoActivity.this, ProtoController.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);

    }

    @Override
    protected  void onResume() {
        super.onResume();
        mScreenTransitionObservable.register(mChangeScreenListener);
    }

    @Override
    protected  void onPause() {
        super.onPause();
        mScreenTransitionObservable.unregister(mChangeScreenListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
