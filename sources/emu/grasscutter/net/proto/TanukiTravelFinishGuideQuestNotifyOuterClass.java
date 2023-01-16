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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelFinishGuideQuestNotifyOuterClass.class */
public final class TanukiTravelFinishGuideQuestNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n(TanukiTravelFinishGuideQuestNotify.proto\"9\n\"TanukiTravelFinishGuideQuestNotify\u0012\u0013\n\u000bactivity_id\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TanukiTravelFinishGuideQuestNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_TanukiTravelFinishGuideQuestNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f887x3aa9a6cf = new GeneratedMessageV3.FieldAccessorTable(internal_static_TanukiTravelFinishGuideQuestNotify_descriptor, new String[]{"ActivityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelFinishGuideQuestNotifyOuterClass$TanukiTravelFinishGuideQuestNotifyOrBuilder.class */
    public interface TanukiTravelFinishGuideQuestNotifyOrBuilder extends MessageOrBuilder {
        int getActivityId();
    }

    private TanukiTravelFinishGuideQuestNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelFinishGuideQuestNotifyOuterClass$TanukiTravelFinishGuideQuestNotify.class */
    public static final class TanukiTravelFinishGuideQuestNotify extends GeneratedMessageV3 implements TanukiTravelFinishGuideQuestNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTIVITY_ID_FIELD_NUMBER = 1;
        private int activityId_;
        private byte memoizedIsInitialized;
        private static final TanukiTravelFinishGuideQuestNotify DEFAULT_INSTANCE = new TanukiTravelFinishGuideQuestNotify();
        private static final Parser<TanukiTravelFinishGuideQuestNotify> PARSER = new AbstractParser<TanukiTravelFinishGuideQuestNotify>() { // from class: emu.grasscutter.net.proto.TanukiTravelFinishGuideQuestNotifyOuterClass.TanukiTravelFinishGuideQuestNotify.1
            @Override // com.google.protobuf.Parser
            public TanukiTravelFinishGuideQuestNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TanukiTravelFinishGuideQuestNotify(input, extensionRegistry);
            }
        };

        private TanukiTravelFinishGuideQuestNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TanukiTravelFinishGuideQuestNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TanukiTravelFinishGuideQuestNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TanukiTravelFinishGuideQuestNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.activityId_ = input.readUInt32();
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
            return TanukiTravelFinishGuideQuestNotifyOuterClass.internal_static_TanukiTravelFinishGuideQuestNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TanukiTravelFinishGuideQuestNotifyOuterClass.f887x3aa9a6cf.ensureFieldAccessorsInitialized(TanukiTravelFinishGuideQuestNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelFinishGuideQuestNotifyOuterClass.TanukiTravelFinishGuideQuestNotifyOrBuilder
        public int getActivityId() {
            return this.activityId_;
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
            if (this.activityId_ != 0) {
                output.writeUInt32(1, this.activityId_);
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
            if (this.activityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.activityId_);
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
            if (!(obj instanceof TanukiTravelFinishGuideQuestNotify)) {
                return equals(obj);
            }
            TanukiTravelFinishGuideQuestNotify other = (TanukiTravelFinishGuideQuestNotify) obj;
            return getActivityId() == other.getActivityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getActivityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TanukiTravelFinishGuideQuestNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelFinishGuideQuestNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelFinishGuideQuestNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelFinishGuideQuestNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelFinishGuideQuestNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelFinishGuideQuestNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelFinishGuideQuestNotify parseFrom(InputStream input) throws IOException {
            return (TanukiTravelFinishGuideQuestNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TanukiTravelFinishGuideQuestNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelFinishGuideQuestNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TanukiTravelFinishGuideQuestNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (TanukiTravelFinishGuideQuestNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TanukiTravelFinishGuideQuestNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelFinishGuideQuestNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TanukiTravelFinishGuideQuestNotify parseFrom(CodedInputStream input) throws IOException {
            return (TanukiTravelFinishGuideQuestNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TanukiTravelFinishGuideQuestNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelFinishGuideQuestNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TanukiTravelFinishGuideQuestNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelFinishGuideQuestNotifyOuterClass$TanukiTravelFinishGuideQuestNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TanukiTravelFinishGuideQuestNotifyOrBuilder {
            private int activityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TanukiTravelFinishGuideQuestNotifyOuterClass.internal_static_TanukiTravelFinishGuideQuestNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TanukiTravelFinishGuideQuestNotifyOuterClass.f887x3aa9a6cf.ensureFieldAccessorsInitialized(TanukiTravelFinishGuideQuestNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TanukiTravelFinishGuideQuestNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.activityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TanukiTravelFinishGuideQuestNotifyOuterClass.internal_static_TanukiTravelFinishGuideQuestNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TanukiTravelFinishGuideQuestNotify getDefaultInstanceForType() {
                return TanukiTravelFinishGuideQuestNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TanukiTravelFinishGuideQuestNotify build() {
                TanukiTravelFinishGuideQuestNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TanukiTravelFinishGuideQuestNotify buildPartial() {
                TanukiTravelFinishGuideQuestNotify result = new TanukiTravelFinishGuideQuestNotify(this);
                result.activityId_ = this.activityId_;
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
                if (other instanceof TanukiTravelFinishGuideQuestNotify) {
                    return mergeFrom((TanukiTravelFinishGuideQuestNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TanukiTravelFinishGuideQuestNotify other) {
                if (other == TanukiTravelFinishGuideQuestNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getActivityId() != 0) {
                    setActivityId(other.getActivityId());
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
                TanukiTravelFinishGuideQuestNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = TanukiTravelFinishGuideQuestNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TanukiTravelFinishGuideQuestNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelFinishGuideQuestNotifyOuterClass.TanukiTravelFinishGuideQuestNotifyOrBuilder
            public int getActivityId() {
                return this.activityId_;
            }

            public Builder setActivityId(int value) {
                this.activityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearActivityId() {
                this.activityId_ = 0;
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

        public static TanukiTravelFinishGuideQuestNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TanukiTravelFinishGuideQuestNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TanukiTravelFinishGuideQuestNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TanukiTravelFinishGuideQuestNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
