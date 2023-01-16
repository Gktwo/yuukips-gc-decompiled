package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: grasscutter.jar:com/google/protobuf/Message.class */
public interface Message extends MessageLite, MessageOrBuilder {

    /* loaded from: grasscutter.jar:com/google/protobuf/Message$Builder.class */
    public interface Builder extends MessageLite.Builder, MessageOrBuilder {
        Builder clear();

        Builder mergeFrom(Message message);

        Message build();

        Message buildPartial();

        @Override // com.google.protobuf.Message.Builder
        Builder clone();

        Builder mergeFrom(CodedInputStream codedInputStream) throws IOException;

        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        @Override // com.google.protobuf.MessageOrBuilder
        Descriptors.Descriptor getDescriptorForType();

        Builder newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor);

        Builder getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor);

        Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i);

        Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        Builder clearField(Descriptors.FieldDescriptor fieldDescriptor);

        Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor);

        Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj);

        Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        Builder setUnknownFields(UnknownFieldSet unknownFieldSet);

        Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet);

        Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException;

        Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder mergeFrom(InputStream inputStream) throws IOException;

        Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        boolean mergeDelimitedFrom(InputStream inputStream) throws IOException;

        boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;
    }

    Parser<? extends Message> getParserForType();

    boolean equals(Object obj);

    int hashCode();

    String toString();

    Builder newBuilderForType();

    Builder toBuilder();
}
