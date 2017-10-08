// IProtoService.aidl
package jp.k.green.protoservice;

import jp.k.green.protoservice.IProtoServiceCallback;

interface IProtoService {
    /**
     * コールバック登録。
     * @param callback 登録するコールバック。
     */
    oneway void registerCallback(IProtoServiceCallback callback);

    /**
     * コールバック解除。
     * @param callback 解除するコールバック。
     */
    oneway void unregisterCallback(IProtoServiceCallback callback);

    int func1(int lhs, int rhs);

    int func2(int param1, int param2);

    int func3();
}
