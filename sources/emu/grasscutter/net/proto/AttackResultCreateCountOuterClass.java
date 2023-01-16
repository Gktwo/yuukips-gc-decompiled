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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackResultCreateCountOuterClass.class */
public final class AttackResultCreateCountOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dAttackResultCreateCount.proto\"S\n\u0017AttackResultCreateCount\u0012\u001b\n\u0013Unk3300_PFFFFJBPKGN\u0018\b \u0003(\r\u0012\u001b\n\u0013Unk3300_MDGFBFBAHPB\u0018\n \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AttackResultCreateCount_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AttackResultCreateCount_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AttackResultCreateCount_descriptor, new String[]{"Unk3300PFFFFJBPKGN", "Unk3300MDGFBFBAHPB"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackResultCreateCountOuterClass$AttackResultCreateCountOrBuilder.class */
    public interface AttackResultCreateCountOrBuilder extends MessageOrBuilder {
        List<Integer> getUnk3300PFFFFJBPKGNList();

        int getUnk3300PFFFFJBPKGNCount();

        int getUnk3300PFFFFJBPKGN(int i);

        List<Integer> getUnk3300MDGFBFBAHPBList();

        int getUnk3300MDGFBFBAHPBCount();

        int getUnk3300MDGFBFBAHPB(int i);
    }

    private AttackResultCreateCountOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackResultCreateCountOuterClass$AttackResultCreateCount.class */
    public static final class AttackResultCreateCount extends GeneratedMessageV3 implements AttackResultCreateCountOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_PFFFFJBPKGN_FIELD_NUMBER = 8;
        private Internal.IntList unk3300PFFFFJBPKGN_;
        private int unk3300PFFFFJBPKGNMemoizedSerializedSize;
        public static final int UNK3300_MDGFBFBAHPB_FIELD_NUMBER = 10;
        private Internal.IntList unk3300MDGFBFBAHPB_;
        private int unk3300MDGFBFBAHPBMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final AttackResultCreateCount DEFAULT_INSTANCE = new AttackResultCreateCount();
        private static final Parser<AttackResultCreateCount> PARSER = new AbstractParser<AttackResultCreateCount>() { // from class: emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCount.1
            @Override // com.google.protobuf.Parser
            public AttackResultCreateCount parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttackResultCreateCount(input, extensionRegistry);
            }
        };

        private AttackResultCreateCount(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300PFFFFJBPKGNMemoizedSerializedSize = -1;
            this.unk3300MDGFBFBAHPBMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AttackResultCreateCount() {
            this.unk3300PFFFFJBPKGNMemoizedSerializedSize = -1;
            this.unk3300MDGFBFBAHPBMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300PFFFFJBPKGN_ = emptyIntList();
            this.unk3300MDGFBFBAHPB_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AttackResultCreateCount();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x013c */
        private AttackResultCreateCount(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300PFFFFJBPKGN_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300PFFFFJBPKGN_.addInt(input.readUInt32());
                                break;
                            case 66:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300PFFFFJBPKGN_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300PFFFFJBPKGN_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300MDGFBFBAHPB_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300MDGFBFBAHPB_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300MDGFBFBAHPB_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300MDGFBFBAHPB_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300PFFFFJBPKGN_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300MDGFBFBAHPB_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttackResultCreateCountOuterClass.internal_static_AttackResultCreateCount_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttackResultCreateCountOuterClass.internal_static_AttackResultCreateCount_fieldAccessorTable.ensureFieldAccessorsInitialized(AttackResultCreateCount.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
        public List<Integer> getUnk3300PFFFFJBPKGNList() {
            return this.unk3300PFFFFJBPKGN_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
        public int getUnk3300PFFFFJBPKGNCount() {
            return this.unk3300PFFFFJBPKGN_.size();
        }

        @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
        public int getUnk3300PFFFFJBPKGN(int index) {
            return this.unk3300PFFFFJBPKGN_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
        public List<Integer> getUnk3300MDGFBFBAHPBList() {
            return this.unk3300MDGFBFBAHPB_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
        public int getUnk3300MDGFBFBAHPBCount() {
            return this.unk3300MDGFBFBAHPB_.size();
        }

        @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
        public int getUnk3300MDGFBFBAHPB(int index) {
            return this.unk3300MDGFBFBAHPB_.getInt(index);
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
            if (getUnk3300PFFFFJBPKGNList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.unk3300PFFFFJBPKGNMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300PFFFFJBPKGN_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300PFFFFJBPKGN_.getInt(i));
            }
            if (getUnk3300MDGFBFBAHPBList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.unk3300MDGFBFBAHPBMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300MDGFBFBAHPB_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300MDGFBFBAHPB_.getInt(i2));
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
            for (int i = 0; i < this.unk3300PFFFFJBPKGN_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300PFFFFJBPKGN_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getUnk3300PFFFFJBPKGNList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300PFFFFJBPKGNMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300MDGFBFBAHPB_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300MDGFBFBAHPB_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUnk3300MDGFBFBAHPBList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300MDGFBFBAHPBMemoizedSerializedSize = dataSize2;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AttackResultCreateCount)) {
                return equals(obj);
            }
            AttackResultCreateCount other = (AttackResultCreateCount) obj;
            return getUnk3300PFFFFJBPKGNList().equals(other.getUnk3300PFFFFJBPKGNList()) && getUnk3300MDGFBFBAHPBList().equals(other.getUnk3300MDGFBFBAHPBList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnk3300PFFFFJBPKGNCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getUnk3300PFFFFJBPKGNList().hashCode();
            }
            if (getUnk3300MDGFBFBAHPBCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getUnk3300MDGFBFBAHPBList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AttackResultCreateCount parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AttackResultCreateCount parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttackResultCreateCount parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AttackResultCreateCount parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttackResultCreateCount parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AttackResultCreateCount parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttackResultCreateCount parseFrom(InputStream input) throws IOException {
            return (AttackResultCreateCount) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AttackResultCreateCount parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttackResultCreateCount) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AttackResultCreateCount parseDelimitedFrom(InputStream input) throws IOException {
            return (AttackResultCreateCount) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AttackResultCreateCount parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttackResultCreateCount) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AttackResultCreateCount parseFrom(CodedInputStream input) throws IOException {
            return (AttackResultCreateCount) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AttackResultCreateCount parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttackResultCreateCount) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttackResultCreateCount prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackResultCreateCountOuterClass$AttackResultCreateCount$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttackResultCreateCountOrBuilder {
            private int bitField0_;
            private Internal.IntList unk3300PFFFFJBPKGN_ = AttackResultCreateCount.emptyIntList();
            private Internal.IntList unk3300MDGFBFBAHPB_ = AttackResultCreateCount.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return AttackResultCreateCountOuterClass.internal_static_AttackResultCreateCount_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttackResultCreateCountOuterClass.internal_static_AttackResultCreateCount_fieldAccessorTable.ensureFieldAccessorsInitialized(AttackResultCreateCount.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AttackResultCreateCount.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300PFFFFJBPKGN_ = AttackResultCreateCount.emptyIntList();
                this.bitField0_ &= -2;
                this.unk3300MDGFBFBAHPB_ = AttackResultCreateCount.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AttackResultCreateCountOuterClass.internal_static_AttackResultCreateCount_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AttackResultCreateCount getDefaultInstanceForType() {
                return AttackResultCreateCount.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AttackResultCreateCount build() {
                AttackResultCreateCount result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AttackResultCreateCount buildPartial() {
                AttackResultCreateCount result = new AttackResultCreateCount(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300PFFFFJBPKGN_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300PFFFFJBPKGN_ = this.unk3300PFFFFJBPKGN_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300MDGFBFBAHPB_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300MDGFBFBAHPB_ = this.unk3300MDGFBFBAHPB_;
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
                if (other instanceof AttackResultCreateCount) {
                    return mergeFrom((AttackResultCreateCount) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AttackResultCreateCount other) {
                if (other == AttackResultCreateCount.getDefaultInstance()) {
                    return this;
                }
                if (!other.unk3300PFFFFJBPKGN_.isEmpty()) {
                    if (this.unk3300PFFFFJBPKGN_.isEmpty()) {
                        this.unk3300PFFFFJBPKGN_ = other.unk3300PFFFFJBPKGN_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300PFFFFJBPKGNIsMutable();
                        this.unk3300PFFFFJBPKGN_.addAll(other.unk3300PFFFFJBPKGN_);
                    }
                    onChanged();
                }
                if (!other.unk3300MDGFBFBAHPB_.isEmpty()) {
                    if (this.unk3300MDGFBFBAHPB_.isEmpty()) {
                        this.unk3300MDGFBFBAHPB_ = other.unk3300MDGFBFBAHPB_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300MDGFBFBAHPBIsMutable();
                        this.unk3300MDGFBFBAHPB_.addAll(other.unk3300MDGFBFBAHPB_);
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
                AttackResultCreateCount parsedMessage = null;
                try {
                    try {
                        parsedMessage = AttackResultCreateCount.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AttackResultCreateCount) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnk3300PFFFFJBPKGNIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300PFFFFJBPKGN_ = AttackResultCreateCount.mutableCopy(this.unk3300PFFFFJBPKGN_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
            public List<Integer> getUnk3300PFFFFJBPKGNList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300PFFFFJBPKGN_) : this.unk3300PFFFFJBPKGN_;
            }

            @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
            public int getUnk3300PFFFFJBPKGNCount() {
                return this.unk3300PFFFFJBPKGN_.size();
            }

            @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
            public int getUnk3300PFFFFJBPKGN(int index) {
                return this.unk3300PFFFFJBPKGN_.getInt(index);
            }

            public Builder setUnk3300PFFFFJBPKGN(int index, int value) {
                ensureUnk3300PFFFFJBPKGNIsMutable();
                this.unk3300PFFFFJBPKGN_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300PFFFFJBPKGN(int value) {
                ensureUnk3300PFFFFJBPKGNIsMutable();
                this.unk3300PFFFFJBPKGN_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300PFFFFJBPKGN(Iterable<? extends Integer> values) {
                ensureUnk3300PFFFFJBPKGNIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300PFFFFJBPKGN_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300PFFFFJBPKGN() {
                this.unk3300PFFFFJBPKGN_ = AttackResultCreateCount.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureUnk3300MDGFBFBAHPBIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300MDGFBFBAHPB_ = AttackResultCreateCount.mutableCopy(this.unk3300MDGFBFBAHPB_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
            public List<Integer> getUnk3300MDGFBFBAHPBList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300MDGFBFBAHPB_) : this.unk3300MDGFBFBAHPB_;
            }

            @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
            public int getUnk3300MDGFBFBAHPBCount() {
                return this.unk3300MDGFBFBAHPB_.size();
            }

            @Override // emu.grasscutter.net.proto.AttackResultCreateCountOuterClass.AttackResultCreateCountOrBuilder
            public int getUnk3300MDGFBFBAHPB(int index) {
                return this.unk3300MDGFBFBAHPB_.getInt(index);
            }

            public Builder setUnk3300MDGFBFBAHPB(int index, int value) {
                ensureUnk3300MDGFBFBAHPBIsMutable();
                this.unk3300MDGFBFBAHPB_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300MDGFBFBAHPB(int value) {
                ensureUnk3300MDGFBFBAHPBIsMutable();
                this.unk3300MDGFBFBAHPB_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300MDGFBFBAHPB(Iterable<? extends Integer> values) {
                ensureUnk3300MDGFBFBAHPBIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300MDGFBFBAHPB_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300MDGFBFBAHPB() {
                this.unk3300MDGFBFBAHPB_ = AttackResultCreateCount.emptyIntList();
                this.bitField0_ &= -3;
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

        public static AttackResultCreateCount getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttackResultCreateCount> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AttackResultCreateCount> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AttackResultCreateCount getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
