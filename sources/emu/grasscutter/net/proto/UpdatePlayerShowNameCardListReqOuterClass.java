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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowNameCardListReqOuterClass.class */
public final class UpdatePlayerShowNameCardListReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%UpdatePlayerShowNameCardListReq.proto\"=\n\u001fUpdatePlayerShowNameCardListReq\u0012\u001a\n\u0012showNameCardIdList\u0018\u000e \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UpdatePlayerShowNameCardListReq_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_UpdatePlayerShowNameCardListReq_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f874xa6a1931d = new GeneratedMessageV3.FieldAccessorTable(internal_static_UpdatePlayerShowNameCardListReq_descriptor, new String[]{"ShowNameCardIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowNameCardListReqOuterClass$UpdatePlayerShowNameCardListReqOrBuilder.class */
    public interface UpdatePlayerShowNameCardListReqOrBuilder extends MessageOrBuilder {
        List<Integer> getShowNameCardIdListList();

        int getShowNameCardIdListCount();

        int getShowNameCardIdList(int i);
    }

    private UpdatePlayerShowNameCardListReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowNameCardListReqOuterClass$UpdatePlayerShowNameCardListReq.class */
    public static final class UpdatePlayerShowNameCardListReq extends GeneratedMessageV3 implements UpdatePlayerShowNameCardListReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SHOWNAMECARDIDLIST_FIELD_NUMBER = 14;
        private Internal.IntList showNameCardIdList_;
        private int showNameCardIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final UpdatePlayerShowNameCardListReq DEFAULT_INSTANCE = new UpdatePlayerShowNameCardListReq();
        private static final Parser<UpdatePlayerShowNameCardListReq> PARSER = new AbstractParser<UpdatePlayerShowNameCardListReq>() { // from class: emu.grasscutter.net.proto.UpdatePlayerShowNameCardListReqOuterClass.UpdatePlayerShowNameCardListReq.1
            @Override // com.google.protobuf.Parser
            public UpdatePlayerShowNameCardListReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UpdatePlayerShowNameCardListReq(input, extensionRegistry);
            }
        };

        private UpdatePlayerShowNameCardListReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.showNameCardIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private UpdatePlayerShowNameCardListReq() {
            this.showNameCardIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.showNameCardIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UpdatePlayerShowNameCardListReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpdatePlayerShowNameCardListReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 112:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.showNameCardIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.showNameCardIdList_.addInt(input.readUInt32());
                                    break;
                                case 114:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.showNameCardIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.showNameCardIdList_.addInt(input.readUInt32());
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.showNameCardIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UpdatePlayerShowNameCardListReqOuterClass.internal_static_UpdatePlayerShowNameCardListReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UpdatePlayerShowNameCardListReqOuterClass.f874xa6a1931d.ensureFieldAccessorsInitialized(UpdatePlayerShowNameCardListReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowNameCardListReqOuterClass.UpdatePlayerShowNameCardListReqOrBuilder
        public List<Integer> getShowNameCardIdListList() {
            return this.showNameCardIdList_;
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowNameCardListReqOuterClass.UpdatePlayerShowNameCardListReqOrBuilder
        public int getShowNameCardIdListCount() {
            return this.showNameCardIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.UpdatePlayerShowNameCardListReqOuterClass.UpdatePlayerShowNameCardListReqOrBuilder
        public int getShowNameCardIdList(int index) {
            return this.showNameCardIdList_.getInt(index);
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
            if (getShowNameCardIdListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.showNameCardIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.showNameCardIdList_.size(); i++) {
                output.writeUInt32NoTag(this.showNameCardIdList_.getInt(i));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.showNameCardIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.showNameCardIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getShowNameCardIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.showNameCardIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UpdatePlayerShowNameCardListReq)) {
                return equals(obj);
            }
            UpdatePlayerShowNameCardListReq other = (UpdatePlayerShowNameCardListReq) obj;
            return getShowNameCardIdListList().equals(other.getShowNameCardIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getShowNameCardIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getShowNameCardIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static UpdatePlayerShowNameCardListReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdatePlayerShowNameCardListReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdatePlayerShowNameCardListReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdatePlayerShowNameCardListReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdatePlayerShowNameCardListReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdatePlayerShowNameCardListReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdatePlayerShowNameCardListReq parseFrom(InputStream input) throws IOException {
            return (UpdatePlayerShowNameCardListReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UpdatePlayerShowNameCardListReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdatePlayerShowNameCardListReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UpdatePlayerShowNameCardListReq parseDelimitedFrom(InputStream input) throws IOException {
            return (UpdatePlayerShowNameCardListReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UpdatePlayerShowNameCardListReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdatePlayerShowNameCardListReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UpdatePlayerShowNameCardListReq parseFrom(CodedInputStream input) throws IOException {
            return (UpdatePlayerShowNameCardListReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UpdatePlayerShowNameCardListReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdatePlayerShowNameCardListReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UpdatePlayerShowNameCardListReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdatePlayerShowNameCardListReqOuterClass$UpdatePlayerShowNameCardListReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UpdatePlayerShowNameCardListReqOrBuilder {
            private int bitField0_;
            private Internal.IntList showNameCardIdList_ = UpdatePlayerShowNameCardListReq.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return UpdatePlayerShowNameCardListReqOuterClass.internal_static_UpdatePlayerShowNameCardListReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UpdatePlayerShowNameCardListReqOuterClass.f874xa6a1931d.ensureFieldAccessorsInitialized(UpdatePlayerShowNameCardListReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UpdatePlayerShowNameCardListReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.showNameCardIdList_ = UpdatePlayerShowNameCardListReq.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UpdatePlayerShowNameCardListReqOuterClass.internal_static_UpdatePlayerShowNameCardListReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UpdatePlayerShowNameCardListReq getDefaultInstanceForType() {
                return UpdatePlayerShowNameCardListReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UpdatePlayerShowNameCardListReq build() {
                UpdatePlayerShowNameCardListReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UpdatePlayerShowNameCardListReq buildPartial() {
                UpdatePlayerShowNameCardListReq result = new UpdatePlayerShowNameCardListReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.showNameCardIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.showNameCardIdList_ = this.showNameCardIdList_;
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
                if (other instanceof UpdatePlayerShowNameCardListReq) {
                    return mergeFrom((UpdatePlayerShowNameCardListReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UpdatePlayerShowNameCardListReq other) {
                if (other == UpdatePlayerShowNameCardListReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.showNameCardIdList_.isEmpty()) {
                    if (this.showNameCardIdList_.isEmpty()) {
                        this.showNameCardIdList_ = other.showNameCardIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureShowNameCardIdListIsMutable();
                        this.showNameCardIdList_.addAll(other.showNameCardIdList_);
                    }
                    onChanged();
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
                UpdatePlayerShowNameCardListReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = UpdatePlayerShowNameCardListReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UpdatePlayerShowNameCardListReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureShowNameCardIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.showNameCardIdList_ = UpdatePlayerShowNameCardListReq.mutableCopy(this.showNameCardIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowNameCardListReqOuterClass.UpdatePlayerShowNameCardListReqOrBuilder
            public List<Integer> getShowNameCardIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.showNameCardIdList_) : this.showNameCardIdList_;
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowNameCardListReqOuterClass.UpdatePlayerShowNameCardListReqOrBuilder
            public int getShowNameCardIdListCount() {
                return this.showNameCardIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.UpdatePlayerShowNameCardListReqOuterClass.UpdatePlayerShowNameCardListReqOrBuilder
            public int getShowNameCardIdList(int index) {
                return this.showNameCardIdList_.getInt(index);
            }

            public Builder setShowNameCardIdList(int index, int value) {
                ensureShowNameCardIdListIsMutable();
                this.showNameCardIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addShowNameCardIdList(int value) {
                ensureShowNameCardIdListIsMutable();
                this.showNameCardIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllShowNameCardIdList(Iterable<? extends Integer> values) {
                ensureShowNameCardIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.showNameCardIdList_);
                onChanged();
                return this;
            }

            public Builder clearShowNameCardIdList() {
                this.showNameCardIdList_ = UpdatePlayerShowNameCardListReq.emptyIntList();
                this.bitField0_ &= -2;
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

        public static UpdatePlayerShowNameCardListReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UpdatePlayerShowNameCardListReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UpdatePlayerShowNameCardListReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UpdatePlayerShowNameCardListReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
