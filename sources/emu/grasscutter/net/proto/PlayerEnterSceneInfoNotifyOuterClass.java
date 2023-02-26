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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass;
import emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass;
import emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterSceneInfoNotifyOuterClass.class */
public final class PlayerEnterSceneInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n PlayerEnterSceneInfoNotify.proto\u001a\u0017MPLevelEntityInfo.proto\u001a\u0018TeamEnterSceneInfo.proto\u001a\u001aAvatarEnterSceneInfo.proto\"Û\u0001\n\u001aPlayerEnterSceneInfoNotify\u0012-\n\u0011mpLevelEntityInfo\u0018\u0007 \u0001(\u000b2\u0012.MPLevelEntityInfo\u0012*\n\rteamEnterInfo\u0018\u0005 \u0001(\u000b2\u0013.TeamEnterSceneInfo\u0012\u0019\n\u0011curAvatarEntityId\u0018\b \u0001(\r\u0012\u0017\n\u000fenterSceneToken\u0018\r \u0001(\r\u0012.\n\u000favatarEnterInfo\u0018\f \u0003(\u000b2\u0015.AvatarEnterSceneInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MPLevelEntityInfoOuterClass.getDescriptor(), TeamEnterSceneInfoOuterClass.getDescriptor(), AvatarEnterSceneInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerEnterSceneInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerEnterSceneInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerEnterSceneInfoNotify_descriptor, new String[]{"MpLevelEntityInfo", "TeamEnterInfo", "CurAvatarEntityId", "EnterSceneToken", "AvatarEnterInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterSceneInfoNotifyOuterClass$PlayerEnterSceneInfoNotifyOrBuilder.class */
    public interface PlayerEnterSceneInfoNotifyOrBuilder extends MessageOrBuilder {
        boolean hasMpLevelEntityInfo();

        MPLevelEntityInfoOuterClass.MPLevelEntityInfo getMpLevelEntityInfo();

        MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder getMpLevelEntityInfoOrBuilder();

        boolean hasTeamEnterInfo();

        TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo getTeamEnterInfo();

        TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder getTeamEnterInfoOrBuilder();

        int getCurAvatarEntityId();

        int getEnterSceneToken();

        List<AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo> getAvatarEnterInfoList();

        AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo getAvatarEnterInfo(int i);

        int getAvatarEnterInfoCount();

        List<? extends AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder> getAvatarEnterInfoOrBuilderList();

        AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder getAvatarEnterInfoOrBuilder(int i);
    }

    private PlayerEnterSceneInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterSceneInfoNotifyOuterClass$PlayerEnterSceneInfoNotify.class */
    public static final class PlayerEnterSceneInfoNotify extends GeneratedMessageV3 implements PlayerEnterSceneInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MPLEVELENTITYINFO_FIELD_NUMBER = 7;
        private MPLevelEntityInfoOuterClass.MPLevelEntityInfo mpLevelEntityInfo_;
        public static final int TEAMENTERINFO_FIELD_NUMBER = 5;
        private TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo teamEnterInfo_;
        public static final int CURAVATARENTITYID_FIELD_NUMBER = 8;
        private int curAvatarEntityId_;
        public static final int ENTERSCENETOKEN_FIELD_NUMBER = 13;
        private int enterSceneToken_;
        public static final int AVATARENTERINFO_FIELD_NUMBER = 12;
        private List<AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo> avatarEnterInfo_;
        private byte memoizedIsInitialized;
        private static final PlayerEnterSceneInfoNotify DEFAULT_INSTANCE = new PlayerEnterSceneInfoNotify();
        private static final Parser<PlayerEnterSceneInfoNotify> PARSER = new AbstractParser<PlayerEnterSceneInfoNotify>() { // from class: emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerEnterSceneInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerEnterSceneInfoNotify(input, extensionRegistry);
            }
        };

        private PlayerEnterSceneInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerEnterSceneInfoNotify() {
            this.memoizedIsInitialized = -1;
            this.avatarEnterInfo_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerEnterSceneInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerEnterSceneInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 42:
                                    TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.Builder subBuilder = this.teamEnterInfo_ != null ? this.teamEnterInfo_.toBuilder() : null;
                                    this.teamEnterInfo_ = (TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo) input.readMessage(TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.teamEnterInfo_);
                                        this.teamEnterInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 58:
                                    MPLevelEntityInfoOuterClass.MPLevelEntityInfo.Builder subBuilder2 = this.mpLevelEntityInfo_ != null ? this.mpLevelEntityInfo_.toBuilder() : null;
                                    this.mpLevelEntityInfo_ = (MPLevelEntityInfoOuterClass.MPLevelEntityInfo) input.readMessage(MPLevelEntityInfoOuterClass.MPLevelEntityInfo.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.mpLevelEntityInfo_);
                                        this.mpLevelEntityInfo_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 64:
                                    this.curAvatarEntityId_ = input.readUInt32();
                                    break;
                                case 98:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.avatarEnterInfo_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.avatarEnterInfo_.add((AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo) input.readMessage(AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.parser(), extensionRegistry));
                                    break;
                                case 104:
                                    this.enterSceneToken_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.avatarEnterInfo_ = Collections.unmodifiableList(this.avatarEnterInfo_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerEnterSceneInfoNotifyOuterClass.internal_static_PlayerEnterSceneInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerEnterSceneInfoNotifyOuterClass.internal_static_PlayerEnterSceneInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerEnterSceneInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public boolean hasMpLevelEntityInfo() {
            return this.mpLevelEntityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public MPLevelEntityInfoOuterClass.MPLevelEntityInfo getMpLevelEntityInfo() {
            return this.mpLevelEntityInfo_ == null ? MPLevelEntityInfoOuterClass.MPLevelEntityInfo.getDefaultInstance() : this.mpLevelEntityInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder getMpLevelEntityInfoOrBuilder() {
            return getMpLevelEntityInfo();
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public boolean hasTeamEnterInfo() {
            return this.teamEnterInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo getTeamEnterInfo() {
            return this.teamEnterInfo_ == null ? TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.getDefaultInstance() : this.teamEnterInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder getTeamEnterInfoOrBuilder() {
            return getTeamEnterInfo();
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public int getCurAvatarEntityId() {
            return this.curAvatarEntityId_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public int getEnterSceneToken() {
            return this.enterSceneToken_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public List<AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo> getAvatarEnterInfoList() {
            return this.avatarEnterInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public List<? extends AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder> getAvatarEnterInfoOrBuilderList() {
            return this.avatarEnterInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public int getAvatarEnterInfoCount() {
            return this.avatarEnterInfo_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo getAvatarEnterInfo(int index) {
            return this.avatarEnterInfo_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
        public AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder getAvatarEnterInfoOrBuilder(int index) {
            return this.avatarEnterInfo_.get(index);
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
            if (this.teamEnterInfo_ != null) {
                output.writeMessage(5, getTeamEnterInfo());
            }
            if (this.mpLevelEntityInfo_ != null) {
                output.writeMessage(7, getMpLevelEntityInfo());
            }
            if (this.curAvatarEntityId_ != 0) {
                output.writeUInt32(8, this.curAvatarEntityId_);
            }
            for (int i = 0; i < this.avatarEnterInfo_.size(); i++) {
                output.writeMessage(12, this.avatarEnterInfo_.get(i));
            }
            if (this.enterSceneToken_ != 0) {
                output.writeUInt32(13, this.enterSceneToken_);
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
            if (this.teamEnterInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(5, getTeamEnterInfo());
            }
            if (this.mpLevelEntityInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getMpLevelEntityInfo());
            }
            if (this.curAvatarEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.curAvatarEntityId_);
            }
            for (int i = 0; i < this.avatarEnterInfo_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.avatarEnterInfo_.get(i));
            }
            if (this.enterSceneToken_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.enterSceneToken_);
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
            if (!(obj instanceof PlayerEnterSceneInfoNotify)) {
                return equals(obj);
            }
            PlayerEnterSceneInfoNotify other = (PlayerEnterSceneInfoNotify) obj;
            if (hasMpLevelEntityInfo() != other.hasMpLevelEntityInfo()) {
                return false;
            }
            if ((!hasMpLevelEntityInfo() || getMpLevelEntityInfo().equals(other.getMpLevelEntityInfo())) && hasTeamEnterInfo() == other.hasTeamEnterInfo()) {
                return (!hasTeamEnterInfo() || getTeamEnterInfo().equals(other.getTeamEnterInfo())) && getCurAvatarEntityId() == other.getCurAvatarEntityId() && getEnterSceneToken() == other.getEnterSceneToken() && getAvatarEnterInfoList().equals(other.getAvatarEnterInfoList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasMpLevelEntityInfo()) {
                hash = (53 * ((37 * hash) + 7)) + getMpLevelEntityInfo().hashCode();
            }
            if (hasTeamEnterInfo()) {
                hash = (53 * ((37 * hash) + 5)) + getTeamEnterInfo().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 8)) + getCurAvatarEntityId())) + 13)) + getEnterSceneToken();
            if (getAvatarEnterInfoCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 12)) + getAvatarEnterInfoList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PlayerEnterSceneInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerEnterSceneInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerEnterSceneInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerEnterSceneInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerEnterSceneInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerEnterSceneInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerEnterSceneInfoNotify parseFrom(InputStream input) throws IOException {
            return (PlayerEnterSceneInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerEnterSceneInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerEnterSceneInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerEnterSceneInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerEnterSceneInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerEnterSceneInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerEnterSceneInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerEnterSceneInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerEnterSceneInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerEnterSceneInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerEnterSceneInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerEnterSceneInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterSceneInfoNotifyOuterClass$PlayerEnterSceneInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerEnterSceneInfoNotifyOrBuilder {
            private int bitField0_;
            private MPLevelEntityInfoOuterClass.MPLevelEntityInfo mpLevelEntityInfo_;
            private SingleFieldBuilderV3<MPLevelEntityInfoOuterClass.MPLevelEntityInfo, MPLevelEntityInfoOuterClass.MPLevelEntityInfo.Builder, MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder> mpLevelEntityInfoBuilder_;
            private TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo teamEnterInfo_;
            private SingleFieldBuilderV3<TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo, TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.Builder, TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder> teamEnterInfoBuilder_;
            private int curAvatarEntityId_;
            private int enterSceneToken_;
            private List<AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo> avatarEnterInfo_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo, AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.Builder, AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder> avatarEnterInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerEnterSceneInfoNotifyOuterClass.internal_static_PlayerEnterSceneInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerEnterSceneInfoNotifyOuterClass.internal_static_PlayerEnterSceneInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerEnterSceneInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerEnterSceneInfoNotify.alwaysUseFieldBuilders) {
                    getAvatarEnterInfoFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.mpLevelEntityInfoBuilder_ == null) {
                    this.mpLevelEntityInfo_ = null;
                } else {
                    this.mpLevelEntityInfo_ = null;
                    this.mpLevelEntityInfoBuilder_ = null;
                }
                if (this.teamEnterInfoBuilder_ == null) {
                    this.teamEnterInfo_ = null;
                } else {
                    this.teamEnterInfo_ = null;
                    this.teamEnterInfoBuilder_ = null;
                }
                this.curAvatarEntityId_ = 0;
                this.enterSceneToken_ = 0;
                if (this.avatarEnterInfoBuilder_ == null) {
                    this.avatarEnterInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.avatarEnterInfoBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerEnterSceneInfoNotifyOuterClass.internal_static_PlayerEnterSceneInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerEnterSceneInfoNotify getDefaultInstanceForType() {
                return PlayerEnterSceneInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerEnterSceneInfoNotify build() {
                PlayerEnterSceneInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerEnterSceneInfoNotify buildPartial() {
                PlayerEnterSceneInfoNotify result = new PlayerEnterSceneInfoNotify(this);
                int i = this.bitField0_;
                if (this.mpLevelEntityInfoBuilder_ == null) {
                    result.mpLevelEntityInfo_ = this.mpLevelEntityInfo_;
                } else {
                    result.mpLevelEntityInfo_ = this.mpLevelEntityInfoBuilder_.build();
                }
                if (this.teamEnterInfoBuilder_ == null) {
                    result.teamEnterInfo_ = this.teamEnterInfo_;
                } else {
                    result.teamEnterInfo_ = this.teamEnterInfoBuilder_.build();
                }
                result.curAvatarEntityId_ = this.curAvatarEntityId_;
                result.enterSceneToken_ = this.enterSceneToken_;
                if (this.avatarEnterInfoBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.avatarEnterInfo_ = Collections.unmodifiableList(this.avatarEnterInfo_);
                        this.bitField0_ &= -2;
                    }
                    result.avatarEnterInfo_ = this.avatarEnterInfo_;
                } else {
                    result.avatarEnterInfo_ = this.avatarEnterInfoBuilder_.build();
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
                if (other instanceof PlayerEnterSceneInfoNotify) {
                    return mergeFrom((PlayerEnterSceneInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerEnterSceneInfoNotify other) {
                if (other == PlayerEnterSceneInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasMpLevelEntityInfo()) {
                    mergeMpLevelEntityInfo(other.getMpLevelEntityInfo());
                }
                if (other.hasTeamEnterInfo()) {
                    mergeTeamEnterInfo(other.getTeamEnterInfo());
                }
                if (other.getCurAvatarEntityId() != 0) {
                    setCurAvatarEntityId(other.getCurAvatarEntityId());
                }
                if (other.getEnterSceneToken() != 0) {
                    setEnterSceneToken(other.getEnterSceneToken());
                }
                if (this.avatarEnterInfoBuilder_ == null) {
                    if (!other.avatarEnterInfo_.isEmpty()) {
                        if (this.avatarEnterInfo_.isEmpty()) {
                            this.avatarEnterInfo_ = other.avatarEnterInfo_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAvatarEnterInfoIsMutable();
                            this.avatarEnterInfo_.addAll(other.avatarEnterInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.avatarEnterInfo_.isEmpty()) {
                    if (this.avatarEnterInfoBuilder_.isEmpty()) {
                        this.avatarEnterInfoBuilder_.dispose();
                        this.avatarEnterInfoBuilder_ = null;
                        this.avatarEnterInfo_ = other.avatarEnterInfo_;
                        this.bitField0_ &= -2;
                        this.avatarEnterInfoBuilder_ = PlayerEnterSceneInfoNotify.alwaysUseFieldBuilders ? getAvatarEnterInfoFieldBuilder() : null;
                    } else {
                        this.avatarEnterInfoBuilder_.addAllMessages(other.avatarEnterInfo_);
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
                PlayerEnterSceneInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerEnterSceneInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerEnterSceneInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public boolean hasMpLevelEntityInfo() {
                return (this.mpLevelEntityInfoBuilder_ == null && this.mpLevelEntityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public MPLevelEntityInfoOuterClass.MPLevelEntityInfo getMpLevelEntityInfo() {
                if (this.mpLevelEntityInfoBuilder_ == null) {
                    return this.mpLevelEntityInfo_ == null ? MPLevelEntityInfoOuterClass.MPLevelEntityInfo.getDefaultInstance() : this.mpLevelEntityInfo_;
                }
                return this.mpLevelEntityInfoBuilder_.getMessage();
            }

            public Builder setMpLevelEntityInfo(MPLevelEntityInfoOuterClass.MPLevelEntityInfo value) {
                if (this.mpLevelEntityInfoBuilder_ != null) {
                    this.mpLevelEntityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.mpLevelEntityInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMpLevelEntityInfo(MPLevelEntityInfoOuterClass.MPLevelEntityInfo.Builder builderForValue) {
                if (this.mpLevelEntityInfoBuilder_ == null) {
                    this.mpLevelEntityInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.mpLevelEntityInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMpLevelEntityInfo(MPLevelEntityInfoOuterClass.MPLevelEntityInfo value) {
                if (this.mpLevelEntityInfoBuilder_ == null) {
                    if (this.mpLevelEntityInfo_ != null) {
                        this.mpLevelEntityInfo_ = MPLevelEntityInfoOuterClass.MPLevelEntityInfo.newBuilder(this.mpLevelEntityInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.mpLevelEntityInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.mpLevelEntityInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMpLevelEntityInfo() {
                if (this.mpLevelEntityInfoBuilder_ == null) {
                    this.mpLevelEntityInfo_ = null;
                    onChanged();
                } else {
                    this.mpLevelEntityInfo_ = null;
                    this.mpLevelEntityInfoBuilder_ = null;
                }
                return this;
            }

            public MPLevelEntityInfoOuterClass.MPLevelEntityInfo.Builder getMpLevelEntityInfoBuilder() {
                onChanged();
                return getMpLevelEntityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder getMpLevelEntityInfoOrBuilder() {
                if (this.mpLevelEntityInfoBuilder_ != null) {
                    return this.mpLevelEntityInfoBuilder_.getMessageOrBuilder();
                }
                return this.mpLevelEntityInfo_ == null ? MPLevelEntityInfoOuterClass.MPLevelEntityInfo.getDefaultInstance() : this.mpLevelEntityInfo_;
            }

            private SingleFieldBuilderV3<MPLevelEntityInfoOuterClass.MPLevelEntityInfo, MPLevelEntityInfoOuterClass.MPLevelEntityInfo.Builder, MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder> getMpLevelEntityInfoFieldBuilder() {
                if (this.mpLevelEntityInfoBuilder_ == null) {
                    this.mpLevelEntityInfoBuilder_ = new SingleFieldBuilderV3<>(getMpLevelEntityInfo(), getParentForChildren(), isClean());
                    this.mpLevelEntityInfo_ = null;
                }
                return this.mpLevelEntityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public boolean hasTeamEnterInfo() {
                return (this.teamEnterInfoBuilder_ == null && this.teamEnterInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo getTeamEnterInfo() {
                if (this.teamEnterInfoBuilder_ == null) {
                    return this.teamEnterInfo_ == null ? TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.getDefaultInstance() : this.teamEnterInfo_;
                }
                return this.teamEnterInfoBuilder_.getMessage();
            }

            public Builder setTeamEnterInfo(TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo value) {
                if (this.teamEnterInfoBuilder_ != null) {
                    this.teamEnterInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.teamEnterInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setTeamEnterInfo(TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.Builder builderForValue) {
                if (this.teamEnterInfoBuilder_ == null) {
                    this.teamEnterInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.teamEnterInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeTeamEnterInfo(TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo value) {
                if (this.teamEnterInfoBuilder_ == null) {
                    if (this.teamEnterInfo_ != null) {
                        this.teamEnterInfo_ = TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.newBuilder(this.teamEnterInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.teamEnterInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.teamEnterInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearTeamEnterInfo() {
                if (this.teamEnterInfoBuilder_ == null) {
                    this.teamEnterInfo_ = null;
                    onChanged();
                } else {
                    this.teamEnterInfo_ = null;
                    this.teamEnterInfoBuilder_ = null;
                }
                return this;
            }

            public TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.Builder getTeamEnterInfoBuilder() {
                onChanged();
                return getTeamEnterInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder getTeamEnterInfoOrBuilder() {
                if (this.teamEnterInfoBuilder_ != null) {
                    return this.teamEnterInfoBuilder_.getMessageOrBuilder();
                }
                return this.teamEnterInfo_ == null ? TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.getDefaultInstance() : this.teamEnterInfo_;
            }

            private SingleFieldBuilderV3<TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo, TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.Builder, TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder> getTeamEnterInfoFieldBuilder() {
                if (this.teamEnterInfoBuilder_ == null) {
                    this.teamEnterInfoBuilder_ = new SingleFieldBuilderV3<>(getTeamEnterInfo(), getParentForChildren(), isClean());
                    this.teamEnterInfo_ = null;
                }
                return this.teamEnterInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public int getCurAvatarEntityId() {
                return this.curAvatarEntityId_;
            }

            public Builder setCurAvatarEntityId(int value) {
                this.curAvatarEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurAvatarEntityId() {
                this.curAvatarEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public int getEnterSceneToken() {
                return this.enterSceneToken_;
            }

            public Builder setEnterSceneToken(int value) {
                this.enterSceneToken_ = value;
                onChanged();
                return this;
            }

            public Builder clearEnterSceneToken() {
                this.enterSceneToken_ = 0;
                onChanged();
                return this;
            }

            private void ensureAvatarEnterInfoIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarEnterInfo_ = new ArrayList(this.avatarEnterInfo_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public List<AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo> getAvatarEnterInfoList() {
                if (this.avatarEnterInfoBuilder_ == null) {
                    return Collections.unmodifiableList(this.avatarEnterInfo_);
                }
                return this.avatarEnterInfoBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public int getAvatarEnterInfoCount() {
                if (this.avatarEnterInfoBuilder_ == null) {
                    return this.avatarEnterInfo_.size();
                }
                return this.avatarEnterInfoBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo getAvatarEnterInfo(int index) {
                if (this.avatarEnterInfoBuilder_ == null) {
                    return this.avatarEnterInfo_.get(index);
                }
                return this.avatarEnterInfoBuilder_.getMessage(index);
            }

            public Builder setAvatarEnterInfo(int index, AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo value) {
                if (this.avatarEnterInfoBuilder_ != null) {
                    this.avatarEnterInfoBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarEnterInfoIsMutable();
                    this.avatarEnterInfo_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarEnterInfo(int index, AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.Builder builderForValue) {
                if (this.avatarEnterInfoBuilder_ == null) {
                    ensureAvatarEnterInfoIsMutable();
                    this.avatarEnterInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarEnterInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarEnterInfo(AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo value) {
                if (this.avatarEnterInfoBuilder_ != null) {
                    this.avatarEnterInfoBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarEnterInfoIsMutable();
                    this.avatarEnterInfo_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarEnterInfo(int index, AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo value) {
                if (this.avatarEnterInfoBuilder_ != null) {
                    this.avatarEnterInfoBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarEnterInfoIsMutable();
                    this.avatarEnterInfo_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarEnterInfo(AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.Builder builderForValue) {
                if (this.avatarEnterInfoBuilder_ == null) {
                    ensureAvatarEnterInfoIsMutable();
                    this.avatarEnterInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarEnterInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarEnterInfo(int index, AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.Builder builderForValue) {
                if (this.avatarEnterInfoBuilder_ == null) {
                    ensureAvatarEnterInfoIsMutable();
                    this.avatarEnterInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarEnterInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatarEnterInfo(Iterable<? extends AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo> values) {
                if (this.avatarEnterInfoBuilder_ == null) {
                    ensureAvatarEnterInfoIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarEnterInfo_);
                    onChanged();
                } else {
                    this.avatarEnterInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatarEnterInfo() {
                if (this.avatarEnterInfoBuilder_ == null) {
                    this.avatarEnterInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.avatarEnterInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatarEnterInfo(int index) {
                if (this.avatarEnterInfoBuilder_ == null) {
                    ensureAvatarEnterInfoIsMutable();
                    this.avatarEnterInfo_.remove(index);
                    onChanged();
                } else {
                    this.avatarEnterInfoBuilder_.remove(index);
                }
                return this;
            }

            public AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.Builder getAvatarEnterInfoBuilder(int index) {
                return getAvatarEnterInfoFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder getAvatarEnterInfoOrBuilder(int index) {
                if (this.avatarEnterInfoBuilder_ == null) {
                    return this.avatarEnterInfo_.get(index);
                }
                return this.avatarEnterInfoBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotifyOrBuilder
            public List<? extends AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder> getAvatarEnterInfoOrBuilderList() {
                if (this.avatarEnterInfoBuilder_ != null) {
                    return this.avatarEnterInfoBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.avatarEnterInfo_);
            }

            public AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.Builder addAvatarEnterInfoBuilder() {
                return getAvatarEnterInfoFieldBuilder().addBuilder(AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.getDefaultInstance());
            }

            public AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.Builder addAvatarEnterInfoBuilder(int index) {
                return getAvatarEnterInfoFieldBuilder().addBuilder(index, AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.getDefaultInstance());
            }

            public List<AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.Builder> getAvatarEnterInfoBuilderList() {
                return getAvatarEnterInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo, AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.Builder, AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder> getAvatarEnterInfoFieldBuilder() {
                if (this.avatarEnterInfoBuilder_ == null) {
                    this.avatarEnterInfoBuilder_ = new RepeatedFieldBuilderV3<>(this.avatarEnterInfo_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.avatarEnterInfo_ = null;
                }
                return this.avatarEnterInfoBuilder_;
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

        public static PlayerEnterSceneInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerEnterSceneInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerEnterSceneInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerEnterSceneInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MPLevelEntityInfoOuterClass.getDescriptor();
        TeamEnterSceneInfoOuterClass.getDescriptor();
        AvatarEnterSceneInfoOuterClass.getDescriptor();
    }
}
