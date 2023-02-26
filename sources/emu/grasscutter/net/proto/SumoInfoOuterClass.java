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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoInfoOuterClass.class */
public final class SumoInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eSumoInfo.proto\"T\n\bSumoInfo\u0012\u001b\n\u0013killEliteMonsterNum\u0018\u0003 \u0001(\r\u0012\u001c\n\u0014killNormalMonsterNum\u0018\u0005 \u0001(\r\u0012\r\n\u0005score\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SumoInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SumoInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SumoInfo_descriptor, new String[]{"KillEliteMonsterNum", "KillNormalMonsterNum", "Score"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoInfoOuterClass$SumoInfoOrBuilder.class */
    public interface SumoInfoOrBuilder extends MessageOrBuilder {
        int getKillEliteMonsterNum();

        int getKillNormalMonsterNum();

        int getScore();
    }

    private SumoInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoInfoOuterClass$SumoInfo.class */
    public static final class SumoInfo extends GeneratedMessageV3 implements SumoInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int KILLELITEMONSTERNUM_FIELD_NUMBER = 3;
        private int killEliteMonsterNum_;
        public static final int KILLNORMALMONSTERNUM_FIELD_NUMBER = 5;
        private int killNormalMonsterNum_;
        public static final int SCORE_FIELD_NUMBER = 4;
        private int score_;
        private byte memoizedIsInitialized;
        private static final SumoInfo DEFAULT_INSTANCE = new SumoInfo();
        private static final Parser<SumoInfo> PARSER = new AbstractParser<SumoInfo>() { // from class: emu.grasscutter.net.proto.SumoInfoOuterClass.SumoInfo.1
            @Override // com.google.protobuf.Parser
            public SumoInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SumoInfo(input, extensionRegistry);
            }
        };

        private SumoInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SumoInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SumoInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SumoInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.killEliteMonsterNum_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.score_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.killNormalMonsterNum_ = input.readUInt32();
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
            return SumoInfoOuterClass.internal_static_SumoInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SumoInfoOuterClass.internal_static_SumoInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SumoInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SumoInfoOuterClass.SumoInfoOrBuilder
        public int getKillEliteMonsterNum() {
            return this.killEliteMonsterNum_;
        }

        @Override // emu.grasscutter.net.proto.SumoInfoOuterClass.SumoInfoOrBuilder
        public int getKillNormalMonsterNum() {
            return this.killNormalMonsterNum_;
        }

        @Override // emu.grasscutter.net.proto.SumoInfoOuterClass.SumoInfoOrBuilder
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
            if (this.killEliteMonsterNum_ != 0) {
                output.writeUInt32(3, this.killEliteMonsterNum_);
            }
            if (this.score_ != 0) {
                output.writeUInt32(4, this.score_);
            }
            if (this.killNormalMonsterNum_ != 0) {
                output.writeUInt32(5, this.killNormalMonsterNum_);
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
            if (this.killEliteMonsterNum_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.killEliteMonsterNum_);
            }
            if (this.score_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.score_);
            }
            if (this.killNormalMonsterNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.killNormalMonsterNum_);
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
            if (!(obj instanceof SumoInfo)) {
                return equals(obj);
            }
            SumoInfo other = (SumoInfo) obj;
            return getKillEliteMonsterNum() == other.getKillEliteMonsterNum() && getKillNormalMonsterNum() == other.getKillNormalMonsterNum() && getScore() == other.getScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getKillEliteMonsterNum())) + 5)) + getKillNormalMonsterNum())) + 4)) + getScore())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SumoInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoInfo parseFrom(InputStream input) throws IOException {
            return (SumoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SumoInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SumoInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SumoInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SumoInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SumoInfo parseFrom(CodedInputStream input) throws IOException {
            return (SumoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SumoInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SumoInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoInfoOuterClass$SumoInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SumoInfoOrBuilder {
            private int killEliteMonsterNum_;
            private int killNormalMonsterNum_;
            private int score_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SumoInfoOuterClass.internal_static_SumoInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SumoInfoOuterClass.internal_static_SumoInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SumoInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SumoInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.killEliteMonsterNum_ = 0;
                this.killNormalMonsterNum_ = 0;
                this.score_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SumoInfoOuterClass.internal_static_SumoInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SumoInfo getDefaultInstanceForType() {
                return SumoInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SumoInfo build() {
                SumoInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SumoInfo buildPartial() {
                SumoInfo result = new SumoInfo(this);
                result.killEliteMonsterNum_ = this.killEliteMonsterNum_;
                result.killNormalMonsterNum_ = this.killNormalMonsterNum_;
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
                if (other instanceof SumoInfo) {
                    return mergeFrom((SumoInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SumoInfo other) {
                if (other == SumoInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getKillEliteMonsterNum() != 0) {
                    setKillEliteMonsterNum(other.getKillEliteMonsterNum());
                }
                if (other.getKillNormalMonsterNum() != 0) {
                    setKillNormalMonsterNum(other.getKillNormalMonsterNum());
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
                SumoInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SumoInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SumoInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SumoInfoOuterClass.SumoInfoOrBuilder
            public int getKillEliteMonsterNum() {
                return this.killEliteMonsterNum_;
            }

            public Builder setKillEliteMonsterNum(int value) {
                this.killEliteMonsterNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillEliteMonsterNum() {
                this.killEliteMonsterNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SumoInfoOuterClass.SumoInfoOrBuilder
            public int getKillNormalMonsterNum() {
                return this.killNormalMonsterNum_;
            }

            public Builder setKillNormalMonsterNum(int value) {
                this.killNormalMonsterNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillNormalMonsterNum() {
                this.killNormalMonsterNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SumoInfoOuterClass.SumoInfoOrBuilder
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

        public static SumoInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SumoInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SumoInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SumoInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
