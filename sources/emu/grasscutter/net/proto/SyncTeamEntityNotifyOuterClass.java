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
import emu.grasscutter.net.proto.TeamEntityInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SyncTeamEntityNotifyOuterClass.class */
public final class SyncTeamEntityNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aSyncTeamEntityNotify.proto\u001a\u0014TeamEntityInfo.proto\"X\n\u0014SyncTeamEntityNotify\u0012.\n\u0015team_entity_info_list\u0018\n \u0003(\u000b2\u000f.TeamEntityInfo\u0012\u0010\n\bscene_id\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TeamEntityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SyncTeamEntityNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SyncTeamEntityNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SyncTeamEntityNotify_descriptor, new String[]{"TeamEntityInfoList", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SyncTeamEntityNotifyOuterClass$SyncTeamEntityNotifyOrBuilder.class */
    public interface SyncTeamEntityNotifyOrBuilder extends MessageOrBuilder {
        List<TeamEntityInfoOuterClass.TeamEntityInfo> getTeamEntityInfoListList();

        TeamEntityInfoOuterClass.TeamEntityInfo getTeamEntityInfoList(int i);

        int getTeamEntityInfoListCount();

        List<? extends TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder> getTeamEntityInfoListOrBuilderList();

        TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder getTeamEntityInfoListOrBuilder(int i);

        int getSceneId();
    }

    private SyncTeamEntityNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SyncTeamEntityNotifyOuterClass$SyncTeamEntityNotify.class */
    public static final class SyncTeamEntityNotify extends GeneratedMessageV3 implements SyncTeamEntityNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TEAM_ENTITY_INFO_LIST_FIELD_NUMBER = 10;
        private List<TeamEntityInfoOuterClass.TeamEntityInfo> teamEntityInfoList_;
        public static final int SCENE_ID_FIELD_NUMBER = 1;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final SyncTeamEntityNotify DEFAULT_INSTANCE = new SyncTeamEntityNotify();
        private static final Parser<SyncTeamEntityNotify> PARSER = new AbstractParser<SyncTeamEntityNotify>() { // from class: emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotify.1
            @Override // com.google.protobuf.Parser
            public SyncTeamEntityNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SyncTeamEntityNotify(input, extensionRegistry);
            }
        };

        private SyncTeamEntityNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SyncTeamEntityNotify() {
            this.memoizedIsInitialized = -1;
            this.teamEntityInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SyncTeamEntityNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SyncTeamEntityNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.sceneId_ = input.readUInt32();
                                    break;
                                case 82:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.teamEntityInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.teamEntityInfoList_.add((TeamEntityInfoOuterClass.TeamEntityInfo) input.readMessage(TeamEntityInfoOuterClass.TeamEntityInfo.parser(), extensionRegistry));
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
                    this.teamEntityInfoList_ = Collections.unmodifiableList(this.teamEntityInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SyncTeamEntityNotifyOuterClass.internal_static_SyncTeamEntityNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SyncTeamEntityNotifyOuterClass.internal_static_SyncTeamEntityNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncTeamEntityNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
        public List<TeamEntityInfoOuterClass.TeamEntityInfo> getTeamEntityInfoListList() {
            return this.teamEntityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
        public List<? extends TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder> getTeamEntityInfoListOrBuilderList() {
            return this.teamEntityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
        public int getTeamEntityInfoListCount() {
            return this.teamEntityInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
        public TeamEntityInfoOuterClass.TeamEntityInfo getTeamEntityInfoList(int index) {
            return this.teamEntityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
        public TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder getTeamEntityInfoListOrBuilder(int index) {
            return this.teamEntityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
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
            if (this.sceneId_ != 0) {
                output.writeUInt32(1, this.sceneId_);
            }
            for (int i = 0; i < this.teamEntityInfoList_.size(); i++) {
                output.writeMessage(10, this.teamEntityInfoList_.get(i));
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.sceneId_);
            }
            for (int i = 0; i < this.teamEntityInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.teamEntityInfoList_.get(i));
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
            if (!(obj instanceof SyncTeamEntityNotify)) {
                return equals(obj);
            }
            SyncTeamEntityNotify other = (SyncTeamEntityNotify) obj;
            return getTeamEntityInfoListList().equals(other.getTeamEntityInfoListList()) && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTeamEntityInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getTeamEntityInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 1)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SyncTeamEntityNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SyncTeamEntityNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SyncTeamEntityNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SyncTeamEntityNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SyncTeamEntityNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SyncTeamEntityNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SyncTeamEntityNotify parseFrom(InputStream input) throws IOException {
            return (SyncTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SyncTeamEntityNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SyncTeamEntityNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SyncTeamEntityNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SyncTeamEntityNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncTeamEntityNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SyncTeamEntityNotify parseFrom(CodedInputStream input) throws IOException {
            return (SyncTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SyncTeamEntityNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncTeamEntityNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SyncTeamEntityNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SyncTeamEntityNotifyOuterClass$SyncTeamEntityNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SyncTeamEntityNotifyOrBuilder {
            private int bitField0_;
            private List<TeamEntityInfoOuterClass.TeamEntityInfo> teamEntityInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<TeamEntityInfoOuterClass.TeamEntityInfo, TeamEntityInfoOuterClass.TeamEntityInfo.Builder, TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder> teamEntityInfoListBuilder_;
            private int sceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SyncTeamEntityNotifyOuterClass.internal_static_SyncTeamEntityNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SyncTeamEntityNotifyOuterClass.internal_static_SyncTeamEntityNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncTeamEntityNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SyncTeamEntityNotify.alwaysUseFieldBuilders) {
                    getTeamEntityInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.teamEntityInfoListBuilder_ == null) {
                    this.teamEntityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.teamEntityInfoListBuilder_.clear();
                }
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SyncTeamEntityNotifyOuterClass.internal_static_SyncTeamEntityNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SyncTeamEntityNotify getDefaultInstanceForType() {
                return SyncTeamEntityNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SyncTeamEntityNotify build() {
                SyncTeamEntityNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SyncTeamEntityNotify buildPartial() {
                SyncTeamEntityNotify result = new SyncTeamEntityNotify(this);
                int i = this.bitField0_;
                if (this.teamEntityInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.teamEntityInfoList_ = Collections.unmodifiableList(this.teamEntityInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.teamEntityInfoList_ = this.teamEntityInfoList_;
                } else {
                    result.teamEntityInfoList_ = this.teamEntityInfoListBuilder_.build();
                }
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
                if (other instanceof SyncTeamEntityNotify) {
                    return mergeFrom((SyncTeamEntityNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SyncTeamEntityNotify other) {
                if (other == SyncTeamEntityNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.teamEntityInfoListBuilder_ == null) {
                    if (!other.teamEntityInfoList_.isEmpty()) {
                        if (this.teamEntityInfoList_.isEmpty()) {
                            this.teamEntityInfoList_ = other.teamEntityInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTeamEntityInfoListIsMutable();
                            this.teamEntityInfoList_.addAll(other.teamEntityInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.teamEntityInfoList_.isEmpty()) {
                    if (this.teamEntityInfoListBuilder_.isEmpty()) {
                        this.teamEntityInfoListBuilder_.dispose();
                        this.teamEntityInfoListBuilder_ = null;
                        this.teamEntityInfoList_ = other.teamEntityInfoList_;
                        this.bitField0_ &= -2;
                        this.teamEntityInfoListBuilder_ = SyncTeamEntityNotify.alwaysUseFieldBuilders ? getTeamEntityInfoListFieldBuilder() : null;
                    } else {
                        this.teamEntityInfoListBuilder_.addAllMessages(other.teamEntityInfoList_);
                    }
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
                SyncTeamEntityNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SyncTeamEntityNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SyncTeamEntityNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTeamEntityInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.teamEntityInfoList_ = new ArrayList(this.teamEntityInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
            public List<TeamEntityInfoOuterClass.TeamEntityInfo> getTeamEntityInfoListList() {
                if (this.teamEntityInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.teamEntityInfoList_);
                }
                return this.teamEntityInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
            public int getTeamEntityInfoListCount() {
                if (this.teamEntityInfoListBuilder_ == null) {
                    return this.teamEntityInfoList_.size();
                }
                return this.teamEntityInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
            public TeamEntityInfoOuterClass.TeamEntityInfo getTeamEntityInfoList(int index) {
                if (this.teamEntityInfoListBuilder_ == null) {
                    return this.teamEntityInfoList_.get(index);
                }
                return this.teamEntityInfoListBuilder_.getMessage(index);
            }

            public Builder setTeamEntityInfoList(int index, TeamEntityInfoOuterClass.TeamEntityInfo value) {
                if (this.teamEntityInfoListBuilder_ != null) {
                    this.teamEntityInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTeamEntityInfoListIsMutable();
                    this.teamEntityInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTeamEntityInfoList(int index, TeamEntityInfoOuterClass.TeamEntityInfo.Builder builderForValue) {
                if (this.teamEntityInfoListBuilder_ == null) {
                    ensureTeamEntityInfoListIsMutable();
                    this.teamEntityInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.teamEntityInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTeamEntityInfoList(TeamEntityInfoOuterClass.TeamEntityInfo value) {
                if (this.teamEntityInfoListBuilder_ != null) {
                    this.teamEntityInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTeamEntityInfoListIsMutable();
                    this.teamEntityInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTeamEntityInfoList(int index, TeamEntityInfoOuterClass.TeamEntityInfo value) {
                if (this.teamEntityInfoListBuilder_ != null) {
                    this.teamEntityInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTeamEntityInfoListIsMutable();
                    this.teamEntityInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTeamEntityInfoList(TeamEntityInfoOuterClass.TeamEntityInfo.Builder builderForValue) {
                if (this.teamEntityInfoListBuilder_ == null) {
                    ensureTeamEntityInfoListIsMutable();
                    this.teamEntityInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.teamEntityInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTeamEntityInfoList(int index, TeamEntityInfoOuterClass.TeamEntityInfo.Builder builderForValue) {
                if (this.teamEntityInfoListBuilder_ == null) {
                    ensureTeamEntityInfoListIsMutable();
                    this.teamEntityInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.teamEntityInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTeamEntityInfoList(Iterable<? extends TeamEntityInfoOuterClass.TeamEntityInfo> values) {
                if (this.teamEntityInfoListBuilder_ == null) {
                    ensureTeamEntityInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.teamEntityInfoList_);
                    onChanged();
                } else {
                    this.teamEntityInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTeamEntityInfoList() {
                if (this.teamEntityInfoListBuilder_ == null) {
                    this.teamEntityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.teamEntityInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTeamEntityInfoList(int index) {
                if (this.teamEntityInfoListBuilder_ == null) {
                    ensureTeamEntityInfoListIsMutable();
                    this.teamEntityInfoList_.remove(index);
                    onChanged();
                } else {
                    this.teamEntityInfoListBuilder_.remove(index);
                }
                return this;
            }

            public TeamEntityInfoOuterClass.TeamEntityInfo.Builder getTeamEntityInfoListBuilder(int index) {
                return getTeamEntityInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
            public TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder getTeamEntityInfoListOrBuilder(int index) {
                if (this.teamEntityInfoListBuilder_ == null) {
                    return this.teamEntityInfoList_.get(index);
                }
                return this.teamEntityInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
            public List<? extends TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder> getTeamEntityInfoListOrBuilderList() {
                if (this.teamEntityInfoListBuilder_ != null) {
                    return this.teamEntityInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.teamEntityInfoList_);
            }

            public TeamEntityInfoOuterClass.TeamEntityInfo.Builder addTeamEntityInfoListBuilder() {
                return getTeamEntityInfoListFieldBuilder().addBuilder(TeamEntityInfoOuterClass.TeamEntityInfo.getDefaultInstance());
            }

            public TeamEntityInfoOuterClass.TeamEntityInfo.Builder addTeamEntityInfoListBuilder(int index) {
                return getTeamEntityInfoListFieldBuilder().addBuilder(index, TeamEntityInfoOuterClass.TeamEntityInfo.getDefaultInstance());
            }

            public List<TeamEntityInfoOuterClass.TeamEntityInfo.Builder> getTeamEntityInfoListBuilderList() {
                return getTeamEntityInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TeamEntityInfoOuterClass.TeamEntityInfo, TeamEntityInfoOuterClass.TeamEntityInfo.Builder, TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder> getTeamEntityInfoListFieldBuilder() {
                if (this.teamEntityInfoListBuilder_ == null) {
                    this.teamEntityInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.teamEntityInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.teamEntityInfoList_ = null;
                }
                return this.teamEntityInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotifyOrBuilder
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

        public static SyncTeamEntityNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SyncTeamEntityNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SyncTeamEntityNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SyncTeamEntityNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TeamEntityInfoOuterClass.getDescriptor();
    }
}
