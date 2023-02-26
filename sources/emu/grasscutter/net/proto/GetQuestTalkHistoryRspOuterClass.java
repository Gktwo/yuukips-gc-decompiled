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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetQuestTalkHistoryRspOuterClass.class */
public final class GetQuestTalkHistoryRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cGetQuestTalkHistoryRsp.proto\"T\n\u0016GetQuestTalkHistoryRsp\u0012\u000f\n\u0007retcode\u0018\b \u0001(\u0005\u0012\u0015\n\rparentQuestId\u0018\r \u0001(\r\u0012\u0012\n\ntalkIdList\u0018\u0007 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetQuestTalkHistoryRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetQuestTalkHistoryRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetQuestTalkHistoryRsp_descriptor, new String[]{"Retcode", "ParentQuestId", "TalkIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetQuestTalkHistoryRspOuterClass$GetQuestTalkHistoryRspOrBuilder.class */
    public interface GetQuestTalkHistoryRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getParentQuestId();

        List<Integer> getTalkIdListList();

        int getTalkIdListCount();

        int getTalkIdList(int i);
    }

    private GetQuestTalkHistoryRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetQuestTalkHistoryRspOuterClass$GetQuestTalkHistoryRsp.class */
    public static final class GetQuestTalkHistoryRsp extends GeneratedMessageV3 implements GetQuestTalkHistoryRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 8;
        private int retcode_;
        public static final int PARENTQUESTID_FIELD_NUMBER = 13;
        private int parentQuestId_;
        public static final int TALKIDLIST_FIELD_NUMBER = 7;
        private Internal.IntList talkIdList_;
        private int talkIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final GetQuestTalkHistoryRsp DEFAULT_INSTANCE = new GetQuestTalkHistoryRsp();
        private static final Parser<GetQuestTalkHistoryRsp> PARSER = new AbstractParser<GetQuestTalkHistoryRsp>() { // from class: emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRsp.1
            @Override // com.google.protobuf.Parser
            public GetQuestTalkHistoryRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetQuestTalkHistoryRsp(input, extensionRegistry);
            }
        };

        private GetQuestTalkHistoryRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.talkIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetQuestTalkHistoryRsp() {
            this.talkIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.talkIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetQuestTalkHistoryRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetQuestTalkHistoryRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 56:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.talkIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.talkIdList_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.talkIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.talkIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 64:
                                this.retcode_ = input.readInt32();
                                break;
                            case 104:
                                this.parentQuestId_ = input.readUInt32();
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
                    this.talkIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetQuestTalkHistoryRspOuterClass.internal_static_GetQuestTalkHistoryRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetQuestTalkHistoryRspOuterClass.internal_static_GetQuestTalkHistoryRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetQuestTalkHistoryRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRspOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
        }

        @Override // emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRspOrBuilder
        public List<Integer> getTalkIdListList() {
            return this.talkIdList_;
        }

        @Override // emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRspOrBuilder
        public int getTalkIdListCount() {
            return this.talkIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRspOrBuilder
        public int getTalkIdList(int index) {
            return this.talkIdList_.getInt(index);
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
            if (getTalkIdListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.talkIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.talkIdList_.size(); i++) {
                output.writeUInt32NoTag(this.talkIdList_.getInt(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(8, this.retcode_);
            }
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(13, this.parentQuestId_);
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
            for (int i = 0; i < this.talkIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.talkIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getTalkIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.talkIdListMemoizedSerializedSize = dataSize;
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(8, this.retcode_);
            }
            if (this.parentQuestId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.parentQuestId_);
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
            if (!(obj instanceof GetQuestTalkHistoryRsp)) {
                return equals(obj);
            }
            GetQuestTalkHistoryRsp other = (GetQuestTalkHistoryRsp) obj;
            return getRetcode() == other.getRetcode() && getParentQuestId() == other.getParentQuestId() && getTalkIdListList().equals(other.getTalkIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getRetcode())) + 13)) + getParentQuestId();
            if (getTalkIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getTalkIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetQuestTalkHistoryRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetQuestTalkHistoryRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetQuestTalkHistoryRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetQuestTalkHistoryRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetQuestTalkHistoryRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetQuestTalkHistoryRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetQuestTalkHistoryRsp parseFrom(InputStream input) throws IOException {
            return (GetQuestTalkHistoryRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetQuestTalkHistoryRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetQuestTalkHistoryRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetQuestTalkHistoryRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetQuestTalkHistoryRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetQuestTalkHistoryRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetQuestTalkHistoryRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetQuestTalkHistoryRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetQuestTalkHistoryRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetQuestTalkHistoryRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetQuestTalkHistoryRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetQuestTalkHistoryRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetQuestTalkHistoryRspOuterClass$GetQuestTalkHistoryRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetQuestTalkHistoryRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private int parentQuestId_;
            private Internal.IntList talkIdList_ = GetQuestTalkHistoryRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetQuestTalkHistoryRspOuterClass.internal_static_GetQuestTalkHistoryRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetQuestTalkHistoryRspOuterClass.internal_static_GetQuestTalkHistoryRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetQuestTalkHistoryRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetQuestTalkHistoryRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.parentQuestId_ = 0;
                this.talkIdList_ = GetQuestTalkHistoryRsp.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetQuestTalkHistoryRspOuterClass.internal_static_GetQuestTalkHistoryRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetQuestTalkHistoryRsp getDefaultInstanceForType() {
                return GetQuestTalkHistoryRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetQuestTalkHistoryRsp build() {
                GetQuestTalkHistoryRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetQuestTalkHistoryRsp buildPartial() {
                GetQuestTalkHistoryRsp result = new GetQuestTalkHistoryRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                result.parentQuestId_ = this.parentQuestId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.talkIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.talkIdList_ = this.talkIdList_;
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
                if (other instanceof GetQuestTalkHistoryRsp) {
                    return mergeFrom((GetQuestTalkHistoryRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetQuestTalkHistoryRsp other) {
                if (other == GetQuestTalkHistoryRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
                }
                if (!other.talkIdList_.isEmpty()) {
                    if (this.talkIdList_.isEmpty()) {
                        this.talkIdList_ = other.talkIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTalkIdListIsMutable();
                        this.talkIdList_.addAll(other.talkIdList_);
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
                GetQuestTalkHistoryRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetQuestTalkHistoryRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetQuestTalkHistoryRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRspOrBuilder
            public int getParentQuestId() {
                return this.parentQuestId_;
            }

            public Builder setParentQuestId(int value) {
                this.parentQuestId_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentQuestId() {
                this.parentQuestId_ = 0;
                onChanged();
                return this;
            }

            private void ensureTalkIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.talkIdList_ = GetQuestTalkHistoryRsp.mutableCopy(this.talkIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRspOrBuilder
            public List<Integer> getTalkIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.talkIdList_) : this.talkIdList_;
            }

            @Override // emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRspOrBuilder
            public int getTalkIdListCount() {
                return this.talkIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetQuestTalkHistoryRspOuterClass.GetQuestTalkHistoryRspOrBuilder
            public int getTalkIdList(int index) {
                return this.talkIdList_.getInt(index);
            }

            public Builder setTalkIdList(int index, int value) {
                ensureTalkIdListIsMutable();
                this.talkIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTalkIdList(int value) {
                ensureTalkIdListIsMutable();
                this.talkIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTalkIdList(Iterable<? extends Integer> values) {
                ensureTalkIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.talkIdList_);
                onChanged();
                return this;
            }

            public Builder clearTalkIdList() {
                this.talkIdList_ = GetQuestTalkHistoryRsp.emptyIntList();
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

        public static GetQuestTalkHistoryRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetQuestTalkHistoryRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetQuestTalkHistoryRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetQuestTalkHistoryRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
