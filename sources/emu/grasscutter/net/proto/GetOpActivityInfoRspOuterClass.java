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
import emu.grasscutter.net.proto.OpActivityInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOpActivityInfoRspOuterClass.class */
public final class GetOpActivityInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aGetOpActivityInfoRsp.proto\u001a\u0014OpActivityInfo.proto\"T\n\u0014GetOpActivityInfoRsp\u0012+\n\u0012opActivityInfoList\u0018\u000b \u0003(\u000b2\u000f.OpActivityInfo\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OpActivityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetOpActivityInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetOpActivityInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetOpActivityInfoRsp_descriptor, new String[]{"OpActivityInfoList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOpActivityInfoRspOuterClass$GetOpActivityInfoRspOrBuilder.class */
    public interface GetOpActivityInfoRspOrBuilder extends MessageOrBuilder {
        List<OpActivityInfoOuterClass.OpActivityInfo> getOpActivityInfoListList();

        OpActivityInfoOuterClass.OpActivityInfo getOpActivityInfoList(int i);

        int getOpActivityInfoListCount();

        List<? extends OpActivityInfoOuterClass.OpActivityInfoOrBuilder> getOpActivityInfoListOrBuilderList();

        OpActivityInfoOuterClass.OpActivityInfoOrBuilder getOpActivityInfoListOrBuilder(int i);

        int getRetcode();
    }

    private GetOpActivityInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOpActivityInfoRspOuterClass$GetOpActivityInfoRsp.class */
    public static final class GetOpActivityInfoRsp extends GeneratedMessageV3 implements GetOpActivityInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPACTIVITYINFOLIST_FIELD_NUMBER = 11;
        private List<OpActivityInfoOuterClass.OpActivityInfo> opActivityInfoList_;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetOpActivityInfoRsp DEFAULT_INSTANCE = new GetOpActivityInfoRsp();
        private static final Parser<GetOpActivityInfoRsp> PARSER = new AbstractParser<GetOpActivityInfoRsp>() { // from class: emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRsp.1
            @Override // com.google.protobuf.Parser
            public GetOpActivityInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetOpActivityInfoRsp(input, extensionRegistry);
            }
        };

        private GetOpActivityInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetOpActivityInfoRsp() {
            this.memoizedIsInitialized = -1;
            this.opActivityInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetOpActivityInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetOpActivityInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 90:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.opActivityInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.opActivityInfoList_.add((OpActivityInfoOuterClass.OpActivityInfo) input.readMessage(OpActivityInfoOuterClass.OpActivityInfo.parser(), extensionRegistry));
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
                    this.opActivityInfoList_ = Collections.unmodifiableList(this.opActivityInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetOpActivityInfoRspOuterClass.internal_static_GetOpActivityInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetOpActivityInfoRspOuterClass.internal_static_GetOpActivityInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOpActivityInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
        public List<OpActivityInfoOuterClass.OpActivityInfo> getOpActivityInfoListList() {
            return this.opActivityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
        public List<? extends OpActivityInfoOuterClass.OpActivityInfoOrBuilder> getOpActivityInfoListOrBuilderList() {
            return this.opActivityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
        public int getOpActivityInfoListCount() {
            return this.opActivityInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
        public OpActivityInfoOuterClass.OpActivityInfo getOpActivityInfoList(int index) {
            return this.opActivityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
        public OpActivityInfoOuterClass.OpActivityInfoOrBuilder getOpActivityInfoListOrBuilder(int index) {
            return this.opActivityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
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
            for (int i = 0; i < this.opActivityInfoList_.size(); i++) {
                output.writeMessage(11, this.opActivityInfoList_.get(i));
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
            for (int i = 0; i < this.opActivityInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.opActivityInfoList_.get(i));
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
            if (!(obj instanceof GetOpActivityInfoRsp)) {
                return equals(obj);
            }
            GetOpActivityInfoRsp other = (GetOpActivityInfoRsp) obj;
            return getOpActivityInfoListList().equals(other.getOpActivityInfoListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getOpActivityInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getOpActivityInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 14)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetOpActivityInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOpActivityInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOpActivityInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOpActivityInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOpActivityInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetOpActivityInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOpActivityInfoRsp parseFrom(InputStream input) throws IOException {
            return (GetOpActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetOpActivityInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOpActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetOpActivityInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetOpActivityInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetOpActivityInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOpActivityInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetOpActivityInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetOpActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetOpActivityInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOpActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetOpActivityInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetOpActivityInfoRspOuterClass$GetOpActivityInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetOpActivityInfoRspOrBuilder {
            private int bitField0_;
            private List<OpActivityInfoOuterClass.OpActivityInfo> opActivityInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<OpActivityInfoOuterClass.OpActivityInfo, OpActivityInfoOuterClass.OpActivityInfo.Builder, OpActivityInfoOuterClass.OpActivityInfoOrBuilder> opActivityInfoListBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetOpActivityInfoRspOuterClass.internal_static_GetOpActivityInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetOpActivityInfoRspOuterClass.internal_static_GetOpActivityInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOpActivityInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetOpActivityInfoRsp.alwaysUseFieldBuilders) {
                    getOpActivityInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.opActivityInfoListBuilder_ == null) {
                    this.opActivityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.opActivityInfoListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetOpActivityInfoRspOuterClass.internal_static_GetOpActivityInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetOpActivityInfoRsp getDefaultInstanceForType() {
                return GetOpActivityInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetOpActivityInfoRsp build() {
                GetOpActivityInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetOpActivityInfoRsp buildPartial() {
                GetOpActivityInfoRsp result = new GetOpActivityInfoRsp(this);
                int i = this.bitField0_;
                if (this.opActivityInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.opActivityInfoList_ = Collections.unmodifiableList(this.opActivityInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.opActivityInfoList_ = this.opActivityInfoList_;
                } else {
                    result.opActivityInfoList_ = this.opActivityInfoListBuilder_.build();
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
                if (other instanceof GetOpActivityInfoRsp) {
                    return mergeFrom((GetOpActivityInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetOpActivityInfoRsp other) {
                if (other == GetOpActivityInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.opActivityInfoListBuilder_ == null) {
                    if (!other.opActivityInfoList_.isEmpty()) {
                        if (this.opActivityInfoList_.isEmpty()) {
                            this.opActivityInfoList_ = other.opActivityInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureOpActivityInfoListIsMutable();
                            this.opActivityInfoList_.addAll(other.opActivityInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.opActivityInfoList_.isEmpty()) {
                    if (this.opActivityInfoListBuilder_.isEmpty()) {
                        this.opActivityInfoListBuilder_.dispose();
                        this.opActivityInfoListBuilder_ = null;
                        this.opActivityInfoList_ = other.opActivityInfoList_;
                        this.bitField0_ &= -2;
                        this.opActivityInfoListBuilder_ = GetOpActivityInfoRsp.alwaysUseFieldBuilders ? getOpActivityInfoListFieldBuilder() : null;
                    } else {
                        this.opActivityInfoListBuilder_.addAllMessages(other.opActivityInfoList_);
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
                GetOpActivityInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetOpActivityInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetOpActivityInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureOpActivityInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.opActivityInfoList_ = new ArrayList(this.opActivityInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
            public List<OpActivityInfoOuterClass.OpActivityInfo> getOpActivityInfoListList() {
                if (this.opActivityInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.opActivityInfoList_);
                }
                return this.opActivityInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
            public int getOpActivityInfoListCount() {
                if (this.opActivityInfoListBuilder_ == null) {
                    return this.opActivityInfoList_.size();
                }
                return this.opActivityInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
            public OpActivityInfoOuterClass.OpActivityInfo getOpActivityInfoList(int index) {
                if (this.opActivityInfoListBuilder_ == null) {
                    return this.opActivityInfoList_.get(index);
                }
                return this.opActivityInfoListBuilder_.getMessage(index);
            }

            public Builder setOpActivityInfoList(int index, OpActivityInfoOuterClass.OpActivityInfo value) {
                if (this.opActivityInfoListBuilder_ != null) {
                    this.opActivityInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOpActivityInfoListIsMutable();
                    this.opActivityInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setOpActivityInfoList(int index, OpActivityInfoOuterClass.OpActivityInfo.Builder builderForValue) {
                if (this.opActivityInfoListBuilder_ == null) {
                    ensureOpActivityInfoListIsMutable();
                    this.opActivityInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.opActivityInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOpActivityInfoList(OpActivityInfoOuterClass.OpActivityInfo value) {
                if (this.opActivityInfoListBuilder_ != null) {
                    this.opActivityInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOpActivityInfoListIsMutable();
                    this.opActivityInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addOpActivityInfoList(int index, OpActivityInfoOuterClass.OpActivityInfo value) {
                if (this.opActivityInfoListBuilder_ != null) {
                    this.opActivityInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOpActivityInfoListIsMutable();
                    this.opActivityInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addOpActivityInfoList(OpActivityInfoOuterClass.OpActivityInfo.Builder builderForValue) {
                if (this.opActivityInfoListBuilder_ == null) {
                    ensureOpActivityInfoListIsMutable();
                    this.opActivityInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.opActivityInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOpActivityInfoList(int index, OpActivityInfoOuterClass.OpActivityInfo.Builder builderForValue) {
                if (this.opActivityInfoListBuilder_ == null) {
                    ensureOpActivityInfoListIsMutable();
                    this.opActivityInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.opActivityInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOpActivityInfoList(Iterable<? extends OpActivityInfoOuterClass.OpActivityInfo> values) {
                if (this.opActivityInfoListBuilder_ == null) {
                    ensureOpActivityInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.opActivityInfoList_);
                    onChanged();
                } else {
                    this.opActivityInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOpActivityInfoList() {
                if (this.opActivityInfoListBuilder_ == null) {
                    this.opActivityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.opActivityInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeOpActivityInfoList(int index) {
                if (this.opActivityInfoListBuilder_ == null) {
                    ensureOpActivityInfoListIsMutable();
                    this.opActivityInfoList_.remove(index);
                    onChanged();
                } else {
                    this.opActivityInfoListBuilder_.remove(index);
                }
                return this;
            }

            public OpActivityInfoOuterClass.OpActivityInfo.Builder getOpActivityInfoListBuilder(int index) {
                return getOpActivityInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
            public OpActivityInfoOuterClass.OpActivityInfoOrBuilder getOpActivityInfoListOrBuilder(int index) {
                if (this.opActivityInfoListBuilder_ == null) {
                    return this.opActivityInfoList_.get(index);
                }
                return this.opActivityInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
            public List<? extends OpActivityInfoOuterClass.OpActivityInfoOrBuilder> getOpActivityInfoListOrBuilderList() {
                if (this.opActivityInfoListBuilder_ != null) {
                    return this.opActivityInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.opActivityInfoList_);
            }

            public OpActivityInfoOuterClass.OpActivityInfo.Builder addOpActivityInfoListBuilder() {
                return getOpActivityInfoListFieldBuilder().addBuilder(OpActivityInfoOuterClass.OpActivityInfo.getDefaultInstance());
            }

            public OpActivityInfoOuterClass.OpActivityInfo.Builder addOpActivityInfoListBuilder(int index) {
                return getOpActivityInfoListFieldBuilder().addBuilder(index, OpActivityInfoOuterClass.OpActivityInfo.getDefaultInstance());
            }

            public List<OpActivityInfoOuterClass.OpActivityInfo.Builder> getOpActivityInfoListBuilderList() {
                return getOpActivityInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<OpActivityInfoOuterClass.OpActivityInfo, OpActivityInfoOuterClass.OpActivityInfo.Builder, OpActivityInfoOuterClass.OpActivityInfoOrBuilder> getOpActivityInfoListFieldBuilder() {
                if (this.opActivityInfoListBuilder_ == null) {
                    this.opActivityInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.opActivityInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.opActivityInfoList_ = null;
                }
                return this.opActivityInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetOpActivityInfoRspOuterClass.GetOpActivityInfoRspOrBuilder
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

        public static GetOpActivityInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetOpActivityInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetOpActivityInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetOpActivityInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        OpActivityInfoOuterClass.getDescriptor();
    }
}
