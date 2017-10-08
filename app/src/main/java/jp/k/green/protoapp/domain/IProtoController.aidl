// IProtoController.aidl
package jp.k.green.protoapp.domain;

import jp.k.green.protoapp.domain.IProtoControllerCallback;

interface IProtoController {
    /**
     * コールバック登録。
     * @param callback 登録するコールバック。
     */
    oneway void registerCallback(IProtoControllerCallback callback);

    /**
     * コールバック解除。
     * @param callback 解除するコールバック。
     */
    oneway void unregisterCallback(IProtoControllerCallback callback);

    int func1(int lhs, int rhs);

    int func2(int param1, int param2);

    int func3();
}
