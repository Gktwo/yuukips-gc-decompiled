package emu.grasscutter.net.proto;

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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarStandUpNotifyOuterClass.class */
public final class EvtAvatarStandUpNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cEvtAvatarStandUpNotify.proto\"a\n\u0016EvtAvatarStandUpNotify\u0012\u000f\n\u0007chairId\u0018\u000b \u0001(\u0004\u0012\u0011\n\tperformId\u0018\u000e \u0001(\u0005\u0012\u0011\n\tdirection\u0018\u0005 \u0001(\u0005\u0012\u0010\n\bentityId\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EvtAvatarStandUpNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EvtAvatarStandUpNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtAvatarStandUpNotify_descriptor, new String[]{"ChairId", "PerformId", "Direction", "EntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarStandUpNotifyOuterClass$EvtAvatarStandUpNotifyOrBuilder.class */
    public interface EvtAvatarStandUpNotifyOrBuilder extends MessageOrBuilder {
        long getChairId();

        int getPerformId();

        int getDirection();

        int getEntityId();
    }

    private EvtAvatarStandUpNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarStandUpNotifyOuterClass$EvtAvatarStandUpNotify.class */
    public static final class EvtAvatarStandUpNotify extends GeneratedMessageV3 implements EvtAvatarStandUpNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHAIRID_FIELD_NUMBER = 11;
        private long chairId_;
        public static final int PERFORMID_FIELD_NUMBER = 14;
        private int performId_;
        public static final int DIRECTION_FIELD_NUMBER = 5;
        private int direction_;
        public static final int ENTITYID_FIELD_NUMBER = 4;
        private int entityId_;
        private byte memoizedIsInitialized;
        private static final EvtAvatarStandUpNotify DEFAULT_INSTANCE = new EvtAvatarStandUpNotify();
        private static final Parser<EvtAvatarStandUpNotify> PARSER = new AbstractParser<EvtAvatarStandUpNotify>() { // from class: emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotify.1
            @Override // com.google.protobuf.Parser
            public EvtAvatarStandUpNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtAvatarStandUpNotify(input, extensionRegistry);
            }
        };

        private EvtAvatarStandUpNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EvtAvatarStandUpNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtAvatarStandUpNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EvtAvatarStandUpNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.direction_ = input.readInt32();
                                    break;
                                case 88:
                                    this.chairId_ = input.readUInt64();
                                    break;
                                case 112:
                                    this.performId_ = input.readInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EvtAvatarStandUpNotifyOuterClass.internal_static_EvtAvatarStandUpNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtAvatarStandUpNotifyOuterClass.internal_static_EvtAvatarStandUpNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtAvatarStandUpNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotifyOrBuilder
        public long getChairId() {
            return this.chairId_;
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotifyOrBuilder
        public int getPerformId() {
            return this.performId_;
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotifyOrBuilder
        public int getDirection() {
            return this.direction_;
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
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
            if (this.entityId_ != 0) {
                output.writeUInt32(4, this.entityId_);
            }
            if (this.direction_ != 0) {
                output.writeInt32(5, this.direction_);
            }
            if (this.chairId_ != 0) {
                output.writeUInt64(11, this.chairId_);
            }
            if (this.performId_ != 0) {
                output.writeInt32(14, this.performId_);
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
            if (this.entityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.entityId_);
            }
            if (this.direction_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.direction_);
            }
            if (this.chairId_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(11, this.chairId_);
            }
            if (this.performId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.performId_);
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
            if (!(obj instanceof EvtAvatarStandUpNotify)) {
                return equals(obj);
            }
            EvtAvatarStandUpNotify other = (EvtAvatarStandUpNotify) obj;
            return getChairId() == other.getChairId() && getPerformId() == other.getPerformId() && getDirection() == other.getDirection() && getEntityId() == other.getEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + Internal.hashLong(getChairId()))) + 14)) + getPerformId())) + 5)) + getDirection())) + 4)) + getEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EvtAvatarStandUpNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAvatarStandUpNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAvatarStandUpNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAvatarStandUpNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAvatarStandUpNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAvatarStandUpNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAvatarStandUpNotify parseFrom(InputStream input) throws IOException {
            return (EvtAvatarStandUpNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAvatarStandUpNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAvatarStandUpNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAvatarStandUpNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtAvatarStandUpNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtAvatarStandUpNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAvatarStandUpNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAvatarStandUpNotify parseFrom(CodedInputStream input) throws IOException {
            return (EvtAvatarStandUpNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAvatarStandUpNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAvatarStandUpNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtAvatarStandUpNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarStandUpNotifyOuterClass$EvtAvatarStandUpNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtAvatarStandUpNotifyOrBuilder {
            private long chairId_;
            private int performId_;
            private int direction_;
            private int entityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtAvatarStandUpNotifyOuterClass.internal_static_EvtAvatarStandUpNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtAvatarStandUpNotifyOuterClass.internal_static_EvtAvatarStandUpNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtAvatarStandUpNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtAvatarStandUpNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.chairId_ = 0;
                this.performId_ = 0;
                this.direction_ = 0;
                this.entityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtAvatarStandUpNotifyOuterClass.internal_static_EvtAvatarStandUpNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtAvatarStandUpNotify getDefaultInstanceForType() {
                return EvtAvatarStandUpNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAvatarStandUpNotify build() {
                EvtAvatarStandUpNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAvatarStandUpNotify buildPartial() {
                EvtAvatarStandUpNotify result = new EvtAvatarStandUpNotify(this);
                result.chairId_ = this.chairId_;
                result.performId_ = this.performId_;
                result.direction_ = this.direction_;
                result.entityId_ = this.entityId_;
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
                if (other instanceof EvtAvatarStandUpNotify) {
                    return mergeFrom((EvtAvatarStandUpNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtAvatarStandUpNotify other) {
                if (other == EvtAvatarStandUpNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getChairId() != 0) {
                    setChairId(other.getChairId());
                }
                if (other.getPerformId() != 0) {
                    setPerformId(other.getPerformId());
                }
                if (other.getDirection() != 0) {
                    setDirection(other.getDirection());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
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
                EvtAvatarStandUpNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtAvatarStandUpNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtAvatarStandUpNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotifyOrBuilder
            public long getChairId() {
                return this.chairId_;
            }

            public Builder setChairId(long value) {
                this.chairId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChairId() {
                this.chairId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotifyOrBuilder
            public int getPerformId() {
                return this.performId_;
            }

            public Builder setPerformId(int value) {
                this.performId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPerformId() {
                this.performId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotifyOrBuilder
            public int getDirection() {
                return this.direction_;
            }

            public Builder setDirection(int value) {
                this.direction_ = value;
                onChanged();
                return this;
            }

            public Builder clearDirection() {
                this.direction_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotifyOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
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

        public static EvtAvatarStandUpNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtAvatarStandUpNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtAvatarStandUpNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtAvatarStandUpNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
