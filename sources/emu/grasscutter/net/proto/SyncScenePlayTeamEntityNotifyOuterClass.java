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
import emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SyncScenePlayTeamEntityNotifyOuterClass.class */
public final class SyncScenePlayTeamEntityNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#SyncScenePlayTeamEntityNotify.proto\u001a\u0018PlayTeamEntityInfo.proto\"`\n\u001dSyncScenePlayTeamEntityNotify\u0012\u0010\n\bscene_id\u0018\u0007 \u0001(\r\u0012-\n\u0010entity_info_list\u0018\u0003 \u0003(\u000b2\u0013.PlayTeamEntityInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlayTeamEntityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SyncScenePlayTeamEntityNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SyncScenePlayTeamEntityNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SyncScenePlayTeamEntityNotify_descriptor, new String[]{"SceneId", "EntityInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SyncScenePlayTeamEntityNotifyOuterClass$SyncScenePlayTeamEntityNotifyOrBuilder.class */
    public interface SyncScenePlayTeamEntityNotifyOrBuilder extends MessageOrBuilder {
        int getSceneId();

        List<PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo> getEntityInfoListList();

        PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo getEntityInfoList(int i);

        int getEntityInfoListCount();

        List<? extends PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder> getEntityInfoListOrBuilderList();

        PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder getEntityInfoListOrBuilder(int i);
    }

    private SyncScenePlayTeamEntityNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SyncScenePlayTeamEntityNotifyOuterClass$SyncScenePlayTeamEntityNotify.class */
    public static final class SyncScenePlayTeamEntityNotify extends GeneratedMessageV3 implements SyncScenePlayTeamEntityNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENE_ID_FIELD_NUMBER = 7;
        private int sceneId_;
        public static final int ENTITY_INFO_LIST_FIELD_NUMBER = 3;
        private List<PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo> entityInfoList_;
        private byte memoizedIsInitialized;
        private static final SyncScenePlayTeamEntityNotify DEFAULT_INSTANCE = new SyncScenePlayTeamEntityNotify();
        private static final Parser<SyncScenePlayTeamEntityNotify> PARSER = new AbstractParser<SyncScenePlayTeamEntityNotify>() { // from class: emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotify.1
            @Override // com.google.protobuf.Parser
            public SyncScenePlayTeamEntityNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SyncScenePlayTeamEntityNotify(input, extensionRegistry);
            }
        };

        private SyncScenePlayTeamEntityNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SyncScenePlayTeamEntityNotify() {
            this.memoizedIsInitialized = -1;
            this.entityInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SyncScenePlayTeamEntityNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SyncScenePlayTeamEntityNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 26:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.entityInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.entityInfoList_.add((PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo) input.readMessage(PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.parser(), extensionRegistry));
                                    break;
                                case 56:
                                    this.sceneId_ = input.readUInt32();
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
                    this.entityInfoList_ = Collections.unmodifiableList(this.entityInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SyncScenePlayTeamEntityNotifyOuterClass.internal_static_SyncScenePlayTeamEntityNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SyncScenePlayTeamEntityNotifyOuterClass.internal_static_SyncScenePlayTeamEntityNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncScenePlayTeamEntityNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
        public List<PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo> getEntityInfoListList() {
            return this.entityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
        public List<? extends PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder> getEntityInfoListOrBuilderList() {
            return this.entityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
        public int getEntityInfoListCount() {
            return this.entityInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
        public PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo getEntityInfoList(int index) {
            return this.entityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
        public PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder getEntityInfoListOrBuilder(int index) {
            return this.entityInfoList_.get(index);
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
            for (int i = 0; i < this.entityInfoList_.size(); i++) {
                output.writeMessage(3, this.entityInfoList_.get(i));
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(7, this.sceneId_);
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
            for (int i = 0; i < this.entityInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.entityInfoList_.get(i));
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.sceneId_);
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
            if (!(obj instanceof SyncScenePlayTeamEntityNotify)) {
                return equals(obj);
            }
            SyncScenePlayTeamEntityNotify other = (SyncScenePlayTeamEntityNotify) obj;
            return getSceneId() == other.getSceneId() && getEntityInfoListList().equals(other.getEntityInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getSceneId();
            if (getEntityInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getEntityInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SyncScenePlayTeamEntityNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SyncScenePlayTeamEntityNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SyncScenePlayTeamEntityNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SyncScenePlayTeamEntityNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SyncScenePlayTeamEntityNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SyncScenePlayTeamEntityNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SyncScenePlayTeamEntityNotify parseFrom(InputStream input) throws IOException {
            return (SyncScenePlayTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SyncScenePlayTeamEntityNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncScenePlayTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SyncScenePlayTeamEntityNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SyncScenePlayTeamEntityNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SyncScenePlayTeamEntityNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncScenePlayTeamEntityNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SyncScenePlayTeamEntityNotify parseFrom(CodedInputStream input) throws IOException {
            return (SyncScenePlayTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SyncScenePlayTeamEntityNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncScenePlayTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SyncScenePlayTeamEntityNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SyncScenePlayTeamEntityNotifyOuterClass$SyncScenePlayTeamEntityNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SyncScenePlayTeamEntityNotifyOrBuilder {
            private int bitField0_;
            private int sceneId_;
            private List<PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo> entityInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo, PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.Builder, PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder> entityInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SyncScenePlayTeamEntityNotifyOuterClass.internal_static_SyncScenePlayTeamEntityNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SyncScenePlayTeamEntityNotifyOuterClass.internal_static_SyncScenePlayTeamEntityNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncScenePlayTeamEntityNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SyncScenePlayTeamEntityNotify.alwaysUseFieldBuilders) {
                    getEntityInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.sceneId_ = 0;
                if (this.entityInfoListBuilder_ == null) {
                    this.entityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.entityInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SyncScenePlayTeamEntityNotifyOuterClass.internal_static_SyncScenePlayTeamEntityNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SyncScenePlayTeamEntityNotify getDefaultInstanceForType() {
                return SyncScenePlayTeamEntityNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SyncScenePlayTeamEntityNotify build() {
                SyncScenePlayTeamEntityNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SyncScenePlayTeamEntityNotify buildPartial() {
                SyncScenePlayTeamEntityNotify result = new SyncScenePlayTeamEntityNotify(this);
                int i = this.bitField0_;
                result.sceneId_ = this.sceneId_;
                if (this.entityInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.entityInfoList_ = Collections.unmodifiableList(this.entityInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.entityInfoList_ = this.entityInfoList_;
                } else {
                    result.entityInfoList_ = this.entityInfoListBuilder_.build();
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
                if (other instanceof SyncScenePlayTeamEntityNotify) {
                    return mergeFrom((SyncScenePlayTeamEntityNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SyncScenePlayTeamEntityNotify other) {
                if (other == SyncScenePlayTeamEntityNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (this.entityInfoListBuilder_ == null) {
                    if (!other.entityInfoList_.isEmpty()) {
                        if (this.entityInfoList_.isEmpty()) {
                            this.entityInfoList_ = other.entityInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureEntityInfoListIsMutable();
                            this.entityInfoList_.addAll(other.entityInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.entityInfoList_.isEmpty()) {
                    if (this.entityInfoListBuilder_.isEmpty()) {
                        this.entityInfoListBuilder_.dispose();
                        this.entityInfoListBuilder_ = null;
                        this.entityInfoList_ = other.entityInfoList_;
                        this.bitField0_ &= -2;
                        this.entityInfoListBuilder_ = SyncScenePlayTeamEntityNotify.alwaysUseFieldBuilders ? getEntityInfoListFieldBuilder() : null;
                    } else {
                        this.entityInfoListBuilder_.addAllMessages(other.entityInfoList_);
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
                SyncScenePlayTeamEntityNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SyncScenePlayTeamEntityNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SyncScenePlayTeamEntityNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
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

            private void ensureEntityInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.entityInfoList_ = new ArrayList(this.entityInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
            public List<PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo> getEntityInfoListList() {
                if (this.entityInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.entityInfoList_);
                }
                return this.entityInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
            public int getEntityInfoListCount() {
                if (this.entityInfoListBuilder_ == null) {
                    return this.entityInfoList_.size();
                }
                return this.entityInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
            public PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo getEntityInfoList(int index) {
                if (this.entityInfoListBuilder_ == null) {
                    return this.entityInfoList_.get(index);
                }
                return this.entityInfoListBuilder_.getMessage(index);
            }

            public Builder setEntityInfoList(int index, PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo value) {
                if (this.entityInfoListBuilder_ != null) {
                    this.entityInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEntityInfoListIsMutable();
                    this.entityInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setEntityInfoList(int index, PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.Builder builderForValue) {
                if (this.entityInfoListBuilder_ == null) {
                    ensureEntityInfoListIsMutable();
                    this.entityInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.entityInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEntityInfoList(PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo value) {
                if (this.entityInfoListBuilder_ != null) {
                    this.entityInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEntityInfoListIsMutable();
                    this.entityInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addEntityInfoList(int index, PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo value) {
                if (this.entityInfoListBuilder_ != null) {
                    this.entityInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEntityInfoListIsMutable();
                    this.entityInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addEntityInfoList(PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.Builder builderForValue) {
                if (this.entityInfoListBuilder_ == null) {
                    ensureEntityInfoListIsMutable();
                    this.entityInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.entityInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEntityInfoList(int index, PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.Builder builderForValue) {
                if (this.entityInfoListBuilder_ == null) {
                    ensureEntityInfoListIsMutable();
                    this.entityInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.entityInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEntityInfoList(Iterable<? extends PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo> values) {
                if (this.entityInfoListBuilder_ == null) {
                    ensureEntityInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.entityInfoList_);
                    onChanged();
                } else {
                    this.entityInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEntityInfoList() {
                if (this.entityInfoListBuilder_ == null) {
                    this.entityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.entityInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeEntityInfoList(int index) {
                if (this.entityInfoListBuilder_ == null) {
                    ensureEntityInfoListIsMutable();
                    this.entityInfoList_.remove(index);
                    onChanged();
                } else {
                    this.entityInfoListBuilder_.remove(index);
                }
                return this;
            }

            public PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.Builder getEntityInfoListBuilder(int index) {
                return getEntityInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
            public PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder getEntityInfoListOrBuilder(int index) {
                if (this.entityInfoListBuilder_ == null) {
                    return this.entityInfoList_.get(index);
                }
                return this.entityInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotifyOrBuilder
            public List<? extends PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder> getEntityInfoListOrBuilderList() {
                if (this.entityInfoListBuilder_ != null) {
                    return this.entityInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.entityInfoList_);
            }

            public PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.Builder addEntityInfoListBuilder() {
                return getEntityInfoListFieldBuilder().addBuilder(PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.getDefaultInstance());
            }

            public PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.Builder addEntityInfoListBuilder(int index) {
                return getEntityInfoListFieldBuilder().addBuilder(index, PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.getDefaultInstance());
            }

            public List<PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.Builder> getEntityInfoListBuilderList() {
                return getEntityInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo, PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.Builder, PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder> getEntityInfoListFieldBuilder() {
                if (this.entityInfoListBuilder_ == null) {
                    this.entityInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.entityInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.entityInfoList_ = null;
                }
                return this.entityInfoListBuilder_;
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

        public static SyncScenePlayTeamEntityNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SyncScenePlayTeamEntityNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SyncScenePlayTeamEntityNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SyncScenePlayTeamEntityNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlayTeamEntityInfoOuterClass.getDescriptor();
    }
}
