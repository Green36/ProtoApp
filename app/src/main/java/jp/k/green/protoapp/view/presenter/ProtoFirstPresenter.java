package jp.k.green.protoapp.view.presenter;


import android.util.Log;
import android.view.View;

import jp.k.green.protoapp.R;
import jp.k.green.protoapp.view.fragment.ProtoFirstFragment;
import jp.k.green.protoapp.view.fragment.ProtoSecondFragment;

public class ProtoFirstPresenter implements ProtoPresenterBase{
    private static final String TAG = "ProtoFirstPresenter";
    private View mView;

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch( v.getId()){
                case R.id.button1:
                    Log.d(TAG, "onClickListener button1");
//                    ProtoSecondFragment secondFragment = ProtoSecondFragment.newInstance(null, null);
//                    getActivity().getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.fragment_frame, secondFragment)
//                            .commit();
                    break;
                case R.id.button2:
                    Log.d(TAG, "onClickListener button2");
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
