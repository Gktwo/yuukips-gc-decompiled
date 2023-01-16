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
import emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBasicInfoOuterClass.class */
public final class HomeBasicInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013HomeBasicInfo.proto\u001a\u0019HomeLimitedShopInfo.proto\"Ø\u0001\n\rHomeBasicInfo\u0012\u000b\n\u0003exp\u0018\u0003 \u0001(\u0004\u0012\u0016\n\u000ehome_owner_uid\u0018\u000b \u0001(\r\u0012\u0019\n\u0011cur_room_scene_id\u0018\u000e \u0001(\r\u0012\u0017\n\u000fowner_nick_name\u0018\u0006 \u0001(\t\u0012\u0015\n\rcur_module_id\u0018\u0004 \u0001(\r\u0012/\n\u0011limited_shop_info\u0018\r \u0001(\u000b2\u0014.HomeLimitedShopInfo\u0012\u0017\n\u000fis_in_edit_mode\u0018\u0007 \u0001(\b\u0012\r\n\u0005level\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeLimitedShopInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeBasicInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeBasicInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeBasicInfo_descriptor, new String[]{"Exp", "HomeOwnerUid", "CurRoomSceneId", "OwnerNickName", "CurModuleId", "LimitedShopInfo", "IsInEditMode", "Level"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBasicInfoOuterClass$HomeBasicInfoOrBuilder.class */
    public interface HomeBasicInfoOrBuilder extends MessageOrBuilder {
        long getExp();

        int getHomeOwnerUid();

        int getCurRoomSceneId();

        String getOwnerNickName();

        ByteString getOwnerNickNameBytes();

        int getCurModuleId();

        boolean hasLimitedShopInfo();

        HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo getLimitedShopInfo();

        HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder getLimitedShopInfoOrBuilder();

        boolean getIsInEditMode();

        int getLevel();
    }

    private HomeBasicInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBasicInfoOuterClass$HomeBasicInfo.class */
    public static final class HomeBasicInfo extends GeneratedMessageV3 implements HomeBasicInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EXP_FIELD_NUMBER = 3;
        private long exp_;
        public static final int HOME_OWNER_UID_FIELD_NUMBER = 11;
        private int homeOwnerUid_;
        public static final int CUR_ROOM_SCENE_ID_FIELD_NUMBER = 14;
        private int curRoomSceneId_;
        public static final int OWNER_NICK_NAME_FIELD_NUMBER = 6;
        private volatile Object ownerNickName_;
        public static final int CUR_MODULE_ID_FIELD_NUMBER = 4;
        private int curModuleId_;
        public static final int LIMITED_SHOP_INFO_FIELD_NUMBER = 13;
        private HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo limitedShopInfo_;
        public static final int IS_IN_EDIT_MODE_FIELD_NUMBER = 7;
        private boolean isInEditMode_;
        public static final int LEVEL_FIELD_NUMBER = 9;
        private int level_;
        private byte memoizedIsInitialized;
        private static final HomeBasicInfo DEFAULT_INSTANCE = new HomeBasicInfo();
        private static final Parser<HomeBasicInfo> PARSER = new AbstractParser<HomeBasicInfo>() { // from class: emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfo.1
            @Override // com.google.protobuf.Parser
            public HomeBasicInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeBasicInfo(input, extensionRegistry);
            }
        };

        private HomeBasicInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeBasicInfo() {
            this.memoizedIsInitialized = -1;
            this.ownerNickName_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeBasicInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeBasicInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.exp_ = input.readUInt64();
                                break;
                            case 32:
                                this.curModuleId_ = input.readUInt32();
                                break;
                            case 50:
                                this.ownerNickName_ = input.readStringRequireUtf8();
                                break;
                            case 56:
                                this.isInEditMode_ = input.readBool();
                                break;
                            case 72:
                                this.level_ = input.readUInt32();
                                break;
                            case 88:
                                this.homeOwnerUid_ = input.readUInt32();
                                break;
                            case 106:
                                HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder subBuilder = this.limitedShopInfo_ != null ? this.limitedShopInfo_.toBuilder() : null;
                                this.limitedShopInfo_ = (HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo) input.readMessage(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.limitedShopInfo_);
                                    this.limitedShopInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 112:
                                this.curRoomSceneId_ = input.readUInt32();
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
            return HomeBasicInfoOuterClass.internal_static_HomeBasicInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeBasicInfoOuterClass.internal_static_HomeBasicInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeBasicInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public long getExp() {
            return this.exp_;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public int getHomeOwnerUid() {
            return this.homeOwnerUid_;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public int getCurRoomSceneId() {
            return this.curRoomSceneId_;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public String getOwnerNickName() {
            Object ref = this.ownerNickName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.ownerNickName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public ByteString getOwnerNickNameBytes() {
            Object ref = this.ownerNickName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.ownerNickName_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public int getCurModuleId() {
            return this.curModuleId_;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public boolean hasLimitedShopInfo() {
            return this.limitedShopInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo getLimitedShopInfo() {
            return this.limitedShopInfo_ == null ? HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.getDefaultInstance() : this.limitedShopInfo_;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder getLimitedShopInfoOrBuilder() {
            return getLimitedShopInfo();
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public boolean getIsInEditMode() {
            return this.isInEditMode_;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
        public int getLevel() {
            return this.level_;
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
            if (this.exp_ != 0) {
                output.writeUInt64(3, this.exp_);
            }
            if (this.curModuleId_ != 0) {
                output.writeUInt32(4, this.curModuleId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.ownerNickName_)) {
                GeneratedMessageV3.writeString(output, 6, this.ownerNickName_);
            }
            if (this.isInEditMode_) {
                output.writeBool(7, this.isInEditMode_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(9, this.level_);
            }
            if (this.homeOwnerUid_ != 0) {
                output.writeUInt32(11, this.homeOwnerUid_);
            }
            if (this.limitedShopInfo_ != null) {
                output.writeMessage(13, getLimitedShopInfo());
            }
            if (this.curRoomSceneId_ != 0) {
                output.writeUInt32(14, this.curRoomSceneId_);
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
            if (this.exp_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(3, this.exp_);
            }
            if (this.curModuleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.curModuleId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.ownerNickName_)) {
                size2 += GeneratedMessageV3.computeStringSize(6, this.ownerNickName_);
            }
            if (this.isInEditMode_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isInEditMode_);
            }
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.level_);
            }
            if (this.homeOwnerUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.homeOwnerUid_);
            }
            if (this.limitedShopInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getLimitedShopInfo());
            }
            if (this.curRoomSceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.curRoomSceneId_);
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
            if (!(obj instanceof HomeBasicInfo)) {
                return equals(obj);
            }
            HomeBasicInfo other = (HomeBasicInfo) obj;
            if (getExp() == other.getExp() && getHomeOwnerUid() == other.getHomeOwnerUid() && getCurRoomSceneId() == other.getCurRoomSceneId() && getOwnerNickName().equals(other.getOwnerNickName()) && getCurModuleId() == other.getCurModuleId() && hasLimitedShopInfo() == other.hasLimitedShopInfo()) {
                return (!hasLimitedShopInfo() || getLimitedShopInfo().equals(other.getLimitedShopInfo())) && getIsInEditMode() == other.getIsInEditMode() && getLevel() == other.getLevel() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + Internal.hashLong(getExp()))) + 11)) + getHomeOwnerUid())) + 14)) + getCurRoomSceneId())) + 6)) + getOwnerNickName().hashCode())) + 4)) + getCurModuleId();
            if (hasLimitedShopInfo()) {
                hash = (53 * ((37 * hash) + 13)) + getLimitedShopInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 7)) + Internal.hashBoolean(getIsInEditMode()))) + 9)) + getLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeBasicInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBasicInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBasicInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBasicInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBasicInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBasicInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBasicInfo parseFrom(InputStream input) throws IOException {
            return (HomeBasicInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeBasicInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBasicInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeBasicInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeBasicInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeBasicInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBasicInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeBasicInfo parseFrom(CodedInputStream input) throws IOException {
            return (HomeBasicInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeBasicInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBasicInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeBasicInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBasicInfoOuterClass$HomeBasicInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeBasicInfoOrBuilder {
            private long exp_;
            private int homeOwnerUid_;
            private int curRoomSceneId_;
            private Object ownerNickName_ = "";
            private int curModuleId_;
            private HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo limitedShopInfo_;
            private SingleFieldBuilderV3<HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder> limitedShopInfoBuilder_;
            private boolean isInEditMode_;
            private int level_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeBasicInfoOuterClass.internal_static_HomeBasicInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeBasicInfoOuterClass.internal_static_HomeBasicInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeBasicInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeBasicInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.exp_ = 0;
                this.homeOwnerUid_ = 0;
                this.curRoomSceneId_ = 0;
                this.ownerNickName_ = "";
                this.curModuleId_ = 0;
                if (this.limitedShopInfoBuilder_ == null) {
                    this.limitedShopInfo_ = null;
                } else {
                    this.limitedShopInfo_ = null;
                    this.limitedShopInfoBuilder_ = null;
                }
                this.isInEditMode_ = false;
                this.level_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeBasicInfoOuterClass.internal_static_HomeBasicInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeBasicInfo getDefaultInstanceForType() {
                return HomeBasicInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeBasicInfo build() {
                HomeBasicInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeBasicInfo buildPartial() {
                HomeBasicInfo result = new HomeBasicInfo(this);
                result.exp_ = this.exp_;
                result.homeOwnerUid_ = this.homeOwnerUid_;
                result.curRoomSceneId_ = this.curRoomSceneId_;
                result.ownerNickName_ = this.ownerNickName_;
                result.curModuleId_ = this.curModuleId_;
                if (this.limitedShopInfoBuilder_ == null) {
                    result.limitedShopInfo_ = this.limitedShopInfo_;
                } else {
                    result.limitedShopInfo_ = this.limitedShopInfoBuilder_.build();
                }
                result.isInEditMode_ = this.isInEditMode_;
                result.level_ = this.level_;
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
                if (other instanceof HomeBasicInfo) {
                    return mergeFrom((HomeBasicInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeBasicInfo other) {
                if (other == HomeBasicInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getExp() != 0) {
                    setExp(other.getExp());
                }
                if (other.getHomeOwnerUid() != 0) {
                    setHomeOwnerUid(other.getHomeOwnerUid());
                }
                if (other.getCurRoomSceneId() != 0) {
                    setCurRoomSceneId(other.getCurRoomSceneId());
                }
                if (!other.getOwnerNickName().isEmpty()) {
                    this.ownerNickName_ = other.ownerNickName_;
                    onChanged();
                }
                if (other.getCurModuleId() != 0) {
                    setCurModuleId(other.getCurModuleId());
                }
                if (other.hasLimitedShopInfo()) {
                    mergeLimitedShopInfo(other.getLimitedShopInfo());
                }
                if (other.getIsInEditMode()) {
                    setIsInEditMode(other.getIsInEditMode());
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
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
                HomeBasicInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeBasicInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeBasicInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public long getExp() {
                return this.exp_;
            }

            public Builder setExp(long value) {
                this.exp_ = value;
                onChanged();
                return this;
            }

            public Builder clearExp() {
                this.exp_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public int getHomeOwnerUid() {
                return this.homeOwnerUid_;
            }

            public Builder setHomeOwnerUid(int value) {
                this.homeOwnerUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearHomeOwnerUid() {
                this.homeOwnerUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public int getCurRoomSceneId() {
                return this.curRoomSceneId_;
            }

            public Builder setCurRoomSceneId(int value) {
                this.curRoomSceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurRoomSceneId() {
                this.curRoomSceneId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public String getOwnerNickName() {
                Object ref = this.ownerNickName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.ownerNickName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public ByteString getOwnerNickNameBytes() {
                Object ref = this.ownerNickName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.ownerNickName_ = b;
                return b;
            }

            public Builder setOwnerNickName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ownerNickName_ = value;
                onChanged();
                return this;
            }

            public Builder clearOwnerNickName() {
                this.ownerNickName_ = HomeBasicInfo.getDefaultInstance().getOwnerNickName();
                onChanged();
                return this;
            }

            public Builder setOwnerNickNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                HomeBasicInfo.checkByteStringIsUtf8(value);
                this.ownerNickName_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public int getCurModuleId() {
                return this.curModuleId_;
            }

            public Builder setCurModuleId(int value) {
                this.curModuleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurModuleId() {
                this.curModuleId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public boolean hasLimitedShopInfo() {
                return (this.limitedShopInfoBuilder_ == null && this.limitedShopInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo getLimitedShopInfo() {
                if (this.limitedShopInfoBuilder_ == null) {
                    return this.limitedShopInfo_ == null ? HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.getDefaultInstance() : this.limitedShopInfo_;
                }
                return this.limitedShopInfoBuilder_.getMessage();
            }

            public Builder setLimitedShopInfo(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo value) {
                if (this.limitedShopInfoBuilder_ != null) {
                    this.limitedShopInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.limitedShopInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setLimitedShopInfo(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder builderForValue) {
                if (this.limitedShopInfoBuilder_ == null) {
                    this.limitedShopInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.limitedShopInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeLimitedShopInfo(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo value) {
                if (this.limitedShopInfoBuilder_ == null) {
                    if (this.limitedShopInfo_ != null) {
                        this.limitedShopInfo_ = HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.newBuilder(this.limitedShopInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.limitedShopInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.limitedShopInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearLimitedShopInfo() {
                if (this.limitedShopInfoBuilder_ == null) {
                    this.limitedShopInfo_ = null;
                    onChanged();
                } else {
                    this.limitedShopInfo_ = null;
                    this.limitedShopInfoBuilder_ = null;
                }
                return this;
            }

            public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder getLimitedShopInfoBuilder() {
                onChanged();
                return getLimitedShopInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder getLimitedShopInfoOrBuilder() {
                if (this.limitedShopInfoBuilder_ != null) {
                    return this.limitedShopInfoBuilder_.getMessageOrBuilder();
                }
                return this.limitedShopInfo_ == null ? HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.getDefaultInstance() : this.limitedShopInfo_;
            }

            private SingleFieldBuilderV3<HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder> getLimitedShopInfoFieldBuilder() {
                if (this.limitedShopInfoBuilder_ == null) {
                    this.limitedShopInfoBuilder_ = new SingleFieldBuilderV3<>(getLimitedShopInfo(), getParentForChildren(), isClean());
                    this.limitedShopInfo_ = null;
                }
                return this.limitedShopInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public boolean getIsInEditMode() {
                return this.isInEditMode_;
            }

            public Builder setIsInEditMode(boolean value) {
                this.isInEditMode_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsInEditMode() {
                this.isInEditMode_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder
            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
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

        public static HomeBasicInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeBasicInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeBasicInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeBasicInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeLimitedShopInfoOuterClass.getDescriptor();
    }
}
