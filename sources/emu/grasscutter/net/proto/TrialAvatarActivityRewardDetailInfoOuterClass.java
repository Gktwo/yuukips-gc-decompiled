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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarActivityRewardDetailInfoOuterClass.class */
public final class TrialAvatarActivityRewardDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n)TrialAvatarActivityRewardDetailInfo.proto\"\u0001\n#TrialAvatarActivityRewardDetailInfo\u0012\u001d\n\u0015trial_avatar_index_id\u0018\u0004 \u0001(\r\u0012\u0017\n\u000freceived_reward\u0018\u000e \u0001(\b\u0012\u0016\n\u000epassed_dungeon\u0018\u0005 \u0001(\b\u0012\u0011\n\treward_id\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TrialAvatarActivityRewardDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_TrialAvatarActivityRewardDetailInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f897xb9001f8f = new GeneratedMessageV3.FieldAccessorTable(internal_static_TrialAvatarActivityRewardDetailInfo_descriptor, new String[]{"TrialAvatarIndexId", "ReceivedReward", "PassedDungeon", "RewardId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarActivityRewardDetailInfoOuterClass$TrialAvatarActivityRewardDetailInfoOrBuilder.class */
    public interface TrialAvatarActivityRewardDetailInfoOrBuilder extends MessageOrBuilder {
        int getTrialAvatarIndexId();

        boolean getReceivedReward();

        boolean getPassedDungeon();

        int getRewardId();
    }

    private TrialAvatarActivityRewardDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarActivityRewardDetailInfoOuterClass$TrialAvatarActivityRewardDetailInfo.class */
    public static final class TrialAvatarActivityRewardDetailInfo extends GeneratedMessageV3 implements TrialAvatarActivityRewardDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TRIAL_AVATAR_INDEX_ID_FIELD_NUMBER = 4;
        private int trialAvatarIndexId_;
        public static final int RECEIVED_REWARD_FIELD_NUMBER = 14;
        private boolean receivedReward_;
        public static final int PASSED_DUNGEON_FIELD_NUMBER = 5;
        private boolean passedDungeon_;
        public static final int REWARD_ID_FIELD_NUMBER = 11;
        private int rewardId_;
        private byte memoizedIsInitialized;
        private static final TrialAvatarActivityRewardDetailInfo DEFAULT_INSTANCE = new TrialAvatarActivityRewardDetailInfo();
        private static final Parser<TrialAvatarActivityRewardDetailInfo> PARSER = new AbstractParser<TrialAvatarActivityRewardDetailInfo>() { // from class: emu.grasscutter.net.proto.TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.1
            @Override // com.google.protobuf.Parser
            public TrialAvatarActivityRewardDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TrialAvatarActivityRewardDetailInfo(input, extensionRegistry);
            }
        };

        private TrialAvatarActivityRewardDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TrialAvatarActivityRewardDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TrialAvatarActivityRewardDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TrialAvatarActivityRewardDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.trialAvatarIndexId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.passedDungeon_ = input.readBool();
                                    break;
                                case 88:
                                    this.rewardId_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.receivedReward_ = input.readBool();
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
            return TrialAvatarActivityRewardDetailInfoOuterClass.internal_static_TrialAvatarActivityRewardDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TrialAvatarActivityRewardDetailInfoOuterClass.f897xb9001f8f.ensureFieldAccessorsInitialized(TrialAvatarActivityRewardDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder
        public int getTrialAvatarIndexId() {
            return this.trialAvatarIndexId_;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder
        public boolean getReceivedReward() {
            return this.receivedReward_;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder
        public boolean getPassedDungeon() {
            return this.passedDungeon_;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder
        public int getRewardId() {
            return this.rewardId_;
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
            if (this.trialAvatarIndexId_ != 0) {
                output.writeUInt32(4, this.trialAvatarIndexId_);
            }
            if (this.passedDungeon_) {
                output.writeBool(5, this.passedDungeon_);
            }
            if (this.rewardId_ != 0) {
                output.writeUInt32(11, this.rewardId_);
            }
            if (this.receivedReward_) {
                output.writeBool(14, this.receivedReward_);
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
            if (this.trialAvatarIndexId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.trialAvatarIndexId_);
            }
            if (this.passedDungeon_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.passedDungeon_);
            }
            if (this.rewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.rewardId_);
            }
            if (this.receivedReward_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.receivedReward_);
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
            if (!(obj instanceof TrialAvatarActivityRewardDetailInfo)) {
                return equals(obj);
            }
            TrialAvatarActivityRewardDetailInfo other = (TrialAvatarActivityRewardDetailInfo) obj;
            return getTrialAvatarIndexId() == other.getTrialAvatarIndexId() && getReceivedReward() == other.getReceivedReward() && getPassedDungeon() == other.getPassedDungeon() && getRewardId() == other.getRewardId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getTrialAvatarIndexId())) + 14)) + Internal.hashBoolean(getReceivedReward()))) + 5)) + Internal.hashBoolean(getPassedDungeon()))) + 11)) + getRewardId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TrialAvatarActivityRewardDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarActivityRewardDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarActivityRewardDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarActivityRewardDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarActivityRewardDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarActivityRewardDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarActivityRewardDetailInfo parseFrom(InputStream input) throws IOException {
            return (TrialAvatarActivityRewardDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrialAvatarActivityRewardDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarActivityRewardDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrialAvatarActivityRewardDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TrialAvatarActivityRewardDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TrialAvatarActivityRewardDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarActivityRewardDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrialAvatarActivityRewardDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (TrialAvatarActivityRewardDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrialAvatarActivityRewardDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarActivityRewardDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TrialAvatarActivityRewardDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarActivityRewardDetailInfoOuterClass$TrialAvatarActivityRewardDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TrialAvatarActivityRewardDetailInfoOrBuilder {
            private int trialAvatarIndexId_;
            private boolean receivedReward_;
            private boolean passedDungeon_;
            private int rewardId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TrialAvatarActivityRewardDetailInfoOuterClass.internal_static_TrialAvatarActivityRewardDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TrialAvatarActivityRewardDetailInfoOuterClass.f897xb9001f8f.ensureFieldAccessorsInitialized(TrialAvatarActivityRewardDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TrialAvatarActivityRewardDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.trialAvatarIndexId_ = 0;
                this.receivedReward_ = false;
                this.passedDungeon_ = false;
                this.rewardId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TrialAvatarActivityRewardDetailInfoOuterClass.internal_static_TrialAvatarActivityRewardDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TrialAvatarActivityRewardDetailInfo getDefaultInstanceForType() {
                return TrialAvatarActivityRewardDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrialAvatarActivityRewardDetailInfo build() {
                TrialAvatarActivityRewardDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrialAvatarActivityRewardDetailInfo buildPartial() {
                TrialAvatarActivityRewardDetailInfo result = new TrialAvatarActivityRewardDetailInfo(this);
                result.trialAvatarIndexId_ = this.trialAvatarIndexId_;
                result.receivedReward_ = this.receivedReward_;
                result.passedDungeon_ = this.passedDungeon_;
                result.rewardId_ = this.rewardId_;
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
                if (other instanceof TrialAvatarActivityRewardDetailInfo) {
                    return mergeFrom((TrialAvatarActivityRewardDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TrialAvatarActivityRewardDetailInfo other) {
                if (other == TrialAvatarActivityRewardDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getTrialAvatarIndexId() != 0) {
                    setTrialAvatarIndexId(other.getTrialAvatarIndexId());
                }
                if (other.getReceivedReward()) {
                    setReceivedReward(other.getReceivedReward());
                }
                if (other.getPassedDungeon()) {
                    setPassedDungeon(other.getPassedDungeon());
                }
                if (other.getRewardId() != 0) {
                    setRewardId(other.getRewardId());
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
                TrialAvatarActivityRewardDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TrialAvatarActivityRewardDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TrialAvatarActivityRewardDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder
            public int getTrialAvatarIndexId() {
                return this.trialAvatarIndexId_;
            }

            public Builder setTrialAvatarIndexId(int value) {
                this.trialAvatarIndexId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTrialAvatarIndexId() {
                this.trialAvatarIndexId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder
            public boolean getReceivedReward() {
                return this.receivedReward_;
            }

            public Builder setReceivedReward(boolean value) {
                this.receivedReward_ = value;
                onChanged();
                return this;
            }

            public Builder clearReceivedReward() {
                this.receivedReward_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder
            public boolean getPassedDungeon() {
                return this.passedDungeon_;
            }

            public Builder setPassedDungeon(boolean value) {
                this.passedDungeon_ = value;
                onChanged();
                return this;
            }

            public Builder clearPassedDungeon() {
                this.passedDungeon_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder
            public int getRewardId() {
                return this.rewardId_;
            }

            public Builder setRewardId(int value) {
                this.rewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRewardId() {
                this.rewardId_ = 0;
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

        public static TrialAvatarActivityRewardDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TrialAvatarActivityRewardDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TrialAvatarActivityRewardDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TrialAvatarActivityRewardDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
