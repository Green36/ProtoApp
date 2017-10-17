package jp.k.green.protoapp.domain;


import android.os.Bundle;
import android.widget.TextView;

public class JniWrapper{

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("jni_lib");
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public String getStr() {
        return stringFromJNI();
    }
}