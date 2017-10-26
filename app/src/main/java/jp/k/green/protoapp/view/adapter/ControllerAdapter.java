package jp.k.green.protoapp.view.adapter;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import jp.k.green.protoapp.domain.ControllerMessage;
import jp.k.green.protoapp.domain.ProtoController;
import jp.k.green.protoservice.ProtoServiceData;

public class ControllerAdapter {
    static private final String TAG = "ControllerAdapter";
    static ControllerAdapter mInstance;
    static ProtoController mController;

    class ControllerListenerInfo {
        OnEventNotifier mListener;
    };
    private ControllerAdapter() {}
    private List<OnEventNotifier> mNotifierList = new ArrayList<>();

    public interface OnEventNotifier {
        int onNoticeFunc1();
        int onNoticeFunc2();
        int onNoticeFunc3();
    }
    public void setOnEventNotifier(OnEventNotifier notifier){
        Log.d(TAG, "setOnEventNotifier");
        mNotifierList.add(notifier);
    }

    public void unsetOnEventNotifier(OnEventNotifier notifier){
        Log.d(TAG, "unsetOnEventNotifier");
        mNotifierList.remove(notifier);
    }

    static public ControllerAdapter getInstance(ProtoController controller) {
        mController = controller;
        return getInstance();
    }

    static public ControllerAdapter getInstance() {
        if( mInstance == null) {
            mInstance = new ControllerAdapter();
        }
        return mInstance;
    }

    public void reqFunc1(int param1, int param2) {
        mController.sendMessage(ControllerMessage.MSG_VIEW_FUNC1, new ControllerMessage());
    }
    public void reqFunc2(int param1, int param2) {
        mController.sendMessage(ControllerMessage.MSG_VIEW_FUNC2, new ControllerMessage());
    }
    public void reqFunc3() {
        mController.sendMessage(ControllerMessage.MSG_VIEW_FUNC3, new ControllerMessage());
    }

    public interface OnReceiveNotify {
        int onReceiveControllerData(ProtoServiceData data);
    }

    public int onNoticeFunc1(){
        Log.d(TAG, "onNoticeFunc1");
        for( OnEventNotifier listner : mNotifierList ) {
            listner.onNoticeFunc1();
        }
        return 0;
    }
    public int onNoticeFunc2(){
        Log.d(TAG, "onNoticeFunc2");
        for( OnEventNotifier listner : mNotifierList ) {
            listner.onNoticeFunc2();
        }
        return 0;
    }
    public int onNoticeFunc3(){
        Log.d(TAG, "onNoticeFunc3");
        for( OnEventNotifier listner : mNotifierList ) {
            listner.onNoticeFunc3();
        }
        return 0;
    }
}
