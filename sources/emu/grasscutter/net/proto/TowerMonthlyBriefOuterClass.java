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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerMonthlyBriefOuterClass.class */
public final class TowerMonthlyBriefOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017TowerMonthlyBrief.proto\"t\n\u0011TowerMonthlyBrief\u0012\u0016\n\u000ebestLevelIndex\u0018\u000b \u0001(\r\u0012\u0017\n\u000ftowerScheduleId\u0018\u0007 \u0001(\r\u0012\u0016\n\u000etotalStarCount\u0018\u000e \u0001(\r\u0012\u0016\n\u000ebestFloorIndex\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TowerMonthlyBrief_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerMonthlyBrief_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerMonthlyBrief_descriptor, new String[]{"BestLevelIndex", "TowerScheduleId", "TotalStarCount", "BestFloorIndex"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerMonthlyBriefOuterClass$TowerMonthlyBriefOrBuilder.class */
    public interface TowerMonthlyBriefOrBuilder extends MessageOrBuilder {
        int getBestLevelIndex();

        int getTowerScheduleId();

        int getTotalStarCount();

        int getBestFloorIndex();
    }

    private TowerMonthlyBriefOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerMonthlyBriefOuterClass$TowerMonthlyBrief.class */
    public static final class TowerMonthlyBrief extends GeneratedMessageV3 implements TowerMonthlyBriefOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BESTLEVELINDEX_FIELD_NUMBER = 11;
        private int bestLevelIndex_;
        public static final int TOWERSCHEDULEID_FIELD_NUMBER = 7;
        private int towerScheduleId_;
        public static final int TOTALSTARCOUNT_FIELD_NUMBER = 14;
        private int totalStarCount_;
        public static final int BESTFLOORINDEX_FIELD_NUMBER = 8;
        private int bestFloorIndex_;
        private byte memoizedIsInitialized;
        private static final TowerMonthlyBrief DEFAULT_INSTANCE = new TowerMonthlyBrief();
        private static final Parser<TowerMonthlyBrief> PARSER = new AbstractParser<TowerMonthlyBrief>() { // from class: emu.grasscutter.net.proto.TowerMonthlyBriefOuterClass.TowerMonthlyBrief.1
            @Override // com.google.protobuf.Parser
            public TowerMonthlyBrief parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerMonthlyBrief(input, extensionRegistry);
            }
        };

        private TowerMonthlyBrief(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TowerMonthlyBrief() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerMonthlyBrief();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TowerMonthlyBrief(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.towerScheduleId_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.bestFloorIndex_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.bestLevelIndex_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.totalStarCount_ = input.readUInt32();
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
            return TowerMonthlyBriefOuterClass.internal_static_TowerMonthlyBrief_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerMonthlyBriefOuterClass.internal_static_TowerMonthlyBrief_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerMonthlyBrief.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder
        public int getBestLevelIndex() {
            return this.bestLevelIndex_;
        }

        @Override // emu.grasscutter.net.proto.TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder
        public int getTowerScheduleId() {
            return this.towerScheduleId_;
        }

        @Override // emu.grasscutter.net.proto.TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder
        public int getTotalStarCount() {
            return this.totalStarCount_;
        }

        @Override // emu.grasscutter.net.proto.TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder
        public int getBestFloorIndex() {
            return this.bestFloorIndex_;
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
            if (this.towerScheduleId_ != 0) {
                output.writeUInt32(7, this.towerScheduleId_);
            }
            if (this.bestFloorIndex_ != 0) {
                output.writeUInt32(8, this.bestFloorIndex_);
            }
            if (this.bestLevelIndex_ != 0) {
                output.writeUInt32(11, this.bestLevelIndex_);
            }
            if (this.totalStarCount_ != 0) {
                output.writeUInt32(14, this.totalStarCount_);
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
            if (this.towerScheduleId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.towerScheduleId_);
            }
            if (this.bestFloorIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.bestFloorIndex_);
            }
            if (this.bestLevelIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.bestLevelIndex_);
            }
            if (this.totalStarCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.totalStarCount_);
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
            if (!(obj instanceof TowerMonthlyBrief)) {
                return equals(obj);
            }
            TowerMonthlyBrief other = (TowerMonthlyBrief) obj;
            return getBestLevelIndex() == other.getBestLevelIndex() && getTowerScheduleId() == other.getTowerScheduleId() && getTotalStarCount() == other.getTotalStarCount() && getBestFloorIndex() == other.getBestFloorIndex() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getBestLevelIndex())) + 7)) + getTowerScheduleId())) + 14)) + getTotalStarCount())) + 8)) + getBestFloorIndex())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TowerMonthlyBrief parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerMonthlyBrief parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerMonthlyBrief parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerMonthlyBrief parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerMonthlyBrief parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerMonthlyBrief parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerMonthlyBrief parseFrom(InputStream input) throws IOException {
            return (TowerMonthlyBrief) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerMonthlyBrief parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerMonthlyBrief) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerMonthlyBrief parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerMonthlyBrief) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerMonthlyBrief parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerMonthlyBrief) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerMonthlyBrief parseFrom(CodedInputStream input) throws IOException {
            return (TowerMonthlyBrief) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerMonthlyBrief parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerMonthlyBrief) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerMonthlyBrief prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerMonthlyBriefOuterClass$TowerMonthlyBrief$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerMonthlyBriefOrBuilder {
            private int bestLevelIndex_;
            private int towerScheduleId_;
            private int totalStarCount_;
            private int bestFloorIndex_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerMonthlyBriefOuterClass.internal_static_TowerMonthlyBrief_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerMonthlyBriefOuterClass.internal_static_TowerMonthlyBrief_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerMonthlyBrief.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerMonthlyBrief.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.bestLevelIndex_ = 0;
                this.towerScheduleId_ = 0;
                this.totalStarCount_ = 0;
                this.bestFloorIndex_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerMonthlyBriefOuterClass.internal_static_TowerMonthlyBrief_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerMonthlyBrief getDefaultInstanceForType() {
                return TowerMonthlyBrief.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerMonthlyBrief build() {
                TowerMonthlyBrief result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerMonthlyBrief buildPartial() {
                TowerMonthlyBrief result = new TowerMonthlyBrief(this);
                result.bestLevelIndex_ = this.bestLevelIndex_;
                result.towerScheduleId_ = this.towerScheduleId_;
                result.totalStarCount_ = this.totalStarCount_;
                result.bestFloorIndex_ = this.bestFloorIndex_;
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
                if (other instanceof TowerMonthlyBrief) {
                    return mergeFrom((TowerMonthlyBrief) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerMonthlyBrief other) {
                if (other == TowerMonthlyBrief.getDefaultInstance()) {
                    return this;
                }
                if (other.getBestLevelIndex() != 0) {
                    setBestLevelIndex(other.getBestLevelIndex());
                }
                if (other.getTowerScheduleId() != 0) {
                    setTowerScheduleId(other.getTowerScheduleId());
                }
                if (other.getTotalStarCount() != 0) {
                    setTotalStarCount(other.getTotalStarCount());
                }
                if (other.getBestFloorIndex() != 0) {
                    setBestFloorIndex(other.getBestFloorIndex());
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
                TowerMonthlyBrief parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerMonthlyBrief.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerMonthlyBrief) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder
            public int getBestLevelIndex() {
                return this.bestLevelIndex_;
            }

            public Builder setBestLevelIndex(int value) {
                this.bestLevelIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearBestLevelIndex() {
                this.bestLevelIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder
            public int getTowerScheduleId() {
                return this.towerScheduleId_;
            }

            public Builder setTowerScheduleId(int value) {
                this.towerScheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTowerScheduleId() {
                this.towerScheduleId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder
            public int getTotalStarCount() {
                return this.totalStarCount_;
            }

            public Builder setTotalStarCount(int value) {
                this.totalStarCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalStarCount() {
                this.totalStarCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder
            public int getBestFloorIndex() {
                return this.bestFloorIndex_;
            }

            public Builder setBestFloorIndex(int value) {
                this.bestFloorIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearBestFloorIndex() {
                this.bestFloorIndex_ = 0;
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

        public static TowerMonthlyBrief getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerMonthlyBrief> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerMonthlyBrief> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerMonthlyBrief getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
