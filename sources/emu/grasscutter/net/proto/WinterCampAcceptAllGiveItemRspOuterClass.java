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
import emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptAllGiveItemRspOuterClass.class */
public final class WinterCampAcceptAllGiveItemRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$WinterCampAcceptAllGiveItemRsp.proto\u001a$WinterCampAcceptItemResultInfo.proto\"s\n\u001eWinterCampAcceptAllGiveItemRsp\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005\u0012@\n\u0017accept_item_result_info\u0018\u0001 \u0003(\u000b2\u001f.WinterCampAcceptItemResultInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WinterCampAcceptItemResultInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WinterCampAcceptAllGiveItemRsp_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_WinterCampAcceptAllGiveItemRsp_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f948x7bb50165 = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampAcceptAllGiveItemRsp_descriptor, new String[]{"Retcode", "AcceptItemResultInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptAllGiveItemRspOuterClass$WinterCampAcceptAllGiveItemRspOrBuilder.class */
    public interface WinterCampAcceptAllGiveItemRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo> getAcceptItemResultInfoList();

        WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo getAcceptItemResultInfo(int i);

        int getAcceptItemResultInfoCount();

        List<? extends WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder> getAcceptItemResultInfoOrBuilderList();

        WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder getAcceptItemResultInfoOrBuilder(int i);
    }

    private WinterCampAcceptAllGiveItemRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptAllGiveItemRspOuterClass$WinterCampAcceptAllGiveItemRsp.class */
    public static final class WinterCampAcceptAllGiveItemRsp extends GeneratedMessageV3 implements WinterCampAcceptAllGiveItemRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        public static final int ACCEPT_ITEM_RESULT_INFO_FIELD_NUMBER = 1;
        private List<WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo> acceptItemResultInfo_;
        private byte memoizedIsInitialized;
        private static final WinterCampAcceptAllGiveItemRsp DEFAULT_INSTANCE = new WinterCampAcceptAllGiveItemRsp();
        private static final Parser<WinterCampAcceptAllGiveItemRsp> PARSER = new AbstractParser<WinterCampAcceptAllGiveItemRsp>() { // from class: emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRsp.1
            @Override // com.google.protobuf.Parser
            public WinterCampAcceptAllGiveItemRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampAcceptAllGiveItemRsp(input, extensionRegistry);
            }
        };

        private WinterCampAcceptAllGiveItemRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WinterCampAcceptAllGiveItemRsp() {
            this.memoizedIsInitialized = -1;
            this.acceptItemResultInfo_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampAcceptAllGiveItemRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WinterCampAcceptAllGiveItemRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.acceptItemResultInfo_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.acceptItemResultInfo_.add((WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo) input.readMessage(WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.parser(), extensionRegistry));
                                    break;
                                case 88:
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
                    this.acceptItemResultInfo_ = Collections.unmodifiableList(this.acceptItemResultInfo_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WinterCampAcceptAllGiveItemRspOuterClass.internal_static_WinterCampAcceptAllGiveItemRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampAcceptAllGiveItemRspOuterClass.f948x7bb50165.ensureFieldAccessorsInitialized(WinterCampAcceptAllGiveItemRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
        public List<WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo> getAcceptItemResultInfoList() {
            return this.acceptItemResultInfo_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
        public List<? extends WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder> getAcceptItemResultInfoOrBuilderList() {
            return this.acceptItemResultInfo_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
        public int getAcceptItemResultInfoCount() {
            return this.acceptItemResultInfo_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
        public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo getAcceptItemResultInfo(int index) {
            return this.acceptItemResultInfo_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
        public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder getAcceptItemResultInfoOrBuilder(int index) {
            return this.acceptItemResultInfo_.get(index);
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
            for (int i = 0; i < this.acceptItemResultInfo_.size(); i++) {
                output.writeMessage(1, this.acceptItemResultInfo_.get(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
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
            for (int i = 0; i < this.acceptItemResultInfo_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.acceptItemResultInfo_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(11, this.retcode_);
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
            if (!(obj instanceof WinterCampAcceptAllGiveItemRsp)) {
                return equals(obj);
            }
            WinterCampAcceptAllGiveItemRsp other = (WinterCampAcceptAllGiveItemRsp) obj;
            return getRetcode() == other.getRetcode() && getAcceptItemResultInfoList().equals(other.getAcceptItemResultInfoList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getRetcode();
            if (getAcceptItemResultInfoCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getAcceptItemResultInfoList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WinterCampAcceptAllGiveItemRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampAcceptAllGiveItemRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampAcceptAllGiveItemRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampAcceptAllGiveItemRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampAcceptAllGiveItemRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampAcceptAllGiveItemRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampAcceptAllGiveItemRsp parseFrom(InputStream input) throws IOException {
            return (WinterCampAcceptAllGiveItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampAcceptAllGiveItemRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampAcceptAllGiveItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampAcceptAllGiveItemRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampAcceptAllGiveItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampAcceptAllGiveItemRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampAcceptAllGiveItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampAcceptAllGiveItemRsp parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampAcceptAllGiveItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampAcceptAllGiveItemRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampAcceptAllGiveItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampAcceptAllGiveItemRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptAllGiveItemRspOuterClass$WinterCampAcceptAllGiveItemRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampAcceptAllGiveItemRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private List<WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo> acceptItemResultInfo_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder> acceptItemResultInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampAcceptAllGiveItemRspOuterClass.internal_static_WinterCampAcceptAllGiveItemRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampAcceptAllGiveItemRspOuterClass.f948x7bb50165.ensureFieldAccessorsInitialized(WinterCampAcceptAllGiveItemRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampAcceptAllGiveItemRsp.alwaysUseFieldBuilders) {
                    getAcceptItemResultInfoFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.acceptItemResultInfoBuilder_ == null) {
                    this.acceptItemResultInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.acceptItemResultInfoBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampAcceptAllGiveItemRspOuterClass.internal_static_WinterCampAcceptAllGiveItemRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampAcceptAllGiveItemRsp getDefaultInstanceForType() {
                return WinterCampAcceptAllGiveItemRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampAcceptAllGiveItemRsp build() {
                WinterCampAcceptAllGiveItemRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampAcceptAllGiveItemRsp buildPartial() {
                WinterCampAcceptAllGiveItemRsp result = new WinterCampAcceptAllGiveItemRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.acceptItemResultInfoBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.acceptItemResultInfo_ = Collections.unmodifiableList(this.acceptItemResultInfo_);
                        this.bitField0_ &= -2;
                    }
                    result.acceptItemResultInfo_ = this.acceptItemResultInfo_;
                } else {
                    result.acceptItemResultInfo_ = this.acceptItemResultInfoBuilder_.build();
                }
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
                if (other instanceof WinterCampAcceptAllGiveItemRsp) {
                    return mergeFrom((WinterCampAcceptAllGiveItemRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampAcceptAllGiveItemRsp other) {
                if (other == WinterCampAcceptAllGiveItemRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.acceptItemResultInfoBuilder_ == null) {
                    if (!other.acceptItemResultInfo_.isEmpty()) {
                        if (this.acceptItemResultInfo_.isEmpty()) {
                            this.acceptItemResultInfo_ = other.acceptItemResultInfo_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAcceptItemResultInfoIsMutable();
                            this.acceptItemResultInfo_.addAll(other.acceptItemResultInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.acceptItemResultInfo_.isEmpty()) {
                    if (this.acceptItemResultInfoBuilder_.isEmpty()) {
                        this.acceptItemResultInfoBuilder_.dispose();
                        this.acceptItemResultInfoBuilder_ = null;
                        this.acceptItemResultInfo_ = other.acceptItemResultInfo_;
                        this.bitField0_ &= -2;
                        this.acceptItemResultInfoBuilder_ = WinterCampAcceptAllGiveItemRsp.alwaysUseFieldBuilders ? getAcceptItemResultInfoFieldBuilder() : null;
                    } else {
                        this.acceptItemResultInfoBuilder_.addAllMessages(other.acceptItemResultInfo_);
                    }
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
                WinterCampAcceptAllGiveItemRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampAcceptAllGiveItemRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampAcceptAllGiveItemRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
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

            private void ensureAcceptItemResultInfoIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.acceptItemResultInfo_ = new ArrayList(this.acceptItemResultInfo_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
            public List<WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo> getAcceptItemResultInfoList() {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    return Collections.unmodifiableList(this.acceptItemResultInfo_);
                }
                return this.acceptItemResultInfoBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
            public int getAcceptItemResultInfoCount() {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    return this.acceptItemResultInfo_.size();
                }
                return this.acceptItemResultInfoBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
            public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo getAcceptItemResultInfo(int index) {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    return this.acceptItemResultInfo_.get(index);
                }
                return this.acceptItemResultInfoBuilder_.getMessage(index);
            }

            public Builder setAcceptItemResultInfo(int index, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo value) {
                if (this.acceptItemResultInfoBuilder_ != null) {
                    this.acceptItemResultInfoBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAcceptItemResultInfoIsMutable();
                    this.acceptItemResultInfo_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAcceptItemResultInfo(int index, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder builderForValue) {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    ensureAcceptItemResultInfoIsMutable();
                    this.acceptItemResultInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.acceptItemResultInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAcceptItemResultInfo(WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo value) {
                if (this.acceptItemResultInfoBuilder_ != null) {
                    this.acceptItemResultInfoBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAcceptItemResultInfoIsMutable();
                    this.acceptItemResultInfo_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAcceptItemResultInfo(int index, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo value) {
                if (this.acceptItemResultInfoBuilder_ != null) {
                    this.acceptItemResultInfoBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAcceptItemResultInfoIsMutable();
                    this.acceptItemResultInfo_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAcceptItemResultInfo(WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder builderForValue) {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    ensureAcceptItemResultInfoIsMutable();
                    this.acceptItemResultInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.acceptItemResultInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAcceptItemResultInfo(int index, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder builderForValue) {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    ensureAcceptItemResultInfoIsMutable();
                    this.acceptItemResultInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.acceptItemResultInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAcceptItemResultInfo(Iterable<? extends WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo> values) {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    ensureAcceptItemResultInfoIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.acceptItemResultInfo_);
                    onChanged();
                } else {
                    this.acceptItemResultInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAcceptItemResultInfo() {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    this.acceptItemResultInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.acceptItemResultInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeAcceptItemResultInfo(int index) {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    ensureAcceptItemResultInfoIsMutable();
                    this.acceptItemResultInfo_.remove(index);
                    onChanged();
                } else {
                    this.acceptItemResultInfoBuilder_.remove(index);
                }
                return this;
            }

            public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder getAcceptItemResultInfoBuilder(int index) {
                return getAcceptItemResultInfoFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
            public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder getAcceptItemResultInfoOrBuilder(int index) {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    return this.acceptItemResultInfo_.get(index);
                }
                return this.acceptItemResultInfoBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptAllGiveItemRspOuterClass.WinterCampAcceptAllGiveItemRspOrBuilder
            public List<? extends WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder> getAcceptItemResultInfoOrBuilderList() {
                if (this.acceptItemResultInfoBuilder_ != null) {
                    return this.acceptItemResultInfoBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.acceptItemResultInfo_);
            }

            public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder addAcceptItemResultInfoBuilder() {
                return getAcceptItemResultInfoFieldBuilder().addBuilder(WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.getDefaultInstance());
            }

            public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder addAcceptItemResultInfoBuilder(int index) {
                return getAcceptItemResultInfoFieldBuilder().addBuilder(index, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.getDefaultInstance());
            }

            public List<WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder> getAcceptItemResultInfoBuilderList() {
                return getAcceptItemResultInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder> getAcceptItemResultInfoFieldBuilder() {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    this.acceptItemResultInfoBuilder_ = new RepeatedFieldBuilderV3<>(this.acceptItemResultInfo_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.acceptItemResultInfo_ = null;
                }
                return this.acceptItemResultInfoBuilder_;
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

        public static WinterCampAcceptAllGiveItemRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampAcceptAllGiveItemRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampAcceptAllGiveItemRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampAcceptAllGiveItemRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WinterCampAcceptItemResultInfoOuterClass.getDescriptor();
    }
}
