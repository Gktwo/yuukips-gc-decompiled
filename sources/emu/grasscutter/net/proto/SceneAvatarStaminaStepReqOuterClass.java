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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAvatarStaminaStepReqOuterClass.class */
public final class SceneAvatarStaminaStepReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fSceneAvatarStaminaStepReq.proto\u001a\fVector.proto\"G\n\u0019SceneAvatarStaminaStepReq\u0012\u0014\n\u0003rot\u0018\u0004 \u0001(\u000b2\u0007.Vector\u0012\u0014\n\fuseClientRot\u0018\t \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneAvatarStaminaStepReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneAvatarStaminaStepReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneAvatarStaminaStepReq_descriptor, new String[]{"Rot", "UseClientRot"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAvatarStaminaStepReqOuterClass$SceneAvatarStaminaStepReqOrBuilder.class */
    public interface SceneAvatarStaminaStepReqOrBuilder extends MessageOrBuilder {
        boolean hasRot();

        VectorOuterClass.Vector getRot();

        VectorOuterClass.VectorOrBuilder getRotOrBuilder();

        boolean getUseClientRot();
    }

    private SceneAvatarStaminaStepReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAvatarStaminaStepReqOuterClass$SceneAvatarStaminaStepReq.class */
    public static final class SceneAvatarStaminaStepReq extends GeneratedMessageV3 implements SceneAvatarStaminaStepReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ROT_FIELD_NUMBER = 4;
        private VectorOuterClass.Vector rot_;
        public static final int USECLIENTROT_FIELD_NUMBER = 9;
        private boolean useClientRot_;
        private byte memoizedIsInitialized;
        private static final SceneAvatarStaminaStepReq DEFAULT_INSTANCE = new SceneAvatarStaminaStepReq();
        private static final Parser<SceneAvatarStaminaStepReq> PARSER = new AbstractParser<SceneAvatarStaminaStepReq>() { // from class: emu.grasscutter.net.proto.SceneAvatarStaminaStepReqOuterClass.SceneAvatarStaminaStepReq.1
            @Override // com.google.protobuf.Parser
            public SceneAvatarStaminaStepReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneAvatarStaminaStepReq(input, extensionRegistry);
            }
        };

        private SceneAvatarStaminaStepReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneAvatarStaminaStepReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneAvatarStaminaStepReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneAvatarStaminaStepReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 34:
                                    VectorOuterClass.Vector.Builder subBuilder = this.rot_ != null ? this.rot_.toBuilder() : null;
                                    this.rot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.rot_);
                                        this.rot_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 72:
                                    this.useClientRot_ = input.readBool();
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
            return SceneAvatarStaminaStepReqOuterClass.internal_static_SceneAvatarStaminaStepReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneAvatarStaminaStepReqOuterClass.internal_static_SceneAvatarStaminaStepReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneAvatarStaminaStepReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarStaminaStepReqOuterClass.SceneAvatarStaminaStepReqOrBuilder
        public boolean hasRot() {
            return this.rot_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarStaminaStepReqOuterClass.SceneAvatarStaminaStepReqOrBuilder
        public VectorOuterClass.Vector getRot() {
            return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarStaminaStepReqOuterClass.SceneAvatarStaminaStepReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getRotOrBuilder() {
            return getRot();
        }

        @Override // emu.grasscutter.net.proto.SceneAvatarStaminaStepReqOuterClass.SceneAvatarStaminaStepReqOrBuilder
        public boolean getUseClientRot() {
            return this.useClientRot_;
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
            if (this.rot_ != null) {
                output.writeMessage(4, getRot());
            }
            if (this.useClientRot_) {
                output.writeBool(9, this.useClientRot_);
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
            if (this.rot_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(4, getRot());
            }
            if (this.useClientRot_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.useClientRot_);
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
            if (!(obj instanceof SceneAvatarStaminaStepReq)) {
                return equals(obj);
            }
            SceneAvatarStaminaStepReq other = (SceneAvatarStaminaStepReq) obj;
            if (hasRot() != other.hasRot()) {
                return false;
            }
            return (!hasRot() || getRot().equals(other.getRot())) && getUseClientRot() == other.getUseClientRot() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasRot()) {
                hash = (53 * ((37 * hash) + 4)) + getRot().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + Internal.hashBoolean(getUseClientRot()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneAvatarStaminaStepReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneAvatarStaminaStepReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneAvatarStaminaStepReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneAvatarStaminaStepReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneAvatarStaminaStepReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneAvatarStaminaStepReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneAvatarStaminaStepReq parseFrom(InputStream input) throws IOException {
            return (SceneAvatarStaminaStepReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneAvatarStaminaStepReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneAvatarStaminaStepReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneAvatarStaminaStepReq parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneAvatarStaminaStepReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneAvatarStaminaStepReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneAvatarStaminaStepReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneAvatarStaminaStepReq parseFrom(CodedInputStream input) throws IOException {
            return (SceneAvatarStaminaStepReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneAvatarStaminaStepReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneAvatarStaminaStepReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneAvatarStaminaStepReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneAvatarStaminaStepReqOuterClass$SceneAvatarStaminaStepReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneAvatarStaminaStepReqOrBuilder {
            private VectorOuterClass.Vector rot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> rotBuilder_;
            private boolean useClientRot_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneAvatarStaminaStepReqOuterClass.internal_static_SceneAvatarStaminaStepReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneAvatarStaminaStepReqOuterClass.internal_static_SceneAvatarStaminaStepReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneAvatarStaminaStepReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneAvatarStaminaStepReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.rotBuilder_ == null) {
                    this.rot_ = null;
                } else {
                    this.rot_ = null;
                    this.rotBuilder_ = null;
                }
                this.useClientRot_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneAvatarStaminaStepReqOuterClass.internal_static_SceneAvatarStaminaStepReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneAvatarStaminaStepReq getDefaultInstanceForType() {
                return SceneAvatarStaminaStepReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneAvatarStaminaStepReq build() {
                SceneAvatarStaminaStepReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneAvatarStaminaStepReq buildPartial() {
                SceneAvatarStaminaStepReq result = new SceneAvatarStaminaStepReq(this);
                if (this.rotBuilder_ == null) {
                    result.rot_ = this.rot_;
                } else {
                    result.rot_ = this.rotBuilder_.build();
                }
                result.useClientRot_ = this.useClientRot_;
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
                if (other instanceof SceneAvatarStaminaStepReq) {
                    return mergeFrom((SceneAvatarStaminaStepReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneAvatarStaminaStepReq other) {
                if (other == SceneAvatarStaminaStepReq.getDefaultInstance()) {
                    return this;
                }
                if (other.hasRot()) {
                    mergeRot(other.getRot());
                }
                if (other.getUseClientRot()) {
                    setUseClientRot(other.getUseClientRot());
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
                SceneAvatarStaminaStepReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneAvatarStaminaStepReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneAvatarStaminaStepReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarStaminaStepReqOuterClass.SceneAvatarStaminaStepReqOrBuilder
            public boolean hasRot() {
                return (this.rotBuilder_ == null && this.rot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarStaminaStepReqOuterClass.SceneAvatarStaminaStepReqOrBuilder
            public VectorOuterClass.Vector getRot() {
                if (this.rotBuilder_ == null) {
                    return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
                }
                return this.rotBuilder_.getMessage();
            }

            public Builder setRot(VectorOuterClass.Vector value) {
                if (this.rotBuilder_ != null) {
                    this.rotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRot(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.rotBuilder_ == null) {
                    this.rot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRot(VectorOuterClass.Vector value) {
                if (this.rotBuilder_ == null) {
                    if (this.rot_ != null) {
                        this.rot_ = VectorOuterClass.Vector.newBuilder(this.rot_).mergeFrom(value).buildPartial();
                    } else {
                        this.rot_ = value;
                    }
                    onChanged();
                } else {
                    this.rotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRot() {
                if (this.rotBuilder_ == null) {
                    this.rot_ = null;
                    onChanged();
                } else {
                    this.rot_ = null;
                    this.rotBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getRotBuilder() {
                onChanged();
                return getRotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarStaminaStepReqOuterClass.SceneAvatarStaminaStepReqOrBuilder
            public VectorOuterClass.VectorOrBuilder getRotOrBuilder() {
                if (this.rotBuilder_ != null) {
                    return this.rotBuilder_.getMessageOrBuilder();
                }
                return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getRotFieldBuilder() {
                if (this.rotBuilder_ == null) {
                    this.rotBuilder_ = new SingleFieldBuilderV3<>(getRot(), getParentForChildren(), isClean());
                    this.rot_ = null;
                }
                return this.rotBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneAvatarStaminaStepReqOuterClass.SceneAvatarStaminaStepReqOrBuilder
            public boolean getUseClientRot() {
                return this.useClientRot_;
            }

            public Builder setUseClientRot(boolean value) {
                this.useClientRot_ = value;
                onChanged();
                return this;
            }

            public Builder clearUseClientRot() {
                this.useClientRot_ = false;
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

        public static SceneAvatarStaminaStepReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneAvatarStaminaStepReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneAvatarStaminaStepReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneAvatarStaminaStepReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
