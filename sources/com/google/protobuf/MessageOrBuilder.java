package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:com/google/protobuf/MessageOrBuilder.class */
public interface MessageOrBuilder extends MessageLiteOrBuilder {
    Message getDefaultInstanceForType();

    List<String> findInitializationErrors();

    String getInitializationErrorString();

    Descriptors.Descriptor getDescriptorForType();

    Map<Descriptors.FieldDescriptor, Object> getAllFields();

    boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor);

    Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor);

    boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

    Object getField(Descriptors.FieldDescriptor fieldDescriptor);

    int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

    Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i);

    UnknownFieldSet getUnknownFields();
}
