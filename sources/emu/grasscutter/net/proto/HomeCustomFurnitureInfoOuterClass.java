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
import emu.grasscutter.net.proto.CustomCommonNodeInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeCustomFurnitureInfoOuterClass.class */
public final class HomeCustomFurnitureInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dHomeCustomFurnitureInfo.proto\u001a\u001aCustomCommonNodeInfo.proto\"X\n\u0017HomeCustomFurnitureInfo\u0012\f\n\u0004guid\u0018\b \u0001(\r\u0012/\n\u0010subFurnitureList\u0018\u0005 \u0003(\u000b2\u0015.CustomCommonNodeInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CustomCommonNodeInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeCustomFurnitureInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeCustomFurnitureInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeCustomFurnitureInfo_descriptor, new String[]{"Guid", "SubFurnitureList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeCustomFurnitureInfoOuterClass$HomeCustomFurnitureInfoOrBuilder.class */
    public interface HomeCustomFurnitureInfoOrBuilder extends MessageOrBuilder {
        int getGuid();

        List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> getSubFurnitureListList();

        CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo getSubFurnitureList(int i);

        int getSubFurnitureListCount();

        List<? extends CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder> getSubFurnitureListOrBuilderList();

        CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder getSubFurnitureListOrBuilder(int i);
    }

    private HomeCustomFurnitureInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeCustomFurnitureInfoOuterClass$HomeCustomFurnitureInfo.class */
    public static final class HomeCustomFurnitureInfo extends GeneratedMessageV3 implements HomeCustomFurnitureInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GUID_FIELD_NUMBER = 8;
        private int guid_;
        public static final int SUBFURNITURELIST_FIELD_NUMBER = 5;
        private List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> subFurnitureList_;
        private byte memoizedIsInitialized;
        private static final HomeCustomFurnitureInfo DEFAULT_INSTANCE = new HomeCustomFurnitureInfo();
        private static final Parser<HomeCustomFurnitureInfo> PARSER = new AbstractParser<HomeCustomFurnitureInfo>() { // from class: emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.1
            @Override // com.google.protobuf.Parser
            public HomeCustomFurnitureInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeCustomFurnitureInfo(input, extensionRegistry);
            }
        };

        private HomeCustomFurnitureInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeCustomFurnitureInfo() {
            this.memoizedIsInitialized = -1;
            this.subFurnitureList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeCustomFurnitureInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeCustomFurnitureInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 42:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.subFurnitureList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.subFurnitureList_.add((CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo) input.readMessage(CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.parser(), extensionRegistry));
                                    break;
                                case 64:
                                    this.guid_ = input.readUInt32();
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
                    this.subFurnitureList_ = Collections.unmodifiableList(this.subFurnitureList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeCustomFurnitureInfoOuterClass.internal_static_HomeCustomFurnitureInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeCustomFurnitureInfoOuterClass.internal_static_HomeCustomFurnitureInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeCustomFurnitureInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
        public int getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
        public List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> getSubFurnitureListList() {
            return this.subFurnitureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
        public List<? extends CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder> getSubFurnitureListOrBuilderList() {
            return this.subFurnitureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
        public int getSubFurnitureListCount() {
            return this.subFurnitureList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
        public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo getSubFurnitureList(int index) {
            return this.subFurnitureList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
        public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder getSubFurnitureListOrBuilder(int index) {
            return this.subFurnitureList_.get(index);
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
            for (int i = 0; i < this.subFurnitureList_.size(); i++) {
                output.writeMessage(5, this.subFurnitureList_.get(i));
            }
            if (this.guid_ != 0) {
                output.writeUInt32(8, this.guid_);
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
            for (int i = 0; i < this.subFurnitureList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.subFurnitureList_.get(i));
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.guid_);
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
            if (!(obj instanceof HomeCustomFurnitureInfo)) {
                return equals(obj);
            }
            HomeCustomFurnitureInfo other = (HomeCustomFurnitureInfo) obj;
            return getGuid() == other.getGuid() && getSubFurnitureListList().equals(other.getSubFurnitureListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getGuid();
            if (getSubFurnitureListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getSubFurnitureListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeCustomFurnitureInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeCustomFurnitureInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeCustomFurnitureInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeCustomFurnitureInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeCustomFurnitureInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeCustomFurnitureInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeCustomFurnitureInfo parseFrom(InputStream input) throws IOException {
            return (HomeCustomFurnitureInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeCustomFurnitureInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeCustomFurnitureInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeCustomFurnitureInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeCustomFurnitureInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeCustomFurnitureInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeCustomFurnitureInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeCustomFurnitureInfo parseFrom(CodedInputStream input) throws IOException {
            return (HomeCustomFurnitureInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeCustomFurnitureInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeCustomFurnitureInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeCustomFurnitureInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeCustomFurnitureInfoOuterClass$HomeCustomFurnitureInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeCustomFurnitureInfoOrBuilder {
            private int bitField0_;
            private int guid_;
            private List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> subFurnitureList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder> subFurnitureListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeCustomFurnitureInfoOuterClass.internal_static_HomeCustomFurnitureInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeCustomFurnitureInfoOuterClass.internal_static_HomeCustomFurnitureInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeCustomFurnitureInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeCustomFurnitureInfo.alwaysUseFieldBuilders) {
                    getSubFurnitureListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.guid_ = 0;
                if (this.subFurnitureListBuilder_ == null) {
                    this.subFurnitureList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.subFurnitureListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeCustomFurnitureInfoOuterClass.internal_static_HomeCustomFurnitureInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeCustomFurnitureInfo getDefaultInstanceForType() {
                return HomeCustomFurnitureInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeCustomFurnitureInfo build() {
                HomeCustomFurnitureInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeCustomFurnitureInfo buildPartial() {
                HomeCustomFurnitureInfo result = new HomeCustomFurnitureInfo(this);
                int i = this.bitField0_;
                result.guid_ = this.guid_;
                if (this.subFurnitureListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.subFurnitureList_ = Collections.unmodifiableList(this.subFurnitureList_);
                        this.bitField0_ &= -2;
                    }
                    result.subFurnitureList_ = this.subFurnitureList_;
                } else {
                    result.subFurnitureList_ = this.subFurnitureListBuilder_.build();
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
                if (other instanceof HomeCustomFurnitureInfo) {
                    return mergeFrom((HomeCustomFurnitureInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeCustomFurnitureInfo other) {
                if (other == HomeCustomFurnitureInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (this.subFurnitureListBuilder_ == null) {
                    if (!other.subFurnitureList_.isEmpty()) {
                        if (this.subFurnitureList_.isEmpty()) {
                            this.subFurnitureList_ = other.subFurnitureList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSubFurnitureListIsMutable();
                            this.subFurnitureList_.addAll(other.subFurnitureList_);
                        }
                        onChanged();
                    }
                } else if (!other.subFurnitureList_.isEmpty()) {
                    if (this.subFurnitureListBuilder_.isEmpty()) {
                        this.subFurnitureListBuilder_.dispose();
                        this.subFurnitureListBuilder_ = null;
                        this.subFurnitureList_ = other.subFurnitureList_;
                        this.bitField0_ &= -2;
                        this.subFurnitureListBuilder_ = HomeCustomFurnitureInfo.alwaysUseFieldBuilders ? getSubFurnitureListFieldBuilder() : null;
                    } else {
                        this.subFurnitureListBuilder_.addAllMessages(other.subFurnitureList_);
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
                HomeCustomFurnitureInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeCustomFurnitureInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeCustomFurnitureInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
            public int getGuid() {
                return this.guid_;
            }

            public Builder setGuid(int value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            private void ensureSubFurnitureListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.subFurnitureList_ = new ArrayList(this.subFurnitureList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
            public List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> getSubFurnitureListList() {
                if (this.subFurnitureListBuilder_ == null) {
                    return Collections.unmodifiableList(this.subFurnitureList_);
                }
                return this.subFurnitureListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
            public int getSubFurnitureListCount() {
                if (this.subFurnitureListBuilder_ == null) {
                    return this.subFurnitureList_.size();
                }
                return this.subFurnitureListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
            public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo getSubFurnitureList(int index) {
                if (this.subFurnitureListBuilder_ == null) {
                    return this.subFurnitureList_.get(index);
                }
                return this.subFurnitureListBuilder_.getMessage(index);
            }

            public Builder setSubFurnitureList(int index, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo value) {
                if (this.subFurnitureListBuilder_ != null) {
                    this.subFurnitureListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSubFurnitureListIsMutable();
                    this.subFurnitureList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSubFurnitureList(int index, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder builderForValue) {
                if (this.subFurnitureListBuilder_ == null) {
                    ensureSubFurnitureListIsMutable();
                    this.subFurnitureList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.subFurnitureListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSubFurnitureList(CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo value) {
                if (this.subFurnitureListBuilder_ != null) {
                    this.subFurnitureListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSubFurnitureListIsMutable();
                    this.subFurnitureList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSubFurnitureList(int index, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo value) {
                if (this.subFurnitureListBuilder_ != null) {
                    this.subFurnitureListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSubFurnitureListIsMutable();
                    this.subFurnitureList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSubFurnitureList(CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder builderForValue) {
                if (this.subFurnitureListBuilder_ == null) {
                    ensureSubFurnitureListIsMutable();
                    this.subFurnitureList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.subFurnitureListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSubFurnitureList(int index, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder builderForValue) {
                if (this.subFurnitureListBuilder_ == null) {
                    ensureSubFurnitureListIsMutable();
                    this.subFurnitureList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.subFurnitureListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSubFurnitureList(Iterable<? extends CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> values) {
                if (this.subFurnitureListBuilder_ == null) {
                    ensureSubFurnitureListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.subFurnitureList_);
                    onChanged();
                } else {
                    this.subFurnitureListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSubFurnitureList() {
                if (this.subFurnitureListBuilder_ == null) {
                    this.subFurnitureList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.subFurnitureListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSubFurnitureList(int index) {
                if (this.subFurnitureListBuilder_ == null) {
                    ensureSubFurnitureListIsMutable();
                    this.subFurnitureList_.remove(index);
                    onChanged();
                } else {
                    this.subFurnitureListBuilder_.remove(index);
                }
                return this;
            }

            public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder getSubFurnitureListBuilder(int index) {
                return getSubFurnitureListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
            public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder getSubFurnitureListOrBuilder(int index) {
                if (this.subFurnitureListBuilder_ == null) {
                    return this.subFurnitureList_.get(index);
                }
                return this.subFurnitureListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder
            public List<? extends CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder> getSubFurnitureListOrBuilderList() {
                if (this.subFurnitureListBuilder_ != null) {
                    return this.subFurnitureListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.subFurnitureList_);
            }

            public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder addSubFurnitureListBuilder() {
                return getSubFurnitureListFieldBuilder().addBuilder(CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.getDefaultInstance());
            }

            public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder addSubFurnitureListBuilder(int index) {
                return getSubFurnitureListFieldBuilder().addBuilder(index, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.getDefaultInstance());
            }

            public List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder> getSubFurnitureListBuilderList() {
                return getSubFurnitureListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder> getSubFurnitureListFieldBuilder() {
                if (this.subFurnitureListBuilder_ == null) {
                    this.subFurnitureListBuilder_ = new RepeatedFieldBuilderV3<>(this.subFurnitureList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.subFurnitureList_ = null;
                }
                return this.subFurnitureListBuilder_;
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

        public static HomeCustomFurnitureInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeCustomFurnitureInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeCustomFurnitureInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeCustomFurnitureInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CustomCommonNodeInfoOuterClass.getDescriptor();
    }
}
