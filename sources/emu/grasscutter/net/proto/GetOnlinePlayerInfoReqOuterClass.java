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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerInfoReqOuterClass.class */
public final class GetOnlinePlayerInfoReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cGetOnlinePlayerInfoReq.proto\"v\n\u0016GetOnlinePlayerInfoReq\u0012\u0012\n\nisOnlineId\u0018\u0003 \u0001(\b\u0012\u0014\n\ntarget_uid\u0018\u0004 \u0001(\rH��\u0012\u0013\n\tonline_id\u0018\n \u0001(\tH��\u0012\u0010\n\u0006psn_id\u0018\f \u0001(\tH��B\u000b\n\tplayer_idB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetOnlinePlayerInfoReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetOnlinePlayerInfoReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetOnlinePlayerInfoReq_descriptor, new String[]{"IsOnlineId", "TargetUid", "OnlineId", "PsnId", "PlayerId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerInfoReqOuterClass$GetOnlinePlayerInfoReqOrBuilder.class */
    public interface GetOnlinePlayerInfoReqOrBuilder extends MessageOrBuilder {
        boolean getIsOnlineId();

        boolean hasTargetUid();

        int getTargetUid();

        boolean hasOnlineId();

        String getOnlineId();

        ByteString getOnlineIdBytes();

        boolean hasPsnId();

        String getPsnId();

        ByteString getPsnIdBytes();

        GetOnlinePlayerInfoReq.PlayerIdCase getPlayerIdCase();
    }

    private GetOnlinePlayerInfoReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerInfoReqOuterClass$GetOnlinePlayerInfoReq.class */
    public static final class GetOnlinePlayerInfoReq extends GeneratedMessageV3 implements GetOnlinePlayerInfoReqOrBuilder {
        private static final long serialVersionUID = 0;
        private int playerIdCase_;
        private Object playerId_;
        public static final int ISONLINEID_FIELD_NUMBER = 3;
        private boolean isOnlineId_;
        public static final int TARGET_UID_FIELD_NUMBER = 4;
        public static final int ONLINE_ID_FIELD_NUMBER = 10;
        public static final int PSN_ID_FIELD_NUMBER = 12;
        private byte memoizedIsInitialized;
        private static final GetOnlinePlayerInfoReq DEFAULT_INSTANCE = new GetOnlinePlayerInfoReq();
        private static final Parser<GetOnlinePlayerInfoReq> PARSER = new AbstractParser<GetOnlinePlayerInfoReq>() { // from class: emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReq.1
            @Override // com.google.protobuf.Parser
            public GetOnlinePlayerInfoReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetOnlinePlayerInfoReq(input, extensionRegistry);
            }
        };

        private GetOnlinePlayerInfoReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.playerIdCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private GetOnlinePlayerInfoReq() {
            this.playerIdCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetOnlinePlayerInfoReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetOnlinePlayerInfoReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.isOnlineId_ = input.readBool();
                                    break;
                                case 32:
                                    this.playerIdCase_ = 4;
                                    this.playerId_ = Integer.valueOf(input.readUInt32());
                                    break;
                                case 82:
                                    String s = input.readStringRequireUtf8();
                                    this.playerIdCase_ = 10;
                                    this.playerId_ = s;
                                    break;
                                case 98:
                                    String s2 = input.readStringRequireUtf8();
                                    this.playerIdCase_ = 12;
                                    this.playerId_ = s2;
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
            return GetOnlinePlayerInfoReqOuterClass.internal_static_GetOnlinePlayerInfoReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetOnlinePlayerInfoReqOuterClass.internal_static_GetOnlinePlayerInfoReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOnlinePlayerInfoReq.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerInfoReqOuterClass$GetOnlinePlayerInfoReq$PlayerIdCase.class */
        public enum PlayerIdCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            TARGET_UID(4),
            ONLINE_ID(10),
            PSN_ID(12),
            PLAYERID_NOT_SET(0);
            
            private final int value;

            PlayerIdCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static PlayerIdCase valueOf(int value) {
                return forNumber(value);
            }

            public static PlayerIdCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return PLAYERID_NOT_SET;
                    case 4:
                        return TARGET_UID;
                    case 10:
                        return ONLINE_ID;
                    case 12:
                        return PSN_ID;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
        public PlayerIdCase getPlayerIdCase() {
            return PlayerIdCase.forNumber(this.playerIdCase_);
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
        public boolean getIsOnlineId() {
            return this.isOnlineId_;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
        public boolean hasTargetUid() {
            return this.playerIdCase_ == 4;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
        public int getTargetUid() {
            if (this.playerIdCase_ == 4) {
                return ((Integer) this.playerId_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
        public boolean hasOnlineId() {
            return this.playerIdCase_ == 10;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
        public String getOnlineId() {
            Object ref = "";
            if (this.playerIdCase_ == 10) {
                ref = this.playerId_;
            }
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            if (this.playerIdCase_ == 10) {
                this.playerId_ = s;
            }
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
        public ByteString getOnlineIdBytes() {
            Object ref = "";
            if (this.playerIdCase_ == 10) {
                ref = this.playerId_;
            }
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            if (this.playerIdCase_ == 10) {
                this.playerId_ = b;
            }
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
        public boolean hasPsnId() {
            return this.playerIdCase_ == 12;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
        public String getPsnId() {
            Object ref = "";
            if (this.playerIdCase_ == 12) {
                ref = this.playerId_;
            }
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            if (this.playerIdCase_ == 12) {
                this.playerId_ = s;
            }
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
        public ByteString getPsnIdBytes() {
            Object ref = "";
            if (this.playerIdCase_ == 12) {
                ref = this.playerId_;
            }
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            if (this.playerIdCase_ == 12) {
                this.playerId_ = b;
            }
            return b;
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
            if (this.isOnlineId_) {
                output.writeBool(3, this.isOnlineId_);
            }
            if (this.playerIdCase_ == 4) {
                output.writeUInt32(4, ((Integer) this.playerId_).intValue());
            }
            if (this.playerIdCase_ == 10) {
                GeneratedMessageV3.writeString(output, 10, this.playerId_);
            }
            if (this.playerIdCase_ == 12) {
                GeneratedMessageV3.writeString(output, 12, this.playerId_);
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
            if (this.isOnlineId_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.isOnlineId_);
            }
            if (this.playerIdCase_ == 4) {
                size2 += CodedOutputStream.computeUInt32Size(4, ((Integer) this.playerId_).intValue());
            }
            if (this.playerIdCase_ == 10) {
                size2 += GeneratedMessageV3.computeStringSize(10, this.playerId_);
            }
            if (this.playerIdCase_ == 12) {
                size2 += GeneratedMessageV3.computeStringSize(12, this.playerId_);
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
            if (!(obj instanceof GetOnlinePlayerInfoReq)) {
                return equals(obj);
            }
            GetOnlinePlayerInfoReq other = (GetOnlinePlayerInfoReq) obj;
            if (getIsOnlineId() != other.getIsOnlineId() || !getPlayerIdCase().equals(other.getPlayerIdCase())) {
                return false;
            }
            switch (this.playerIdCase_) {
                case 4:
                    if (getTargetUid() != other.getTargetUid()) {
                        return false;
                    }
                    break;
                case 10:
                    if (!getOnlineId().equals(other.getOnlineId())) {
                        return false;
                    }
                    break;
                case 12:
                    if (!getPsnId().equals(other.getPsnId())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + Internal.hashBoolean(getIsOnlineId());
            switch (this.playerIdCase_) {
                case 4:
                    hash = (53 * ((37 * hash) + 4)) + getTargetUid();
                    break;
                case 10:
                    hash = (53 * ((37 * hash) + 10)) + getOnlineId().hashCode();
                    break;
                case 12:
                    hash = (53 * ((37 * hash) + 12)) + getPsnId().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetOnlinePlayerInfoReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOnlinePlayerInfoReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlinePlayerInfoReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOnlinePlayerInfoReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlinePlayerInfoReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOnlinePlayerInfoReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlinePlayerInfoReq parseFrom(InputStream input) throws IOException {
            return (GetOnlinePlayerInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetOnlinePlayerInfoReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlinePlayerInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetOnlinePlayerInfoReq parseDelimitedFrom(InputStream input) throws IOException {
            return (GetOnlinePlayerInfoReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetOnlinePlayerInfoReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlinePlayerInfoReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetOnlinePlayerInfoReq parseFrom(CodedInputStream input) throws IOException {
            return (GetOnlinePlayerInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetOnlinePlayerInfoReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlinePlayerInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetOnlinePlayerInfoReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOnlinePlayerInfoReqOuterClass$GetOnlinePlayerInfoReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetOnlinePlayerInfoReqOrBuilder {
            private int playerIdCase_ = 0;
            private Object playerId_;
            private boolean isOnlineId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetOnlinePlayerInfoReqOuterClass.internal_static_GetOnlinePlayerInfoReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetOnlinePlayerInfoReqOuterClass.internal_static_GetOnlinePlayerInfoReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOnlinePlayerInfoReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetOnlinePlayerInfoReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOnlineId_ = false;
                this.playerIdCase_ = 0;
                this.playerId_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetOnlinePlayerInfoReqOuterClass.internal_static_GetOnlinePlayerInfoReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetOnlinePlayerInfoReq getDefaultInstanceForType() {
                return GetOnlinePlayerInfoReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetOnlinePlayerInfoReq build() {
                GetOnlinePlayerInfoReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetOnlinePlayerInfoReq buildPartial() {
                GetOnlinePlayerInfoReq result = new GetOnlinePlayerInfoReq(this);
                result.isOnlineId_ = this.isOnlineId_;
                if (this.playerIdCase_ == 4) {
                    result.playerId_ = this.playerId_;
                }
                if (this.playerIdCase_ == 10) {
                    result.playerId_ = this.playerId_;
                }
                if (this.playerIdCase_ == 12) {
                    result.playerId_ = this.playerId_;
                }
                result.playerIdCase_ = this.playerIdCase_;
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
                if (other instanceof GetOnlinePlayerInfoReq) {
                    return mergeFrom((GetOnlinePlayerInfoReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetOnlinePlayerInfoReq other) {
                if (other == GetOnlinePlayerInfoReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOnlineId()) {
                    setIsOnlineId(other.getIsOnlineId());
                }
                switch (other.getPlayerIdCase()) {
                    case TARGET_UID:
                        setTargetUid(other.getTargetUid());
                        break;
                    case ONLINE_ID:
                        this.playerIdCase_ = 10;
                        this.playerId_ = other.playerId_;
                        onChanged();
                        break;
                    case PSN_ID:
                        this.playerIdCase_ = 12;
                        this.playerId_ = other.playerId_;
                        onChanged();
                        break;
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
                GetOnlinePlayerInfoReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetOnlinePlayerInfoReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetOnlinePlayerInfoReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
            public PlayerIdCase getPlayerIdCase() {
                return PlayerIdCase.forNumber(this.playerIdCase_);
            }

            public Builder clearPlayerId() {
                this.playerIdCase_ = 0;
                this.playerId_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
            public boolean getIsOnlineId() {
                return this.isOnlineId_;
            }

            public Builder setIsOnlineId(boolean value) {
                this.isOnlineId_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOnlineId() {
                this.isOnlineId_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
            public boolean hasTargetUid() {
                return this.playerIdCase_ == 4;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
            public int getTargetUid() {
                if (this.playerIdCase_ == 4) {
                    return ((Integer) this.playerId_).intValue();
                }
                return 0;
            }

            public Builder setTargetUid(int value) {
                this.playerIdCase_ = 4;
                this.playerId_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                if (this.playerIdCase_ == 4) {
                    this.playerIdCase_ = 0;
                    this.playerId_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
            public boolean hasOnlineId() {
                return this.playerIdCase_ == 10;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
            public String getOnlineId() {
                Object ref = "";
                if (this.playerIdCase_ == 10) {
                    ref = this.playerId_;
                }
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                if (this.playerIdCase_ == 10) {
                    this.playerId_ = s;
                }
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
            public ByteString getOnlineIdBytes() {
                Object ref = "";
                if (this.playerIdCase_ == 10) {
                    ref = this.playerId_;
                }
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                if (this.playerIdCase_ == 10) {
                    this.playerId_ = b;
                }
                return b;
            }

            public Builder setOnlineId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.playerIdCase_ = 10;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearOnlineId() {
                if (this.playerIdCase_ == 10) {
                    this.playerIdCase_ = 0;
                    this.playerId_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder setOnlineIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetOnlinePlayerInfoReq.checkByteStringIsUtf8(value);
                this.playerIdCase_ = 10;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
            public boolean hasPsnId() {
                return this.playerIdCase_ == 12;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
            public String getPsnId() {
                Object ref = "";
                if (this.playerIdCase_ == 12) {
                    ref = this.playerId_;
                }
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                if (this.playerIdCase_ == 12) {
                    this.playerId_ = s;
                }
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetOnlinePlayerInfoReqOuterClass.GetOnlinePlayerInfoReqOrBuilder
            public ByteString getPsnIdBytes() {
                Object ref = "";
                if (this.playerIdCase_ == 12) {
                    ref = this.playerId_;
                }
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                if (this.playerIdCase_ == 12) {
                    this.playerId_ = b;
                }
                return b;
            }

            public Builder setPsnId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.playerIdCase_ = 12;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPsnId() {
                if (this.playerIdCase_ == 12) {
                    this.playerIdCase_ = 0;
                    this.playerId_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder setPsnIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetOnlinePlayerInfoReq.checkByteStringIsUtf8(value);
                this.playerIdCase_ = 12;
                this.playerId_ = value;
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

        public static GetOnlinePlayerInfoReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetOnlinePlayerInfoReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetOnlinePlayerInfoReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetOnlinePlayerInfoReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
