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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GCGTCTavernChallengeDataOuterClass.class */
public final class GCGTCTavernChallengeDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eGCGTCTavernChallengeData.proto\"N\n\u0018GCGTCTavernChallengeData\u0012\u001c\n\u0014unlock_level_id_list\u0018\r \u0003(\r\u0012\u0014\n\fcharacter_id\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GCGTCTavernChallengeData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GCGTCTavernChallengeData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GCGTCTavernChallengeData_descriptor, new String[]{"UnlockLevelIdList", "CharacterId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GCGTCTavernChallengeDataOuterClass$GCGTCTavernChallengeDataOrBuilder.class */
    public interface GCGTCTavernChallengeDataOrBuilder extends MessageOrBuilder {
        List<Integer> getUnlockLevelIdListList();

        int getUnlockLevelIdListCount();

        int getUnlockLevelIdList(int i);

        int getCharacterId();
    }

    private GCGTCTavernChallengeDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GCGTCTavernChallengeDataOuterClass$GCGTCTavernChallengeData.class */
    public static final class GCGTCTavernChallengeData extends GeneratedMessageV3 implements GCGTCTavernChallengeDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNLOCK_LEVEL_ID_LIST_FIELD_NUMBER = 13;
        private Internal.IntList unlockLevelIdList_;
        private int unlockLevelIdListMemoizedSerializedSize;
        public static final int CHARACTER_ID_FIELD_NUMBER = 4;
        private int characterId_;
        private byte memoizedIsInitialized;
        private static final GCGTCTavernChallengeData DEFAULT_INSTANCE = new GCGTCTavernChallengeData();
        private static final Parser<GCGTCTavernChallengeData> PARSER = new AbstractParser<GCGTCTavernChallengeData>() { // from class: emu.grasscutter.net.proto.GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.1
            @Override // com.google.protobuf.Parser
            public GCGTCTavernChallengeData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GCGTCTavernChallengeData(input, extensionRegistry);
            }
        };

        private GCGTCTavernChallengeData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unlockLevelIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GCGTCTavernChallengeData() {
            this.unlockLevelIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unlockLevelIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GCGTCTavernChallengeData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GCGTCTavernChallengeData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.characterId_ = input.readUInt32();
                                    break;
                                case 104:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unlockLevelIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.unlockLevelIdList_.addInt(input.readUInt32());
                                    break;
                                case 106:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unlockLevelIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unlockLevelIdList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
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
                    this.unlockLevelIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GCGTCTavernChallengeDataOuterClass.internal_static_GCGTCTavernChallengeData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GCGTCTavernChallengeDataOuterClass.internal_static_GCGTCTavernChallengeData_fieldAccessorTable.ensureFieldAccessorsInitialized(GCGTCTavernChallengeData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder
        public List<Integer> getUnlockLevelIdListList() {
            return this.unlockLevelIdList_;
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder
        public int getUnlockLevelIdListCount() {
            return this.unlockLevelIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder
        public int getUnlockLevelIdList(int index) {
            return this.unlockLevelIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder
        public int getCharacterId() {
            return this.characterId_;
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
            if (this.characterId_ != 0) {
                output.writeUInt32(4, this.characterId_);
            }
            if (getUnlockLevelIdListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.unlockLevelIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unlockLevelIdList_.size(); i++) {
                output.writeUInt32NoTag(this.unlockLevelIdList_.getInt(i));
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
            if (this.characterId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.characterId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.unlockLevelIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unlockLevelIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getUnlockLevelIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unlockLevelIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GCGTCTavernChallengeData)) {
                return equals(obj);
            }
            GCGTCTavernChallengeData other = (GCGTCTavernChallengeData) obj;
            return getUnlockLevelIdListList().equals(other.getUnlockLevelIdListList()) && getCharacterId() == other.getCharacterId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnlockLevelIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getUnlockLevelIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 4)) + getCharacterId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GCGTCTavernChallengeData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GCGTCTavernChallengeData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GCGTCTavernChallengeData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GCGTCTavernChallengeData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GCGTCTavernChallengeData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GCGTCTavernChallengeData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GCGTCTavernChallengeData parseFrom(InputStream input) throws IOException {
            return (GCGTCTavernChallengeData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GCGTCTavernChallengeData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GCGTCTavernChallengeData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GCGTCTavernChallengeData parseDelimitedFrom(InputStream input) throws IOException {
            return (GCGTCTavernChallengeData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GCGTCTavernChallengeData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GCGTCTavernChallengeData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GCGTCTavernChallengeData parseFrom(CodedInputStream input) throws IOException {
            return (GCGTCTavernChallengeData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GCGTCTavernChallengeData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GCGTCTavernChallengeData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GCGTCTavernChallengeData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GCGTCTavernChallengeDataOuterClass$GCGTCTavernChallengeData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GCGTCTavernChallengeDataOrBuilder {
            private int bitField0_;
            private Internal.IntList unlockLevelIdList_ = GCGTCTavernChallengeData.emptyIntList();
            private int characterId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GCGTCTavernChallengeDataOuterClass.internal_static_GCGTCTavernChallengeData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GCGTCTavernChallengeDataOuterClass.internal_static_GCGTCTavernChallengeData_fieldAccessorTable.ensureFieldAccessorsInitialized(GCGTCTavernChallengeData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GCGTCTavernChallengeData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unlockLevelIdList_ = GCGTCTavernChallengeData.emptyIntList();
                this.bitField0_ &= -2;
                this.characterId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GCGTCTavernChallengeDataOuterClass.internal_static_GCGTCTavernChallengeData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GCGTCTavernChallengeData getDefaultInstanceForType() {
                return GCGTCTavernChallengeData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GCGTCTavernChallengeData build() {
                GCGTCTavernChallengeData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GCGTCTavernChallengeData buildPartial() {
                GCGTCTavernChallengeData result = new GCGTCTavernChallengeData(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unlockLevelIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unlockLevelIdList_ = this.unlockLevelIdList_;
                result.characterId_ = this.characterId_;
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
                if (other instanceof GCGTCTavernChallengeData) {
                    return mergeFrom((GCGTCTavernChallengeData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GCGTCTavernChallengeData other) {
                if (other == GCGTCTavernChallengeData.getDefaultInstance()) {
                    return this;
                }
                if (!other.unlockLevelIdList_.isEmpty()) {
                    if (this.unlockLevelIdList_.isEmpty()) {
                        this.unlockLevelIdList_ = other.unlockLevelIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnlockLevelIdListIsMutable();
                        this.unlockLevelIdList_.addAll(other.unlockLevelIdList_);
                    }
                    onChanged();
                }
                if (other.getCharacterId() != 0) {
                    setCharacterId(other.getCharacterId());
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
                GCGTCTavernChallengeData parsedMessage = null;
                try {
                    try {
                        parsedMessage = GCGTCTavernChallengeData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GCGTCTavernChallengeData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnlockLevelIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unlockLevelIdList_ = GCGTCTavernChallengeData.mutableCopy(this.unlockLevelIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder
            public List<Integer> getUnlockLevelIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unlockLevelIdList_) : this.unlockLevelIdList_;
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder
            public int getUnlockLevelIdListCount() {
                return this.unlockLevelIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder
            public int getUnlockLevelIdList(int index) {
                return this.unlockLevelIdList_.getInt(index);
            }

            public Builder setUnlockLevelIdList(int index, int value) {
                ensureUnlockLevelIdListIsMutable();
                this.unlockLevelIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockLevelIdList(int value) {
                ensureUnlockLevelIdListIsMutable();
                this.unlockLevelIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockLevelIdList(Iterable<? extends Integer> values) {
                ensureUnlockLevelIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockLevelIdList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockLevelIdList() {
                this.unlockLevelIdList_ = GCGTCTavernChallengeData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder
            public int getCharacterId() {
                return this.characterId_;
            }

            public Builder setCharacterId(int value) {
                this.characterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCharacterId() {
                this.characterId_ = 0;
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

        public static GCGTCTavernChallengeData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GCGTCTavernChallengeData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GCGTCTavernChallengeData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GCGTCTavernChallengeData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
