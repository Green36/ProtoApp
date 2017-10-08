package jp.k.green.protoapp.domain;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ProtoControllerData implements Parcelable {
    List<String> mList;

    protected ProtoControllerData(Parcel in) {
        mList = in.createStringArrayList();
    }

    public static final Creator<ProtoControllerData> CREATOR = new Creator<ProtoControllerData>() {
        @Override
        public ProtoControllerData createFromParcel(Parcel in) {
            return new ProtoControllerData(in);
        }

        @Override
        public ProtoControllerData[] newArray(int size) {
            return new ProtoControllerData[size];
        }
    };

    List<String> getList(){ return mList; };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(mList);
    }
}
