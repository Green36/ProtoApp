package jp.k.green.protoapp.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.k.green.protoapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProtoSecondFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProtoSecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProtoSecondFragment extends Fragment {
    private static final String TAG = "ProtoSecondFragment";
    private FragmentActivity mActivity = null;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch( v.getId()){
                case R.id.button3:
                    Log.d(TAG, "onClickListener button");
                    break;
                case R.id.button4:
                    Log.d(TAG, "onClickListener button2");
                    ProtoFirstFragment firstFragment = ProtoFirstFragment.newInstance(null, null);
                    mActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_frame, firstFragment)
                            .commit();
                    break;
            }
        }
    };

    public ProtoSecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProtoSecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProtoSecondFragment newInstance(String param1, String param2) {
        ProtoSecondFragment fragment = new ProtoSecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_proto_second, container, false);
        setOnClickListner(v);

        return v;
    }

    private void setOnClickListner(View v) {
        v.findViewById(R.id.button3).setOnClickListener(mClickListener);
        v.findViewById(R.id.button4).setOnClickListener(mClickListener);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (FragmentActivity)context;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
