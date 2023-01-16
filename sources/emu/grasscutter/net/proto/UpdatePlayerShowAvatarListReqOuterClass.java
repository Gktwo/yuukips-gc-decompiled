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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowAvatarListReqOuterClass.class */
public final class UpdatePlayerShowAvatarListReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#UpdatePlayerShowAvatarListReq.proto\"T\n\u001dUpdatePlayerShowAvatarListReq\u0012\u001b\n\u0013show_avatar_id_list\u0018\n \u0003(\r\u0012\u0016\n\u000eis_show_avatar\u0018\u0006 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UpdatePlayerShowAvatarListReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UpdatePlayerShowAvatarListReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UpdatePlayerShowAvatarListReq_descriptor, new String[]{"ShowAvatarIdList", "IsShowAvatar"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowAvatarListReqOuterClass$UpdatePlayerShowAvatarListReqOrBuilder.class */
    public interface UpdatePlayerShowAvatarListReqOrBuilder extends MessageOrBuilder {
        List<Integer> getShowAvatarIdListList();

        int getShowAvatarIdListCount();

        int getShowAvatarIdList(int i);

        boolean getIsShowAvatar();
    }

    private UpdatePlayerShowAvatarListReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowAvatarListReqOuterClass$UpdatePlayerShowAvatarListReq.class */
    public static final class UpdatePlayerShowAvatarListReq extends GeneratedMessageV3 implements UpdatePlayerShowAvatarListReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SHOW_AVATAR_ID_LIST_FIELD_NUMBER = 10;
        private Internal.IntList showAvatarIdList_;
        private int showAvatarIdListMemoizedSerializedSize;
        public static final int IS_SHOW_AVATAR_FIELD_NUMBER = 6;
        private boolean isShowAvatar_;
        private byte memoizedIsInitialized;
        private static final UpdatePlayerShowAvatarListReq DEFAULT_INSTANCE = new UpdatePlayerShowAvatarListReq();
        private static final Parser<UpdatePlayerShowAvatarListReq> PARSER = new AbstractParser<UpdatePlayerShowAvatarListReq>() { // from class: emu.grasscutter.net.proto.UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReq.1
            @Override // com.google.protobuf.Parser
            public UpdatePlayerShowAvatarListReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UpdatePlayerShowAvatarListReq(input, extensionRegistry);
            }
        };

        private UpdatePlayerShowAvatarListReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.showAvatarIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private UpdatePlayerShowAvatarListReq() {
            this.showAvatarIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.showAvatarIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UpdatePlayerShowAvatarListReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpdatePlayerShowAvatarListReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.isShowAvatar_ = input.readBool();
                                    break;
                                case 80:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.showAvatarIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.showAvatarIdList_.addInt(input.readUInt32());
                                    break;
                                case 82:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.showAvatarIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.showAvatarIdList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
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
                    this.showAvatarIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UpdatePlayerShowAvatarListReqOuterClass.internal_static_UpdatePlayerShowAvatarListReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UpdatePlayerShowAvatarListReqOuterClass.internal_static_UpdatePlayerShowAvatarListReq_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdatePlayerShowAvatarListReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReqOrBuilder
        public List<Integer> getShowAvatarIdListList() {
            return this.showAvatarIdList_;
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReqOrBuilder
        public int getShowAvatarIdListCount() {
            return this.showAvatarIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReqOrBuilder
        public int getShowAvatarIdList(int index) {
            return this.showAvatarIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReqOrBuilder
        public boolean getIsShowAvatar() {
            return this.isShowAvatar_;
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
            getSerializedSize();
            if (this.isShowAvatar_) {
                output.writeBool(6, this.isShowAvatar_);
            }
            if (getShowAvatarIdListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.showAvatarIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.showAvatarIdList_.size(); i++) {
                output.writeUInt32NoTag(this.showAvatarIdList_.getInt(i));
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
            if (this.isShowAvatar_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(6, this.isShowAvatar_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.showAvatarIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.showAvatarIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getShowAvatarIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.showAvatarIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UpdatePlayerShowAvatarListReq)) {
                return equals(obj);
            }
            UpdatePlayerShowAvatarListReq other = (UpdatePlayerShowAvatarListReq) obj;
            return getShowAvatarIdListList().equals(other.getShowAvatarIdListList()) && getIsShowAvatar() == other.getIsShowAvatar() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getShowAvatarIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getShowAvatarIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 6)) + Internal.hashBoolean(getIsShowAvatar()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static UpdatePlayerShowAvatarListReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdatePlayerShowAvatarListReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdatePlayerShowAvatarListReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdatePlayerShowAvatarListReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdatePlayerShowAvatarListReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdatePlayerShowAvatarListReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdatePlayerShowAvatarListReq parseFrom(InputStream input) throws IOException {
            return (UpdatePlayerShowAvatarListReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UpdatePlayerShowAvatarListReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdatePlayerShowAvatarListReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UpdatePlayerShowAvatarListReq parseDelimitedFrom(InputStream input) throws IOException {
            return (UpdatePlayerShowAvatarListReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UpdatePlayerShowAvatarListReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdatePlayerShowAvatarListReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UpdatePlayerShowAvatarListReq parseFrom(CodedInputStream input) throws IOException {
            return (UpdatePlayerShowAvatarListReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UpdatePlayerShowAvatarListReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdatePlayerShowAvatarListReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UpdatePlayerShowAvatarListReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowAvatarListReqOuterClass$UpdatePlayerShowAvatarListReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UpdatePlayerShowAvatarListReqOrBuilder {
            private int bitField0_;
            private Internal.IntList showAvatarIdList_ = UpdatePlayerShowAvatarListReq.emptyIntList();
            private boolean isShowAvatar_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UpdatePlayerShowAvatarListReqOuterClass.internal_static_UpdatePlayerShowAvatarListReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UpdatePlayerShowAvatarListReqOuterClass.internal_static_UpdatePlayerShowAvatarListReq_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdatePlayerShowAvatarListReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UpdatePlayerShowAvatarListReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.showAvatarIdList_ = UpdatePlayerShowAvatarListReq.emptyIntList();
                this.bitField0_ &= -2;
                this.isShowAvatar_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UpdatePlayerShowAvatarListReqOuterClass.internal_static_UpdatePlayerShowAvatarListReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UpdatePlayerShowAvatarListReq getDefaultInstanceForType() {
                return UpdatePlayerShowAvatarListReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UpdatePlayerShowAvatarListReq build() {
                UpdatePlayerShowAvatarListReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UpdatePlayerShowAvatarListReq buildPartial() {
                UpdatePlayerShowAvatarListReq result = new UpdatePlayerShowAvatarListReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.showAvatarIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.showAvatarIdList_ = this.showAvatarIdList_;
                result.isShowAvatar_ = this.isShowAvatar_;
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
                if (other instanceof UpdatePlayerShowAvatarListReq) {
                    return mergeFrom((UpdatePlayerShowAvatarListReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UpdatePlayerShowAvatarListReq other) {
                if (other == UpdatePlayerShowAvatarListReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.showAvatarIdList_.isEmpty()) {
                    if (this.showAvatarIdList_.isEmpty()) {
                        this.showAvatarIdList_ = other.showAvatarIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureShowAvatarIdListIsMutable();
                        this.showAvatarIdList_.addAll(other.showAvatarIdList_);
                    }
                    onChanged();
                }
                if (other.getIsShowAvatar()) {
                    setIsShowAvatar(other.getIsShowAvatar());
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
                UpdatePlayerShowAvatarListReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = UpdatePlayerShowAvatarListReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UpdatePlayerShowAvatarListReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureShowAvatarIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.showAvatarIdList_ = UpdatePlayerShowAvatarListReq.mutableCopy(this.showAvatarIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReqOrBuilder
            public List<Integer> getShowAvatarIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.showAvatarIdList_) : this.showAvatarIdList_;
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReqOrBuilder
            public int getShowAvatarIdListCount() {
                return this.showAvatarIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReqOrBuilder
            public int getShowAvatarIdList(int index) {
                return this.showAvatarIdList_.getInt(index);
            }

            public Builder setShowAvatarIdList(int index, int value) {
                ensureShowAvatarIdListIsMutable();
                this.showAvatarIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addShowAvatarIdList(int value) {
                ensureShowAvatarIdListIsMutable();
                this.showAvatarIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllShowAvatarIdList(Iterable<? extends Integer> values) {
                ensureShowAvatarIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.showAvatarIdList_);
                onChanged();
                return this;
            }

            public Builder clearShowAvatarIdList() {
                this.showAvatarIdList_ = UpdatePlayerShowAvatarListReq.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReqOrBuilder
            public boolean getIsShowAvatar() {
                return this.isShowAvatar_;
            }

            public Builder setIsShowAvatar(boolean value) {
                this.isShowAvatar_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsShowAvatar() {
                this.isShowAvatar_ = false;
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

        public static UpdatePlayerShowAvatarListReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UpdatePlayerShowAvatarListReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UpdatePlayerShowAvatarListReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UpdatePlayerShowAvatarListReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
