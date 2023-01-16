package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: grasscutter.jar:com/google/protobuf/MessageLite.class */
public interface MessageLite extends MessageLiteOrBuilder {

    /* loaded from: grasscutter.jar:com/google/protobuf/MessageLite$Builder.class */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        @Override // com.google.protobuf.Message.Builder
        Builder clear();

        @Override // com.google.protobuf.Message.Builder
        MessageLite build();

        @Override // com.google.protobuf.Message.Builder
        MessageLite buildPartial();

        @Override // java.lang.Object, com.google.protobuf.Message.Builder
        Builder clone();

        @Override // com.google.protobuf.Message.Builder
        Builder mergeFrom(CodedInputStream codedInputStream) throws IOException;

        @Override // com.google.protobuf.Message.Builder
        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        @Override // com.google.protobuf.Message.Builder
        Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException;

        @Override // com.google.protobuf.Message.Builder
        Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        @Override // com.google.protobuf.Message.Builder
        Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException;

        @Override // com.google.protobuf.Message.Builder
        Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        @Override // com.google.protobuf.Message.Builder
        Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        @Override // com.google.protobuf.Message.Builder
        Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        @Override // com.google.protobuf.Message.Builder
        Builder mergeFrom(InputStream inputStream) throws IOException;

        @Override // com.google.protobuf.Message.Builder
        Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder mergeFrom(MessageLite messageLite);

        @Override // com.google.protobuf.Message.Builder
        boolean mergeDelimitedFrom(InputStream inputStream) throws IOException;

        @Override // com.google.protobuf.Message.Builder
        boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;
    }

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;

    int getSerializedSize();

    @Override // com.google.protobuf.Message
    Parser<? extends MessageLite> getParserForType();

    ByteString toByteString();

    byte[] toByteArray();

    void writeTo(OutputStream outputStream) throws IOException;

    void writeDelimitedTo(OutputStream outputStream) throws IOException;

    @Override // com.google.protobuf.Message
    Builder newBuilderForType();

    @Override // com.google.protobuf.Message
    Builder toBuilder();
}
