package jp.k.green.protoapp.domain;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import jp.k.green.protoapp.view.adapter.ControllerAdapter;
import jp.k.green.protoservice.IProtoService;

public class MessageHandler extends Handler {

    private static final String TAG = "MessageHandler";
    private IProtoService mService = null;

    public MessageHandler(Looper looper) {
        super(looper);
    }

    public void setProtoService(IProtoService service){
        mService = service;
    }

    @Override
    public void handleMessage(Message msg) {
        Log.d(TAG, "### handleMessage ### what = " + String.valueOf(msg.what));
        switch (msg.what) {
            case ControllerMessage.MSG_VIEW_FUNC1:
                try {
                    mService.func1(1,2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case ControllerMessage.MSG_VIEW_FUNC2:
                try {
                    mService.func2(1,2);
                    Log.d(TAG, "#########" + new JniWrapper().getStr());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case ControllerMessage.MSG_VIEW_FUNC3:
                try {
                    mService.func3();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case ControllerMessage.MSG_SERVICE_FUNC1:
                Log.d(TAG, "onNoticeFunc1");
                ControllerAdapter.getInstance().onNoticeFunc1();
                break;
            case ControllerMessage.MSG_SERVICE_FUNC2:
                Log.d(TAG, "onNoticeFunc2");
                ControllerAdapter.getInstance().onNoticeFunc2();
                break;
            case ControllerMessage.MSG_SERVICE_FUNC3:
                Log.d(TAG, "onNoticeFunc3");
                ControllerAdapter.getInstance().onNoticeFunc3();
                break;
        }
    }
}
