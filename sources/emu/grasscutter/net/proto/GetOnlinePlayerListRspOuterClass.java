package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerListRspOuterClass.class */
public final class GetOnlinePlayerListRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cGetOnlinePlayerListRsp.proto\u001a\u0016OnlinePlayerInfo.proto\"c\n\u0016GetOnlinePlayerListRsp\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005\u0012\r\n\u0005param\u0018\u000e \u0001(\r\u0012)\n\u000eplayerInfoList\u0018\t \u0003(\u000b2\u0011.OnlinePlayerInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OnlinePlayerInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetOnlinePlayerListRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetOnlinePlayerListRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetOnlinePlayerListRsp_descriptor, new String[]{"Retcode", "Param", "PlayerInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerListRspOuterClass$GetOnlinePlayerListRspOrBuilder.class */
    public interface GetOnlinePlayerListRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getParam();

        List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo> getPlayerInfoListList();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfoList(int i);

        int getPlayerInfoListCount();

        List<? extends OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getPlayerInfoListOrBuilderList();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoListOrBuilder(int i);
    }

    private GetOnlinePlayerListRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerListRspOuterClass$GetOnlinePlayerListRsp.class */
    public static final class GetOnlinePlayerListRsp extends GeneratedMessageV3 implements GetOnlinePlayerListRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        public static final int PARAM_FIELD_NUMBER = 14;
        private int param_;
        public static final int PLAYERINFOLIST_FIELD_NUMBER = 9;
        private List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo> playerInfoList_;
        private byte memoizedIsInitialized;
        private static final GetOnlinePlayerListRsp DEFAULT_INSTANCE = new GetOnlinePlayerListRsp();
        private static final Parser<GetOnlinePlayerListRsp> PARSER = new AbstractParser<GetOnlinePlayerListRsp>() { // from class: emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRsp.1
            @Override // com.google.protobuf.Parser
            public GetOnlinePlayerListRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetOnlinePlayerListRsp(input, extensionRegistry);
            }
        };

        private GetOnlinePlayerListRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetOnlinePlayerListRsp() {
            this.memoizedIsInitialized = -1;
            this.playerInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetOnlinePlayerListRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetOnlinePlayerListRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 40:
                                this.retcode_ = input.readInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.playerInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.playerInfoList_.add((OnlinePlayerInfoOuterClass.OnlinePlayerInfo) input.readMessage(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.parser(), extensionRegistry));
                                break;
                            case 112:
                                this.param_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.playerInfoList_ = Collections.unmodifiableList(this.playerInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetOnlinePlayerListRspOuterClass.internal_static_GetOnlinePlayerListRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetOnlinePlayerListRspOuterClass.internal_static_GetOnlinePlayerListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOnlinePlayerListRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
        public int getParam() {
            return this.param_;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
        public List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo> getPlayerInfoListList() {
            return this.playerInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
        public List<? extends OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getPlayerInfoListOrBuilderList() {
            return this.playerInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
        public int getPlayerInfoListCount() {
            return this.playerInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfoList(int index) {
            return this.playerInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoListOrBuilder(int index) {
            return this.playerInfoList_.get(index);
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
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            for (int i = 0; i < this.playerInfoList_.size(); i++) {
                output.writeMessage(9, this.playerInfoList_.get(i));
            }
            if (this.param_ != 0) {
                output.writeUInt32(14, this.param_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            for (int i = 0; i < this.playerInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.playerInfoList_.get(i));
            }
            if (this.param_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.param_);
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
            if (!(obj instanceof GetOnlinePlayerListRsp)) {
                return equals(obj);
            }
            GetOnlinePlayerListRsp other = (GetOnlinePlayerListRsp) obj;
            return getRetcode() == other.getRetcode() && getParam() == other.getParam() && getPlayerInfoListList().equals(other.getPlayerInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getRetcode())) + 14)) + getParam();
            if (getPlayerInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getPlayerInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetOnlinePlayerListRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOnlinePlayerListRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlinePlayerListRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOnlinePlayerListRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlinePlayerListRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOnlinePlayerListRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlinePlayerListRsp parseFrom(InputStream input) throws IOException {
            return (GetOnlinePlayerListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetOnlinePlayerListRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlinePlayerListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetOnlinePlayerListRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetOnlinePlayerListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetOnlinePlayerListRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlinePlayerListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetOnlinePlayerListRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetOnlinePlayerListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetOnlinePlayerListRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlinePlayerListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetOnlinePlayerListRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerListRspOuterClass$GetOnlinePlayerListRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetOnlinePlayerListRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private int param_;
            private List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo> playerInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> playerInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetOnlinePlayerListRspOuterClass.internal_static_GetOnlinePlayerListRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetOnlinePlayerListRspOuterClass.internal_static_GetOnlinePlayerListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOnlinePlayerListRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetOnlinePlayerListRsp.alwaysUseFieldBuilders) {
                    getPlayerInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.param_ = 0;
                if (this.playerInfoListBuilder_ == null) {
                    this.playerInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.playerInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetOnlinePlayerListRspOuterClass.internal_static_GetOnlinePlayerListRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetOnlinePlayerListRsp getDefaultInstanceForType() {
                return GetOnlinePlayerListRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetOnlinePlayerListRsp build() {
                GetOnlinePlayerListRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetOnlinePlayerListRsp buildPartial() {
                GetOnlinePlayerListRsp result = new GetOnlinePlayerListRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                result.param_ = this.param_;
                if (this.playerInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.playerInfoList_ = Collections.unmodifiableList(this.playerInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.playerInfoList_ = this.playerInfoList_;
                } else {
                    result.playerInfoList_ = this.playerInfoListBuilder_.build();
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
                if (other instanceof GetOnlinePlayerListRsp) {
                    return mergeFrom((GetOnlinePlayerListRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetOnlinePlayerListRsp other) {
                if (other == GetOnlinePlayerListRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
                }
                if (this.playerInfoListBuilder_ == null) {
                    if (!other.playerInfoList_.isEmpty()) {
                        if (this.playerInfoList_.isEmpty()) {
                            this.playerInfoList_ = other.playerInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePlayerInfoListIsMutable();
                            this.playerInfoList_.addAll(other.playerInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.playerInfoList_.isEmpty()) {
                    if (this.playerInfoListBuilder_.isEmpty()) {
                        this.playerInfoListBuilder_.dispose();
                        this.playerInfoListBuilder_ = null;
                        this.playerInfoList_ = other.playerInfoList_;
                        this.bitField0_ &= -2;
                        this.playerInfoListBuilder_ = GetOnlinePlayerListRsp.alwaysUseFieldBuilders ? getPlayerInfoListFieldBuilder() : null;
                    } else {
                        this.playerInfoListBuilder_.addAllMessages(other.playerInfoList_);
                    }
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
                GetOnlinePlayerListRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetOnlinePlayerListRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetOnlinePlayerListRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
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

            private void ensurePlayerInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.playerInfoList_ = new ArrayList(this.playerInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
            public List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo> getPlayerInfoListList() {
                if (this.playerInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.playerInfoList_);
                }
                return this.playerInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
            public int getPlayerInfoListCount() {
                if (this.playerInfoListBuilder_ == null) {
                    return this.playerInfoList_.size();
                }
                return this.playerInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfoList(int index) {
                if (this.playerInfoListBuilder_ == null) {
                    return this.playerInfoList_.get(index);
                }
                return this.playerInfoListBuilder_.getMessage(index);
            }

            public Builder setPlayerInfoList(int index, OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.playerInfoListBuilder_ != null) {
                    this.playerInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerInfoList(int index, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerInfoList(OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.playerInfoListBuilder_ != null) {
                    this.playerInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerInfoList(int index, OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.playerInfoListBuilder_ != null) {
                    this.playerInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerInfoList(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerInfoList(int index, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPlayerInfoList(Iterable<? extends OnlinePlayerInfoOuterClass.OnlinePlayerInfo> values) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.playerInfoList_);
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPlayerInfoList() {
                if (this.playerInfoListBuilder_ == null) {
                    this.playerInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removePlayerInfoList(int index) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.remove(index);
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.remove(index);
                }
                return this;
            }

            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder getPlayerInfoListBuilder(int index) {
                return getPlayerInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoListOrBuilder(int index) {
                if (this.playerInfoListBuilder_ == null) {
                    return this.playerInfoList_.get(index);
                }
                return this.playerInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRspOrBuilder
            public List<? extends OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getPlayerInfoListOrBuilderList() {
                if (this.playerInfoListBuilder_ != null) {
                    return this.playerInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.playerInfoList_);
            }

            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder addPlayerInfoListBuilder() {
                return getPlayerInfoListFieldBuilder().addBuilder(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance());
            }

            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder addPlayerInfoListBuilder(int index) {
                return getPlayerInfoListFieldBuilder().addBuilder(index, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance());
            }

            public List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder> getPlayerInfoListBuilderList() {
                return getPlayerInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getPlayerInfoListFieldBuilder() {
                if (this.playerInfoListBuilder_ == null) {
                    this.playerInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.playerInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.playerInfoList_ = null;
                }
                return this.playerInfoListBuilder_;
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

        public static GetOnlinePlayerListRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetOnlinePlayerListRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetOnlinePlayerListRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetOnlinePlayerListRsp getDefaultInstanceForType() {
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
