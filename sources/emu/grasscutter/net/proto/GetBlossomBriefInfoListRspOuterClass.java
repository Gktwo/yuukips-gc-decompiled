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
import emu.grasscutter.net.proto.BlossomBriefInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetBlossomBriefInfoListRspOuterClass.class */
public final class GetBlossomBriefInfoListRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n GetBlossomBriefInfoListRsp.proto\u001a\u0016BlossomBriefInfo.proto\"Y\n\u001aGetBlossomBriefInfoListRsp\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005\u0012*\n\u000fbrief_info_list\u0018\u0001 \u0003(\u000b2\u0011.BlossomBriefInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BlossomBriefInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetBlossomBriefInfoListRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetBlossomBriefInfoListRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetBlossomBriefInfoListRsp_descriptor, new String[]{"Retcode", "BriefInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetBlossomBriefInfoListRspOuterClass$GetBlossomBriefInfoListRspOrBuilder.class */
    public interface GetBlossomBriefInfoListRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<BlossomBriefInfoOuterClass.BlossomBriefInfo> getBriefInfoListList();

        BlossomBriefInfoOuterClass.BlossomBriefInfo getBriefInfoList(int i);

        int getBriefInfoListCount();

        List<? extends BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder> getBriefInfoListOrBuilderList();

        BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder getBriefInfoListOrBuilder(int i);
    }

    private GetBlossomBriefInfoListRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetBlossomBriefInfoListRspOuterClass$GetBlossomBriefInfoListRsp.class */
    public static final class GetBlossomBriefInfoListRsp extends GeneratedMessageV3 implements GetBlossomBriefInfoListRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        public static final int BRIEF_INFO_LIST_FIELD_NUMBER = 1;
        private List<BlossomBriefInfoOuterClass.BlossomBriefInfo> briefInfoList_;
        private byte memoizedIsInitialized;
        private static final GetBlossomBriefInfoListRsp DEFAULT_INSTANCE = new GetBlossomBriefInfoListRsp();
        private static final Parser<GetBlossomBriefInfoListRsp> PARSER = new AbstractParser<GetBlossomBriefInfoListRsp>() { // from class: emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRsp.1
            @Override // com.google.protobuf.Parser
            public GetBlossomBriefInfoListRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetBlossomBriefInfoListRsp(input, extensionRegistry);
            }
        };

        private GetBlossomBriefInfoListRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetBlossomBriefInfoListRsp() {
            this.memoizedIsInitialized = -1;
            this.briefInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetBlossomBriefInfoListRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetBlossomBriefInfoListRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.briefInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.briefInfoList_.add((BlossomBriefInfoOuterClass.BlossomBriefInfo) input.readMessage(BlossomBriefInfoOuterClass.BlossomBriefInfo.parser(), extensionRegistry));
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.briefInfoList_ = Collections.unmodifiableList(this.briefInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetBlossomBriefInfoListRspOuterClass.internal_static_GetBlossomBriefInfoListRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetBlossomBriefInfoListRspOuterClass.internal_static_GetBlossomBriefInfoListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetBlossomBriefInfoListRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
        public List<BlossomBriefInfoOuterClass.BlossomBriefInfo> getBriefInfoListList() {
            return this.briefInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
        public List<? extends BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder> getBriefInfoListOrBuilderList() {
            return this.briefInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
        public int getBriefInfoListCount() {
            return this.briefInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
        public BlossomBriefInfoOuterClass.BlossomBriefInfo getBriefInfoList(int index) {
            return this.briefInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
        public BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder getBriefInfoListOrBuilder(int index) {
            return this.briefInfoList_.get(index);
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
            for (int i = 0; i < this.briefInfoList_.size(); i++) {
                output.writeMessage(1, this.briefInfoList_.get(i));
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
            for (int i = 0; i < this.briefInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.briefInfoList_.get(i));
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
            if (!(obj instanceof GetBlossomBriefInfoListRsp)) {
                return equals(obj);
            }
            GetBlossomBriefInfoListRsp other = (GetBlossomBriefInfoListRsp) obj;
            return getRetcode() == other.getRetcode() && getBriefInfoListList().equals(other.getBriefInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getRetcode();
            if (getBriefInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getBriefInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetBlossomBriefInfoListRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetBlossomBriefInfoListRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetBlossomBriefInfoListRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetBlossomBriefInfoListRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetBlossomBriefInfoListRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetBlossomBriefInfoListRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetBlossomBriefInfoListRsp parseFrom(InputStream input) throws IOException {
            return (GetBlossomBriefInfoListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetBlossomBriefInfoListRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetBlossomBriefInfoListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetBlossomBriefInfoListRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetBlossomBriefInfoListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetBlossomBriefInfoListRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetBlossomBriefInfoListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetBlossomBriefInfoListRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetBlossomBriefInfoListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetBlossomBriefInfoListRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetBlossomBriefInfoListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetBlossomBriefInfoListRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetBlossomBriefInfoListRspOuterClass$GetBlossomBriefInfoListRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetBlossomBriefInfoListRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private List<BlossomBriefInfoOuterClass.BlossomBriefInfo> briefInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<BlossomBriefInfoOuterClass.BlossomBriefInfo, BlossomBriefInfoOuterClass.BlossomBriefInfo.Builder, BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder> briefInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetBlossomBriefInfoListRspOuterClass.internal_static_GetBlossomBriefInfoListRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetBlossomBriefInfoListRspOuterClass.internal_static_GetBlossomBriefInfoListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetBlossomBriefInfoListRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetBlossomBriefInfoListRsp.alwaysUseFieldBuilders) {
                    getBriefInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.briefInfoListBuilder_ == null) {
                    this.briefInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.briefInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetBlossomBriefInfoListRspOuterClass.internal_static_GetBlossomBriefInfoListRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetBlossomBriefInfoListRsp getDefaultInstanceForType() {
                return GetBlossomBriefInfoListRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetBlossomBriefInfoListRsp build() {
                GetBlossomBriefInfoListRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetBlossomBriefInfoListRsp buildPartial() {
                GetBlossomBriefInfoListRsp result = new GetBlossomBriefInfoListRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.briefInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.briefInfoList_ = Collections.unmodifiableList(this.briefInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.briefInfoList_ = this.briefInfoList_;
                } else {
                    result.briefInfoList_ = this.briefInfoListBuilder_.build();
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
                if (other instanceof GetBlossomBriefInfoListRsp) {
                    return mergeFrom((GetBlossomBriefInfoListRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetBlossomBriefInfoListRsp other) {
                if (other == GetBlossomBriefInfoListRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.briefInfoListBuilder_ == null) {
                    if (!other.briefInfoList_.isEmpty()) {
                        if (this.briefInfoList_.isEmpty()) {
                            this.briefInfoList_ = other.briefInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBriefInfoListIsMutable();
                            this.briefInfoList_.addAll(other.briefInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.briefInfoList_.isEmpty()) {
                    if (this.briefInfoListBuilder_.isEmpty()) {
                        this.briefInfoListBuilder_.dispose();
                        this.briefInfoListBuilder_ = null;
                        this.briefInfoList_ = other.briefInfoList_;
                        this.bitField0_ &= -2;
                        this.briefInfoListBuilder_ = GetBlossomBriefInfoListRsp.alwaysUseFieldBuilders ? getBriefInfoListFieldBuilder() : null;
                    } else {
                        this.briefInfoListBuilder_.addAllMessages(other.briefInfoList_);
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
                GetBlossomBriefInfoListRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetBlossomBriefInfoListRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetBlossomBriefInfoListRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
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

            private void ensureBriefInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.briefInfoList_ = new ArrayList(this.briefInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
            public List<BlossomBriefInfoOuterClass.BlossomBriefInfo> getBriefInfoListList() {
                if (this.briefInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.briefInfoList_);
                }
                return this.briefInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
            public int getBriefInfoListCount() {
                if (this.briefInfoListBuilder_ == null) {
                    return this.briefInfoList_.size();
                }
                return this.briefInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
            public BlossomBriefInfoOuterClass.BlossomBriefInfo getBriefInfoList(int index) {
                if (this.briefInfoListBuilder_ == null) {
                    return this.briefInfoList_.get(index);
                }
                return this.briefInfoListBuilder_.getMessage(index);
            }

            public Builder setBriefInfoList(int index, BlossomBriefInfoOuterClass.BlossomBriefInfo value) {
                if (this.briefInfoListBuilder_ != null) {
                    this.briefInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBriefInfoListIsMutable();
                    this.briefInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBriefInfoList(int index, BlossomBriefInfoOuterClass.BlossomBriefInfo.Builder builderForValue) {
                if (this.briefInfoListBuilder_ == null) {
                    ensureBriefInfoListIsMutable();
                    this.briefInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.briefInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBriefInfoList(BlossomBriefInfoOuterClass.BlossomBriefInfo value) {
                if (this.briefInfoListBuilder_ != null) {
                    this.briefInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBriefInfoListIsMutable();
                    this.briefInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBriefInfoList(int index, BlossomBriefInfoOuterClass.BlossomBriefInfo value) {
                if (this.briefInfoListBuilder_ != null) {
                    this.briefInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBriefInfoListIsMutable();
                    this.briefInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBriefInfoList(BlossomBriefInfoOuterClass.BlossomBriefInfo.Builder builderForValue) {
                if (this.briefInfoListBuilder_ == null) {
                    ensureBriefInfoListIsMutable();
                    this.briefInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.briefInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBriefInfoList(int index, BlossomBriefInfoOuterClass.BlossomBriefInfo.Builder builderForValue) {
                if (this.briefInfoListBuilder_ == null) {
                    ensureBriefInfoListIsMutable();
                    this.briefInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.briefInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBriefInfoList(Iterable<? extends BlossomBriefInfoOuterClass.BlossomBriefInfo> values) {
                if (this.briefInfoListBuilder_ == null) {
                    ensureBriefInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.briefInfoList_);
                    onChanged();
                } else {
                    this.briefInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBriefInfoList() {
                if (this.briefInfoListBuilder_ == null) {
                    this.briefInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.briefInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBriefInfoList(int index) {
                if (this.briefInfoListBuilder_ == null) {
                    ensureBriefInfoListIsMutable();
                    this.briefInfoList_.remove(index);
                    onChanged();
                } else {
                    this.briefInfoListBuilder_.remove(index);
                }
                return this;
            }

            public BlossomBriefInfoOuterClass.BlossomBriefInfo.Builder getBriefInfoListBuilder(int index) {
                return getBriefInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
            public BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder getBriefInfoListOrBuilder(int index) {
                if (this.briefInfoListBuilder_ == null) {
                    return this.briefInfoList_.get(index);
                }
                return this.briefInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListRspOuterClass.GetBlossomBriefInfoListRspOrBuilder
            public List<? extends BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder> getBriefInfoListOrBuilderList() {
                if (this.briefInfoListBuilder_ != null) {
                    return this.briefInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.briefInfoList_);
            }

            public BlossomBriefInfoOuterClass.BlossomBriefInfo.Builder addBriefInfoListBuilder() {
                return getBriefInfoListFieldBuilder().addBuilder(BlossomBriefInfoOuterClass.BlossomBriefInfo.getDefaultInstance());
            }

            public BlossomBriefInfoOuterClass.BlossomBriefInfo.Builder addBriefInfoListBuilder(int index) {
                return getBriefInfoListFieldBuilder().addBuilder(index, BlossomBriefInfoOuterClass.BlossomBriefInfo.getDefaultInstance());
            }

            public List<BlossomBriefInfoOuterClass.BlossomBriefInfo.Builder> getBriefInfoListBuilderList() {
                return getBriefInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BlossomBriefInfoOuterClass.BlossomBriefInfo, BlossomBriefInfoOuterClass.BlossomBriefInfo.Builder, BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder> getBriefInfoListFieldBuilder() {
                if (this.briefInfoListBuilder_ == null) {
                    this.briefInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.briefInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.briefInfoList_ = null;
                }
                return this.briefInfoListBuilder_;
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

        public static GetBlossomBriefInfoListRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetBlossomBriefInfoListRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetBlossomBriefInfoListRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetBlossomBriefInfoListRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BlossomBriefInfoOuterClass.getDescriptor();
    }
}