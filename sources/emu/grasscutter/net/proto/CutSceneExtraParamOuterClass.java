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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CutSceneExtraParamOuterClass.class */
public final class CutSceneExtraParamOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018CutSceneExtraParam.proto\"-\n\u0012CutSceneExtraParam\u0012\u0017\n\u000fdetailParamList\u0018\u0003 \u0003(\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CutSceneExtraParam_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CutSceneExtraParam_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CutSceneExtraParam_descriptor, new String[]{"DetailParamList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CutSceneExtraParamOuterClass$CutSceneExtraParamOrBuilder.class */
    public interface CutSceneExtraParamOrBuilder extends MessageOrBuilder {
        List<Double> getDetailParamListList();

        int getDetailParamListCount();

        double getDetailParamList(int i);
    }

    private CutSceneExtraParamOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CutSceneExtraParamOuterClass$CutSceneExtraParam.class */
    public static final class CutSceneExtraParam extends GeneratedMessageV3 implements CutSceneExtraParamOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DETAILPARAMLIST_FIELD_NUMBER = 3;
        private Internal.DoubleList detailParamList_;
        private int detailParamListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final CutSceneExtraParam DEFAULT_INSTANCE = new CutSceneExtraParam();
        private static final Parser<CutSceneExtraParam> PARSER = new AbstractParser<CutSceneExtraParam>() { // from class: emu.grasscutter.net.proto.CutSceneExtraParamOuterClass.CutSceneExtraParam.1
            @Override // com.google.protobuf.Parser
            public CutSceneExtraParam parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CutSceneExtraParam(input, extensionRegistry);
            }
        };

        private CutSceneExtraParam(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailParamListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private CutSceneExtraParam() {
            this.detailParamListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.detailParamList_ = emptyDoubleList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CutSceneExtraParam();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CutSceneExtraParam(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 25:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.detailParamList_ = newDoubleList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.detailParamList_.addDouble(input.readDouble());
                                    break;
                                case 26:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.detailParamList_ = newDoubleList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.detailParamList_.addDouble(input.readDouble());
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
                    this.detailParamList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CutSceneExtraParamOuterClass.internal_static_CutSceneExtraParam_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CutSceneExtraParamOuterClass.internal_static_CutSceneExtraParam_fieldAccessorTable.ensureFieldAccessorsInitialized(CutSceneExtraParam.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder
        public List<Double> getDetailParamListList() {
            return this.detailParamList_;
        }

        @Override // emu.grasscutter.net.proto.CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder
        public int getDetailParamListCount() {
            return this.detailParamList_.size();
        }

        @Override // emu.grasscutter.net.proto.CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder
        public double getDetailParamList(int index) {
            return this.detailParamList_.getDouble(index);
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
            if (getDetailParamListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.detailParamListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.detailParamList_.size(); i++) {
                output.writeDoubleNoTag(this.detailParamList_.getDouble(i));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 8 * getDetailParamListList().size();
            int size2 = 0 + dataSize;
            if (!getDetailParamListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.detailParamListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CutSceneExtraParam)) {
                return equals(obj);
            }
            CutSceneExtraParam other = (CutSceneExtraParam) obj;
            return getDetailParamListList().equals(other.getDetailParamListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDetailParamListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getDetailParamListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CutSceneExtraParam parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CutSceneExtraParam parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CutSceneExtraParam parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CutSceneExtraParam parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CutSceneExtraParam parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CutSceneExtraParam parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CutSceneExtraParam parseFrom(InputStream input) throws IOException {
            return (CutSceneExtraParam) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CutSceneExtraParam parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CutSceneExtraParam) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CutSceneExtraParam parseDelimitedFrom(InputStream input) throws IOException {
            return (CutSceneExtraParam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CutSceneExtraParam parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CutSceneExtraParam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CutSceneExtraParam parseFrom(CodedInputStream input) throws IOException {
            return (CutSceneExtraParam) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CutSceneExtraParam parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CutSceneExtraParam) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CutSceneExtraParam prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CutSceneExtraParamOuterClass$CutSceneExtraParam$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CutSceneExtraParamOrBuilder {
            private int bitField0_;
            private Internal.DoubleList detailParamList_ = CutSceneExtraParam.emptyDoubleList();

            public static final Descriptors.Descriptor getDescriptor() {
                return CutSceneExtraParamOuterClass.internal_static_CutSceneExtraParam_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CutSceneExtraParamOuterClass.internal_static_CutSceneExtraParam_fieldAccessorTable.ensureFieldAccessorsInitialized(CutSceneExtraParam.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CutSceneExtraParam.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.detailParamList_ = CutSceneExtraParam.emptyDoubleList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CutSceneExtraParamOuterClass.internal_static_CutSceneExtraParam_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CutSceneExtraParam getDefaultInstanceForType() {
                return CutSceneExtraParam.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CutSceneExtraParam build() {
                CutSceneExtraParam result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CutSceneExtraParam buildPartial() {
                CutSceneExtraParam result = new CutSceneExtraParam(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.detailParamList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.detailParamList_ = this.detailParamList_;
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
                if (other instanceof CutSceneExtraParam) {
                    return mergeFrom((CutSceneExtraParam) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CutSceneExtraParam other) {
                if (other == CutSceneExtraParam.getDefaultInstance()) {
                    return this;
                }
                if (!other.detailParamList_.isEmpty()) {
                    if (this.detailParamList_.isEmpty()) {
                        this.detailParamList_ = other.detailParamList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDetailParamListIsMutable();
                        this.detailParamList_.addAll(other.detailParamList_);
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
                CutSceneExtraParam parsedMessage = null;
                try {
                    try {
                        parsedMessage = CutSceneExtraParam.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CutSceneExtraParam) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDetailParamListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.detailParamList_ = CutSceneExtraParam.mutableCopy(this.detailParamList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder
            public List<Double> getDetailParamListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.detailParamList_) : this.detailParamList_;
            }

            @Override // emu.grasscutter.net.proto.CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder
            public int getDetailParamListCount() {
                return this.detailParamList_.size();
            }

            @Override // emu.grasscutter.net.proto.CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder
            public double getDetailParamList(int index) {
                return this.detailParamList_.getDouble(index);
            }

            public Builder setDetailParamList(int index, double value) {
                ensureDetailParamListIsMutable();
                this.detailParamList_.setDouble(index, value);
                onChanged();
                return this;
            }

            public Builder addDetailParamList(double value) {
                ensureDetailParamListIsMutable();
                this.detailParamList_.addDouble(value);
                onChanged();
                return this;
            }

            public Builder addAllDetailParamList(Iterable<? extends Double> values) {
                ensureDetailParamListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.detailParamList_);
                onChanged();
                return this;
            }

            public Builder clearDetailParamList() {
                this.detailParamList_ = CutSceneExtraParam.emptyDoubleList();
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

        public static CutSceneExtraParam getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CutSceneExtraParam> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CutSceneExtraParam> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CutSceneExtraParam getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
