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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TryEnterHomeRspOuterClass.class */
public final class TryEnterHomeRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015TryEnterHomeRsp.proto\"H\n\u000fTryEnterHomeRsp\u0012\u0011\n\ttargetUid\u0018\u000f \u0001(\r\u0012\u0011\n\tparamList\u0018\n \u0003(\r\u0012\u000f\n\u0007retcode\u0018\f \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TryEnterHomeRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TryEnterHomeRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TryEnterHomeRsp_descriptor, new String[]{"TargetUid", "ParamList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TryEnterHomeRspOuterClass$TryEnterHomeRspOrBuilder.class */
    public interface TryEnterHomeRspOrBuilder extends MessageOrBuilder {
        int getTargetUid();

        List<Integer> getParamListList();

        int getParamListCount();

        int getParamList(int i);

        int getRetcode();
    }

    private TryEnterHomeRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TryEnterHomeRspOuterClass$TryEnterHomeRsp.class */
    public static final class TryEnterHomeRsp extends GeneratedMessageV3 implements TryEnterHomeRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TARGETUID_FIELD_NUMBER = 15;
        private int targetUid_;
        public static final int PARAMLIST_FIELD_NUMBER = 10;
        private Internal.IntList paramList_;
        private int paramListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 12;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final TryEnterHomeRsp DEFAULT_INSTANCE = new TryEnterHomeRsp();
        private static final Parser<TryEnterHomeRsp> PARSER = new AbstractParser<TryEnterHomeRsp>() { // from class: emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRsp.1
            @Override // com.google.protobuf.Parser
            public TryEnterHomeRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TryEnterHomeRsp(input, extensionRegistry);
            }
        };

        private TryEnterHomeRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.paramListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private TryEnterHomeRsp() {
            this.paramListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.paramList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TryEnterHomeRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TryEnterHomeRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.paramList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.paramList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.paramList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.paramList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 96:
                                this.retcode_ = input.readInt32();
                                break;
                            case 120:
                                this.targetUid_ = input.readUInt32();
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.paramList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TryEnterHomeRspOuterClass.internal_static_TryEnterHomeRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TryEnterHomeRspOuterClass.internal_static_TryEnterHomeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TryEnterHomeRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRspOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
        }

        @Override // emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRspOrBuilder
        public List<Integer> getParamListList() {
            return this.paramList_;
        }

        @Override // emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRspOrBuilder
        public int getParamListCount() {
            return this.paramList_.size();
        }

        @Override // emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRspOrBuilder
        public int getParamList(int index) {
            return this.paramList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRspOrBuilder
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
            if (getParamListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.paramListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.paramList_.size(); i++) {
                output.writeUInt32NoTag(this.paramList_.getInt(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(12, this.retcode_);
            }
            if (this.targetUid_ != 0) {
                output.writeUInt32(15, this.targetUid_);
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
            for (int i = 0; i < this.paramList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.paramList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getParamListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.paramListMemoizedSerializedSize = dataSize;
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(12, this.retcode_);
            }
            if (this.targetUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.targetUid_);
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
            if (!(obj instanceof TryEnterHomeRsp)) {
                return equals(obj);
            }
            TryEnterHomeRsp other = (TryEnterHomeRsp) obj;
            return getTargetUid() == other.getTargetUid() && getParamListList().equals(other.getParamListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getTargetUid();
            if (getParamListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getParamListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 12)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TryEnterHomeRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TryEnterHomeRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TryEnterHomeRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TryEnterHomeRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TryEnterHomeRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TryEnterHomeRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TryEnterHomeRsp parseFrom(InputStream input) throws IOException {
            return (TryEnterHomeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TryEnterHomeRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TryEnterHomeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TryEnterHomeRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (TryEnterHomeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TryEnterHomeRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TryEnterHomeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TryEnterHomeRsp parseFrom(CodedInputStream input) throws IOException {
            return (TryEnterHomeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TryEnterHomeRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TryEnterHomeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TryEnterHomeRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TryEnterHomeRspOuterClass$TryEnterHomeRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TryEnterHomeRspOrBuilder {
            private int bitField0_;
            private int targetUid_;
            private Internal.IntList paramList_ = TryEnterHomeRsp.emptyIntList();
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TryEnterHomeRspOuterClass.internal_static_TryEnterHomeRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TryEnterHomeRspOuterClass.internal_static_TryEnterHomeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TryEnterHomeRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TryEnterHomeRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.targetUid_ = 0;
                this.paramList_ = TryEnterHomeRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TryEnterHomeRspOuterClass.internal_static_TryEnterHomeRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TryEnterHomeRsp getDefaultInstanceForType() {
                return TryEnterHomeRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TryEnterHomeRsp build() {
                TryEnterHomeRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TryEnterHomeRsp buildPartial() {
                TryEnterHomeRsp result = new TryEnterHomeRsp(this);
                int i = this.bitField0_;
                result.targetUid_ = this.targetUid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.paramList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.paramList_ = this.paramList_;
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
                if (other instanceof TryEnterHomeRsp) {
                    return mergeFrom((TryEnterHomeRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TryEnterHomeRsp other) {
                if (other == TryEnterHomeRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
                }
                if (!other.paramList_.isEmpty()) {
                    if (this.paramList_.isEmpty()) {
                        this.paramList_ = other.paramList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureParamListIsMutable();
                        this.paramList_.addAll(other.paramList_);
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
                TryEnterHomeRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = TryEnterHomeRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TryEnterHomeRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRspOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
                onChanged();
                return this;
            }

            private void ensureParamListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.paramList_ = TryEnterHomeRsp.mutableCopy(this.paramList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRspOrBuilder
            public List<Integer> getParamListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.paramList_) : this.paramList_;
            }

            @Override // emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRspOrBuilder
            public int getParamListCount() {
                return this.paramList_.size();
            }

            @Override // emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRspOrBuilder
            public int getParamList(int index) {
                return this.paramList_.getInt(index);
            }

            public Builder setParamList(int index, int value) {
                ensureParamListIsMutable();
                this.paramList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addParamList(int value) {
                ensureParamListIsMutable();
                this.paramList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllParamList(Iterable<? extends Integer> values) {
                ensureParamListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.paramList_);
                onChanged();
                return this;
            }

            public Builder clearParamList() {
                this.paramList_ = TryEnterHomeRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TryEnterHomeRspOuterClass.TryEnterHomeRspOrBuilder
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

        public static TryEnterHomeRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TryEnterHomeRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TryEnterHomeRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TryEnterHomeRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
