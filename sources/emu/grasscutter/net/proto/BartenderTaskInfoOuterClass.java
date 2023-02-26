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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderTaskInfoOuterClass.class */
public final class BartenderTaskInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017BartenderTaskInfo.proto\"1\n\u0011BartenderTaskInfo\u0012\u0010\n\bisFinish\u0018\u0007 \u0001(\b\u0012\n\n\u0002id\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BartenderTaskInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BartenderTaskInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BartenderTaskInfo_descriptor, new String[]{"IsFinish", "Id"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderTaskInfoOuterClass$BartenderTaskInfoOrBuilder.class */
    public interface BartenderTaskInfoOrBuilder extends MessageOrBuilder {
        boolean getIsFinish();

        int getId();
    }

    private BartenderTaskInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderTaskInfoOuterClass$BartenderTaskInfo.class */
    public static final class BartenderTaskInfo extends GeneratedMessageV3 implements BartenderTaskInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISFINISH_FIELD_NUMBER = 7;
        private boolean isFinish_;
        public static final int ID_FIELD_NUMBER = 4;
        private int id_;
        private byte memoizedIsInitialized;
        private static final BartenderTaskInfo DEFAULT_INSTANCE = new BartenderTaskInfo();
        private static final Parser<BartenderTaskInfo> PARSER = new AbstractParser<BartenderTaskInfo>() { // from class: emu.grasscutter.net.proto.BartenderTaskInfoOuterClass.BartenderTaskInfo.1
            @Override // com.google.protobuf.Parser
            public BartenderTaskInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BartenderTaskInfo(input, extensionRegistry);
            }
        };

        private BartenderTaskInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BartenderTaskInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BartenderTaskInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BartenderTaskInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.id_ = input.readUInt32();
                                break;
                            case 56:
                                this.isFinish_ = input.readBool();
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
            return BartenderTaskInfoOuterClass.internal_static_BartenderTaskInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BartenderTaskInfoOuterClass.internal_static_BartenderTaskInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BartenderTaskInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        @Override // emu.grasscutter.net.proto.BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder
        public int getId() {
            return this.id_;
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
            if (this.id_ != 0) {
                output.writeUInt32(4, this.id_);
            }
            if (this.isFinish_) {
                output.writeBool(7, this.isFinish_);
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
            if (this.id_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.id_);
            }
            if (this.isFinish_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isFinish_);
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
            if (!(obj instanceof BartenderTaskInfo)) {
                return equals(obj);
            }
            BartenderTaskInfo other = (BartenderTaskInfo) obj;
            return getIsFinish() == other.getIsFinish() && getId() == other.getId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + Internal.hashBoolean(getIsFinish()))) + 4)) + getId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BartenderTaskInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BartenderTaskInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BartenderTaskInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BartenderTaskInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BartenderTaskInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BartenderTaskInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BartenderTaskInfo parseFrom(InputStream input) throws IOException {
            return (BartenderTaskInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BartenderTaskInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BartenderTaskInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BartenderTaskInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BartenderTaskInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BartenderTaskInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BartenderTaskInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BartenderTaskInfo parseFrom(CodedInputStream input) throws IOException {
            return (BartenderTaskInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BartenderTaskInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BartenderTaskInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BartenderTaskInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderTaskInfoOuterClass$BartenderTaskInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BartenderTaskInfoOrBuilder {
            private boolean isFinish_;
            private int id_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BartenderTaskInfoOuterClass.internal_static_BartenderTaskInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BartenderTaskInfoOuterClass.internal_static_BartenderTaskInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BartenderTaskInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BartenderTaskInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFinish_ = false;
                this.id_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BartenderTaskInfoOuterClass.internal_static_BartenderTaskInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BartenderTaskInfo getDefaultInstanceForType() {
                return BartenderTaskInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BartenderTaskInfo build() {
                BartenderTaskInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BartenderTaskInfo buildPartial() {
                BartenderTaskInfo result = new BartenderTaskInfo(this);
                result.isFinish_ = this.isFinish_;
                result.id_ = this.id_;
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
                if (other instanceof BartenderTaskInfo) {
                    return mergeFrom((BartenderTaskInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BartenderTaskInfo other) {
                if (other == BartenderTaskInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                if (other.getId() != 0) {
                    setId(other.getId());
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
                BartenderTaskInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BartenderTaskInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BartenderTaskInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder
            public boolean getIsFinish() {
                return this.isFinish_;
            }

            public Builder setIsFinish(boolean value) {
                this.isFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinish() {
                this.isFinish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
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

        public static BartenderTaskInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BartenderTaskInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BartenderTaskInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BartenderTaskInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
