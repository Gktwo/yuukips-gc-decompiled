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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGetRecvItemListRspOuterClass.class */
public final class WinterCampGetRecvItemListRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"WinterCampGetRecvItemListRsp.proto\u001a\u001cWinterCampRecvItemData.proto\"e\n\u001cWinterCampGetRecvItemListRsp\u00124\n\u0013recv_item_data_list\u0018\u0006 \u0003(\u000b2\u0017.WinterCampRecvItemData\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WinterCampRecvItemDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WinterCampGetRecvItemListRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WinterCampGetRecvItemListRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampGetRecvItemListRsp_descriptor, new String[]{"RecvItemDataList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGetRecvItemListRspOuterClass$WinterCampGetRecvItemListRspOrBuilder.class */
    public interface WinterCampGetRecvItemListRspOrBuilder extends MessageOrBuilder {
        List<WinterCampRecvItemDataOuterClass.WinterCampRecvItemData> getRecvItemDataListList();

        WinterCampRecvItemDataOuterClass.WinterCampRecvItemData getRecvItemDataList(int i);

        int getRecvItemDataListCount();

        List<? extends WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder> getRecvItemDataListOrBuilderList();

        WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder getRecvItemDataListOrBuilder(int i);

        int getRetcode();
    }

    private WinterCampGetRecvItemListRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGetRecvItemListRspOuterClass$WinterCampGetRecvItemListRsp.class */
    public static final class WinterCampGetRecvItemListRsp extends GeneratedMessageV3 implements WinterCampGetRecvItemListRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RECV_ITEM_DATA_LIST_FIELD_NUMBER = 6;
        private List<WinterCampRecvItemDataOuterClass.WinterCampRecvItemData> recvItemDataList_;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final WinterCampGetRecvItemListRsp DEFAULT_INSTANCE = new WinterCampGetRecvItemListRsp();
        private static final Parser<WinterCampGetRecvItemListRsp> PARSER = new AbstractParser<WinterCampGetRecvItemListRsp>() { // from class: emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRsp.1
            @Override // com.google.protobuf.Parser
            public WinterCampGetRecvItemListRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampGetRecvItemListRsp(input, extensionRegistry);
            }
        };

        private WinterCampGetRecvItemListRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WinterCampGetRecvItemListRsp() {
            this.memoizedIsInitialized = -1;
            this.recvItemDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampGetRecvItemListRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WinterCampGetRecvItemListRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 50:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.recvItemDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.recvItemDataList_.add((WinterCampRecvItemDataOuterClass.WinterCampRecvItemData) input.readMessage(WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.parser(), extensionRegistry));
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
                    this.recvItemDataList_ = Collections.unmodifiableList(this.recvItemDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WinterCampGetRecvItemListRspOuterClass.internal_static_WinterCampGetRecvItemListRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampGetRecvItemListRspOuterClass.internal_static_WinterCampGetRecvItemListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampGetRecvItemListRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
        public List<WinterCampRecvItemDataOuterClass.WinterCampRecvItemData> getRecvItemDataListList() {
            return this.recvItemDataList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
        public List<? extends WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder> getRecvItemDataListOrBuilderList() {
            return this.recvItemDataList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
        public int getRecvItemDataListCount() {
            return this.recvItemDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
        public WinterCampRecvItemDataOuterClass.WinterCampRecvItemData getRecvItemDataList(int index) {
            return this.recvItemDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
        public WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder getRecvItemDataListOrBuilder(int index) {
            return this.recvItemDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
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
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            for (int i = 0; i < this.recvItemDataList_.size(); i++) {
                output.writeMessage(6, this.recvItemDataList_.get(i));
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
                size2 = 0 + CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            for (int i = 0; i < this.recvItemDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.recvItemDataList_.get(i));
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
            if (!(obj instanceof WinterCampGetRecvItemListRsp)) {
                return equals(obj);
            }
            WinterCampGetRecvItemListRsp other = (WinterCampGetRecvItemListRsp) obj;
            return getRecvItemDataListList().equals(other.getRecvItemDataListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getRecvItemDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getRecvItemDataListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 5)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WinterCampGetRecvItemListRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampGetRecvItemListRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampGetRecvItemListRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampGetRecvItemListRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampGetRecvItemListRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampGetRecvItemListRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampGetRecvItemListRsp parseFrom(InputStream input) throws IOException {
            return (WinterCampGetRecvItemListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampGetRecvItemListRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampGetRecvItemListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampGetRecvItemListRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampGetRecvItemListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampGetRecvItemListRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampGetRecvItemListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampGetRecvItemListRsp parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampGetRecvItemListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampGetRecvItemListRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampGetRecvItemListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampGetRecvItemListRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGetRecvItemListRspOuterClass$WinterCampGetRecvItemListRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampGetRecvItemListRspOrBuilder {
            private int bitField0_;
            private List<WinterCampRecvItemDataOuterClass.WinterCampRecvItemData> recvItemDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<WinterCampRecvItemDataOuterClass.WinterCampRecvItemData, WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder, WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder> recvItemDataListBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampGetRecvItemListRspOuterClass.internal_static_WinterCampGetRecvItemListRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampGetRecvItemListRspOuterClass.internal_static_WinterCampGetRecvItemListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampGetRecvItemListRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampGetRecvItemListRsp.alwaysUseFieldBuilders) {
                    getRecvItemDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.recvItemDataListBuilder_ == null) {
                    this.recvItemDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.recvItemDataListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampGetRecvItemListRspOuterClass.internal_static_WinterCampGetRecvItemListRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampGetRecvItemListRsp getDefaultInstanceForType() {
                return WinterCampGetRecvItemListRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampGetRecvItemListRsp build() {
                WinterCampGetRecvItemListRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampGetRecvItemListRsp buildPartial() {
                WinterCampGetRecvItemListRsp result = new WinterCampGetRecvItemListRsp(this);
                int i = this.bitField0_;
                if (this.recvItemDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.recvItemDataList_ = Collections.unmodifiableList(this.recvItemDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.recvItemDataList_ = this.recvItemDataList_;
                } else {
                    result.recvItemDataList_ = this.recvItemDataListBuilder_.build();
                }
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
                if (other instanceof WinterCampGetRecvItemListRsp) {
                    return mergeFrom((WinterCampGetRecvItemListRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampGetRecvItemListRsp other) {
                if (other == WinterCampGetRecvItemListRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.recvItemDataListBuilder_ == null) {
                    if (!other.recvItemDataList_.isEmpty()) {
                        if (this.recvItemDataList_.isEmpty()) {
                            this.recvItemDataList_ = other.recvItemDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRecvItemDataListIsMutable();
                            this.recvItemDataList_.addAll(other.recvItemDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.recvItemDataList_.isEmpty()) {
                    if (this.recvItemDataListBuilder_.isEmpty()) {
                        this.recvItemDataListBuilder_.dispose();
                        this.recvItemDataListBuilder_ = null;
                        this.recvItemDataList_ = other.recvItemDataList_;
                        this.bitField0_ &= -2;
                        this.recvItemDataListBuilder_ = WinterCampGetRecvItemListRsp.alwaysUseFieldBuilders ? getRecvItemDataListFieldBuilder() : null;
                    } else {
                        this.recvItemDataListBuilder_.addAllMessages(other.recvItemDataList_);
                    }
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
                WinterCampGetRecvItemListRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampGetRecvItemListRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampGetRecvItemListRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureRecvItemDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.recvItemDataList_ = new ArrayList(this.recvItemDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
            public List<WinterCampRecvItemDataOuterClass.WinterCampRecvItemData> getRecvItemDataListList() {
                if (this.recvItemDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.recvItemDataList_);
                }
                return this.recvItemDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
            public int getRecvItemDataListCount() {
                if (this.recvItemDataListBuilder_ == null) {
                    return this.recvItemDataList_.size();
                }
                return this.recvItemDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
            public WinterCampRecvItemDataOuterClass.WinterCampRecvItemData getRecvItemDataList(int index) {
                if (this.recvItemDataListBuilder_ == null) {
                    return this.recvItemDataList_.get(index);
                }
                return this.recvItemDataListBuilder_.getMessage(index);
            }

            public Builder setRecvItemDataList(int index, WinterCampRecvItemDataOuterClass.WinterCampRecvItemData value) {
                if (this.recvItemDataListBuilder_ != null) {
                    this.recvItemDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRecvItemDataListIsMutable();
                    this.recvItemDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRecvItemDataList(int index, WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder builderForValue) {
                if (this.recvItemDataListBuilder_ == null) {
                    ensureRecvItemDataListIsMutable();
                    this.recvItemDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.recvItemDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRecvItemDataList(WinterCampRecvItemDataOuterClass.WinterCampRecvItemData value) {
                if (this.recvItemDataListBuilder_ != null) {
                    this.recvItemDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRecvItemDataListIsMutable();
                    this.recvItemDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRecvItemDataList(int index, WinterCampRecvItemDataOuterClass.WinterCampRecvItemData value) {
                if (this.recvItemDataListBuilder_ != null) {
                    this.recvItemDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRecvItemDataListIsMutable();
                    this.recvItemDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRecvItemDataList(WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder builderForValue) {
                if (this.recvItemDataListBuilder_ == null) {
                    ensureRecvItemDataListIsMutable();
                    this.recvItemDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.recvItemDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRecvItemDataList(int index, WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder builderForValue) {
                if (this.recvItemDataListBuilder_ == null) {
                    ensureRecvItemDataListIsMutable();
                    this.recvItemDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.recvItemDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRecvItemDataList(Iterable<? extends WinterCampRecvItemDataOuterClass.WinterCampRecvItemData> values) {
                if (this.recvItemDataListBuilder_ == null) {
                    ensureRecvItemDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.recvItemDataList_);
                    onChanged();
                } else {
                    this.recvItemDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRecvItemDataList() {
                if (this.recvItemDataListBuilder_ == null) {
                    this.recvItemDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.recvItemDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRecvItemDataList(int index) {
                if (this.recvItemDataListBuilder_ == null) {
                    ensureRecvItemDataListIsMutable();
                    this.recvItemDataList_.remove(index);
                    onChanged();
                } else {
                    this.recvItemDataListBuilder_.remove(index);
                }
                return this;
            }

            public WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder getRecvItemDataListBuilder(int index) {
                return getRecvItemDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
            public WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder getRecvItemDataListOrBuilder(int index) {
                if (this.recvItemDataListBuilder_ == null) {
                    return this.recvItemDataList_.get(index);
                }
                return this.recvItemDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
            public List<? extends WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder> getRecvItemDataListOrBuilderList() {
                if (this.recvItemDataListBuilder_ != null) {
                    return this.recvItemDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.recvItemDataList_);
            }

            public WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder addRecvItemDataListBuilder() {
                return getRecvItemDataListFieldBuilder().addBuilder(WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.getDefaultInstance());
            }

            public WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder addRecvItemDataListBuilder(int index) {
                return getRecvItemDataListFieldBuilder().addBuilder(index, WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.getDefaultInstance());
            }

            public List<WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder> getRecvItemDataListBuilderList() {
                return getRecvItemDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WinterCampRecvItemDataOuterClass.WinterCampRecvItemData, WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder, WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder> getRecvItemDataListFieldBuilder() {
                if (this.recvItemDataListBuilder_ == null) {
                    this.recvItemDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.recvItemDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.recvItemDataList_ = null;
                }
                return this.recvItemDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetRecvItemListRspOuterClass.WinterCampGetRecvItemListRspOrBuilder
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

        public static WinterCampGetRecvItemListRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampGetRecvItemListRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampGetRecvItemListRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampGetRecvItemListRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WinterCampRecvItemDataOuterClass.getDescriptor();
    }
}
