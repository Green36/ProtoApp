package jp.k.green.protoapp.view.presenter;


import android.util.Log;
import android.view.View;

import jp.k.green.protoapp.R;
import jp.k.green.protoapp.view.adapter.ControllerAdapter;
import jp.k.green.protoapp.view.fragment.FragmentFactory;
import jp.k.green.protoapp.view.reactive.ScreenTransitionObservable;
import jp.k.green.protoservice.ProtoServiceData;

public class SecondPresenter implements  ProtoPresenterBase {
    private static final String TAG = "ProtoFirstPresenter";
    private View mView;
    private ControllerAdapter mController = ControllerAdapter.getInstance();

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch( v.getId()){
                case R.id.button3:
                    Log.d(TAG, "onClickListener button3");
                    ScreenTransitionObservable.getInstance().notifyChangeScreen(FragmentFactory.FragmentId.ID_FIRST);
                    break;
                case R.id.button4:
                    Log.d(TAG, "onClickListener button4");
                    mController.reqFunc2(3, 4);

                    break;
            }
        }
    };

    private void setOnClickListner(View v) {
        v.findViewById(R.id.button3).setOnClickListener(mClickListener);
        v.findViewById(R.id.button4).setOnClickListener(mClickListener);
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
