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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMusicGameSettleReqOuterClass.class */
public final class FleurFairMusicGameSettleReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!FleurFairMusicGameSettleReq.proto\"h\n\u001bFleurFairMusicGameSettleReq\u0012\r\n\u0005score\u0018\u0001 \u0001(\r\u0012\u0013\n\u000bcorrect_hit\u0018\n \u0001(\r\u0012\r\n\u0005combo\u0018\u0003 \u0001(\r\u0012\u0016\n\u000emusic_basic_id\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FleurFairMusicGameSettleReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FleurFairMusicGameSettleReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FleurFairMusicGameSettleReq_descriptor, new String[]{"Score", "CorrectHit", "Combo", "MusicBasicId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMusicGameSettleReqOuterClass$FleurFairMusicGameSettleReqOrBuilder.class */
    public interface FleurFairMusicGameSettleReqOrBuilder extends MessageOrBuilder {
        int getScore();

        int getCorrectHit();

        int getCombo();

        int getMusicBasicId();
    }

    private FleurFairMusicGameSettleReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMusicGameSettleReqOuterClass$FleurFairMusicGameSettleReq.class */
    public static final class FleurFairMusicGameSettleReq extends GeneratedMessageV3 implements FleurFairMusicGameSettleReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCORE_FIELD_NUMBER = 1;
        private int score_;
        public static final int CORRECT_HIT_FIELD_NUMBER = 10;
        private int correctHit_;
        public static final int COMBO_FIELD_NUMBER = 3;
        private int combo_;
        public static final int MUSIC_BASIC_ID_FIELD_NUMBER = 14;
        private int musicBasicId_;
        private byte memoizedIsInitialized;
        private static final FleurFairMusicGameSettleReq DEFAULT_INSTANCE = new FleurFairMusicGameSettleReq();
        private static final Parser<FleurFairMusicGameSettleReq> PARSER = new AbstractParser<FleurFairMusicGameSettleReq>() { // from class: emu.grasscutter.net.proto.FleurFairMusicGameSettleReqOuterClass.FleurFairMusicGameSettleReq.1
            @Override // com.google.protobuf.Parser
            public FleurFairMusicGameSettleReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FleurFairMusicGameSettleReq(input, extensionRegistry);
            }
        };

        private FleurFairMusicGameSettleReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FleurFairMusicGameSettleReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FleurFairMusicGameSettleReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FleurFairMusicGameSettleReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.score_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.combo_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.correctHit_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.musicBasicId_ = input.readUInt32();
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
            return FleurFairMusicGameSettleReqOuterClass.internal_static_FleurFairMusicGameSettleReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FleurFairMusicGameSettleReqOuterClass.internal_static_FleurFairMusicGameSettleReq_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairMusicGameSettleReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FleurFairMusicGameSettleReqOuterClass.FleurFairMusicGameSettleReqOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMusicGameSettleReqOuterClass.FleurFairMusicGameSettleReqOrBuilder
        public int getCorrectHit() {
            return this.correctHit_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMusicGameSettleReqOuterClass.FleurFairMusicGameSettleReqOrBuilder
        public int getCombo() {
            return this.combo_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMusicGameSettleReqOuterClass.FleurFairMusicGameSettleReqOrBuilder
        public int getMusicBasicId() {
            return this.musicBasicId_;
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
            if (this.score_ != 0) {
                output.writeUInt32(1, this.score_);
            }
            if (this.combo_ != 0) {
                output.writeUInt32(3, this.combo_);
            }
            if (this.correctHit_ != 0) {
                output.writeUInt32(10, this.correctHit_);
            }
            if (this.musicBasicId_ != 0) {
                output.writeUInt32(14, this.musicBasicId_);
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
            if (this.score_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.score_);
            }
            if (this.combo_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.combo_);
            }
            if (this.correctHit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.correctHit_);
            }
            if (this.musicBasicId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.musicBasicId_);
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
            if (!(obj instanceof FleurFairMusicGameSettleReq)) {
                return equals(obj);
            }
            FleurFairMusicGameSettleReq other = (FleurFairMusicGameSettleReq) obj;
            return getScore() == other.getScore() && getCorrectHit() == other.getCorrectHit() && getCombo() == other.getCombo() && getMusicBasicId() == other.getMusicBasicId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getScore())) + 10)) + getCorrectHit())) + 3)) + getCombo())) + 14)) + getMusicBasicId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FleurFairMusicGameSettleReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairMusicGameSettleReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairMusicGameSettleReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairMusicGameSettleReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairMusicGameSettleReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairMusicGameSettleReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairMusicGameSettleReq parseFrom(InputStream input) throws IOException {
            return (FleurFairMusicGameSettleReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairMusicGameSettleReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairMusicGameSettleReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairMusicGameSettleReq parseDelimitedFrom(InputStream input) throws IOException {
            return (FleurFairMusicGameSettleReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FleurFairMusicGameSettleReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairMusicGameSettleReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairMusicGameSettleReq parseFrom(CodedInputStream input) throws IOException {
            return (FleurFairMusicGameSettleReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairMusicGameSettleReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairMusicGameSettleReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FleurFairMusicGameSettleReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMusicGameSettleReqOuterClass$FleurFairMusicGameSettleReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FleurFairMusicGameSettleReqOrBuilder {
            private int score_;
            private int correctHit_;
            private int combo_;
            private int musicBasicId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FleurFairMusicGameSettleReqOuterClass.internal_static_FleurFairMusicGameSettleReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FleurFairMusicGameSettleReqOuterClass.internal_static_FleurFairMusicGameSettleReq_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairMusicGameSettleReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FleurFairMusicGameSettleReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.score_ = 0;
                this.correctHit_ = 0;
                this.combo_ = 0;
                this.musicBasicId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FleurFairMusicGameSettleReqOuterClass.internal_static_FleurFairMusicGameSettleReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FleurFairMusicGameSettleReq getDefaultInstanceForType() {
                return FleurFairMusicGameSettleReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairMusicGameSettleReq build() {
                FleurFairMusicGameSettleReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairMusicGameSettleReq buildPartial() {
                FleurFairMusicGameSettleReq result = new FleurFairMusicGameSettleReq(this);
                result.score_ = this.score_;
                result.correctHit_ = this.correctHit_;
                result.combo_ = this.combo_;
                result.musicBasicId_ = this.musicBasicId_;
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
                if (other instanceof FleurFairMusicGameSettleReq) {
                    return mergeFrom((FleurFairMusicGameSettleReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FleurFairMusicGameSettleReq other) {
                if (other == FleurFairMusicGameSettleReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getScore() != 0) {
                    setScore(other.getScore());
                }
                if (other.getCorrectHit() != 0) {
                    setCorrectHit(other.getCorrectHit());
                }
                if (other.getCombo() != 0) {
                    setCombo(other.getCombo());
                }
                if (other.getMusicBasicId() != 0) {
                    setMusicBasicId(other.getMusicBasicId());
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
                FleurFairMusicGameSettleReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = FleurFairMusicGameSettleReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FleurFairMusicGameSettleReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FleurFairMusicGameSettleReqOuterClass.FleurFairMusicGameSettleReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.FleurFairMusicGameSettleReqOuterClass.FleurFairMusicGameSettleReqOrBuilder
            public int getCorrectHit() {
                return this.correctHit_;
            }

            public Builder setCorrectHit(int value) {
                this.correctHit_ = value;
                onChanged();
                return this;
            }

            public Builder clearCorrectHit() {
                this.correctHit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairMusicGameSettleReqOuterClass.FleurFairMusicGameSettleReqOrBuilder
            public int getCombo() {
                return this.combo_;
            }

            public Builder setCombo(int value) {
                this.combo_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombo() {
                this.combo_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairMusicGameSettleReqOuterClass.FleurFairMusicGameSettleReqOrBuilder
            public int getMusicBasicId() {
                return this.musicBasicId_;
            }

            public Builder setMusicBasicId(int value) {
                this.musicBasicId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMusicBasicId() {
                this.musicBasicId_ = 0;
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

        public static FleurFairMusicGameSettleReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FleurFairMusicGameSettleReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FleurFairMusicGameSettleReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FleurFairMusicGameSettleReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
