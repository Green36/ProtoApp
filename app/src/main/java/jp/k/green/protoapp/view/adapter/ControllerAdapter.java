package jp.k.green.protoapp.view.adapter;


import jp.k.green.protoapp.domain.ControllerMessage;
import jp.k.green.protoapp.domain.ProtoController;
import jp.k.green.protoservice.ProtoServiceData;

public class ControllerAdapter {
    static ControllerAdapter mInstance;
    static ProtoController mController;

    private ControllerAdapter() {}

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


}
