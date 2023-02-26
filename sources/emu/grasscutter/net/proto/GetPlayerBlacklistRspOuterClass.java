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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerBlacklistRspOuterClass.class */
public final class GetPlayerBlacklistRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bGetPlayerBlacklistRsp.proto\u001a\u0011FriendBrief.proto\"I\n\u0015GetPlayerBlacklistRsp\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005\u0012\u001f\n\tblacklist\u0018\u0001 \u0003(\u000b2\f.FriendBriefB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FriendBriefOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetPlayerBlacklistRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetPlayerBlacklistRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetPlayerBlacklistRsp_descriptor, new String[]{"Retcode", "Blacklist"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerBlacklistRspOuterClass$GetPlayerBlacklistRspOrBuilder.class */
    public interface GetPlayerBlacklistRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<FriendBriefOuterClass.FriendBrief> getBlacklistList();

        FriendBriefOuterClass.FriendBrief getBlacklist(int i);

        int getBlacklistCount();

        List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getBlacklistOrBuilderList();

        FriendBriefOuterClass.FriendBriefOrBuilder getBlacklistOrBuilder(int i);
    }

    private GetPlayerBlacklistRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerBlacklistRspOuterClass$GetPlayerBlacklistRsp.class */
    public static final class GetPlayerBlacklistRsp extends GeneratedMessageV3 implements GetPlayerBlacklistRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        public static final int BLACKLIST_FIELD_NUMBER = 1;
        private List<FriendBriefOuterClass.FriendBrief> blacklist_;
        private byte memoizedIsInitialized;
        private static final GetPlayerBlacklistRsp DEFAULT_INSTANCE = new GetPlayerBlacklistRsp();
        private static final Parser<GetPlayerBlacklistRsp> PARSER = new AbstractParser<GetPlayerBlacklistRsp>() { // from class: emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRsp.1
            @Override // com.google.protobuf.Parser
            public GetPlayerBlacklistRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetPlayerBlacklistRsp(input, extensionRegistry);
            }
        };

        private GetPlayerBlacklistRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetPlayerBlacklistRsp() {
            this.memoizedIsInitialized = -1;
            this.blacklist_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetPlayerBlacklistRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetPlayerBlacklistRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.blacklist_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.blacklist_.add((FriendBriefOuterClass.FriendBrief) input.readMessage(FriendBriefOuterClass.FriendBrief.parser(), extensionRegistry));
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
                    this.blacklist_ = Collections.unmodifiableList(this.blacklist_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetPlayerBlacklistRspOuterClass.internal_static_GetPlayerBlacklistRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetPlayerBlacklistRspOuterClass.internal_static_GetPlayerBlacklistRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerBlacklistRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
        public List<FriendBriefOuterClass.FriendBrief> getBlacklistList() {
            return this.blacklist_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
        public List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getBlacklistOrBuilderList() {
            return this.blacklist_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
        public int getBlacklistCount() {
            return this.blacklist_.size();
        }

        @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
        public FriendBriefOuterClass.FriendBrief getBlacklist(int index) {
            return this.blacklist_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
        public FriendBriefOuterClass.FriendBriefOrBuilder getBlacklistOrBuilder(int index) {
            return this.blacklist_.get(index);
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
            for (int i = 0; i < this.blacklist_.size(); i++) {
                output.writeMessage(1, this.blacklist_.get(i));
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
            for (int i = 0; i < this.blacklist_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.blacklist_.get(i));
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
            if (!(obj instanceof GetPlayerBlacklistRsp)) {
                return equals(obj);
            }
            GetPlayerBlacklistRsp other = (GetPlayerBlacklistRsp) obj;
            return getRetcode() == other.getRetcode() && getBlacklistList().equals(other.getBlacklistList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getRetcode();
            if (getBlacklistCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getBlacklistList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetPlayerBlacklistRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerBlacklistRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerBlacklistRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerBlacklistRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerBlacklistRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerBlacklistRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerBlacklistRsp parseFrom(InputStream input) throws IOException {
            return (GetPlayerBlacklistRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerBlacklistRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerBlacklistRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerBlacklistRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetPlayerBlacklistRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetPlayerBlacklistRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerBlacklistRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerBlacklistRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetPlayerBlacklistRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerBlacklistRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerBlacklistRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetPlayerBlacklistRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerBlacklistRspOuterClass$GetPlayerBlacklistRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetPlayerBlacklistRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private List<FriendBriefOuterClass.FriendBrief> blacklist_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FriendBriefOuterClass.FriendBrief, FriendBriefOuterClass.FriendBrief.Builder, FriendBriefOuterClass.FriendBriefOrBuilder> blacklistBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetPlayerBlacklistRspOuterClass.internal_static_GetPlayerBlacklistRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetPlayerBlacklistRspOuterClass.internal_static_GetPlayerBlacklistRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerBlacklistRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetPlayerBlacklistRsp.alwaysUseFieldBuilders) {
                    getBlacklistFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.blacklistBuilder_ == null) {
                    this.blacklist_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.blacklistBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetPlayerBlacklistRspOuterClass.internal_static_GetPlayerBlacklistRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetPlayerBlacklistRsp getDefaultInstanceForType() {
                return GetPlayerBlacklistRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerBlacklistRsp build() {
                GetPlayerBlacklistRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerBlacklistRsp buildPartial() {
                GetPlayerBlacklistRsp result = new GetPlayerBlacklistRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.blacklistBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.blacklist_ = Collections.unmodifiableList(this.blacklist_);
                        this.bitField0_ &= -2;
                    }
                    result.blacklist_ = this.blacklist_;
                } else {
                    result.blacklist_ = this.blacklistBuilder_.build();
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
                if (other instanceof GetPlayerBlacklistRsp) {
                    return mergeFrom((GetPlayerBlacklistRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetPlayerBlacklistRsp other) {
                if (other == GetPlayerBlacklistRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.blacklistBuilder_ == null) {
                    if (!other.blacklist_.isEmpty()) {
                        if (this.blacklist_.isEmpty()) {
                            this.blacklist_ = other.blacklist_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBlacklistIsMutable();
                            this.blacklist_.addAll(other.blacklist_);
                        }
                        onChanged();
                    }
                } else if (!other.blacklist_.isEmpty()) {
                    if (this.blacklistBuilder_.isEmpty()) {
                        this.blacklistBuilder_.dispose();
                        this.blacklistBuilder_ = null;
                        this.blacklist_ = other.blacklist_;
                        this.bitField0_ &= -2;
                        this.blacklistBuilder_ = GetPlayerBlacklistRsp.alwaysUseFieldBuilders ? getBlacklistFieldBuilder() : null;
                    } else {
                        this.blacklistBuilder_.addAllMessages(other.blacklist_);
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
                GetPlayerBlacklistRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetPlayerBlacklistRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetPlayerBlacklistRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
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

            private void ensureBlacklistIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.blacklist_ = new ArrayList(this.blacklist_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
            public List<FriendBriefOuterClass.FriendBrief> getBlacklistList() {
                if (this.blacklistBuilder_ == null) {
                    return Collections.unmodifiableList(this.blacklist_);
                }
                return this.blacklistBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
            public int getBlacklistCount() {
                if (this.blacklistBuilder_ == null) {
                    return this.blacklist_.size();
                }
                return this.blacklistBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
            public FriendBriefOuterClass.FriendBrief getBlacklist(int index) {
                if (this.blacklistBuilder_ == null) {
                    return this.blacklist_.get(index);
                }
                return this.blacklistBuilder_.getMessage(index);
            }

            public Builder setBlacklist(int index, FriendBriefOuterClass.FriendBrief value) {
                if (this.blacklistBuilder_ != null) {
                    this.blacklistBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBlacklistIsMutable();
                    this.blacklist_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBlacklist(int index, FriendBriefOuterClass.FriendBrief.Builder builderForValue) {
                if (this.blacklistBuilder_ == null) {
                    ensureBlacklistIsMutable();
                    this.blacklist_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.blacklistBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBlacklist(FriendBriefOuterClass.FriendBrief value) {
                if (this.blacklistBuilder_ != null) {
                    this.blacklistBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBlacklistIsMutable();
                    this.blacklist_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBlacklist(int index, FriendBriefOuterClass.FriendBrief value) {
                if (this.blacklistBuilder_ != null) {
                    this.blacklistBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBlacklistIsMutable();
                    this.blacklist_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBlacklist(FriendBriefOuterClass.FriendBrief.Builder builderForValue) {
                if (this.blacklistBuilder_ == null) {
                    ensureBlacklistIsMutable();
                    this.blacklist_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.blacklistBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBlacklist(int index, FriendBriefOuterClass.FriendBrief.Builder builderForValue) {
                if (this.blacklistBuilder_ == null) {
                    ensureBlacklistIsMutable();
                    this.blacklist_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.blacklistBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBlacklist(Iterable<? extends FriendBriefOuterClass.FriendBrief> values) {
                if (this.blacklistBuilder_ == null) {
                    ensureBlacklistIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.blacklist_);
                    onChanged();
                } else {
                    this.blacklistBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBlacklist() {
                if (this.blacklistBuilder_ == null) {
                    this.blacklist_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.blacklistBuilder_.clear();
                }
                return this;
            }

            public Builder removeBlacklist(int index) {
                if (this.blacklistBuilder_ == null) {
                    ensureBlacklistIsMutable();
                    this.blacklist_.remove(index);
                    onChanged();
                } else {
                    this.blacklistBuilder_.remove(index);
                }
                return this;
            }

            public FriendBriefOuterClass.FriendBrief.Builder getBlacklistBuilder(int index) {
                return getBlacklistFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
            public FriendBriefOuterClass.FriendBriefOrBuilder getBlacklistOrBuilder(int index) {
                if (this.blacklistBuilder_ == null) {
                    return this.blacklist_.get(index);
                }
                return this.blacklistBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetPlayerBlacklistRspOuterClass.GetPlayerBlacklistRspOrBuilder
            public List<? extends FriendBriefOuterClass.FriendBriefOrBuilder> getBlacklistOrBuilderList() {
                if (this.blacklistBuilder_ != null) {
                    return this.blacklistBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.blacklist_);
            }

            public FriendBriefOuterClass.FriendBrief.Builder addBlacklistBuilder() {
                return getBlacklistFieldBuilder().addBuilder(FriendBriefOuterClass.FriendBrief.getDefaultInstance());
            }

            public FriendBriefOuterClass.FriendBrief.Builder addBlacklistBuilder(int index) {
                return getBlacklistFieldBuilder().addBuilder(index, FriendBriefOuterClass.FriendBrief.getDefaultInstance());
            }

            public List<FriendBriefOuterClass.FriendBrief.Builder> getBlacklistBuilderList() {
                return getBlacklistFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FriendBriefOuterClass.FriendBrief, FriendBriefOuterClass.FriendBrief.Builder, FriendBriefOuterClass.FriendBriefOrBuilder> getBlacklistFieldBuilder() {
                if (this.blacklistBuilder_ == null) {
                    this.blacklistBuilder_ = new RepeatedFieldBuilderV3<>(this.blacklist_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.blacklist_ = null;
                }
                return this.blacklistBuilder_;
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

        public static GetPlayerBlacklistRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetPlayerBlacklistRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetPlayerBlacklistRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetPlayerBlacklistRsp getDefaultInstanceForType() {
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
