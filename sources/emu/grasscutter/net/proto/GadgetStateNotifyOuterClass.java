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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetStateNotifyOuterClass.class */
public final class GadgetStateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017GadgetStateNotify.proto\"Z\n\u0011GadgetStateNotify\u0012\u0013\n\u000bgadgetState\u0018\t \u0001(\r\u0012\u0016\n\u000egadgetEntityId\u0018\u0007 \u0001(\r\u0012\u0018\n\u0010isEnableInteract\u0018\u000f \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GadgetStateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GadgetStateNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GadgetStateNotify_descriptor, new String[]{"GadgetState", "GadgetEntityId", "IsEnableInteract"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetStateNotifyOuterClass$GadgetStateNotifyOrBuilder.class */
    public interface GadgetStateNotifyOrBuilder extends MessageOrBuilder {
        int getGadgetState();

        int getGadgetEntityId();

        boolean getIsEnableInteract();
    }

    private GadgetStateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetStateNotifyOuterClass$GadgetStateNotify.class */
    public static final class GadgetStateNotify extends GeneratedMessageV3 implements GadgetStateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GADGETSTATE_FIELD_NUMBER = 9;
        private int gadgetState_;
        public static final int GADGETENTITYID_FIELD_NUMBER = 7;
        private int gadgetEntityId_;
        public static final int ISENABLEINTERACT_FIELD_NUMBER = 15;
        private boolean isEnableInteract_;
        private byte memoizedIsInitialized;
        private static final GadgetStateNotify DEFAULT_INSTANCE = new GadgetStateNotify();
        private static final Parser<GadgetStateNotify> PARSER = new AbstractParser<GadgetStateNotify>() { // from class: emu.grasscutter.net.proto.GadgetStateNotifyOuterClass.GadgetStateNotify.1
            @Override // com.google.protobuf.Parser
            public GadgetStateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GadgetStateNotify(input, extensionRegistry);
            }
        };

        private GadgetStateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GadgetStateNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GadgetStateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GadgetStateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.gadgetEntityId_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.gadgetState_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.isEnableInteract_ = input.readBool();
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
            return GadgetStateNotifyOuterClass.internal_static_GadgetStateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GadgetStateNotifyOuterClass.internal_static_GadgetStateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetStateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GadgetStateNotifyOuterClass.GadgetStateNotifyOrBuilder
        public int getGadgetState() {
            return this.gadgetState_;
        }

        @Override // emu.grasscutter.net.proto.GadgetStateNotifyOuterClass.GadgetStateNotifyOrBuilder
        public int getGadgetEntityId() {
            return this.gadgetEntityId_;
        }

        @Override // emu.grasscutter.net.proto.GadgetStateNotifyOuterClass.GadgetStateNotifyOrBuilder
        public boolean getIsEnableInteract() {
            return this.isEnableInteract_;
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
            if (this.gadgetEntityId_ != 0) {
                output.writeUInt32(7, this.gadgetEntityId_);
            }
            if (this.gadgetState_ != 0) {
                output.writeUInt32(9, this.gadgetState_);
            }
            if (this.isEnableInteract_) {
                output.writeBool(15, this.isEnableInteract_);
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
            if (this.gadgetEntityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.gadgetEntityId_);
            }
            if (this.gadgetState_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.gadgetState_);
            }
            if (this.isEnableInteract_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isEnableInteract_);
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
            if (!(obj instanceof GadgetStateNotify)) {
                return equals(obj);
            }
            GadgetStateNotify other = (GadgetStateNotify) obj;
            return getGadgetState() == other.getGadgetState() && getGadgetEntityId() == other.getGadgetEntityId() && getIsEnableInteract() == other.getIsEnableInteract() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getGadgetState())) + 7)) + getGadgetEntityId())) + 15)) + Internal.hashBoolean(getIsEnableInteract()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GadgetStateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetStateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetStateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetStateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetStateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetStateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetStateNotify parseFrom(InputStream input) throws IOException {
            return (GadgetStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetStateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetStateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (GadgetStateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GadgetStateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetStateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetStateNotify parseFrom(CodedInputStream input) throws IOException {
            return (GadgetStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetStateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GadgetStateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetStateNotifyOuterClass$GadgetStateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GadgetStateNotifyOrBuilder {
            private int gadgetState_;
            private int gadgetEntityId_;
            private boolean isEnableInteract_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GadgetStateNotifyOuterClass.internal_static_GadgetStateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GadgetStateNotifyOuterClass.internal_static_GadgetStateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetStateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GadgetStateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gadgetState_ = 0;
                this.gadgetEntityId_ = 0;
                this.isEnableInteract_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GadgetStateNotifyOuterClass.internal_static_GadgetStateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GadgetStateNotify getDefaultInstanceForType() {
                return GadgetStateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetStateNotify build() {
                GadgetStateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetStateNotify buildPartial() {
                GadgetStateNotify result = new GadgetStateNotify(this);
                result.gadgetState_ = this.gadgetState_;
                result.gadgetEntityId_ = this.gadgetEntityId_;
                result.isEnableInteract_ = this.isEnableInteract_;
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
                if (other instanceof GadgetStateNotify) {
                    return mergeFrom((GadgetStateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GadgetStateNotify other) {
                if (other == GadgetStateNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getGadgetState() != 0) {
                    setGadgetState(other.getGadgetState());
                }
                if (other.getGadgetEntityId() != 0) {
                    setGadgetEntityId(other.getGadgetEntityId());
                }
                if (other.getIsEnableInteract()) {
                    setIsEnableInteract(other.getIsEnableInteract());
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
                GadgetStateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = GadgetStateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GadgetStateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GadgetStateNotifyOuterClass.GadgetStateNotifyOrBuilder
            public int getGadgetState() {
                return this.gadgetState_;
            }

            public Builder setGadgetState(int value) {
                this.gadgetState_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetState() {
                this.gadgetState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetStateNotifyOuterClass.GadgetStateNotifyOrBuilder
            public int getGadgetEntityId() {
                return this.gadgetEntityId_;
            }

            public Builder setGadgetEntityId(int value) {
                this.gadgetEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetEntityId() {
                this.gadgetEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetStateNotifyOuterClass.GadgetStateNotifyOrBuilder
            public boolean getIsEnableInteract() {
                return this.isEnableInteract_;
            }

            public Builder setIsEnableInteract(boolean value) {
                this.isEnableInteract_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEnableInteract() {
                this.isEnableInteract_ = false;
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

        public static GadgetStateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GadgetStateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GadgetStateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GadgetStateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
