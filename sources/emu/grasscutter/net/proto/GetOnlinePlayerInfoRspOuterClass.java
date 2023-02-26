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
import emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerInfoRspOuterClass.class */
public final class GetOnlinePlayerInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cGetOnlinePlayerInfoRsp.proto\u001a\u0016OnlinePlayerInfo.proto\"x\n\u0016GetOnlinePlayerInfoRsp\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005\u0012+\n\u0010targetPlayerInfo\u0018\u000b \u0001(\u000b2\u0011.OnlinePlayerInfo\u0012\u0011\n\ttargetUid\u0018\u0003 \u0001(\r\u0012\r\n\u0005param\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OnlinePlayerInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetOnlinePlayerInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetOnlinePlayerInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetOnlinePlayerInfoRsp_descriptor, new String[]{"Retcode", "TargetPlayerInfo", "TargetUid", "Param"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerInfoRspOuterClass$GetOnlinePlayerInfoRspOrBuilder.class */
    public interface GetOnlinePlayerInfoRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        boolean hasTargetPlayerInfo();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfo getTargetPlayerInfo();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getTargetPlayerInfoOrBuilder();

        int getTargetUid();

        int getParam();
    }

    private GetOnlinePlayerInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerInfoRspOuterClass$GetOnlinePlayerInfoRsp.class */
    public static final class GetOnlinePlayerInfoRsp extends GeneratedMessageV3 implements GetOnlinePlayerInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        public static final int TARGETPLAYERINFO_FIELD_NUMBER = 11;
        private OnlinePlayerInfoOuterClass.OnlinePlayerInfo targetPlayerInfo_;
        public static final int TARGETUID_FIELD_NUMBER = 3;
        private int targetUid_;
        public static final int PARAM_FIELD_NUMBER = 10;
        private int param_;
        private byte memoizedIsInitialized;
        private static final GetOnlinePlayerInfoRsp DEFAULT_INSTANCE = new GetOnlinePlayerInfoRsp();
        private static final Parser<GetOnlinePlayerInfoRsp> PARSER = new AbstractParser<GetOnlinePlayerInfoRsp>() { // from class: emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRsp.1
            @Override // com.google.protobuf.Parser
            public GetOnlinePlayerInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetOnlinePlayerInfoRsp(input, extensionRegistry);
            }
        };

        private GetOnlinePlayerInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetOnlinePlayerInfoRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetOnlinePlayerInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetOnlinePlayerInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.targetUid_ = input.readUInt32();
                                break;
                            case 80:
                                this.param_ = input.readUInt32();
                                break;
                            case 90:
                                OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder subBuilder = this.targetPlayerInfo_ != null ? this.targetPlayerInfo_.toBuilder() : null;
                                this.targetPlayerInfo_ = (OnlinePlayerInfoOuterClass.OnlinePlayerInfo) input.readMessage(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.targetPlayerInfo_);
                                    this.targetPlayerInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 112:
                                this.retcode_ = input.readInt32();
                                break;
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
            return GetOnlinePlayerInfoRspOuterClass.internal_static_GetOnlinePlayerInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetOnlinePlayerInfoRspOuterClass.internal_static_GetOnlinePlayerInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOnlinePlayerInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
        public boolean hasTargetPlayerInfo() {
            return this.targetPlayerInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getTargetPlayerInfo() {
            return this.targetPlayerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.targetPlayerInfo_;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getTargetPlayerInfoOrBuilder() {
            return getTargetPlayerInfo();
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
        public int getParam() {
            return this.param_;
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
            if (this.targetUid_ != 0) {
                output.writeUInt32(3, this.targetUid_);
            }
            if (this.param_ != 0) {
                output.writeUInt32(10, this.param_);
            }
            if (this.targetPlayerInfo_ != null) {
                output.writeMessage(11, getTargetPlayerInfo());
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
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
            if (this.targetUid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.targetUid_);
            }
            if (this.param_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.param_);
            }
            if (this.targetPlayerInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getTargetPlayerInfo());
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
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
            if (!(obj instanceof GetOnlinePlayerInfoRsp)) {
                return equals(obj);
            }
            GetOnlinePlayerInfoRsp other = (GetOnlinePlayerInfoRsp) obj;
            if (getRetcode() == other.getRetcode() && hasTargetPlayerInfo() == other.hasTargetPlayerInfo()) {
                return (!hasTargetPlayerInfo() || getTargetPlayerInfo().equals(other.getTargetPlayerInfo())) && getTargetUid() == other.getTargetUid() && getParam() == other.getParam() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getRetcode();
            if (hasTargetPlayerInfo()) {
                hash = (53 * ((37 * hash) + 11)) + getTargetPlayerInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + getTargetUid())) + 10)) + getParam())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetOnlinePlayerInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOnlinePlayerInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlinePlayerInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOnlinePlayerInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlinePlayerInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOnlinePlayerInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlinePlayerInfoRsp parseFrom(InputStream input) throws IOException {
            return (GetOnlinePlayerInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetOnlinePlayerInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlinePlayerInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetOnlinePlayerInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetOnlinePlayerInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetOnlinePlayerInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlinePlayerInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetOnlinePlayerInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetOnlinePlayerInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetOnlinePlayerInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlinePlayerInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetOnlinePlayerInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerInfoRspOuterClass$GetOnlinePlayerInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetOnlinePlayerInfoRspOrBuilder {
            private int retcode_;
            private OnlinePlayerInfoOuterClass.OnlinePlayerInfo targetPlayerInfo_;
            private SingleFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> targetPlayerInfoBuilder_;
            private int targetUid_;
            private int param_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetOnlinePlayerInfoRspOuterClass.internal_static_GetOnlinePlayerInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetOnlinePlayerInfoRspOuterClass.internal_static_GetOnlinePlayerInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOnlinePlayerInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetOnlinePlayerInfoRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.targetPlayerInfoBuilder_ == null) {
                    this.targetPlayerInfo_ = null;
                } else {
                    this.targetPlayerInfo_ = null;
                    this.targetPlayerInfoBuilder_ = null;
                }
                this.targetUid_ = 0;
                this.param_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetOnlinePlayerInfoRspOuterClass.internal_static_GetOnlinePlayerInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetOnlinePlayerInfoRsp getDefaultInstanceForType() {
                return GetOnlinePlayerInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetOnlinePlayerInfoRsp build() {
                GetOnlinePlayerInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetOnlinePlayerInfoRsp buildPartial() {
                GetOnlinePlayerInfoRsp result = new GetOnlinePlayerInfoRsp(this);
                result.retcode_ = this.retcode_;
                if (this.targetPlayerInfoBuilder_ == null) {
                    result.targetPlayerInfo_ = this.targetPlayerInfo_;
                } else {
                    result.targetPlayerInfo_ = this.targetPlayerInfoBuilder_.build();
                }
                result.targetUid_ = this.targetUid_;
                result.param_ = this.param_;
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
                if (other instanceof GetOnlinePlayerInfoRsp) {
                    return mergeFrom((GetOnlinePlayerInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetOnlinePlayerInfoRsp other) {
                if (other == GetOnlinePlayerInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.hasTargetPlayerInfo()) {
                    mergeTargetPlayerInfo(other.getTargetPlayerInfo());
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
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
                GetOnlinePlayerInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetOnlinePlayerInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetOnlinePlayerInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
            public boolean hasTargetPlayerInfo() {
                return (this.targetPlayerInfoBuilder_ == null && this.targetPlayerInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getTargetPlayerInfo() {
                if (this.targetPlayerInfoBuilder_ == null) {
                    return this.targetPlayerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.targetPlayerInfo_;
                }
                return this.targetPlayerInfoBuilder_.getMessage();
            }

            public Builder setTargetPlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.targetPlayerInfoBuilder_ != null) {
                    this.targetPlayerInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.targetPlayerInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setTargetPlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
                if (this.targetPlayerInfoBuilder_ == null) {
                    this.targetPlayerInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.targetPlayerInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeTargetPlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.targetPlayerInfoBuilder_ == null) {
                    if (this.targetPlayerInfo_ != null) {
                        this.targetPlayerInfo_ = OnlinePlayerInfoOuterClass.OnlinePlayerInfo.newBuilder(this.targetPlayerInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.targetPlayerInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.targetPlayerInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearTargetPlayerInfo() {
                if (this.targetPlayerInfoBuilder_ == null) {
                    this.targetPlayerInfo_ = null;
                    onChanged();
                } else {
                    this.targetPlayerInfo_ = null;
                    this.targetPlayerInfoBuilder_ = null;
                }
                return this;
            }

            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder getTargetPlayerInfoBuilder() {
                onChanged();
                return getTargetPlayerInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getTargetPlayerInfoOrBuilder() {
                if (this.targetPlayerInfoBuilder_ != null) {
                    return this.targetPlayerInfoBuilder_.getMessageOrBuilder();
                }
                return this.targetPlayerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.targetPlayerInfo_;
            }

            private SingleFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getTargetPlayerInfoFieldBuilder() {
                if (this.targetPlayerInfoBuilder_ == null) {
                    this.targetPlayerInfoBuilder_ = new SingleFieldBuilderV3<>(getTargetPlayerInfo(), getParentForChildren(), isClean());
                    this.targetPlayerInfo_ = null;
                }
                return this.targetPlayerInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoRspOuterClass.GetOnlinePlayerInfoRspOrBuilder
            public int getParam() {
                return this.param_;
            }

            public Builder setParam(int value) {
                this.param_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam() {
                this.param_ = 0;
                onChanged();
                return this;
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

        public static GetOnlinePlayerInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetOnlinePlayerInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetOnlinePlayerInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetOnlinePlayerInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        OnlinePlayerInfoOuterClass.getDescriptor();
    }
}
