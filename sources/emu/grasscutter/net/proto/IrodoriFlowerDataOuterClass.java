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
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriFlowerDataOuterClass.class */
public final class IrodoriFlowerDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017IrodoriFlowerData.proto\u001a\u000fItemParam.proto\"R\n\u0011IrodoriFlowerData\u0012\u0019\n\u0011finishedThemeList\u0018\u0005 \u0003(\r\u0012\"\n\u000eusedFlowerList\u0018\f \u0003(\u000b2\n.ItemParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IrodoriFlowerData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriFlowerData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriFlowerData_descriptor, new String[]{"FinishedThemeList", "UsedFlowerList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriFlowerDataOuterClass$IrodoriFlowerDataOrBuilder.class */
    public interface IrodoriFlowerDataOrBuilder extends MessageOrBuilder {
        List<Integer> getFinishedThemeListList();

        int getFinishedThemeListCount();

        int getFinishedThemeList(int i);

        List<ItemParamOuterClass.ItemParam> getUsedFlowerListList();

        ItemParamOuterClass.ItemParam getUsedFlowerList(int i);

        int getUsedFlowerListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUsedFlowerListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getUsedFlowerListOrBuilder(int i);
    }

    private IrodoriFlowerDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriFlowerDataOuterClass$IrodoriFlowerData.class */
    public static final class IrodoriFlowerData extends GeneratedMessageV3 implements IrodoriFlowerDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FINISHEDTHEMELIST_FIELD_NUMBER = 5;
        private Internal.IntList finishedThemeList_;
        private int finishedThemeListMemoizedSerializedSize;
        public static final int USEDFLOWERLIST_FIELD_NUMBER = 12;
        private List<ItemParamOuterClass.ItemParam> usedFlowerList_;
        private byte memoizedIsInitialized;
        private static final IrodoriFlowerData DEFAULT_INSTANCE = new IrodoriFlowerData();
        private static final Parser<IrodoriFlowerData> PARSER = new AbstractParser<IrodoriFlowerData>() { // from class: emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerData.1
            @Override // com.google.protobuf.Parser
            public IrodoriFlowerData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriFlowerData(input, extensionRegistry);
            }
        };

        private IrodoriFlowerData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.finishedThemeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private IrodoriFlowerData() {
            this.finishedThemeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.finishedThemeList_ = emptyIntList();
            this.usedFlowerList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriFlowerData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x00fa */
        private IrodoriFlowerData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.finishedThemeList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.finishedThemeList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.finishedThemeList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.finishedThemeList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.usedFlowerList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.usedFlowerList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
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
                    this.finishedThemeList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.usedFlowerList_ = Collections.unmodifiableList(this.usedFlowerList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriFlowerDataOuterClass.internal_static_IrodoriFlowerData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriFlowerDataOuterClass.internal_static_IrodoriFlowerData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriFlowerData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
        public List<Integer> getFinishedThemeListList() {
            return this.finishedThemeList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
        public int getFinishedThemeListCount() {
            return this.finishedThemeList_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
        public int getFinishedThemeList(int index) {
            return this.finishedThemeList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
        public List<ItemParamOuterClass.ItemParam> getUsedFlowerListList() {
            return this.usedFlowerList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUsedFlowerListOrBuilderList() {
            return this.usedFlowerList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
        public int getUsedFlowerListCount() {
            return this.usedFlowerList_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
        public ItemParamOuterClass.ItemParam getUsedFlowerList(int index) {
            return this.usedFlowerList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getUsedFlowerListOrBuilder(int index) {
            return this.usedFlowerList_.get(index);
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
            if (getFinishedThemeListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.finishedThemeListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.finishedThemeList_.size(); i++) {
                output.writeUInt32NoTag(this.finishedThemeList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.usedFlowerList_.size(); i2++) {
                output.writeMessage(12, this.usedFlowerList_.get(i2));
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
            for (int i = 0; i < this.finishedThemeList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.finishedThemeList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getFinishedThemeListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.finishedThemeListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.usedFlowerList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.usedFlowerList_.get(i2));
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
            if (!(obj instanceof IrodoriFlowerData)) {
                return equals(obj);
            }
            IrodoriFlowerData other = (IrodoriFlowerData) obj;
            return getFinishedThemeListList().equals(other.getFinishedThemeListList()) && getUsedFlowerListList().equals(other.getUsedFlowerListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getFinishedThemeListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getFinishedThemeListList().hashCode();
            }
            if (getUsedFlowerListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getUsedFlowerListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriFlowerData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriFlowerData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriFlowerData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriFlowerData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriFlowerData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriFlowerData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriFlowerData parseFrom(InputStream input) throws IOException {
            return (IrodoriFlowerData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriFlowerData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriFlowerData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriFlowerData parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriFlowerData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriFlowerData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriFlowerData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriFlowerData parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriFlowerData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriFlowerData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriFlowerData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriFlowerData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriFlowerDataOuterClass$IrodoriFlowerData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriFlowerDataOrBuilder {
            private int bitField0_;
            private Internal.IntList finishedThemeList_ = IrodoriFlowerData.emptyIntList();
            private List<ItemParamOuterClass.ItemParam> usedFlowerList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> usedFlowerListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriFlowerDataOuterClass.internal_static_IrodoriFlowerData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriFlowerDataOuterClass.internal_static_IrodoriFlowerData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriFlowerData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriFlowerData.alwaysUseFieldBuilders) {
                    getUsedFlowerListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.finishedThemeList_ = IrodoriFlowerData.emptyIntList();
                this.bitField0_ &= -2;
                if (this.usedFlowerListBuilder_ == null) {
                    this.usedFlowerList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.usedFlowerListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriFlowerDataOuterClass.internal_static_IrodoriFlowerData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriFlowerData getDefaultInstanceForType() {
                return IrodoriFlowerData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriFlowerData build() {
                IrodoriFlowerData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriFlowerData buildPartial() {
                IrodoriFlowerData result = new IrodoriFlowerData(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.finishedThemeList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.finishedThemeList_ = this.finishedThemeList_;
                if (this.usedFlowerListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.usedFlowerList_ = Collections.unmodifiableList(this.usedFlowerList_);
                        this.bitField0_ &= -3;
                    }
                    result.usedFlowerList_ = this.usedFlowerList_;
                } else {
                    result.usedFlowerList_ = this.usedFlowerListBuilder_.build();
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
                if (other instanceof IrodoriFlowerData) {
                    return mergeFrom((IrodoriFlowerData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriFlowerData other) {
                if (other == IrodoriFlowerData.getDefaultInstance()) {
                    return this;
                }
                if (!other.finishedThemeList_.isEmpty()) {
                    if (this.finishedThemeList_.isEmpty()) {
                        this.finishedThemeList_ = other.finishedThemeList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFinishedThemeListIsMutable();
                        this.finishedThemeList_.addAll(other.finishedThemeList_);
                    }
                    onChanged();
                }
                if (this.usedFlowerListBuilder_ == null) {
                    if (!other.usedFlowerList_.isEmpty()) {
                        if (this.usedFlowerList_.isEmpty()) {
                            this.usedFlowerList_ = other.usedFlowerList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureUsedFlowerListIsMutable();
                            this.usedFlowerList_.addAll(other.usedFlowerList_);
                        }
                        onChanged();
                    }
                } else if (!other.usedFlowerList_.isEmpty()) {
                    if (this.usedFlowerListBuilder_.isEmpty()) {
                        this.usedFlowerListBuilder_.dispose();
                        this.usedFlowerListBuilder_ = null;
                        this.usedFlowerList_ = other.usedFlowerList_;
                        this.bitField0_ &= -3;
                        this.usedFlowerListBuilder_ = IrodoriFlowerData.alwaysUseFieldBuilders ? getUsedFlowerListFieldBuilder() : null;
                    } else {
                        this.usedFlowerListBuilder_.addAllMessages(other.usedFlowerList_);
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
                IrodoriFlowerData parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriFlowerData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriFlowerData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureFinishedThemeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.finishedThemeList_ = IrodoriFlowerData.mutableCopy(this.finishedThemeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
            public List<Integer> getFinishedThemeListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.finishedThemeList_) : this.finishedThemeList_;
            }

            @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
            public int getFinishedThemeListCount() {
                return this.finishedThemeList_.size();
            }

            @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
            public int getFinishedThemeList(int index) {
                return this.finishedThemeList_.getInt(index);
            }

            public Builder setFinishedThemeList(int index, int value) {
                ensureFinishedThemeListIsMutable();
                this.finishedThemeList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFinishedThemeList(int value) {
                ensureFinishedThemeListIsMutable();
                this.finishedThemeList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFinishedThemeList(Iterable<? extends Integer> values) {
                ensureFinishedThemeListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.finishedThemeList_);
                onChanged();
                return this;
            }

            public Builder clearFinishedThemeList() {
                this.finishedThemeList_ = IrodoriFlowerData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureUsedFlowerListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.usedFlowerList_ = new ArrayList(this.usedFlowerList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
            public List<ItemParamOuterClass.ItemParam> getUsedFlowerListList() {
                if (this.usedFlowerListBuilder_ == null) {
                    return Collections.unmodifiableList(this.usedFlowerList_);
                }
                return this.usedFlowerListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
            public int getUsedFlowerListCount() {
                if (this.usedFlowerListBuilder_ == null) {
                    return this.usedFlowerList_.size();
                }
                return this.usedFlowerListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
            public ItemParamOuterClass.ItemParam getUsedFlowerList(int index) {
                if (this.usedFlowerListBuilder_ == null) {
                    return this.usedFlowerList_.get(index);
                }
                return this.usedFlowerListBuilder_.getMessage(index);
            }

            public Builder setUsedFlowerList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.usedFlowerListBuilder_ != null) {
                    this.usedFlowerListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUsedFlowerListIsMutable();
                    this.usedFlowerList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUsedFlowerList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.usedFlowerListBuilder_ == null) {
                    ensureUsedFlowerListIsMutable();
                    this.usedFlowerList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.usedFlowerListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUsedFlowerList(ItemParamOuterClass.ItemParam value) {
                if (this.usedFlowerListBuilder_ != null) {
                    this.usedFlowerListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUsedFlowerListIsMutable();
                    this.usedFlowerList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUsedFlowerList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.usedFlowerListBuilder_ != null) {
                    this.usedFlowerListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUsedFlowerListIsMutable();
                    this.usedFlowerList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUsedFlowerList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.usedFlowerListBuilder_ == null) {
                    ensureUsedFlowerListIsMutable();
                    this.usedFlowerList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.usedFlowerListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUsedFlowerList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.usedFlowerListBuilder_ == null) {
                    ensureUsedFlowerListIsMutable();
                    this.usedFlowerList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.usedFlowerListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUsedFlowerList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.usedFlowerListBuilder_ == null) {
                    ensureUsedFlowerListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.usedFlowerList_);
                    onChanged();
                } else {
                    this.usedFlowerListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUsedFlowerList() {
                if (this.usedFlowerListBuilder_ == null) {
                    this.usedFlowerList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.usedFlowerListBuilder_.clear();
                }
                return this;
            }

            public Builder removeUsedFlowerList(int index) {
                if (this.usedFlowerListBuilder_ == null) {
                    ensureUsedFlowerListIsMutable();
                    this.usedFlowerList_.remove(index);
                    onChanged();
                } else {
                    this.usedFlowerListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getUsedFlowerListBuilder(int index) {
                return getUsedFlowerListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getUsedFlowerListOrBuilder(int index) {
                if (this.usedFlowerListBuilder_ == null) {
                    return this.usedFlowerList_.get(index);
                }
                return this.usedFlowerListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUsedFlowerListOrBuilderList() {
                if (this.usedFlowerListBuilder_ != null) {
                    return this.usedFlowerListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.usedFlowerList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addUsedFlowerListBuilder() {
                return getUsedFlowerListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addUsedFlowerListBuilder(int index) {
                return getUsedFlowerListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getUsedFlowerListBuilderList() {
                return getUsedFlowerListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getUsedFlowerListFieldBuilder() {
                if (this.usedFlowerListBuilder_ == null) {
                    this.usedFlowerListBuilder_ = new RepeatedFieldBuilderV3<>(this.usedFlowerList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.usedFlowerList_ = null;
                }
                return this.usedFlowerListBuilder_;
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

        public static IrodoriFlowerData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriFlowerData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriFlowerData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriFlowerData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemParamOuterClass.getDescriptor();
    }
}
