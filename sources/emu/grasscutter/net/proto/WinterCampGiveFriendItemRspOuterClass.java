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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGiveFriendItemRspOuterClass.class */
public final class WinterCampGiveFriendItemRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!WinterCampGiveFriendItemRsp.proto\"J\n\u001bWinterCampGiveFriendItemRsp\u0012\u001a\n\u0012limit_item_id_list\u0018\u0003 \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u000f \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_WinterCampGiveFriendItemRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WinterCampGiveFriendItemRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampGiveFriendItemRsp_descriptor, new String[]{"LimitItemIdList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGiveFriendItemRspOuterClass$WinterCampGiveFriendItemRspOrBuilder.class */
    public interface WinterCampGiveFriendItemRspOrBuilder extends MessageOrBuilder {
        List<Integer> getLimitItemIdListList();

        int getLimitItemIdListCount();

        int getLimitItemIdList(int i);

        int getRetcode();
    }

    private WinterCampGiveFriendItemRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGiveFriendItemRspOuterClass$WinterCampGiveFriendItemRsp.class */
    public static final class WinterCampGiveFriendItemRsp extends GeneratedMessageV3 implements WinterCampGiveFriendItemRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LIMIT_ITEM_ID_LIST_FIELD_NUMBER = 3;
        private Internal.IntList limitItemIdList_;
        private int limitItemIdListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 15;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final WinterCampGiveFriendItemRsp DEFAULT_INSTANCE = new WinterCampGiveFriendItemRsp();
        private static final Parser<WinterCampGiveFriendItemRsp> PARSER = new AbstractParser<WinterCampGiveFriendItemRsp>() { // from class: emu.grasscutter.net.proto.WinterCampGiveFriendItemRspOuterClass.WinterCampGiveFriendItemRsp.1
            @Override // com.google.protobuf.Parser
            public WinterCampGiveFriendItemRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampGiveFriendItemRsp(input, extensionRegistry);
            }
        };

        private WinterCampGiveFriendItemRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.limitItemIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private WinterCampGiveFriendItemRsp() {
            this.limitItemIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.limitItemIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampGiveFriendItemRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WinterCampGiveFriendItemRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.limitItemIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.limitItemIdList_.addInt(input.readUInt32());
                                    break;
                                case 26:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.limitItemIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.limitItemIdList_.addInt(input.readUInt32());
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
                    this.limitItemIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WinterCampGiveFriendItemRspOuterClass.internal_static_WinterCampGiveFriendItemRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampGiveFriendItemRspOuterClass.internal_static_WinterCampGiveFriendItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampGiveFriendItemRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampGiveFriendItemRspOuterClass.WinterCampGiveFriendItemRspOrBuilder
        public List<Integer> getLimitItemIdListList() {
            return this.limitItemIdList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampGiveFriendItemRspOuterClass.WinterCampGiveFriendItemRspOrBuilder
        public int getLimitItemIdListCount() {
            return this.limitItemIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampGiveFriendItemRspOuterClass.WinterCampGiveFriendItemRspOrBuilder
        public int getLimitItemIdList(int index) {
            return this.limitItemIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampGiveFriendItemRspOuterClass.WinterCampGiveFriendItemRspOrBuilder
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
            if (getLimitItemIdListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.limitItemIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.limitItemIdList_.size(); i++) {
                output.writeUInt32NoTag(this.limitItemIdList_.getInt(i));
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
            for (int i = 0; i < this.limitItemIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.limitItemIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getLimitItemIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.limitItemIdListMemoizedSerializedSize = dataSize;
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
            if (!(obj instanceof WinterCampGiveFriendItemRsp)) {
                return equals(obj);
            }
            WinterCampGiveFriendItemRsp other = (WinterCampGiveFriendItemRsp) obj;
            return getLimitItemIdListList().equals(other.getLimitItemIdListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getLimitItemIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getLimitItemIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WinterCampGiveFriendItemRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampGiveFriendItemRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampGiveFriendItemRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampGiveFriendItemRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampGiveFriendItemRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampGiveFriendItemRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampGiveFriendItemRsp parseFrom(InputStream input) throws IOException {
            return (WinterCampGiveFriendItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampGiveFriendItemRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampGiveFriendItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampGiveFriendItemRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampGiveFriendItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampGiveFriendItemRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampGiveFriendItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampGiveFriendItemRsp parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampGiveFriendItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampGiveFriendItemRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampGiveFriendItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampGiveFriendItemRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGiveFriendItemRspOuterClass$WinterCampGiveFriendItemRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampGiveFriendItemRspOrBuilder {
            private int bitField0_;
            private Internal.IntList limitItemIdList_ = WinterCampGiveFriendItemRsp.emptyIntList();
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampGiveFriendItemRspOuterClass.internal_static_WinterCampGiveFriendItemRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampGiveFriendItemRspOuterClass.internal_static_WinterCampGiveFriendItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampGiveFriendItemRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampGiveFriendItemRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.limitItemIdList_ = WinterCampGiveFriendItemRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampGiveFriendItemRspOuterClass.internal_static_WinterCampGiveFriendItemRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampGiveFriendItemRsp getDefaultInstanceForType() {
                return WinterCampGiveFriendItemRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampGiveFriendItemRsp build() {
                WinterCampGiveFriendItemRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampGiveFriendItemRsp buildPartial() {
                WinterCampGiveFriendItemRsp result = new WinterCampGiveFriendItemRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.limitItemIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.limitItemIdList_ = this.limitItemIdList_;
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
                if (other instanceof WinterCampGiveFriendItemRsp) {
                    return mergeFrom((WinterCampGiveFriendItemRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampGiveFriendItemRsp other) {
                if (other == WinterCampGiveFriendItemRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.limitItemIdList_.isEmpty()) {
                    if (this.limitItemIdList_.isEmpty()) {
                        this.limitItemIdList_ = other.limitItemIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLimitItemIdListIsMutable();
                        this.limitItemIdList_.addAll(other.limitItemIdList_);
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
                WinterCampGiveFriendItemRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampGiveFriendItemRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampGiveFriendItemRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureLimitItemIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.limitItemIdList_ = WinterCampGiveFriendItemRsp.mutableCopy(this.limitItemIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampGiveFriendItemRspOuterClass.WinterCampGiveFriendItemRspOrBuilder
            public List<Integer> getLimitItemIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.limitItemIdList_) : this.limitItemIdList_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampGiveFriendItemRspOuterClass.WinterCampGiveFriendItemRspOrBuilder
            public int getLimitItemIdListCount() {
                return this.limitItemIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.WinterCampGiveFriendItemRspOuterClass.WinterCampGiveFriendItemRspOrBuilder
            public int getLimitItemIdList(int index) {
                return this.limitItemIdList_.getInt(index);
            }

            public Builder setLimitItemIdList(int index, int value) {
                ensureLimitItemIdListIsMutable();
                this.limitItemIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLimitItemIdList(int value) {
                ensureLimitItemIdListIsMutable();
                this.limitItemIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLimitItemIdList(Iterable<? extends Integer> values) {
                ensureLimitItemIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.limitItemIdList_);
                onChanged();
                return this;
            }

            public Builder clearLimitItemIdList() {
                this.limitItemIdList_ = WinterCampGiveFriendItemRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WinterCampGiveFriendItemRspOuterClass.WinterCampGiveFriendItemRspOrBuilder
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

        public static WinterCampGiveFriendItemRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampGiveFriendItemRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampGiveFriendItemRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampGiveFriendItemRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
