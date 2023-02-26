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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatInfoOuterClass.class */
public final class BuoyantCombatInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017BuoyantCombatInfo.proto\"]\n\u0011BuoyantCombatInfo\u0012\u0018\n\u0010killMonsterCount\u0018\u0003 \u0001(\r\u0012\u001f\n\u0017killSpecialMonsterCount\u0018\u000f \u0001(\r\u0012\r\n\u0005score\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BuoyantCombatInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BuoyantCombatInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BuoyantCombatInfo_descriptor, new String[]{"KillMonsterCount", "KillSpecialMonsterCount", "Score"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatInfoOuterClass$BuoyantCombatInfoOrBuilder.class */
    public interface BuoyantCombatInfoOrBuilder extends MessageOrBuilder {
        int getKillMonsterCount();

        int getKillSpecialMonsterCount();

        int getScore();
    }

    private BuoyantCombatInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatInfoOuterClass$BuoyantCombatInfo.class */
    public static final class BuoyantCombatInfo extends GeneratedMessageV3 implements BuoyantCombatInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int KILLMONSTERCOUNT_FIELD_NUMBER = 3;
        private int killMonsterCount_;
        public static final int KILLSPECIALMONSTERCOUNT_FIELD_NUMBER = 15;
        private int killSpecialMonsterCount_;
        public static final int SCORE_FIELD_NUMBER = 12;
        private int score_;
        private byte memoizedIsInitialized;
        private static final BuoyantCombatInfo DEFAULT_INSTANCE = new BuoyantCombatInfo();
        private static final Parser<BuoyantCombatInfo> PARSER = new AbstractParser<BuoyantCombatInfo>() { // from class: emu.grasscutter.net.proto.BuoyantCombatInfoOuterClass.BuoyantCombatInfo.1
            @Override // com.google.protobuf.Parser
            public BuoyantCombatInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BuoyantCombatInfo(input, extensionRegistry);
            }
        };

        private BuoyantCombatInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BuoyantCombatInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BuoyantCombatInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuoyantCombatInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.killMonsterCount_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.score_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.killSpecialMonsterCount_ = input.readUInt32();
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
            return BuoyantCombatInfoOuterClass.internal_static_BuoyantCombatInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BuoyantCombatInfoOuterClass.internal_static_BuoyantCombatInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BuoyantCombatInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder
        public int getKillMonsterCount() {
            return this.killMonsterCount_;
        }

        @Override // emu.grasscutter.net.proto.BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder
        public int getKillSpecialMonsterCount() {
            return this.killSpecialMonsterCount_;
        }

        @Override // emu.grasscutter.net.proto.BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder
        public int getScore() {
            return this.score_;
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
            if (this.killMonsterCount_ != 0) {
                output.writeUInt32(3, this.killMonsterCount_);
            }
            if (this.score_ != 0) {
                output.writeUInt32(12, this.score_);
            }
            if (this.killSpecialMonsterCount_ != 0) {
                output.writeUInt32(15, this.killSpecialMonsterCount_);
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
            if (this.killMonsterCount_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.killMonsterCount_);
            }
            if (this.score_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.score_);
            }
            if (this.killSpecialMonsterCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.killSpecialMonsterCount_);
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
            if (!(obj instanceof BuoyantCombatInfo)) {
                return equals(obj);
            }
            BuoyantCombatInfo other = (BuoyantCombatInfo) obj;
            return getKillMonsterCount() == other.getKillMonsterCount() && getKillSpecialMonsterCount() == other.getKillSpecialMonsterCount() && getScore() == other.getScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getKillMonsterCount())) + 15)) + getKillSpecialMonsterCount())) + 12)) + getScore())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BuoyantCombatInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuoyantCombatInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuoyantCombatInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuoyantCombatInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuoyantCombatInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuoyantCombatInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuoyantCombatInfo parseFrom(InputStream input) throws IOException {
            return (BuoyantCombatInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuoyantCombatInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuoyantCombatInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuoyantCombatInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BuoyantCombatInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BuoyantCombatInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuoyantCombatInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuoyantCombatInfo parseFrom(CodedInputStream input) throws IOException {
            return (BuoyantCombatInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuoyantCombatInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuoyantCombatInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BuoyantCombatInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatInfoOuterClass$BuoyantCombatInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BuoyantCombatInfoOrBuilder {
            private int killMonsterCount_;
            private int killSpecialMonsterCount_;
            private int score_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BuoyantCombatInfoOuterClass.internal_static_BuoyantCombatInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BuoyantCombatInfoOuterClass.internal_static_BuoyantCombatInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BuoyantCombatInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BuoyantCombatInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.killMonsterCount_ = 0;
                this.killSpecialMonsterCount_ = 0;
                this.score_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BuoyantCombatInfoOuterClass.internal_static_BuoyantCombatInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BuoyantCombatInfo getDefaultInstanceForType() {
                return BuoyantCombatInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuoyantCombatInfo build() {
                BuoyantCombatInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuoyantCombatInfo buildPartial() {
                BuoyantCombatInfo result = new BuoyantCombatInfo(this);
                result.killMonsterCount_ = this.killMonsterCount_;
                result.killSpecialMonsterCount_ = this.killSpecialMonsterCount_;
                result.score_ = this.score_;
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
                if (other instanceof BuoyantCombatInfo) {
                    return mergeFrom((BuoyantCombatInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BuoyantCombatInfo other) {
                if (other == BuoyantCombatInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getKillMonsterCount() != 0) {
                    setKillMonsterCount(other.getKillMonsterCount());
                }
                if (other.getKillSpecialMonsterCount() != 0) {
                    setKillSpecialMonsterCount(other.getKillSpecialMonsterCount());
                }
                if (other.getScore() != 0) {
                    setScore(other.getScore());
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
                BuoyantCombatInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BuoyantCombatInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BuoyantCombatInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder
            public int getKillMonsterCount() {
                return this.killMonsterCount_;
            }

            public Builder setKillMonsterCount(int value) {
                this.killMonsterCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillMonsterCount() {
                this.killMonsterCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder
            public int getKillSpecialMonsterCount() {
                return this.killSpecialMonsterCount_;
            }

            public Builder setKillSpecialMonsterCount(int value) {
                this.killSpecialMonsterCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillSpecialMonsterCount() {
                this.killSpecialMonsterCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder
            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.score_ = 0;
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

        public static BuoyantCombatInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BuoyantCombatInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BuoyantCombatInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BuoyantCombatInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
