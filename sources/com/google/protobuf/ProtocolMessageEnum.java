package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;

/* loaded from: grasscutter.jar:com/google/protobuf/ProtocolMessageEnum.class */
public interface ProtocolMessageEnum extends Internal.EnumLite {
    @Override // com.google.protobuf.Internal.EnumLite
    int getNumber();

    Descriptors.EnumValueDescriptor getValueDescriptor();

    Descriptors.EnumDescriptor getDescriptorForType();
}
