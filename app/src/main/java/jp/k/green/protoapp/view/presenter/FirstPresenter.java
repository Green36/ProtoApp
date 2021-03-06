package jp.k.green.protoapp.view.presenter;


import android.os.Message;
import android.util.Log;
import android.view.View;

import jp.k.green.protoapp.R;
import jp.k.green.protoapp.domain.ControllerMessage;
import jp.k.green.protoapp.view.adapter.ControllerAdapter;
import jp.k.green.protoapp.view.fragment.FragmentFactory;
import jp.k.green.protoapp.view.reactive.ScreenTransitionObservable;
import jp.k.green.protoservice.ProtoServiceData;

public class FirstPresenter implements ProtoPresenterBase{
    private static final String TAG = "FirstPresenter";
    private View mView;
    private ControllerAdapter mController = ControllerAdapter.getInstance();


    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    Log.d(TAG, "onClickListener button1");
                    ScreenTransitionObservable.getInstance().notifyChangeScreen(FragmentFactory.FragmentId.ID_SECOND);
                    break;
                case R.id.button2:
                    Log.d(TAG, "onClickListener button2");
                    mController.reqFunc2(1, 2);

                    break;
            }
        }
    };

    private void setOnClickListner(View v) {
        v.findViewById(R.id.button1).setOnClickListener(mClickListener);
        v.findViewById(R.id.button2).setOnClickListener(mClickListener);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void onViewResume() {

    }

    @Override
    public void onViewPause() {

    }

    @Override
    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("You can't set a null view");
        }
        mView = view;
        setOnClickListner(mView);
    }

}
