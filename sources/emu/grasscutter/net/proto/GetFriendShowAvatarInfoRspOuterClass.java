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
import emu.grasscutter.net.proto.ShowAvatarInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetFriendShowAvatarInfoRspOuterClass.class */
public final class GetFriendShowAvatarInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n GetFriendShowAvatarInfoRsp.proto\u001a\u0014ShowAvatarInfo.proto\"j\n\u001aGetFriendShowAvatarInfoRsp\u0012.\n\u0015show_avatar_info_list\u0018\u0005 \u0003(\u000b2\u000f.ShowAvatarInfo\u0012\u000b\n\u0003uid\u0018\t \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ShowAvatarInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetFriendShowAvatarInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetFriendShowAvatarInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetFriendShowAvatarInfoRsp_descriptor, new String[]{"ShowAvatarInfoList", "Uid", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetFriendShowAvatarInfoRspOuterClass$GetFriendShowAvatarInfoRspOrBuilder.class */
    public interface GetFriendShowAvatarInfoRspOrBuilder extends MessageOrBuilder {
        List<ShowAvatarInfoOuterClass.ShowAvatarInfo> getShowAvatarInfoListList();

        ShowAvatarInfoOuterClass.ShowAvatarInfo getShowAvatarInfoList(int i);

        int getShowAvatarInfoListCount();

        List<? extends ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder> getShowAvatarInfoListOrBuilderList();

        ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder getShowAvatarInfoListOrBuilder(int i);

        int getUid();

        int getRetcode();
    }

    private GetFriendShowAvatarInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetFriendShowAvatarInfoRspOuterClass$GetFriendShowAvatarInfoRsp.class */
    public static final class GetFriendShowAvatarInfoRsp extends GeneratedMessageV3 implements GetFriendShowAvatarInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SHOW_AVATAR_INFO_LIST_FIELD_NUMBER = 5;
        private List<ShowAvatarInfoOuterClass.ShowAvatarInfo> showAvatarInfoList_;
        public static final int UID_FIELD_NUMBER = 9;
        private int uid_;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetFriendShowAvatarInfoRsp DEFAULT_INSTANCE = new GetFriendShowAvatarInfoRsp();
        private static final Parser<GetFriendShowAvatarInfoRsp> PARSER = new AbstractParser<GetFriendShowAvatarInfoRsp>() { // from class: emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRsp.1
            @Override // com.google.protobuf.Parser
            public GetFriendShowAvatarInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetFriendShowAvatarInfoRsp(input, extensionRegistry);
            }
        };

        private GetFriendShowAvatarInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetFriendShowAvatarInfoRsp() {
            this.memoizedIsInitialized = -1;
            this.showAvatarInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetFriendShowAvatarInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetFriendShowAvatarInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.retcode_ = input.readInt32();
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.showAvatarInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.showAvatarInfoList_.add((ShowAvatarInfoOuterClass.ShowAvatarInfo) input.readMessage(ShowAvatarInfoOuterClass.ShowAvatarInfo.parser(), extensionRegistry));
                                break;
                            case 72:
                                this.uid_ = input.readUInt32();
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
                    this.showAvatarInfoList_ = Collections.unmodifiableList(this.showAvatarInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetFriendShowAvatarInfoRspOuterClass.internal_static_GetFriendShowAvatarInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetFriendShowAvatarInfoRspOuterClass.internal_static_GetFriendShowAvatarInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetFriendShowAvatarInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
        public List<ShowAvatarInfoOuterClass.ShowAvatarInfo> getShowAvatarInfoListList() {
            return this.showAvatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
        public List<? extends ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder> getShowAvatarInfoListOrBuilderList() {
            return this.showAvatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
        public int getShowAvatarInfoListCount() {
            return this.showAvatarInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
        public ShowAvatarInfoOuterClass.ShowAvatarInfo getShowAvatarInfoList(int index) {
            return this.showAvatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
        public ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder getShowAvatarInfoListOrBuilder(int index) {
            return this.showAvatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
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
                output.writeInt32(1, this.retcode_);
            }
            for (int i = 0; i < this.showAvatarInfoList_.size(); i++) {
                output.writeMessage(5, this.showAvatarInfoList_.get(i));
            }
            if (this.uid_ != 0) {
                output.writeUInt32(9, this.uid_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.retcode_);
            }
            for (int i = 0; i < this.showAvatarInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.showAvatarInfoList_.get(i));
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.uid_);
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
            if (!(obj instanceof GetFriendShowAvatarInfoRsp)) {
                return equals(obj);
            }
            GetFriendShowAvatarInfoRsp other = (GetFriendShowAvatarInfoRsp) obj;
            return getShowAvatarInfoListList().equals(other.getShowAvatarInfoListList()) && getUid() == other.getUid() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getShowAvatarInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getShowAvatarInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 9)) + getUid())) + 1)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetFriendShowAvatarInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetFriendShowAvatarInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetFriendShowAvatarInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetFriendShowAvatarInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetFriendShowAvatarInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetFriendShowAvatarInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetFriendShowAvatarInfoRsp parseFrom(InputStream input) throws IOException {
            return (GetFriendShowAvatarInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetFriendShowAvatarInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFriendShowAvatarInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetFriendShowAvatarInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetFriendShowAvatarInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetFriendShowAvatarInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFriendShowAvatarInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetFriendShowAvatarInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetFriendShowAvatarInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetFriendShowAvatarInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFriendShowAvatarInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetFriendShowAvatarInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetFriendShowAvatarInfoRspOuterClass$GetFriendShowAvatarInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetFriendShowAvatarInfoRspOrBuilder {
            private int bitField0_;
            private List<ShowAvatarInfoOuterClass.ShowAvatarInfo> showAvatarInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ShowAvatarInfoOuterClass.ShowAvatarInfo, ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder, ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder> showAvatarInfoListBuilder_;
            private int uid_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetFriendShowAvatarInfoRspOuterClass.internal_static_GetFriendShowAvatarInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetFriendShowAvatarInfoRspOuterClass.internal_static_GetFriendShowAvatarInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetFriendShowAvatarInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetFriendShowAvatarInfoRsp.alwaysUseFieldBuilders) {
                    getShowAvatarInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.showAvatarInfoListBuilder_ == null) {
                    this.showAvatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.showAvatarInfoListBuilder_.clear();
                }
                this.uid_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetFriendShowAvatarInfoRspOuterClass.internal_static_GetFriendShowAvatarInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetFriendShowAvatarInfoRsp getDefaultInstanceForType() {
                return GetFriendShowAvatarInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetFriendShowAvatarInfoRsp build() {
                GetFriendShowAvatarInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetFriendShowAvatarInfoRsp buildPartial() {
                GetFriendShowAvatarInfoRsp result = new GetFriendShowAvatarInfoRsp(this);
                int i = this.bitField0_;
                if (this.showAvatarInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.showAvatarInfoList_ = Collections.unmodifiableList(this.showAvatarInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.showAvatarInfoList_ = this.showAvatarInfoList_;
                } else {
                    result.showAvatarInfoList_ = this.showAvatarInfoListBuilder_.build();
                }
                result.uid_ = this.uid_;
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
                if (other instanceof GetFriendShowAvatarInfoRsp) {
                    return mergeFrom((GetFriendShowAvatarInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetFriendShowAvatarInfoRsp other) {
                if (other == GetFriendShowAvatarInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.showAvatarInfoListBuilder_ == null) {
                    if (!other.showAvatarInfoList_.isEmpty()) {
                        if (this.showAvatarInfoList_.isEmpty()) {
                            this.showAvatarInfoList_ = other.showAvatarInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureShowAvatarInfoListIsMutable();
                            this.showAvatarInfoList_.addAll(other.showAvatarInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.showAvatarInfoList_.isEmpty()) {
                    if (this.showAvatarInfoListBuilder_.isEmpty()) {
                        this.showAvatarInfoListBuilder_.dispose();
                        this.showAvatarInfoListBuilder_ = null;
                        this.showAvatarInfoList_ = other.showAvatarInfoList_;
                        this.bitField0_ &= -2;
                        this.showAvatarInfoListBuilder_ = GetFriendShowAvatarInfoRsp.alwaysUseFieldBuilders ? getShowAvatarInfoListFieldBuilder() : null;
                    } else {
                        this.showAvatarInfoListBuilder_.addAllMessages(other.showAvatarInfoList_);
                    }
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
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
                GetFriendShowAvatarInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetFriendShowAvatarInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetFriendShowAvatarInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureShowAvatarInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.showAvatarInfoList_ = new ArrayList(this.showAvatarInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
            public List<ShowAvatarInfoOuterClass.ShowAvatarInfo> getShowAvatarInfoListList() {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.showAvatarInfoList_);
                }
                return this.showAvatarInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
            public int getShowAvatarInfoListCount() {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return this.showAvatarInfoList_.size();
                }
                return this.showAvatarInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
            public ShowAvatarInfoOuterClass.ShowAvatarInfo getShowAvatarInfoList(int index) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return this.showAvatarInfoList_.get(index);
                }
                return this.showAvatarInfoListBuilder_.getMessage(index);
            }

            public Builder setShowAvatarInfoList(int index, ShowAvatarInfoOuterClass.ShowAvatarInfo value) {
                if (this.showAvatarInfoListBuilder_ != null) {
                    this.showAvatarInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setShowAvatarInfoList(int index, ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder builderForValue) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addShowAvatarInfoList(ShowAvatarInfoOuterClass.ShowAvatarInfo value) {
                if (this.showAvatarInfoListBuilder_ != null) {
                    this.showAvatarInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addShowAvatarInfoList(int index, ShowAvatarInfoOuterClass.ShowAvatarInfo value) {
                if (this.showAvatarInfoListBuilder_ != null) {
                    this.showAvatarInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addShowAvatarInfoList(ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder builderForValue) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addShowAvatarInfoList(int index, ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder builderForValue) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllShowAvatarInfoList(Iterable<? extends ShowAvatarInfoOuterClass.ShowAvatarInfo> values) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    ensureShowAvatarInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.showAvatarInfoList_);
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearShowAvatarInfoList() {
                if (this.showAvatarInfoListBuilder_ == null) {
                    this.showAvatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeShowAvatarInfoList(int index) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.remove(index);
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.remove(index);
                }
                return this;
            }

            public ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder getShowAvatarInfoListBuilder(int index) {
                return getShowAvatarInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
            public ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder getShowAvatarInfoListOrBuilder(int index) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return this.showAvatarInfoList_.get(index);
                }
                return this.showAvatarInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
            public List<? extends ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder> getShowAvatarInfoListOrBuilderList() {
                if (this.showAvatarInfoListBuilder_ != null) {
                    return this.showAvatarInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.showAvatarInfoList_);
            }

            public ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder addShowAvatarInfoListBuilder() {
                return getShowAvatarInfoListFieldBuilder().addBuilder(ShowAvatarInfoOuterClass.ShowAvatarInfo.getDefaultInstance());
            }

            public ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder addShowAvatarInfoListBuilder(int index) {
                return getShowAvatarInfoListFieldBuilder().addBuilder(index, ShowAvatarInfoOuterClass.ShowAvatarInfo.getDefaultInstance());
            }

            public List<ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder> getShowAvatarInfoListBuilderList() {
                return getShowAvatarInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ShowAvatarInfoOuterClass.ShowAvatarInfo, ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder, ShowAvatarInfoOuterClass.ShowAvatarInfoOrBuilder> getShowAvatarInfoListFieldBuilder() {
                if (this.showAvatarInfoListBuilder_ == null) {
                    this.showAvatarInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.showAvatarInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.showAvatarInfoList_ = null;
                }
                return this.showAvatarInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRspOrBuilder
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

        public static GetFriendShowAvatarInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetFriendShowAvatarInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetFriendShowAvatarInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetFriendShowAvatarInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ShowAvatarInfoOuterClass.getDescriptor();
    }
}
