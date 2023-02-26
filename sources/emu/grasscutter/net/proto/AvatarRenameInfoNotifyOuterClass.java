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
import emu.grasscutter.net.proto.AvatarRenameInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarRenameInfoNotifyOuterClass.class */
public final class AvatarRenameInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cAvatarRenameInfoNotify.proto\u001a\u0016AvatarRenameInfo.proto\"E\n\u0016AvatarRenameInfoNotify\u0012+\n\u0010avatarRenameList\u0018\f \u0003(\u000b2\u0011.AvatarRenameInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarRenameInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarRenameInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarRenameInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarRenameInfoNotify_descriptor, new String[]{"AvatarRenameList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarRenameInfoNotifyOuterClass$AvatarRenameInfoNotifyOrBuilder.class */
    public interface AvatarRenameInfoNotifyOrBuilder extends MessageOrBuilder {
        List<AvatarRenameInfoOuterClass.AvatarRenameInfo> getAvatarRenameListList();

        AvatarRenameInfoOuterClass.AvatarRenameInfo getAvatarRenameList(int i);

        int getAvatarRenameListCount();

        List<? extends AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder> getAvatarRenameListOrBuilderList();

        AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder getAvatarRenameListOrBuilder(int i);
    }

    private AvatarRenameInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarRenameInfoNotifyOuterClass$AvatarRenameInfoNotify.class */
    public static final class AvatarRenameInfoNotify extends GeneratedMessageV3 implements AvatarRenameInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARRENAMELIST_FIELD_NUMBER = 12;
        private List<AvatarRenameInfoOuterClass.AvatarRenameInfo> avatarRenameList_;
        private byte memoizedIsInitialized;
        private static final AvatarRenameInfoNotify DEFAULT_INSTANCE = new AvatarRenameInfoNotify();
        private static final Parser<AvatarRenameInfoNotify> PARSER = new AbstractParser<AvatarRenameInfoNotify>() { // from class: emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarRenameInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarRenameInfoNotify(input, extensionRegistry);
            }
        };

        private AvatarRenameInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarRenameInfoNotify() {
            this.memoizedIsInitialized = -1;
            this.avatarRenameList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarRenameInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarRenameInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 98:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.avatarRenameList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.avatarRenameList_.add((AvatarRenameInfoOuterClass.AvatarRenameInfo) input.readMessage(AvatarRenameInfoOuterClass.AvatarRenameInfo.parser(), extensionRegistry));
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
                    this.avatarRenameList_ = Collections.unmodifiableList(this.avatarRenameList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarRenameInfoNotifyOuterClass.internal_static_AvatarRenameInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarRenameInfoNotifyOuterClass.internal_static_AvatarRenameInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarRenameInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotifyOrBuilder
        public List<AvatarRenameInfoOuterClass.AvatarRenameInfo> getAvatarRenameListList() {
            return this.avatarRenameList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotifyOrBuilder
        public List<? extends AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder> getAvatarRenameListOrBuilderList() {
            return this.avatarRenameList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotifyOrBuilder
        public int getAvatarRenameListCount() {
            return this.avatarRenameList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotifyOrBuilder
        public AvatarRenameInfoOuterClass.AvatarRenameInfo getAvatarRenameList(int index) {
            return this.avatarRenameList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotifyOrBuilder
        public AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder getAvatarRenameListOrBuilder(int index) {
            return this.avatarRenameList_.get(index);
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
            for (int i = 0; i < this.avatarRenameList_.size(); i++) {
                output.writeMessage(12, this.avatarRenameList_.get(i));
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
            for (int i = 0; i < this.avatarRenameList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.avatarRenameList_.get(i));
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
            if (!(obj instanceof AvatarRenameInfoNotify)) {
                return equals(obj);
            }
            AvatarRenameInfoNotify other = (AvatarRenameInfoNotify) obj;
            return getAvatarRenameListList().equals(other.getAvatarRenameListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAvatarRenameListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getAvatarRenameListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarRenameInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarRenameInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarRenameInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarRenameInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarRenameInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarRenameInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarRenameInfoNotify parseFrom(InputStream input) throws IOException {
            return (AvatarRenameInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarRenameInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarRenameInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarRenameInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarRenameInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarRenameInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarRenameInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarRenameInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarRenameInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarRenameInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarRenameInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarRenameInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarRenameInfoNotifyOuterClass$AvatarRenameInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarRenameInfoNotifyOrBuilder {
            private int bitField0_;
            private List<AvatarRenameInfoOuterClass.AvatarRenameInfo> avatarRenameList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AvatarRenameInfoOuterClass.AvatarRenameInfo, AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder, AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder> avatarRenameListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarRenameInfoNotifyOuterClass.internal_static_AvatarRenameInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarRenameInfoNotifyOuterClass.internal_static_AvatarRenameInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarRenameInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarRenameInfoNotify.alwaysUseFieldBuilders) {
                    getAvatarRenameListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.avatarRenameListBuilder_ == null) {
                    this.avatarRenameList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.avatarRenameListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarRenameInfoNotifyOuterClass.internal_static_AvatarRenameInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarRenameInfoNotify getDefaultInstanceForType() {
                return AvatarRenameInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarRenameInfoNotify build() {
                AvatarRenameInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarRenameInfoNotify buildPartial() {
                AvatarRenameInfoNotify result = new AvatarRenameInfoNotify(this);
                int i = this.bitField0_;
                if (this.avatarRenameListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.avatarRenameList_ = Collections.unmodifiableList(this.avatarRenameList_);
                        this.bitField0_ &= -2;
                    }
                    result.avatarRenameList_ = this.avatarRenameList_;
                } else {
                    result.avatarRenameList_ = this.avatarRenameListBuilder_.build();
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
                if (other instanceof AvatarRenameInfoNotify) {
                    return mergeFrom((AvatarRenameInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarRenameInfoNotify other) {
                if (other == AvatarRenameInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.avatarRenameListBuilder_ == null) {
                    if (!other.avatarRenameList_.isEmpty()) {
                        if (this.avatarRenameList_.isEmpty()) {
                            this.avatarRenameList_ = other.avatarRenameList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAvatarRenameListIsMutable();
                            this.avatarRenameList_.addAll(other.avatarRenameList_);
                        }
                        onChanged();
                    }
                } else if (!other.avatarRenameList_.isEmpty()) {
                    if (this.avatarRenameListBuilder_.isEmpty()) {
                        this.avatarRenameListBuilder_.dispose();
                        this.avatarRenameListBuilder_ = null;
                        this.avatarRenameList_ = other.avatarRenameList_;
                        this.bitField0_ &= -2;
                        this.avatarRenameListBuilder_ = AvatarRenameInfoNotify.alwaysUseFieldBuilders ? getAvatarRenameListFieldBuilder() : null;
                    } else {
                        this.avatarRenameListBuilder_.addAllMessages(other.avatarRenameList_);
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
                AvatarRenameInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarRenameInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarRenameInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAvatarRenameListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarRenameList_ = new ArrayList(this.avatarRenameList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotifyOrBuilder
            public List<AvatarRenameInfoOuterClass.AvatarRenameInfo> getAvatarRenameListList() {
                if (this.avatarRenameListBuilder_ == null) {
                    return Collections.unmodifiableList(this.avatarRenameList_);
                }
                return this.avatarRenameListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotifyOrBuilder
            public int getAvatarRenameListCount() {
                if (this.avatarRenameListBuilder_ == null) {
                    return this.avatarRenameList_.size();
                }
                return this.avatarRenameListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotifyOrBuilder
            public AvatarRenameInfoOuterClass.AvatarRenameInfo getAvatarRenameList(int index) {
                if (this.avatarRenameListBuilder_ == null) {
                    return this.avatarRenameList_.get(index);
                }
                return this.avatarRenameListBuilder_.getMessage(index);
            }

            public Builder setAvatarRenameList(int index, AvatarRenameInfoOuterClass.AvatarRenameInfo value) {
                if (this.avatarRenameListBuilder_ != null) {
                    this.avatarRenameListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarRenameList(int index, AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder builderForValue) {
                if (this.avatarRenameListBuilder_ == null) {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarRenameList(AvatarRenameInfoOuterClass.AvatarRenameInfo value) {
                if (this.avatarRenameListBuilder_ != null) {
                    this.avatarRenameListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarRenameList(int index, AvatarRenameInfoOuterClass.AvatarRenameInfo value) {
                if (this.avatarRenameListBuilder_ != null) {
                    this.avatarRenameListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarRenameList(AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder builderForValue) {
                if (this.avatarRenameListBuilder_ == null) {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarRenameList(int index, AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder builderForValue) {
                if (this.avatarRenameListBuilder_ == null) {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatarRenameList(Iterable<? extends AvatarRenameInfoOuterClass.AvatarRenameInfo> values) {
                if (this.avatarRenameListBuilder_ == null) {
                    ensureAvatarRenameListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarRenameList_);
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatarRenameList() {
                if (this.avatarRenameListBuilder_ == null) {
                    this.avatarRenameList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatarRenameList(int index) {
                if (this.avatarRenameListBuilder_ == null) {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.remove(index);
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.remove(index);
                }
                return this;
            }

            public AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder getAvatarRenameListBuilder(int index) {
                return getAvatarRenameListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotifyOrBuilder
            public AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder getAvatarRenameListOrBuilder(int index) {
                if (this.avatarRenameListBuilder_ == null) {
                    return this.avatarRenameList_.get(index);
                }
                return this.avatarRenameListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarRenameInfoNotifyOuterClass.AvatarRenameInfoNotifyOrBuilder
            public List<? extends AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder> getAvatarRenameListOrBuilderList() {
                if (this.avatarRenameListBuilder_ != null) {
                    return this.avatarRenameListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.avatarRenameList_);
            }

            public AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder addAvatarRenameListBuilder() {
                return getAvatarRenameListFieldBuilder().addBuilder(AvatarRenameInfoOuterClass.AvatarRenameInfo.getDefaultInstance());
            }

            public AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder addAvatarRenameListBuilder(int index) {
                return getAvatarRenameListFieldBuilder().addBuilder(index, AvatarRenameInfoOuterClass.AvatarRenameInfo.getDefaultInstance());
            }

            public List<AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder> getAvatarRenameListBuilderList() {
                return getAvatarRenameListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AvatarRenameInfoOuterClass.AvatarRenameInfo, AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder, AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder> getAvatarRenameListFieldBuilder() {
                if (this.avatarRenameListBuilder_ == null) {
                    this.avatarRenameListBuilder_ = new RepeatedFieldBuilderV3<>(this.avatarRenameList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.avatarRenameList_ = null;
                }
                return this.avatarRenameListBuilder_;
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

        public static AvatarRenameInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarRenameInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarRenameInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarRenameInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarRenameInfoOuterClass.getDescriptor();
    }
}
