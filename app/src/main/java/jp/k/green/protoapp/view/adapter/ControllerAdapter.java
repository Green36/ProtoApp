package jp.k.green.protoapp.view.adapter;


import android.os.RemoteException;

import jp.k.green.protoapp.domain.IProtoController;

public class ControllerAdapter {
    private ControllerAdapter mInstance;
    private IProtoController mController;

    private ControllerAdapter() {

    }

    public ControllerAdapter getInstance(IProtoController ctrl){
        mController = ctrl;
        return getInstance();
    }

    public ControllerAdapter getInstance(){
        if( mInstance == null){
            mInstance = new ControllerAdapter();
        }
        return mInstance;
    }

    public void func1(int param1, int param2) {
        try {
            mController.func1(param1, param2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void func2(int param1, int param2) {
        try {
            mController.func2(param1, param2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void func3() {
        try {
            mController.func3();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
