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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllUnlockNameCardRspOuterClass.class */
public final class GetAllUnlockNameCardRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dGetAllUnlockNameCardRsp.proto\"@\n\u0017GetAllUnlockNameCardRsp\u0012\u000f\n\u0007retcode\u0018\u000f \u0001(\u0005\u0012\u0014\n\fnameCardList\u0018\f \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetAllUnlockNameCardRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetAllUnlockNameCardRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetAllUnlockNameCardRsp_descriptor, new String[]{"Retcode", "NameCardList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllUnlockNameCardRspOuterClass$GetAllUnlockNameCardRspOrBuilder.class */
    public interface GetAllUnlockNameCardRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<Integer> getNameCardListList();

        int getNameCardListCount();

        int getNameCardList(int i);
    }

    private GetAllUnlockNameCardRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllUnlockNameCardRspOuterClass$GetAllUnlockNameCardRsp.class */
    public static final class GetAllUnlockNameCardRsp extends GeneratedMessageV3 implements GetAllUnlockNameCardRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 15;
        private int retcode_;
        public static final int NAMECARDLIST_FIELD_NUMBER = 12;
        private Internal.IntList nameCardList_;
        private int nameCardListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final GetAllUnlockNameCardRsp DEFAULT_INSTANCE = new GetAllUnlockNameCardRsp();
        private static final Parser<GetAllUnlockNameCardRsp> PARSER = new AbstractParser<GetAllUnlockNameCardRsp>() { // from class: emu.grasscutter.net.proto.GetAllUnlockNameCardRspOuterClass.GetAllUnlockNameCardRsp.1
            @Override // com.google.protobuf.Parser
            public GetAllUnlockNameCardRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetAllUnlockNameCardRsp(input, extensionRegistry);
            }
        };

        private GetAllUnlockNameCardRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.nameCardListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetAllUnlockNameCardRsp() {
            this.nameCardListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.nameCardList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetAllUnlockNameCardRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAllUnlockNameCardRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 96:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.nameCardList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.nameCardList_.addInt(input.readUInt32());
                                    break;
                                case 98:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.nameCardList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.nameCardList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 120:
                                    this.retcode_ = input.readInt32();
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
                    this.nameCardList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetAllUnlockNameCardRspOuterClass.internal_static_GetAllUnlockNameCardRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetAllUnlockNameCardRspOuterClass.internal_static_GetAllUnlockNameCardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllUnlockNameCardRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetAllUnlockNameCardRspOuterClass.GetAllUnlockNameCardRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetAllUnlockNameCardRspOuterClass.GetAllUnlockNameCardRspOrBuilder
        public List<Integer> getNameCardListList() {
            return this.nameCardList_;
        }

        @Override // emu.grasscutter.net.proto.GetAllUnlockNameCardRspOuterClass.GetAllUnlockNameCardRspOrBuilder
        public int getNameCardListCount() {
            return this.nameCardList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetAllUnlockNameCardRspOuterClass.GetAllUnlockNameCardRspOrBuilder
        public int getNameCardList(int index) {
            return this.nameCardList_.getInt(index);
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
            if (getNameCardListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.nameCardListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.nameCardList_.size(); i++) {
                output.writeUInt32NoTag(this.nameCardList_.getInt(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(15, this.retcode_);
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
            for (int i = 0; i < this.nameCardList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.nameCardList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getNameCardListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.nameCardListMemoizedSerializedSize = dataSize;
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(15, this.retcode_);
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
            if (!(obj instanceof GetAllUnlockNameCardRsp)) {
                return equals(obj);
            }
            GetAllUnlockNameCardRsp other = (GetAllUnlockNameCardRsp) obj;
            return getRetcode() == other.getRetcode() && getNameCardListList().equals(other.getNameCardListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getRetcode();
            if (getNameCardListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getNameCardListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetAllUnlockNameCardRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAllUnlockNameCardRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllUnlockNameCardRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAllUnlockNameCardRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllUnlockNameCardRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAllUnlockNameCardRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllUnlockNameCardRsp parseFrom(InputStream input) throws IOException {
            return (GetAllUnlockNameCardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetAllUnlockNameCardRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllUnlockNameCardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetAllUnlockNameCardRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAllUnlockNameCardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetAllUnlockNameCardRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllUnlockNameCardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetAllUnlockNameCardRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetAllUnlockNameCardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetAllUnlockNameCardRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllUnlockNameCardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetAllUnlockNameCardRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllUnlockNameCardRspOuterClass$GetAllUnlockNameCardRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetAllUnlockNameCardRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private Internal.IntList nameCardList_ = GetAllUnlockNameCardRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetAllUnlockNameCardRspOuterClass.internal_static_GetAllUnlockNameCardRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetAllUnlockNameCardRspOuterClass.internal_static_GetAllUnlockNameCardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllUnlockNameCardRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetAllUnlockNameCardRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.nameCardList_ = GetAllUnlockNameCardRsp.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetAllUnlockNameCardRspOuterClass.internal_static_GetAllUnlockNameCardRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetAllUnlockNameCardRsp getDefaultInstanceForType() {
                return GetAllUnlockNameCardRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetAllUnlockNameCardRsp build() {
                GetAllUnlockNameCardRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetAllUnlockNameCardRsp buildPartial() {
                GetAllUnlockNameCardRsp result = new GetAllUnlockNameCardRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if ((this.bitField0_ & 1) != 0) {
                    this.nameCardList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.nameCardList_ = this.nameCardList_;
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
                if (other instanceof GetAllUnlockNameCardRsp) {
                    return mergeFrom((GetAllUnlockNameCardRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetAllUnlockNameCardRsp other) {
                if (other == GetAllUnlockNameCardRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.nameCardList_.isEmpty()) {
                    if (this.nameCardList_.isEmpty()) {
                        this.nameCardList_ = other.nameCardList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureNameCardListIsMutable();
                        this.nameCardList_.addAll(other.nameCardList_);
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
                GetAllUnlockNameCardRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetAllUnlockNameCardRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetAllUnlockNameCardRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetAllUnlockNameCardRspOuterClass.GetAllUnlockNameCardRspOrBuilder
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

            private void ensureNameCardListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.nameCardList_ = GetAllUnlockNameCardRsp.mutableCopy(this.nameCardList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetAllUnlockNameCardRspOuterClass.GetAllUnlockNameCardRspOrBuilder
            public List<Integer> getNameCardListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.nameCardList_) : this.nameCardList_;
            }

            @Override // emu.grasscutter.net.proto.GetAllUnlockNameCardRspOuterClass.GetAllUnlockNameCardRspOrBuilder
            public int getNameCardListCount() {
                return this.nameCardList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetAllUnlockNameCardRspOuterClass.GetAllUnlockNameCardRspOrBuilder
            public int getNameCardList(int index) {
                return this.nameCardList_.getInt(index);
            }

            public Builder setNameCardList(int index, int value) {
                ensureNameCardListIsMutable();
                this.nameCardList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addNameCardList(int value) {
                ensureNameCardListIsMutable();
                this.nameCardList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllNameCardList(Iterable<? extends Integer> values) {
                ensureNameCardListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.nameCardList_);
                onChanged();
                return this;
            }

            public Builder clearNameCardList() {
                this.nameCardList_ = GetAllUnlockNameCardRsp.emptyIntList();
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

        public static GetAllUnlockNameCardRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetAllUnlockNameCardRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetAllUnlockNameCardRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetAllUnlockNameCardRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
