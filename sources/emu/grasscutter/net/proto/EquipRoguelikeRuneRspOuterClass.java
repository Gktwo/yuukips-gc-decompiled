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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipRoguelikeRuneRspOuterClass.class */
public final class EquipRoguelikeRuneRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bEquipRoguelikeRuneRsp.proto\";\n\u0015EquipRoguelikeRuneRsp\u0012\u0011\n\trune_list\u0018\u0006 \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EquipRoguelikeRuneRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EquipRoguelikeRuneRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EquipRoguelikeRuneRsp_descriptor, new String[]{"RuneList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipRoguelikeRuneRspOuterClass$EquipRoguelikeRuneRspOrBuilder.class */
    public interface EquipRoguelikeRuneRspOrBuilder extends MessageOrBuilder {
        List<Integer> getRuneListList();

        int getRuneListCount();

        int getRuneList(int i);

        int getRetcode();
    }

    private EquipRoguelikeRuneRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipRoguelikeRuneRspOuterClass$EquipRoguelikeRuneRsp.class */
    public static final class EquipRoguelikeRuneRsp extends GeneratedMessageV3 implements EquipRoguelikeRuneRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RUNE_LIST_FIELD_NUMBER = 6;
        private Internal.IntList runeList_;
        private int runeListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final EquipRoguelikeRuneRsp DEFAULT_INSTANCE = new EquipRoguelikeRuneRsp();
        private static final Parser<EquipRoguelikeRuneRsp> PARSER = new AbstractParser<EquipRoguelikeRuneRsp>() { // from class: emu.grasscutter.net.proto.EquipRoguelikeRuneRspOuterClass.EquipRoguelikeRuneRsp.1
            @Override // com.google.protobuf.Parser
            public EquipRoguelikeRuneRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EquipRoguelikeRuneRsp(input, extensionRegistry);
            }
        };

        private EquipRoguelikeRuneRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.runeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private EquipRoguelikeRuneRsp() {
            this.runeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.runeList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EquipRoguelikeRuneRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EquipRoguelikeRuneRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 48:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.runeList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.runeList_.addInt(input.readUInt32());
                                    break;
                                case 50:
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
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
            return EquipRoguelikeRuneRspOuterClass.internal_static_EquipRoguelikeRuneRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EquipRoguelikeRuneRspOuterClass.internal_static_EquipRoguelikeRuneRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipRoguelikeRuneRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneRspOuterClass.EquipRoguelikeRuneRspOrBuilder
        public List<Integer> getRuneListList() {
            return this.runeList_;
        }

        @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneRspOuterClass.EquipRoguelikeRuneRspOrBuilder
        public int getRuneListCount() {
            return this.runeList_.size();
        }

        @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneRspOuterClass.EquipRoguelikeRuneRspOrBuilder
        public int getRuneList(int index) {
            return this.runeList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneRspOuterClass.EquipRoguelikeRuneRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            if (getRuneListList().size() > 0) {
                output.writeUInt32NoTag(50);
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
            int size2 = 0;
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.runeList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.runeList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getRuneListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.runeListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EquipRoguelikeRuneRsp)) {
                return equals(obj);
            }
            EquipRoguelikeRuneRsp other = (EquipRoguelikeRuneRsp) obj;
            return getRuneListList().equals(other.getRuneListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getRuneListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getRuneListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 5)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EquipRoguelikeRuneRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EquipRoguelikeRuneRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EquipRoguelikeRuneRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EquipRoguelikeRuneRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EquipRoguelikeRuneRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EquipRoguelikeRuneRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EquipRoguelikeRuneRsp parseFrom(InputStream input) throws IOException {
            return (EquipRoguelikeRuneRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EquipRoguelikeRuneRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EquipRoguelikeRuneRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EquipRoguelikeRuneRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (EquipRoguelikeRuneRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EquipRoguelikeRuneRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EquipRoguelikeRuneRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EquipRoguelikeRuneRsp parseFrom(CodedInputStream input) throws IOException {
            return (EquipRoguelikeRuneRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EquipRoguelikeRuneRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EquipRoguelikeRuneRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EquipRoguelikeRuneRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipRoguelikeRuneRspOuterClass$EquipRoguelikeRuneRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EquipRoguelikeRuneRspOrBuilder {
            private int bitField0_;
            private Internal.IntList runeList_ = EquipRoguelikeRuneRsp.emptyIntList();
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EquipRoguelikeRuneRspOuterClass.internal_static_EquipRoguelikeRuneRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EquipRoguelikeRuneRspOuterClass.internal_static_EquipRoguelikeRuneRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipRoguelikeRuneRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EquipRoguelikeRuneRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.runeList_ = EquipRoguelikeRuneRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EquipRoguelikeRuneRspOuterClass.internal_static_EquipRoguelikeRuneRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EquipRoguelikeRuneRsp getDefaultInstanceForType() {
                return EquipRoguelikeRuneRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EquipRoguelikeRuneRsp build() {
                EquipRoguelikeRuneRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EquipRoguelikeRuneRsp buildPartial() {
                EquipRoguelikeRuneRsp result = new EquipRoguelikeRuneRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.runeList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.runeList_ = this.runeList_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof EquipRoguelikeRuneRsp) {
                    return mergeFrom((EquipRoguelikeRuneRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EquipRoguelikeRuneRsp other) {
                if (other == EquipRoguelikeRuneRsp.getDefaultInstance()) {
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
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                EquipRoguelikeRuneRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = EquipRoguelikeRuneRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EquipRoguelikeRuneRsp) e.getUnfinishedMessage();
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
                    this.runeList_ = EquipRoguelikeRuneRsp.mutableCopy(this.runeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneRspOuterClass.EquipRoguelikeRuneRspOrBuilder
            public List<Integer> getRuneListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.runeList_) : this.runeList_;
            }

            @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneRspOuterClass.EquipRoguelikeRuneRspOrBuilder
            public int getRuneListCount() {
                return this.runeList_.size();
            }

            @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneRspOuterClass.EquipRoguelikeRuneRspOrBuilder
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
                this.runeList_ = EquipRoguelikeRuneRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EquipRoguelikeRuneRspOuterClass.EquipRoguelikeRuneRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
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

        public static EquipRoguelikeRuneRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EquipRoguelikeRuneRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EquipRoguelikeRuneRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EquipRoguelikeRuneRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
