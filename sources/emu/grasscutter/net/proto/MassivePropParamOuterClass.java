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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MassivePropParamOuterClass.class */
public final class MassivePropParamOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016MassivePropParam.proto\"]\n\u0010MassivePropParam\u0012\f\n\u0004type\u0018\u0001 \u0001(\u0005\u0012\u0013\n\u000bbkeclhnchpn\u0018\u0002 \u0003(\r\u0012\u0011\n\tparamList\u0018\u0003 \u0003(\u0002\u0012\u0013\n\u000beejlkopeggc\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MassivePropParam_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MassivePropParam_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MassivePropParam_descriptor, new String[]{"Type", "Bkeclhnchpn", "ParamList", "Eejlkopeggc"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MassivePropParamOuterClass$MassivePropParamOrBuilder.class */
    public interface MassivePropParamOrBuilder extends MessageOrBuilder {
        int getType();

        List<Integer> getBkeclhnchpnList();

        int getBkeclhnchpnCount();

        int getBkeclhnchpn(int i);

        List<Float> getParamListList();

        int getParamListCount();

        float getParamList(int i);

        int getEejlkopeggc();
    }

    private MassivePropParamOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MassivePropParamOuterClass$MassivePropParam.class */
    public static final class MassivePropParam extends GeneratedMessageV3 implements MassivePropParamOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int BKECLHNCHPN_FIELD_NUMBER = 2;
        private Internal.IntList bkeclhnchpn_;
        private int bkeclhnchpnMemoizedSerializedSize;
        public static final int PARAMLIST_FIELD_NUMBER = 3;
        private Internal.FloatList paramList_;
        private int paramListMemoizedSerializedSize;
        public static final int EEJLKOPEGGC_FIELD_NUMBER = 4;
        private int eejlkopeggc_;
        private byte memoizedIsInitialized;
        private static final MassivePropParam DEFAULT_INSTANCE = new MassivePropParam();
        private static final Parser<MassivePropParam> PARSER = new AbstractParser<MassivePropParam>() { // from class: emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParam.1
            @Override // com.google.protobuf.Parser
            public MassivePropParam parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MassivePropParam(input, extensionRegistry);
            }
        };

        private MassivePropParam(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.bkeclhnchpnMemoizedSerializedSize = -1;
            this.paramListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private MassivePropParam() {
            this.bkeclhnchpnMemoizedSerializedSize = -1;
            this.paramListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.bkeclhnchpn_ = emptyIntList();
            this.paramList_ = emptyFloatList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MassivePropParam();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0162 */
        private MassivePropParam(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.type_ = input.readInt32();
                                break;
                            case 16:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.bkeclhnchpn_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.bkeclhnchpn_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.bkeclhnchpn_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.bkeclhnchpn_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 26:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.paramList_ = newFloatList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.paramList_.addFloat(input.readFloat());
                                }
                                input.popLimit(limit2);
                                break;
                            case 29:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.paramList_ = newFloatList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.paramList_.addFloat(input.readFloat());
                                break;
                            case 32:
                                this.eejlkopeggc_ = input.readUInt32();
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
                    this.bkeclhnchpn_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.paramList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MassivePropParamOuterClass.internal_static_MassivePropParam_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MassivePropParamOuterClass.internal_static_MassivePropParam_fieldAccessorTable.ensureFieldAccessorsInitialized(MassivePropParam.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
        public List<Integer> getBkeclhnchpnList() {
            return this.bkeclhnchpn_;
        }

        @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
        public int getBkeclhnchpnCount() {
            return this.bkeclhnchpn_.size();
        }

        @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
        public int getBkeclhnchpn(int index) {
            return this.bkeclhnchpn_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
        public List<Float> getParamListList() {
            return this.paramList_;
        }

        @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
        public int getParamListCount() {
            return this.paramList_.size();
        }

        @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
        public float getParamList(int index) {
            return this.paramList_.getFloat(index);
        }

        @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
        public int getEejlkopeggc() {
            return this.eejlkopeggc_;
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
            if (this.type_ != 0) {
                output.writeInt32(1, this.type_);
            }
            if (getBkeclhnchpnList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.bkeclhnchpnMemoizedSerializedSize);
            }
            for (int i = 0; i < this.bkeclhnchpn_.size(); i++) {
                output.writeUInt32NoTag(this.bkeclhnchpn_.getInt(i));
            }
            if (getParamListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.paramListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.paramList_.size(); i2++) {
                output.writeFloatNoTag(this.paramList_.getFloat(i2));
            }
            if (this.eejlkopeggc_ != 0) {
                output.writeUInt32(4, this.eejlkopeggc_);
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
            if (this.type_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.type_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.bkeclhnchpn_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.bkeclhnchpn_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getBkeclhnchpnList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.bkeclhnchpnMemoizedSerializedSize = dataSize;
            int dataSize2 = 4 * getParamListList().size();
            int size4 = size3 + dataSize2;
            if (!getParamListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.paramListMemoizedSerializedSize = dataSize2;
            if (this.eejlkopeggc_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(4, this.eejlkopeggc_);
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MassivePropParam)) {
                return equals(obj);
            }
            MassivePropParam other = (MassivePropParam) obj;
            return getType() == other.getType() && getBkeclhnchpnList().equals(other.getBkeclhnchpnList()) && getParamListList().equals(other.getParamListList()) && getEejlkopeggc() == other.getEejlkopeggc() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getType();
            if (getBkeclhnchpnCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getBkeclhnchpnList().hashCode();
            }
            if (getParamListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getParamListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 4)) + getEejlkopeggc())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MassivePropParam parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MassivePropParam parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MassivePropParam parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MassivePropParam parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MassivePropParam parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MassivePropParam parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MassivePropParam parseFrom(InputStream input) throws IOException {
            return (MassivePropParam) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MassivePropParam parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MassivePropParam) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MassivePropParam parseDelimitedFrom(InputStream input) throws IOException {
            return (MassivePropParam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MassivePropParam parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MassivePropParam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MassivePropParam parseFrom(CodedInputStream input) throws IOException {
            return (MassivePropParam) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MassivePropParam parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MassivePropParam) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MassivePropParam prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MassivePropParamOuterClass$MassivePropParam$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MassivePropParamOrBuilder {
            private int bitField0_;
            private int type_;
            private Internal.IntList bkeclhnchpn_ = MassivePropParam.emptyIntList();
            private Internal.FloatList paramList_ = MassivePropParam.emptyFloatList();
            private int eejlkopeggc_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MassivePropParamOuterClass.internal_static_MassivePropParam_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MassivePropParamOuterClass.internal_static_MassivePropParam_fieldAccessorTable.ensureFieldAccessorsInitialized(MassivePropParam.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MassivePropParam.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.type_ = 0;
                this.bkeclhnchpn_ = MassivePropParam.emptyIntList();
                this.bitField0_ &= -2;
                this.paramList_ = MassivePropParam.emptyFloatList();
                this.bitField0_ &= -3;
                this.eejlkopeggc_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MassivePropParamOuterClass.internal_static_MassivePropParam_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MassivePropParam getDefaultInstanceForType() {
                return MassivePropParam.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MassivePropParam build() {
                MassivePropParam result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MassivePropParam buildPartial() {
                MassivePropParam result = new MassivePropParam(this);
                int i = this.bitField0_;
                result.type_ = this.type_;
                if ((this.bitField0_ & 1) != 0) {
                    this.bkeclhnchpn_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.bkeclhnchpn_ = this.bkeclhnchpn_;
                if ((this.bitField0_ & 2) != 0) {
                    this.paramList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.paramList_ = this.paramList_;
                result.eejlkopeggc_ = this.eejlkopeggc_;
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
                if (other instanceof MassivePropParam) {
                    return mergeFrom((MassivePropParam) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MassivePropParam other) {
                if (other == MassivePropParam.getDefaultInstance()) {
                    return this;
                }
                if (other.getType() != 0) {
                    setType(other.getType());
                }
                if (!other.bkeclhnchpn_.isEmpty()) {
                    if (this.bkeclhnchpn_.isEmpty()) {
                        this.bkeclhnchpn_ = other.bkeclhnchpn_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureBkeclhnchpnIsMutable();
                        this.bkeclhnchpn_.addAll(other.bkeclhnchpn_);
                    }
                    onChanged();
                }
                if (!other.paramList_.isEmpty()) {
                    if (this.paramList_.isEmpty()) {
                        this.paramList_ = other.paramList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureParamListIsMutable();
                        this.paramList_.addAll(other.paramList_);
                    }
                    onChanged();
                }
                if (other.getEejlkopeggc() != 0) {
                    setEejlkopeggc(other.getEejlkopeggc());
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
                MassivePropParam parsedMessage = null;
                try {
                    try {
                        parsedMessage = MassivePropParam.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MassivePropParam) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            private void ensureBkeclhnchpnIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.bkeclhnchpn_ = MassivePropParam.mutableCopy(this.bkeclhnchpn_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
            public List<Integer> getBkeclhnchpnList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.bkeclhnchpn_) : this.bkeclhnchpn_;
            }

            @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
            public int getBkeclhnchpnCount() {
                return this.bkeclhnchpn_.size();
            }

            @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
            public int getBkeclhnchpn(int index) {
                return this.bkeclhnchpn_.getInt(index);
            }

            public Builder setBkeclhnchpn(int index, int value) {
                ensureBkeclhnchpnIsMutable();
                this.bkeclhnchpn_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addBkeclhnchpn(int value) {
                ensureBkeclhnchpnIsMutable();
                this.bkeclhnchpn_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllBkeclhnchpn(Iterable<? extends Integer> values) {
                ensureBkeclhnchpnIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.bkeclhnchpn_);
                onChanged();
                return this;
            }

            public Builder clearBkeclhnchpn() {
                this.bkeclhnchpn_ = MassivePropParam.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureParamListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.paramList_ = MassivePropParam.mutableCopy(this.paramList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
            public List<Float> getParamListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.paramList_) : this.paramList_;
            }

            @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
            public int getParamListCount() {
                return this.paramList_.size();
            }

            @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
            public float getParamList(int index) {
                return this.paramList_.getFloat(index);
            }

            public Builder setParamList(int index, float value) {
                ensureParamListIsMutable();
                this.paramList_.setFloat(index, value);
                onChanged();
                return this;
            }

            public Builder addParamList(float value) {
                ensureParamListIsMutable();
                this.paramList_.addFloat(value);
                onChanged();
                return this;
            }

            public Builder addAllParamList(Iterable<? extends Float> values) {
                ensureParamListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.paramList_);
                onChanged();
                return this;
            }

            public Builder clearParamList() {
                this.paramList_ = MassivePropParam.emptyFloatList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MassivePropParamOuterClass.MassivePropParamOrBuilder
            public int getEejlkopeggc() {
                return this.eejlkopeggc_;
            }

            public Builder setEejlkopeggc(int value) {
                this.eejlkopeggc_ = value;
                onChanged();
                return this;
            }

            public Builder clearEejlkopeggc() {
                this.eejlkopeggc_ = 0;
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

        public static MassivePropParam getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MassivePropParam> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MassivePropParam> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MassivePropParam getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
