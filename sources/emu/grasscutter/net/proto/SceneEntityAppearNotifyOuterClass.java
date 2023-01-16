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
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.VisionTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAppearNotifyOuterClass.class */
public final class SceneEntityAppearNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dSceneEntityAppearNotify.proto\u001a\u0015SceneEntityInfo.proto\u001a\u0010VisionType.proto\"q\n\u0017SceneEntityAppearNotify\u0012%\n\u000bentity_list\u0018\u000f \u0003(\u000b2\u0010.SceneEntityInfo\u0012 \n\u000bappear_type\u0018\u0001 \u0001(\u000e2\u000b.VisionType\u0012\r\n\u0005param\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SceneEntityInfoOuterClass.getDescriptor(), VisionTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneEntityAppearNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneEntityAppearNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneEntityAppearNotify_descriptor, new String[]{"EntityList", "AppearType", "Param"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAppearNotifyOuterClass$SceneEntityAppearNotifyOrBuilder.class */
    public interface SceneEntityAppearNotifyOrBuilder extends MessageOrBuilder {
        List<SceneEntityInfoOuterClass.SceneEntityInfo> getEntityListList();

        SceneEntityInfoOuterClass.SceneEntityInfo getEntityList(int i);

        int getEntityListCount();

        List<? extends SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder> getEntityListOrBuilderList();

        SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder getEntityListOrBuilder(int i);

        int getAppearTypeValue();

        VisionTypeOuterClass.VisionType getAppearType();

        int getParam();
    }

    private SceneEntityAppearNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAppearNotifyOuterClass$SceneEntityAppearNotify.class */
    public static final class SceneEntityAppearNotify extends GeneratedMessageV3 implements SceneEntityAppearNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITY_LIST_FIELD_NUMBER = 15;
        private List<SceneEntityInfoOuterClass.SceneEntityInfo> entityList_;
        public static final int APPEAR_TYPE_FIELD_NUMBER = 1;
        private int appearType_;
        public static final int PARAM_FIELD_NUMBER = 7;
        private int param_;
        private byte memoizedIsInitialized;
        private static final SceneEntityAppearNotify DEFAULT_INSTANCE = new SceneEntityAppearNotify();
        private static final Parser<SceneEntityAppearNotify> PARSER = new AbstractParser<SceneEntityAppearNotify>() { // from class: emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotify.1
            @Override // com.google.protobuf.Parser
            public SceneEntityAppearNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneEntityAppearNotify(input, extensionRegistry);
            }
        };

        private SceneEntityAppearNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneEntityAppearNotify() {
            this.memoizedIsInitialized = -1;
            this.entityList_ = Collections.emptyList();
            this.appearType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneEntityAppearNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneEntityAppearNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.appearType_ = input.readEnum();
                                break;
                            case 56:
                                this.param_ = input.readUInt32();
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.entityList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.entityList_.add((SceneEntityInfoOuterClass.SceneEntityInfo) input.readMessage(SceneEntityInfoOuterClass.SceneEntityInfo.parser(), extensionRegistry));
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
                    this.entityList_ = Collections.unmodifiableList(this.entityList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneEntityAppearNotifyOuterClass.internal_static_SceneEntityAppearNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneEntityAppearNotifyOuterClass.internal_static_SceneEntityAppearNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneEntityAppearNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
        public List<SceneEntityInfoOuterClass.SceneEntityInfo> getEntityListList() {
            return this.entityList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
        public List<? extends SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder> getEntityListOrBuilderList() {
            return this.entityList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
        public int getEntityListCount() {
            return this.entityList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
        public SceneEntityInfoOuterClass.SceneEntityInfo getEntityList(int index) {
            return this.entityList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
        public SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder getEntityListOrBuilder(int index) {
            return this.entityList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
        public int getAppearTypeValue() {
            return this.appearType_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
        public VisionTypeOuterClass.VisionType getAppearType() {
            VisionTypeOuterClass.VisionType result = VisionTypeOuterClass.VisionType.valueOf(this.appearType_);
            return result == null ? VisionTypeOuterClass.VisionType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
        public int getParam() {
            return this.param_;
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
            if (this.appearType_ != VisionTypeOuterClass.VisionType.VISION_TYPE_NONE.getNumber()) {
                output.writeEnum(1, this.appearType_);
            }
            if (this.param_ != 0) {
                output.writeUInt32(7, this.param_);
            }
            for (int i = 0; i < this.entityList_.size(); i++) {
                output.writeMessage(15, this.entityList_.get(i));
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
            if (this.appearType_ != VisionTypeOuterClass.VisionType.VISION_TYPE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.appearType_);
            }
            if (this.param_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.param_);
            }
            for (int i = 0; i < this.entityList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.entityList_.get(i));
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
            if (!(obj instanceof SceneEntityAppearNotify)) {
                return equals(obj);
            }
            SceneEntityAppearNotify other = (SceneEntityAppearNotify) obj;
            return getEntityListList().equals(other.getEntityListList()) && this.appearType_ == other.appearType_ && getParam() == other.getParam() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getEntityListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getEntityListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 1)) + this.appearType_)) + 7)) + getParam())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneEntityAppearNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityAppearNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityAppearNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityAppearNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityAppearNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityAppearNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityAppearNotify parseFrom(InputStream input) throws IOException {
            return (SceneEntityAppearNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneEntityAppearNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityAppearNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneEntityAppearNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneEntityAppearNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneEntityAppearNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityAppearNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneEntityAppearNotify parseFrom(CodedInputStream input) throws IOException {
            return (SceneEntityAppearNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneEntityAppearNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityAppearNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneEntityAppearNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAppearNotifyOuterClass$SceneEntityAppearNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneEntityAppearNotifyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<SceneEntityInfoOuterClass.SceneEntityInfo, SceneEntityInfoOuterClass.SceneEntityInfo.Builder, SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder> entityListBuilder_;
            private int param_;
            private List<SceneEntityInfoOuterClass.SceneEntityInfo> entityList_ = Collections.emptyList();
            private int appearType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneEntityAppearNotifyOuterClass.internal_static_SceneEntityAppearNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneEntityAppearNotifyOuterClass.internal_static_SceneEntityAppearNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneEntityAppearNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneEntityAppearNotify.alwaysUseFieldBuilders) {
                    getEntityListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.entityListBuilder_ == null) {
                    this.entityList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.entityListBuilder_.clear();
                }
                this.appearType_ = 0;
                this.param_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneEntityAppearNotifyOuterClass.internal_static_SceneEntityAppearNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneEntityAppearNotify getDefaultInstanceForType() {
                return SceneEntityAppearNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneEntityAppearNotify build() {
                SceneEntityAppearNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneEntityAppearNotify buildPartial() {
                SceneEntityAppearNotify result = new SceneEntityAppearNotify(this);
                int i = this.bitField0_;
                if (this.entityListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.entityList_ = Collections.unmodifiableList(this.entityList_);
                        this.bitField0_ &= -2;
                    }
                    result.entityList_ = this.entityList_;
                } else {
                    result.entityList_ = this.entityListBuilder_.build();
                }
                result.appearType_ = this.appearType_;
                result.param_ = this.param_;
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
                if (other instanceof SceneEntityAppearNotify) {
                    return mergeFrom((SceneEntityAppearNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneEntityAppearNotify other) {
                if (other == SceneEntityAppearNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.entityListBuilder_ == null) {
                    if (!other.entityList_.isEmpty()) {
                        if (this.entityList_.isEmpty()) {
                            this.entityList_ = other.entityList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureEntityListIsMutable();
                            this.entityList_.addAll(other.entityList_);
                        }
                        onChanged();
                    }
                } else if (!other.entityList_.isEmpty()) {
                    if (this.entityListBuilder_.isEmpty()) {
                        this.entityListBuilder_.dispose();
                        this.entityListBuilder_ = null;
                        this.entityList_ = other.entityList_;
                        this.bitField0_ &= -2;
                        this.entityListBuilder_ = SceneEntityAppearNotify.alwaysUseFieldBuilders ? getEntityListFieldBuilder() : null;
                    } else {
                        this.entityListBuilder_.addAllMessages(other.entityList_);
                    }
                }
                if (other.appearType_ != 0) {
                    setAppearTypeValue(other.getAppearTypeValue());
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
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
                SceneEntityAppearNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneEntityAppearNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneEntityAppearNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureEntityListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.entityList_ = new ArrayList(this.entityList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
            public List<SceneEntityInfoOuterClass.SceneEntityInfo> getEntityListList() {
                if (this.entityListBuilder_ == null) {
                    return Collections.unmodifiableList(this.entityList_);
                }
                return this.entityListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
            public int getEntityListCount() {
                if (this.entityListBuilder_ == null) {
                    return this.entityList_.size();
                }
                return this.entityListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
            public SceneEntityInfoOuterClass.SceneEntityInfo getEntityList(int index) {
                if (this.entityListBuilder_ == null) {
                    return this.entityList_.get(index);
                }
                return this.entityListBuilder_.getMessage(index);
            }

            public Builder setEntityList(int index, SceneEntityInfoOuterClass.SceneEntityInfo value) {
                if (this.entityListBuilder_ != null) {
                    this.entityListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEntityListIsMutable();
                    this.entityList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setEntityList(int index, SceneEntityInfoOuterClass.SceneEntityInfo.Builder builderForValue) {
                if (this.entityListBuilder_ == null) {
                    ensureEntityListIsMutable();
                    this.entityList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.entityListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEntityList(SceneEntityInfoOuterClass.SceneEntityInfo value) {
                if (this.entityListBuilder_ != null) {
                    this.entityListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEntityListIsMutable();
                    this.entityList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addEntityList(int index, SceneEntityInfoOuterClass.SceneEntityInfo value) {
                if (this.entityListBuilder_ != null) {
                    this.entityListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEntityListIsMutable();
                    this.entityList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addEntityList(SceneEntityInfoOuterClass.SceneEntityInfo.Builder builderForValue) {
                if (this.entityListBuilder_ == null) {
                    ensureEntityListIsMutable();
                    this.entityList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.entityListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEntityList(int index, SceneEntityInfoOuterClass.SceneEntityInfo.Builder builderForValue) {
                if (this.entityListBuilder_ == null) {
                    ensureEntityListIsMutable();
                    this.entityList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.entityListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEntityList(Iterable<? extends SceneEntityInfoOuterClass.SceneEntityInfo> values) {
                if (this.entityListBuilder_ == null) {
                    ensureEntityListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.entityList_);
                    onChanged();
                } else {
                    this.entityListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEntityList() {
                if (this.entityListBuilder_ == null) {
                    this.entityList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.entityListBuilder_.clear();
                }
                return this;
            }

            public Builder removeEntityList(int index) {
                if (this.entityListBuilder_ == null) {
                    ensureEntityListIsMutable();
                    this.entityList_.remove(index);
                    onChanged();
                } else {
                    this.entityListBuilder_.remove(index);
                }
                return this;
            }

            public SceneEntityInfoOuterClass.SceneEntityInfo.Builder getEntityListBuilder(int index) {
                return getEntityListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
            public SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder getEntityListOrBuilder(int index) {
                if (this.entityListBuilder_ == null) {
                    return this.entityList_.get(index);
                }
                return this.entityListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
            public List<? extends SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder> getEntityListOrBuilderList() {
                if (this.entityListBuilder_ != null) {
                    return this.entityListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.entityList_);
            }

            public SceneEntityInfoOuterClass.SceneEntityInfo.Builder addEntityListBuilder() {
                return getEntityListFieldBuilder().addBuilder(SceneEntityInfoOuterClass.SceneEntityInfo.getDefaultInstance());
            }

            public SceneEntityInfoOuterClass.SceneEntityInfo.Builder addEntityListBuilder(int index) {
                return getEntityListFieldBuilder().addBuilder(index, SceneEntityInfoOuterClass.SceneEntityInfo.getDefaultInstance());
            }

            public List<SceneEntityInfoOuterClass.SceneEntityInfo.Builder> getEntityListBuilderList() {
                return getEntityListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SceneEntityInfoOuterClass.SceneEntityInfo, SceneEntityInfoOuterClass.SceneEntityInfo.Builder, SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder> getEntityListFieldBuilder() {
                if (this.entityListBuilder_ == null) {
                    this.entityListBuilder_ = new RepeatedFieldBuilderV3<>(this.entityList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.entityList_ = null;
                }
                return this.entityListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
            public int getAppearTypeValue() {
                return this.appearType_;
            }

            public Builder setAppearTypeValue(int value) {
                this.appearType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
            public VisionTypeOuterClass.VisionType getAppearType() {
                VisionTypeOuterClass.VisionType result = VisionTypeOuterClass.VisionType.valueOf(this.appearType_);
                return result == null ? VisionTypeOuterClass.VisionType.UNRECOGNIZED : result;
            }

            public Builder setAppearType(VisionTypeOuterClass.VisionType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.appearType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAppearType() {
                this.appearType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotifyOrBuilder
            public int getParam() {
                return this.param_;
            }

            public Builder setParam(int value) {
                this.param_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam() {
                this.param_ = 0;
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

        public static SceneEntityAppearNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneEntityAppearNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneEntityAppearNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneEntityAppearNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SceneEntityInfoOuterClass.getDescriptor();
        VisionTypeOuterClass.getDescriptor();
    }
}
