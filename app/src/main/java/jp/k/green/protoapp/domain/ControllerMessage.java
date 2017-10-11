package jp.k.green.protoapp.domain;


public class ControllerMessage {
    public static final int MSG_VIEW_FUNC1 = 1;
    public static final int MSG_VIEW_FUNC2 = 2;
    public static final int MSG_VIEW_FUNC3 = 3;
    public static final int MSG_SERVICE_FUNC1 = 4;
    public static final int MSG_SERVICE_FUNC2 = 5;
    public static final int MSG_SERVICE_FUNC3 = 6;

    private Object mParam;
    public void setObject(Object param) {
        mParam = param;
    }
}
