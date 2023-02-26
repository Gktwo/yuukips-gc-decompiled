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
import emu.grasscutter.net.proto.HomeFurnitureDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureGroupDataOuterClass.class */
public final class HomeFurnitureGroupDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cHomeFurnitureGroupData.proto\u001a\u0017HomeFurnitureData.proto\"g\n\u0016HomeFurnitureGroupData\u00120\n\u0014virtualFurnitureList\u0018\f \u0003(\u000b2\u0012.HomeFurnitureData\u0012\u001b\n\u0013groupFurnitureIndex\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeFurnitureDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeFurnitureGroupData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeFurnitureGroupData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeFurnitureGroupData_descriptor, new String[]{"VirtualFurnitureList", "GroupFurnitureIndex"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureGroupDataOuterClass$HomeFurnitureGroupDataOrBuilder.class */
    public interface HomeFurnitureGroupDataOrBuilder extends MessageOrBuilder {
        List<HomeFurnitureDataOuterClass.HomeFurnitureData> getVirtualFurnitureListList();

        HomeFurnitureDataOuterClass.HomeFurnitureData getVirtualFurnitureList(int i);

        int getVirtualFurnitureListCount();

        List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getVirtualFurnitureListOrBuilderList();

        HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getVirtualFurnitureListOrBuilder(int i);

        int getGroupFurnitureIndex();
    }

    private HomeFurnitureGroupDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureGroupDataOuterClass$HomeFurnitureGroupData.class */
    public static final class HomeFurnitureGroupData extends GeneratedMessageV3 implements HomeFurnitureGroupDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int VIRTUALFURNITURELIST_FIELD_NUMBER = 12;
        private List<HomeFurnitureDataOuterClass.HomeFurnitureData> virtualFurnitureList_;
        public static final int GROUPFURNITUREINDEX_FIELD_NUMBER = 4;
        private int groupFurnitureIndex_;
        private byte memoizedIsInitialized;
        private static final HomeFurnitureGroupData DEFAULT_INSTANCE = new HomeFurnitureGroupData();
        private static final Parser<HomeFurnitureGroupData> PARSER = new AbstractParser<HomeFurnitureGroupData>() { // from class: emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.1
            @Override // com.google.protobuf.Parser
            public HomeFurnitureGroupData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeFurnitureGroupData(input, extensionRegistry);
            }
        };

        private HomeFurnitureGroupData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeFurnitureGroupData() {
            this.memoizedIsInitialized = -1;
            this.virtualFurnitureList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeFurnitureGroupData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeFurnitureGroupData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.groupFurnitureIndex_ = input.readUInt32();
                                    break;
                                case 98:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.virtualFurnitureList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.virtualFurnitureList_.add((HomeFurnitureDataOuterClass.HomeFurnitureData) input.readMessage(HomeFurnitureDataOuterClass.HomeFurnitureData.parser(), extensionRegistry));
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
                    this.virtualFurnitureList_ = Collections.unmodifiableList(this.virtualFurnitureList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeFurnitureGroupDataOuterClass.internal_static_HomeFurnitureGroupData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeFurnitureGroupDataOuterClass.internal_static_HomeFurnitureGroupData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeFurnitureGroupData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
        public List<HomeFurnitureDataOuterClass.HomeFurnitureData> getVirtualFurnitureListList() {
            return this.virtualFurnitureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
        public List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getVirtualFurnitureListOrBuilderList() {
            return this.virtualFurnitureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
        public int getVirtualFurnitureListCount() {
            return this.virtualFurnitureList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureData getVirtualFurnitureList(int index) {
            return this.virtualFurnitureList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getVirtualFurnitureListOrBuilder(int index) {
            return this.virtualFurnitureList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
        public int getGroupFurnitureIndex() {
            return this.groupFurnitureIndex_;
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
            if (this.groupFurnitureIndex_ != 0) {
                output.writeUInt32(4, this.groupFurnitureIndex_);
            }
            for (int i = 0; i < this.virtualFurnitureList_.size(); i++) {
                output.writeMessage(12, this.virtualFurnitureList_.get(i));
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
            if (this.groupFurnitureIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.groupFurnitureIndex_);
            }
            for (int i = 0; i < this.virtualFurnitureList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.virtualFurnitureList_.get(i));
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
            if (!(obj instanceof HomeFurnitureGroupData)) {
                return equals(obj);
            }
            HomeFurnitureGroupData other = (HomeFurnitureGroupData) obj;
            return getVirtualFurnitureListList().equals(other.getVirtualFurnitureListList()) && getGroupFurnitureIndex() == other.getGroupFurnitureIndex() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getVirtualFurnitureListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getVirtualFurnitureListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 4)) + getGroupFurnitureIndex())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeFurnitureGroupData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureGroupData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureGroupData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureGroupData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureGroupData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureGroupData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureGroupData parseFrom(InputStream input) throws IOException {
            return (HomeFurnitureGroupData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeFurnitureGroupData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureGroupData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeFurnitureGroupData parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeFurnitureGroupData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeFurnitureGroupData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureGroupData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeFurnitureGroupData parseFrom(CodedInputStream input) throws IOException {
            return (HomeFurnitureGroupData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeFurnitureGroupData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureGroupData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeFurnitureGroupData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureGroupDataOuterClass$HomeFurnitureGroupData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeFurnitureGroupDataOrBuilder {
            private int bitField0_;
            private List<HomeFurnitureDataOuterClass.HomeFurnitureData> virtualFurnitureList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> virtualFurnitureListBuilder_;
            private int groupFurnitureIndex_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeFurnitureGroupDataOuterClass.internal_static_HomeFurnitureGroupData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeFurnitureGroupDataOuterClass.internal_static_HomeFurnitureGroupData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeFurnitureGroupData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeFurnitureGroupData.alwaysUseFieldBuilders) {
                    getVirtualFurnitureListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.virtualFurnitureListBuilder_ == null) {
                    this.virtualFurnitureList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.virtualFurnitureListBuilder_.clear();
                }
                this.groupFurnitureIndex_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeFurnitureGroupDataOuterClass.internal_static_HomeFurnitureGroupData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeFurnitureGroupData getDefaultInstanceForType() {
                return HomeFurnitureGroupData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeFurnitureGroupData build() {
                HomeFurnitureGroupData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeFurnitureGroupData buildPartial() {
                HomeFurnitureGroupData result = new HomeFurnitureGroupData(this);
                int i = this.bitField0_;
                if (this.virtualFurnitureListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.virtualFurnitureList_ = Collections.unmodifiableList(this.virtualFurnitureList_);
                        this.bitField0_ &= -2;
                    }
                    result.virtualFurnitureList_ = this.virtualFurnitureList_;
                } else {
                    result.virtualFurnitureList_ = this.virtualFurnitureListBuilder_.build();
                }
                result.groupFurnitureIndex_ = this.groupFurnitureIndex_;
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
                if (other instanceof HomeFurnitureGroupData) {
                    return mergeFrom((HomeFurnitureGroupData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeFurnitureGroupData other) {
                if (other == HomeFurnitureGroupData.getDefaultInstance()) {
                    return this;
                }
                if (this.virtualFurnitureListBuilder_ == null) {
                    if (!other.virtualFurnitureList_.isEmpty()) {
                        if (this.virtualFurnitureList_.isEmpty()) {
                            this.virtualFurnitureList_ = other.virtualFurnitureList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureVirtualFurnitureListIsMutable();
                            this.virtualFurnitureList_.addAll(other.virtualFurnitureList_);
                        }
                        onChanged();
                    }
                } else if (!other.virtualFurnitureList_.isEmpty()) {
                    if (this.virtualFurnitureListBuilder_.isEmpty()) {
                        this.virtualFurnitureListBuilder_.dispose();
                        this.virtualFurnitureListBuilder_ = null;
                        this.virtualFurnitureList_ = other.virtualFurnitureList_;
                        this.bitField0_ &= -2;
                        this.virtualFurnitureListBuilder_ = HomeFurnitureGroupData.alwaysUseFieldBuilders ? getVirtualFurnitureListFieldBuilder() : null;
                    } else {
                        this.virtualFurnitureListBuilder_.addAllMessages(other.virtualFurnitureList_);
                    }
                }
                if (other.getGroupFurnitureIndex() != 0) {
                    setGroupFurnitureIndex(other.getGroupFurnitureIndex());
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
                HomeFurnitureGroupData parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeFurnitureGroupData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeFurnitureGroupData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureVirtualFurnitureListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.virtualFurnitureList_ = new ArrayList(this.virtualFurnitureList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
            public List<HomeFurnitureDataOuterClass.HomeFurnitureData> getVirtualFurnitureListList() {
                if (this.virtualFurnitureListBuilder_ == null) {
                    return Collections.unmodifiableList(this.virtualFurnitureList_);
                }
                return this.virtualFurnitureListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
            public int getVirtualFurnitureListCount() {
                if (this.virtualFurnitureListBuilder_ == null) {
                    return this.virtualFurnitureList_.size();
                }
                return this.virtualFurnitureListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureData getVirtualFurnitureList(int index) {
                if (this.virtualFurnitureListBuilder_ == null) {
                    return this.virtualFurnitureList_.get(index);
                }
                return this.virtualFurnitureListBuilder_.getMessage(index);
            }

            public Builder setVirtualFurnitureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.virtualFurnitureListBuilder_ != null) {
                    this.virtualFurnitureListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureVirtualFurnitureListIsMutable();
                    this.virtualFurnitureList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setVirtualFurnitureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.virtualFurnitureListBuilder_ == null) {
                    ensureVirtualFurnitureListIsMutable();
                    this.virtualFurnitureList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.virtualFurnitureListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addVirtualFurnitureList(HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.virtualFurnitureListBuilder_ != null) {
                    this.virtualFurnitureListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureVirtualFurnitureListIsMutable();
                    this.virtualFurnitureList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addVirtualFurnitureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.virtualFurnitureListBuilder_ != null) {
                    this.virtualFurnitureListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureVirtualFurnitureListIsMutable();
                    this.virtualFurnitureList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addVirtualFurnitureList(HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.virtualFurnitureListBuilder_ == null) {
                    ensureVirtualFurnitureListIsMutable();
                    this.virtualFurnitureList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.virtualFurnitureListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addVirtualFurnitureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.virtualFurnitureListBuilder_ == null) {
                    ensureVirtualFurnitureListIsMutable();
                    this.virtualFurnitureList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.virtualFurnitureListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllVirtualFurnitureList(Iterable<? extends HomeFurnitureDataOuterClass.HomeFurnitureData> values) {
                if (this.virtualFurnitureListBuilder_ == null) {
                    ensureVirtualFurnitureListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.virtualFurnitureList_);
                    onChanged();
                } else {
                    this.virtualFurnitureListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearVirtualFurnitureList() {
                if (this.virtualFurnitureListBuilder_ == null) {
                    this.virtualFurnitureList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.virtualFurnitureListBuilder_.clear();
                }
                return this;
            }

            public Builder removeVirtualFurnitureList(int index) {
                if (this.virtualFurnitureListBuilder_ == null) {
                    ensureVirtualFurnitureListIsMutable();
                    this.virtualFurnitureList_.remove(index);
                    onChanged();
                } else {
                    this.virtualFurnitureListBuilder_.remove(index);
                }
                return this;
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder getVirtualFurnitureListBuilder(int index) {
                return getVirtualFurnitureListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getVirtualFurnitureListOrBuilder(int index) {
                if (this.virtualFurnitureListBuilder_ == null) {
                    return this.virtualFurnitureList_.get(index);
                }
                return this.virtualFurnitureListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
            public List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getVirtualFurnitureListOrBuilderList() {
                if (this.virtualFurnitureListBuilder_ != null) {
                    return this.virtualFurnitureListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.virtualFurnitureList_);
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder addVirtualFurnitureListBuilder() {
                return getVirtualFurnitureListFieldBuilder().addBuilder(HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance());
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder addVirtualFurnitureListBuilder(int index) {
                return getVirtualFurnitureListFieldBuilder().addBuilder(index, HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance());
            }

            public List<HomeFurnitureDataOuterClass.HomeFurnitureData.Builder> getVirtualFurnitureListBuilderList() {
                return getVirtualFurnitureListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getVirtualFurnitureListFieldBuilder() {
                if (this.virtualFurnitureListBuilder_ == null) {
                    this.virtualFurnitureListBuilder_ = new RepeatedFieldBuilderV3<>(this.virtualFurnitureList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.virtualFurnitureList_ = null;
                }
                return this.virtualFurnitureListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder
            public int getGroupFurnitureIndex() {
                return this.groupFurnitureIndex_;
            }

            public Builder setGroupFurnitureIndex(int value) {
                this.groupFurnitureIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroupFurnitureIndex() {
                this.groupFurnitureIndex_ = 0;
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

        public static HomeFurnitureGroupData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeFurnitureGroupData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeFurnitureGroupData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeFurnitureGroupData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeFurnitureDataOuterClass.getDescriptor();
    }
}
