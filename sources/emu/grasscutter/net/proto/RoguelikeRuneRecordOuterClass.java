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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeRuneRecordOuterClass.class */
public final class RoguelikeRuneRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019RoguelikeRuneRecord.proto\"_\n\u0013RoguelikeRuneRecord\u0012\u001b\n\u0013Unk3300_JLOLMLFAPHH\u0018\u0007 \u0001(\r\u0012\u001b\n\u0013Unk3300_IGBOJLPPKON\u0018\f \u0001(\r\u0012\u000e\n\u0006runeId\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RoguelikeRuneRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RoguelikeRuneRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RoguelikeRuneRecord_descriptor, new String[]{"Unk3300JLOLMLFAPHH", "Unk3300IGBOJLPPKON", "RuneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeRuneRecordOuterClass$RoguelikeRuneRecordOrBuilder.class */
    public interface RoguelikeRuneRecordOrBuilder extends MessageOrBuilder {
        int getUnk3300JLOLMLFAPHH();

        int getUnk3300IGBOJLPPKON();

        int getRuneId();
    }

    private RoguelikeRuneRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeRuneRecordOuterClass$RoguelikeRuneRecord.class */
    public static final class RoguelikeRuneRecord extends GeneratedMessageV3 implements RoguelikeRuneRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_JLOLMLFAPHH_FIELD_NUMBER = 7;
        private int unk3300JLOLMLFAPHH_;
        public static final int UNK3300_IGBOJLPPKON_FIELD_NUMBER = 12;
        private int unk3300IGBOJLPPKON_;
        public static final int RUNEID_FIELD_NUMBER = 6;
        private int runeId_;
        private byte memoizedIsInitialized;
        private static final RoguelikeRuneRecord DEFAULT_INSTANCE = new RoguelikeRuneRecord();
        private static final Parser<RoguelikeRuneRecord> PARSER = new AbstractParser<RoguelikeRuneRecord>() { // from class: emu.grasscutter.net.proto.RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.1
            @Override // com.google.protobuf.Parser
            public RoguelikeRuneRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RoguelikeRuneRecord(input, extensionRegistry);
            }
        };

        private RoguelikeRuneRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RoguelikeRuneRecord() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RoguelikeRuneRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RoguelikeRuneRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.runeId_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.unk3300JLOLMLFAPHH_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.unk3300IGBOJLPPKON_ = input.readUInt32();
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
            return RoguelikeRuneRecordOuterClass.internal_static_RoguelikeRuneRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RoguelikeRuneRecordOuterClass.internal_static_RoguelikeRuneRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(RoguelikeRuneRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder
        public int getUnk3300JLOLMLFAPHH() {
            return this.unk3300JLOLMLFAPHH_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder
        public int getUnk3300IGBOJLPPKON() {
            return this.unk3300IGBOJLPPKON_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder
        public int getRuneId() {
            return this.runeId_;
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
            if (this.runeId_ != 0) {
                output.writeUInt32(6, this.runeId_);
            }
            if (this.unk3300JLOLMLFAPHH_ != 0) {
                output.writeUInt32(7, this.unk3300JLOLMLFAPHH_);
            }
            if (this.unk3300IGBOJLPPKON_ != 0) {
                output.writeUInt32(12, this.unk3300IGBOJLPPKON_);
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
            if (this.runeId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.runeId_);
            }
            if (this.unk3300JLOLMLFAPHH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.unk3300JLOLMLFAPHH_);
            }
            if (this.unk3300IGBOJLPPKON_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300IGBOJLPPKON_);
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
            if (!(obj instanceof RoguelikeRuneRecord)) {
                return equals(obj);
            }
            RoguelikeRuneRecord other = (RoguelikeRuneRecord) obj;
            return getUnk3300JLOLMLFAPHH() == other.getUnk3300JLOLMLFAPHH() && getUnk3300IGBOJLPPKON() == other.getUnk3300IGBOJLPPKON() && getRuneId() == other.getRuneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getUnk3300JLOLMLFAPHH())) + 12)) + getUnk3300IGBOJLPPKON())) + 6)) + getRuneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static RoguelikeRuneRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeRuneRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeRuneRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeRuneRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeRuneRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeRuneRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeRuneRecord parseFrom(InputStream input) throws IOException {
            return (RoguelikeRuneRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeRuneRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeRuneRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeRuneRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (RoguelikeRuneRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RoguelikeRuneRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeRuneRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeRuneRecord parseFrom(CodedInputStream input) throws IOException {
            return (RoguelikeRuneRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeRuneRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeRuneRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RoguelikeRuneRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeRuneRecordOuterClass$RoguelikeRuneRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RoguelikeRuneRecordOrBuilder {
            private int unk3300JLOLMLFAPHH_;
            private int unk3300IGBOJLPPKON_;
            private int runeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RoguelikeRuneRecordOuterClass.internal_static_RoguelikeRuneRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RoguelikeRuneRecordOuterClass.internal_static_RoguelikeRuneRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(RoguelikeRuneRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RoguelikeRuneRecord.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300JLOLMLFAPHH_ = 0;
                this.unk3300IGBOJLPPKON_ = 0;
                this.runeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RoguelikeRuneRecordOuterClass.internal_static_RoguelikeRuneRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RoguelikeRuneRecord getDefaultInstanceForType() {
                return RoguelikeRuneRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeRuneRecord build() {
                RoguelikeRuneRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeRuneRecord buildPartial() {
                RoguelikeRuneRecord result = new RoguelikeRuneRecord(this);
                result.unk3300JLOLMLFAPHH_ = this.unk3300JLOLMLFAPHH_;
                result.unk3300IGBOJLPPKON_ = this.unk3300IGBOJLPPKON_;
                result.runeId_ = this.runeId_;
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
                if (other instanceof RoguelikeRuneRecord) {
                    return mergeFrom((RoguelikeRuneRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RoguelikeRuneRecord other) {
                if (other == RoguelikeRuneRecord.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300JLOLMLFAPHH() != 0) {
                    setUnk3300JLOLMLFAPHH(other.getUnk3300JLOLMLFAPHH());
                }
                if (other.getUnk3300IGBOJLPPKON() != 0) {
                    setUnk3300IGBOJLPPKON(other.getUnk3300IGBOJLPPKON());
                }
                if (other.getRuneId() != 0) {
                    setRuneId(other.getRuneId());
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
                RoguelikeRuneRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = RoguelikeRuneRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RoguelikeRuneRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder
            public int getUnk3300JLOLMLFAPHH() {
                return this.unk3300JLOLMLFAPHH_;
            }

            public Builder setUnk3300JLOLMLFAPHH(int value) {
                this.unk3300JLOLMLFAPHH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JLOLMLFAPHH() {
                this.unk3300JLOLMLFAPHH_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder
            public int getUnk3300IGBOJLPPKON() {
                return this.unk3300IGBOJLPPKON_;
            }

            public Builder setUnk3300IGBOJLPPKON(int value) {
                this.unk3300IGBOJLPPKON_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300IGBOJLPPKON() {
                this.unk3300IGBOJLPPKON_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder
            public int getRuneId() {
                return this.runeId_;
            }

            public Builder setRuneId(int value) {
                this.runeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRuneId() {
                this.runeId_ = 0;
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

        public static RoguelikeRuneRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RoguelikeRuneRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RoguelikeRuneRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RoguelikeRuneRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
