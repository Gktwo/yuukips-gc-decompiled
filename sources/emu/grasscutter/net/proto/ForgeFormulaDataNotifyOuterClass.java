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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeFormulaDataNotifyOuterClass.class */
public final class ForgeFormulaDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cForgeFormulaDataNotify.proto\";\n\u0016ForgeFormulaDataNotify\u0012\u0010\n\bisLocked\u0018\u0001 \u0001(\b\u0012\u000f\n\u0007forgeId\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ForgeFormulaDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ForgeFormulaDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ForgeFormulaDataNotify_descriptor, new String[]{"IsLocked", "ForgeId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeFormulaDataNotifyOuterClass$ForgeFormulaDataNotifyOrBuilder.class */
    public interface ForgeFormulaDataNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsLocked();

        int getForgeId();
    }

    private ForgeFormulaDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeFormulaDataNotifyOuterClass$ForgeFormulaDataNotify.class */
    public static final class ForgeFormulaDataNotify extends GeneratedMessageV3 implements ForgeFormulaDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISLOCKED_FIELD_NUMBER = 1;
        private boolean isLocked_;
        public static final int FORGEID_FIELD_NUMBER = 12;
        private int forgeId_;
        private byte memoizedIsInitialized;
        private static final ForgeFormulaDataNotify DEFAULT_INSTANCE = new ForgeFormulaDataNotify();
        private static final Parser<ForgeFormulaDataNotify> PARSER = new AbstractParser<ForgeFormulaDataNotify>() { // from class: emu.grasscutter.net.proto.ForgeFormulaDataNotifyOuterClass.ForgeFormulaDataNotify.1
            @Override // com.google.protobuf.Parser
            public ForgeFormulaDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ForgeFormulaDataNotify(input, extensionRegistry);
            }
        };

        private ForgeFormulaDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ForgeFormulaDataNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ForgeFormulaDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ForgeFormulaDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isLocked_ = input.readBool();
                                break;
                            case 96:
                                this.forgeId_ = input.readUInt32();
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
            return ForgeFormulaDataNotifyOuterClass.internal_static_ForgeFormulaDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ForgeFormulaDataNotifyOuterClass.internal_static_ForgeFormulaDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeFormulaDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ForgeFormulaDataNotifyOuterClass.ForgeFormulaDataNotifyOrBuilder
        public boolean getIsLocked() {
            return this.isLocked_;
        }

        @Override // emu.grasscutter.net.proto.ForgeFormulaDataNotifyOuterClass.ForgeFormulaDataNotifyOrBuilder
        public int getForgeId() {
            return this.forgeId_;
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
            if (this.isLocked_) {
                output.writeBool(1, this.isLocked_);
            }
            if (this.forgeId_ != 0) {
                output.writeUInt32(12, this.forgeId_);
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
            if (this.isLocked_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isLocked_);
            }
            if (this.forgeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.forgeId_);
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
            if (!(obj instanceof ForgeFormulaDataNotify)) {
                return equals(obj);
            }
            ForgeFormulaDataNotify other = (ForgeFormulaDataNotify) obj;
            return getIsLocked() == other.getIsLocked() && getForgeId() == other.getForgeId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashBoolean(getIsLocked()))) + 12)) + getForgeId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ForgeFormulaDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeFormulaDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeFormulaDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeFormulaDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeFormulaDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeFormulaDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeFormulaDataNotify parseFrom(InputStream input) throws IOException {
            return (ForgeFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeFormulaDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeFormulaDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ForgeFormulaDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ForgeFormulaDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeFormulaDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeFormulaDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (ForgeFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeFormulaDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ForgeFormulaDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeFormulaDataNotifyOuterClass$ForgeFormulaDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ForgeFormulaDataNotifyOrBuilder {
            private boolean isLocked_;
            private int forgeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ForgeFormulaDataNotifyOuterClass.internal_static_ForgeFormulaDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ForgeFormulaDataNotifyOuterClass.internal_static_ForgeFormulaDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeFormulaDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ForgeFormulaDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isLocked_ = false;
                this.forgeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ForgeFormulaDataNotifyOuterClass.internal_static_ForgeFormulaDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ForgeFormulaDataNotify getDefaultInstanceForType() {
                return ForgeFormulaDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeFormulaDataNotify build() {
                ForgeFormulaDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeFormulaDataNotify buildPartial() {
                ForgeFormulaDataNotify result = new ForgeFormulaDataNotify(this);
                result.isLocked_ = this.isLocked_;
                result.forgeId_ = this.forgeId_;
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
                if (other instanceof ForgeFormulaDataNotify) {
                    return mergeFrom((ForgeFormulaDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ForgeFormulaDataNotify other) {
                if (other == ForgeFormulaDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsLocked()) {
                    setIsLocked(other.getIsLocked());
                }
                if (other.getForgeId() != 0) {
                    setForgeId(other.getForgeId());
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
                ForgeFormulaDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ForgeFormulaDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ForgeFormulaDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ForgeFormulaDataNotifyOuterClass.ForgeFormulaDataNotifyOrBuilder
            public boolean getIsLocked() {
                return this.isLocked_;
            }

            public Builder setIsLocked(boolean value) {
                this.isLocked_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsLocked() {
                this.isLocked_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeFormulaDataNotifyOuterClass.ForgeFormulaDataNotifyOrBuilder
            public int getForgeId() {
                return this.forgeId_;
            }

            public Builder setForgeId(int value) {
                this.forgeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearForgeId() {
                this.forgeId_ = 0;
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

        public static ForgeFormulaDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ForgeFormulaDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ForgeFormulaDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ForgeFormulaDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
