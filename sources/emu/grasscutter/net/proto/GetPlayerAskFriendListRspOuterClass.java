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
import emu.grasscutter.net.proto.FriendBriefOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerAskFriendListRspOuterClass.class */
public final class GetPlayerAskFriendListRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fGetPlayerAskFriendListRsp.proto\u001a\u0011FriendBrief.proto\"S\n\u0019GetPlayerAskFriendListRsp\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005\u0012%\n\u000fask_friend_list\u0018\u0003 \u0003(\u000b2\f.FriendBriefB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FriendBriefOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetPlayerAskFriendListRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetPlayerAskFriendListRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetPlayerAskFriendListRsp_descriptor, new String[]{"Retcode", "AskFriendList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerAskFriendListRspOuterClass$GetPlayerAskFriendListRspOrBuilder.class */
    public interface GetPlayerAskFriendListRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<FriendBriefOuterClass.FriendBrief> getAskFriendListList();

        FriendBriefOuterClass.FriendBrief getAskFriendList(int i);

        int getAskFriendListCount();

        List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getAskFriendListOrBuilderList();

        FriendBriefOuterClass.FriendBriefOrBuilder getAskFriendListOrBuilder(int i);
    }

    private GetPlayerAskFriendListRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerAskFriendListRspOuterClass$GetPlayerAskFriendListRsp.class */
    public static final class GetPlayerAskFriendListRsp extends GeneratedMessageV3 implements GetPlayerAskFriendListRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        public static final int ASK_FRIEND_LIST_FIELD_NUMBER = 3;
        private List<FriendBriefOuterClass.FriendBrief> askFriendList_;
        private byte memoizedIsInitialized;
        private static final GetPlayerAskFriendListRsp DEFAULT_INSTANCE = new GetPlayerAskFriendListRsp();
        private static final Parser<GetPlayerAskFriendListRsp> PARSER = new AbstractParser<GetPlayerAskFriendListRsp>() { // from class: emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRsp.1
            @Override // com.google.protobuf.Parser
            public GetPlayerAskFriendListRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetPlayerAskFriendListRsp(input, extensionRegistry);
            }
        };

        private GetPlayerAskFriendListRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetPlayerAskFriendListRsp() {
            this.memoizedIsInitialized = -1;
            this.askFriendList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetPlayerAskFriendListRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetPlayerAskFriendListRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 26:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.askFriendList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.askFriendList_.add((FriendBriefOuterClass.FriendBrief) input.readMessage(FriendBriefOuterClass.FriendBrief.parser(), extensionRegistry));
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
                    this.askFriendList_ = Collections.unmodifiableList(this.askFriendList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetPlayerAskFriendListRspOuterClass.internal_static_GetPlayerAskFriendListRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetPlayerAskFriendListRspOuterClass.internal_static_GetPlayerAskFriendListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerAskFriendListRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
        public List<FriendBriefOuterClass.FriendBrief> getAskFriendListList() {
            return this.askFriendList_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
        public List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getAskFriendListOrBuilderList() {
            return this.askFriendList_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
        public int getAskFriendListCount() {
            return this.askFriendList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
        public FriendBriefOuterClass.FriendBrief getAskFriendList(int index) {
            return this.askFriendList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
        public FriendBriefOuterClass.FriendBriefOrBuilder getAskFriendListOrBuilder(int index) {
            return this.askFriendList_.get(index);
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
            for (int i = 0; i < this.askFriendList_.size(); i++) {
                output.writeMessage(3, this.askFriendList_.get(i));
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
            for (int i = 0; i < this.askFriendList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.askFriendList_.get(i));
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
            if (!(obj instanceof GetPlayerAskFriendListRsp)) {
                return equals(obj);
            }
            GetPlayerAskFriendListRsp other = (GetPlayerAskFriendListRsp) obj;
            return getRetcode() == other.getRetcode() && getAskFriendListList().equals(other.getAskFriendListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getRetcode();
            if (getAskFriendListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getAskFriendListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetPlayerAskFriendListRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerAskFriendListRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerAskFriendListRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerAskFriendListRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerAskFriendListRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerAskFriendListRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerAskFriendListRsp parseFrom(InputStream input) throws IOException {
            return (GetPlayerAskFriendListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerAskFriendListRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerAskFriendListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerAskFriendListRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetPlayerAskFriendListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetPlayerAskFriendListRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerAskFriendListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerAskFriendListRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetPlayerAskFriendListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerAskFriendListRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerAskFriendListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetPlayerAskFriendListRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerAskFriendListRspOuterClass$GetPlayerAskFriendListRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetPlayerAskFriendListRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private List<FriendBriefOuterClass.FriendBrief> askFriendList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FriendBriefOuterClass.FriendBrief, FriendBriefOuterClass.FriendBrief.Builder, FriendBriefOuterClass.FriendBriefOrBuilder> askFriendListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetPlayerAskFriendListRspOuterClass.internal_static_GetPlayerAskFriendListRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetPlayerAskFriendListRspOuterClass.internal_static_GetPlayerAskFriendListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerAskFriendListRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetPlayerAskFriendListRsp.alwaysUseFieldBuilders) {
                    getAskFriendListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.askFriendListBuilder_ == null) {
                    this.askFriendList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.askFriendListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetPlayerAskFriendListRspOuterClass.internal_static_GetPlayerAskFriendListRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetPlayerAskFriendListRsp getDefaultInstanceForType() {
                return GetPlayerAskFriendListRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerAskFriendListRsp build() {
                GetPlayerAskFriendListRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerAskFriendListRsp buildPartial() {
                GetPlayerAskFriendListRsp result = new GetPlayerAskFriendListRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.askFriendListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.askFriendList_ = Collections.unmodifiableList(this.askFriendList_);
                        this.bitField0_ &= -2;
                    }
                    result.askFriendList_ = this.askFriendList_;
                } else {
                    result.askFriendList_ = this.askFriendListBuilder_.build();
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
                if (other instanceof GetPlayerAskFriendListRsp) {
                    return mergeFrom((GetPlayerAskFriendListRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetPlayerAskFriendListRsp other) {
                if (other == GetPlayerAskFriendListRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.askFriendListBuilder_ == null) {
                    if (!other.askFriendList_.isEmpty()) {
                        if (this.askFriendList_.isEmpty()) {
                            this.askFriendList_ = other.askFriendList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAskFriendListIsMutable();
                            this.askFriendList_.addAll(other.askFriendList_);
                        }
                        onChanged();
                    }
                } else if (!other.askFriendList_.isEmpty()) {
                    if (this.askFriendListBuilder_.isEmpty()) {
                        this.askFriendListBuilder_.dispose();
                        this.askFriendListBuilder_ = null;
                        this.askFriendList_ = other.askFriendList_;
                        this.bitField0_ &= -2;
                        this.askFriendListBuilder_ = GetPlayerAskFriendListRsp.alwaysUseFieldBuilders ? getAskFriendListFieldBuilder() : null;
                    } else {
                        this.askFriendListBuilder_.addAllMessages(other.askFriendList_);
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
                GetPlayerAskFriendListRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetPlayerAskFriendListRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetPlayerAskFriendListRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
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

            private void ensureAskFriendListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.askFriendList_ = new ArrayList(this.askFriendList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
            public List<FriendBriefOuterClass.FriendBrief> getAskFriendListList() {
                if (this.askFriendListBuilder_ == null) {
                    return Collections.unmodifiableList(this.askFriendList_);
                }
                return this.askFriendListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
            public int getAskFriendListCount() {
                if (this.askFriendListBuilder_ == null) {
                    return this.askFriendList_.size();
                }
                return this.askFriendListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
            public FriendBriefOuterClass.FriendBrief getAskFriendList(int index) {
                if (this.askFriendListBuilder_ == null) {
                    return this.askFriendList_.get(index);
                }
                return this.askFriendListBuilder_.getMessage(index);
            }

            public Builder setAskFriendList(int index, FriendBriefOuterClass.FriendBrief value) {
                if (this.askFriendListBuilder_ != null) {
                    this.askFriendListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAskFriendListIsMutable();
                    this.askFriendList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAskFriendList(int index, FriendBriefOuterClass.FriendBrief.Builder builderForValue) {
                if (this.askFriendListBuilder_ == null) {
                    ensureAskFriendListIsMutable();
                    this.askFriendList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.askFriendListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAskFriendList(FriendBriefOuterClass.FriendBrief value) {
                if (this.askFriendListBuilder_ != null) {
                    this.askFriendListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAskFriendListIsMutable();
                    this.askFriendList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAskFriendList(int index, FriendBriefOuterClass.FriendBrief value) {
                if (this.askFriendListBuilder_ != null) {
                    this.askFriendListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAskFriendListIsMutable();
                    this.askFriendList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAskFriendList(FriendBriefOuterClass.FriendBrief.Builder builderForValue) {
                if (this.askFriendListBuilder_ == null) {
                    ensureAskFriendListIsMutable();
                    this.askFriendList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.askFriendListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAskFriendList(int index, FriendBriefOuterClass.FriendBrief.Builder builderForValue) {
                if (this.askFriendListBuilder_ == null) {
                    ensureAskFriendListIsMutable();
                    this.askFriendList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.askFriendListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAskFriendList(Iterable<? extends FriendBriefOuterClass.FriendBrief> values) {
                if (this.askFriendListBuilder_ == null) {
                    ensureAskFriendListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.askFriendList_);
                    onChanged();
                } else {
                    this.askFriendListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAskFriendList() {
                if (this.askFriendListBuilder_ == null) {
                    this.askFriendList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.askFriendListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAskFriendList(int index) {
                if (this.askFriendListBuilder_ == null) {
                    ensureAskFriendListIsMutable();
                    this.askFriendList_.remove(index);
                    onChanged();
                } else {
                    this.askFriendListBuilder_.remove(index);
                }
                return this;
            }

            public FriendBriefOuterClass.FriendBrief.Builder getAskFriendListBuilder(int index) {
                return getAskFriendListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
            public FriendBriefOuterClass.FriendBriefOrBuilder getAskFriendListOrBuilder(int index) {
                if (this.askFriendListBuilder_ == null) {
                    return this.askFriendList_.get(index);
                }
                return this.askFriendListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRspOrBuilder
            public List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getAskFriendListOrBuilderList() {
                if (this.askFriendListBuilder_ != null) {
                    return this.askFriendListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.askFriendList_);
            }

            public FriendBriefOuterClass.FriendBrief.Builder addAskFriendListBuilder() {
                return getAskFriendListFieldBuilder().addBuilder(FriendBriefOuterClass.FriendBrief.getDefaultInstance());
            }

            public FriendBriefOuterClass.FriendBrief.Builder addAskFriendListBuilder(int index) {
                return getAskFriendListFieldBuilder().addBuilder(index, FriendBriefOuterClass.FriendBrief.getDefaultInstance());
            }

            public List<FriendBriefOuterClass.FriendBrief.Builder> getAskFriendListBuilderList() {
                return getAskFriendListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FriendBriefOuterClass.FriendBrief, FriendBriefOuterClass.FriendBrief.Builder, FriendBriefOuterClass.FriendBriefOrBuilder> getAskFriendListFieldBuilder() {
                if (this.askFriendListBuilder_ == null) {
                    this.askFriendListBuilder_ = new RepeatedFieldBuilderV3<>(this.askFriendList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.askFriendList_ = null;
                }
                return this.askFriendListBuilder_;
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

        public static GetPlayerAskFriendListRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetPlayerAskFriendListRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetPlayerAskFriendListRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetPlayerAskFriendListRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FriendBriefOuterClass.getDescriptor();
    }
}
