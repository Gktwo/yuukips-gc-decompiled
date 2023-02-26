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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerMiddleLevelChangeTeamNotifyOuterClass.class */
public final class TowerMiddleLevelChangeTeamNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&TowerMiddleLevelChangeTeamNotify.proto\"\"\n TowerMiddleLevelChangeTeamNotifyB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TowerMiddleLevelChangeTeamNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_TowerMiddleLevelChangeTeamNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f863x4d8d4341 = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerMiddleLevelChangeTeamNotify_descriptor, new String[0]);

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerMiddleLevelChangeTeamNotifyOuterClass$TowerMiddleLevelChangeTeamNotifyOrBuilder.class */
    public interface TowerMiddleLevelChangeTeamNotifyOrBuilder extends MessageOrBuilder {
    }

    private TowerMiddleLevelChangeTeamNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerMiddleLevelChangeTeamNotifyOuterClass$TowerMiddleLevelChangeTeamNotify.class */
    public static final class TowerMiddleLevelChangeTeamNotify extends GeneratedMessageV3 implements TowerMiddleLevelChangeTeamNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private static final TowerMiddleLevelChangeTeamNotify DEFAULT_INSTANCE = new TowerMiddleLevelChangeTeamNotify();
        private static final Parser<TowerMiddleLevelChangeTeamNotify> PARSER = new AbstractParser<TowerMiddleLevelChangeTeamNotify>() { // from class: emu.grasscutter.net.proto.TowerMiddleLevelChangeTeamNotifyOuterClass.TowerMiddleLevelChangeTeamNotify.1
            @Override // com.google.protobuf.Parser
            public TowerMiddleLevelChangeTeamNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerMiddleLevelChangeTeamNotify(input, extensionRegistry);
            }
        };

        private TowerMiddleLevelChangeTeamNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TowerMiddleLevelChangeTeamNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerMiddleLevelChangeTeamNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TowerMiddleLevelChangeTeamNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
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
            return TowerMiddleLevelChangeTeamNotifyOuterClass.internal_static_TowerMiddleLevelChangeTeamNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerMiddleLevelChangeTeamNotifyOuterClass.f863x4d8d4341.ensureFieldAccessorsInitialized(TowerMiddleLevelChangeTeamNotify.class, Builder.class);
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
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size2;
            return size2;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TowerMiddleLevelChangeTeamNotify)) {
                return equals(obj);
            }
            return this.unknownFields.equals(((TowerMiddleLevelChangeTeamNotify) obj).unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((19 * 41) + getDescriptor().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TowerMiddleLevelChangeTeamNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerMiddleLevelChangeTeamNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerMiddleLevelChangeTeamNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerMiddleLevelChangeTeamNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerMiddleLevelChangeTeamNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerMiddleLevelChangeTeamNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerMiddleLevelChangeTeamNotify parseFrom(InputStream input) throws IOException {
            return (TowerMiddleLevelChangeTeamNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerMiddleLevelChangeTeamNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerMiddleLevelChangeTeamNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerMiddleLevelChangeTeamNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerMiddleLevelChangeTeamNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerMiddleLevelChangeTeamNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerMiddleLevelChangeTeamNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerMiddleLevelChangeTeamNotify parseFrom(CodedInputStream input) throws IOException {
            return (TowerMiddleLevelChangeTeamNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerMiddleLevelChangeTeamNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerMiddleLevelChangeTeamNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerMiddleLevelChangeTeamNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerMiddleLevelChangeTeamNotifyOuterClass$TowerMiddleLevelChangeTeamNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerMiddleLevelChangeTeamNotifyOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return TowerMiddleLevelChangeTeamNotifyOuterClass.internal_static_TowerMiddleLevelChangeTeamNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerMiddleLevelChangeTeamNotifyOuterClass.f863x4d8d4341.ensureFieldAccessorsInitialized(TowerMiddleLevelChangeTeamNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerMiddleLevelChangeTeamNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerMiddleLevelChangeTeamNotifyOuterClass.internal_static_TowerMiddleLevelChangeTeamNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerMiddleLevelChangeTeamNotify getDefaultInstanceForType() {
                return TowerMiddleLevelChangeTeamNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerMiddleLevelChangeTeamNotify build() {
                TowerMiddleLevelChangeTeamNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerMiddleLevelChangeTeamNotify buildPartial() {
                TowerMiddleLevelChangeTeamNotify result = new TowerMiddleLevelChangeTeamNotify(this);
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
                if (other instanceof TowerMiddleLevelChangeTeamNotify) {
                    return mergeFrom((TowerMiddleLevelChangeTeamNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerMiddleLevelChangeTeamNotify other) {
                if (other == TowerMiddleLevelChangeTeamNotify.getDefaultInstance()) {
                    return this;
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
                TowerMiddleLevelChangeTeamNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerMiddleLevelChangeTeamNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerMiddleLevelChangeTeamNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
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

        public static TowerMiddleLevelChangeTeamNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerMiddleLevelChangeTeamNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerMiddleLevelChangeTeamNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerMiddleLevelChangeTeamNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
