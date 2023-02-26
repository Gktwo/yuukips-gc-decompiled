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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BundleInfoOuterClass.class */
public final class BundleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010BundleInfo.proto\"!\n\nBundleInfo\u0012\u0013\n\u000bfamklmmklpj\u0018\n \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BundleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BundleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BundleInfo_descriptor, new String[]{"Famklmmklpj"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BundleInfoOuterClass$BundleInfoOrBuilder.class */
    public interface BundleInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getFamklmmklpjList();

        int getFamklmmklpjCount();

        int getFamklmmklpj(int i);
    }

    private BundleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BundleInfoOuterClass$BundleInfo.class */
    public static final class BundleInfo extends GeneratedMessageV3 implements BundleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FAMKLMMKLPJ_FIELD_NUMBER = 10;
        private Internal.IntList famklmmklpj_;
        private int famklmmklpjMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final BundleInfo DEFAULT_INSTANCE = new BundleInfo();
        private static final Parser<BundleInfo> PARSER = new AbstractParser<BundleInfo>() { // from class: emu.grasscutter.net.proto.BundleInfoOuterClass.BundleInfo.1
            @Override // com.google.protobuf.Parser
            public BundleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BundleInfo(input, extensionRegistry);
            }
        };

        private BundleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.famklmmklpjMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private BundleInfo() {
            this.famklmmklpjMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.famklmmklpj_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BundleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BundleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 80:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.famklmmklpj_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.famklmmklpj_.addInt(input.readUInt32());
                                    break;
                                case 82:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.famklmmklpj_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.famklmmklpj_.addInt(input.readUInt32());
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
                    this.famklmmklpj_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BundleInfoOuterClass.internal_static_BundleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BundleInfoOuterClass.internal_static_BundleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BundleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BundleInfoOuterClass.BundleInfoOrBuilder
        public List<Integer> getFamklmmklpjList() {
            return this.famklmmklpj_;
        }

        @Override // emu.grasscutter.net.proto.BundleInfoOuterClass.BundleInfoOrBuilder
        public int getFamklmmklpjCount() {
            return this.famklmmklpj_.size();
        }

        @Override // emu.grasscutter.net.proto.BundleInfoOuterClass.BundleInfoOrBuilder
        public int getFamklmmklpj(int index) {
            return this.famklmmklpj_.getInt(index);
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
            if (getFamklmmklpjList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.famklmmklpjMemoizedSerializedSize);
            }
            for (int i = 0; i < this.famklmmklpj_.size(); i++) {
                output.writeUInt32NoTag(this.famklmmklpj_.getInt(i));
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
            for (int i = 0; i < this.famklmmklpj_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.famklmmklpj_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getFamklmmklpjList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.famklmmklpjMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BundleInfo)) {
                return equals(obj);
            }
            BundleInfo other = (BundleInfo) obj;
            return getFamklmmklpjList().equals(other.getFamklmmklpjList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getFamklmmklpjCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getFamklmmklpjList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BundleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BundleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BundleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BundleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BundleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BundleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BundleInfo parseFrom(InputStream input) throws IOException {
            return (BundleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BundleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BundleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BundleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BundleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BundleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BundleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BundleInfo parseFrom(CodedInputStream input) throws IOException {
            return (BundleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BundleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BundleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BundleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BundleInfoOuterClass$BundleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BundleInfoOrBuilder {
            private int bitField0_;
            private Internal.IntList famklmmklpj_ = BundleInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return BundleInfoOuterClass.internal_static_BundleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BundleInfoOuterClass.internal_static_BundleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BundleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BundleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.famklmmklpj_ = BundleInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BundleInfoOuterClass.internal_static_BundleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BundleInfo getDefaultInstanceForType() {
                return BundleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BundleInfo build() {
                BundleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BundleInfo buildPartial() {
                BundleInfo result = new BundleInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.famklmmklpj_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.famklmmklpj_ = this.famklmmklpj_;
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
                if (other instanceof BundleInfo) {
                    return mergeFrom((BundleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BundleInfo other) {
                if (other == BundleInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.famklmmklpj_.isEmpty()) {
                    if (this.famklmmklpj_.isEmpty()) {
                        this.famklmmklpj_ = other.famklmmklpj_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFamklmmklpjIsMutable();
                        this.famklmmklpj_.addAll(other.famklmmklpj_);
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
                BundleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BundleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BundleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureFamklmmklpjIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.famklmmklpj_ = BundleInfo.mutableCopy(this.famklmmklpj_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BundleInfoOuterClass.BundleInfoOrBuilder
            public List<Integer> getFamklmmklpjList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.famklmmklpj_) : this.famklmmklpj_;
            }

            @Override // emu.grasscutter.net.proto.BundleInfoOuterClass.BundleInfoOrBuilder
            public int getFamklmmklpjCount() {
                return this.famklmmklpj_.size();
            }

            @Override // emu.grasscutter.net.proto.BundleInfoOuterClass.BundleInfoOrBuilder
            public int getFamklmmklpj(int index) {
                return this.famklmmklpj_.getInt(index);
            }

            public Builder setFamklmmklpj(int index, int value) {
                ensureFamklmmklpjIsMutable();
                this.famklmmklpj_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFamklmmklpj(int value) {
                ensureFamklmmklpjIsMutable();
                this.famklmmklpj_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFamklmmklpj(Iterable<? extends Integer> values) {
                ensureFamklmmklpjIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.famklmmklpj_);
                onChanged();
                return this;
            }

            public Builder clearFamklmmklpj() {
                this.famklmmklpj_ = BundleInfo.emptyIntList();
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

        public static BundleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BundleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BundleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BundleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
