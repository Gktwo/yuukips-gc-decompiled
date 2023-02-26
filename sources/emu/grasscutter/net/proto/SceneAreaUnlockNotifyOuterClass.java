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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAreaUnlockNotifyOuterClass.class */
public final class SceneAreaUnlockNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bSceneAreaUnlockNotify.proto\":\n\u0015SceneAreaUnlockNotify\u0012\u0010\n\bareaList\u0018\f \u0003(\r\u0012\u000f\n\u0007sceneId\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SceneAreaUnlockNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneAreaUnlockNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneAreaUnlockNotify_descriptor, new String[]{"AreaList", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAreaUnlockNotifyOuterClass$SceneAreaUnlockNotifyOrBuilder.class */
    public interface SceneAreaUnlockNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getAreaListList();

        int getAreaListCount();

        int getAreaList(int i);

        int getSceneId();
    }

    private SceneAreaUnlockNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAreaUnlockNotifyOuterClass$SceneAreaUnlockNotify.class */
    public static final class SceneAreaUnlockNotify extends GeneratedMessageV3 implements SceneAreaUnlockNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AREALIST_FIELD_NUMBER = 12;
        private Internal.IntList areaList_;
        private int areaListMemoizedSerializedSize;
        public static final int SCENEID_FIELD_NUMBER = 11;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final SceneAreaUnlockNotify DEFAULT_INSTANCE = new SceneAreaUnlockNotify();
        private static final Parser<SceneAreaUnlockNotify> PARSER = new AbstractParser<SceneAreaUnlockNotify>() { // from class: emu.grasscutter.net.proto.SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotify.1
            @Override // com.google.protobuf.Parser
            public SceneAreaUnlockNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneAreaUnlockNotify(input, extensionRegistry);
            }
        };

        private SceneAreaUnlockNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.areaListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SceneAreaUnlockNotify() {
            this.areaListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.areaList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneAreaUnlockNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneAreaUnlockNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 88:
                                    this.sceneId_ = input.readUInt32();
                                    break;
                                case 96:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.areaList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.areaList_.addInt(input.readUInt32());
                                    break;
                                case 98:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.areaList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.areaList_.addInt(input.readUInt32());
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.areaList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneAreaUnlockNotifyOuterClass.internal_static_SceneAreaUnlockNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneAreaUnlockNotifyOuterClass.internal_static_SceneAreaUnlockNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneAreaUnlockNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotifyOrBuilder
        public List<Integer> getAreaListList() {
            return this.areaList_;
        }

        @Override // emu.grasscutter.net.proto.SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotifyOrBuilder
        public int getAreaListCount() {
            return this.areaList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotifyOrBuilder
        public int getAreaList(int index) {
            return this.areaList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotifyOrBuilder
        public int getSceneId() {
            return this.sceneId_;
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
            if (this.sceneId_ != 0) {
                output.writeUInt32(11, this.sceneId_);
            }
            if (getAreaListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.areaListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.areaList_.size(); i++) {
                output.writeUInt32NoTag(this.areaList_.getInt(i));
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
            if (this.sceneId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(11, this.sceneId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.areaList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.areaList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getAreaListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.areaListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SceneAreaUnlockNotify)) {
                return equals(obj);
            }
            SceneAreaUnlockNotify other = (SceneAreaUnlockNotify) obj;
            return getAreaListList().equals(other.getAreaListList()) && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAreaListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getAreaListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneAreaUnlockNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneAreaUnlockNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneAreaUnlockNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneAreaUnlockNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneAreaUnlockNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneAreaUnlockNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneAreaUnlockNotify parseFrom(InputStream input) throws IOException {
            return (SceneAreaUnlockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneAreaUnlockNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneAreaUnlockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneAreaUnlockNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneAreaUnlockNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneAreaUnlockNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneAreaUnlockNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneAreaUnlockNotify parseFrom(CodedInputStream input) throws IOException {
            return (SceneAreaUnlockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneAreaUnlockNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneAreaUnlockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneAreaUnlockNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAreaUnlockNotifyOuterClass$SceneAreaUnlockNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneAreaUnlockNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList areaList_ = SceneAreaUnlockNotify.emptyIntList();
            private int sceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneAreaUnlockNotifyOuterClass.internal_static_SceneAreaUnlockNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneAreaUnlockNotifyOuterClass.internal_static_SceneAreaUnlockNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneAreaUnlockNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneAreaUnlockNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.areaList_ = SceneAreaUnlockNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneAreaUnlockNotifyOuterClass.internal_static_SceneAreaUnlockNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneAreaUnlockNotify getDefaultInstanceForType() {
                return SceneAreaUnlockNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneAreaUnlockNotify build() {
                SceneAreaUnlockNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneAreaUnlockNotify buildPartial() {
                SceneAreaUnlockNotify result = new SceneAreaUnlockNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.areaList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.areaList_ = this.areaList_;
                result.sceneId_ = this.sceneId_;
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
                if (other instanceof SceneAreaUnlockNotify) {
                    return mergeFrom((SceneAreaUnlockNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneAreaUnlockNotify other) {
                if (other == SceneAreaUnlockNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.areaList_.isEmpty()) {
                    if (this.areaList_.isEmpty()) {
                        this.areaList_ = other.areaList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAreaListIsMutable();
                        this.areaList_.addAll(other.areaList_);
                    }
                    onChanged();
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
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
                SceneAreaUnlockNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneAreaUnlockNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneAreaUnlockNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAreaListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.areaList_ = SceneAreaUnlockNotify.mutableCopy(this.areaList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotifyOrBuilder
            public List<Integer> getAreaListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.areaList_) : this.areaList_;
            }

            @Override // emu.grasscutter.net.proto.SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotifyOrBuilder
            public int getAreaListCount() {
                return this.areaList_.size();
            }

            @Override // emu.grasscutter.net.proto.SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotifyOrBuilder
            public int getAreaList(int index) {
                return this.areaList_.getInt(index);
            }

            public Builder setAreaList(int index, int value) {
                ensureAreaListIsMutable();
                this.areaList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAreaList(int value) {
                ensureAreaListIsMutable();
                this.areaList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAreaList(Iterable<? extends Integer> values) {
                ensureAreaListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.areaList_);
                onChanged();
                return this;
            }

            public Builder clearAreaList() {
                this.areaList_ = SceneAreaUnlockNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotifyOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
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

        public static SceneAreaUnlockNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneAreaUnlockNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneAreaUnlockNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneAreaUnlockNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
