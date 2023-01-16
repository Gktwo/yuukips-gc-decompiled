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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetFriendShowNameCardInfoRspOuterClass.class */
public final class GetFriendShowNameCardInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"GetFriendShowNameCardInfoRsp.proto\"\\\n\u001cGetFriendShowNameCardInfoRsp\u0012\u001e\n\u0016show_name_card_id_list\u0018\u0005 \u0003(\r\u0012\u000b\n\u0003uid\u0018\t \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0003 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetFriendShowNameCardInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetFriendShowNameCardInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetFriendShowNameCardInfoRsp_descriptor, new String[]{"ShowNameCardIdList", "Uid", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetFriendShowNameCardInfoRspOuterClass$GetFriendShowNameCardInfoRspOrBuilder.class */
    public interface GetFriendShowNameCardInfoRspOrBuilder extends MessageOrBuilder {
        List<Integer> getShowNameCardIdListList();

        int getShowNameCardIdListCount();

        int getShowNameCardIdList(int i);

        int getUid();

        int getRetcode();
    }

    private GetFriendShowNameCardInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetFriendShowNameCardInfoRspOuterClass$GetFriendShowNameCardInfoRsp.class */
    public static final class GetFriendShowNameCardInfoRsp extends GeneratedMessageV3 implements GetFriendShowNameCardInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SHOW_NAME_CARD_ID_LIST_FIELD_NUMBER = 5;
        private Internal.IntList showNameCardIdList_;
        private int showNameCardIdListMemoizedSerializedSize;
        public static final int UID_FIELD_NUMBER = 9;
        private int uid_;
        public static final int RETCODE_FIELD_NUMBER = 3;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetFriendShowNameCardInfoRsp DEFAULT_INSTANCE = new GetFriendShowNameCardInfoRsp();
        private static final Parser<GetFriendShowNameCardInfoRsp> PARSER = new AbstractParser<GetFriendShowNameCardInfoRsp>() { // from class: emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRsp.1
            @Override // com.google.protobuf.Parser
            public GetFriendShowNameCardInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetFriendShowNameCardInfoRsp(input, extensionRegistry);
            }
        };

        private GetFriendShowNameCardInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.showNameCardIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetFriendShowNameCardInfoRsp() {
            this.showNameCardIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.showNameCardIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetFriendShowNameCardInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetFriendShowNameCardInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.retcode_ = input.readInt32();
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.showNameCardIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.showNameCardIdList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.showNameCardIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.showNameCardIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 72:
                                this.uid_ = input.readUInt32();
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
                    this.showNameCardIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetFriendShowNameCardInfoRspOuterClass.internal_static_GetFriendShowNameCardInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetFriendShowNameCardInfoRspOuterClass.internal_static_GetFriendShowNameCardInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetFriendShowNameCardInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRspOrBuilder
        public List<Integer> getShowNameCardIdListList() {
            return this.showNameCardIdList_;
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRspOrBuilder
        public int getShowNameCardIdListCount() {
            return this.showNameCardIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRspOrBuilder
        public int getShowNameCardIdList(int index) {
            return this.showNameCardIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRspOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRspOrBuilder
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
                output.writeInt32(3, this.retcode_);
            }
            if (getShowNameCardIdListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.showNameCardIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.showNameCardIdList_.size(); i++) {
                output.writeUInt32NoTag(this.showNameCardIdList_.getInt(i));
            }
            if (this.uid_ != 0) {
                output.writeUInt32(9, this.uid_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(3, this.retcode_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.showNameCardIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.showNameCardIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getShowNameCardIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.showNameCardIdListMemoizedSerializedSize = dataSize;
            if (this.uid_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(9, this.uid_);
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
            if (!(obj instanceof GetFriendShowNameCardInfoRsp)) {
                return equals(obj);
            }
            GetFriendShowNameCardInfoRsp other = (GetFriendShowNameCardInfoRsp) obj;
            return getShowNameCardIdListList().equals(other.getShowNameCardIdListList()) && getUid() == other.getUid() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getShowNameCardIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getShowNameCardIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 9)) + getUid())) + 3)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetFriendShowNameCardInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetFriendShowNameCardInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetFriendShowNameCardInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetFriendShowNameCardInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetFriendShowNameCardInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetFriendShowNameCardInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetFriendShowNameCardInfoRsp parseFrom(InputStream input) throws IOException {
            return (GetFriendShowNameCardInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetFriendShowNameCardInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFriendShowNameCardInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetFriendShowNameCardInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetFriendShowNameCardInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetFriendShowNameCardInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFriendShowNameCardInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetFriendShowNameCardInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetFriendShowNameCardInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetFriendShowNameCardInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFriendShowNameCardInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetFriendShowNameCardInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetFriendShowNameCardInfoRspOuterClass$GetFriendShowNameCardInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetFriendShowNameCardInfoRspOrBuilder {
            private int bitField0_;
            private Internal.IntList showNameCardIdList_ = GetFriendShowNameCardInfoRsp.emptyIntList();
            private int uid_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetFriendShowNameCardInfoRspOuterClass.internal_static_GetFriendShowNameCardInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetFriendShowNameCardInfoRspOuterClass.internal_static_GetFriendShowNameCardInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetFriendShowNameCardInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetFriendShowNameCardInfoRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.showNameCardIdList_ = GetFriendShowNameCardInfoRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.uid_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetFriendShowNameCardInfoRspOuterClass.internal_static_GetFriendShowNameCardInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetFriendShowNameCardInfoRsp getDefaultInstanceForType() {
                return GetFriendShowNameCardInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetFriendShowNameCardInfoRsp build() {
                GetFriendShowNameCardInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetFriendShowNameCardInfoRsp buildPartial() {
                GetFriendShowNameCardInfoRsp result = new GetFriendShowNameCardInfoRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.showNameCardIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.showNameCardIdList_ = this.showNameCardIdList_;
                result.uid_ = this.uid_;
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
                if (other instanceof GetFriendShowNameCardInfoRsp) {
                    return mergeFrom((GetFriendShowNameCardInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetFriendShowNameCardInfoRsp other) {
                if (other == GetFriendShowNameCardInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.showNameCardIdList_.isEmpty()) {
                    if (this.showNameCardIdList_.isEmpty()) {
                        this.showNameCardIdList_ = other.showNameCardIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureShowNameCardIdListIsMutable();
                        this.showNameCardIdList_.addAll(other.showNameCardIdList_);
                    }
                    onChanged();
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
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
                GetFriendShowNameCardInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetFriendShowNameCardInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetFriendShowNameCardInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureShowNameCardIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.showNameCardIdList_ = GetFriendShowNameCardInfoRsp.mutableCopy(this.showNameCardIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRspOrBuilder
            public List<Integer> getShowNameCardIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.showNameCardIdList_) : this.showNameCardIdList_;
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRspOrBuilder
            public int getShowNameCardIdListCount() {
                return this.showNameCardIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRspOrBuilder
            public int getShowNameCardIdList(int index) {
                return this.showNameCardIdList_.getInt(index);
            }

            public Builder setShowNameCardIdList(int index, int value) {
                ensureShowNameCardIdListIsMutable();
                this.showNameCardIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addShowNameCardIdList(int value) {
                ensureShowNameCardIdListIsMutable();
                this.showNameCardIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllShowNameCardIdList(Iterable<? extends Integer> values) {
                ensureShowNameCardIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.showNameCardIdList_);
                onChanged();
                return this;
            }

            public Builder clearShowNameCardIdList() {
                this.showNameCardIdList_ = GetFriendShowNameCardInfoRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRspOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRspOrBuilder
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

        public static GetFriendShowNameCardInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetFriendShowNameCardInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetFriendShowNameCardInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetFriendShowNameCardInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
