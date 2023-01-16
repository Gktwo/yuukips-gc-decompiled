package com.google.protobuf;

import com.google.protobuf.Descriptors;

/* loaded from: grasscutter.jar:com/google/protobuf/Service.class */
public interface Service {
    Descriptors.ServiceDescriptor getDescriptorForType();

    void callMethod(Descriptors.MethodDescriptor methodDescriptor, RpcController rpcController, Message message, RpcCallback<Message> rpcCallback);

    Message getRequestPrototype(Descriptors.MethodDescriptor methodDescriptor);

    Message getResponsePrototype(Descriptors.MethodDescriptor methodDescriptor);
}
