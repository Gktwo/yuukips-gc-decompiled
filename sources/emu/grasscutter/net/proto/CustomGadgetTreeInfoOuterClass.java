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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomGadgetTreeInfoOuterClass.class */
public final class CustomGadgetTreeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aCustomGadgetTreeInfo.proto\u001a\u001aCustomCommonNodeInfo.proto\"@\n\u0014CustomGadgetTreeInfo\u0012(\n\tnode_list\u0018\u0001 \u0003(\u000b2\u0015.CustomCommonNodeInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CustomCommonNodeInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CustomGadgetTreeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CustomGadgetTreeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CustomGadgetTreeInfo_descriptor, new String[]{"NodeList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomGadgetTreeInfoOuterClass$CustomGadgetTreeInfoOrBuilder.class */
    public interface CustomGadgetTreeInfoOrBuilder extends MessageOrBuilder {
        List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> getNodeListList();

        CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo getNodeList(int i);

        int getNodeListCount();

        List<? extends CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder> getNodeListOrBuilderList();

        CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder getNodeListOrBuilder(int i);
    }

    private CustomGadgetTreeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomGadgetTreeInfoOuterClass$CustomGadgetTreeInfo.class */
    public static final class CustomGadgetTreeInfo extends GeneratedMessageV3 implements CustomGadgetTreeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NODE_LIST_FIELD_NUMBER = 1;
        private List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> nodeList_;
        private byte memoizedIsInitialized;
        private static final CustomGadgetTreeInfo DEFAULT_INSTANCE = new CustomGadgetTreeInfo();
        private static final Parser<CustomGadgetTreeInfo> PARSER = new AbstractParser<CustomGadgetTreeInfo>() { // from class: emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.1
            @Override // com.google.protobuf.Parser
            public CustomGadgetTreeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CustomGadgetTreeInfo(input, extensionRegistry);
            }
        };

        private CustomGadgetTreeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CustomGadgetTreeInfo() {
            this.memoizedIsInitialized = -1;
            this.nodeList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CustomGadgetTreeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CustomGadgetTreeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.nodeList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.nodeList_.add((CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo) input.readMessage(CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.parser(), extensionRegistry));
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
                    this.nodeList_ = Collections.unmodifiableList(this.nodeList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CustomGadgetTreeInfoOuterClass.internal_static_CustomGadgetTreeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CustomGadgetTreeInfoOuterClass.internal_static_CustomGadgetTreeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomGadgetTreeInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder
        public List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> getNodeListList() {
            return this.nodeList_;
        }

        @Override // emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder
        public List<? extends CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder> getNodeListOrBuilderList() {
            return this.nodeList_;
        }

        @Override // emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder
        public int getNodeListCount() {
            return this.nodeList_.size();
        }

        @Override // emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder
        public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo getNodeList(int index) {
            return this.nodeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder
        public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder getNodeListOrBuilder(int index) {
            return this.nodeList_.get(index);
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
            for (int i = 0; i < this.nodeList_.size(); i++) {
                output.writeMessage(1, this.nodeList_.get(i));
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
            for (int i = 0; i < this.nodeList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.nodeList_.get(i));
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
            if (!(obj instanceof CustomGadgetTreeInfo)) {
                return equals(obj);
            }
            CustomGadgetTreeInfo other = (CustomGadgetTreeInfo) obj;
            return getNodeListList().equals(other.getNodeListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getNodeListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getNodeListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CustomGadgetTreeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CustomGadgetTreeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CustomGadgetTreeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CustomGadgetTreeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CustomGadgetTreeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CustomGadgetTreeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CustomGadgetTreeInfo parseFrom(InputStream input) throws IOException {
            return (CustomGadgetTreeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CustomGadgetTreeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CustomGadgetTreeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CustomGadgetTreeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CustomGadgetTreeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CustomGadgetTreeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CustomGadgetTreeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CustomGadgetTreeInfo parseFrom(CodedInputStream input) throws IOException {
            return (CustomGadgetTreeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CustomGadgetTreeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CustomGadgetTreeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CustomGadgetTreeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomGadgetTreeInfoOuterClass$CustomGadgetTreeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CustomGadgetTreeInfoOrBuilder {
            private int bitField0_;
            private List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> nodeList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder> nodeListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CustomGadgetTreeInfoOuterClass.internal_static_CustomGadgetTreeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CustomGadgetTreeInfoOuterClass.internal_static_CustomGadgetTreeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomGadgetTreeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CustomGadgetTreeInfo.alwaysUseFieldBuilders) {
                    getNodeListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.nodeListBuilder_ == null) {
                    this.nodeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.nodeListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CustomGadgetTreeInfoOuterClass.internal_static_CustomGadgetTreeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CustomGadgetTreeInfo getDefaultInstanceForType() {
                return CustomGadgetTreeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CustomGadgetTreeInfo build() {
                CustomGadgetTreeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CustomGadgetTreeInfo buildPartial() {
                CustomGadgetTreeInfo result = new CustomGadgetTreeInfo(this);
                int i = this.bitField0_;
                if (this.nodeListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.nodeList_ = Collections.unmodifiableList(this.nodeList_);
                        this.bitField0_ &= -2;
                    }
                    result.nodeList_ = this.nodeList_;
                } else {
                    result.nodeList_ = this.nodeListBuilder_.build();
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
                if (other instanceof CustomGadgetTreeInfo) {
                    return mergeFrom((CustomGadgetTreeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CustomGadgetTreeInfo other) {
                if (other == CustomGadgetTreeInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.nodeListBuilder_ == null) {
                    if (!other.nodeList_.isEmpty()) {
                        if (this.nodeList_.isEmpty()) {
                            this.nodeList_ = other.nodeList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureNodeListIsMutable();
                            this.nodeList_.addAll(other.nodeList_);
                        }
                        onChanged();
                    }
                } else if (!other.nodeList_.isEmpty()) {
                    if (this.nodeListBuilder_.isEmpty()) {
                        this.nodeListBuilder_.dispose();
                        this.nodeListBuilder_ = null;
                        this.nodeList_ = other.nodeList_;
                        this.bitField0_ &= -2;
                        this.nodeListBuilder_ = CustomGadgetTreeInfo.alwaysUseFieldBuilders ? getNodeListFieldBuilder() : null;
                    } else {
                        this.nodeListBuilder_.addAllMessages(other.nodeList_);
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
                CustomGadgetTreeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CustomGadgetTreeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CustomGadgetTreeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureNodeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.nodeList_ = new ArrayList(this.nodeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder
            public List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> getNodeListList() {
                if (this.nodeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.nodeList_);
                }
                return this.nodeListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder
            public int getNodeListCount() {
                if (this.nodeListBuilder_ == null) {
                    return this.nodeList_.size();
                }
                return this.nodeListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder
            public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo getNodeList(int index) {
                if (this.nodeListBuilder_ == null) {
                    return this.nodeList_.get(index);
                }
                return this.nodeListBuilder_.getMessage(index);
            }

            public Builder setNodeList(int index, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo value) {
                if (this.nodeListBuilder_ != null) {
                    this.nodeListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNodeListIsMutable();
                    this.nodeList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setNodeList(int index, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder builderForValue) {
                if (this.nodeListBuilder_ == null) {
                    ensureNodeListIsMutable();
                    this.nodeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nodeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addNodeList(CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo value) {
                if (this.nodeListBuilder_ != null) {
                    this.nodeListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNodeListIsMutable();
                    this.nodeList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addNodeList(int index, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo value) {
                if (this.nodeListBuilder_ != null) {
                    this.nodeListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNodeListIsMutable();
                    this.nodeList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addNodeList(CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder builderForValue) {
                if (this.nodeListBuilder_ == null) {
                    ensureNodeListIsMutable();
                    this.nodeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nodeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addNodeList(int index, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder builderForValue) {
                if (this.nodeListBuilder_ == null) {
                    ensureNodeListIsMutable();
                    this.nodeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nodeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllNodeList(Iterable<? extends CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo> values) {
                if (this.nodeListBuilder_ == null) {
                    ensureNodeListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.nodeList_);
                    onChanged();
                } else {
                    this.nodeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNodeList() {
                if (this.nodeListBuilder_ == null) {
                    this.nodeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.nodeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeNodeList(int index) {
                if (this.nodeListBuilder_ == null) {
                    ensureNodeListIsMutable();
                    this.nodeList_.remove(index);
                    onChanged();
                } else {
                    this.nodeListBuilder_.remove(index);
                }
                return this;
            }

            public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder getNodeListBuilder(int index) {
                return getNodeListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder
            public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder getNodeListOrBuilder(int index) {
                if (this.nodeListBuilder_ == null) {
                    return this.nodeList_.get(index);
                }
                return this.nodeListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder
            public List<? extends CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder> getNodeListOrBuilderList() {
                if (this.nodeListBuilder_ != null) {
                    return this.nodeListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.nodeList_);
            }

            public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder addNodeListBuilder() {
                return getNodeListFieldBuilder().addBuilder(CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.getDefaultInstance());
            }

            public CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder addNodeListBuilder(int index) {
                return getNodeListFieldBuilder().addBuilder(index, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.getDefaultInstance());
            }

            public List<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder> getNodeListBuilderList() {
                return getNodeListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.Builder, CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder> getNodeListFieldBuilder() {
                if (this.nodeListBuilder_ == null) {
                    this.nodeListBuilder_ = new RepeatedFieldBuilderV3<>(this.nodeList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.nodeList_ = null;
                }
                return this.nodeListBuilder_;
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

        public static CustomGadgetTreeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CustomGadgetTreeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CustomGadgetTreeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CustomGadgetTreeInfo getDefaultInstanceForType() {
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
