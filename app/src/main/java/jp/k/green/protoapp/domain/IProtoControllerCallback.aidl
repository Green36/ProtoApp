// IProtoControllerCallback.aidl
package jp.k.green.protoapp.domain;

import jp.k.green.protoapp.domain.ProtoControllerData;

interface IProtoControllerCallback {
    int onReceiveControllerData(in ProtoControllerData data);
}
