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
import emu.grasscutter.net.proto.VisionTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityDisappearNotifyOuterClass.class */
public final class SceneEntityDisappearNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n SceneEntityDisappearNotify.proto\u001a\u0010VisionType.proto\"e\n\u001aSceneEntityDisappearNotify\u0012\r\n\u0005param\u0018\u000f \u0001(\r\u0012#\n\u000edisappear_type\u0018\f \u0001(\u000e2\u000b.VisionType\u0012\u0013\n\u000bentity_list\u0018\r \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VisionTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneEntityDisappearNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneEntityDisappearNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneEntityDisappearNotify_descriptor, new String[]{"Param", "DisappearType", "EntityList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityDisappearNotifyOuterClass$SceneEntityDisappearNotifyOrBuilder.class */
    public interface SceneEntityDisappearNotifyOrBuilder extends MessageOrBuilder {
        int getParam();

        int getDisappearTypeValue();

        VisionTypeOuterClass.VisionType getDisappearType();

        List<Integer> getEntityListList();

        int getEntityListCount();

        int getEntityList(int i);
    }

    private SceneEntityDisappearNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityDisappearNotifyOuterClass$SceneEntityDisappearNotify.class */
    public static final class SceneEntityDisappearNotify extends GeneratedMessageV3 implements SceneEntityDisappearNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARAM_FIELD_NUMBER = 15;
        private int param_;
        public static final int DISAPPEAR_TYPE_FIELD_NUMBER = 12;
        private int disappearType_;
        public static final int ENTITY_LIST_FIELD_NUMBER = 13;
        private Internal.IntList entityList_;
        private int entityListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final SceneEntityDisappearNotify DEFAULT_INSTANCE = new SceneEntityDisappearNotify();
        private static final Parser<SceneEntityDisappearNotify> PARSER = new AbstractParser<SceneEntityDisappearNotify>() { // from class: emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotify.1
            @Override // com.google.protobuf.Parser
            public SceneEntityDisappearNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneEntityDisappearNotify(input, extensionRegistry);
            }
        };

        private SceneEntityDisappearNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.entityListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SceneEntityDisappearNotify() {
            this.entityListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.disappearType_ = 0;
            this.entityList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneEntityDisappearNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneEntityDisappearNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 96:
                                this.disappearType_ = input.readEnum();
                                break;
                            case 104:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.entityList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.entityList_.addInt(input.readUInt32());
                                break;
                            case 106:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.entityList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.entityList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 120:
                                this.param_ = input.readUInt32();
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
                    this.entityList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneEntityDisappearNotifyOuterClass.internal_static_SceneEntityDisappearNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneEntityDisappearNotifyOuterClass.internal_static_SceneEntityDisappearNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneEntityDisappearNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
        public int getParam() {
            return this.param_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
        public int getDisappearTypeValue() {
            return this.disappearType_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
        public VisionTypeOuterClass.VisionType getDisappearType() {
            VisionTypeOuterClass.VisionType result = VisionTypeOuterClass.VisionType.valueOf(this.disappearType_);
            return result == null ? VisionTypeOuterClass.VisionType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
        public List<Integer> getEntityListList() {
            return this.entityList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
        public int getEntityListCount() {
            return this.entityList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
        public int getEntityList(int index) {
            return this.entityList_.getInt(index);
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
            if (this.disappearType_ != VisionTypeOuterClass.VisionType.VISION_TYPE_NONE.getNumber()) {
                output.writeEnum(12, this.disappearType_);
            }
            if (getEntityListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.entityListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.entityList_.size(); i++) {
                output.writeUInt32NoTag(this.entityList_.getInt(i));
            }
            if (this.param_ != 0) {
                output.writeUInt32(15, this.param_);
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
            if (this.disappearType_ != VisionTypeOuterClass.VisionType.VISION_TYPE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(12, this.disappearType_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.entityList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.entityList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getEntityListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.entityListMemoizedSerializedSize = dataSize;
            if (this.param_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.param_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SceneEntityDisappearNotify)) {
                return equals(obj);
            }
            SceneEntityDisappearNotify other = (SceneEntityDisappearNotify) obj;
            return getParam() == other.getParam() && this.disappearType_ == other.disappearType_ && getEntityListList().equals(other.getEntityListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getParam())) + 12)) + this.disappearType_;
            if (getEntityListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getEntityListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneEntityDisappearNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityDisappearNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityDisappearNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityDisappearNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityDisappearNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityDisappearNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityDisappearNotify parseFrom(InputStream input) throws IOException {
            return (SceneEntityDisappearNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneEntityDisappearNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityDisappearNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneEntityDisappearNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneEntityDisappearNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneEntityDisappearNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityDisappearNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneEntityDisappearNotify parseFrom(CodedInputStream input) throws IOException {
            return (SceneEntityDisappearNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneEntityDisappearNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityDisappearNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneEntityDisappearNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityDisappearNotifyOuterClass$SceneEntityDisappearNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneEntityDisappearNotifyOrBuilder {
            private int bitField0_;
            private int param_;
            private int disappearType_ = 0;
            private Internal.IntList entityList_ = SceneEntityDisappearNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneEntityDisappearNotifyOuterClass.internal_static_SceneEntityDisappearNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneEntityDisappearNotifyOuterClass.internal_static_SceneEntityDisappearNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneEntityDisappearNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneEntityDisappearNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.param_ = 0;
                this.disappearType_ = 0;
                this.entityList_ = SceneEntityDisappearNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneEntityDisappearNotifyOuterClass.internal_static_SceneEntityDisappearNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneEntityDisappearNotify getDefaultInstanceForType() {
                return SceneEntityDisappearNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneEntityDisappearNotify build() {
                SceneEntityDisappearNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneEntityDisappearNotify buildPartial() {
                SceneEntityDisappearNotify result = new SceneEntityDisappearNotify(this);
                int i = this.bitField0_;
                result.param_ = this.param_;
                result.disappearType_ = this.disappearType_;
                if ((this.bitField0_ & 1) != 0) {
                    this.entityList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.entityList_ = this.entityList_;
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
                if (other instanceof SceneEntityDisappearNotify) {
                    return mergeFrom((SceneEntityDisappearNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneEntityDisappearNotify other) {
                if (other == SceneEntityDisappearNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
                }
                if (other.disappearType_ != 0) {
                    setDisappearTypeValue(other.getDisappearTypeValue());
                }
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
                SceneEntityDisappearNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneEntityDisappearNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneEntityDisappearNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
            public int getDisappearTypeValue() {
                return this.disappearType_;
            }

            public Builder setDisappearTypeValue(int value) {
                this.disappearType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
            public VisionTypeOuterClass.VisionType getDisappearType() {
                VisionTypeOuterClass.VisionType result = VisionTypeOuterClass.VisionType.valueOf(this.disappearType_);
                return result == null ? VisionTypeOuterClass.VisionType.UNRECOGNIZED : result;
            }

            public Builder setDisappearType(VisionTypeOuterClass.VisionType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.disappearType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearDisappearType() {
                this.disappearType_ = 0;
                onChanged();
                return this;
            }

            private void ensureEntityListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.entityList_ = SceneEntityDisappearNotify.mutableCopy(this.entityList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
            public List<Integer> getEntityListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.entityList_) : this.entityList_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
            public int getEntityListCount() {
                return this.entityList_.size();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotifyOrBuilder
            public int getEntityList(int index) {
                return this.entityList_.getInt(index);
            }

            public Builder setEntityList(int index, int value) {
                ensureEntityListIsMutable();
                this.entityList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addEntityList(int value) {
                ensureEntityListIsMutable();
                this.entityList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllEntityList(Iterable<? extends Integer> values) {
                ensureEntityListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.entityList_);
                onChanged();
                return this;
            }

            public Builder clearEntityList() {
                this.entityList_ = SceneEntityDisappearNotify.emptyIntList();
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

        public static SceneEntityDisappearNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneEntityDisappearNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneEntityDisappearNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneEntityDisappearNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VisionTypeOuterClass.getDescriptor();
    }
}
