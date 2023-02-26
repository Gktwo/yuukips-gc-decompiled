package emu.grasscutter.net.proto;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.FriendBriefOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AskAddFriendNotifyOuterClass.class */
public final class AskAddFriendNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018AskAddFriendNotify.proto\u001a\u0011FriendBrief.proto\"P\n\u0012AskAddFriendNotify\u0012'\n\u0011targetFriendBrief\u0018\u0007 \u0001(\u000b2\f.FriendBrief\u0012\u0011\n\ttargetUid\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FriendBriefOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AskAddFriendNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AskAddFriendNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AskAddFriendNotify_descriptor, new String[]{"TargetFriendBrief", "TargetUid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AskAddFriendNotifyOuterClass$AskAddFriendNotifyOrBuilder.class */
    public interface AskAddFriendNotifyOrBuilder extends MessageOrBuilder {
        boolean hasTargetFriendBrief();

        FriendBriefOuterClass.FriendBrief getTargetFriendBrief();

        FriendBriefOuterClass.FriendBriefOrBuilder getTargetFriendBriefOrBuilder();

        int getTargetUid();
    }

    private AskAddFriendNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AskAddFriendNotifyOuterClass$AskAddFriendNotify.class */
    public static final class AskAddFriendNotify extends GeneratedMessageV3 implements AskAddFriendNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TARGETFRIENDBRIEF_FIELD_NUMBER = 7;
        private FriendBriefOuterClass.FriendBrief targetFriendBrief_;
        public static final int TARGETUID_FIELD_NUMBER = 8;
        private int targetUid_;
        private byte memoizedIsInitialized;
        private static final AskAddFriendNotify DEFAULT_INSTANCE = new AskAddFriendNotify();
        private static final Parser<AskAddFriendNotify> PARSER = new AbstractParser<AskAddFriendNotify>() { // from class: emu.grasscutter.net.proto.AskAddFriendNotifyOuterClass.AskAddFriendNotify.1
            @Override // com.google.protobuf.Parser
            public AskAddFriendNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AskAddFriendNotify(input, extensionRegistry);
            }
        };

        private AskAddFriendNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AskAddFriendNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AskAddFriendNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AskAddFriendNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
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
                                case 58:
                                    FriendBriefOuterClass.FriendBrief.Builder subBuilder = this.targetFriendBrief_ != null ? this.targetFriendBrief_.toBuilder() : null;
                                    this.targetFriendBrief_ = (FriendBriefOuterClass.FriendBrief) input.readMessage(FriendBriefOuterClass.FriendBrief.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.targetFriendBrief_);
                                        this.targetFriendBrief_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 64:
                                    this.targetUid_ = input.readUInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AskAddFriendNotifyOuterClass.internal_static_AskAddFriendNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AskAddFriendNotifyOuterClass.internal_static_AskAddFriendNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AskAddFriendNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AskAddFriendNotifyOuterClass.AskAddFriendNotifyOrBuilder
        public boolean hasTargetFriendBrief() {
            return this.targetFriendBrief_ != null;
        }

        @Override // emu.grasscutter.net.proto.AskAddFriendNotifyOuterClass.AskAddFriendNotifyOrBuilder
        public FriendBriefOuterClass.FriendBrief getTargetFriendBrief() {
            return this.targetFriendBrief_ == null ? FriendBriefOuterClass.FriendBrief.getDefaultInstance() : this.targetFriendBrief_;
        }

        @Override // emu.grasscutter.net.proto.AskAddFriendNotifyOuterClass.AskAddFriendNotifyOrBuilder
        public FriendBriefOuterClass.FriendBriefOrBuilder getTargetFriendBriefOrBuilder() {
            return getTargetFriendBrief();
        }

        @Override // emu.grasscutter.net.proto.AskAddFriendNotifyOuterClass.AskAddFriendNotifyOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
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
            if (this.targetFriendBrief_ != null) {
                output.writeMessage(7, getTargetFriendBrief());
            }
            if (this.targetUid_ != 0) {
                output.writeUInt32(8, this.targetUid_);
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
            if (this.targetFriendBrief_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(7, getTargetFriendBrief());
            }
            if (this.targetUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.targetUid_);
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
            if (!(obj instanceof AskAddFriendNotify)) {
                return equals(obj);
            }
            AskAddFriendNotify other = (AskAddFriendNotify) obj;
            if (hasTargetFriendBrief() != other.hasTargetFriendBrief()) {
                return false;
            }
            return (!hasTargetFriendBrief() || getTargetFriendBrief().equals(other.getTargetFriendBrief())) && getTargetUid() == other.getTargetUid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasTargetFriendBrief()) {
                hash = (53 * ((37 * hash) + 7)) + getTargetFriendBrief().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 8)) + getTargetUid())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AskAddFriendNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AskAddFriendNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AskAddFriendNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AskAddFriendNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AskAddFriendNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AskAddFriendNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AskAddFriendNotify parseFrom(InputStream input) throws IOException {
            return (AskAddFriendNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AskAddFriendNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AskAddFriendNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AskAddFriendNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AskAddFriendNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AskAddFriendNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AskAddFriendNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AskAddFriendNotify parseFrom(CodedInputStream input) throws IOException {
            return (AskAddFriendNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AskAddFriendNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AskAddFriendNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AskAddFriendNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AskAddFriendNotifyOuterClass$AskAddFriendNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AskAddFriendNotifyOrBuilder {
            private FriendBriefOuterClass.FriendBrief targetFriendBrief_;
            private SingleFieldBuilderV3<FriendBriefOuterClass.FriendBrief, FriendBriefOuterClass.FriendBrief.Builder, FriendBriefOuterClass.FriendBriefOrBuilder> targetFriendBriefBuilder_;
            private int targetUid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AskAddFriendNotifyOuterClass.internal_static_AskAddFriendNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AskAddFriendNotifyOuterClass.internal_static_AskAddFriendNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AskAddFriendNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AskAddFriendNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.targetFriendBriefBuilder_ == null) {
                    this.targetFriendBrief_ = null;
                } else {
                    this.targetFriendBrief_ = null;
                    this.targetFriendBriefBuilder_ = null;
                }
                this.targetUid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AskAddFriendNotifyOuterClass.internal_static_AskAddFriendNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AskAddFriendNotify getDefaultInstanceForType() {
                return AskAddFriendNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AskAddFriendNotify build() {
                AskAddFriendNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AskAddFriendNotify buildPartial() {
                AskAddFriendNotify result = new AskAddFriendNotify(this);
                if (this.targetFriendBriefBuilder_ == null) {
                    result.targetFriendBrief_ = this.targetFriendBrief_;
                } else {
                    result.targetFriendBrief_ = this.targetFriendBriefBuilder_.build();
                }
                result.targetUid_ = this.targetUid_;
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
                if (other instanceof AskAddFriendNotify) {
                    return mergeFrom((AskAddFriendNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AskAddFriendNotify other) {
                if (other == AskAddFriendNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasTargetFriendBrief()) {
                    mergeTargetFriendBrief(other.getTargetFriendBrief());
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
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
                AskAddFriendNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AskAddFriendNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AskAddFriendNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AskAddFriendNotifyOuterClass.AskAddFriendNotifyOrBuilder
            public boolean hasTargetFriendBrief() {
                return (this.targetFriendBriefBuilder_ == null && this.targetFriendBrief_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AskAddFriendNotifyOuterClass.AskAddFriendNotifyOrBuilder
            public FriendBriefOuterClass.FriendBrief getTargetFriendBrief() {
                if (this.targetFriendBriefBuilder_ == null) {
                    return this.targetFriendBrief_ == null ? FriendBriefOuterClass.FriendBrief.getDefaultInstance() : this.targetFriendBrief_;
                }
                return this.targetFriendBriefBuilder_.getMessage();
            }

            public Builder setTargetFriendBrief(FriendBriefOuterClass.FriendBrief value) {
                if (this.targetFriendBriefBuilder_ != null) {
                    this.targetFriendBriefBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.targetFriendBrief_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setTargetFriendBrief(FriendBriefOuterClass.FriendBrief.Builder builderForValue) {
                if (this.targetFriendBriefBuilder_ == null) {
                    this.targetFriendBrief_ = builderForValue.build();
                    onChanged();
                } else {
                    this.targetFriendBriefBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeTargetFriendBrief(FriendBriefOuterClass.FriendBrief value) {
                if (this.targetFriendBriefBuilder_ == null) {
                    if (this.targetFriendBrief_ != null) {
                        this.targetFriendBrief_ = FriendBriefOuterClass.FriendBrief.newBuilder(this.targetFriendBrief_).mergeFrom(value).buildPartial();
                    } else {
                        this.targetFriendBrief_ = value;
                    }
                    onChanged();
                } else {
                    this.targetFriendBriefBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearTargetFriendBrief() {
                if (this.targetFriendBriefBuilder_ == null) {
                    this.targetFriendBrief_ = null;
                    onChanged();
                } else {
                    this.targetFriendBrief_ = null;
                    this.targetFriendBriefBuilder_ = null;
                }
                return this;
            }

            public FriendBriefOuterClass.FriendBrief.Builder getTargetFriendBriefBuilder() {
                onChanged();
                return getTargetFriendBriefFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AskAddFriendNotifyOuterClass.AskAddFriendNotifyOrBuilder
            public FriendBriefOuterClass.FriendBriefOrBuilder getTargetFriendBriefOrBuilder() {
                if (this.targetFriendBriefBuilder_ != null) {
                    return this.targetFriendBriefBuilder_.getMessageOrBuilder();
                }
                return this.targetFriendBrief_ == null ? FriendBriefOuterClass.FriendBrief.getDefaultInstance() : this.targetFriendBrief_;
            }

            private SingleFieldBuilderV3<FriendBriefOuterClass.FriendBrief, FriendBriefOuterClass.FriendBrief.Builder, FriendBriefOuterClass.FriendBriefOrBuilder> getTargetFriendBriefFieldBuilder() {
                if (this.targetFriendBriefBuilder_ == null) {
                    this.targetFriendBriefBuilder_ = new SingleFieldBuilderV3<>(getTargetFriendBrief(), getParentForChildren(), isClean());
                    this.targetFriendBrief_ = null;
                }
                return this.targetFriendBriefBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AskAddFriendNotifyOuterClass.AskAddFriendNotifyOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
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

        public static AskAddFriendNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AskAddFriendNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AskAddFriendNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AskAddFriendNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FriendBriefOuterClass.getDescriptor();
    }
}
