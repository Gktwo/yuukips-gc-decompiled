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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DropHintNotifyOuterClass.class */
public final class DropHintNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014DropHintNotify.proto\u001a\fVector.proto\"?\n\u000eDropHintNotify\u0012\u0019\n\bposition\u0018\t \u0001(\u000b2\u0007.Vector\u0012\u0012\n\nitemIdList\u0018\n \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DropHintNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DropHintNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DropHintNotify_descriptor, new String[]{"Position", "ItemIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DropHintNotifyOuterClass$DropHintNotifyOrBuilder.class */
    public interface DropHintNotifyOrBuilder extends MessageOrBuilder {
        boolean hasPosition();

        VectorOuterClass.Vector getPosition();

        VectorOuterClass.VectorOrBuilder getPositionOrBuilder();

        List<Integer> getItemIdListList();

        int getItemIdListCount();

        int getItemIdList(int i);
    }

    private DropHintNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DropHintNotifyOuterClass$DropHintNotify.class */
    public static final class DropHintNotify extends GeneratedMessageV3 implements DropHintNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int POSITION_FIELD_NUMBER = 9;
        private VectorOuterClass.Vector position_;
        public static final int ITEMIDLIST_FIELD_NUMBER = 10;
        private Internal.IntList itemIdList_;
        private int itemIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final DropHintNotify DEFAULT_INSTANCE = new DropHintNotify();
        private static final Parser<DropHintNotify> PARSER = new AbstractParser<DropHintNotify>() { // from class: emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotify.1
            @Override // com.google.protobuf.Parser
            public DropHintNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DropHintNotify(input, extensionRegistry);
            }
        };

        private DropHintNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.itemIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DropHintNotify() {
            this.itemIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.itemIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DropHintNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DropHintNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 74:
                                VectorOuterClass.Vector.Builder subBuilder = this.position_ != null ? this.position_.toBuilder() : null;
                                this.position_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.position_);
                                    this.position_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.itemIdList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.itemIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.itemIdList_.addInt(input.readUInt32());
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
                    this.itemIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DropHintNotifyOuterClass.internal_static_DropHintNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DropHintNotifyOuterClass.internal_static_DropHintNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DropHintNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
        public boolean hasPosition() {
            return this.position_ != null;
        }

        @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
        public VectorOuterClass.Vector getPosition() {
            return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
        }

        @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
            return getPosition();
        }

        @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
        public List<Integer> getItemIdListList() {
            return this.itemIdList_;
        }

        @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
        public int getItemIdListCount() {
            return this.itemIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
        public int getItemIdList(int index) {
            return this.itemIdList_.getInt(index);
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
            if (this.position_ != null) {
                output.writeMessage(9, getPosition());
            }
            if (getItemIdListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.itemIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.itemIdList_.size(); i++) {
                output.writeUInt32NoTag(this.itemIdList_.getInt(i));
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
            if (this.position_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(9, getPosition());
            }
            int dataSize = 0;
            for (int i = 0; i < this.itemIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.itemIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getItemIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.itemIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DropHintNotify)) {
                return equals(obj);
            }
            DropHintNotify other = (DropHintNotify) obj;
            if (hasPosition() != other.hasPosition()) {
                return false;
            }
            return (!hasPosition() || getPosition().equals(other.getPosition())) && getItemIdListList().equals(other.getItemIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasPosition()) {
                hash = (53 * ((37 * hash) + 9)) + getPosition().hashCode();
            }
            if (getItemIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getItemIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DropHintNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DropHintNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DropHintNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DropHintNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DropHintNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DropHintNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DropHintNotify parseFrom(InputStream input) throws IOException {
            return (DropHintNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DropHintNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DropHintNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DropHintNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (DropHintNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DropHintNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DropHintNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DropHintNotify parseFrom(CodedInputStream input) throws IOException {
            return (DropHintNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DropHintNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DropHintNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DropHintNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DropHintNotifyOuterClass$DropHintNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DropHintNotifyOrBuilder {
            private int bitField0_;
            private VectorOuterClass.Vector position_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> positionBuilder_;
            private Internal.IntList itemIdList_ = DropHintNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return DropHintNotifyOuterClass.internal_static_DropHintNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DropHintNotifyOuterClass.internal_static_DropHintNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DropHintNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DropHintNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.positionBuilder_ == null) {
                    this.position_ = null;
                } else {
                    this.position_ = null;
                    this.positionBuilder_ = null;
                }
                this.itemIdList_ = DropHintNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DropHintNotifyOuterClass.internal_static_DropHintNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DropHintNotify getDefaultInstanceForType() {
                return DropHintNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DropHintNotify build() {
                DropHintNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DropHintNotify buildPartial() {
                DropHintNotify result = new DropHintNotify(this);
                int i = this.bitField0_;
                if (this.positionBuilder_ == null) {
                    result.position_ = this.position_;
                } else {
                    result.position_ = this.positionBuilder_.build();
                }
                if ((this.bitField0_ & 1) != 0) {
                    this.itemIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.itemIdList_ = this.itemIdList_;
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
                if (other instanceof DropHintNotify) {
                    return mergeFrom((DropHintNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DropHintNotify other) {
                if (other == DropHintNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPosition()) {
                    mergePosition(other.getPosition());
                }
                if (!other.itemIdList_.isEmpty()) {
                    if (this.itemIdList_.isEmpty()) {
                        this.itemIdList_ = other.itemIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureItemIdListIsMutable();
                        this.itemIdList_.addAll(other.itemIdList_);
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
                DropHintNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = DropHintNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DropHintNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
            public boolean hasPosition() {
                return (this.positionBuilder_ == null && this.position_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
            public VectorOuterClass.Vector getPosition() {
                if (this.positionBuilder_ == null) {
                    return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
                }
                return this.positionBuilder_.getMessage();
            }

            public Builder setPosition(VectorOuterClass.Vector value) {
                if (this.positionBuilder_ != null) {
                    this.positionBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.position_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPosition(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.positionBuilder_ == null) {
                    this.position_ = builderForValue.build();
                    onChanged();
                } else {
                    this.positionBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePosition(VectorOuterClass.Vector value) {
                if (this.positionBuilder_ == null) {
                    if (this.position_ != null) {
                        this.position_ = VectorOuterClass.Vector.newBuilder(this.position_).mergeFrom(value).buildPartial();
                    } else {
                        this.position_ = value;
                    }
                    onChanged();
                } else {
                    this.positionBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPosition() {
                if (this.positionBuilder_ == null) {
                    this.position_ = null;
                    onChanged();
                } else {
                    this.position_ = null;
                    this.positionBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPositionBuilder() {
                onChanged();
                return getPositionFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
                if (this.positionBuilder_ != null) {
                    return this.positionBuilder_.getMessageOrBuilder();
                }
                return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPositionFieldBuilder() {
                if (this.positionBuilder_ == null) {
                    this.positionBuilder_ = new SingleFieldBuilderV3<>(getPosition(), getParentForChildren(), isClean());
                    this.position_ = null;
                }
                return this.positionBuilder_;
            }

            private void ensureItemIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemIdList_ = DropHintNotify.mutableCopy(this.itemIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
            public List<Integer> getItemIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.itemIdList_) : this.itemIdList_;
            }

            @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
            public int getItemIdListCount() {
                return this.itemIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.DropHintNotifyOuterClass.DropHintNotifyOrBuilder
            public int getItemIdList(int index) {
                return this.itemIdList_.getInt(index);
            }

            public Builder setItemIdList(int index, int value) {
                ensureItemIdListIsMutable();
                this.itemIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addItemIdList(int value) {
                ensureItemIdListIsMutable();
                this.itemIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllItemIdList(Iterable<? extends Integer> values) {
                ensureItemIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemIdList_);
                onChanged();
                return this;
            }

            public Builder clearItemIdList() {
                this.itemIdList_ = DropHintNotify.emptyIntList();
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

        public static DropHintNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DropHintNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DropHintNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DropHintNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
