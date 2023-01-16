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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ForwardTypeOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtDoSkillSuccNotifyOuterClass.class */
public final class EvtDoSkillSuccNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aEvtDoSkillSuccNotify.proto\u001a\u0011ForwardType.proto\u001a\fVector.proto\"y\n\u0014EvtDoSkillSuccNotify\u0012\u0011\n\tcaster_id\u0018\u000f \u0001(\r\u0012\"\n\fforward_type\u0018\t \u0001(\u000e2\f.ForwardType\u0012\u0010\n\bskill_id\u0018\u000e \u0001(\r\u0012\u0018\n\u0007forward\u0018\r \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ForwardTypeOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EvtDoSkillSuccNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EvtDoSkillSuccNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtDoSkillSuccNotify_descriptor, new String[]{"CasterId", "ForwardType", "SkillId", "Forward"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtDoSkillSuccNotifyOuterClass$EvtDoSkillSuccNotifyOrBuilder.class */
    public interface EvtDoSkillSuccNotifyOrBuilder extends MessageOrBuilder {
        int getCasterId();

        int getForwardTypeValue();

        ForwardTypeOuterClass.ForwardType getForwardType();

        int getSkillId();

        boolean hasForward();

        VectorOuterClass.Vector getForward();

        VectorOuterClass.VectorOrBuilder getForwardOrBuilder();
    }

    private EvtDoSkillSuccNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtDoSkillSuccNotifyOuterClass$EvtDoSkillSuccNotify.class */
    public static final class EvtDoSkillSuccNotify extends GeneratedMessageV3 implements EvtDoSkillSuccNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CASTER_ID_FIELD_NUMBER = 15;
        private int casterId_;
        public static final int FORWARD_TYPE_FIELD_NUMBER = 9;
        private int forwardType_;
        public static final int SKILL_ID_FIELD_NUMBER = 14;
        private int skillId_;
        public static final int FORWARD_FIELD_NUMBER = 13;
        private VectorOuterClass.Vector forward_;
        private byte memoizedIsInitialized;
        private static final EvtDoSkillSuccNotify DEFAULT_INSTANCE = new EvtDoSkillSuccNotify();
        private static final Parser<EvtDoSkillSuccNotify> PARSER = new AbstractParser<EvtDoSkillSuccNotify>() { // from class: emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotify.1
            @Override // com.google.protobuf.Parser
            public EvtDoSkillSuccNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtDoSkillSuccNotify(input, extensionRegistry);
            }
        };

        private EvtDoSkillSuccNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EvtDoSkillSuccNotify() {
            this.memoizedIsInitialized = -1;
            this.forwardType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtDoSkillSuccNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EvtDoSkillSuccNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 72:
                                this.forwardType_ = input.readEnum();
                                break;
                            case 106:
                                VectorOuterClass.Vector.Builder subBuilder = this.forward_ != null ? this.forward_.toBuilder() : null;
                                this.forward_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.forward_);
                                    this.forward_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 112:
                                this.skillId_ = input.readUInt32();
                                break;
                            case 120:
                                this.casterId_ = input.readUInt32();
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
            return EvtDoSkillSuccNotifyOuterClass.internal_static_EvtDoSkillSuccNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtDoSkillSuccNotifyOuterClass.internal_static_EvtDoSkillSuccNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtDoSkillSuccNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
        public int getCasterId() {
            return this.casterId_;
        }

        @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
        public int getForwardTypeValue() {
            return this.forwardType_;
        }

        @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
        public ForwardTypeOuterClass.ForwardType getForwardType() {
            ForwardTypeOuterClass.ForwardType result = ForwardTypeOuterClass.ForwardType.valueOf(this.forwardType_);
            return result == null ? ForwardTypeOuterClass.ForwardType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
        public int getSkillId() {
            return this.skillId_;
        }

        @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
        public boolean hasForward() {
            return this.forward_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
        public VectorOuterClass.Vector getForward() {
            return this.forward_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.forward_;
        }

        @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getForwardOrBuilder() {
            return getForward();
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
            if (this.forwardType_ != ForwardTypeOuterClass.ForwardType.FORWARD_TYPE_LOCAL.getNumber()) {
                output.writeEnum(9, this.forwardType_);
            }
            if (this.forward_ != null) {
                output.writeMessage(13, getForward());
            }
            if (this.skillId_ != 0) {
                output.writeUInt32(14, this.skillId_);
            }
            if (this.casterId_ != 0) {
                output.writeUInt32(15, this.casterId_);
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
            if (this.forwardType_ != ForwardTypeOuterClass.ForwardType.FORWARD_TYPE_LOCAL.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(9, this.forwardType_);
            }
            if (this.forward_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getForward());
            }
            if (this.skillId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.skillId_);
            }
            if (this.casterId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.casterId_);
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
            if (!(obj instanceof EvtDoSkillSuccNotify)) {
                return equals(obj);
            }
            EvtDoSkillSuccNotify other = (EvtDoSkillSuccNotify) obj;
            if (getCasterId() == other.getCasterId() && this.forwardType_ == other.forwardType_ && getSkillId() == other.getSkillId() && hasForward() == other.hasForward()) {
                return (!hasForward() || getForward().equals(other.getForward())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getCasterId())) + 9)) + this.forwardType_)) + 14)) + getSkillId();
            if (hasForward()) {
                hash = (53 * ((37 * hash) + 13)) + getForward().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EvtDoSkillSuccNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtDoSkillSuccNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtDoSkillSuccNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtDoSkillSuccNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtDoSkillSuccNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtDoSkillSuccNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtDoSkillSuccNotify parseFrom(InputStream input) throws IOException {
            return (EvtDoSkillSuccNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtDoSkillSuccNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtDoSkillSuccNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtDoSkillSuccNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtDoSkillSuccNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtDoSkillSuccNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtDoSkillSuccNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtDoSkillSuccNotify parseFrom(CodedInputStream input) throws IOException {
            return (EvtDoSkillSuccNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtDoSkillSuccNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtDoSkillSuccNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtDoSkillSuccNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtDoSkillSuccNotifyOuterClass$EvtDoSkillSuccNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtDoSkillSuccNotifyOrBuilder {
            private int casterId_;
            private int forwardType_ = 0;
            private int skillId_;
            private VectorOuterClass.Vector forward_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> forwardBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtDoSkillSuccNotifyOuterClass.internal_static_EvtDoSkillSuccNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtDoSkillSuccNotifyOuterClass.internal_static_EvtDoSkillSuccNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtDoSkillSuccNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtDoSkillSuccNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.casterId_ = 0;
                this.forwardType_ = 0;
                this.skillId_ = 0;
                if (this.forwardBuilder_ == null) {
                    this.forward_ = null;
                } else {
                    this.forward_ = null;
                    this.forwardBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtDoSkillSuccNotifyOuterClass.internal_static_EvtDoSkillSuccNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtDoSkillSuccNotify getDefaultInstanceForType() {
                return EvtDoSkillSuccNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtDoSkillSuccNotify build() {
                EvtDoSkillSuccNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtDoSkillSuccNotify buildPartial() {
                EvtDoSkillSuccNotify result = new EvtDoSkillSuccNotify(this);
                result.casterId_ = this.casterId_;
                result.forwardType_ = this.forwardType_;
                result.skillId_ = this.skillId_;
                if (this.forwardBuilder_ == null) {
                    result.forward_ = this.forward_;
                } else {
                    result.forward_ = this.forwardBuilder_.build();
                }
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
                if (other instanceof EvtDoSkillSuccNotify) {
                    return mergeFrom((EvtDoSkillSuccNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtDoSkillSuccNotify other) {
                if (other == EvtDoSkillSuccNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getCasterId() != 0) {
                    setCasterId(other.getCasterId());
                }
                if (other.forwardType_ != 0) {
                    setForwardTypeValue(other.getForwardTypeValue());
                }
                if (other.getSkillId() != 0) {
                    setSkillId(other.getSkillId());
                }
                if (other.hasForward()) {
                    mergeForward(other.getForward());
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
                EvtDoSkillSuccNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtDoSkillSuccNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtDoSkillSuccNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
            public int getCasterId() {
                return this.casterId_;
            }

            public Builder setCasterId(int value) {
                this.casterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCasterId() {
                this.casterId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
            public int getForwardTypeValue() {
                return this.forwardType_;
            }

            public Builder setForwardTypeValue(int value) {
                this.forwardType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
            public ForwardTypeOuterClass.ForwardType getForwardType() {
                ForwardTypeOuterClass.ForwardType result = ForwardTypeOuterClass.ForwardType.valueOf(this.forwardType_);
                return result == null ? ForwardTypeOuterClass.ForwardType.UNRECOGNIZED : result;
            }

            public Builder setForwardType(ForwardTypeOuterClass.ForwardType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.forwardType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearForwardType() {
                this.forwardType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
            public int getSkillId() {
                return this.skillId_;
            }

            public Builder setSkillId(int value) {
                this.skillId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSkillId() {
                this.skillId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
            public boolean hasForward() {
                return (this.forwardBuilder_ == null && this.forward_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
            public VectorOuterClass.Vector getForward() {
                if (this.forwardBuilder_ == null) {
                    return this.forward_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.forward_;
                }
                return this.forwardBuilder_.getMessage();
            }

            public Builder setForward(VectorOuterClass.Vector value) {
                if (this.forwardBuilder_ != null) {
                    this.forwardBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.forward_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setForward(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.forwardBuilder_ == null) {
                    this.forward_ = builderForValue.build();
                    onChanged();
                } else {
                    this.forwardBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeForward(VectorOuterClass.Vector value) {
                if (this.forwardBuilder_ == null) {
                    if (this.forward_ != null) {
                        this.forward_ = VectorOuterClass.Vector.newBuilder(this.forward_).mergeFrom(value).buildPartial();
                    } else {
                        this.forward_ = value;
                    }
                    onChanged();
                } else {
                    this.forwardBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearForward() {
                if (this.forwardBuilder_ == null) {
                    this.forward_ = null;
                    onChanged();
                } else {
                    this.forward_ = null;
                    this.forwardBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getForwardBuilder() {
                onChanged();
                return getForwardFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getForwardOrBuilder() {
                if (this.forwardBuilder_ != null) {
                    return this.forwardBuilder_.getMessageOrBuilder();
                }
                return this.forward_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.forward_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getForwardFieldBuilder() {
                if (this.forwardBuilder_ == null) {
                    this.forwardBuilder_ = new SingleFieldBuilderV3<>(getForward(), getParentForChildren(), isClean());
                    this.forward_ = null;
                }
                return this.forwardBuilder_;
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

        public static EvtDoSkillSuccNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtDoSkillSuccNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtDoSkillSuccNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtDoSkillSuccNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ForwardTypeOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
