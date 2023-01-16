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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekMapInfoOuterClass.class */
public final class HideAndSeekMapInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018HideAndSeekMapInfo.proto\"@\n\u0012HideAndSeekMapInfo\u0012\u001e\n\u0016match_lock_reason_list\u0018\u0006 \u0003(\r\u0012\n\n\u0002id\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HideAndSeekMapInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HideAndSeekMapInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HideAndSeekMapInfo_descriptor, new String[]{"MatchLockReasonList", "Id"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekMapInfoOuterClass$HideAndSeekMapInfoOrBuilder.class */
    public interface HideAndSeekMapInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getMatchLockReasonListList();

        int getMatchLockReasonListCount();

        int getMatchLockReasonList(int i);

        int getId();
    }

    private HideAndSeekMapInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekMapInfoOuterClass$HideAndSeekMapInfo.class */
    public static final class HideAndSeekMapInfo extends GeneratedMessageV3 implements HideAndSeekMapInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MATCH_LOCK_REASON_LIST_FIELD_NUMBER = 6;
        private Internal.IntList matchLockReasonList_;
        private int matchLockReasonListMemoizedSerializedSize;
        public static final int ID_FIELD_NUMBER = 12;
        private int id_;
        private byte memoizedIsInitialized;
        private static final HideAndSeekMapInfo DEFAULT_INSTANCE = new HideAndSeekMapInfo();
        private static final Parser<HideAndSeekMapInfo> PARSER = new AbstractParser<HideAndSeekMapInfo>() { // from class: emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.1
            @Override // com.google.protobuf.Parser
            public HideAndSeekMapInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HideAndSeekMapInfo(input, extensionRegistry);
            }
        };

        private HideAndSeekMapInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.matchLockReasonListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HideAndSeekMapInfo() {
            this.matchLockReasonListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.matchLockReasonList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HideAndSeekMapInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HideAndSeekMapInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.matchLockReasonList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.matchLockReasonList_.addInt(input.readUInt32());
                                    break;
                                case 50:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.matchLockReasonList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.matchLockReasonList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 96:
                                    this.id_ = input.readUInt32();
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
                    this.matchLockReasonList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HideAndSeekMapInfoOuterClass.internal_static_HideAndSeekMapInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HideAndSeekMapInfoOuterClass.internal_static_HideAndSeekMapInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HideAndSeekMapInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder
        public List<Integer> getMatchLockReasonListList() {
            return this.matchLockReasonList_;
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder
        public int getMatchLockReasonListCount() {
            return this.matchLockReasonList_.size();
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder
        public int getMatchLockReasonList(int index) {
            return this.matchLockReasonList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder
        public int getId() {
            return this.id_;
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
            if (getMatchLockReasonListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.matchLockReasonListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.matchLockReasonList_.size(); i++) {
                output.writeUInt32NoTag(this.matchLockReasonList_.getInt(i));
            }
            if (this.id_ != 0) {
                output.writeUInt32(12, this.id_);
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
            for (int i = 0; i < this.matchLockReasonList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.matchLockReasonList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getMatchLockReasonListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.matchLockReasonListMemoizedSerializedSize = dataSize;
            if (this.id_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.id_);
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
            if (!(obj instanceof HideAndSeekMapInfo)) {
                return equals(obj);
            }
            HideAndSeekMapInfo other = (HideAndSeekMapInfo) obj;
            return getMatchLockReasonListList().equals(other.getMatchLockReasonListList()) && getId() == other.getId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMatchLockReasonListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getMatchLockReasonListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 12)) + getId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HideAndSeekMapInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HideAndSeekMapInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HideAndSeekMapInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HideAndSeekMapInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HideAndSeekMapInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HideAndSeekMapInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HideAndSeekMapInfo parseFrom(InputStream input) throws IOException {
            return (HideAndSeekMapInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HideAndSeekMapInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HideAndSeekMapInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HideAndSeekMapInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HideAndSeekMapInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HideAndSeekMapInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HideAndSeekMapInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HideAndSeekMapInfo parseFrom(CodedInputStream input) throws IOException {
            return (HideAndSeekMapInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HideAndSeekMapInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HideAndSeekMapInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HideAndSeekMapInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekMapInfoOuterClass$HideAndSeekMapInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HideAndSeekMapInfoOrBuilder {
            private int bitField0_;
            private Internal.IntList matchLockReasonList_ = HideAndSeekMapInfo.emptyIntList();
            private int id_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HideAndSeekMapInfoOuterClass.internal_static_HideAndSeekMapInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HideAndSeekMapInfoOuterClass.internal_static_HideAndSeekMapInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HideAndSeekMapInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HideAndSeekMapInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.matchLockReasonList_ = HideAndSeekMapInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.id_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HideAndSeekMapInfoOuterClass.internal_static_HideAndSeekMapInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HideAndSeekMapInfo getDefaultInstanceForType() {
                return HideAndSeekMapInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HideAndSeekMapInfo build() {
                HideAndSeekMapInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HideAndSeekMapInfo buildPartial() {
                HideAndSeekMapInfo result = new HideAndSeekMapInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.matchLockReasonList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.matchLockReasonList_ = this.matchLockReasonList_;
                result.id_ = this.id_;
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
                if (other instanceof HideAndSeekMapInfo) {
                    return mergeFrom((HideAndSeekMapInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HideAndSeekMapInfo other) {
                if (other == HideAndSeekMapInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.matchLockReasonList_.isEmpty()) {
                    if (this.matchLockReasonList_.isEmpty()) {
                        this.matchLockReasonList_ = other.matchLockReasonList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureMatchLockReasonListIsMutable();
                        this.matchLockReasonList_.addAll(other.matchLockReasonList_);
                    }
                    onChanged();
                }
                if (other.getId() != 0) {
                    setId(other.getId());
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
                HideAndSeekMapInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HideAndSeekMapInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HideAndSeekMapInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMatchLockReasonListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.matchLockReasonList_ = HideAndSeekMapInfo.mutableCopy(this.matchLockReasonList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder
            public List<Integer> getMatchLockReasonListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.matchLockReasonList_) : this.matchLockReasonList_;
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder
            public int getMatchLockReasonListCount() {
                return this.matchLockReasonList_.size();
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder
            public int getMatchLockReasonList(int index) {
                return this.matchLockReasonList_.getInt(index);
            }

            public Builder setMatchLockReasonList(int index, int value) {
                ensureMatchLockReasonListIsMutable();
                this.matchLockReasonList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addMatchLockReasonList(int value) {
                ensureMatchLockReasonListIsMutable();
                this.matchLockReasonList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllMatchLockReasonList(Iterable<? extends Integer> values) {
                ensureMatchLockReasonListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.matchLockReasonList_);
                onChanged();
                return this;
            }

            public Builder clearMatchLockReasonList() {
                this.matchLockReasonList_ = HideAndSeekMapInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
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

        public static HideAndSeekMapInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HideAndSeekMapInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HideAndSeekMapInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HideAndSeekMapInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
