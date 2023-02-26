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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekInfoOuterClass.class */
public final class HideAndSeekInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015HideAndSeekInfo.proto\"@\n\u000fHideAndSeekInfo\u0012\u0016\n\u000evisibleUidList\u0018\u0005 \u0003(\r\u0012\u0015\n\rcaughtUidList\u0018\u0007 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HideAndSeekInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HideAndSeekInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HideAndSeekInfo_descriptor, new String[]{"VisibleUidList", "CaughtUidList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekInfoOuterClass$HideAndSeekInfoOrBuilder.class */
    public interface HideAndSeekInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getVisibleUidListList();

        int getVisibleUidListCount();

        int getVisibleUidList(int i);

        List<Integer> getCaughtUidListList();

        int getCaughtUidListCount();

        int getCaughtUidList(int i);
    }

    private HideAndSeekInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekInfoOuterClass$HideAndSeekInfo.class */
    public static final class HideAndSeekInfo extends GeneratedMessageV3 implements HideAndSeekInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int VISIBLEUIDLIST_FIELD_NUMBER = 5;
        private Internal.IntList visibleUidList_;
        private int visibleUidListMemoizedSerializedSize;
        public static final int CAUGHTUIDLIST_FIELD_NUMBER = 7;
        private Internal.IntList caughtUidList_;
        private int caughtUidListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final HideAndSeekInfo DEFAULT_INSTANCE = new HideAndSeekInfo();
        private static final Parser<HideAndSeekInfo> PARSER = new AbstractParser<HideAndSeekInfo>() { // from class: emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfo.1
            @Override // com.google.protobuf.Parser
            public HideAndSeekInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HideAndSeekInfo(input, extensionRegistry);
            }
        };

        private HideAndSeekInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.visibleUidListMemoizedSerializedSize = -1;
            this.caughtUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HideAndSeekInfo() {
            this.visibleUidListMemoizedSerializedSize = -1;
            this.caughtUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.visibleUidList_ = emptyIntList();
            this.caughtUidList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HideAndSeekInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x013c */
        private HideAndSeekInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.visibleUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.visibleUidList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.visibleUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.visibleUidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.caughtUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.caughtUidList_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.caughtUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.caughtUidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
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
                    this.visibleUidList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.caughtUidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HideAndSeekInfoOuterClass.internal_static_HideAndSeekInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HideAndSeekInfoOuterClass.internal_static_HideAndSeekInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HideAndSeekInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
        public List<Integer> getVisibleUidListList() {
            return this.visibleUidList_;
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
        public int getVisibleUidListCount() {
            return this.visibleUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
        public int getVisibleUidList(int index) {
            return this.visibleUidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
        public List<Integer> getCaughtUidListList() {
            return this.caughtUidList_;
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
        public int getCaughtUidListCount() {
            return this.caughtUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
        public int getCaughtUidList(int index) {
            return this.caughtUidList_.getInt(index);
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
            if (getVisibleUidListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.visibleUidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.visibleUidList_.size(); i++) {
                output.writeUInt32NoTag(this.visibleUidList_.getInt(i));
            }
            if (getCaughtUidListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.caughtUidListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.caughtUidList_.size(); i2++) {
                output.writeUInt32NoTag(this.caughtUidList_.getInt(i2));
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
            for (int i = 0; i < this.visibleUidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.visibleUidList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getVisibleUidListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.visibleUidListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.caughtUidList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.caughtUidList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getCaughtUidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.caughtUidListMemoizedSerializedSize = dataSize2;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HideAndSeekInfo)) {
                return equals(obj);
            }
            HideAndSeekInfo other = (HideAndSeekInfo) obj;
            return getVisibleUidListList().equals(other.getVisibleUidListList()) && getCaughtUidListList().equals(other.getCaughtUidListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getVisibleUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getVisibleUidListList().hashCode();
            }
            if (getCaughtUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getCaughtUidListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HideAndSeekInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HideAndSeekInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HideAndSeekInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HideAndSeekInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HideAndSeekInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HideAndSeekInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HideAndSeekInfo parseFrom(InputStream input) throws IOException {
            return (HideAndSeekInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HideAndSeekInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HideAndSeekInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HideAndSeekInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HideAndSeekInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HideAndSeekInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HideAndSeekInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HideAndSeekInfo parseFrom(CodedInputStream input) throws IOException {
            return (HideAndSeekInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HideAndSeekInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HideAndSeekInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HideAndSeekInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekInfoOuterClass$HideAndSeekInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HideAndSeekInfoOrBuilder {
            private int bitField0_;
            private Internal.IntList visibleUidList_ = HideAndSeekInfo.emptyIntList();
            private Internal.IntList caughtUidList_ = HideAndSeekInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return HideAndSeekInfoOuterClass.internal_static_HideAndSeekInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HideAndSeekInfoOuterClass.internal_static_HideAndSeekInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HideAndSeekInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HideAndSeekInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.visibleUidList_ = HideAndSeekInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.caughtUidList_ = HideAndSeekInfo.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HideAndSeekInfoOuterClass.internal_static_HideAndSeekInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HideAndSeekInfo getDefaultInstanceForType() {
                return HideAndSeekInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HideAndSeekInfo build() {
                HideAndSeekInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HideAndSeekInfo buildPartial() {
                HideAndSeekInfo result = new HideAndSeekInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.visibleUidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.visibleUidList_ = this.visibleUidList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.caughtUidList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.caughtUidList_ = this.caughtUidList_;
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
                if (other instanceof HideAndSeekInfo) {
                    return mergeFrom((HideAndSeekInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HideAndSeekInfo other) {
                if (other == HideAndSeekInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.visibleUidList_.isEmpty()) {
                    if (this.visibleUidList_.isEmpty()) {
                        this.visibleUidList_ = other.visibleUidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureVisibleUidListIsMutable();
                        this.visibleUidList_.addAll(other.visibleUidList_);
                    }
                    onChanged();
                }
                if (!other.caughtUidList_.isEmpty()) {
                    if (this.caughtUidList_.isEmpty()) {
                        this.caughtUidList_ = other.caughtUidList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureCaughtUidListIsMutable();
                        this.caughtUidList_.addAll(other.caughtUidList_);
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
                HideAndSeekInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HideAndSeekInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HideAndSeekInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureVisibleUidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.visibleUidList_ = HideAndSeekInfo.mutableCopy(this.visibleUidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
            public List<Integer> getVisibleUidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.visibleUidList_) : this.visibleUidList_;
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
            public int getVisibleUidListCount() {
                return this.visibleUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
            public int getVisibleUidList(int index) {
                return this.visibleUidList_.getInt(index);
            }

            public Builder setVisibleUidList(int index, int value) {
                ensureVisibleUidListIsMutable();
                this.visibleUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addVisibleUidList(int value) {
                ensureVisibleUidListIsMutable();
                this.visibleUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllVisibleUidList(Iterable<? extends Integer> values) {
                ensureVisibleUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.visibleUidList_);
                onChanged();
                return this;
            }

            public Builder clearVisibleUidList() {
                this.visibleUidList_ = HideAndSeekInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureCaughtUidListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.caughtUidList_ = HideAndSeekInfo.mutableCopy(this.caughtUidList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
            public List<Integer> getCaughtUidListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.caughtUidList_) : this.caughtUidList_;
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
            public int getCaughtUidListCount() {
                return this.caughtUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder
            public int getCaughtUidList(int index) {
                return this.caughtUidList_.getInt(index);
            }

            public Builder setCaughtUidList(int index, int value) {
                ensureCaughtUidListIsMutable();
                this.caughtUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addCaughtUidList(int value) {
                ensureCaughtUidListIsMutable();
                this.caughtUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllCaughtUidList(Iterable<? extends Integer> values) {
                ensureCaughtUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.caughtUidList_);
                onChanged();
                return this;
            }

            public Builder clearCaughtUidList() {
                this.caughtUidList_ = HideAndSeekInfo.emptyIntList();
                this.bitField0_ &= -3;
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

        public static HideAndSeekInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HideAndSeekInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HideAndSeekInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HideAndSeekInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
