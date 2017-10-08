package jp.k.green.protoservice;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ProtoServiceData implements Parcelable {
    List<String> mList;

    protected ProtoServiceData(Parcel in) {
        mList = in.createStringArrayList();
    }

    public static final Creator<ProtoServiceData> CREATOR = new Creator<ProtoServiceData>() {
        @Override
        public ProtoServiceData createFromParcel(Parcel in) {
            return new ProtoServiceData(in);
        }

        @Override
        public ProtoServiceData[] newArray(int size) {
            return new ProtoServiceData[size];
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
