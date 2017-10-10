package jp.k.green.protoapp.view.reactive;


import java.util.ArrayList;
import java.util.List;

import jp.k.green.protoapp.view.fragment.FragmentFactory.FragmentId;

public class ScreenTransitionObservable {
    static ScreenTransitionObservable mInstance;
    List<OnChangeScreenListener> mChangeScreenListeners;

    private ScreenTransitionObservable() {
        mChangeScreenListeners = new ArrayList<OnChangeScreenListener>();
    }

    public interface OnChangeScreenListener {
        void onChangeScreen(FragmentId id);
    }

    public static ScreenTransitionObservable getInstance() {
        if( mInstance == null) {
            mInstance = new ScreenTransitionObservable();
        }
        return mInstance;
    }

    public void register(OnChangeScreenListener observer) {
        //To avoid duplicated register
        if (!mChangeScreenListeners.contains(observer)) {
            mChangeScreenListeners.add(observer);
        }
    }

    public void unregister(OnChangeScreenListener observer) {
        mChangeScreenListeners.remove(observer);
    }

    public void notifyChangeScreen(FragmentId id) {
        for (OnChangeScreenListener changeScreenListener : mChangeScreenListeners) {
            changeScreenListener.onChangeScreen(id);
        }
    }

}
