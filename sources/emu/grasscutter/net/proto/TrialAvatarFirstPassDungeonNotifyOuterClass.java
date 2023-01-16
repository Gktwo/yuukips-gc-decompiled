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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarFirstPassDungeonNotifyOuterClass.class */
public final class TrialAvatarFirstPassDungeonNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'TrialAvatarFirstPassDungeonNotify.proto\"B\n!TrialAvatarFirstPassDungeonNotify\u0012\u001d\n\u0015trial_avatar_index_id\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TrialAvatarFirstPassDungeonNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_TrialAvatarFirstPassDungeonNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f898xe6965c8a = new GeneratedMessageV3.FieldAccessorTable(internal_static_TrialAvatarFirstPassDungeonNotify_descriptor, new String[]{"TrialAvatarIndexId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarFirstPassDungeonNotifyOuterClass$TrialAvatarFirstPassDungeonNotifyOrBuilder.class */
    public interface TrialAvatarFirstPassDungeonNotifyOrBuilder extends MessageOrBuilder {
        int getTrialAvatarIndexId();
    }

    private TrialAvatarFirstPassDungeonNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarFirstPassDungeonNotifyOuterClass$TrialAvatarFirstPassDungeonNotify.class */
    public static final class TrialAvatarFirstPassDungeonNotify extends GeneratedMessageV3 implements TrialAvatarFirstPassDungeonNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TRIAL_AVATAR_INDEX_ID_FIELD_NUMBER = 1;
        private int trialAvatarIndexId_;
        private byte memoizedIsInitialized;
        private static final TrialAvatarFirstPassDungeonNotify DEFAULT_INSTANCE = new TrialAvatarFirstPassDungeonNotify();
        private static final Parser<TrialAvatarFirstPassDungeonNotify> PARSER = new AbstractParser<TrialAvatarFirstPassDungeonNotify>() { // from class: emu.grasscutter.net.proto.TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.1
            @Override // com.google.protobuf.Parser
            public TrialAvatarFirstPassDungeonNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TrialAvatarFirstPassDungeonNotify(input, extensionRegistry);
            }
        };

        private TrialAvatarFirstPassDungeonNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TrialAvatarFirstPassDungeonNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TrialAvatarFirstPassDungeonNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TrialAvatarFirstPassDungeonNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.trialAvatarIndexId_ = input.readUInt32();
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
            return TrialAvatarFirstPassDungeonNotifyOuterClass.internal_static_TrialAvatarFirstPassDungeonNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TrialAvatarFirstPassDungeonNotifyOuterClass.f898xe6965c8a.ensureFieldAccessorsInitialized(TrialAvatarFirstPassDungeonNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotifyOrBuilder
        public int getTrialAvatarIndexId() {
            return this.trialAvatarIndexId_;
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
            if (this.trialAvatarIndexId_ != 0) {
                output.writeUInt32(1, this.trialAvatarIndexId_);
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
            if (this.trialAvatarIndexId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.trialAvatarIndexId_);
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
            if (!(obj instanceof TrialAvatarFirstPassDungeonNotify)) {
                return equals(obj);
            }
            TrialAvatarFirstPassDungeonNotify other = (TrialAvatarFirstPassDungeonNotify) obj;
            return getTrialAvatarIndexId() == other.getTrialAvatarIndexId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getTrialAvatarIndexId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TrialAvatarFirstPassDungeonNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarFirstPassDungeonNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarFirstPassDungeonNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarFirstPassDungeonNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarFirstPassDungeonNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarFirstPassDungeonNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarFirstPassDungeonNotify parseFrom(InputStream input) throws IOException {
            return (TrialAvatarFirstPassDungeonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrialAvatarFirstPassDungeonNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarFirstPassDungeonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrialAvatarFirstPassDungeonNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (TrialAvatarFirstPassDungeonNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TrialAvatarFirstPassDungeonNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarFirstPassDungeonNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrialAvatarFirstPassDungeonNotify parseFrom(CodedInputStream input) throws IOException {
            return (TrialAvatarFirstPassDungeonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrialAvatarFirstPassDungeonNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarFirstPassDungeonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TrialAvatarFirstPassDungeonNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarFirstPassDungeonNotifyOuterClass$TrialAvatarFirstPassDungeonNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TrialAvatarFirstPassDungeonNotifyOrBuilder {
            private int trialAvatarIndexId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TrialAvatarFirstPassDungeonNotifyOuterClass.internal_static_TrialAvatarFirstPassDungeonNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TrialAvatarFirstPassDungeonNotifyOuterClass.f898xe6965c8a.ensureFieldAccessorsInitialized(TrialAvatarFirstPassDungeonNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TrialAvatarFirstPassDungeonNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.trialAvatarIndexId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TrialAvatarFirstPassDungeonNotifyOuterClass.internal_static_TrialAvatarFirstPassDungeonNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TrialAvatarFirstPassDungeonNotify getDefaultInstanceForType() {
                return TrialAvatarFirstPassDungeonNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrialAvatarFirstPassDungeonNotify build() {
                TrialAvatarFirstPassDungeonNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrialAvatarFirstPassDungeonNotify buildPartial() {
                TrialAvatarFirstPassDungeonNotify result = new TrialAvatarFirstPassDungeonNotify(this);
                result.trialAvatarIndexId_ = this.trialAvatarIndexId_;
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
                if (other instanceof TrialAvatarFirstPassDungeonNotify) {
                    return mergeFrom((TrialAvatarFirstPassDungeonNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TrialAvatarFirstPassDungeonNotify other) {
                if (other == TrialAvatarFirstPassDungeonNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getTrialAvatarIndexId() != 0) {
                    setTrialAvatarIndexId(other.getTrialAvatarIndexId());
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
                TrialAvatarFirstPassDungeonNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = TrialAvatarFirstPassDungeonNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TrialAvatarFirstPassDungeonNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotifyOrBuilder
            public int getTrialAvatarIndexId() {
                return this.trialAvatarIndexId_;
            }

            public Builder setTrialAvatarIndexId(int value) {
                this.trialAvatarIndexId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTrialAvatarIndexId() {
                this.trialAvatarIndexId_ = 0;
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

        public static TrialAvatarFirstPassDungeonNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TrialAvatarFirstPassDungeonNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TrialAvatarFirstPassDungeonNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TrialAvatarFirstPassDungeonNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
