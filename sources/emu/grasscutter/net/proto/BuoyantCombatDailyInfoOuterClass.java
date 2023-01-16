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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatDailyInfoOuterClass.class */
public final class BuoyantCombatDailyInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cBuoyantCombatDailyInfo.proto\"@\n\u0016BuoyantCombatDailyInfo\u0012\u0012\n\nbest_score\u0018\u0005 \u0001(\r\u0012\u0012\n\nstart_time\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BuoyantCombatDailyInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BuoyantCombatDailyInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BuoyantCombatDailyInfo_descriptor, new String[]{"BestScore", "StartTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatDailyInfoOuterClass$BuoyantCombatDailyInfoOrBuilder.class */
    public interface BuoyantCombatDailyInfoOrBuilder extends MessageOrBuilder {
        int getBestScore();

        int getStartTime();
    }

    private BuoyantCombatDailyInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatDailyInfoOuterClass$BuoyantCombatDailyInfo.class */
    public static final class BuoyantCombatDailyInfo extends GeneratedMessageV3 implements BuoyantCombatDailyInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BEST_SCORE_FIELD_NUMBER = 5;
        private int bestScore_;
        public static final int START_TIME_FIELD_NUMBER = 10;
        private int startTime_;
        private byte memoizedIsInitialized;
        private static final BuoyantCombatDailyInfo DEFAULT_INSTANCE = new BuoyantCombatDailyInfo();
        private static final Parser<BuoyantCombatDailyInfo> PARSER = new AbstractParser<BuoyantCombatDailyInfo>() { // from class: emu.grasscutter.net.proto.BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.1
            @Override // com.google.protobuf.Parser
            public BuoyantCombatDailyInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BuoyantCombatDailyInfo(input, extensionRegistry);
            }
        };

        private BuoyantCombatDailyInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BuoyantCombatDailyInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BuoyantCombatDailyInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuoyantCombatDailyInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.bestScore_ = input.readUInt32();
                                break;
                            case 80:
                                this.startTime_ = input.readUInt32();
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
            return BuoyantCombatDailyInfoOuterClass.internal_static_BuoyantCombatDailyInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BuoyantCombatDailyInfoOuterClass.internal_static_BuoyantCombatDailyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BuoyantCombatDailyInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder
        public int getBestScore() {
            return this.bestScore_;
        }

        @Override // emu.grasscutter.net.proto.BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder
        public int getStartTime() {
            return this.startTime_;
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
            if (this.bestScore_ != 0) {
                output.writeUInt32(5, this.bestScore_);
            }
            if (this.startTime_ != 0) {
                output.writeUInt32(10, this.startTime_);
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
            if (this.bestScore_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.bestScore_);
            }
            if (this.startTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.startTime_);
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
            if (!(obj instanceof BuoyantCombatDailyInfo)) {
                return equals(obj);
            }
            BuoyantCombatDailyInfo other = (BuoyantCombatDailyInfo) obj;
            return getBestScore() == other.getBestScore() && getStartTime() == other.getStartTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getBestScore())) + 10)) + getStartTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BuoyantCombatDailyInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuoyantCombatDailyInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuoyantCombatDailyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuoyantCombatDailyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuoyantCombatDailyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuoyantCombatDailyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuoyantCombatDailyInfo parseFrom(InputStream input) throws IOException {
            return (BuoyantCombatDailyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuoyantCombatDailyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuoyantCombatDailyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuoyantCombatDailyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BuoyantCombatDailyInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BuoyantCombatDailyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuoyantCombatDailyInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuoyantCombatDailyInfo parseFrom(CodedInputStream input) throws IOException {
            return (BuoyantCombatDailyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuoyantCombatDailyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuoyantCombatDailyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BuoyantCombatDailyInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatDailyInfoOuterClass$BuoyantCombatDailyInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BuoyantCombatDailyInfoOrBuilder {
            private int bestScore_;
            private int startTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BuoyantCombatDailyInfoOuterClass.internal_static_BuoyantCombatDailyInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BuoyantCombatDailyInfoOuterClass.internal_static_BuoyantCombatDailyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BuoyantCombatDailyInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BuoyantCombatDailyInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.bestScore_ = 0;
                this.startTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BuoyantCombatDailyInfoOuterClass.internal_static_BuoyantCombatDailyInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BuoyantCombatDailyInfo getDefaultInstanceForType() {
                return BuoyantCombatDailyInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuoyantCombatDailyInfo build() {
                BuoyantCombatDailyInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuoyantCombatDailyInfo buildPartial() {
                BuoyantCombatDailyInfo result = new BuoyantCombatDailyInfo(this);
                result.bestScore_ = this.bestScore_;
                result.startTime_ = this.startTime_;
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
                if (other instanceof BuoyantCombatDailyInfo) {
                    return mergeFrom((BuoyantCombatDailyInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BuoyantCombatDailyInfo other) {
                if (other == BuoyantCombatDailyInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getBestScore() != 0) {
                    setBestScore(other.getBestScore());
                }
                if (other.getStartTime() != 0) {
                    setStartTime(other.getStartTime());
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
                BuoyantCombatDailyInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BuoyantCombatDailyInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BuoyantCombatDailyInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder
            public int getBestScore() {
                return this.bestScore_;
            }

            public Builder setBestScore(int value) {
                this.bestScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearBestScore() {
                this.bestScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder
            public int getStartTime() {
                return this.startTime_;
            }

            public Builder setStartTime(int value) {
                this.startTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartTime() {
                this.startTime_ = 0;
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

        public static BuoyantCombatDailyInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BuoyantCombatDailyInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BuoyantCombatDailyInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BuoyantCombatDailyInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
