package jp.k.green.protoapp.view.presenter;


import android.util.Log;
import android.view.View;

import jp.k.green.protoapp.R;
import jp.k.green.protoapp.view.fragment.FragmentFactory;
import jp.k.green.protoapp.view.reactive.ScreenTransitionObservable;

/**
 * PresenterのBASEクラス。
 * 各Fragment共通のIFを定義
 */
public interface ProtoPresenterBase {
    void initialize();

    void onViewResume();

    void onViewPause();

    void setView(View v);
}
