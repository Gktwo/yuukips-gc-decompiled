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
import emu.grasscutter.net.proto.MonsterRouteOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterPointArrayRouteUpdateNotifyOuterClass.class */
public final class MonsterPointArrayRouteUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n(MonsterPointArrayRouteUpdateNotify.proto\u001a\u0012MonsterRoute.proto\"]\n\"MonsterPointArrayRouteUpdateNotify\u0012\u0011\n\tentity_id\u0018\u0005 \u0001(\r\u0012$\n\rmonster_route\u0018\u000b \u0001(\u000b2\r.MonsterRouteB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MonsterRouteOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MonsterPointArrayRouteUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_MonsterPointArrayRouteUpdateNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f801x547d8325 = new GeneratedMessageV3.FieldAccessorTable(internal_static_MonsterPointArrayRouteUpdateNotify_descriptor, new String[]{"EntityId", "MonsterRoute"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterPointArrayRouteUpdateNotifyOuterClass$MonsterPointArrayRouteUpdateNotifyOrBuilder.class */
    public interface MonsterPointArrayRouteUpdateNotifyOrBuilder extends MessageOrBuilder {
        int getEntityId();

        boolean hasMonsterRoute();

        MonsterRouteOuterClass.MonsterRoute getMonsterRoute();

        MonsterRouteOuterClass.MonsterRouteOrBuilder getMonsterRouteOrBuilder();
    }

    private MonsterPointArrayRouteUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterPointArrayRouteUpdateNotifyOuterClass$MonsterPointArrayRouteUpdateNotify.class */
    public static final class MonsterPointArrayRouteUpdateNotify extends GeneratedMessageV3 implements MonsterPointArrayRouteUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITY_ID_FIELD_NUMBER = 5;
        private int entityId_;
        public static final int MONSTER_ROUTE_FIELD_NUMBER = 11;
        private MonsterRouteOuterClass.MonsterRoute monsterRoute_;
        private byte memoizedIsInitialized;
        private static final MonsterPointArrayRouteUpdateNotify DEFAULT_INSTANCE = new MonsterPointArrayRouteUpdateNotify();
        private static final Parser<MonsterPointArrayRouteUpdateNotify> PARSER = new AbstractParser<MonsterPointArrayRouteUpdateNotify>() { // from class: emu.grasscutter.net.proto.MonsterPointArrayRouteUpdateNotifyOuterClass.MonsterPointArrayRouteUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public MonsterPointArrayRouteUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MonsterPointArrayRouteUpdateNotify(input, extensionRegistry);
            }
        };

        private MonsterPointArrayRouteUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MonsterPointArrayRouteUpdateNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MonsterPointArrayRouteUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MonsterPointArrayRouteUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 90:
                                    MonsterRouteOuterClass.MonsterRoute.Builder subBuilder = this.monsterRoute_ != null ? this.monsterRoute_.toBuilder() : null;
                                    this.monsterRoute_ = (MonsterRouteOuterClass.MonsterRoute) input.readMessage(MonsterRouteOuterClass.MonsterRoute.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.monsterRoute_);
                                        this.monsterRoute_ = subBuilder.buildPartial();
                                        break;
                                    }
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
            return MonsterPointArrayRouteUpdateNotifyOuterClass.internal_static_MonsterPointArrayRouteUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MonsterPointArrayRouteUpdateNotifyOuterClass.f801x547d8325.ensureFieldAccessorsInitialized(MonsterPointArrayRouteUpdateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MonsterPointArrayRouteUpdateNotifyOuterClass.MonsterPointArrayRouteUpdateNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.MonsterPointArrayRouteUpdateNotifyOuterClass.MonsterPointArrayRouteUpdateNotifyOrBuilder
        public boolean hasMonsterRoute() {
            return this.monsterRoute_ != null;
        }

        @Override // emu.grasscutter.net.proto.MonsterPointArrayRouteUpdateNotifyOuterClass.MonsterPointArrayRouteUpdateNotifyOrBuilder
        public MonsterRouteOuterClass.MonsterRoute getMonsterRoute() {
            return this.monsterRoute_ == null ? MonsterRouteOuterClass.MonsterRoute.getDefaultInstance() : this.monsterRoute_;
        }

        @Override // emu.grasscutter.net.proto.MonsterPointArrayRouteUpdateNotifyOuterClass.MonsterPointArrayRouteUpdateNotifyOrBuilder
        public MonsterRouteOuterClass.MonsterRouteOrBuilder getMonsterRouteOrBuilder() {
            return getMonsterRoute();
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
                output.writeUInt32(5, this.entityId_);
            }
            if (this.monsterRoute_ != null) {
                output.writeMessage(11, getMonsterRoute());
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.entityId_);
            }
            if (this.monsterRoute_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getMonsterRoute());
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
            if (!(obj instanceof MonsterPointArrayRouteUpdateNotify)) {
                return equals(obj);
            }
            MonsterPointArrayRouteUpdateNotify other = (MonsterPointArrayRouteUpdateNotify) obj;
            if (getEntityId() == other.getEntityId() && hasMonsterRoute() == other.hasMonsterRoute()) {
                return (!hasMonsterRoute() || getMonsterRoute().equals(other.getMonsterRoute())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getEntityId();
            if (hasMonsterRoute()) {
                hash = (53 * ((37 * hash) + 11)) + getMonsterRoute().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MonsterPointArrayRouteUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MonsterPointArrayRouteUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MonsterPointArrayRouteUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MonsterPointArrayRouteUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MonsterPointArrayRouteUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MonsterPointArrayRouteUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MonsterPointArrayRouteUpdateNotify parseFrom(InputStream input) throws IOException {
            return (MonsterPointArrayRouteUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MonsterPointArrayRouteUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonsterPointArrayRouteUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MonsterPointArrayRouteUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (MonsterPointArrayRouteUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MonsterPointArrayRouteUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonsterPointArrayRouteUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MonsterPointArrayRouteUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (MonsterPointArrayRouteUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MonsterPointArrayRouteUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonsterPointArrayRouteUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MonsterPointArrayRouteUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterPointArrayRouteUpdateNotifyOuterClass$MonsterPointArrayRouteUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MonsterPointArrayRouteUpdateNotifyOrBuilder {
            private int entityId_;
            private MonsterRouteOuterClass.MonsterRoute monsterRoute_;
            private SingleFieldBuilderV3<MonsterRouteOuterClass.MonsterRoute, MonsterRouteOuterClass.MonsterRoute.Builder, MonsterRouteOuterClass.MonsterRouteOrBuilder> monsterRouteBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MonsterPointArrayRouteUpdateNotifyOuterClass.internal_static_MonsterPointArrayRouteUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MonsterPointArrayRouteUpdateNotifyOuterClass.f801x547d8325.ensureFieldAccessorsInitialized(MonsterPointArrayRouteUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MonsterPointArrayRouteUpdateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                if (this.monsterRouteBuilder_ == null) {
                    this.monsterRoute_ = null;
                } else {
                    this.monsterRoute_ = null;
                    this.monsterRouteBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MonsterPointArrayRouteUpdateNotifyOuterClass.internal_static_MonsterPointArrayRouteUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MonsterPointArrayRouteUpdateNotify getDefaultInstanceForType() {
                return MonsterPointArrayRouteUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MonsterPointArrayRouteUpdateNotify build() {
                MonsterPointArrayRouteUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MonsterPointArrayRouteUpdateNotify buildPartial() {
                MonsterPointArrayRouteUpdateNotify result = new MonsterPointArrayRouteUpdateNotify(this);
                result.entityId_ = this.entityId_;
                if (this.monsterRouteBuilder_ == null) {
                    result.monsterRoute_ = this.monsterRoute_;
                } else {
                    result.monsterRoute_ = this.monsterRouteBuilder_.build();
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
                if (other instanceof MonsterPointArrayRouteUpdateNotify) {
                    return mergeFrom((MonsterPointArrayRouteUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MonsterPointArrayRouteUpdateNotify other) {
                if (other == MonsterPointArrayRouteUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.hasMonsterRoute()) {
                    mergeMonsterRoute(other.getMonsterRoute());
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
                MonsterPointArrayRouteUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = MonsterPointArrayRouteUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MonsterPointArrayRouteUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MonsterPointArrayRouteUpdateNotifyOuterClass.MonsterPointArrayRouteUpdateNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.MonsterPointArrayRouteUpdateNotifyOuterClass.MonsterPointArrayRouteUpdateNotifyOrBuilder
            public boolean hasMonsterRoute() {
                return (this.monsterRouteBuilder_ == null && this.monsterRoute_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MonsterPointArrayRouteUpdateNotifyOuterClass.MonsterPointArrayRouteUpdateNotifyOrBuilder
            public MonsterRouteOuterClass.MonsterRoute getMonsterRoute() {
                if (this.monsterRouteBuilder_ == null) {
                    return this.monsterRoute_ == null ? MonsterRouteOuterClass.MonsterRoute.getDefaultInstance() : this.monsterRoute_;
                }
                return this.monsterRouteBuilder_.getMessage();
            }

            public Builder setMonsterRoute(MonsterRouteOuterClass.MonsterRoute value) {
                if (this.monsterRouteBuilder_ != null) {
                    this.monsterRouteBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.monsterRoute_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMonsterRoute(MonsterRouteOuterClass.MonsterRoute.Builder builderForValue) {
                if (this.monsterRouteBuilder_ == null) {
                    this.monsterRoute_ = builderForValue.build();
                    onChanged();
                } else {
                    this.monsterRouteBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMonsterRoute(MonsterRouteOuterClass.MonsterRoute value) {
                if (this.monsterRouteBuilder_ == null) {
                    if (this.monsterRoute_ != null) {
                        this.monsterRoute_ = MonsterRouteOuterClass.MonsterRoute.newBuilder(this.monsterRoute_).mergeFrom(value).buildPartial();
                    } else {
                        this.monsterRoute_ = value;
                    }
                    onChanged();
                } else {
                    this.monsterRouteBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMonsterRoute() {
                if (this.monsterRouteBuilder_ == null) {
                    this.monsterRoute_ = null;
                    onChanged();
                } else {
                    this.monsterRoute_ = null;
                    this.monsterRouteBuilder_ = null;
                }
                return this;
            }

            public MonsterRouteOuterClass.MonsterRoute.Builder getMonsterRouteBuilder() {
                onChanged();
                return getMonsterRouteFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MonsterPointArrayRouteUpdateNotifyOuterClass.MonsterPointArrayRouteUpdateNotifyOrBuilder
            public MonsterRouteOuterClass.MonsterRouteOrBuilder getMonsterRouteOrBuilder() {
                if (this.monsterRouteBuilder_ != null) {
                    return this.monsterRouteBuilder_.getMessageOrBuilder();
                }
                return this.monsterRoute_ == null ? MonsterRouteOuterClass.MonsterRoute.getDefaultInstance() : this.monsterRoute_;
            }

            private SingleFieldBuilderV3<MonsterRouteOuterClass.MonsterRoute, MonsterRouteOuterClass.MonsterRoute.Builder, MonsterRouteOuterClass.MonsterRouteOrBuilder> getMonsterRouteFieldBuilder() {
                if (this.monsterRouteBuilder_ == null) {
                    this.monsterRouteBuilder_ = new SingleFieldBuilderV3<>(getMonsterRoute(), getParentForChildren(), isClean());
                    this.monsterRoute_ = null;
                }
                return this.monsterRouteBuilder_;
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

        public static MonsterPointArrayRouteUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MonsterPointArrayRouteUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MonsterPointArrayRouteUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MonsterPointArrayRouteUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MonsterRouteOuterClass.getDescriptor();
    }
}
