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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMusicRecordOuterClass.class */
public final class FleurFairMusicRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aFleurFairMusicRecord.proto\"O\n\u0014FleurFairMusicRecord\u0012\u0011\n\tmax_score\u0018\u000b \u0001(\r\u0012\u0011\n\tis_unlock\u0018\n \u0001(\b\u0012\u0011\n\tmax_combo\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FleurFairMusicRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FleurFairMusicRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FleurFairMusicRecord_descriptor, new String[]{"MaxScore", "IsUnlock", "MaxCombo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMusicRecordOuterClass$FleurFairMusicRecordOrBuilder.class */
    public interface FleurFairMusicRecordOrBuilder extends MessageOrBuilder {
        int getMaxScore();

        boolean getIsUnlock();

        int getMaxCombo();
    }

    private FleurFairMusicRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMusicRecordOuterClass$FleurFairMusicRecord.class */
    public static final class FleurFairMusicRecord extends GeneratedMessageV3 implements FleurFairMusicRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAX_SCORE_FIELD_NUMBER = 11;
        private int maxScore_;
        public static final int IS_UNLOCK_FIELD_NUMBER = 10;
        private boolean isUnlock_;
        public static final int MAX_COMBO_FIELD_NUMBER = 6;
        private int maxCombo_;
        private byte memoizedIsInitialized;
        private static final FleurFairMusicRecord DEFAULT_INSTANCE = new FleurFairMusicRecord();
        private static final Parser<FleurFairMusicRecord> PARSER = new AbstractParser<FleurFairMusicRecord>() { // from class: emu.grasscutter.net.proto.FleurFairMusicRecordOuterClass.FleurFairMusicRecord.1
            @Override // com.google.protobuf.Parser
            public FleurFairMusicRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FleurFairMusicRecord(input, extensionRegistry);
            }
        };

        private FleurFairMusicRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FleurFairMusicRecord() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FleurFairMusicRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FleurFairMusicRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.maxCombo_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.isUnlock_ = input.readBool();
                                    break;
                                case 88:
                                    this.maxScore_ = input.readUInt32();
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
            return FleurFairMusicRecordOuterClass.internal_static_FleurFairMusicRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FleurFairMusicRecordOuterClass.internal_static_FleurFairMusicRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairMusicRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FleurFairMusicRecordOuterClass.FleurFairMusicRecordOrBuilder
        public int getMaxScore() {
            return this.maxScore_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMusicRecordOuterClass.FleurFairMusicRecordOrBuilder
        public boolean getIsUnlock() {
            return this.isUnlock_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMusicRecordOuterClass.FleurFairMusicRecordOrBuilder
        public int getMaxCombo() {
            return this.maxCombo_;
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
            if (this.maxCombo_ != 0) {
                output.writeUInt32(6, this.maxCombo_);
            }
            if (this.isUnlock_) {
                output.writeBool(10, this.isUnlock_);
            }
            if (this.maxScore_ != 0) {
                output.writeUInt32(11, this.maxScore_);
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
            if (this.maxCombo_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.maxCombo_);
            }
            if (this.isUnlock_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isUnlock_);
            }
            if (this.maxScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.maxScore_);
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
            if (!(obj instanceof FleurFairMusicRecord)) {
                return equals(obj);
            }
            FleurFairMusicRecord other = (FleurFairMusicRecord) obj;
            return getMaxScore() == other.getMaxScore() && getIsUnlock() == other.getIsUnlock() && getMaxCombo() == other.getMaxCombo() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getMaxScore())) + 10)) + Internal.hashBoolean(getIsUnlock()))) + 6)) + getMaxCombo())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FleurFairMusicRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairMusicRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairMusicRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairMusicRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairMusicRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairMusicRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairMusicRecord parseFrom(InputStream input) throws IOException {
            return (FleurFairMusicRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairMusicRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairMusicRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairMusicRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (FleurFairMusicRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FleurFairMusicRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairMusicRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairMusicRecord parseFrom(CodedInputStream input) throws IOException {
            return (FleurFairMusicRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairMusicRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairMusicRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FleurFairMusicRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMusicRecordOuterClass$FleurFairMusicRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FleurFairMusicRecordOrBuilder {
            private int maxScore_;
            private boolean isUnlock_;
            private int maxCombo_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FleurFairMusicRecordOuterClass.internal_static_FleurFairMusicRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FleurFairMusicRecordOuterClass.internal_static_FleurFairMusicRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairMusicRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FleurFairMusicRecord.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.maxScore_ = 0;
                this.isUnlock_ = false;
                this.maxCombo_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FleurFairMusicRecordOuterClass.internal_static_FleurFairMusicRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FleurFairMusicRecord getDefaultInstanceForType() {
                return FleurFairMusicRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairMusicRecord build() {
                FleurFairMusicRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairMusicRecord buildPartial() {
                FleurFairMusicRecord result = new FleurFairMusicRecord(this);
                result.maxScore_ = this.maxScore_;
                result.isUnlock_ = this.isUnlock_;
                result.maxCombo_ = this.maxCombo_;
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
                if (other instanceof FleurFairMusicRecord) {
                    return mergeFrom((FleurFairMusicRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FleurFairMusicRecord other) {
                if (other == FleurFairMusicRecord.getDefaultInstance()) {
                    return this;
                }
                if (other.getMaxScore() != 0) {
                    setMaxScore(other.getMaxScore());
                }
                if (other.getIsUnlock()) {
                    setIsUnlock(other.getIsUnlock());
                }
                if (other.getMaxCombo() != 0) {
                    setMaxCombo(other.getMaxCombo());
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
                FleurFairMusicRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = FleurFairMusicRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FleurFairMusicRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FleurFairMusicRecordOuterClass.FleurFairMusicRecordOrBuilder
            public int getMaxScore() {
                return this.maxScore_;
            }

            public Builder setMaxScore(int value) {
                this.maxScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxScore() {
                this.maxScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairMusicRecordOuterClass.FleurFairMusicRecordOrBuilder
            public boolean getIsUnlock() {
                return this.isUnlock_;
            }

            public Builder setIsUnlock(boolean value) {
                this.isUnlock_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsUnlock() {
                this.isUnlock_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairMusicRecordOuterClass.FleurFairMusicRecordOrBuilder
            public int getMaxCombo() {
                return this.maxCombo_;
            }

            public Builder setMaxCombo(int value) {
                this.maxCombo_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxCombo() {
                this.maxCombo_ = 0;
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

        public static FleurFairMusicRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FleurFairMusicRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FleurFairMusicRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FleurFairMusicRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
