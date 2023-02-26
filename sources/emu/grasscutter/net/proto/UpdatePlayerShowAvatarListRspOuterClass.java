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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowAvatarListRspOuterClass.class */
public final class UpdatePlayerShowAvatarListRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#UpdatePlayerShowAvatarListRsp.proto\"`\n\u001dUpdatePlayerShowAvatarListRsp\u0012\u0018\n\u0010showAvatarIdList\u0018\u000f \u0003(\r\u0012\u0014\n\fisShowAvatar\u0018\u000e \u0001(\b\u0012\u000f\n\u0007retcode\u0018\n \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UpdatePlayerShowAvatarListRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UpdatePlayerShowAvatarListRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UpdatePlayerShowAvatarListRsp_descriptor, new String[]{"ShowAvatarIdList", "IsShowAvatar", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowAvatarListRspOuterClass$UpdatePlayerShowAvatarListRspOrBuilder.class */
    public interface UpdatePlayerShowAvatarListRspOrBuilder extends MessageOrBuilder {
        List<Integer> getShowAvatarIdListList();

        int getShowAvatarIdListCount();

        int getShowAvatarIdList(int i);

        boolean getIsShowAvatar();

        int getRetcode();
    }

    private UpdatePlayerShowAvatarListRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowAvatarListRspOuterClass$UpdatePlayerShowAvatarListRsp.class */
    public static final class UpdatePlayerShowAvatarListRsp extends GeneratedMessageV3 implements UpdatePlayerShowAvatarListRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SHOWAVATARIDLIST_FIELD_NUMBER = 15;
        private Internal.IntList showAvatarIdList_;
        private int showAvatarIdListMemoizedSerializedSize;
        public static final int ISSHOWAVATAR_FIELD_NUMBER = 14;
        private boolean isShowAvatar_;
        public static final int RETCODE_FIELD_NUMBER = 10;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final UpdatePlayerShowAvatarListRsp DEFAULT_INSTANCE = new UpdatePlayerShowAvatarListRsp();
        private static final Parser<UpdatePlayerShowAvatarListRsp> PARSER = new AbstractParser<UpdatePlayerShowAvatarListRsp>() { // from class: emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRsp.1
            @Override // com.google.protobuf.Parser
            public UpdatePlayerShowAvatarListRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UpdatePlayerShowAvatarListRsp(input, extensionRegistry);
            }
        };

        private UpdatePlayerShowAvatarListRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.showAvatarIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private UpdatePlayerShowAvatarListRsp() {
            this.showAvatarIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.showAvatarIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UpdatePlayerShowAvatarListRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpdatePlayerShowAvatarListRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 80:
                                this.retcode_ = input.readInt32();
                                break;
                            case 112:
                                this.isShowAvatar_ = input.readBool();
                                break;
                            case 120:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.showAvatarIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.showAvatarIdList_.addInt(input.readUInt32());
                                break;
                            case 122:
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
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
            return UpdatePlayerShowAvatarListRspOuterClass.internal_static_UpdatePlayerShowAvatarListRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UpdatePlayerShowAvatarListRspOuterClass.internal_static_UpdatePlayerShowAvatarListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdatePlayerShowAvatarListRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRspOrBuilder
        public List<Integer> getShowAvatarIdListList() {
            return this.showAvatarIdList_;
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRspOrBuilder
        public int getShowAvatarIdListCount() {
            return this.showAvatarIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRspOrBuilder
        public int getShowAvatarIdList(int index) {
            return this.showAvatarIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRspOrBuilder
        public boolean getIsShowAvatar() {
            return this.isShowAvatar_;
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRspOrBuilder
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
            getSerializedSize();
            if (this.retcode_ != 0) {
                output.writeInt32(10, this.retcode_);
            }
            if (this.isShowAvatar_) {
                output.writeBool(14, this.isShowAvatar_);
            }
            if (getShowAvatarIdListList().size() > 0) {
                output.writeUInt32NoTag(122);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(10, this.retcode_);
            }
            if (this.isShowAvatar_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isShowAvatar_);
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
            if (!(obj instanceof UpdatePlayerShowAvatarListRsp)) {
                return equals(obj);
            }
            UpdatePlayerShowAvatarListRsp other = (UpdatePlayerShowAvatarListRsp) obj;
            return getShowAvatarIdListList().equals(other.getShowAvatarIdListList()) && getIsShowAvatar() == other.getIsShowAvatar() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getShowAvatarIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getShowAvatarIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 14)) + Internal.hashBoolean(getIsShowAvatar()))) + 10)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static UpdatePlayerShowAvatarListRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdatePlayerShowAvatarListRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdatePlayerShowAvatarListRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdatePlayerShowAvatarListRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdatePlayerShowAvatarListRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdatePlayerShowAvatarListRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdatePlayerShowAvatarListRsp parseFrom(InputStream input) throws IOException {
            return (UpdatePlayerShowAvatarListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UpdatePlayerShowAvatarListRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdatePlayerShowAvatarListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UpdatePlayerShowAvatarListRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (UpdatePlayerShowAvatarListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UpdatePlayerShowAvatarListRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdatePlayerShowAvatarListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UpdatePlayerShowAvatarListRsp parseFrom(CodedInputStream input) throws IOException {
            return (UpdatePlayerShowAvatarListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UpdatePlayerShowAvatarListRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdatePlayerShowAvatarListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UpdatePlayerShowAvatarListRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowAvatarListRspOuterClass$UpdatePlayerShowAvatarListRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UpdatePlayerShowAvatarListRspOrBuilder {
            private int bitField0_;
            private Internal.IntList showAvatarIdList_ = UpdatePlayerShowAvatarListRsp.emptyIntList();
            private boolean isShowAvatar_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UpdatePlayerShowAvatarListRspOuterClass.internal_static_UpdatePlayerShowAvatarListRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UpdatePlayerShowAvatarListRspOuterClass.internal_static_UpdatePlayerShowAvatarListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdatePlayerShowAvatarListRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UpdatePlayerShowAvatarListRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.showAvatarIdList_ = UpdatePlayerShowAvatarListRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.isShowAvatar_ = false;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UpdatePlayerShowAvatarListRspOuterClass.internal_static_UpdatePlayerShowAvatarListRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UpdatePlayerShowAvatarListRsp getDefaultInstanceForType() {
                return UpdatePlayerShowAvatarListRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UpdatePlayerShowAvatarListRsp build() {
                UpdatePlayerShowAvatarListRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UpdatePlayerShowAvatarListRsp buildPartial() {
                UpdatePlayerShowAvatarListRsp result = new UpdatePlayerShowAvatarListRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.showAvatarIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.showAvatarIdList_ = this.showAvatarIdList_;
                result.isShowAvatar_ = this.isShowAvatar_;
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
                if (other instanceof UpdatePlayerShowAvatarListRsp) {
                    return mergeFrom((UpdatePlayerShowAvatarListRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UpdatePlayerShowAvatarListRsp other) {
                if (other == UpdatePlayerShowAvatarListRsp.getDefaultInstance()) {
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
                UpdatePlayerShowAvatarListRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = UpdatePlayerShowAvatarListRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UpdatePlayerShowAvatarListRsp) e.getUnfinishedMessage();
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
                    this.showAvatarIdList_ = UpdatePlayerShowAvatarListRsp.mutableCopy(this.showAvatarIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRspOrBuilder
            public List<Integer> getShowAvatarIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.showAvatarIdList_) : this.showAvatarIdList_;
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRspOrBuilder
            public int getShowAvatarIdListCount() {
                return this.showAvatarIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRspOrBuilder
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
                this.showAvatarIdList_ = UpdatePlayerShowAvatarListRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRspOrBuilder
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

        public static UpdatePlayerShowAvatarListRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UpdatePlayerShowAvatarListRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UpdatePlayerShowAvatarListRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UpdatePlayerShowAvatarListRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
