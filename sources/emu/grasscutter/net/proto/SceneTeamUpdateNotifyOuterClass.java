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
import emu.grasscutter.net.proto.SceneTeamAvatarOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTeamUpdateNotifyOuterClass.class */
public final class SceneTeamUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bSceneTeamUpdateNotify.proto\u001a\u0015SceneTeamAvatar.proto\"[\n\u0015SceneTeamUpdateNotify\u00120\n\u0016scene_team_avatar_list\u0018\u000b \u0003(\u000b2\u0010.SceneTeamAvatar\u0012\u0010\n\bis_in_mp\u0018\u0007 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SceneTeamAvatarOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneTeamUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneTeamUpdateNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneTeamUpdateNotify_descriptor, new String[]{"SceneTeamAvatarList", "IsInMp"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTeamUpdateNotifyOuterClass$SceneTeamUpdateNotifyOrBuilder.class */
    public interface SceneTeamUpdateNotifyOrBuilder extends MessageOrBuilder {
        List<SceneTeamAvatarOuterClass.SceneTeamAvatar> getSceneTeamAvatarListList();

        SceneTeamAvatarOuterClass.SceneTeamAvatar getSceneTeamAvatarList(int i);

        int getSceneTeamAvatarListCount();

        List<? extends SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder> getSceneTeamAvatarListOrBuilderList();

        SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder getSceneTeamAvatarListOrBuilder(int i);

        boolean getIsInMp();
    }

    private SceneTeamUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTeamUpdateNotifyOuterClass$SceneTeamUpdateNotify.class */
    public static final class SceneTeamUpdateNotify extends GeneratedMessageV3 implements SceneTeamUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENE_TEAM_AVATAR_LIST_FIELD_NUMBER = 11;
        private List<SceneTeamAvatarOuterClass.SceneTeamAvatar> sceneTeamAvatarList_;
        public static final int IS_IN_MP_FIELD_NUMBER = 7;
        private boolean isInMp_;
        private byte memoizedIsInitialized;
        private static final SceneTeamUpdateNotify DEFAULT_INSTANCE = new SceneTeamUpdateNotify();
        private static final Parser<SceneTeamUpdateNotify> PARSER = new AbstractParser<SceneTeamUpdateNotify>() { // from class: emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public SceneTeamUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneTeamUpdateNotify(input, extensionRegistry);
            }
        };

        private SceneTeamUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneTeamUpdateNotify() {
            this.memoizedIsInitialized = -1;
            this.sceneTeamAvatarList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneTeamUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneTeamUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.isInMp_ = input.readBool();
                                    break;
                                case 90:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.sceneTeamAvatarList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.sceneTeamAvatarList_.add((SceneTeamAvatarOuterClass.SceneTeamAvatar) input.readMessage(SceneTeamAvatarOuterClass.SceneTeamAvatar.parser(), extensionRegistry));
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
                    this.sceneTeamAvatarList_ = Collections.unmodifiableList(this.sceneTeamAvatarList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneTeamUpdateNotifyOuterClass.internal_static_SceneTeamUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneTeamUpdateNotifyOuterClass.internal_static_SceneTeamUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneTeamUpdateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
        public List<SceneTeamAvatarOuterClass.SceneTeamAvatar> getSceneTeamAvatarListList() {
            return this.sceneTeamAvatarList_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
        public List<? extends SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder> getSceneTeamAvatarListOrBuilderList() {
            return this.sceneTeamAvatarList_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
        public int getSceneTeamAvatarListCount() {
            return this.sceneTeamAvatarList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
        public SceneTeamAvatarOuterClass.SceneTeamAvatar getSceneTeamAvatarList(int index) {
            return this.sceneTeamAvatarList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
        public SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder getSceneTeamAvatarListOrBuilder(int index) {
            return this.sceneTeamAvatarList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
        public boolean getIsInMp() {
            return this.isInMp_;
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
            if (this.isInMp_) {
                output.writeBool(7, this.isInMp_);
            }
            for (int i = 0; i < this.sceneTeamAvatarList_.size(); i++) {
                output.writeMessage(11, this.sceneTeamAvatarList_.get(i));
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
            if (this.isInMp_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(7, this.isInMp_);
            }
            for (int i = 0; i < this.sceneTeamAvatarList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.sceneTeamAvatarList_.get(i));
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
            if (!(obj instanceof SceneTeamUpdateNotify)) {
                return equals(obj);
            }
            SceneTeamUpdateNotify other = (SceneTeamUpdateNotify) obj;
            return getSceneTeamAvatarListList().equals(other.getSceneTeamAvatarListList()) && getIsInMp() == other.getIsInMp() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getSceneTeamAvatarListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getSceneTeamAvatarListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 7)) + Internal.hashBoolean(getIsInMp()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneTeamUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneTeamUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneTeamUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneTeamUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneTeamUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneTeamUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneTeamUpdateNotify parseFrom(InputStream input) throws IOException {
            return (SceneTeamUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneTeamUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneTeamUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneTeamUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneTeamUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneTeamUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneTeamUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneTeamUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (SceneTeamUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneTeamUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneTeamUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneTeamUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTeamUpdateNotifyOuterClass$SceneTeamUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneTeamUpdateNotifyOrBuilder {
            private int bitField0_;
            private List<SceneTeamAvatarOuterClass.SceneTeamAvatar> sceneTeamAvatarList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<SceneTeamAvatarOuterClass.SceneTeamAvatar, SceneTeamAvatarOuterClass.SceneTeamAvatar.Builder, SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder> sceneTeamAvatarListBuilder_;
            private boolean isInMp_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneTeamUpdateNotifyOuterClass.internal_static_SceneTeamUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneTeamUpdateNotifyOuterClass.internal_static_SceneTeamUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneTeamUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneTeamUpdateNotify.alwaysUseFieldBuilders) {
                    getSceneTeamAvatarListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    this.sceneTeamAvatarList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.sceneTeamAvatarListBuilder_.clear();
                }
                this.isInMp_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneTeamUpdateNotifyOuterClass.internal_static_SceneTeamUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneTeamUpdateNotify getDefaultInstanceForType() {
                return SceneTeamUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneTeamUpdateNotify build() {
                SceneTeamUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneTeamUpdateNotify buildPartial() {
                SceneTeamUpdateNotify result = new SceneTeamUpdateNotify(this);
                int i = this.bitField0_;
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.sceneTeamAvatarList_ = Collections.unmodifiableList(this.sceneTeamAvatarList_);
                        this.bitField0_ &= -2;
                    }
                    result.sceneTeamAvatarList_ = this.sceneTeamAvatarList_;
                } else {
                    result.sceneTeamAvatarList_ = this.sceneTeamAvatarListBuilder_.build();
                }
                result.isInMp_ = this.isInMp_;
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
                if (other instanceof SceneTeamUpdateNotify) {
                    return mergeFrom((SceneTeamUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneTeamUpdateNotify other) {
                if (other == SceneTeamUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    if (!other.sceneTeamAvatarList_.isEmpty()) {
                        if (this.sceneTeamAvatarList_.isEmpty()) {
                            this.sceneTeamAvatarList_ = other.sceneTeamAvatarList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSceneTeamAvatarListIsMutable();
                            this.sceneTeamAvatarList_.addAll(other.sceneTeamAvatarList_);
                        }
                        onChanged();
                    }
                } else if (!other.sceneTeamAvatarList_.isEmpty()) {
                    if (this.sceneTeamAvatarListBuilder_.isEmpty()) {
                        this.sceneTeamAvatarListBuilder_.dispose();
                        this.sceneTeamAvatarListBuilder_ = null;
                        this.sceneTeamAvatarList_ = other.sceneTeamAvatarList_;
                        this.bitField0_ &= -2;
                        this.sceneTeamAvatarListBuilder_ = SceneTeamUpdateNotify.alwaysUseFieldBuilders ? getSceneTeamAvatarListFieldBuilder() : null;
                    } else {
                        this.sceneTeamAvatarListBuilder_.addAllMessages(other.sceneTeamAvatarList_);
                    }
                }
                if (other.getIsInMp()) {
                    setIsInMp(other.getIsInMp());
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
                SceneTeamUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneTeamUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneTeamUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureSceneTeamAvatarListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.sceneTeamAvatarList_ = new ArrayList(this.sceneTeamAvatarList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
            public List<SceneTeamAvatarOuterClass.SceneTeamAvatar> getSceneTeamAvatarListList() {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    return Collections.unmodifiableList(this.sceneTeamAvatarList_);
                }
                return this.sceneTeamAvatarListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
            public int getSceneTeamAvatarListCount() {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    return this.sceneTeamAvatarList_.size();
                }
                return this.sceneTeamAvatarListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
            public SceneTeamAvatarOuterClass.SceneTeamAvatar getSceneTeamAvatarList(int index) {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    return this.sceneTeamAvatarList_.get(index);
                }
                return this.sceneTeamAvatarListBuilder_.getMessage(index);
            }

            public Builder setSceneTeamAvatarList(int index, SceneTeamAvatarOuterClass.SceneTeamAvatar value) {
                if (this.sceneTeamAvatarListBuilder_ != null) {
                    this.sceneTeamAvatarListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSceneTeamAvatarListIsMutable();
                    this.sceneTeamAvatarList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSceneTeamAvatarList(int index, SceneTeamAvatarOuterClass.SceneTeamAvatar.Builder builderForValue) {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    ensureSceneTeamAvatarListIsMutable();
                    this.sceneTeamAvatarList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.sceneTeamAvatarListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSceneTeamAvatarList(SceneTeamAvatarOuterClass.SceneTeamAvatar value) {
                if (this.sceneTeamAvatarListBuilder_ != null) {
                    this.sceneTeamAvatarListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSceneTeamAvatarListIsMutable();
                    this.sceneTeamAvatarList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSceneTeamAvatarList(int index, SceneTeamAvatarOuterClass.SceneTeamAvatar value) {
                if (this.sceneTeamAvatarListBuilder_ != null) {
                    this.sceneTeamAvatarListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSceneTeamAvatarListIsMutable();
                    this.sceneTeamAvatarList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSceneTeamAvatarList(SceneTeamAvatarOuterClass.SceneTeamAvatar.Builder builderForValue) {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    ensureSceneTeamAvatarListIsMutable();
                    this.sceneTeamAvatarList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.sceneTeamAvatarListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSceneTeamAvatarList(int index, SceneTeamAvatarOuterClass.SceneTeamAvatar.Builder builderForValue) {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    ensureSceneTeamAvatarListIsMutable();
                    this.sceneTeamAvatarList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.sceneTeamAvatarListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSceneTeamAvatarList(Iterable<? extends SceneTeamAvatarOuterClass.SceneTeamAvatar> values) {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    ensureSceneTeamAvatarListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sceneTeamAvatarList_);
                    onChanged();
                } else {
                    this.sceneTeamAvatarListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSceneTeamAvatarList() {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    this.sceneTeamAvatarList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.sceneTeamAvatarListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSceneTeamAvatarList(int index) {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    ensureSceneTeamAvatarListIsMutable();
                    this.sceneTeamAvatarList_.remove(index);
                    onChanged();
                } else {
                    this.sceneTeamAvatarListBuilder_.remove(index);
                }
                return this;
            }

            public SceneTeamAvatarOuterClass.SceneTeamAvatar.Builder getSceneTeamAvatarListBuilder(int index) {
                return getSceneTeamAvatarListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
            public SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder getSceneTeamAvatarListOrBuilder(int index) {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    return this.sceneTeamAvatarList_.get(index);
                }
                return this.sceneTeamAvatarListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
            public List<? extends SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder> getSceneTeamAvatarListOrBuilderList() {
                if (this.sceneTeamAvatarListBuilder_ != null) {
                    return this.sceneTeamAvatarListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.sceneTeamAvatarList_);
            }

            public SceneTeamAvatarOuterClass.SceneTeamAvatar.Builder addSceneTeamAvatarListBuilder() {
                return getSceneTeamAvatarListFieldBuilder().addBuilder(SceneTeamAvatarOuterClass.SceneTeamAvatar.getDefaultInstance());
            }

            public SceneTeamAvatarOuterClass.SceneTeamAvatar.Builder addSceneTeamAvatarListBuilder(int index) {
                return getSceneTeamAvatarListFieldBuilder().addBuilder(index, SceneTeamAvatarOuterClass.SceneTeamAvatar.getDefaultInstance());
            }

            public List<SceneTeamAvatarOuterClass.SceneTeamAvatar.Builder> getSceneTeamAvatarListBuilderList() {
                return getSceneTeamAvatarListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SceneTeamAvatarOuterClass.SceneTeamAvatar, SceneTeamAvatarOuterClass.SceneTeamAvatar.Builder, SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder> getSceneTeamAvatarListFieldBuilder() {
                if (this.sceneTeamAvatarListBuilder_ == null) {
                    this.sceneTeamAvatarListBuilder_ = new RepeatedFieldBuilderV3<>(this.sceneTeamAvatarList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.sceneTeamAvatarList_ = null;
                }
                return this.sceneTeamAvatarListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotifyOrBuilder
            public boolean getIsInMp() {
                return this.isInMp_;
            }

            public Builder setIsInMp(boolean value) {
                this.isInMp_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsInMp() {
                this.isInMp_ = false;
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

        public static SceneTeamUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneTeamUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneTeamUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneTeamUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SceneTeamAvatarOuterClass.getDescriptor();
    }
}
