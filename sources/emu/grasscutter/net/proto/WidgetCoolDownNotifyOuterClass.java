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
import emu.grasscutter.net.proto.WidgetCoolDownDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCoolDownNotifyOuterClass.class */
public final class WidgetCoolDownNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aWidgetCoolDownNotify.proto\u001a\u0018WidgetCoolDownData.proto\"\u0001\n\u0014WidgetCoolDownNotify\u00127\n\u001anormal_cool_down_data_list\u0018\u0002 \u0003(\u000b2\u0013.WidgetCoolDownData\u00126\n\u0019group_cool_down_data_list\u0018\u000e \u0003(\u000b2\u0013.WidgetCoolDownDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WidgetCoolDownDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WidgetCoolDownNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WidgetCoolDownNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WidgetCoolDownNotify_descriptor, new String[]{"NormalCoolDownDataList", "GroupCoolDownDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCoolDownNotifyOuterClass$WidgetCoolDownNotifyOrBuilder.class */
    public interface WidgetCoolDownNotifyOrBuilder extends MessageOrBuilder {
        List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getNormalCoolDownDataListList();

        WidgetCoolDownDataOuterClass.WidgetCoolDownData getNormalCoolDownDataList(int i);

        int getNormalCoolDownDataListCount();

        List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getNormalCoolDownDataListOrBuilderList();

        WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getNormalCoolDownDataListOrBuilder(int i);

        List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getGroupCoolDownDataListList();

        WidgetCoolDownDataOuterClass.WidgetCoolDownData getGroupCoolDownDataList(int i);

        int getGroupCoolDownDataListCount();

        List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getGroupCoolDownDataListOrBuilderList();

        WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getGroupCoolDownDataListOrBuilder(int i);
    }

    private WidgetCoolDownNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCoolDownNotifyOuterClass$WidgetCoolDownNotify.class */
    public static final class WidgetCoolDownNotify extends GeneratedMessageV3 implements WidgetCoolDownNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NORMAL_COOL_DOWN_DATA_LIST_FIELD_NUMBER = 2;
        private List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> normalCoolDownDataList_;
        public static final int GROUP_COOL_DOWN_DATA_LIST_FIELD_NUMBER = 14;
        private List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> groupCoolDownDataList_;
        private byte memoizedIsInitialized;
        private static final WidgetCoolDownNotify DEFAULT_INSTANCE = new WidgetCoolDownNotify();
        private static final Parser<WidgetCoolDownNotify> PARSER = new AbstractParser<WidgetCoolDownNotify>() { // from class: emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotify.1
            @Override // com.google.protobuf.Parser
            public WidgetCoolDownNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WidgetCoolDownNotify(input, extensionRegistry);
            }
        };

        private WidgetCoolDownNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WidgetCoolDownNotify() {
            this.memoizedIsInitialized = -1;
            this.normalCoolDownDataList_ = Collections.emptyList();
            this.groupCoolDownDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WidgetCoolDownNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x00b8 */
        private WidgetCoolDownNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.normalCoolDownDataList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.normalCoolDownDataList_.add((WidgetCoolDownDataOuterClass.WidgetCoolDownData) input.readMessage(WidgetCoolDownDataOuterClass.WidgetCoolDownData.parser(), extensionRegistry));
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.groupCoolDownDataList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.groupCoolDownDataList_.add((WidgetCoolDownDataOuterClass.WidgetCoolDownData) input.readMessage(WidgetCoolDownDataOuterClass.WidgetCoolDownData.parser(), extensionRegistry));
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
                    this.normalCoolDownDataList_ = Collections.unmodifiableList(this.normalCoolDownDataList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.groupCoolDownDataList_ = Collections.unmodifiableList(this.groupCoolDownDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WidgetCoolDownNotifyOuterClass.internal_static_WidgetCoolDownNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WidgetCoolDownNotifyOuterClass.internal_static_WidgetCoolDownNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetCoolDownNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
        public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getNormalCoolDownDataListList() {
            return this.normalCoolDownDataList_;
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
        public List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getNormalCoolDownDataListOrBuilderList() {
            return this.normalCoolDownDataList_;
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
        public int getNormalCoolDownDataListCount() {
            return this.normalCoolDownDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
        public WidgetCoolDownDataOuterClass.WidgetCoolDownData getNormalCoolDownDataList(int index) {
            return this.normalCoolDownDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
        public WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getNormalCoolDownDataListOrBuilder(int index) {
            return this.normalCoolDownDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
        public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getGroupCoolDownDataListList() {
            return this.groupCoolDownDataList_;
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
        public List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getGroupCoolDownDataListOrBuilderList() {
            return this.groupCoolDownDataList_;
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
        public int getGroupCoolDownDataListCount() {
            return this.groupCoolDownDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
        public WidgetCoolDownDataOuterClass.WidgetCoolDownData getGroupCoolDownDataList(int index) {
            return this.groupCoolDownDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
        public WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getGroupCoolDownDataListOrBuilder(int index) {
            return this.groupCoolDownDataList_.get(index);
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
            for (int i = 0; i < this.normalCoolDownDataList_.size(); i++) {
                output.writeMessage(2, this.normalCoolDownDataList_.get(i));
            }
            for (int i2 = 0; i2 < this.groupCoolDownDataList_.size(); i2++) {
                output.writeMessage(14, this.groupCoolDownDataList_.get(i2));
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
            for (int i = 0; i < this.normalCoolDownDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.normalCoolDownDataList_.get(i));
            }
            for (int i2 = 0; i2 < this.groupCoolDownDataList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.groupCoolDownDataList_.get(i2));
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
            if (!(obj instanceof WidgetCoolDownNotify)) {
                return equals(obj);
            }
            WidgetCoolDownNotify other = (WidgetCoolDownNotify) obj;
            return getNormalCoolDownDataListList().equals(other.getNormalCoolDownDataListList()) && getGroupCoolDownDataListList().equals(other.getGroupCoolDownDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getNormalCoolDownDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getNormalCoolDownDataListList().hashCode();
            }
            if (getGroupCoolDownDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getGroupCoolDownDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WidgetCoolDownNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetCoolDownNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetCoolDownNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetCoolDownNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetCoolDownNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetCoolDownNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetCoolDownNotify parseFrom(InputStream input) throws IOException {
            return (WidgetCoolDownNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetCoolDownNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetCoolDownNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetCoolDownNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WidgetCoolDownNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WidgetCoolDownNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetCoolDownNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetCoolDownNotify parseFrom(CodedInputStream input) throws IOException {
            return (WidgetCoolDownNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetCoolDownNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetCoolDownNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WidgetCoolDownNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCoolDownNotifyOuterClass$WidgetCoolDownNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WidgetCoolDownNotifyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<WidgetCoolDownDataOuterClass.WidgetCoolDownData, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder, WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> normalCoolDownDataListBuilder_;
            private RepeatedFieldBuilderV3<WidgetCoolDownDataOuterClass.WidgetCoolDownData, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder, WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> groupCoolDownDataListBuilder_;
            private List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> normalCoolDownDataList_ = Collections.emptyList();
            private List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> groupCoolDownDataList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return WidgetCoolDownNotifyOuterClass.internal_static_WidgetCoolDownNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WidgetCoolDownNotifyOuterClass.internal_static_WidgetCoolDownNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetCoolDownNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WidgetCoolDownNotify.alwaysUseFieldBuilders) {
                    getNormalCoolDownDataListFieldBuilder();
                    getGroupCoolDownDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.normalCoolDownDataListBuilder_ == null) {
                    this.normalCoolDownDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.normalCoolDownDataListBuilder_.clear();
                }
                if (this.groupCoolDownDataListBuilder_ == null) {
                    this.groupCoolDownDataList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.groupCoolDownDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WidgetCoolDownNotifyOuterClass.internal_static_WidgetCoolDownNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WidgetCoolDownNotify getDefaultInstanceForType() {
                return WidgetCoolDownNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetCoolDownNotify build() {
                WidgetCoolDownNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetCoolDownNotify buildPartial() {
                WidgetCoolDownNotify result = new WidgetCoolDownNotify(this);
                int i = this.bitField0_;
                if (this.normalCoolDownDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.normalCoolDownDataList_ = Collections.unmodifiableList(this.normalCoolDownDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.normalCoolDownDataList_ = this.normalCoolDownDataList_;
                } else {
                    result.normalCoolDownDataList_ = this.normalCoolDownDataListBuilder_.build();
                }
                if (this.groupCoolDownDataListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.groupCoolDownDataList_ = Collections.unmodifiableList(this.groupCoolDownDataList_);
                        this.bitField0_ &= -3;
                    }
                    result.groupCoolDownDataList_ = this.groupCoolDownDataList_;
                } else {
                    result.groupCoolDownDataList_ = this.groupCoolDownDataListBuilder_.build();
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
                if (other instanceof WidgetCoolDownNotify) {
                    return mergeFrom((WidgetCoolDownNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WidgetCoolDownNotify other) {
                if (other == WidgetCoolDownNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.normalCoolDownDataListBuilder_ == null) {
                    if (!other.normalCoolDownDataList_.isEmpty()) {
                        if (this.normalCoolDownDataList_.isEmpty()) {
                            this.normalCoolDownDataList_ = other.normalCoolDownDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureNormalCoolDownDataListIsMutable();
                            this.normalCoolDownDataList_.addAll(other.normalCoolDownDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.normalCoolDownDataList_.isEmpty()) {
                    if (this.normalCoolDownDataListBuilder_.isEmpty()) {
                        this.normalCoolDownDataListBuilder_.dispose();
                        this.normalCoolDownDataListBuilder_ = null;
                        this.normalCoolDownDataList_ = other.normalCoolDownDataList_;
                        this.bitField0_ &= -2;
                        this.normalCoolDownDataListBuilder_ = WidgetCoolDownNotify.alwaysUseFieldBuilders ? getNormalCoolDownDataListFieldBuilder() : null;
                    } else {
                        this.normalCoolDownDataListBuilder_.addAllMessages(other.normalCoolDownDataList_);
                    }
                }
                if (this.groupCoolDownDataListBuilder_ == null) {
                    if (!other.groupCoolDownDataList_.isEmpty()) {
                        if (this.groupCoolDownDataList_.isEmpty()) {
                            this.groupCoolDownDataList_ = other.groupCoolDownDataList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureGroupCoolDownDataListIsMutable();
                            this.groupCoolDownDataList_.addAll(other.groupCoolDownDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.groupCoolDownDataList_.isEmpty()) {
                    if (this.groupCoolDownDataListBuilder_.isEmpty()) {
                        this.groupCoolDownDataListBuilder_.dispose();
                        this.groupCoolDownDataListBuilder_ = null;
                        this.groupCoolDownDataList_ = other.groupCoolDownDataList_;
                        this.bitField0_ &= -3;
                        this.groupCoolDownDataListBuilder_ = WidgetCoolDownNotify.alwaysUseFieldBuilders ? getGroupCoolDownDataListFieldBuilder() : null;
                    } else {
                        this.groupCoolDownDataListBuilder_.addAllMessages(other.groupCoolDownDataList_);
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
                WidgetCoolDownNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WidgetCoolDownNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WidgetCoolDownNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureNormalCoolDownDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.normalCoolDownDataList_ = new ArrayList(this.normalCoolDownDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
            public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getNormalCoolDownDataListList() {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.normalCoolDownDataList_);
                }
                return this.normalCoolDownDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
            public int getNormalCoolDownDataListCount() {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    return this.normalCoolDownDataList_.size();
                }
                return this.normalCoolDownDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
            public WidgetCoolDownDataOuterClass.WidgetCoolDownData getNormalCoolDownDataList(int index) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    return this.normalCoolDownDataList_.get(index);
                }
                return this.normalCoolDownDataListBuilder_.getMessage(index);
            }

            public Builder setNormalCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.normalCoolDownDataListBuilder_ != null) {
                    this.normalCoolDownDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setNormalCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addNormalCoolDownDataList(WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.normalCoolDownDataListBuilder_ != null) {
                    this.normalCoolDownDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addNormalCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.normalCoolDownDataListBuilder_ != null) {
                    this.normalCoolDownDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addNormalCoolDownDataList(WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addNormalCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllNormalCoolDownDataList(Iterable<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownData> values) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    ensureNormalCoolDownDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.normalCoolDownDataList_);
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNormalCoolDownDataList() {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    this.normalCoolDownDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeNormalCoolDownDataList(int index) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.remove(index);
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.remove(index);
                }
                return this;
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder getNormalCoolDownDataListBuilder(int index) {
                return getNormalCoolDownDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
            public WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getNormalCoolDownDataListOrBuilder(int index) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    return this.normalCoolDownDataList_.get(index);
                }
                return this.normalCoolDownDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
            public List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getNormalCoolDownDataListOrBuilderList() {
                if (this.normalCoolDownDataListBuilder_ != null) {
                    return this.normalCoolDownDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.normalCoolDownDataList_);
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder addNormalCoolDownDataListBuilder() {
                return getNormalCoolDownDataListFieldBuilder().addBuilder(WidgetCoolDownDataOuterClass.WidgetCoolDownData.getDefaultInstance());
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder addNormalCoolDownDataListBuilder(int index) {
                return getNormalCoolDownDataListFieldBuilder().addBuilder(index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.getDefaultInstance());
            }

            public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder> getNormalCoolDownDataListBuilderList() {
                return getNormalCoolDownDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WidgetCoolDownDataOuterClass.WidgetCoolDownData, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder, WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getNormalCoolDownDataListFieldBuilder() {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    this.normalCoolDownDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.normalCoolDownDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.normalCoolDownDataList_ = null;
                }
                return this.normalCoolDownDataListBuilder_;
            }

            private void ensureGroupCoolDownDataListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.groupCoolDownDataList_ = new ArrayList(this.groupCoolDownDataList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
            public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getGroupCoolDownDataListList() {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.groupCoolDownDataList_);
                }
                return this.groupCoolDownDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
            public int getGroupCoolDownDataListCount() {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    return this.groupCoolDownDataList_.size();
                }
                return this.groupCoolDownDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
            public WidgetCoolDownDataOuterClass.WidgetCoolDownData getGroupCoolDownDataList(int index) {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    return this.groupCoolDownDataList_.get(index);
                }
                return this.groupCoolDownDataListBuilder_.getMessage(index);
            }

            public Builder setGroupCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.groupCoolDownDataListBuilder_ != null) {
                    this.groupCoolDownDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGroupCoolDownDataListIsMutable();
                    this.groupCoolDownDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setGroupCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    ensureGroupCoolDownDataListIsMutable();
                    this.groupCoolDownDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.groupCoolDownDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addGroupCoolDownDataList(WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.groupCoolDownDataListBuilder_ != null) {
                    this.groupCoolDownDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGroupCoolDownDataListIsMutable();
                    this.groupCoolDownDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addGroupCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.groupCoolDownDataListBuilder_ != null) {
                    this.groupCoolDownDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGroupCoolDownDataListIsMutable();
                    this.groupCoolDownDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addGroupCoolDownDataList(WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    ensureGroupCoolDownDataListIsMutable();
                    this.groupCoolDownDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.groupCoolDownDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addGroupCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    ensureGroupCoolDownDataListIsMutable();
                    this.groupCoolDownDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.groupCoolDownDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllGroupCoolDownDataList(Iterable<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownData> values) {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    ensureGroupCoolDownDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.groupCoolDownDataList_);
                    onChanged();
                } else {
                    this.groupCoolDownDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearGroupCoolDownDataList() {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    this.groupCoolDownDataList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.groupCoolDownDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeGroupCoolDownDataList(int index) {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    ensureGroupCoolDownDataListIsMutable();
                    this.groupCoolDownDataList_.remove(index);
                    onChanged();
                } else {
                    this.groupCoolDownDataListBuilder_.remove(index);
                }
                return this;
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder getGroupCoolDownDataListBuilder(int index) {
                return getGroupCoolDownDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
            public WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getGroupCoolDownDataListOrBuilder(int index) {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    return this.groupCoolDownDataList_.get(index);
                }
                return this.groupCoolDownDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotifyOrBuilder
            public List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getGroupCoolDownDataListOrBuilderList() {
                if (this.groupCoolDownDataListBuilder_ != null) {
                    return this.groupCoolDownDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.groupCoolDownDataList_);
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder addGroupCoolDownDataListBuilder() {
                return getGroupCoolDownDataListFieldBuilder().addBuilder(WidgetCoolDownDataOuterClass.WidgetCoolDownData.getDefaultInstance());
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder addGroupCoolDownDataListBuilder(int index) {
                return getGroupCoolDownDataListFieldBuilder().addBuilder(index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.getDefaultInstance());
            }

            public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder> getGroupCoolDownDataListBuilderList() {
                return getGroupCoolDownDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WidgetCoolDownDataOuterClass.WidgetCoolDownData, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder, WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getGroupCoolDownDataListFieldBuilder() {
                if (this.groupCoolDownDataListBuilder_ == null) {
                    this.groupCoolDownDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.groupCoolDownDataList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.groupCoolDownDataList_ = null;
                }
                return this.groupCoolDownDataListBuilder_;
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

        public static WidgetCoolDownNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WidgetCoolDownNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WidgetCoolDownNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WidgetCoolDownNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WidgetCoolDownDataOuterClass.getDescriptor();
    }
}
