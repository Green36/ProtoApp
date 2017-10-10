package jp.k.green.protoapp.view.fragment;

import android.support.v4.app.Fragment;
import android.util.Log;


public class FragmentFactory {
    private static final String TAG = "FragmentFactory";

    public enum FragmentId{
        ID_FIRST,
        ID_SECOND
    };

    public Fragment createFragment(FragmentId id)
    {
        Fragment fragment = null;
        switch(id){
            case ID_FIRST:
                fragment = FirstFragment.newInstance(null, null);
                break;
            case ID_SECOND:
                fragment = SecondFragment.newInstance(null, null);
                break;
            default:
                Log.e(TAG, "Invalid id = " + String.valueOf(id));
        }
        return fragment;
    }
}
