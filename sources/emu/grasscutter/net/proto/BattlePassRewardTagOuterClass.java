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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.BattlePassUnlockStatusOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassRewardTagOuterClass.class */
public final class BattlePassRewardTagOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019BattlePassRewardTag.proto\u001a\u001cBattlePassUnlockStatus.proto\"e\n\u0013BattlePassRewardTag\u0012\r\n\u0005level\u0018\b \u0001(\r\u0012-\n\funlockStatus\u0018\r \u0001(\u000e2\u0017.BattlePassUnlockStatus\u0012\u0010\n\brewardId\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BattlePassUnlockStatusOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BattlePassRewardTag_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BattlePassRewardTag_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BattlePassRewardTag_descriptor, new String[]{"Level", "UnlockStatus", "RewardId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassRewardTagOuterClass$BattlePassRewardTagOrBuilder.class */
    public interface BattlePassRewardTagOrBuilder extends MessageOrBuilder {
        int getLevel();

        int getUnlockStatusValue();

        BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus getUnlockStatus();

        int getRewardId();
    }

    private BattlePassRewardTagOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassRewardTagOuterClass$BattlePassRewardTag.class */
    public static final class BattlePassRewardTag extends GeneratedMessageV3 implements BattlePassRewardTagOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVEL_FIELD_NUMBER = 8;
        private int level_;
        public static final int UNLOCKSTATUS_FIELD_NUMBER = 13;
        private int unlockStatus_;
        public static final int REWARDID_FIELD_NUMBER = 15;
        private int rewardId_;
        private byte memoizedIsInitialized;
        private static final BattlePassRewardTag DEFAULT_INSTANCE = new BattlePassRewardTag();
        private static final Parser<BattlePassRewardTag> PARSER = new AbstractParser<BattlePassRewardTag>() { // from class: emu.grasscutter.net.proto.BattlePassRewardTagOuterClass.BattlePassRewardTag.1
            @Override // com.google.protobuf.Parser
            public BattlePassRewardTag parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattlePassRewardTag(input, extensionRegistry);
            }
        };

        private BattlePassRewardTag(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BattlePassRewardTag() {
            this.memoizedIsInitialized = -1;
            this.unlockStatus_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BattlePassRewardTag();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattlePassRewardTag(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 64:
                                this.level_ = input.readUInt32();
                                break;
                            case 104:
                                this.unlockStatus_ = input.readEnum();
                                break;
                            case 120:
                                this.rewardId_ = input.readUInt32();
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
            return BattlePassRewardTagOuterClass.internal_static_BattlePassRewardTag_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattlePassRewardTagOuterClass.internal_static_BattlePassRewardTag_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassRewardTag.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder
        public int getUnlockStatusValue() {
            return this.unlockStatus_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder
        public BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus getUnlockStatus() {
            BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus result = BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.valueOf(this.unlockStatus_);
            return result == null ? BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder
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
            if (this.level_ != 0) {
                output.writeUInt32(8, this.level_);
            }
            if (this.unlockStatus_ != BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.BATTLE_PASS_UNLOCK_STATUS_INVALID.getNumber()) {
                output.writeEnum(13, this.unlockStatus_);
            }
            if (this.rewardId_ != 0) {
                output.writeUInt32(15, this.rewardId_);
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
            if (this.level_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.level_);
            }
            if (this.unlockStatus_ != BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.BATTLE_PASS_UNLOCK_STATUS_INVALID.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(13, this.unlockStatus_);
            }
            if (this.rewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.rewardId_);
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
            if (!(obj instanceof BattlePassRewardTag)) {
                return equals(obj);
            }
            BattlePassRewardTag other = (BattlePassRewardTag) obj;
            return getLevel() == other.getLevel() && this.unlockStatus_ == other.unlockStatus_ && getRewardId() == other.getRewardId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getLevel())) + 13)) + this.unlockStatus_)) + 15)) + getRewardId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BattlePassRewardTag parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassRewardTag parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassRewardTag parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassRewardTag parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassRewardTag parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassRewardTag parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassRewardTag parseFrom(InputStream input) throws IOException {
            return (BattlePassRewardTag) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassRewardTag parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassRewardTag) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassRewardTag parseDelimitedFrom(InputStream input) throws IOException {
            return (BattlePassRewardTag) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BattlePassRewardTag parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassRewardTag) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassRewardTag parseFrom(CodedInputStream input) throws IOException {
            return (BattlePassRewardTag) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassRewardTag parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassRewardTag) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BattlePassRewardTag prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassRewardTagOuterClass$BattlePassRewardTag$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BattlePassRewardTagOrBuilder {
            private int level_;
            private int unlockStatus_ = 0;
            private int rewardId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BattlePassRewardTagOuterClass.internal_static_BattlePassRewardTag_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattlePassRewardTagOuterClass.internal_static_BattlePassRewardTag_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassRewardTag.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattlePassRewardTag.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.level_ = 0;
                this.unlockStatus_ = 0;
                this.rewardId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BattlePassRewardTagOuterClass.internal_static_BattlePassRewardTag_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BattlePassRewardTag getDefaultInstanceForType() {
                return BattlePassRewardTag.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassRewardTag build() {
                BattlePassRewardTag result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassRewardTag buildPartial() {
                BattlePassRewardTag result = new BattlePassRewardTag(this);
                result.level_ = this.level_;
                result.unlockStatus_ = this.unlockStatus_;
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
                if (other instanceof BattlePassRewardTag) {
                    return mergeFrom((BattlePassRewardTag) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattlePassRewardTag other) {
                if (other == BattlePassRewardTag.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.unlockStatus_ != 0) {
                    setUnlockStatusValue(other.getUnlockStatusValue());
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
                BattlePassRewardTag parsedMessage = null;
                try {
                    try {
                        parsedMessage = BattlePassRewardTag.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BattlePassRewardTag) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder
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

            @Override // emu.grasscutter.net.proto.BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder
            public int getUnlockStatusValue() {
                return this.unlockStatus_;
            }

            public Builder setUnlockStatusValue(int value) {
                this.unlockStatus_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder
            public BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus getUnlockStatus() {
                BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus result = BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.valueOf(this.unlockStatus_);
                return result == null ? BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.UNRECOGNIZED : result;
            }

            public Builder setUnlockStatus(BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unlockStatus_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearUnlockStatus() {
                this.unlockStatus_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder
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

        public static BattlePassRewardTag getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BattlePassRewardTag> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BattlePassRewardTag> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BattlePassRewardTag getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BattlePassUnlockStatusOuterClass.getDescriptor();
    }
}
