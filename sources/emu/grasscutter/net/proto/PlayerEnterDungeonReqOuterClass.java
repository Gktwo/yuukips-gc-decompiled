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
import emu.grasscutter.net.proto.DungeonEnterPosInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterDungeonReqOuterClass.class */
public final class PlayerEnterDungeonReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bPlayerEnterDungeonReq.proto\u001a\u0019DungeonEnterPosInfo.proto\"g\n\u0015PlayerEnterDungeonReq\u0012\u0011\n\tdungeonId\u0018\u0002 \u0001(\r\u0012\u000f\n\u0007pointId\u0018\t \u0001(\r\u0012*\n\fenterPosInfo\u0018\u0004 \u0001(\u000b2\u0014.DungeonEnterPosInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DungeonEnterPosInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerEnterDungeonReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerEnterDungeonReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerEnterDungeonReq_descriptor, new String[]{"DungeonId", "PointId", "EnterPosInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterDungeonReqOuterClass$PlayerEnterDungeonReqOrBuilder.class */
    public interface PlayerEnterDungeonReqOrBuilder extends MessageOrBuilder {
        int getDungeonId();

        int getPointId();

        boolean hasEnterPosInfo();

        DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo getEnterPosInfo();

        DungeonEnterPosInfoOuterClass.DungeonEnterPosInfoOrBuilder getEnterPosInfoOrBuilder();
    }

    private PlayerEnterDungeonReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterDungeonReqOuterClass$PlayerEnterDungeonReq.class */
    public static final class PlayerEnterDungeonReq extends GeneratedMessageV3 implements PlayerEnterDungeonReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DUNGEONID_FIELD_NUMBER = 2;
        private int dungeonId_;
        public static final int POINTID_FIELD_NUMBER = 9;
        private int pointId_;
        public static final int ENTERPOSINFO_FIELD_NUMBER = 4;
        private DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo enterPosInfo_;
        private byte memoizedIsInitialized;
        private static final PlayerEnterDungeonReq DEFAULT_INSTANCE = new PlayerEnterDungeonReq();
        private static final Parser<PlayerEnterDungeonReq> PARSER = new AbstractParser<PlayerEnterDungeonReq>() { // from class: emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReq.1
            @Override // com.google.protobuf.Parser
            public PlayerEnterDungeonReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerEnterDungeonReq(input, extensionRegistry);
            }
        };

        private PlayerEnterDungeonReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerEnterDungeonReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerEnterDungeonReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerEnterDungeonReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.dungeonId_ = input.readUInt32();
                                    break;
                                case 34:
                                    DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo.Builder subBuilder = this.enterPosInfo_ != null ? this.enterPosInfo_.toBuilder() : null;
                                    this.enterPosInfo_ = (DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo) input.readMessage(DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.enterPosInfo_);
                                        this.enterPosInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 72:
                                    this.pointId_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerEnterDungeonReqOuterClass.internal_static_PlayerEnterDungeonReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerEnterDungeonReqOuterClass.internal_static_PlayerEnterDungeonReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerEnterDungeonReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReqOrBuilder
        public int getDungeonId() {
            return this.dungeonId_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReqOrBuilder
        public int getPointId() {
            return this.pointId_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReqOrBuilder
        public boolean hasEnterPosInfo() {
            return this.enterPosInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReqOrBuilder
        public DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo getEnterPosInfo() {
            return this.enterPosInfo_ == null ? DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo.getDefaultInstance() : this.enterPosInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReqOrBuilder
        public DungeonEnterPosInfoOuterClass.DungeonEnterPosInfoOrBuilder getEnterPosInfoOrBuilder() {
            return getEnterPosInfo();
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
            if (this.dungeonId_ != 0) {
                output.writeUInt32(2, this.dungeonId_);
            }
            if (this.enterPosInfo_ != null) {
                output.writeMessage(4, getEnterPosInfo());
            }
            if (this.pointId_ != 0) {
                output.writeUInt32(9, this.pointId_);
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
            if (this.dungeonId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.dungeonId_);
            }
            if (this.enterPosInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getEnterPosInfo());
            }
            if (this.pointId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.pointId_);
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
            if (!(obj instanceof PlayerEnterDungeonReq)) {
                return equals(obj);
            }
            PlayerEnterDungeonReq other = (PlayerEnterDungeonReq) obj;
            if (getDungeonId() == other.getDungeonId() && getPointId() == other.getPointId() && hasEnterPosInfo() == other.hasEnterPosInfo()) {
                return (!hasEnterPosInfo() || getEnterPosInfo().equals(other.getEnterPosInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getDungeonId())) + 9)) + getPointId();
            if (hasEnterPosInfo()) {
                hash = (53 * ((37 * hash) + 4)) + getEnterPosInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerEnterDungeonReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerEnterDungeonReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerEnterDungeonReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerEnterDungeonReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerEnterDungeonReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerEnterDungeonReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerEnterDungeonReq parseFrom(InputStream input) throws IOException {
            return (PlayerEnterDungeonReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerEnterDungeonReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerEnterDungeonReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerEnterDungeonReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerEnterDungeonReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerEnterDungeonReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerEnterDungeonReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerEnterDungeonReq parseFrom(CodedInputStream input) throws IOException {
            return (PlayerEnterDungeonReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerEnterDungeonReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerEnterDungeonReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerEnterDungeonReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterDungeonReqOuterClass$PlayerEnterDungeonReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerEnterDungeonReqOrBuilder {
            private int dungeonId_;
            private int pointId_;
            private DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo enterPosInfo_;
            private SingleFieldBuilderV3<DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo, DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo.Builder, DungeonEnterPosInfoOuterClass.DungeonEnterPosInfoOrBuilder> enterPosInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerEnterDungeonReqOuterClass.internal_static_PlayerEnterDungeonReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerEnterDungeonReqOuterClass.internal_static_PlayerEnterDungeonReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerEnterDungeonReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerEnterDungeonReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dungeonId_ = 0;
                this.pointId_ = 0;
                if (this.enterPosInfoBuilder_ == null) {
                    this.enterPosInfo_ = null;
                } else {
                    this.enterPosInfo_ = null;
                    this.enterPosInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerEnterDungeonReqOuterClass.internal_static_PlayerEnterDungeonReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerEnterDungeonReq getDefaultInstanceForType() {
                return PlayerEnterDungeonReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerEnterDungeonReq build() {
                PlayerEnterDungeonReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerEnterDungeonReq buildPartial() {
                PlayerEnterDungeonReq result = new PlayerEnterDungeonReq(this);
                result.dungeonId_ = this.dungeonId_;
                result.pointId_ = this.pointId_;
                if (this.enterPosInfoBuilder_ == null) {
                    result.enterPosInfo_ = this.enterPosInfo_;
                } else {
                    result.enterPosInfo_ = this.enterPosInfoBuilder_.build();
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
                if (other instanceof PlayerEnterDungeonReq) {
                    return mergeFrom((PlayerEnterDungeonReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerEnterDungeonReq other) {
                if (other == PlayerEnterDungeonReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getDungeonId() != 0) {
                    setDungeonId(other.getDungeonId());
                }
                if (other.getPointId() != 0) {
                    setPointId(other.getPointId());
                }
                if (other.hasEnterPosInfo()) {
                    mergeEnterPosInfo(other.getEnterPosInfo());
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
                PlayerEnterDungeonReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerEnterDungeonReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerEnterDungeonReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReqOrBuilder
            public int getDungeonId() {
                return this.dungeonId_;
            }

            public Builder setDungeonId(int value) {
                this.dungeonId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonId() {
                this.dungeonId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReqOrBuilder
            public int getPointId() {
                return this.pointId_;
            }

            public Builder setPointId(int value) {
                this.pointId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPointId() {
                this.pointId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReqOrBuilder
            public boolean hasEnterPosInfo() {
                return (this.enterPosInfoBuilder_ == null && this.enterPosInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReqOrBuilder
            public DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo getEnterPosInfo() {
                if (this.enterPosInfoBuilder_ == null) {
                    return this.enterPosInfo_ == null ? DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo.getDefaultInstance() : this.enterPosInfo_;
                }
                return this.enterPosInfoBuilder_.getMessage();
            }

            public Builder setEnterPosInfo(DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo value) {
                if (this.enterPosInfoBuilder_ != null) {
                    this.enterPosInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.enterPosInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setEnterPosInfo(DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo.Builder builderForValue) {
                if (this.enterPosInfoBuilder_ == null) {
                    this.enterPosInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.enterPosInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeEnterPosInfo(DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo value) {
                if (this.enterPosInfoBuilder_ == null) {
                    if (this.enterPosInfo_ != null) {
                        this.enterPosInfo_ = DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo.newBuilder(this.enterPosInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.enterPosInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.enterPosInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearEnterPosInfo() {
                if (this.enterPosInfoBuilder_ == null) {
                    this.enterPosInfo_ = null;
                    onChanged();
                } else {
                    this.enterPosInfo_ = null;
                    this.enterPosInfoBuilder_ = null;
                }
                return this;
            }

            public DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo.Builder getEnterPosInfoBuilder() {
                onChanged();
                return getEnterPosInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReqOrBuilder
            public DungeonEnterPosInfoOuterClass.DungeonEnterPosInfoOrBuilder getEnterPosInfoOrBuilder() {
                if (this.enterPosInfoBuilder_ != null) {
                    return this.enterPosInfoBuilder_.getMessageOrBuilder();
                }
                return this.enterPosInfo_ == null ? DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo.getDefaultInstance() : this.enterPosInfo_;
            }

            private SingleFieldBuilderV3<DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo, DungeonEnterPosInfoOuterClass.DungeonEnterPosInfo.Builder, DungeonEnterPosInfoOuterClass.DungeonEnterPosInfoOrBuilder> getEnterPosInfoFieldBuilder() {
                if (this.enterPosInfoBuilder_ == null) {
                    this.enterPosInfoBuilder_ = new SingleFieldBuilderV3<>(getEnterPosInfo(), getParentForChildren(), isClean());
                    this.enterPosInfo_ = null;
                }
                return this.enterPosInfoBuilder_;
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

        public static PlayerEnterDungeonReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerEnterDungeonReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerEnterDungeonReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerEnterDungeonReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DungeonEnterPosInfoOuterClass.getDescriptor();
    }
}
