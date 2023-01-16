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
import emu.grasscutter.net.proto.ScenePlayerInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerInfoNotifyOuterClass.class */
public final class ScenePlayerInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bScenePlayerInfoNotify.proto\u001a\u0015ScenePlayerInfo.proto\"C\n\u0015ScenePlayerInfoNotify\u0012*\n\u0010player_info_list\u0018\u000b \u0003(\u000b2\u0010.ScenePlayerInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ScenePlayerInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ScenePlayerInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ScenePlayerInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ScenePlayerInfoNotify_descriptor, new String[]{"PlayerInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerInfoNotifyOuterClass$ScenePlayerInfoNotifyOrBuilder.class */
    public interface ScenePlayerInfoNotifyOrBuilder extends MessageOrBuilder {
        List<ScenePlayerInfoOuterClass.ScenePlayerInfo> getPlayerInfoListList();

        ScenePlayerInfoOuterClass.ScenePlayerInfo getPlayerInfoList(int i);

        int getPlayerInfoListCount();

        List<? extends ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder> getPlayerInfoListOrBuilderList();

        ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder getPlayerInfoListOrBuilder(int i);
    }

    private ScenePlayerInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerInfoNotifyOuterClass$ScenePlayerInfoNotify.class */
    public static final class ScenePlayerInfoNotify extends GeneratedMessageV3 implements ScenePlayerInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PLAYER_INFO_LIST_FIELD_NUMBER = 11;
        private List<ScenePlayerInfoOuterClass.ScenePlayerInfo> playerInfoList_;
        private byte memoizedIsInitialized;
        private static final ScenePlayerInfoNotify DEFAULT_INSTANCE = new ScenePlayerInfoNotify();
        private static final Parser<ScenePlayerInfoNotify> PARSER = new AbstractParser<ScenePlayerInfoNotify>() { // from class: emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotify.1
            @Override // com.google.protobuf.Parser
            public ScenePlayerInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ScenePlayerInfoNotify(input, extensionRegistry);
            }
        };

        private ScenePlayerInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ScenePlayerInfoNotify() {
            this.memoizedIsInitialized = -1;
            this.playerInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ScenePlayerInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ScenePlayerInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 90:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.playerInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.playerInfoList_.add((ScenePlayerInfoOuterClass.ScenePlayerInfo) input.readMessage(ScenePlayerInfoOuterClass.ScenePlayerInfo.parser(), extensionRegistry));
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
                    this.playerInfoList_ = Collections.unmodifiableList(this.playerInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ScenePlayerInfoNotifyOuterClass.internal_static_ScenePlayerInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ScenePlayerInfoNotifyOuterClass.internal_static_ScenePlayerInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ScenePlayerInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotifyOrBuilder
        public List<ScenePlayerInfoOuterClass.ScenePlayerInfo> getPlayerInfoListList() {
            return this.playerInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotifyOrBuilder
        public List<? extends ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder> getPlayerInfoListOrBuilderList() {
            return this.playerInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotifyOrBuilder
        public int getPlayerInfoListCount() {
            return this.playerInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotifyOrBuilder
        public ScenePlayerInfoOuterClass.ScenePlayerInfo getPlayerInfoList(int index) {
            return this.playerInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotifyOrBuilder
        public ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder getPlayerInfoListOrBuilder(int index) {
            return this.playerInfoList_.get(index);
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
            for (int i = 0; i < this.playerInfoList_.size(); i++) {
                output.writeMessage(11, this.playerInfoList_.get(i));
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
            for (int i = 0; i < this.playerInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.playerInfoList_.get(i));
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
            if (!(obj instanceof ScenePlayerInfoNotify)) {
                return equals(obj);
            }
            ScenePlayerInfoNotify other = (ScenePlayerInfoNotify) obj;
            return getPlayerInfoListList().equals(other.getPlayerInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getPlayerInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getPlayerInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ScenePlayerInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePlayerInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePlayerInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePlayerInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePlayerInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePlayerInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePlayerInfoNotify parseFrom(InputStream input) throws IOException {
            return (ScenePlayerInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ScenePlayerInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePlayerInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ScenePlayerInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ScenePlayerInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ScenePlayerInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePlayerInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ScenePlayerInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (ScenePlayerInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ScenePlayerInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePlayerInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ScenePlayerInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerInfoNotifyOuterClass$ScenePlayerInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ScenePlayerInfoNotifyOrBuilder {
            private int bitField0_;
            private List<ScenePlayerInfoOuterClass.ScenePlayerInfo> playerInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ScenePlayerInfoOuterClass.ScenePlayerInfo, ScenePlayerInfoOuterClass.ScenePlayerInfo.Builder, ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder> playerInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ScenePlayerInfoNotifyOuterClass.internal_static_ScenePlayerInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ScenePlayerInfoNotifyOuterClass.internal_static_ScenePlayerInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ScenePlayerInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ScenePlayerInfoNotify.alwaysUseFieldBuilders) {
                    getPlayerInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.playerInfoListBuilder_ == null) {
                    this.playerInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.playerInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ScenePlayerInfoNotifyOuterClass.internal_static_ScenePlayerInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ScenePlayerInfoNotify getDefaultInstanceForType() {
                return ScenePlayerInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ScenePlayerInfoNotify build() {
                ScenePlayerInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ScenePlayerInfoNotify buildPartial() {
                ScenePlayerInfoNotify result = new ScenePlayerInfoNotify(this);
                int i = this.bitField0_;
                if (this.playerInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.playerInfoList_ = Collections.unmodifiableList(this.playerInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.playerInfoList_ = this.playerInfoList_;
                } else {
                    result.playerInfoList_ = this.playerInfoListBuilder_.build();
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
                if (other instanceof ScenePlayerInfoNotify) {
                    return mergeFrom((ScenePlayerInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ScenePlayerInfoNotify other) {
                if (other == ScenePlayerInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.playerInfoListBuilder_ == null) {
                    if (!other.playerInfoList_.isEmpty()) {
                        if (this.playerInfoList_.isEmpty()) {
                            this.playerInfoList_ = other.playerInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePlayerInfoListIsMutable();
                            this.playerInfoList_.addAll(other.playerInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.playerInfoList_.isEmpty()) {
                    if (this.playerInfoListBuilder_.isEmpty()) {
                        this.playerInfoListBuilder_.dispose();
                        this.playerInfoListBuilder_ = null;
                        this.playerInfoList_ = other.playerInfoList_;
                        this.bitField0_ &= -2;
                        this.playerInfoListBuilder_ = ScenePlayerInfoNotify.alwaysUseFieldBuilders ? getPlayerInfoListFieldBuilder() : null;
                    } else {
                        this.playerInfoListBuilder_.addAllMessages(other.playerInfoList_);
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
                ScenePlayerInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ScenePlayerInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ScenePlayerInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensurePlayerInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.playerInfoList_ = new ArrayList(this.playerInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotifyOrBuilder
            public List<ScenePlayerInfoOuterClass.ScenePlayerInfo> getPlayerInfoListList() {
                if (this.playerInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.playerInfoList_);
                }
                return this.playerInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotifyOrBuilder
            public int getPlayerInfoListCount() {
                if (this.playerInfoListBuilder_ == null) {
                    return this.playerInfoList_.size();
                }
                return this.playerInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotifyOrBuilder
            public ScenePlayerInfoOuterClass.ScenePlayerInfo getPlayerInfoList(int index) {
                if (this.playerInfoListBuilder_ == null) {
                    return this.playerInfoList_.get(index);
                }
                return this.playerInfoListBuilder_.getMessage(index);
            }

            public Builder setPlayerInfoList(int index, ScenePlayerInfoOuterClass.ScenePlayerInfo value) {
                if (this.playerInfoListBuilder_ != null) {
                    this.playerInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerInfoList(int index, ScenePlayerInfoOuterClass.ScenePlayerInfo.Builder builderForValue) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerInfoList(ScenePlayerInfoOuterClass.ScenePlayerInfo value) {
                if (this.playerInfoListBuilder_ != null) {
                    this.playerInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerInfoList(int index, ScenePlayerInfoOuterClass.ScenePlayerInfo value) {
                if (this.playerInfoListBuilder_ != null) {
                    this.playerInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerInfoList(ScenePlayerInfoOuterClass.ScenePlayerInfo.Builder builderForValue) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerInfoList(int index, ScenePlayerInfoOuterClass.ScenePlayerInfo.Builder builderForValue) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPlayerInfoList(Iterable<? extends ScenePlayerInfoOuterClass.ScenePlayerInfo> values) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.playerInfoList_);
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPlayerInfoList() {
                if (this.playerInfoListBuilder_ == null) {
                    this.playerInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removePlayerInfoList(int index) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.remove(index);
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.remove(index);
                }
                return this;
            }

            public ScenePlayerInfoOuterClass.ScenePlayerInfo.Builder getPlayerInfoListBuilder(int index) {
                return getPlayerInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotifyOrBuilder
            public ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder getPlayerInfoListOrBuilder(int index) {
                if (this.playerInfoListBuilder_ == null) {
                    return this.playerInfoList_.get(index);
                }
                return this.playerInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerInfoNotifyOuterClass.ScenePlayerInfoNotifyOrBuilder
            public List<? extends ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder> getPlayerInfoListOrBuilderList() {
                if (this.playerInfoListBuilder_ != null) {
                    return this.playerInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.playerInfoList_);
            }

            public ScenePlayerInfoOuterClass.ScenePlayerInfo.Builder addPlayerInfoListBuilder() {
                return getPlayerInfoListFieldBuilder().addBuilder(ScenePlayerInfoOuterClass.ScenePlayerInfo.getDefaultInstance());
            }

            public ScenePlayerInfoOuterClass.ScenePlayerInfo.Builder addPlayerInfoListBuilder(int index) {
                return getPlayerInfoListFieldBuilder().addBuilder(index, ScenePlayerInfoOuterClass.ScenePlayerInfo.getDefaultInstance());
            }

            public List<ScenePlayerInfoOuterClass.ScenePlayerInfo.Builder> getPlayerInfoListBuilderList() {
                return getPlayerInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ScenePlayerInfoOuterClass.ScenePlayerInfo, ScenePlayerInfoOuterClass.ScenePlayerInfo.Builder, ScenePlayerInfoOuterClass.ScenePlayerInfoOrBuilder> getPlayerInfoListFieldBuilder() {
                if (this.playerInfoListBuilder_ == null) {
                    this.playerInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.playerInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.playerInfoList_ = null;
                }
                return this.playerInfoListBuilder_;
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

        public static ScenePlayerInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ScenePlayerInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ScenePlayerInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ScenePlayerInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ScenePlayerInfoOuterClass.getDescriptor();
    }
}
