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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipRoguelikeRuneReqOuterClass.class */
public final class EquipRoguelikeRuneReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bEquipRoguelikeRuneReq.proto\")\n\u0015EquipRoguelikeRuneReq\u0012\u0010\n\bruneList\u0018\u000f \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EquipRoguelikeRuneReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EquipRoguelikeRuneReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EquipRoguelikeRuneReq_descriptor, new String[]{"RuneList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipRoguelikeRuneReqOuterClass$EquipRoguelikeRuneReqOrBuilder.class */
    public interface EquipRoguelikeRuneReqOrBuilder extends MessageOrBuilder {
        List<Integer> getRuneListList();

        int getRuneListCount();

        int getRuneList(int i);
    }

    private EquipRoguelikeRuneReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipRoguelikeRuneReqOuterClass$EquipRoguelikeRuneReq.class */
    public static final class EquipRoguelikeRuneReq extends GeneratedMessageV3 implements EquipRoguelikeRuneReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RUNELIST_FIELD_NUMBER = 15;
        private Internal.IntList runeList_;
        private int runeListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final EquipRoguelikeRuneReq DEFAULT_INSTANCE = new EquipRoguelikeRuneReq();
        private static final Parser<EquipRoguelikeRuneReq> PARSER = new AbstractParser<EquipRoguelikeRuneReq>() { // from class: emu.grasscutter.net.proto.EquipRoguelikeRuneReqOuterClass.EquipRoguelikeRuneReq.1
            @Override // com.google.protobuf.Parser
            public EquipRoguelikeRuneReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EquipRoguelikeRuneReq(input, extensionRegistry);
            }
        };

        private EquipRoguelikeRuneReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.runeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private EquipRoguelikeRuneReq() {
            this.runeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.runeList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EquipRoguelikeRuneReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EquipRoguelikeRuneReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 120:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.runeList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.runeList_.addInt(input.readUInt32());
                                    break;
                                case 122:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.runeList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.runeList_.addInt(input.readUInt32());
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
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.runeList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EquipRoguelikeRuneReqOuterClass.internal_static_EquipRoguelikeRuneReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EquipRoguelikeRuneReqOuterClass.internal_static_EquipRoguelikeRuneReq_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipRoguelikeRuneReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneReqOuterClass.EquipRoguelikeRuneReqOrBuilder
        public List<Integer> getRuneListList() {
            return this.runeList_;
        }

        @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneReqOuterClass.EquipRoguelikeRuneReqOrBuilder
        public int getRuneListCount() {
            return this.runeList_.size();
        }

        @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneReqOuterClass.EquipRoguelikeRuneReqOrBuilder
        public int getRuneList(int index) {
            return this.runeList_.getInt(index);
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
            if (getRuneListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.runeListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.runeList_.size(); i++) {
                output.writeUInt32NoTag(this.runeList_.getInt(i));
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
            for (int i = 0; i < this.runeList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.runeList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getRuneListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.runeListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EquipRoguelikeRuneReq)) {
                return equals(obj);
            }
            EquipRoguelikeRuneReq other = (EquipRoguelikeRuneReq) obj;
            return getRuneListList().equals(other.getRuneListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getRuneListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getRuneListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EquipRoguelikeRuneReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EquipRoguelikeRuneReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EquipRoguelikeRuneReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EquipRoguelikeRuneReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EquipRoguelikeRuneReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EquipRoguelikeRuneReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EquipRoguelikeRuneReq parseFrom(InputStream input) throws IOException {
            return (EquipRoguelikeRuneReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EquipRoguelikeRuneReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EquipRoguelikeRuneReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EquipRoguelikeRuneReq parseDelimitedFrom(InputStream input) throws IOException {
            return (EquipRoguelikeRuneReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EquipRoguelikeRuneReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EquipRoguelikeRuneReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EquipRoguelikeRuneReq parseFrom(CodedInputStream input) throws IOException {
            return (EquipRoguelikeRuneReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EquipRoguelikeRuneReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EquipRoguelikeRuneReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EquipRoguelikeRuneReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipRoguelikeRuneReqOuterClass$EquipRoguelikeRuneReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EquipRoguelikeRuneReqOrBuilder {
            private int bitField0_;
            private Internal.IntList runeList_ = EquipRoguelikeRuneReq.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return EquipRoguelikeRuneReqOuterClass.internal_static_EquipRoguelikeRuneReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EquipRoguelikeRuneReqOuterClass.internal_static_EquipRoguelikeRuneReq_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipRoguelikeRuneReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EquipRoguelikeRuneReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.runeList_ = EquipRoguelikeRuneReq.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EquipRoguelikeRuneReqOuterClass.internal_static_EquipRoguelikeRuneReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EquipRoguelikeRuneReq getDefaultInstanceForType() {
                return EquipRoguelikeRuneReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EquipRoguelikeRuneReq build() {
                EquipRoguelikeRuneReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EquipRoguelikeRuneReq buildPartial() {
                EquipRoguelikeRuneReq result = new EquipRoguelikeRuneReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.runeList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.runeList_ = this.runeList_;
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
                if (other instanceof EquipRoguelikeRuneReq) {
                    return mergeFrom((EquipRoguelikeRuneReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EquipRoguelikeRuneReq other) {
                if (other == EquipRoguelikeRuneReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.runeList_.isEmpty()) {
                    if (this.runeList_.isEmpty()) {
                        this.runeList_ = other.runeList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRuneListIsMutable();
                        this.runeList_.addAll(other.runeList_);
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
                EquipRoguelikeRuneReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = EquipRoguelikeRuneReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EquipRoguelikeRuneReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureRuneListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.runeList_ = EquipRoguelikeRuneReq.mutableCopy(this.runeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneReqOuterClass.EquipRoguelikeRuneReqOrBuilder
            public List<Integer> getRuneListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.runeList_) : this.runeList_;
            }

            @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneReqOuterClass.EquipRoguelikeRuneReqOrBuilder
            public int getRuneListCount() {
                return this.runeList_.size();
            }

            @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneReqOuterClass.EquipRoguelikeRuneReqOrBuilder
            public int getRuneList(int index) {
                return this.runeList_.getInt(index);
            }

            public Builder setRuneList(int index, int value) {
                ensureRuneListIsMutable();
                this.runeList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addRuneList(int value) {
                ensureRuneListIsMutable();
                this.runeList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllRuneList(Iterable<? extends Integer> values) {
                ensureRuneListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.runeList_);
                onChanged();
                return this;
            }

            public Builder clearRuneList() {
                this.runeList_ = EquipRoguelikeRuneReq.emptyIntList();
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

        public static EquipRoguelikeRuneReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EquipRoguelikeRuneReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EquipRoguelikeRuneReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EquipRoguelikeRuneReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
