package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.FireWorkDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkReqOuterClass.class */
public final class FireWorkReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011FireWorkReq.proto\u001a\u0012FireWorkData.proto\"2\n\u000bFireWorkReq\u0012#\n\ffireWorkData\u0018\u0007 \u0001(\u000b2\r.FireWorkDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FireWorkDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FireWorkReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FireWorkReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FireWorkReq_descriptor, new String[]{"FireWorkData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkReqOuterClass$FireWorkReqOrBuilder.class */
    public interface FireWorkReqOrBuilder extends MessageOrBuilder {
        boolean hasFireWorkData();

        FireWorkDataOuterClass.FireWorkData getFireWorkData();

        FireWorkDataOuterClass.FireWorkDataOrBuilder getFireWorkDataOrBuilder();
    }

    private FireWorkReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkReqOuterClass$FireWorkReq.class */
    public static final class FireWorkReq extends GeneratedMessageV3 implements FireWorkReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FIREWORKDATA_FIELD_NUMBER = 7;
        private FireWorkDataOuterClass.FireWorkData fireWorkData_;
        private byte memoizedIsInitialized;
        private static final FireWorkReq DEFAULT_INSTANCE = new FireWorkReq();
        private static final Parser<FireWorkReq> PARSER = new AbstractParser<FireWorkReq>() { // from class: emu.grasscutter.net.proto.FireWorkReqOuterClass.FireWorkReq.1
            @Override // com.google.protobuf.Parser
            public FireWorkReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FireWorkReq(input, extensionRegistry);
            }
        };

        private FireWorkReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FireWorkReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FireWorkReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FireWorkReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 58:
                                FireWorkDataOuterClass.FireWorkData.Builder subBuilder = this.fireWorkData_ != null ? this.fireWorkData_.toBuilder() : null;
                                this.fireWorkData_ = (FireWorkDataOuterClass.FireWorkData) input.readMessage(FireWorkDataOuterClass.FireWorkData.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.fireWorkData_);
                                    this.fireWorkData_ = subBuilder.buildPartial();
                                    break;
                                }
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FireWorkReqOuterClass.internal_static_FireWorkReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FireWorkReqOuterClass.internal_static_FireWorkReq_fieldAccessorTable.ensureFieldAccessorsInitialized(FireWorkReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FireWorkReqOuterClass.FireWorkReqOrBuilder
        public boolean hasFireWorkData() {
            return this.fireWorkData_ != null;
        }

        @Override // emu.grasscutter.net.proto.FireWorkReqOuterClass.FireWorkReqOrBuilder
        public FireWorkDataOuterClass.FireWorkData getFireWorkData() {
            return this.fireWorkData_ == null ? FireWorkDataOuterClass.FireWorkData.getDefaultInstance() : this.fireWorkData_;
        }

        @Override // emu.grasscutter.net.proto.FireWorkReqOuterClass.FireWorkReqOrBuilder
        public FireWorkDataOuterClass.FireWorkDataOrBuilder getFireWorkDataOrBuilder() {
            return getFireWorkData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.fireWorkData_ != null) {
                output.writeMessage(7, getFireWorkData());
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.fireWorkData_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(7, getFireWorkData());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FireWorkReq)) {
                return equals(obj);
            }
            FireWorkReq other = (FireWorkReq) obj;
            if (hasFireWorkData() != other.hasFireWorkData()) {
                return false;
            }
            return (!hasFireWorkData() || getFireWorkData().equals(other.getFireWorkData())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasFireWorkData()) {
                hash = (53 * ((37 * hash) + 7)) + getFireWorkData().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FireWorkReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkReq parseFrom(InputStream input) throws IOException {
            return (FireWorkReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireWorkReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireWorkReq parseDelimitedFrom(InputStream input) throws IOException {
            return (FireWorkReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FireWorkReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireWorkReq parseFrom(CodedInputStream input) throws IOException {
            return (FireWorkReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireWorkReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FireWorkReq prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkReqOuterClass$FireWorkReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FireWorkReqOrBuilder {
            private FireWorkDataOuterClass.FireWorkData fireWorkData_;
            private SingleFieldBuilderV3<FireWorkDataOuterClass.FireWorkData, FireWorkDataOuterClass.FireWorkData.Builder, FireWorkDataOuterClass.FireWorkDataOrBuilder> fireWorkDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FireWorkReqOuterClass.internal_static_FireWorkReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FireWorkReqOuterClass.internal_static_FireWorkReq_fieldAccessorTable.ensureFieldAccessorsInitialized(FireWorkReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FireWorkReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.fireWorkDataBuilder_ == null) {
                    this.fireWorkData_ = null;
                } else {
                    this.fireWorkData_ = null;
                    this.fireWorkDataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FireWorkReqOuterClass.internal_static_FireWorkReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FireWorkReq getDefaultInstanceForType() {
                return FireWorkReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireWorkReq build() {
                FireWorkReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireWorkReq buildPartial() {
                FireWorkReq result = new FireWorkReq(this);
                if (this.fireWorkDataBuilder_ == null) {
                    result.fireWorkData_ = this.fireWorkData_;
                } else {
                    result.fireWorkData_ = this.fireWorkDataBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
            public Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof FireWorkReq) {
                    return mergeFrom((FireWorkReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FireWorkReq other) {
                if (other == FireWorkReq.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFireWorkData()) {
                    mergeFireWorkData(other.getFireWorkData());
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FireWorkReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = FireWorkReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FireWorkReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FireWorkReqOuterClass.FireWorkReqOrBuilder
            public boolean hasFireWorkData() {
                return (this.fireWorkDataBuilder_ == null && this.fireWorkData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.FireWorkReqOuterClass.FireWorkReqOrBuilder
            public FireWorkDataOuterClass.FireWorkData getFireWorkData() {
                if (this.fireWorkDataBuilder_ == null) {
                    return this.fireWorkData_ == null ? FireWorkDataOuterClass.FireWorkData.getDefaultInstance() : this.fireWorkData_;
                }
                return this.fireWorkDataBuilder_.getMessage();
            }

            public Builder setFireWorkData(FireWorkDataOuterClass.FireWorkData value) {
                if (this.fireWorkDataBuilder_ != null) {
                    this.fireWorkDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.fireWorkData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFireWorkData(FireWorkDataOuterClass.FireWorkData.Builder builderForValue) {
                if (this.fireWorkDataBuilder_ == null) {
                    this.fireWorkData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fireWorkDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFireWorkData(FireWorkDataOuterClass.FireWorkData value) {
                if (this.fireWorkDataBuilder_ == null) {
                    if (this.fireWorkData_ != null) {
                        this.fireWorkData_ = FireWorkDataOuterClass.FireWorkData.newBuilder(this.fireWorkData_).mergeFrom(value).buildPartial();
                    } else {
                        this.fireWorkData_ = value;
                    }
                    onChanged();
                } else {
                    this.fireWorkDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFireWorkData() {
                if (this.fireWorkDataBuilder_ == null) {
                    this.fireWorkData_ = null;
                    onChanged();
                } else {
                    this.fireWorkData_ = null;
                    this.fireWorkDataBuilder_ = null;
                }
                return this;
            }

            public FireWorkDataOuterClass.FireWorkData.Builder getFireWorkDataBuilder() {
                onChanged();
                return getFireWorkDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.FireWorkReqOuterClass.FireWorkReqOrBuilder
            public FireWorkDataOuterClass.FireWorkDataOrBuilder getFireWorkDataOrBuilder() {
                if (this.fireWorkDataBuilder_ != null) {
                    return this.fireWorkDataBuilder_.getMessageOrBuilder();
                }
                return this.fireWorkData_ == null ? FireWorkDataOuterClass.FireWorkData.getDefaultInstance() : this.fireWorkData_;
            }

            private SingleFieldBuilderV3<FireWorkDataOuterClass.FireWorkData, FireWorkDataOuterClass.FireWorkData.Builder, FireWorkDataOuterClass.FireWorkDataOrBuilder> getFireWorkDataFieldBuilder() {
                if (this.fireWorkDataBuilder_ == null) {
                    this.fireWorkDataBuilder_ = new SingleFieldBuilderV3<>(getFireWorkData(), getParentForChildren(), isClean());
                    this.fireWorkData_ = null;
                }
                return this.fireWorkDataBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static FireWorkReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FireWorkReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FireWorkReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FireWorkReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FireWorkDataOuterClass.getDescriptor();
    }
}
