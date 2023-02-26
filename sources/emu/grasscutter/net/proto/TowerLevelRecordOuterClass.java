package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelRecordOuterClass.class */
public final class TowerLevelRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016TowerLevelRecord.proto\">\n\u0010TowerLevelRecord\u0012\u000f\n\u0007levelId\u0018\u000b \u0001(\r\u0012\u0019\n\u0011satisfiedCondList\u0018\u0007 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TowerLevelRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerLevelRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerLevelRecord_descriptor, new String[]{"LevelId", "SatisfiedCondList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelRecordOuterClass$TowerLevelRecordOrBuilder.class */
    public interface TowerLevelRecordOrBuilder extends MessageOrBuilder {
        int getLevelId();

        List<Integer> getSatisfiedCondListList();

        int getSatisfiedCondListCount();

        int getSatisfiedCondList(int i);
    }

    private TowerLevelRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelRecordOuterClass$TowerLevelRecord.class */
    public static final class TowerLevelRecord extends GeneratedMessageV3 implements TowerLevelRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVELID_FIELD_NUMBER = 11;
        private int levelId_;
        public static final int SATISFIEDCONDLIST_FIELD_NUMBER = 7;
        private Internal.IntList satisfiedCondList_;
        private int satisfiedCondListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final TowerLevelRecord DEFAULT_INSTANCE = new TowerLevelRecord();
        private static final Parser<TowerLevelRecord> PARSER = new AbstractParser<TowerLevelRecord>() { // from class: emu.grasscutter.net.proto.TowerLevelRecordOuterClass.TowerLevelRecord.1
            @Override // com.google.protobuf.Parser
            public TowerLevelRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerLevelRecord(input, extensionRegistry);
            }
        };

        private TowerLevelRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.satisfiedCondListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private TowerLevelRecord() {
            this.satisfiedCondListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.satisfiedCondList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerLevelRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TowerLevelRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
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
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.satisfiedCondList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.satisfiedCondList_.addInt(input.readUInt32());
                                    break;
                                case 58:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.satisfiedCondList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.satisfiedCondList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 88:
                                    this.levelId_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.satisfiedCondList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TowerLevelRecordOuterClass.internal_static_TowerLevelRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerLevelRecordOuterClass.internal_static_TowerLevelRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerLevelRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder
        public List<Integer> getSatisfiedCondListList() {
            return this.satisfiedCondList_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder
        public int getSatisfiedCondListCount() {
            return this.satisfiedCondList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder
        public int getSatisfiedCondList(int index) {
            return this.satisfiedCondList_.getInt(index);
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
            getSerializedSize();
            if (getSatisfiedCondListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.satisfiedCondListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.satisfiedCondList_.size(); i++) {
                output.writeUInt32NoTag(this.satisfiedCondList_.getInt(i));
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(11, this.levelId_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.satisfiedCondList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.satisfiedCondList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getSatisfiedCondListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.satisfiedCondListMemoizedSerializedSize = dataSize;
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.levelId_);
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
            if (!(obj instanceof TowerLevelRecord)) {
                return equals(obj);
            }
            TowerLevelRecord other = (TowerLevelRecord) obj;
            return getLevelId() == other.getLevelId() && getSatisfiedCondListList().equals(other.getSatisfiedCondListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getLevelId();
            if (getSatisfiedCondListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getSatisfiedCondListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TowerLevelRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelRecord parseFrom(InputStream input) throws IOException {
            return (TowerLevelRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerLevelRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerLevelRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerLevelRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerLevelRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerLevelRecord parseFrom(CodedInputStream input) throws IOException {
            return (TowerLevelRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerLevelRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerLevelRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelRecordOuterClass$TowerLevelRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerLevelRecordOrBuilder {
            private int bitField0_;
            private int levelId_;
            private Internal.IntList satisfiedCondList_ = TowerLevelRecord.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerLevelRecordOuterClass.internal_static_TowerLevelRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerLevelRecordOuterClass.internal_static_TowerLevelRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerLevelRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerLevelRecord.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.levelId_ = 0;
                this.satisfiedCondList_ = TowerLevelRecord.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerLevelRecordOuterClass.internal_static_TowerLevelRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerLevelRecord getDefaultInstanceForType() {
                return TowerLevelRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerLevelRecord build() {
                TowerLevelRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerLevelRecord buildPartial() {
                TowerLevelRecord result = new TowerLevelRecord(this);
                int i = this.bitField0_;
                result.levelId_ = this.levelId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.satisfiedCondList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.satisfiedCondList_ = this.satisfiedCondList_;
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
                if (other instanceof TowerLevelRecord) {
                    return mergeFrom((TowerLevelRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerLevelRecord other) {
                if (other == TowerLevelRecord.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (!other.satisfiedCondList_.isEmpty()) {
                    if (this.satisfiedCondList_.isEmpty()) {
                        this.satisfiedCondList_ = other.satisfiedCondList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureSatisfiedCondListIsMutable();
                        this.satisfiedCondList_.addAll(other.satisfiedCondList_);
                    }
                    onChanged();
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
                TowerLevelRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerLevelRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerLevelRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder
            public int getLevelId() {
                return this.levelId_;
            }

            public Builder setLevelId(int value) {
                this.levelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelId() {
                this.levelId_ = 0;
                onChanged();
                return this;
            }

            private void ensureSatisfiedCondListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.satisfiedCondList_ = TowerLevelRecord.mutableCopy(this.satisfiedCondList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder
            public List<Integer> getSatisfiedCondListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.satisfiedCondList_) : this.satisfiedCondList_;
            }

            @Override // emu.grasscutter.net.proto.TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder
            public int getSatisfiedCondListCount() {
                return this.satisfiedCondList_.size();
            }

            @Override // emu.grasscutter.net.proto.TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder
            public int getSatisfiedCondList(int index) {
                return this.satisfiedCondList_.getInt(index);
            }

            public Builder setSatisfiedCondList(int index, int value) {
                ensureSatisfiedCondListIsMutable();
                this.satisfiedCondList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addSatisfiedCondList(int value) {
                ensureSatisfiedCondListIsMutable();
                this.satisfiedCondList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllSatisfiedCondList(Iterable<? extends Integer> values) {
                ensureSatisfiedCondListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.satisfiedCondList_);
                onChanged();
                return this;
            }

            public Builder clearSatisfiedCondList() {
                this.satisfiedCondList_ = TowerLevelRecord.emptyIntList();
                this.bitField0_ &= -2;
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

        public static TowerLevelRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerLevelRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerLevelRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerLevelRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
