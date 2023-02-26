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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.MailDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllMailRspOuterClass.class */
public final class GetAllMailRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013GetAllMailRsp.proto\u001a\u000eMailData.proto\"g\n\rGetAllMailRsp\u0012\u0013\n\u000bisCollected\u0018\u0005 \u0001(\b\u0012\u000f\n\u0007retcode\u0018\t \u0001(\u0005\u0012\u001b\n\bmailList\u0018\u0007 \u0003(\u000b2\t.MailData\u0012\u0013\n\u000bisTruncated\u0018\b \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MailDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetAllMailRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetAllMailRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetAllMailRsp_descriptor, new String[]{"IsCollected", "Retcode", "MailList", "IsTruncated"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllMailRspOuterClass$GetAllMailRspOrBuilder.class */
    public interface GetAllMailRspOrBuilder extends MessageOrBuilder {
        boolean getIsCollected();

        int getRetcode();

        List<MailDataOuterClass.MailData> getMailListList();

        MailDataOuterClass.MailData getMailList(int i);

        int getMailListCount();

        List<? extends MailDataOuterClass.MailDataOrBuilder> getMailListOrBuilderList();

        MailDataOuterClass.MailDataOrBuilder getMailListOrBuilder(int i);

        boolean getIsTruncated();
    }

    private GetAllMailRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllMailRspOuterClass$GetAllMailRsp.class */
    public static final class GetAllMailRsp extends GeneratedMessageV3 implements GetAllMailRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISCOLLECTED_FIELD_NUMBER = 5;
        private boolean isCollected_;
        public static final int RETCODE_FIELD_NUMBER = 9;
        private int retcode_;
        public static final int MAILLIST_FIELD_NUMBER = 7;
        private List<MailDataOuterClass.MailData> mailList_;
        public static final int ISTRUNCATED_FIELD_NUMBER = 8;
        private boolean isTruncated_;
        private byte memoizedIsInitialized;
        private static final GetAllMailRsp DEFAULT_INSTANCE = new GetAllMailRsp();
        private static final Parser<GetAllMailRsp> PARSER = new AbstractParser<GetAllMailRsp>() { // from class: emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRsp.1
            @Override // com.google.protobuf.Parser
            public GetAllMailRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetAllMailRsp(input, extensionRegistry);
            }
        };

        private GetAllMailRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetAllMailRsp() {
            this.memoizedIsInitialized = -1;
            this.mailList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetAllMailRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAllMailRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.isCollected_ = input.readBool();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.mailList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.mailList_.add((MailDataOuterClass.MailData) input.readMessage(MailDataOuterClass.MailData.parser(), extensionRegistry));
                                break;
                            case 64:
                                this.isTruncated_ = input.readBool();
                                break;
                            case 72:
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
                    this.mailList_ = Collections.unmodifiableList(this.mailList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetAllMailRspOuterClass.internal_static_GetAllMailRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetAllMailRspOuterClass.internal_static_GetAllMailRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllMailRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
        public boolean getIsCollected() {
            return this.isCollected_;
        }

        @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
        public List<MailDataOuterClass.MailData> getMailListList() {
            return this.mailList_;
        }

        @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
        public List<? extends MailDataOuterClass.MailDataOrBuilder> getMailListOrBuilderList() {
            return this.mailList_;
        }

        @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
        public int getMailListCount() {
            return this.mailList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
        public MailDataOuterClass.MailData getMailList(int index) {
            return this.mailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
        public MailDataOuterClass.MailDataOrBuilder getMailListOrBuilder(int index) {
            return this.mailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
        public boolean getIsTruncated() {
            return this.isTruncated_;
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
            if (this.isCollected_) {
                output.writeBool(5, this.isCollected_);
            }
            for (int i = 0; i < this.mailList_.size(); i++) {
                output.writeMessage(7, this.mailList_.get(i));
            }
            if (this.isTruncated_) {
                output.writeBool(8, this.isTruncated_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(9, this.retcode_);
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
            if (this.isCollected_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(5, this.isCollected_);
            }
            for (int i = 0; i < this.mailList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.mailList_.get(i));
            }
            if (this.isTruncated_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isTruncated_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.retcode_);
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
            if (!(obj instanceof GetAllMailRsp)) {
                return equals(obj);
            }
            GetAllMailRsp other = (GetAllMailRsp) obj;
            return getIsCollected() == other.getIsCollected() && getRetcode() == other.getRetcode() && getMailListList().equals(other.getMailListList()) && getIsTruncated() == other.getIsTruncated() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + Internal.hashBoolean(getIsCollected()))) + 9)) + getRetcode();
            if (getMailListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getMailListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 8)) + Internal.hashBoolean(getIsTruncated()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetAllMailRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAllMailRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllMailRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAllMailRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllMailRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAllMailRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllMailRsp parseFrom(InputStream input) throws IOException {
            return (GetAllMailRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetAllMailRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllMailRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetAllMailRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAllMailRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetAllMailRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllMailRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetAllMailRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetAllMailRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetAllMailRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllMailRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetAllMailRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAllMailRspOuterClass$GetAllMailRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetAllMailRspOrBuilder {
            private int bitField0_;
            private boolean isCollected_;
            private int retcode_;
            private List<MailDataOuterClass.MailData> mailList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MailDataOuterClass.MailData, MailDataOuterClass.MailData.Builder, MailDataOuterClass.MailDataOrBuilder> mailListBuilder_;
            private boolean isTruncated_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetAllMailRspOuterClass.internal_static_GetAllMailRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetAllMailRspOuterClass.internal_static_GetAllMailRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllMailRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetAllMailRsp.alwaysUseFieldBuilders) {
                    getMailListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isCollected_ = false;
                this.retcode_ = 0;
                if (this.mailListBuilder_ == null) {
                    this.mailList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.mailListBuilder_.clear();
                }
                this.isTruncated_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetAllMailRspOuterClass.internal_static_GetAllMailRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetAllMailRsp getDefaultInstanceForType() {
                return GetAllMailRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetAllMailRsp build() {
                GetAllMailRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetAllMailRsp buildPartial() {
                GetAllMailRsp result = new GetAllMailRsp(this);
                int i = this.bitField0_;
                result.isCollected_ = this.isCollected_;
                result.retcode_ = this.retcode_;
                if (this.mailListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.mailList_ = Collections.unmodifiableList(this.mailList_);
                        this.bitField0_ &= -2;
                    }
                    result.mailList_ = this.mailList_;
                } else {
                    result.mailList_ = this.mailListBuilder_.build();
                }
                result.isTruncated_ = this.isTruncated_;
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
                if (other instanceof GetAllMailRsp) {
                    return mergeFrom((GetAllMailRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetAllMailRsp other) {
                if (other == GetAllMailRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsCollected()) {
                    setIsCollected(other.getIsCollected());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.mailListBuilder_ == null) {
                    if (!other.mailList_.isEmpty()) {
                        if (this.mailList_.isEmpty()) {
                            this.mailList_ = other.mailList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMailListIsMutable();
                            this.mailList_.addAll(other.mailList_);
                        }
                        onChanged();
                    }
                } else if (!other.mailList_.isEmpty()) {
                    if (this.mailListBuilder_.isEmpty()) {
                        this.mailListBuilder_.dispose();
                        this.mailListBuilder_ = null;
                        this.mailList_ = other.mailList_;
                        this.bitField0_ &= -2;
                        this.mailListBuilder_ = GetAllMailRsp.alwaysUseFieldBuilders ? getMailListFieldBuilder() : null;
                    } else {
                        this.mailListBuilder_.addAllMessages(other.mailList_);
                    }
                }
                if (other.getIsTruncated()) {
                    setIsTruncated(other.getIsTruncated());
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
                GetAllMailRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetAllMailRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetAllMailRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
            public boolean getIsCollected() {
                return this.isCollected_;
            }

            public Builder setIsCollected(boolean value) {
                this.isCollected_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsCollected() {
                this.isCollected_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
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

            private void ensureMailListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.mailList_ = new ArrayList(this.mailList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
            public List<MailDataOuterClass.MailData> getMailListList() {
                if (this.mailListBuilder_ == null) {
                    return Collections.unmodifiableList(this.mailList_);
                }
                return this.mailListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
            public int getMailListCount() {
                if (this.mailListBuilder_ == null) {
                    return this.mailList_.size();
                }
                return this.mailListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
            public MailDataOuterClass.MailData getMailList(int index) {
                if (this.mailListBuilder_ == null) {
                    return this.mailList_.get(index);
                }
                return this.mailListBuilder_.getMessage(index);
            }

            public Builder setMailList(int index, MailDataOuterClass.MailData value) {
                if (this.mailListBuilder_ != null) {
                    this.mailListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMailListIsMutable();
                    this.mailList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMailList(int index, MailDataOuterClass.MailData.Builder builderForValue) {
                if (this.mailListBuilder_ == null) {
                    ensureMailListIsMutable();
                    this.mailList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mailListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMailList(MailDataOuterClass.MailData value) {
                if (this.mailListBuilder_ != null) {
                    this.mailListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMailListIsMutable();
                    this.mailList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMailList(int index, MailDataOuterClass.MailData value) {
                if (this.mailListBuilder_ != null) {
                    this.mailListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMailListIsMutable();
                    this.mailList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMailList(MailDataOuterClass.MailData.Builder builderForValue) {
                if (this.mailListBuilder_ == null) {
                    ensureMailListIsMutable();
                    this.mailList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.mailListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMailList(int index, MailDataOuterClass.MailData.Builder builderForValue) {
                if (this.mailListBuilder_ == null) {
                    ensureMailListIsMutable();
                    this.mailList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mailListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMailList(Iterable<? extends MailDataOuterClass.MailData> values) {
                if (this.mailListBuilder_ == null) {
                    ensureMailListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.mailList_);
                    onChanged();
                } else {
                    this.mailListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMailList() {
                if (this.mailListBuilder_ == null) {
                    this.mailList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.mailListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMailList(int index) {
                if (this.mailListBuilder_ == null) {
                    ensureMailListIsMutable();
                    this.mailList_.remove(index);
                    onChanged();
                } else {
                    this.mailListBuilder_.remove(index);
                }
                return this;
            }

            public MailDataOuterClass.MailData.Builder getMailListBuilder(int index) {
                return getMailListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
            public MailDataOuterClass.MailDataOrBuilder getMailListOrBuilder(int index) {
                if (this.mailListBuilder_ == null) {
                    return this.mailList_.get(index);
                }
                return this.mailListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
            public List<? extends MailDataOuterClass.MailDataOrBuilder> getMailListOrBuilderList() {
                if (this.mailListBuilder_ != null) {
                    return this.mailListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.mailList_);
            }

            public MailDataOuterClass.MailData.Builder addMailListBuilder() {
                return getMailListFieldBuilder().addBuilder(MailDataOuterClass.MailData.getDefaultInstance());
            }

            public MailDataOuterClass.MailData.Builder addMailListBuilder(int index) {
                return getMailListFieldBuilder().addBuilder(index, MailDataOuterClass.MailData.getDefaultInstance());
            }

            public List<MailDataOuterClass.MailData.Builder> getMailListBuilderList() {
                return getMailListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MailDataOuterClass.MailData, MailDataOuterClass.MailData.Builder, MailDataOuterClass.MailDataOrBuilder> getMailListFieldBuilder() {
                if (this.mailListBuilder_ == null) {
                    this.mailListBuilder_ = new RepeatedFieldBuilderV3<>(this.mailList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.mailList_ = null;
                }
                return this.mailListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetAllMailRspOuterClass.GetAllMailRspOrBuilder
            public boolean getIsTruncated() {
                return this.isTruncated_;
            }

            public Builder setIsTruncated(boolean value) {
                this.isTruncated_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTruncated() {
                this.isTruncated_ = false;
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

        public static GetAllMailRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetAllMailRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetAllMailRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetAllMailRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MailDataOuterClass.getDescriptor();
    }
}
