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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerFriendListRspOuterClass.class */
public final class GetPlayerFriendListRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cGetPlayerFriendListRsp.proto\u001a\u0011FriendBrief.proto\"s\n\u0016GetPlayerFriendListRsp\u0012%\n\u000fask_friend_list\u0018\r \u0003(\u000b2\f.FriendBrief\u0012\u000f\n\u0007retcode\u0018\u0004 \u0001(\u0005\u0012!\n\u000bfriend_list\u0018\u000f \u0003(\u000b2\f.FriendBriefB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FriendBriefOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetPlayerFriendListRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetPlayerFriendListRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetPlayerFriendListRsp_descriptor, new String[]{"AskFriendList", "Retcode", "FriendList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerFriendListRspOuterClass$GetPlayerFriendListRspOrBuilder.class */
    public interface GetPlayerFriendListRspOrBuilder extends MessageOrBuilder {
        List<FriendBriefOuterClass.FriendBrief> getAskFriendListList();

        FriendBriefOuterClass.FriendBrief getAskFriendList(int i);

        int getAskFriendListCount();

        List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getAskFriendListOrBuilderList();

        FriendBriefOuterClass.FriendBriefOrBuilder getAskFriendListOrBuilder(int i);

        int getRetcode();

        List<FriendBriefOuterClass.FriendBrief> getFriendListList();

        FriendBriefOuterClass.FriendBrief getFriendList(int i);

        int getFriendListCount();

        List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getFriendListOrBuilderList();

        FriendBriefOuterClass.FriendBriefOrBuilder getFriendListOrBuilder(int i);
    }

    private GetPlayerFriendListRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerFriendListRspOuterClass$GetPlayerFriendListRsp.class */
    public static final class GetPlayerFriendListRsp extends GeneratedMessageV3 implements GetPlayerFriendListRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ASK_FRIEND_LIST_FIELD_NUMBER = 13;
        private List<FriendBriefOuterClass.FriendBrief> askFriendList_;
        public static final int RETCODE_FIELD_NUMBER = 4;
        private int retcode_;
        public static final int FRIEND_LIST_FIELD_NUMBER = 15;
        private List<FriendBriefOuterClass.FriendBrief> friendList_;
        private byte memoizedIsInitialized;
        private static final GetPlayerFriendListRsp DEFAULT_INSTANCE = new GetPlayerFriendListRsp();
        private static final Parser<GetPlayerFriendListRsp> PARSER = new AbstractParser<GetPlayerFriendListRsp>() { // from class: emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRsp.1
            @Override // com.google.protobuf.Parser
            public GetPlayerFriendListRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetPlayerFriendListRsp(input, extensionRegistry);
            }
        };

        private GetPlayerFriendListRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetPlayerFriendListRsp() {
            this.memoizedIsInitialized = -1;
            this.askFriendList_ = Collections.emptyList();
            this.friendList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetPlayerFriendListRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x00cb */
        private GetPlayerFriendListRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.retcode_ = input.readInt32();
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.askFriendList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.askFriendList_.add((FriendBriefOuterClass.FriendBrief) input.readMessage(FriendBriefOuterClass.FriendBrief.parser(), extensionRegistry));
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.friendList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.friendList_.add((FriendBriefOuterClass.FriendBrief) input.readMessage(FriendBriefOuterClass.FriendBrief.parser(), extensionRegistry));
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.askFriendList_ = Collections.unmodifiableList(this.askFriendList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.friendList_ = Collections.unmodifiableList(this.friendList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetPlayerFriendListRspOuterClass.internal_static_GetPlayerFriendListRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetPlayerFriendListRspOuterClass.internal_static_GetPlayerFriendListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerFriendListRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public List<FriendBriefOuterClass.FriendBrief> getAskFriendListList() {
            return this.askFriendList_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getAskFriendListOrBuilderList() {
            return this.askFriendList_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public int getAskFriendListCount() {
            return this.askFriendList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public FriendBriefOuterClass.FriendBrief getAskFriendList(int index) {
            return this.askFriendList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public FriendBriefOuterClass.FriendBriefOrBuilder getAskFriendListOrBuilder(int index) {
            return this.askFriendList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public List<FriendBriefOuterClass.FriendBrief> getFriendListList() {
            return this.friendList_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getFriendListOrBuilderList() {
            return this.friendList_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public int getFriendListCount() {
            return this.friendList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public FriendBriefOuterClass.FriendBrief getFriendList(int index) {
            return this.friendList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
        public FriendBriefOuterClass.FriendBriefOrBuilder getFriendListOrBuilder(int index) {
            return this.friendList_.get(index);
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
                output.writeInt32(4, this.retcode_);
            }
            for (int i = 0; i < this.askFriendList_.size(); i++) {
                output.writeMessage(13, this.askFriendList_.get(i));
            }
            for (int i2 = 0; i2 < this.friendList_.size(); i2++) {
                output.writeMessage(15, this.friendList_.get(i2));
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
                size2 = 0 + CodedOutputStream.computeInt32Size(4, this.retcode_);
            }
            for (int i = 0; i < this.askFriendList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.askFriendList_.get(i));
            }
            for (int i2 = 0; i2 < this.friendList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.friendList_.get(i2));
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
            if (!(obj instanceof GetPlayerFriendListRsp)) {
                return equals(obj);
            }
            GetPlayerFriendListRsp other = (GetPlayerFriendListRsp) obj;
            return getAskFriendListList().equals(other.getAskFriendListList()) && getRetcode() == other.getRetcode() && getFriendListList().equals(other.getFriendListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAskFriendListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getAskFriendListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 4)) + getRetcode();
            if (getFriendListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 15)) + getFriendListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static GetPlayerFriendListRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerFriendListRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerFriendListRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerFriendListRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerFriendListRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerFriendListRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerFriendListRsp parseFrom(InputStream input) throws IOException {
            return (GetPlayerFriendListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerFriendListRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerFriendListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerFriendListRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetPlayerFriendListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetPlayerFriendListRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerFriendListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerFriendListRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetPlayerFriendListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerFriendListRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerFriendListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetPlayerFriendListRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerFriendListRspOuterClass$GetPlayerFriendListRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetPlayerFriendListRspOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<FriendBriefOuterClass.FriendBrief, FriendBriefOuterClass.FriendBrief.Builder, FriendBriefOuterClass.FriendBriefOrBuilder> askFriendListBuilder_;
            private int retcode_;
            private RepeatedFieldBuilderV3<FriendBriefOuterClass.FriendBrief, FriendBriefOuterClass.FriendBrief.Builder, FriendBriefOuterClass.FriendBriefOrBuilder> friendListBuilder_;
            private List<FriendBriefOuterClass.FriendBrief> askFriendList_ = Collections.emptyList();
            private List<FriendBriefOuterClass.FriendBrief> friendList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetPlayerFriendListRspOuterClass.internal_static_GetPlayerFriendListRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetPlayerFriendListRspOuterClass.internal_static_GetPlayerFriendListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerFriendListRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetPlayerFriendListRsp.alwaysUseFieldBuilders) {
                    getAskFriendListFieldBuilder();
                    getFriendListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.askFriendListBuilder_ == null) {
                    this.askFriendList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.askFriendListBuilder_.clear();
                }
                this.retcode_ = 0;
                if (this.friendListBuilder_ == null) {
                    this.friendList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.friendListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetPlayerFriendListRspOuterClass.internal_static_GetPlayerFriendListRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetPlayerFriendListRsp getDefaultInstanceForType() {
                return GetPlayerFriendListRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerFriendListRsp build() {
                GetPlayerFriendListRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerFriendListRsp buildPartial() {
                GetPlayerFriendListRsp result = new GetPlayerFriendListRsp(this);
                int i = this.bitField0_;
                if (this.askFriendListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.askFriendList_ = Collections.unmodifiableList(this.askFriendList_);
                        this.bitField0_ &= -2;
                    }
                    result.askFriendList_ = this.askFriendList_;
                } else {
                    result.askFriendList_ = this.askFriendListBuilder_.build();
                }
                result.retcode_ = this.retcode_;
                if (this.friendListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.friendList_ = Collections.unmodifiableList(this.friendList_);
                        this.bitField0_ &= -3;
                    }
                    result.friendList_ = this.friendList_;
                } else {
                    result.friendList_ = this.friendListBuilder_.build();
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
                if (other instanceof GetPlayerFriendListRsp) {
                    return mergeFrom((GetPlayerFriendListRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetPlayerFriendListRsp other) {
                if (other == GetPlayerFriendListRsp.getDefaultInstance()) {
                    return this;
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
                        this.askFriendListBuilder_ = GetPlayerFriendListRsp.alwaysUseFieldBuilders ? getAskFriendListFieldBuilder() : null;
                    } else {
                        this.askFriendListBuilder_.addAllMessages(other.askFriendList_);
                    }
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.friendListBuilder_ == null) {
                    if (!other.friendList_.isEmpty()) {
                        if (this.friendList_.isEmpty()) {
                            this.friendList_ = other.friendList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureFriendListIsMutable();
                            this.friendList_.addAll(other.friendList_);
                        }
                        onChanged();
                    }
                } else if (!other.friendList_.isEmpty()) {
                    if (this.friendListBuilder_.isEmpty()) {
                        this.friendListBuilder_.dispose();
                        this.friendListBuilder_ = null;
                        this.friendList_ = other.friendList_;
                        this.bitField0_ &= -3;
                        this.friendListBuilder_ = GetPlayerFriendListRsp.alwaysUseFieldBuilders ? getFriendListFieldBuilder() : null;
                    } else {
                        this.friendListBuilder_.addAllMessages(other.friendList_);
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
                GetPlayerFriendListRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetPlayerFriendListRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetPlayerFriendListRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAskFriendListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.askFriendList_ = new ArrayList(this.askFriendList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
            public List<FriendBriefOuterClass.FriendBrief> getAskFriendListList() {
                if (this.askFriendListBuilder_ == null) {
                    return Collections.unmodifiableList(this.askFriendList_);
                }
                return this.askFriendListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
            public int getAskFriendListCount() {
                if (this.askFriendListBuilder_ == null) {
                    return this.askFriendList_.size();
                }
                return this.askFriendListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
            public FriendBriefOuterClass.FriendBriefOrBuilder getAskFriendListOrBuilder(int index) {
                if (this.askFriendListBuilder_ == null) {
                    return this.askFriendList_.get(index);
                }
                return this.askFriendListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
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

            private void ensureFriendListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.friendList_ = new ArrayList(this.friendList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
            public List<FriendBriefOuterClass.FriendBrief> getFriendListList() {
                if (this.friendListBuilder_ == null) {
                    return Collections.unmodifiableList(this.friendList_);
                }
                return this.friendListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
            public int getFriendListCount() {
                if (this.friendListBuilder_ == null) {
                    return this.friendList_.size();
                }
                return this.friendListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
            public FriendBriefOuterClass.FriendBrief getFriendList(int index) {
                if (this.friendListBuilder_ == null) {
                    return this.friendList_.get(index);
                }
                return this.friendListBuilder_.getMessage(index);
            }

            public Builder setFriendList(int index, FriendBriefOuterClass.FriendBrief value) {
                if (this.friendListBuilder_ != null) {
                    this.friendListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFriendListIsMutable();
                    this.friendList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFriendList(int index, FriendBriefOuterClass.FriendBrief.Builder builderForValue) {
                if (this.friendListBuilder_ == null) {
                    ensureFriendListIsMutable();
                    this.friendList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.friendListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFriendList(FriendBriefOuterClass.FriendBrief value) {
                if (this.friendListBuilder_ != null) {
                    this.friendListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFriendListIsMutable();
                    this.friendList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFriendList(int index, FriendBriefOuterClass.FriendBrief value) {
                if (this.friendListBuilder_ != null) {
                    this.friendListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFriendListIsMutable();
                    this.friendList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFriendList(FriendBriefOuterClass.FriendBrief.Builder builderForValue) {
                if (this.friendListBuilder_ == null) {
                    ensureFriendListIsMutable();
                    this.friendList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.friendListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFriendList(int index, FriendBriefOuterClass.FriendBrief.Builder builderForValue) {
                if (this.friendListBuilder_ == null) {
                    ensureFriendListIsMutable();
                    this.friendList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.friendListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFriendList(Iterable<? extends FriendBriefOuterClass.FriendBrief> values) {
                if (this.friendListBuilder_ == null) {
                    ensureFriendListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.friendList_);
                    onChanged();
                } else {
                    this.friendListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFriendList() {
                if (this.friendListBuilder_ == null) {
                    this.friendList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.friendListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFriendList(int index) {
                if (this.friendListBuilder_ == null) {
                    ensureFriendListIsMutable();
                    this.friendList_.remove(index);
                    onChanged();
                } else {
                    this.friendListBuilder_.remove(index);
                }
                return this;
            }

            public FriendBriefOuterClass.FriendBrief.Builder getFriendListBuilder(int index) {
                return getFriendListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
            public FriendBriefOuterClass.FriendBriefOrBuilder getFriendListOrBuilder(int index) {
                if (this.friendListBuilder_ == null) {
                    return this.friendList_.get(index);
                }
                return this.friendListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass.GetPlayerFriendListRspOrBuilder
            public List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getFriendListOrBuilderList() {
                if (this.friendListBuilder_ != null) {
                    return this.friendListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.friendList_);
            }

            public FriendBriefOuterClass.FriendBrief.Builder addFriendListBuilder() {
                return getFriendListFieldBuilder().addBuilder(FriendBriefOuterClass.FriendBrief.getDefaultInstance());
            }

            public FriendBriefOuterClass.FriendBrief.Builder addFriendListBuilder(int index) {
                return getFriendListFieldBuilder().addBuilder(index, FriendBriefOuterClass.FriendBrief.getDefaultInstance());
            }

            public List<FriendBriefOuterClass.FriendBrief.Builder> getFriendListBuilderList() {
                return getFriendListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FriendBriefOuterClass.FriendBrief, FriendBriefOuterClass.FriendBrief.Builder, FriendBriefOuterClass.FriendBriefOrBuilder> getFriendListFieldBuilder() {
                if (this.friendListBuilder_ == null) {
                    this.friendListBuilder_ = new RepeatedFieldBuilderV3<>(this.friendList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.friendList_ = null;
                }
                return this.friendListBuilder_;
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

        public static GetPlayerFriendListRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetPlayerFriendListRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetPlayerFriendListRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetPlayerFriendListRsp getDefaultInstanceForType() {
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
