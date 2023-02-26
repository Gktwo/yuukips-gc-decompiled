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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueAvatarInfoOuterClass.class */
public final class RogueAvatarInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015RogueAvatarInfo.proto\"I\n\u000fRogueAvatarInfo\u0012\u0010\n\bavatarId\u0018\u000f \u0001(\r\u0012\u000f\n\u0007isAlive\u0018\u0005 \u0001(\b\u0012\u0013\n\u000begkmacmbgbe\u0018\u0001 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RogueAvatarInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RogueAvatarInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RogueAvatarInfo_descriptor, new String[]{"AvatarId", "IsAlive", "Egkmacmbgbe"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueAvatarInfoOuterClass$RogueAvatarInfoOrBuilder.class */
    public interface RogueAvatarInfoOrBuilder extends MessageOrBuilder {
        int getAvatarId();

        boolean getIsAlive();

        boolean getEgkmacmbgbe();
    }

    private RogueAvatarInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueAvatarInfoOuterClass$RogueAvatarInfo.class */
    public static final class RogueAvatarInfo extends GeneratedMessageV3 implements RogueAvatarInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARID_FIELD_NUMBER = 15;
        private int avatarId_;
        public static final int ISALIVE_FIELD_NUMBER = 5;
        private boolean isAlive_;
        public static final int EGKMACMBGBE_FIELD_NUMBER = 1;
        private boolean egkmacmbgbe_;
        private byte memoizedIsInitialized;
        private static final RogueAvatarInfo DEFAULT_INSTANCE = new RogueAvatarInfo();
        private static final Parser<RogueAvatarInfo> PARSER = new AbstractParser<RogueAvatarInfo>() { // from class: emu.grasscutter.net.proto.RogueAvatarInfoOuterClass.RogueAvatarInfo.1
            @Override // com.google.protobuf.Parser
            public RogueAvatarInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RogueAvatarInfo(input, extensionRegistry);
            }
        };

        private RogueAvatarInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RogueAvatarInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RogueAvatarInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RogueAvatarInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.egkmacmbgbe_ = input.readBool();
                                    break;
                                case 40:
                                    this.isAlive_ = input.readBool();
                                    break;
                                case 120:
                                    this.avatarId_ = input.readUInt32();
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
            return RogueAvatarInfoOuterClass.internal_static_RogueAvatarInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RogueAvatarInfoOuterClass.internal_static_RogueAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueAvatarInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder
        public boolean getIsAlive() {
            return this.isAlive_;
        }

        @Override // emu.grasscutter.net.proto.RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder
        public boolean getEgkmacmbgbe() {
            return this.egkmacmbgbe_;
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
            if (this.egkmacmbgbe_) {
                output.writeBool(1, this.egkmacmbgbe_);
            }
            if (this.isAlive_) {
                output.writeBool(5, this.isAlive_);
            }
            if (this.avatarId_ != 0) {
                output.writeUInt32(15, this.avatarId_);
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
            if (this.egkmacmbgbe_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.egkmacmbgbe_);
            }
            if (this.isAlive_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isAlive_);
            }
            if (this.avatarId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.avatarId_);
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
            if (!(obj instanceof RogueAvatarInfo)) {
                return equals(obj);
            }
            RogueAvatarInfo other = (RogueAvatarInfo) obj;
            return getAvatarId() == other.getAvatarId() && getIsAlive() == other.getIsAlive() && getEgkmacmbgbe() == other.getEgkmacmbgbe() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getAvatarId())) + 5)) + Internal.hashBoolean(getIsAlive()))) + 1)) + Internal.hashBoolean(getEgkmacmbgbe()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static RogueAvatarInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueAvatarInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueAvatarInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueAvatarInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueAvatarInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueAvatarInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueAvatarInfo parseFrom(InputStream input) throws IOException {
            return (RogueAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueAvatarInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueAvatarInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RogueAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RogueAvatarInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueAvatarInfo parseFrom(CodedInputStream input) throws IOException {
            return (RogueAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueAvatarInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RogueAvatarInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueAvatarInfoOuterClass$RogueAvatarInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RogueAvatarInfoOrBuilder {
            private int avatarId_;
            private boolean isAlive_;
            private boolean egkmacmbgbe_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RogueAvatarInfoOuterClass.internal_static_RogueAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RogueAvatarInfoOuterClass.internal_static_RogueAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueAvatarInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RogueAvatarInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarId_ = 0;
                this.isAlive_ = false;
                this.egkmacmbgbe_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RogueAvatarInfoOuterClass.internal_static_RogueAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RogueAvatarInfo getDefaultInstanceForType() {
                return RogueAvatarInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueAvatarInfo build() {
                RogueAvatarInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueAvatarInfo buildPartial() {
                RogueAvatarInfo result = new RogueAvatarInfo(this);
                result.avatarId_ = this.avatarId_;
                result.isAlive_ = this.isAlive_;
                result.egkmacmbgbe_ = this.egkmacmbgbe_;
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
                if (other instanceof RogueAvatarInfo) {
                    return mergeFrom((RogueAvatarInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RogueAvatarInfo other) {
                if (other == RogueAvatarInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.getIsAlive()) {
                    setIsAlive(other.getIsAlive());
                }
                if (other.getEgkmacmbgbe()) {
                    setEgkmacmbgbe(other.getEgkmacmbgbe());
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
                RogueAvatarInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RogueAvatarInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RogueAvatarInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder
            public int getAvatarId() {
                return this.avatarId_;
            }

            public Builder setAvatarId(int value) {
                this.avatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarId() {
                this.avatarId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder
            public boolean getIsAlive() {
                return this.isAlive_;
            }

            public Builder setIsAlive(boolean value) {
                this.isAlive_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAlive() {
                this.isAlive_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder
            public boolean getEgkmacmbgbe() {
                return this.egkmacmbgbe_;
            }

            public Builder setEgkmacmbgbe(boolean value) {
                this.egkmacmbgbe_ = value;
                onChanged();
                return this;
            }

            public Builder clearEgkmacmbgbe() {
                this.egkmacmbgbe_ = false;
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

        public static RogueAvatarInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RogueAvatarInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RogueAvatarInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RogueAvatarInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
