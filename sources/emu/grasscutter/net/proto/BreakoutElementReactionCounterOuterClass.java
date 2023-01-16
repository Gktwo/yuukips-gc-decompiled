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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutElementReactionCounterOuterClass.class */
public final class BreakoutElementReactionCounterOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$BreakoutElementReactionCounter.proto\"I\n\u001eBreakoutElementReactionCounter\u0012\u0018\n\u0010element_reaction\u0018\u0001 \u0001(\r\u0012\r\n\u0005count\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BreakoutElementReactionCounter_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_BreakoutElementReactionCounter_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f662xd8b76997 = new GeneratedMessageV3.FieldAccessorTable(internal_static_BreakoutElementReactionCounter_descriptor, new String[]{"ElementReaction", "Count"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutElementReactionCounterOuterClass$BreakoutElementReactionCounterOrBuilder.class */
    public interface BreakoutElementReactionCounterOrBuilder extends MessageOrBuilder {
        int getElementReaction();

        int getCount();
    }

    private BreakoutElementReactionCounterOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutElementReactionCounterOuterClass$BreakoutElementReactionCounter.class */
    public static final class BreakoutElementReactionCounter extends GeneratedMessageV3 implements BreakoutElementReactionCounterOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ELEMENT_REACTION_FIELD_NUMBER = 1;
        private int elementReaction_;
        public static final int COUNT_FIELD_NUMBER = 2;
        private int count_;
        private byte memoizedIsInitialized;
        private static final BreakoutElementReactionCounter DEFAULT_INSTANCE = new BreakoutElementReactionCounter();
        private static final Parser<BreakoutElementReactionCounter> PARSER = new AbstractParser<BreakoutElementReactionCounter>() { // from class: emu.grasscutter.net.proto.BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.1
            @Override // com.google.protobuf.Parser
            public BreakoutElementReactionCounter parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BreakoutElementReactionCounter(input, extensionRegistry);
            }
        };

        private BreakoutElementReactionCounter(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BreakoutElementReactionCounter() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BreakoutElementReactionCounter();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BreakoutElementReactionCounter(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.elementReaction_ = input.readUInt32();
                                break;
                            case 16:
                                this.count_ = input.readUInt32();
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
            return BreakoutElementReactionCounterOuterClass.internal_static_BreakoutElementReactionCounter_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BreakoutElementReactionCounterOuterClass.f662xd8b76997.ensureFieldAccessorsInitialized(BreakoutElementReactionCounter.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder
        public int getElementReaction() {
            return this.elementReaction_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder
        public int getCount() {
            return this.count_;
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
            if (this.elementReaction_ != 0) {
                output.writeUInt32(1, this.elementReaction_);
            }
            if (this.count_ != 0) {
                output.writeUInt32(2, this.count_);
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
            if (this.elementReaction_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.elementReaction_);
            }
            if (this.count_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.count_);
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
            if (!(obj instanceof BreakoutElementReactionCounter)) {
                return equals(obj);
            }
            BreakoutElementReactionCounter other = (BreakoutElementReactionCounter) obj;
            return getElementReaction() == other.getElementReaction() && getCount() == other.getCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getElementReaction())) + 2)) + getCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BreakoutElementReactionCounter parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutElementReactionCounter parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutElementReactionCounter parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutElementReactionCounter parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutElementReactionCounter parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutElementReactionCounter parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutElementReactionCounter parseFrom(InputStream input) throws IOException {
            return (BreakoutElementReactionCounter) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutElementReactionCounter parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutElementReactionCounter) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutElementReactionCounter parseDelimitedFrom(InputStream input) throws IOException {
            return (BreakoutElementReactionCounter) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BreakoutElementReactionCounter parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutElementReactionCounter) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutElementReactionCounter parseFrom(CodedInputStream input) throws IOException {
            return (BreakoutElementReactionCounter) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutElementReactionCounter parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutElementReactionCounter) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BreakoutElementReactionCounter prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutElementReactionCounterOuterClass$BreakoutElementReactionCounter$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreakoutElementReactionCounterOrBuilder {
            private int elementReaction_;
            private int count_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BreakoutElementReactionCounterOuterClass.internal_static_BreakoutElementReactionCounter_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BreakoutElementReactionCounterOuterClass.f662xd8b76997.ensureFieldAccessorsInitialized(BreakoutElementReactionCounter.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BreakoutElementReactionCounter.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.elementReaction_ = 0;
                this.count_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BreakoutElementReactionCounterOuterClass.internal_static_BreakoutElementReactionCounter_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BreakoutElementReactionCounter getDefaultInstanceForType() {
                return BreakoutElementReactionCounter.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutElementReactionCounter build() {
                BreakoutElementReactionCounter result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutElementReactionCounter buildPartial() {
                BreakoutElementReactionCounter result = new BreakoutElementReactionCounter(this);
                result.elementReaction_ = this.elementReaction_;
                result.count_ = this.count_;
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
                if (other instanceof BreakoutElementReactionCounter) {
                    return mergeFrom((BreakoutElementReactionCounter) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BreakoutElementReactionCounter other) {
                if (other == BreakoutElementReactionCounter.getDefaultInstance()) {
                    return this;
                }
                if (other.getElementReaction() != 0) {
                    setElementReaction(other.getElementReaction());
                }
                if (other.getCount() != 0) {
                    setCount(other.getCount());
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
                BreakoutElementReactionCounter parsedMessage = null;
                try {
                    try {
                        parsedMessage = BreakoutElementReactionCounter.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BreakoutElementReactionCounter) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder
            public int getElementReaction() {
                return this.elementReaction_;
            }

            public Builder setElementReaction(int value) {
                this.elementReaction_ = value;
                onChanged();
                return this;
            }

            public Builder clearElementReaction() {
                this.elementReaction_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder
            public int getCount() {
                return this.count_;
            }

            public Builder setCount(int value) {
                this.count_ = value;
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
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

        public static BreakoutElementReactionCounter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreakoutElementReactionCounter> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BreakoutElementReactionCounter> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BreakoutElementReactionCounter getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
