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
import emu.grasscutter.net.proto.FriendEnterHomeOptionOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerHomeCompInfoOuterClass.class */
public final class PlayerHomeCompInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018PlayerHomeCompInfo.proto\u001a\u001bFriendEnterHomeOption.proto\"¦\u0001\n\u0012PlayerHomeCompInfo\u0012\u0018\n\u0010seenModuleIdList\u0018\u0002 \u0003(\r\u00125\n\u0015friendEnterHomeOption\u0018\u0004 \u0001(\u000e2\u0016.FriendEnterHomeOption\u0012\u001c\n\u0014unlockedModuleIdList\u0018\n \u0003(\r\u0012!\n\u0019levelupRewardGotLevelList\u0018\f \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FriendEnterHomeOptionOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerHomeCompInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerHomeCompInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerHomeCompInfo_descriptor, new String[]{"SeenModuleIdList", "FriendEnterHomeOption", "UnlockedModuleIdList", "LevelupRewardGotLevelList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerHomeCompInfoOuterClass$PlayerHomeCompInfoOrBuilder.class */
    public interface PlayerHomeCompInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getSeenModuleIdListList();

        int getSeenModuleIdListCount();

        int getSeenModuleIdList(int i);

        int getFriendEnterHomeOptionValue();

        FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getFriendEnterHomeOption();

        List<Integer> getUnlockedModuleIdListList();

        int getUnlockedModuleIdListCount();

        int getUnlockedModuleIdList(int i);

        List<Integer> getLevelupRewardGotLevelListList();

        int getLevelupRewardGotLevelListCount();

        int getLevelupRewardGotLevelList(int i);
    }

    private PlayerHomeCompInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerHomeCompInfoOuterClass$PlayerHomeCompInfo.class */
    public static final class PlayerHomeCompInfo extends GeneratedMessageV3 implements PlayerHomeCompInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SEENMODULEIDLIST_FIELD_NUMBER = 2;
        private Internal.IntList seenModuleIdList_;
        private int seenModuleIdListMemoizedSerializedSize;
        public static final int FRIENDENTERHOMEOPTION_FIELD_NUMBER = 4;
        private int friendEnterHomeOption_;
        public static final int UNLOCKEDMODULEIDLIST_FIELD_NUMBER = 10;
        private Internal.IntList unlockedModuleIdList_;
        private int unlockedModuleIdListMemoizedSerializedSize;
        public static final int LEVELUPREWARDGOTLEVELLIST_FIELD_NUMBER = 12;
        private Internal.IntList levelupRewardGotLevelList_;
        private int levelupRewardGotLevelListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final PlayerHomeCompInfo DEFAULT_INSTANCE = new PlayerHomeCompInfo();
        private static final Parser<PlayerHomeCompInfo> PARSER = new AbstractParser<PlayerHomeCompInfo>() { // from class: emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.1
            @Override // com.google.protobuf.Parser
            public PlayerHomeCompInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerHomeCompInfo(input, extensionRegistry);
            }
        };

        private PlayerHomeCompInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.seenModuleIdListMemoizedSerializedSize = -1;
            this.unlockedModuleIdListMemoizedSerializedSize = -1;
            this.levelupRewardGotLevelListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private PlayerHomeCompInfo() {
            this.seenModuleIdListMemoizedSerializedSize = -1;
            this.unlockedModuleIdListMemoizedSerializedSize = -1;
            this.levelupRewardGotLevelListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.seenModuleIdList_ = emptyIntList();
            this.friendEnterHomeOption_ = 0;
            this.unlockedModuleIdList_ = emptyIntList();
            this.levelupRewardGotLevelList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerHomeCompInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:101:0x01ca */
        private PlayerHomeCompInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.seenModuleIdList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.seenModuleIdList_.addInt(input.readUInt32());
                                    break;
                                case 18:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.seenModuleIdList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.seenModuleIdList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 32:
                                    this.friendEnterHomeOption_ = input.readEnum();
                                    break;
                                case 80:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.unlockedModuleIdList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.unlockedModuleIdList_.addInt(input.readUInt32());
                                    break;
                                case 82:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unlockedModuleIdList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unlockedModuleIdList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 96:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.levelupRewardGotLevelList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.levelupRewardGotLevelList_.addInt(input.readUInt32());
                                    break;
                                case 98:
                                    int limit3 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.levelupRewardGotLevelList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.levelupRewardGotLevelList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit3);
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                            done = done;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.seenModuleIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unlockedModuleIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.levelupRewardGotLevelList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerHomeCompInfoOuterClass.internal_static_PlayerHomeCompInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerHomeCompInfoOuterClass.internal_static_PlayerHomeCompInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerHomeCompInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public List<Integer> getSeenModuleIdListList() {
            return this.seenModuleIdList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public int getSeenModuleIdListCount() {
            return this.seenModuleIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public int getSeenModuleIdList(int index) {
            return this.seenModuleIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public int getFriendEnterHomeOptionValue() {
            return this.friendEnterHomeOption_;
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getFriendEnterHomeOption() {
            FriendEnterHomeOptionOuterClass.FriendEnterHomeOption result = FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.valueOf(this.friendEnterHomeOption_);
            return result == null ? FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public List<Integer> getUnlockedModuleIdListList() {
            return this.unlockedModuleIdList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public int getUnlockedModuleIdListCount() {
            return this.unlockedModuleIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public int getUnlockedModuleIdList(int index) {
            return this.unlockedModuleIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public List<Integer> getLevelupRewardGotLevelListList() {
            return this.levelupRewardGotLevelList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public int getLevelupRewardGotLevelListCount() {
            return this.levelupRewardGotLevelList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
        public int getLevelupRewardGotLevelList(int index) {
            return this.levelupRewardGotLevelList_.getInt(index);
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
            getSerializedSize();
            if (getSeenModuleIdListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.seenModuleIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.seenModuleIdList_.size(); i++) {
                output.writeUInt32NoTag(this.seenModuleIdList_.getInt(i));
            }
            if (this.friendEnterHomeOption_ != FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM.getNumber()) {
                output.writeEnum(4, this.friendEnterHomeOption_);
            }
            if (getUnlockedModuleIdListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.unlockedModuleIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unlockedModuleIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.unlockedModuleIdList_.getInt(i2));
            }
            if (getLevelupRewardGotLevelListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.levelupRewardGotLevelListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.levelupRewardGotLevelList_.size(); i3++) {
                output.writeUInt32NoTag(this.levelupRewardGotLevelList_.getInt(i3));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.seenModuleIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.seenModuleIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getSeenModuleIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.seenModuleIdListMemoizedSerializedSize = dataSize;
            if (this.friendEnterHomeOption_ != FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(4, this.friendEnterHomeOption_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unlockedModuleIdList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unlockedModuleIdList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUnlockedModuleIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unlockedModuleIdListMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.levelupRewardGotLevelList_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.levelupRewardGotLevelList_.getInt(i3));
            }
            int size4 = size3 + dataSize3;
            if (!getLevelupRewardGotLevelListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.levelupRewardGotLevelListMemoizedSerializedSize = dataSize3;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PlayerHomeCompInfo)) {
                return equals(obj);
            }
            PlayerHomeCompInfo other = (PlayerHomeCompInfo) obj;
            return getSeenModuleIdListList().equals(other.getSeenModuleIdListList()) && this.friendEnterHomeOption_ == other.friendEnterHomeOption_ && getUnlockedModuleIdListList().equals(other.getUnlockedModuleIdListList()) && getLevelupRewardGotLevelListList().equals(other.getLevelupRewardGotLevelListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getSeenModuleIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getSeenModuleIdListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 4)) + this.friendEnterHomeOption_;
            if (getUnlockedModuleIdListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 10)) + getUnlockedModuleIdListList().hashCode();
            }
            if (getLevelupRewardGotLevelListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 12)) + getLevelupRewardGotLevelListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PlayerHomeCompInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerHomeCompInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerHomeCompInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerHomeCompInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerHomeCompInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerHomeCompInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerHomeCompInfo parseFrom(InputStream input) throws IOException {
            return (PlayerHomeCompInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerHomeCompInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerHomeCompInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerHomeCompInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerHomeCompInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerHomeCompInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerHomeCompInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerHomeCompInfo parseFrom(CodedInputStream input) throws IOException {
            return (PlayerHomeCompInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerHomeCompInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerHomeCompInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerHomeCompInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerHomeCompInfoOuterClass$PlayerHomeCompInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerHomeCompInfoOrBuilder {
            private int bitField0_;
            private Internal.IntList seenModuleIdList_ = PlayerHomeCompInfo.emptyIntList();
            private int friendEnterHomeOption_ = 0;
            private Internal.IntList unlockedModuleIdList_ = PlayerHomeCompInfo.emptyIntList();
            private Internal.IntList levelupRewardGotLevelList_ = PlayerHomeCompInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerHomeCompInfoOuterClass.internal_static_PlayerHomeCompInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerHomeCompInfoOuterClass.internal_static_PlayerHomeCompInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerHomeCompInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerHomeCompInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.seenModuleIdList_ = PlayerHomeCompInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.friendEnterHomeOption_ = 0;
                this.unlockedModuleIdList_ = PlayerHomeCompInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.levelupRewardGotLevelList_ = PlayerHomeCompInfo.emptyIntList();
                this.bitField0_ &= -5;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerHomeCompInfoOuterClass.internal_static_PlayerHomeCompInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerHomeCompInfo getDefaultInstanceForType() {
                return PlayerHomeCompInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerHomeCompInfo build() {
                PlayerHomeCompInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerHomeCompInfo buildPartial() {
                PlayerHomeCompInfo result = new PlayerHomeCompInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.seenModuleIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.seenModuleIdList_ = this.seenModuleIdList_;
                result.friendEnterHomeOption_ = this.friendEnterHomeOption_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unlockedModuleIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unlockedModuleIdList_ = this.unlockedModuleIdList_;
                if ((this.bitField0_ & 4) != 0) {
                    this.levelupRewardGotLevelList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.levelupRewardGotLevelList_ = this.levelupRewardGotLevelList_;
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
                if (other instanceof PlayerHomeCompInfo) {
                    return mergeFrom((PlayerHomeCompInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerHomeCompInfo other) {
                if (other == PlayerHomeCompInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.seenModuleIdList_.isEmpty()) {
                    if (this.seenModuleIdList_.isEmpty()) {
                        this.seenModuleIdList_ = other.seenModuleIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureSeenModuleIdListIsMutable();
                        this.seenModuleIdList_.addAll(other.seenModuleIdList_);
                    }
                    onChanged();
                }
                if (other.friendEnterHomeOption_ != 0) {
                    setFriendEnterHomeOptionValue(other.getFriendEnterHomeOptionValue());
                }
                if (!other.unlockedModuleIdList_.isEmpty()) {
                    if (this.unlockedModuleIdList_.isEmpty()) {
                        this.unlockedModuleIdList_ = other.unlockedModuleIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnlockedModuleIdListIsMutable();
                        this.unlockedModuleIdList_.addAll(other.unlockedModuleIdList_);
                    }
                    onChanged();
                }
                if (!other.levelupRewardGotLevelList_.isEmpty()) {
                    if (this.levelupRewardGotLevelList_.isEmpty()) {
                        this.levelupRewardGotLevelList_ = other.levelupRewardGotLevelList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureLevelupRewardGotLevelListIsMutable();
                        this.levelupRewardGotLevelList_.addAll(other.levelupRewardGotLevelList_);
                    }
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
                PlayerHomeCompInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerHomeCompInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerHomeCompInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureSeenModuleIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.seenModuleIdList_ = PlayerHomeCompInfo.mutableCopy(this.seenModuleIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public List<Integer> getSeenModuleIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.seenModuleIdList_) : this.seenModuleIdList_;
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public int getSeenModuleIdListCount() {
                return this.seenModuleIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public int getSeenModuleIdList(int index) {
                return this.seenModuleIdList_.getInt(index);
            }

            public Builder setSeenModuleIdList(int index, int value) {
                ensureSeenModuleIdListIsMutable();
                this.seenModuleIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addSeenModuleIdList(int value) {
                ensureSeenModuleIdListIsMutable();
                this.seenModuleIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllSeenModuleIdList(Iterable<? extends Integer> values) {
                ensureSeenModuleIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.seenModuleIdList_);
                onChanged();
                return this;
            }

            public Builder clearSeenModuleIdList() {
                this.seenModuleIdList_ = PlayerHomeCompInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public int getFriendEnterHomeOptionValue() {
                return this.friendEnterHomeOption_;
            }

            public Builder setFriendEnterHomeOptionValue(int value) {
                this.friendEnterHomeOption_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getFriendEnterHomeOption() {
                FriendEnterHomeOptionOuterClass.FriendEnterHomeOption result = FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.valueOf(this.friendEnterHomeOption_);
                return result == null ? FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.UNRECOGNIZED : result;
            }

            public Builder setFriendEnterHomeOption(FriendEnterHomeOptionOuterClass.FriendEnterHomeOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.friendEnterHomeOption_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFriendEnterHomeOption() {
                this.friendEnterHomeOption_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnlockedModuleIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unlockedModuleIdList_ = PlayerHomeCompInfo.mutableCopy(this.unlockedModuleIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public List<Integer> getUnlockedModuleIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unlockedModuleIdList_) : this.unlockedModuleIdList_;
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public int getUnlockedModuleIdListCount() {
                return this.unlockedModuleIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public int getUnlockedModuleIdList(int index) {
                return this.unlockedModuleIdList_.getInt(index);
            }

            public Builder setUnlockedModuleIdList(int index, int value) {
                ensureUnlockedModuleIdListIsMutable();
                this.unlockedModuleIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockedModuleIdList(int value) {
                ensureUnlockedModuleIdListIsMutable();
                this.unlockedModuleIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockedModuleIdList(Iterable<? extends Integer> values) {
                ensureUnlockedModuleIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockedModuleIdList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockedModuleIdList() {
                this.unlockedModuleIdList_ = PlayerHomeCompInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureLevelupRewardGotLevelListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.levelupRewardGotLevelList_ = PlayerHomeCompInfo.mutableCopy(this.levelupRewardGotLevelList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public List<Integer> getLevelupRewardGotLevelListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.levelupRewardGotLevelList_) : this.levelupRewardGotLevelList_;
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public int getLevelupRewardGotLevelListCount() {
                return this.levelupRewardGotLevelList_.size();
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder
            public int getLevelupRewardGotLevelList(int index) {
                return this.levelupRewardGotLevelList_.getInt(index);
            }

            public Builder setLevelupRewardGotLevelList(int index, int value) {
                ensureLevelupRewardGotLevelListIsMutable();
                this.levelupRewardGotLevelList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLevelupRewardGotLevelList(int value) {
                ensureLevelupRewardGotLevelListIsMutable();
                this.levelupRewardGotLevelList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLevelupRewardGotLevelList(Iterable<? extends Integer> values) {
                ensureLevelupRewardGotLevelListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.levelupRewardGotLevelList_);
                onChanged();
                return this;
            }

            public Builder clearLevelupRewardGotLevelList() {
                this.levelupRewardGotLevelList_ = PlayerHomeCompInfo.emptyIntList();
                this.bitField0_ &= -5;
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

        public static PlayerHomeCompInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerHomeCompInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerHomeCompInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerHomeCompInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FriendEnterHomeOptionOuterClass.getDescriptor();
    }
}
