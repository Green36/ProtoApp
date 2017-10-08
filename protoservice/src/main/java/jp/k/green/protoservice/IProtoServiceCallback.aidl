// IProtoServiceCallback.aidl
package jp.k.green.protoservice;

import jp.k.green.protoservice.ProtoServiceData;

interface IProtoServiceCallback {
    int onReceiveControllerData(in ProtoServiceData data);
}
