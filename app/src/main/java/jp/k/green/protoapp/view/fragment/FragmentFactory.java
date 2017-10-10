package jp.k.green.protoapp.view.fragment;

import android.support.v4.app.Fragment;


public class FragmentFactory {
    public enum FragmentId{
        ID_FIRST,
        ID_SECOND
    };

    public Fragment createFragment(FragmentId id)
    {
        Fragment fragment = null;
        switch(id){
            case ID_FIRST:
                fragment = new ProtoFirstFragment();
                break;
            case ID_SECOND:
                fragment = new ProtoSecondFragment();
                break;
        }
        return fragment;
    }
}
