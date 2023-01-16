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
import emu.grasscutter.net.proto.H5ActivityInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllH5ActivityInfoRspOuterClass.class */
public final class GetAllH5ActivityInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dGetAllH5ActivityInfoRsp.proto\u001a\u0014H5ActivityInfo.proto\"|\n\u0017GetAllH5ActivityInfoRsp\u0012 \n\u0018client_red_dot_timestamp\u0018\u0003 \u0001(\r\u0012.\n\u0015h5_activity_info_list\u0018\u0005 \u0003(\u000b2\u000f.H5ActivityInfo\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{H5ActivityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetAllH5ActivityInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetAllH5ActivityInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetAllH5ActivityInfoRsp_descriptor, new String[]{"ClientRedDotTimestamp", "H5ActivityInfoList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllH5ActivityInfoRspOuterClass$GetAllH5ActivityInfoRspOrBuilder.class */
    public interface GetAllH5ActivityInfoRspOrBuilder extends MessageOrBuilder {
        int getClientRedDotTimestamp();

        List<H5ActivityInfoOuterClass.H5ActivityInfo> getH5ActivityInfoListList();

        H5ActivityInfoOuterClass.H5ActivityInfo getH5ActivityInfoList(int i);

        int getH5ActivityInfoListCount();

        List<? extends H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder> getH5ActivityInfoListOrBuilderList();

        H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder getH5ActivityInfoListOrBuilder(int i);

        int getRetcode();
    }

    private GetAllH5ActivityInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllH5ActivityInfoRspOuterClass$GetAllH5ActivityInfoRsp.class */
    public static final class GetAllH5ActivityInfoRsp extends GeneratedMessageV3 implements GetAllH5ActivityInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CLIENT_RED_DOT_TIMESTAMP_FIELD_NUMBER = 3;
        private int clientRedDotTimestamp_;
        public static final int H5_ACTIVITY_INFO_LIST_FIELD_NUMBER = 5;
        private List<H5ActivityInfoOuterClass.H5ActivityInfo> h5ActivityInfoList_;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetAllH5ActivityInfoRsp DEFAULT_INSTANCE = new GetAllH5ActivityInfoRsp();
        private static final Parser<GetAllH5ActivityInfoRsp> PARSER = new AbstractParser<GetAllH5ActivityInfoRsp>() { // from class: emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRsp.1
            @Override // com.google.protobuf.Parser
            public GetAllH5ActivityInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetAllH5ActivityInfoRsp(input, extensionRegistry);
            }
        };

        private GetAllH5ActivityInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetAllH5ActivityInfoRsp() {
            this.memoizedIsInitialized = -1;
            this.h5ActivityInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetAllH5ActivityInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAllH5ActivityInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.clientRedDotTimestamp_ = input.readUInt32();
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.h5ActivityInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.h5ActivityInfoList_.add((H5ActivityInfoOuterClass.H5ActivityInfo) input.readMessage(H5ActivityInfoOuterClass.H5ActivityInfo.parser(), extensionRegistry));
                                break;
                            case 112:
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.h5ActivityInfoList_ = Collections.unmodifiableList(this.h5ActivityInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetAllH5ActivityInfoRspOuterClass.internal_static_GetAllH5ActivityInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetAllH5ActivityInfoRspOuterClass.internal_static_GetAllH5ActivityInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllH5ActivityInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
        public int getClientRedDotTimestamp() {
            return this.clientRedDotTimestamp_;
        }

        @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
        public List<H5ActivityInfoOuterClass.H5ActivityInfo> getH5ActivityInfoListList() {
            return this.h5ActivityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
        public List<? extends H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder> getH5ActivityInfoListOrBuilderList() {
            return this.h5ActivityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
        public int getH5ActivityInfoListCount() {
            return this.h5ActivityInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
        public H5ActivityInfoOuterClass.H5ActivityInfo getH5ActivityInfoList(int index) {
            return this.h5ActivityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
        public H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder getH5ActivityInfoListOrBuilder(int index) {
            return this.h5ActivityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
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
            if (this.clientRedDotTimestamp_ != 0) {
                output.writeUInt32(3, this.clientRedDotTimestamp_);
            }
            for (int i = 0; i < this.h5ActivityInfoList_.size(); i++) {
                output.writeMessage(5, this.h5ActivityInfoList_.get(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
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
            if (this.clientRedDotTimestamp_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.clientRedDotTimestamp_);
            }
            for (int i = 0; i < this.h5ActivityInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.h5ActivityInfoList_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
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
            if (!(obj instanceof GetAllH5ActivityInfoRsp)) {
                return equals(obj);
            }
            GetAllH5ActivityInfoRsp other = (GetAllH5ActivityInfoRsp) obj;
            return getClientRedDotTimestamp() == other.getClientRedDotTimestamp() && getH5ActivityInfoListList().equals(other.getH5ActivityInfoListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getClientRedDotTimestamp();
            if (getH5ActivityInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getH5ActivityInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 14)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetAllH5ActivityInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAllH5ActivityInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllH5ActivityInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAllH5ActivityInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllH5ActivityInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAllH5ActivityInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllH5ActivityInfoRsp parseFrom(InputStream input) throws IOException {
            return (GetAllH5ActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetAllH5ActivityInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllH5ActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetAllH5ActivityInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAllH5ActivityInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetAllH5ActivityInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllH5ActivityInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetAllH5ActivityInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetAllH5ActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetAllH5ActivityInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllH5ActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetAllH5ActivityInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllH5ActivityInfoRspOuterClass$GetAllH5ActivityInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetAllH5ActivityInfoRspOrBuilder {
            private int bitField0_;
            private int clientRedDotTimestamp_;
            private List<H5ActivityInfoOuterClass.H5ActivityInfo> h5ActivityInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<H5ActivityInfoOuterClass.H5ActivityInfo, H5ActivityInfoOuterClass.H5ActivityInfo.Builder, H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder> h5ActivityInfoListBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetAllH5ActivityInfoRspOuterClass.internal_static_GetAllH5ActivityInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetAllH5ActivityInfoRspOuterClass.internal_static_GetAllH5ActivityInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllH5ActivityInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetAllH5ActivityInfoRsp.alwaysUseFieldBuilders) {
                    getH5ActivityInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.clientRedDotTimestamp_ = 0;
                if (this.h5ActivityInfoListBuilder_ == null) {
                    this.h5ActivityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.h5ActivityInfoListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetAllH5ActivityInfoRspOuterClass.internal_static_GetAllH5ActivityInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetAllH5ActivityInfoRsp getDefaultInstanceForType() {
                return GetAllH5ActivityInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetAllH5ActivityInfoRsp build() {
                GetAllH5ActivityInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetAllH5ActivityInfoRsp buildPartial() {
                GetAllH5ActivityInfoRsp result = new GetAllH5ActivityInfoRsp(this);
                int i = this.bitField0_;
                result.clientRedDotTimestamp_ = this.clientRedDotTimestamp_;
                if (this.h5ActivityInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.h5ActivityInfoList_ = Collections.unmodifiableList(this.h5ActivityInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.h5ActivityInfoList_ = this.h5ActivityInfoList_;
                } else {
                    result.h5ActivityInfoList_ = this.h5ActivityInfoListBuilder_.build();
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
                if (other instanceof GetAllH5ActivityInfoRsp) {
                    return mergeFrom((GetAllH5ActivityInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetAllH5ActivityInfoRsp other) {
                if (other == GetAllH5ActivityInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getClientRedDotTimestamp() != 0) {
                    setClientRedDotTimestamp(other.getClientRedDotTimestamp());
                }
                if (this.h5ActivityInfoListBuilder_ == null) {
                    if (!other.h5ActivityInfoList_.isEmpty()) {
                        if (this.h5ActivityInfoList_.isEmpty()) {
                            this.h5ActivityInfoList_ = other.h5ActivityInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureH5ActivityInfoListIsMutable();
                            this.h5ActivityInfoList_.addAll(other.h5ActivityInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.h5ActivityInfoList_.isEmpty()) {
                    if (this.h5ActivityInfoListBuilder_.isEmpty()) {
                        this.h5ActivityInfoListBuilder_.dispose();
                        this.h5ActivityInfoListBuilder_ = null;
                        this.h5ActivityInfoList_ = other.h5ActivityInfoList_;
                        this.bitField0_ &= -2;
                        this.h5ActivityInfoListBuilder_ = GetAllH5ActivityInfoRsp.alwaysUseFieldBuilders ? getH5ActivityInfoListFieldBuilder() : null;
                    } else {
                        this.h5ActivityInfoListBuilder_.addAllMessages(other.h5ActivityInfoList_);
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
                GetAllH5ActivityInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetAllH5ActivityInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetAllH5ActivityInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
            public int getClientRedDotTimestamp() {
                return this.clientRedDotTimestamp_;
            }

            public Builder setClientRedDotTimestamp(int value) {
                this.clientRedDotTimestamp_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientRedDotTimestamp() {
                this.clientRedDotTimestamp_ = 0;
                onChanged();
                return this;
            }

            private void ensureH5ActivityInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.h5ActivityInfoList_ = new ArrayList(this.h5ActivityInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
            public List<H5ActivityInfoOuterClass.H5ActivityInfo> getH5ActivityInfoListList() {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.h5ActivityInfoList_);
                }
                return this.h5ActivityInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
            public int getH5ActivityInfoListCount() {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    return this.h5ActivityInfoList_.size();
                }
                return this.h5ActivityInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
            public H5ActivityInfoOuterClass.H5ActivityInfo getH5ActivityInfoList(int index) {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    return this.h5ActivityInfoList_.get(index);
                }
                return this.h5ActivityInfoListBuilder_.getMessage(index);
            }

            public Builder setH5ActivityInfoList(int index, H5ActivityInfoOuterClass.H5ActivityInfo value) {
                if (this.h5ActivityInfoListBuilder_ != null) {
                    this.h5ActivityInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureH5ActivityInfoListIsMutable();
                    this.h5ActivityInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setH5ActivityInfoList(int index, H5ActivityInfoOuterClass.H5ActivityInfo.Builder builderForValue) {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    ensureH5ActivityInfoListIsMutable();
                    this.h5ActivityInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.h5ActivityInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addH5ActivityInfoList(H5ActivityInfoOuterClass.H5ActivityInfo value) {
                if (this.h5ActivityInfoListBuilder_ != null) {
                    this.h5ActivityInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureH5ActivityInfoListIsMutable();
                    this.h5ActivityInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addH5ActivityInfoList(int index, H5ActivityInfoOuterClass.H5ActivityInfo value) {
                if (this.h5ActivityInfoListBuilder_ != null) {
                    this.h5ActivityInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureH5ActivityInfoListIsMutable();
                    this.h5ActivityInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addH5ActivityInfoList(H5ActivityInfoOuterClass.H5ActivityInfo.Builder builderForValue) {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    ensureH5ActivityInfoListIsMutable();
                    this.h5ActivityInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.h5ActivityInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addH5ActivityInfoList(int index, H5ActivityInfoOuterClass.H5ActivityInfo.Builder builderForValue) {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    ensureH5ActivityInfoListIsMutable();
                    this.h5ActivityInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.h5ActivityInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllH5ActivityInfoList(Iterable<? extends H5ActivityInfoOuterClass.H5ActivityInfo> values) {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    ensureH5ActivityInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.h5ActivityInfoList_);
                    onChanged();
                } else {
                    this.h5ActivityInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearH5ActivityInfoList() {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    this.h5ActivityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.h5ActivityInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeH5ActivityInfoList(int index) {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    ensureH5ActivityInfoListIsMutable();
                    this.h5ActivityInfoList_.remove(index);
                    onChanged();
                } else {
                    this.h5ActivityInfoListBuilder_.remove(index);
                }
                return this;
            }

            public H5ActivityInfoOuterClass.H5ActivityInfo.Builder getH5ActivityInfoListBuilder(int index) {
                return getH5ActivityInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
            public H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder getH5ActivityInfoListOrBuilder(int index) {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    return this.h5ActivityInfoList_.get(index);
                }
                return this.h5ActivityInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
            public List<? extends H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder> getH5ActivityInfoListOrBuilderList() {
                if (this.h5ActivityInfoListBuilder_ != null) {
                    return this.h5ActivityInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.h5ActivityInfoList_);
            }

            public H5ActivityInfoOuterClass.H5ActivityInfo.Builder addH5ActivityInfoListBuilder() {
                return getH5ActivityInfoListFieldBuilder().addBuilder(H5ActivityInfoOuterClass.H5ActivityInfo.getDefaultInstance());
            }

            public H5ActivityInfoOuterClass.H5ActivityInfo.Builder addH5ActivityInfoListBuilder(int index) {
                return getH5ActivityInfoListFieldBuilder().addBuilder(index, H5ActivityInfoOuterClass.H5ActivityInfo.getDefaultInstance());
            }

            public List<H5ActivityInfoOuterClass.H5ActivityInfo.Builder> getH5ActivityInfoListBuilderList() {
                return getH5ActivityInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<H5ActivityInfoOuterClass.H5ActivityInfo, H5ActivityInfoOuterClass.H5ActivityInfo.Builder, H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder> getH5ActivityInfoListFieldBuilder() {
                if (this.h5ActivityInfoListBuilder_ == null) {
                    this.h5ActivityInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.h5ActivityInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.h5ActivityInfoList_ = null;
                }
                return this.h5ActivityInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetAllH5ActivityInfoRspOuterClass.GetAllH5ActivityInfoRspOrBuilder
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

        public static GetAllH5ActivityInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetAllH5ActivityInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetAllH5ActivityInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetAllH5ActivityInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        H5ActivityInfoOuterClass.getDescriptor();
    }
}
