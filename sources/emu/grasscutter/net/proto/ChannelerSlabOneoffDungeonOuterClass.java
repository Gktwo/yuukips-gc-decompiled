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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabOneoffDungeonOuterClass.class */
public final class ChannelerSlabOneoffDungeonOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n ChannelerSlabOneoffDungeon.proto\"T\n\u001aChannelerSlabOneoffDungeon\u0012\u0012\n\ndungeon_id\u0018\u0006 \u0001(\r\u0012\u000f\n\u0007is_done\u0018\u0001 \u0001(\b\u0012\u0011\n\treward_id\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChannelerSlabOneoffDungeon_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChannelerSlabOneoffDungeon_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChannelerSlabOneoffDungeon_descriptor, new String[]{"DungeonId", "IsDone", "RewardId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabOneoffDungeonOuterClass$ChannelerSlabOneoffDungeonOrBuilder.class */
    public interface ChannelerSlabOneoffDungeonOrBuilder extends MessageOrBuilder {
        int getDungeonId();

        boolean getIsDone();

        int getRewardId();
    }

    private ChannelerSlabOneoffDungeonOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabOneoffDungeonOuterClass$ChannelerSlabOneoffDungeon.class */
    public static final class ChannelerSlabOneoffDungeon extends GeneratedMessageV3 implements ChannelerSlabOneoffDungeonOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DUNGEON_ID_FIELD_NUMBER = 6;
        private int dungeonId_;
        public static final int IS_DONE_FIELD_NUMBER = 1;
        private boolean isDone_;
        public static final int REWARD_ID_FIELD_NUMBER = 5;
        private int rewardId_;
        private byte memoizedIsInitialized;
        private static final ChannelerSlabOneoffDungeon DEFAULT_INSTANCE = new ChannelerSlabOneoffDungeon();
        private static final Parser<ChannelerSlabOneoffDungeon> PARSER = new AbstractParser<ChannelerSlabOneoffDungeon>() { // from class: emu.grasscutter.net.proto.ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.1
            @Override // com.google.protobuf.Parser
            public ChannelerSlabOneoffDungeon parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChannelerSlabOneoffDungeon(input, extensionRegistry);
            }
        };

        private ChannelerSlabOneoffDungeon(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChannelerSlabOneoffDungeon() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChannelerSlabOneoffDungeon();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChannelerSlabOneoffDungeon(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.isDone_ = input.readBool();
                                    break;
                                case 40:
                                    this.rewardId_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.dungeonId_ = input.readUInt32();
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
            return ChannelerSlabOneoffDungeonOuterClass.internal_static_ChannelerSlabOneoffDungeon_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChannelerSlabOneoffDungeonOuterClass.internal_static_ChannelerSlabOneoffDungeon_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabOneoffDungeon.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder
        public int getDungeonId() {
            return this.dungeonId_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder
        public boolean getIsDone() {
            return this.isDone_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder
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
            if (this.isDone_) {
                output.writeBool(1, this.isDone_);
            }
            if (this.rewardId_ != 0) {
                output.writeUInt32(5, this.rewardId_);
            }
            if (this.dungeonId_ != 0) {
                output.writeUInt32(6, this.dungeonId_);
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
            if (this.isDone_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isDone_);
            }
            if (this.rewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.rewardId_);
            }
            if (this.dungeonId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.dungeonId_);
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
            if (!(obj instanceof ChannelerSlabOneoffDungeon)) {
                return equals(obj);
            }
            ChannelerSlabOneoffDungeon other = (ChannelerSlabOneoffDungeon) obj;
            return getDungeonId() == other.getDungeonId() && getIsDone() == other.getIsDone() && getRewardId() == other.getRewardId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getDungeonId())) + 1)) + Internal.hashBoolean(getIsDone()))) + 5)) + getRewardId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ChannelerSlabOneoffDungeon parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabOneoffDungeon parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabOneoffDungeon parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabOneoffDungeon parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabOneoffDungeon parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabOneoffDungeon parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabOneoffDungeon parseFrom(InputStream input) throws IOException {
            return (ChannelerSlabOneoffDungeon) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabOneoffDungeon parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabOneoffDungeon) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabOneoffDungeon parseDelimitedFrom(InputStream input) throws IOException {
            return (ChannelerSlabOneoffDungeon) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChannelerSlabOneoffDungeon parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabOneoffDungeon) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabOneoffDungeon parseFrom(CodedInputStream input) throws IOException {
            return (ChannelerSlabOneoffDungeon) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabOneoffDungeon parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabOneoffDungeon) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChannelerSlabOneoffDungeon prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabOneoffDungeonOuterClass$ChannelerSlabOneoffDungeon$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChannelerSlabOneoffDungeonOrBuilder {
            private int dungeonId_;
            private boolean isDone_;
            private int rewardId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChannelerSlabOneoffDungeonOuterClass.internal_static_ChannelerSlabOneoffDungeon_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChannelerSlabOneoffDungeonOuterClass.internal_static_ChannelerSlabOneoffDungeon_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabOneoffDungeon.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChannelerSlabOneoffDungeon.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dungeonId_ = 0;
                this.isDone_ = false;
                this.rewardId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChannelerSlabOneoffDungeonOuterClass.internal_static_ChannelerSlabOneoffDungeon_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChannelerSlabOneoffDungeon getDefaultInstanceForType() {
                return ChannelerSlabOneoffDungeon.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabOneoffDungeon build() {
                ChannelerSlabOneoffDungeon result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabOneoffDungeon buildPartial() {
                ChannelerSlabOneoffDungeon result = new ChannelerSlabOneoffDungeon(this);
                result.dungeonId_ = this.dungeonId_;
                result.isDone_ = this.isDone_;
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
                if (other instanceof ChannelerSlabOneoffDungeon) {
                    return mergeFrom((ChannelerSlabOneoffDungeon) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChannelerSlabOneoffDungeon other) {
                if (other == ChannelerSlabOneoffDungeon.getDefaultInstance()) {
                    return this;
                }
                if (other.getDungeonId() != 0) {
                    setDungeonId(other.getDungeonId());
                }
                if (other.getIsDone()) {
                    setIsDone(other.getIsDone());
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
                ChannelerSlabOneoffDungeon parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChannelerSlabOneoffDungeon.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChannelerSlabOneoffDungeon) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder
            public boolean getIsDone() {
                return this.isDone_;
            }

            public Builder setIsDone(boolean value) {
                this.isDone_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsDone() {
                this.isDone_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder
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

        public static ChannelerSlabOneoffDungeon getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChannelerSlabOneoffDungeon> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChannelerSlabOneoffDungeon> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChannelerSlabOneoffDungeon getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
