package jp.k.green.protoapp.view.presenter;


import android.view.View;

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
