package jp.k.green.protoapp.view.adapter;


import android.os.RemoteException;
import android.util.Log;

import jp.k.green.protoapp.domain.IProtoController;

public class ControllerAdapter {
    private static final String TAG = "ControllerAdapter";
    private static ControllerAdapter mInstance;
    private IProtoController mController;

    private ControllerAdapter() {

    }

    public void SetController(IProtoController ctrl){
        Log.d(TAG, "mController set.");
        mController = ctrl;
    }

    public static ControllerAdapter getInstance(){
        if( mInstance == null){
            mInstance = new ControllerAdapter();
        }
        return mInstance;
    }

    public void func1(int param1, int param2) {
        Log.d(TAG, "func1(" + String.valueOf(param1) + ", " + String.valueOf(param2) + " )");
        try {
            mController.func1(param1, param2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void func2(int param1, int param2) {
        Log.d(TAG, "func2(" + String.valueOf(param1) + ", " + String.valueOf(param2) + " )");
        try {
            mController.func2(param1, param2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void func3() {
        Log.d(TAG, "func3()");
        try {
            mController.func3();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
