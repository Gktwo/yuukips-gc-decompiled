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
import emu.grasscutter.net.proto.ProfilePictureOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGroupPlayerInfoOuterClass.class */
public final class HomeGroupPlayerInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019HomeGroupPlayerInfo.proto\u001a\u0014ProfilePicture.proto\"\u0001\n\u0013HomeGroupPlayerInfo\u0012\u000e\n\u0006psn_id\u0018\n \u0001(\t\u0012\u0010\n\bnickname\u0018\r \u0001(\t\u0012\u000b\n\u0003uid\u0018\u0001 \u0001(\r\u0012(\n\u000fprofile_picture\u0018\u0002 \u0001(\u000b2\u000f.ProfilePicture\u0012\u0014\n\fplayer_level\u0018\t \u0001(\r\u0012\u0011\n\tonline_id\u0018\u0004 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ProfilePictureOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeGroupPlayerInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeGroupPlayerInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeGroupPlayerInfo_descriptor, new String[]{"PsnId", "Nickname", "Uid", "ProfilePicture", "PlayerLevel", "OnlineId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGroupPlayerInfoOuterClass$HomeGroupPlayerInfoOrBuilder.class */
    public interface HomeGroupPlayerInfoOrBuilder extends MessageOrBuilder {
        String getPsnId();

        ByteString getPsnIdBytes();

        String getNickname();

        ByteString getNicknameBytes();

        int getUid();

        boolean hasProfilePicture();

        ProfilePictureOuterClass.ProfilePicture getProfilePicture();

        ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder();

        int getPlayerLevel();

        String getOnlineId();

        ByteString getOnlineIdBytes();
    }

    private HomeGroupPlayerInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGroupPlayerInfoOuterClass$HomeGroupPlayerInfo.class */
    public static final class HomeGroupPlayerInfo extends GeneratedMessageV3 implements HomeGroupPlayerInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PSN_ID_FIELD_NUMBER = 10;
        private volatile Object psnId_;
        public static final int NICKNAME_FIELD_NUMBER = 13;
        private volatile Object nickname_;
        public static final int UID_FIELD_NUMBER = 1;
        private int uid_;
        public static final int PROFILE_PICTURE_FIELD_NUMBER = 2;
        private ProfilePictureOuterClass.ProfilePicture profilePicture_;
        public static final int PLAYER_LEVEL_FIELD_NUMBER = 9;
        private int playerLevel_;
        public static final int ONLINE_ID_FIELD_NUMBER = 4;
        private volatile Object onlineId_;
        private byte memoizedIsInitialized;
        private static final HomeGroupPlayerInfo DEFAULT_INSTANCE = new HomeGroupPlayerInfo();
        private static final Parser<HomeGroupPlayerInfo> PARSER = new AbstractParser<HomeGroupPlayerInfo>() { // from class: emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.1
            @Override // com.google.protobuf.Parser
            public HomeGroupPlayerInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeGroupPlayerInfo(input, extensionRegistry);
            }
        };

        private HomeGroupPlayerInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeGroupPlayerInfo() {
            this.memoizedIsInitialized = -1;
            this.psnId_ = "";
            this.nickname_ = "";
            this.onlineId_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeGroupPlayerInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeGroupPlayerInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.uid_ = input.readUInt32();
                                break;
                            case 18:
                                ProfilePictureOuterClass.ProfilePicture.Builder subBuilder = this.profilePicture_ != null ? this.profilePicture_.toBuilder() : null;
                                this.profilePicture_ = (ProfilePictureOuterClass.ProfilePicture) input.readMessage(ProfilePictureOuterClass.ProfilePicture.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.profilePicture_);
                                    this.profilePicture_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 34:
                                this.onlineId_ = input.readStringRequireUtf8();
                                break;
                            case 72:
                                this.playerLevel_ = input.readUInt32();
                                break;
                            case 82:
                                this.psnId_ = input.readStringRequireUtf8();
                                break;
                            case 106:
                                this.nickname_ = input.readStringRequireUtf8();
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
            return HomeGroupPlayerInfoOuterClass.internal_static_HomeGroupPlayerInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeGroupPlayerInfoOuterClass.internal_static_HomeGroupPlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeGroupPlayerInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public String getPsnId() {
            Object ref = this.psnId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.psnId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public ByteString getPsnIdBytes() {
            Object ref = this.psnId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.psnId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public String getNickname() {
            Object ref = this.nickname_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.nickname_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public ByteString getNicknameBytes() {
            Object ref = this.nickname_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.nickname_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public boolean hasProfilePicture() {
            return this.profilePicture_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public ProfilePictureOuterClass.ProfilePicture getProfilePicture() {
            return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder() {
            return getProfilePicture();
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public int getPlayerLevel() {
            return this.playerLevel_;
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public String getOnlineId() {
            Object ref = this.onlineId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.onlineId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
        public ByteString getOnlineIdBytes() {
            Object ref = this.onlineId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.onlineId_ = b;
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
            if (this.uid_ != 0) {
                output.writeUInt32(1, this.uid_);
            }
            if (this.profilePicture_ != null) {
                output.writeMessage(2, getProfilePicture());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                GeneratedMessageV3.writeString(output, 4, this.onlineId_);
            }
            if (this.playerLevel_ != 0) {
                output.writeUInt32(9, this.playerLevel_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                GeneratedMessageV3.writeString(output, 10, this.psnId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nickname_)) {
                GeneratedMessageV3.writeString(output, 13, this.nickname_);
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
            if (this.uid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.uid_);
            }
            if (this.profilePicture_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getProfilePicture());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.onlineId_);
            }
            if (this.playerLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.playerLevel_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                size2 += GeneratedMessageV3.computeStringSize(10, this.psnId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nickname_)) {
                size2 += GeneratedMessageV3.computeStringSize(13, this.nickname_);
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
            if (!(obj instanceof HomeGroupPlayerInfo)) {
                return equals(obj);
            }
            HomeGroupPlayerInfo other = (HomeGroupPlayerInfo) obj;
            if (getPsnId().equals(other.getPsnId()) && getNickname().equals(other.getNickname()) && getUid() == other.getUid() && hasProfilePicture() == other.hasProfilePicture()) {
                return (!hasProfilePicture() || getProfilePicture().equals(other.getProfilePicture())) && getPlayerLevel() == other.getPlayerLevel() && getOnlineId().equals(other.getOnlineId()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getPsnId().hashCode())) + 13)) + getNickname().hashCode())) + 1)) + getUid();
            if (hasProfilePicture()) {
                hash = (53 * ((37 * hash) + 2)) + getProfilePicture().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 9)) + getPlayerLevel())) + 4)) + getOnlineId().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeGroupPlayerInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeGroupPlayerInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeGroupPlayerInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeGroupPlayerInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeGroupPlayerInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeGroupPlayerInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeGroupPlayerInfo parseFrom(InputStream input) throws IOException {
            return (HomeGroupPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeGroupPlayerInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeGroupPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeGroupPlayerInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeGroupPlayerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeGroupPlayerInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeGroupPlayerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeGroupPlayerInfo parseFrom(CodedInputStream input) throws IOException {
            return (HomeGroupPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeGroupPlayerInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeGroupPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeGroupPlayerInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGroupPlayerInfoOuterClass$HomeGroupPlayerInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeGroupPlayerInfoOrBuilder {
            private int uid_;
            private ProfilePictureOuterClass.ProfilePicture profilePicture_;
            private SingleFieldBuilderV3<ProfilePictureOuterClass.ProfilePicture, ProfilePictureOuterClass.ProfilePicture.Builder, ProfilePictureOuterClass.ProfilePictureOrBuilder> profilePictureBuilder_;
            private int playerLevel_;
            private Object psnId_ = "";
            private Object nickname_ = "";
            private Object onlineId_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeGroupPlayerInfoOuterClass.internal_static_HomeGroupPlayerInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeGroupPlayerInfoOuterClass.internal_static_HomeGroupPlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeGroupPlayerInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeGroupPlayerInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.psnId_ = "";
                this.nickname_ = "";
                this.uid_ = 0;
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = null;
                } else {
                    this.profilePicture_ = null;
                    this.profilePictureBuilder_ = null;
                }
                this.playerLevel_ = 0;
                this.onlineId_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeGroupPlayerInfoOuterClass.internal_static_HomeGroupPlayerInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeGroupPlayerInfo getDefaultInstanceForType() {
                return HomeGroupPlayerInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeGroupPlayerInfo build() {
                HomeGroupPlayerInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeGroupPlayerInfo buildPartial() {
                HomeGroupPlayerInfo result = new HomeGroupPlayerInfo(this);
                result.psnId_ = this.psnId_;
                result.nickname_ = this.nickname_;
                result.uid_ = this.uid_;
                if (this.profilePictureBuilder_ == null) {
                    result.profilePicture_ = this.profilePicture_;
                } else {
                    result.profilePicture_ = this.profilePictureBuilder_.build();
                }
                result.playerLevel_ = this.playerLevel_;
                result.onlineId_ = this.onlineId_;
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
                if (other instanceof HomeGroupPlayerInfo) {
                    return mergeFrom((HomeGroupPlayerInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeGroupPlayerInfo other) {
                if (other == HomeGroupPlayerInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.getPsnId().isEmpty()) {
                    this.psnId_ = other.psnId_;
                    onChanged();
                }
                if (!other.getNickname().isEmpty()) {
                    this.nickname_ = other.nickname_;
                    onChanged();
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (other.hasProfilePicture()) {
                    mergeProfilePicture(other.getProfilePicture());
                }
                if (other.getPlayerLevel() != 0) {
                    setPlayerLevel(other.getPlayerLevel());
                }
                if (!other.getOnlineId().isEmpty()) {
                    this.onlineId_ = other.onlineId_;
                    onChanged();
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
                HomeGroupPlayerInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeGroupPlayerInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeGroupPlayerInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
            public String getPsnId() {
                Object ref = this.psnId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.psnId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
            public ByteString getPsnIdBytes() {
                Object ref = this.psnId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.psnId_ = b;
                return b;
            }

            public Builder setPsnId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.psnId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPsnId() {
                this.psnId_ = HomeGroupPlayerInfo.getDefaultInstance().getPsnId();
                onChanged();
                return this;
            }

            public Builder setPsnIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                HomeGroupPlayerInfo.checkByteStringIsUtf8(value);
                this.psnId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
            public String getNickname() {
                Object ref = this.nickname_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.nickname_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
            public ByteString getNicknameBytes() {
                Object ref = this.nickname_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.nickname_ = b;
                return b;
            }

            public Builder setNickname(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.nickname_ = value;
                onChanged();
                return this;
            }

            public Builder clearNickname() {
                this.nickname_ = HomeGroupPlayerInfo.getDefaultInstance().getNickname();
                onChanged();
                return this;
            }

            public Builder setNicknameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                HomeGroupPlayerInfo.checkByteStringIsUtf8(value);
                this.nickname_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
            public boolean hasProfilePicture() {
                return (this.profilePictureBuilder_ == null && this.profilePicture_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
            public ProfilePictureOuterClass.ProfilePicture getProfilePicture() {
                if (this.profilePictureBuilder_ == null) {
                    return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
                }
                return this.profilePictureBuilder_.getMessage();
            }

            public Builder setProfilePicture(ProfilePictureOuterClass.ProfilePicture value) {
                if (this.profilePictureBuilder_ != null) {
                    this.profilePictureBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.profilePicture_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setProfilePicture(ProfilePictureOuterClass.ProfilePicture.Builder builderForValue) {
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = builderForValue.build();
                    onChanged();
                } else {
                    this.profilePictureBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeProfilePicture(ProfilePictureOuterClass.ProfilePicture value) {
                if (this.profilePictureBuilder_ == null) {
                    if (this.profilePicture_ != null) {
                        this.profilePicture_ = ProfilePictureOuterClass.ProfilePicture.newBuilder(this.profilePicture_).mergeFrom(value).buildPartial();
                    } else {
                        this.profilePicture_ = value;
                    }
                    onChanged();
                } else {
                    this.profilePictureBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearProfilePicture() {
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = null;
                    onChanged();
                } else {
                    this.profilePicture_ = null;
                    this.profilePictureBuilder_ = null;
                }
                return this;
            }

            public ProfilePictureOuterClass.ProfilePicture.Builder getProfilePictureBuilder() {
                onChanged();
                return getProfilePictureFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
            public ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder() {
                if (this.profilePictureBuilder_ != null) {
                    return this.profilePictureBuilder_.getMessageOrBuilder();
                }
                return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
            }

            private SingleFieldBuilderV3<ProfilePictureOuterClass.ProfilePicture, ProfilePictureOuterClass.ProfilePicture.Builder, ProfilePictureOuterClass.ProfilePictureOrBuilder> getProfilePictureFieldBuilder() {
                if (this.profilePictureBuilder_ == null) {
                    this.profilePictureBuilder_ = new SingleFieldBuilderV3<>(getProfilePicture(), getParentForChildren(), isClean());
                    this.profilePicture_ = null;
                }
                return this.profilePictureBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
            public int getPlayerLevel() {
                return this.playerLevel_;
            }

            public Builder setPlayerLevel(int value) {
                this.playerLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerLevel() {
                this.playerLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
            public String getOnlineId() {
                Object ref = this.onlineId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.onlineId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder
            public ByteString getOnlineIdBytes() {
                Object ref = this.onlineId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.onlineId_ = b;
                return b;
            }

            public Builder setOnlineId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.onlineId_ = value;
                onChanged();
                return this;
            }

            public Builder clearOnlineId() {
                this.onlineId_ = HomeGroupPlayerInfo.getDefaultInstance().getOnlineId();
                onChanged();
                return this;
            }

            public Builder setOnlineIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                HomeGroupPlayerInfo.checkByteStringIsUtf8(value);
                this.onlineId_ = value;
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

        public static HomeGroupPlayerInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeGroupPlayerInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeGroupPlayerInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeGroupPlayerInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ProfilePictureOuterClass.getDescriptor();
    }
}
