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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionAvatarInfoOuterClass.class */
public final class PotionAvatarInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016PotionAvatarInfo.proto\"5\n\u0010PotionAvatarInfo\u0012\u0010\n\bavatarId\u0018\n \u0001(\u0004\u0012\u000f\n\u0007isTrial\u0018\u0003 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PotionAvatarInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PotionAvatarInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PotionAvatarInfo_descriptor, new String[]{"AvatarId", "IsTrial"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionAvatarInfoOuterClass$PotionAvatarInfoOrBuilder.class */
    public interface PotionAvatarInfoOrBuilder extends MessageOrBuilder {
        long getAvatarId();

        boolean getIsTrial();
    }

    private PotionAvatarInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionAvatarInfoOuterClass$PotionAvatarInfo.class */
    public static final class PotionAvatarInfo extends GeneratedMessageV3 implements PotionAvatarInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARID_FIELD_NUMBER = 10;
        private long avatarId_;
        public static final int ISTRIAL_FIELD_NUMBER = 3;
        private boolean isTrial_;
        private byte memoizedIsInitialized;
        private static final PotionAvatarInfo DEFAULT_INSTANCE = new PotionAvatarInfo();
        private static final Parser<PotionAvatarInfo> PARSER = new AbstractParser<PotionAvatarInfo>() { // from class: emu.grasscutter.net.proto.PotionAvatarInfoOuterClass.PotionAvatarInfo.1
            @Override // com.google.protobuf.Parser
            public PotionAvatarInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PotionAvatarInfo(input, extensionRegistry);
            }
        };

        private PotionAvatarInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PotionAvatarInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PotionAvatarInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PotionAvatarInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.isTrial_ = input.readBool();
                                break;
                            case 80:
                                this.avatarId_ = input.readUInt64();
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
            return PotionAvatarInfoOuterClass.internal_static_PotionAvatarInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PotionAvatarInfoOuterClass.internal_static_PotionAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PotionAvatarInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PotionAvatarInfoOuterClass.PotionAvatarInfoOrBuilder
        public long getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.PotionAvatarInfoOuterClass.PotionAvatarInfoOrBuilder
        public boolean getIsTrial() {
            return this.isTrial_;
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
            if (this.isTrial_) {
                output.writeBool(3, this.isTrial_);
            }
            if (this.avatarId_ != 0) {
                output.writeUInt64(10, this.avatarId_);
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
            if (this.isTrial_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.isTrial_);
            }
            if (this.avatarId_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(10, this.avatarId_);
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
            if (!(obj instanceof PotionAvatarInfo)) {
                return equals(obj);
            }
            PotionAvatarInfo other = (PotionAvatarInfo) obj;
            return getAvatarId() == other.getAvatarId() && getIsTrial() == other.getIsTrial() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + Internal.hashLong(getAvatarId()))) + 3)) + Internal.hashBoolean(getIsTrial()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PotionAvatarInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionAvatarInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionAvatarInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionAvatarInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionAvatarInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionAvatarInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionAvatarInfo parseFrom(InputStream input) throws IOException {
            return (PotionAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PotionAvatarInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PotionAvatarInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PotionAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PotionAvatarInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PotionAvatarInfo parseFrom(CodedInputStream input) throws IOException {
            return (PotionAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PotionAvatarInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PotionAvatarInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionAvatarInfoOuterClass$PotionAvatarInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PotionAvatarInfoOrBuilder {
            private long avatarId_;
            private boolean isTrial_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PotionAvatarInfoOuterClass.internal_static_PotionAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PotionAvatarInfoOuterClass.internal_static_PotionAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PotionAvatarInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PotionAvatarInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarId_ = 0;
                this.isTrial_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PotionAvatarInfoOuterClass.internal_static_PotionAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PotionAvatarInfo getDefaultInstanceForType() {
                return PotionAvatarInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PotionAvatarInfo build() {
                PotionAvatarInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PotionAvatarInfo buildPartial() {
                PotionAvatarInfo result = new PotionAvatarInfo(this);
                result.avatarId_ = this.avatarId_;
                result.isTrial_ = this.isTrial_;
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
                if (other instanceof PotionAvatarInfo) {
                    return mergeFrom((PotionAvatarInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PotionAvatarInfo other) {
                if (other == PotionAvatarInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.getIsTrial()) {
                    setIsTrial(other.getIsTrial());
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
                PotionAvatarInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PotionAvatarInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PotionAvatarInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PotionAvatarInfoOuterClass.PotionAvatarInfoOrBuilder
            public long getAvatarId() {
                return this.avatarId_;
            }

            public Builder setAvatarId(long value) {
                this.avatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarId() {
                this.avatarId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PotionAvatarInfoOuterClass.PotionAvatarInfoOrBuilder
            public boolean getIsTrial() {
                return this.isTrial_;
            }

            public Builder setIsTrial(boolean value) {
                this.isTrial_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTrial() {
                this.isTrial_ = false;
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

        public static PotionAvatarInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PotionAvatarInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PotionAvatarInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PotionAvatarInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
