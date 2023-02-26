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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CityReputationQuestInfoOuterClass.class */
public final class CityReputationQuestInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dCityReputationQuestInfo.proto\"c\n\u0017CityReputationQuestInfo\u0012\u000e\n\u0006isOpen\u0018\u000e \u0001(\b\u0012\u001b\n\u0013Unk3300_OMGMGDIHDOH\u0018\u0004 \u0003(\r\u0012\u001b\n\u0013Unk3300_IMLDPDMHJBJ\u0018\n \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CityReputationQuestInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CityReputationQuestInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CityReputationQuestInfo_descriptor, new String[]{"IsOpen", "Unk3300OMGMGDIHDOH", "Unk3300IMLDPDMHJBJ"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CityReputationQuestInfoOuterClass$CityReputationQuestInfoOrBuilder.class */
    public interface CityReputationQuestInfoOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        List<Integer> getUnk3300OMGMGDIHDOHList();

        int getUnk3300OMGMGDIHDOHCount();

        int getUnk3300OMGMGDIHDOH(int i);

        List<Integer> getUnk3300IMLDPDMHJBJList();

        int getUnk3300IMLDPDMHJBJCount();

        int getUnk3300IMLDPDMHJBJ(int i);
    }

    private CityReputationQuestInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CityReputationQuestInfoOuterClass$CityReputationQuestInfo.class */
    public static final class CityReputationQuestInfo extends GeneratedMessageV3 implements CityReputationQuestInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISOPEN_FIELD_NUMBER = 14;
        private boolean isOpen_;
        public static final int UNK3300_OMGMGDIHDOH_FIELD_NUMBER = 4;
        private Internal.IntList unk3300OMGMGDIHDOH_;
        private int unk3300OMGMGDIHDOHMemoizedSerializedSize;
        public static final int UNK3300_IMLDPDMHJBJ_FIELD_NUMBER = 10;
        private Internal.IntList unk3300IMLDPDMHJBJ_;
        private int unk3300IMLDPDMHJBJMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final CityReputationQuestInfo DEFAULT_INSTANCE = new CityReputationQuestInfo();
        private static final Parser<CityReputationQuestInfo> PARSER = new AbstractParser<CityReputationQuestInfo>() { // from class: emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfo.1
            @Override // com.google.protobuf.Parser
            public CityReputationQuestInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CityReputationQuestInfo(input, extensionRegistry);
            }
        };

        private CityReputationQuestInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300OMGMGDIHDOHMemoizedSerializedSize = -1;
            this.unk3300IMLDPDMHJBJMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private CityReputationQuestInfo() {
            this.unk3300OMGMGDIHDOHMemoizedSerializedSize = -1;
            this.unk3300IMLDPDMHJBJMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300OMGMGDIHDOH_ = emptyIntList();
            this.unk3300IMLDPDMHJBJ_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CityReputationQuestInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x014f */
        private CityReputationQuestInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300OMGMGDIHDOH_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300OMGMGDIHDOH_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300OMGMGDIHDOH_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300OMGMGDIHDOH_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300IMLDPDMHJBJ_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300IMLDPDMHJBJ_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300IMLDPDMHJBJ_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300IMLDPDMHJBJ_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 112:
                                this.isOpen_ = input.readBool();
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
                    this.unk3300OMGMGDIHDOH_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300IMLDPDMHJBJ_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CityReputationQuestInfoOuterClass.internal_static_CityReputationQuestInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CityReputationQuestInfoOuterClass.internal_static_CityReputationQuestInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CityReputationQuestInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
        public List<Integer> getUnk3300OMGMGDIHDOHList() {
            return this.unk3300OMGMGDIHDOH_;
        }

        @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
        public int getUnk3300OMGMGDIHDOHCount() {
            return this.unk3300OMGMGDIHDOH_.size();
        }

        @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
        public int getUnk3300OMGMGDIHDOH(int index) {
            return this.unk3300OMGMGDIHDOH_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
        public List<Integer> getUnk3300IMLDPDMHJBJList() {
            return this.unk3300IMLDPDMHJBJ_;
        }

        @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
        public int getUnk3300IMLDPDMHJBJCount() {
            return this.unk3300IMLDPDMHJBJ_.size();
        }

        @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
        public int getUnk3300IMLDPDMHJBJ(int index) {
            return this.unk3300IMLDPDMHJBJ_.getInt(index);
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
            if (getUnk3300OMGMGDIHDOHList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.unk3300OMGMGDIHDOHMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300OMGMGDIHDOH_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300OMGMGDIHDOH_.getInt(i));
            }
            if (getUnk3300IMLDPDMHJBJList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.unk3300IMLDPDMHJBJMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300IMLDPDMHJBJ_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300IMLDPDMHJBJ_.getInt(i2));
            }
            if (this.isOpen_) {
                output.writeBool(14, this.isOpen_);
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
            for (int i = 0; i < this.unk3300OMGMGDIHDOH_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300OMGMGDIHDOH_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getUnk3300OMGMGDIHDOHList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300OMGMGDIHDOHMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300IMLDPDMHJBJ_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300IMLDPDMHJBJ_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUnk3300IMLDPDMHJBJList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300IMLDPDMHJBJMemoizedSerializedSize = dataSize2;
            if (this.isOpen_) {
                size3 += CodedOutputStream.computeBoolSize(14, this.isOpen_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CityReputationQuestInfo)) {
                return equals(obj);
            }
            CityReputationQuestInfo other = (CityReputationQuestInfo) obj;
            return getIsOpen() == other.getIsOpen() && getUnk3300OMGMGDIHDOHList().equals(other.getUnk3300OMGMGDIHDOHList()) && getUnk3300IMLDPDMHJBJList().equals(other.getUnk3300IMLDPDMHJBJList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + Internal.hashBoolean(getIsOpen());
            if (getUnk3300OMGMGDIHDOHCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getUnk3300OMGMGDIHDOHList().hashCode();
            }
            if (getUnk3300IMLDPDMHJBJCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getUnk3300IMLDPDMHJBJList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CityReputationQuestInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CityReputationQuestInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CityReputationQuestInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CityReputationQuestInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CityReputationQuestInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CityReputationQuestInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CityReputationQuestInfo parseFrom(InputStream input) throws IOException {
            return (CityReputationQuestInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CityReputationQuestInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CityReputationQuestInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CityReputationQuestInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CityReputationQuestInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CityReputationQuestInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CityReputationQuestInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CityReputationQuestInfo parseFrom(CodedInputStream input) throws IOException {
            return (CityReputationQuestInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CityReputationQuestInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CityReputationQuestInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CityReputationQuestInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CityReputationQuestInfoOuterClass$CityReputationQuestInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CityReputationQuestInfoOrBuilder {
            private int bitField0_;
            private boolean isOpen_;
            private Internal.IntList unk3300OMGMGDIHDOH_ = CityReputationQuestInfo.emptyIntList();
            private Internal.IntList unk3300IMLDPDMHJBJ_ = CityReputationQuestInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return CityReputationQuestInfoOuterClass.internal_static_CityReputationQuestInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CityReputationQuestInfoOuterClass.internal_static_CityReputationQuestInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CityReputationQuestInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CityReputationQuestInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                this.unk3300OMGMGDIHDOH_ = CityReputationQuestInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.unk3300IMLDPDMHJBJ_ = CityReputationQuestInfo.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CityReputationQuestInfoOuterClass.internal_static_CityReputationQuestInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CityReputationQuestInfo getDefaultInstanceForType() {
                return CityReputationQuestInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CityReputationQuestInfo build() {
                CityReputationQuestInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CityReputationQuestInfo buildPartial() {
                CityReputationQuestInfo result = new CityReputationQuestInfo(this);
                int i = this.bitField0_;
                result.isOpen_ = this.isOpen_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300OMGMGDIHDOH_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300OMGMGDIHDOH_ = this.unk3300OMGMGDIHDOH_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300IMLDPDMHJBJ_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300IMLDPDMHJBJ_ = this.unk3300IMLDPDMHJBJ_;
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
                if (other instanceof CityReputationQuestInfo) {
                    return mergeFrom((CityReputationQuestInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CityReputationQuestInfo other) {
                if (other == CityReputationQuestInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (!other.unk3300OMGMGDIHDOH_.isEmpty()) {
                    if (this.unk3300OMGMGDIHDOH_.isEmpty()) {
                        this.unk3300OMGMGDIHDOH_ = other.unk3300OMGMGDIHDOH_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300OMGMGDIHDOHIsMutable();
                        this.unk3300OMGMGDIHDOH_.addAll(other.unk3300OMGMGDIHDOH_);
                    }
                    onChanged();
                }
                if (!other.unk3300IMLDPDMHJBJ_.isEmpty()) {
                    if (this.unk3300IMLDPDMHJBJ_.isEmpty()) {
                        this.unk3300IMLDPDMHJBJ_ = other.unk3300IMLDPDMHJBJ_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300IMLDPDMHJBJIsMutable();
                        this.unk3300IMLDPDMHJBJ_.addAll(other.unk3300IMLDPDMHJBJ_);
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
                CityReputationQuestInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CityReputationQuestInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CityReputationQuestInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            private void ensureUnk3300OMGMGDIHDOHIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300OMGMGDIHDOH_ = CityReputationQuestInfo.mutableCopy(this.unk3300OMGMGDIHDOH_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
            public List<Integer> getUnk3300OMGMGDIHDOHList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300OMGMGDIHDOH_) : this.unk3300OMGMGDIHDOH_;
            }

            @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
            public int getUnk3300OMGMGDIHDOHCount() {
                return this.unk3300OMGMGDIHDOH_.size();
            }

            @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
            public int getUnk3300OMGMGDIHDOH(int index) {
                return this.unk3300OMGMGDIHDOH_.getInt(index);
            }

            public Builder setUnk3300OMGMGDIHDOH(int index, int value) {
                ensureUnk3300OMGMGDIHDOHIsMutable();
                this.unk3300OMGMGDIHDOH_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300OMGMGDIHDOH(int value) {
                ensureUnk3300OMGMGDIHDOHIsMutable();
                this.unk3300OMGMGDIHDOH_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300OMGMGDIHDOH(Iterable<? extends Integer> values) {
                ensureUnk3300OMGMGDIHDOHIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300OMGMGDIHDOH_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300OMGMGDIHDOH() {
                this.unk3300OMGMGDIHDOH_ = CityReputationQuestInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureUnk3300IMLDPDMHJBJIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300IMLDPDMHJBJ_ = CityReputationQuestInfo.mutableCopy(this.unk3300IMLDPDMHJBJ_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
            public List<Integer> getUnk3300IMLDPDMHJBJList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300IMLDPDMHJBJ_) : this.unk3300IMLDPDMHJBJ_;
            }

            @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
            public int getUnk3300IMLDPDMHJBJCount() {
                return this.unk3300IMLDPDMHJBJ_.size();
            }

            @Override // emu.grasscutter.net.proto.CityReputationQuestInfoOuterClass.CityReputationQuestInfoOrBuilder
            public int getUnk3300IMLDPDMHJBJ(int index) {
                return this.unk3300IMLDPDMHJBJ_.getInt(index);
            }

            public Builder setUnk3300IMLDPDMHJBJ(int index, int value) {
                ensureUnk3300IMLDPDMHJBJIsMutable();
                this.unk3300IMLDPDMHJBJ_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300IMLDPDMHJBJ(int value) {
                ensureUnk3300IMLDPDMHJBJIsMutable();
                this.unk3300IMLDPDMHJBJ_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300IMLDPDMHJBJ(Iterable<? extends Integer> values) {
                ensureUnk3300IMLDPDMHJBJIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300IMLDPDMHJBJ_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300IMLDPDMHJBJ() {
                this.unk3300IMLDPDMHJBJ_ = CityReputationQuestInfo.emptyIntList();
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

        public static CityReputationQuestInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CityReputationQuestInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CityReputationQuestInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CityReputationQuestInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
