package jp.k.green.protoapp.view.reactive;


import java.util.ArrayList;
import java.util.List;

public class ScreenTransitionObservable {

    List<OnChangeScreenListener> mChangeScreenListeners;

    public ScreenTransitionObservable() {
        mChangeScreenListeners = new ArrayList<OnChangeScreenListener>();
    }

    public interface OnChangeScreenListener {
        void onChangeScreen(int id);
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

    public void notifyObservers(int fragment_id) {
        for (OnChangeScreenListener changeScreenListener : mChangeScreenListeners) {
            changeScreenListener.onChangeScreen(fragment_id);
        }
    }

}
