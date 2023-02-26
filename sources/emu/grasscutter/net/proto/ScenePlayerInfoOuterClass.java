package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerInfoOuterClass.class */
public final class ScenePlayerInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015ScenePlayerInfo.proto\u001a\u0016OnlinePlayerInfo.proto\"\u0001\n\u000fScenePlayerInfo\u0012\f\n\u0004name\u0018\n \u0001(\t\u0012\u000b\n\u0003uid\u0018\r \u0001(\r\u0012\u000e\n\u0006peerId\u0018\u0005 \u0001(\r\u0012\u000f\n\u0007sceneId\u0018\u0004 \u0001(\r\u0012\u0013\n\u000bisConnected\u0018\u0007 \u0001(\b\u0012+\n\u0010onlinePlayerInfo\u0018\u0002 \u0001(\u000b2\u0011.OnlinePlayerInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OnlinePlayerInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ScenePlayerInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ScenePlayerInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ScenePlayerInfo_descriptor, new String[]{"Name", "Uid", "PeerId", "SceneId", "IsConnected", "OnlinePlayerInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerInfoOuterClass$ScenePlayerInfoOrBuilder.class */
    public interface ScenePlayerInfoOrBuilder extends MessageOrBuilder {
        String getName();

        ByteString getNameBytes();

        int getUid();

        int getPeerId();

        int getSceneId();

        boolean getIsConnected();

        boolean hasOnlinePlayerInfo();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfo getOnlinePlayerInfo();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getOnlinePlayerInfoOrBuilder();
    }

    private ScenePlayerInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerInfoOuterClass$ScenePlayerInfo.class */
    public static final class ScenePlayerInfo extends GeneratedMessageV3 implements ScenePlayerInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NAME_FIELD_NUMBER = 10;
        private volatile Object name_;
        public static final int UID_FIELD_NUMBER = 13;
        private int uid_;
        public static final int PEERID_FIELD_NUMBER = 5;
        private int peerId_;
        public static final int SCENEID_FIELD_NUMBER = 4;
        private int sceneId_;
        public static final int ISCONNECTED_FIELD_NUMBER = 7;
        private boolean isConnected_;
        public static final int ONLINEPLAYERINFO_FIELD_NUMBER = 2;
        private OnlinePlayerInfoOuterClass.OnlinePlayerInfo onlinePlayerInfo_;
        private byte memoizedIsInitialized;
        private static final ScenePlayerInfo DEFAULT_INSTANCE = new ScenePlayerInfo();
        private static final Parser<ScenePlayerInfo> PARSER = new AbstractParser<ScenePlayerInfo>() { // from class: emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfo.1
            @Override // com.google.protobuf.Parser
            public ScenePlayerInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ScenePlayerInfo(input, extensionRegistry);
            }
        };

        private ScenePlayerInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ScenePlayerInfo() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ScenePlayerInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ScenePlayerInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 18:
                                    OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder subBuilder = this.onlinePlayerInfo_ != null ? this.onlinePlayerInfo_.toBuilder() : null;
                                    this.onlinePlayerInfo_ = (OnlinePlayerInfoOuterClass.OnlinePlayerInfo) input.readMessage(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.onlinePlayerInfo_);
                                        this.onlinePlayerInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 32:
                                    this.sceneId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.peerId_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.isConnected_ = input.readBool();
                                    break;
                                case 82:
                                    this.name_ = input.readStringRequireUtf8();
                                    break;
                                case 104:
                                    this.uid_ = input.readUInt32();
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
                        }
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
            return ScenePlayerInfoOuterClass.internal_static_ScenePlayerInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ScenePlayerInfoOuterClass.internal_static_ScenePlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ScenePlayerInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.name_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
        public int getPeerId() {
            return this.peerId_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
        public boolean getIsConnected() {
            return this.isConnected_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
        public boolean hasOnlinePlayerInfo() {
            return this.onlinePlayerInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getOnlinePlayerInfo() {
            return this.onlinePlayerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.onlinePlayerInfo_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getOnlinePlayerInfoOrBuilder() {
            return getOnlinePlayerInfo();
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
            if (this.onlinePlayerInfo_ != null) {
                output.writeMessage(2, getOnlinePlayerInfo());
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(4, this.sceneId_);
            }
            if (this.peerId_ != 0) {
                output.writeUInt32(5, this.peerId_);
            }
            if (this.isConnected_) {
                output.writeBool(7, this.isConnected_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                GeneratedMessageV3.writeString(output, 10, this.name_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(13, this.uid_);
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
            if (this.onlinePlayerInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getOnlinePlayerInfo());
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.sceneId_);
            }
            if (this.peerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.peerId_);
            }
            if (this.isConnected_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isConnected_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                size2 += GeneratedMessageV3.computeStringSize(10, this.name_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.uid_);
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
            if (!(obj instanceof ScenePlayerInfo)) {
                return equals(obj);
            }
            ScenePlayerInfo other = (ScenePlayerInfo) obj;
            if (getName().equals(other.getName()) && getUid() == other.getUid() && getPeerId() == other.getPeerId() && getSceneId() == other.getSceneId() && getIsConnected() == other.getIsConnected() && hasOnlinePlayerInfo() == other.hasOnlinePlayerInfo()) {
                return (!hasOnlinePlayerInfo() || getOnlinePlayerInfo().equals(other.getOnlinePlayerInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getName().hashCode())) + 13)) + getUid())) + 5)) + getPeerId())) + 4)) + getSceneId())) + 7)) + Internal.hashBoolean(getIsConnected());
            if (hasOnlinePlayerInfo()) {
                hash = (53 * ((37 * hash) + 2)) + getOnlinePlayerInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ScenePlayerInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePlayerInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePlayerInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePlayerInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePlayerInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePlayerInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePlayerInfo parseFrom(InputStream input) throws IOException {
            return (ScenePlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ScenePlayerInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ScenePlayerInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ScenePlayerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ScenePlayerInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePlayerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ScenePlayerInfo parseFrom(CodedInputStream input) throws IOException {
            return (ScenePlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ScenePlayerInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ScenePlayerInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerInfoOuterClass$ScenePlayerInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ScenePlayerInfoOrBuilder {
            private Object name_ = "";
            private int uid_;
            private int peerId_;
            private int sceneId_;
            private boolean isConnected_;
            private OnlinePlayerInfoOuterClass.OnlinePlayerInfo onlinePlayerInfo_;
            private SingleFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> onlinePlayerInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ScenePlayerInfoOuterClass.internal_static_ScenePlayerInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ScenePlayerInfoOuterClass.internal_static_ScenePlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ScenePlayerInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ScenePlayerInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.name_ = "";
                this.uid_ = 0;
                this.peerId_ = 0;
                this.sceneId_ = 0;
                this.isConnected_ = false;
                if (this.onlinePlayerInfoBuilder_ == null) {
                    this.onlinePlayerInfo_ = null;
                } else {
                    this.onlinePlayerInfo_ = null;
                    this.onlinePlayerInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ScenePlayerInfoOuterClass.internal_static_ScenePlayerInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ScenePlayerInfo getDefaultInstanceForType() {
                return ScenePlayerInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ScenePlayerInfo build() {
                ScenePlayerInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ScenePlayerInfo buildPartial() {
                ScenePlayerInfo result = new ScenePlayerInfo(this);
                result.name_ = this.name_;
                result.uid_ = this.uid_;
                result.peerId_ = this.peerId_;
                result.sceneId_ = this.sceneId_;
                result.isConnected_ = this.isConnected_;
                if (this.onlinePlayerInfoBuilder_ == null) {
                    result.onlinePlayerInfo_ = this.onlinePlayerInfo_;
                } else {
                    result.onlinePlayerInfo_ = this.onlinePlayerInfoBuilder_.build();
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
                if (other instanceof ScenePlayerInfo) {
                    return mergeFrom((ScenePlayerInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ScenePlayerInfo other) {
                if (other == ScenePlayerInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.getName().isEmpty()) {
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (other.getPeerId() != 0) {
                    setPeerId(other.getPeerId());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.getIsConnected()) {
                    setIsConnected(other.getIsConnected());
                }
                if (other.hasOnlinePlayerInfo()) {
                    mergeOnlinePlayerInfo(other.getOnlinePlayerInfo());
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
                ScenePlayerInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ScenePlayerInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ScenePlayerInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
            public ByteString getNameBytes() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = ScenePlayerInfo.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ScenePlayerInfo.checkByteStringIsUtf8(value);
                this.name_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
            public int getPeerId() {
                return this.peerId_;
            }

            public Builder setPeerId(int value) {
                this.peerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPeerId() {
                this.peerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
            public boolean getIsConnected() {
                return this.isConnected_;
            }

            public Builder setIsConnected(boolean value) {
                this.isConnected_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsConnected() {
                this.isConnected_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
            public boolean hasOnlinePlayerInfo() {
                return (this.onlinePlayerInfoBuilder_ == null && this.onlinePlayerInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getOnlinePlayerInfo() {
                if (this.onlinePlayerInfoBuilder_ == null) {
                    return this.onlinePlayerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.onlinePlayerInfo_;
                }
                return this.onlinePlayerInfoBuilder_.getMessage();
            }

            public Builder setOnlinePlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.onlinePlayerInfoBuilder_ != null) {
                    this.onlinePlayerInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.onlinePlayerInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setOnlinePlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
                if (this.onlinePlayerInfoBuilder_ == null) {
                    this.onlinePlayerInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.onlinePlayerInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeOnlinePlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.onlinePlayerInfoBuilder_ == null) {
                    if (this.onlinePlayerInfo_ != null) {
                        this.onlinePlayerInfo_ = OnlinePlayerInfoOuterClass.OnlinePlayerInfo.newBuilder(this.onlinePlayerInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.onlinePlayerInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.onlinePlayerInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearOnlinePlayerInfo() {
                if (this.onlinePlayerInfoBuilder_ == null) {
                    this.onlinePlayerInfo_ = null;
                    onChanged();
                } else {
                    this.onlinePlayerInfo_ = null;
                    this.onlinePlayerInfoBuilder_ = null;
                }
                return this;
            }

            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder getOnlinePlayerInfoBuilder() {
                onChanged();
                return getOnlinePlayerInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getOnlinePlayerInfoOrBuilder() {
                if (this.onlinePlayerInfoBuilder_ != null) {
                    return this.onlinePlayerInfoBuilder_.getMessageOrBuilder();
                }
                return this.onlinePlayerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.onlinePlayerInfo_;
            }

            private SingleFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getOnlinePlayerInfoFieldBuilder() {
                if (this.onlinePlayerInfoBuilder_ == null) {
                    this.onlinePlayerInfoBuilder_ = new SingleFieldBuilderV3<>(getOnlinePlayerInfo(), getParentForChildren(), isClean());
                    this.onlinePlayerInfo_ = null;
                }
                return this.onlinePlayerInfoBuilder_;
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

        public static ScenePlayerInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ScenePlayerInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ScenePlayerInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ScenePlayerInfo getDefaultInstanceForType() {
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
