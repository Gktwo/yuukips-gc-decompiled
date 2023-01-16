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
import emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldSceneInfoListNotifyOuterClass.class */
public final class PlayerWorldSceneInfoListNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$PlayerWorldSceneInfoListNotify.proto\u001a\u001aPlayerWorldSceneInfo.proto\"J\n\u001ePlayerWorldSceneInfoListNotify\u0012(\n\tinfo_list\u0018\u0002 \u0003(\u000b2\u0015.PlayerWorldSceneInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlayerWorldSceneInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerWorldSceneInfoListNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_PlayerWorldSceneInfoListNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f832x8845778d = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerWorldSceneInfoListNotify_descriptor, new String[]{"InfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldSceneInfoListNotifyOuterClass$PlayerWorldSceneInfoListNotifyOrBuilder.class */
    public interface PlayerWorldSceneInfoListNotifyOrBuilder extends MessageOrBuilder {
        List<PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo> getInfoListList();

        PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo getInfoList(int i);

        int getInfoListCount();

        List<? extends PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder> getInfoListOrBuilderList();

        PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder getInfoListOrBuilder(int i);
    }

    private PlayerWorldSceneInfoListNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldSceneInfoListNotifyOuterClass$PlayerWorldSceneInfoListNotify.class */
    public static final class PlayerWorldSceneInfoListNotify extends GeneratedMessageV3 implements PlayerWorldSceneInfoListNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INFO_LIST_FIELD_NUMBER = 2;
        private List<PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo> infoList_;
        private byte memoizedIsInitialized;
        private static final PlayerWorldSceneInfoListNotify DEFAULT_INSTANCE = new PlayerWorldSceneInfoListNotify();
        private static final Parser<PlayerWorldSceneInfoListNotify> PARSER = new AbstractParser<PlayerWorldSceneInfoListNotify>() { // from class: emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerWorldSceneInfoListNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerWorldSceneInfoListNotify(input, extensionRegistry);
            }
        };

        private PlayerWorldSceneInfoListNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerWorldSceneInfoListNotify() {
            this.memoizedIsInitialized = -1;
            this.infoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerWorldSceneInfoListNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerWorldSceneInfoListNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.infoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.infoList_.add((PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo) input.readMessage(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.parser(), extensionRegistry));
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
                    this.infoList_ = Collections.unmodifiableList(this.infoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerWorldSceneInfoListNotifyOuterClass.internal_static_PlayerWorldSceneInfoListNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerWorldSceneInfoListNotifyOuterClass.f832x8845778d.ensureFieldAccessorsInitialized(PlayerWorldSceneInfoListNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotifyOrBuilder
        public List<PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo> getInfoListList() {
            return this.infoList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotifyOrBuilder
        public List<? extends PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder> getInfoListOrBuilderList() {
            return this.infoList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotifyOrBuilder
        public int getInfoListCount() {
            return this.infoList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotifyOrBuilder
        public PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo getInfoList(int index) {
            return this.infoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotifyOrBuilder
        public PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder getInfoListOrBuilder(int index) {
            return this.infoList_.get(index);
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
            for (int i = 0; i < this.infoList_.size(); i++) {
                output.writeMessage(2, this.infoList_.get(i));
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
            for (int i = 0; i < this.infoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.infoList_.get(i));
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
            if (!(obj instanceof PlayerWorldSceneInfoListNotify)) {
                return equals(obj);
            }
            PlayerWorldSceneInfoListNotify other = (PlayerWorldSceneInfoListNotify) obj;
            return getInfoListList().equals(other.getInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerWorldSceneInfoListNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWorldSceneInfoListNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWorldSceneInfoListNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWorldSceneInfoListNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWorldSceneInfoListNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWorldSceneInfoListNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWorldSceneInfoListNotify parseFrom(InputStream input) throws IOException {
            return (PlayerWorldSceneInfoListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerWorldSceneInfoListNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWorldSceneInfoListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerWorldSceneInfoListNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerWorldSceneInfoListNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerWorldSceneInfoListNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWorldSceneInfoListNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerWorldSceneInfoListNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerWorldSceneInfoListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerWorldSceneInfoListNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWorldSceneInfoListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerWorldSceneInfoListNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldSceneInfoListNotifyOuterClass$PlayerWorldSceneInfoListNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerWorldSceneInfoListNotifyOrBuilder {
            private int bitField0_;
            private List<PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo> infoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo, PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder, PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder> infoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerWorldSceneInfoListNotifyOuterClass.internal_static_PlayerWorldSceneInfoListNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerWorldSceneInfoListNotifyOuterClass.f832x8845778d.ensureFieldAccessorsInitialized(PlayerWorldSceneInfoListNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerWorldSceneInfoListNotify.alwaysUseFieldBuilders) {
                    getInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.infoListBuilder_ == null) {
                    this.infoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.infoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerWorldSceneInfoListNotifyOuterClass.internal_static_PlayerWorldSceneInfoListNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerWorldSceneInfoListNotify getDefaultInstanceForType() {
                return PlayerWorldSceneInfoListNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerWorldSceneInfoListNotify build() {
                PlayerWorldSceneInfoListNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerWorldSceneInfoListNotify buildPartial() {
                PlayerWorldSceneInfoListNotify result = new PlayerWorldSceneInfoListNotify(this);
                int i = this.bitField0_;
                if (this.infoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.infoList_ = Collections.unmodifiableList(this.infoList_);
                        this.bitField0_ &= -2;
                    }
                    result.infoList_ = this.infoList_;
                } else {
                    result.infoList_ = this.infoListBuilder_.build();
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
                if (other instanceof PlayerWorldSceneInfoListNotify) {
                    return mergeFrom((PlayerWorldSceneInfoListNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerWorldSceneInfoListNotify other) {
                if (other == PlayerWorldSceneInfoListNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.infoListBuilder_ == null) {
                    if (!other.infoList_.isEmpty()) {
                        if (this.infoList_.isEmpty()) {
                            this.infoList_ = other.infoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureInfoListIsMutable();
                            this.infoList_.addAll(other.infoList_);
                        }
                        onChanged();
                    }
                } else if (!other.infoList_.isEmpty()) {
                    if (this.infoListBuilder_.isEmpty()) {
                        this.infoListBuilder_.dispose();
                        this.infoListBuilder_ = null;
                        this.infoList_ = other.infoList_;
                        this.bitField0_ &= -2;
                        this.infoListBuilder_ = PlayerWorldSceneInfoListNotify.alwaysUseFieldBuilders ? getInfoListFieldBuilder() : null;
                    } else {
                        this.infoListBuilder_.addAllMessages(other.infoList_);
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
                PlayerWorldSceneInfoListNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerWorldSceneInfoListNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerWorldSceneInfoListNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.infoList_ = new ArrayList(this.infoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotifyOrBuilder
            public List<PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo> getInfoListList() {
                if (this.infoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.infoList_);
                }
                return this.infoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotifyOrBuilder
            public int getInfoListCount() {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.size();
                }
                return this.infoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotifyOrBuilder
            public PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo getInfoList(int index) {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.get(index);
                }
                return this.infoListBuilder_.getMessage(index);
            }

            public Builder setInfoList(int index, PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setInfoList(int index, PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addInfoList(int index, PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addInfoList(int index, PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllInfoList(Iterable<? extends PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo> values) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.infoList_);
                    onChanged();
                } else {
                    this.infoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearInfoList() {
                if (this.infoListBuilder_ == null) {
                    this.infoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.infoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeInfoList(int index) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.remove(index);
                    onChanged();
                } else {
                    this.infoListBuilder_.remove(index);
                }
                return this;
            }

            public PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder getInfoListBuilder(int index) {
                return getInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotifyOrBuilder
            public PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder getInfoListOrBuilder(int index) {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.get(index);
                }
                return this.infoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotifyOrBuilder
            public List<? extends PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder> getInfoListOrBuilderList() {
                if (this.infoListBuilder_ != null) {
                    return this.infoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.infoList_);
            }

            public PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder addInfoListBuilder() {
                return getInfoListFieldBuilder().addBuilder(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.getDefaultInstance());
            }

            public PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder addInfoListBuilder(int index) {
                return getInfoListFieldBuilder().addBuilder(index, PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.getDefaultInstance());
            }

            public List<PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder> getInfoListBuilderList() {
                return getInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo, PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder, PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder> getInfoListFieldBuilder() {
                if (this.infoListBuilder_ == null) {
                    this.infoListBuilder_ = new RepeatedFieldBuilderV3<>(this.infoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.infoList_ = null;
                }
                return this.infoListBuilder_;
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

        public static PlayerWorldSceneInfoListNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerWorldSceneInfoListNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerWorldSceneInfoListNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerWorldSceneInfoListNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlayerWorldSceneInfoOuterClass.getDescriptor();
    }
}
