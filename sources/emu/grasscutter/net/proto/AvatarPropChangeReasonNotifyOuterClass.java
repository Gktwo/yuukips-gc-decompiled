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
import emu.grasscutter.net.proto.PropChangeReasonOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarPropChangeReasonNotifyOuterClass.class */
public final class AvatarPropChangeReasonNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"AvatarPropChangeReasonNotify.proto\u001a\u0016PropChangeReason.proto\"\u0001\n\u001cAvatarPropChangeReasonNotify\u0012\u0011\n\tprop_type\u0018\u0007 \u0001(\r\u0012!\n\u0006reason\u0018\u000f \u0001(\u000e2\u0011.PropChangeReason\u0012\u0011\n\tcur_value\u0018\u000e \u0001(\u0002\u0012\u0013\n\u000bavatar_guid\u0018\u0003 \u0001(\u0004\u0012\u0011\n\told_value\u0018\r \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PropChangeReasonOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarPropChangeReasonNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarPropChangeReasonNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarPropChangeReasonNotify_descriptor, new String[]{"PropType", "Reason", "CurValue", "AvatarGuid", "OldValue"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarPropChangeReasonNotifyOuterClass$AvatarPropChangeReasonNotifyOrBuilder.class */
    public interface AvatarPropChangeReasonNotifyOrBuilder extends MessageOrBuilder {
        int getPropType();

        int getReasonValue();

        PropChangeReasonOuterClass.PropChangeReason getReason();

        float getCurValue();

        long getAvatarGuid();

        float getOldValue();
    }

    private AvatarPropChangeReasonNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarPropChangeReasonNotifyOuterClass$AvatarPropChangeReasonNotify.class */
    public static final class AvatarPropChangeReasonNotify extends GeneratedMessageV3 implements AvatarPropChangeReasonNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PROP_TYPE_FIELD_NUMBER = 7;
        private int propType_;
        public static final int REASON_FIELD_NUMBER = 15;
        private int reason_;
        public static final int CUR_VALUE_FIELD_NUMBER = 14;
        private float curValue_;
        public static final int AVATAR_GUID_FIELD_NUMBER = 3;
        private long avatarGuid_;
        public static final int OLD_VALUE_FIELD_NUMBER = 13;
        private float oldValue_;
        private byte memoizedIsInitialized;
        private static final AvatarPropChangeReasonNotify DEFAULT_INSTANCE = new AvatarPropChangeReasonNotify();
        private static final Parser<AvatarPropChangeReasonNotify> PARSER = new AbstractParser<AvatarPropChangeReasonNotify>() { // from class: emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarPropChangeReasonNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarPropChangeReasonNotify(input, extensionRegistry);
            }
        };

        private AvatarPropChangeReasonNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarPropChangeReasonNotify() {
            this.memoizedIsInitialized = -1;
            this.reason_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarPropChangeReasonNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarPropChangeReasonNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 56:
                                this.propType_ = input.readUInt32();
                                break;
                            case 109:
                                this.oldValue_ = input.readFloat();
                                break;
                            case 117:
                                this.curValue_ = input.readFloat();
                                break;
                            case 120:
                                this.reason_ = input.readEnum();
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
            return AvatarPropChangeReasonNotifyOuterClass.internal_static_AvatarPropChangeReasonNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarPropChangeReasonNotifyOuterClass.internal_static_AvatarPropChangeReasonNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarPropChangeReasonNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
        public int getPropType() {
            return this.propType_;
        }

        @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
        public int getReasonValue() {
            return this.reason_;
        }

        @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
        public PropChangeReasonOuterClass.PropChangeReason getReason() {
            PropChangeReasonOuterClass.PropChangeReason result = PropChangeReasonOuterClass.PropChangeReason.valueOf(this.reason_);
            return result == null ? PropChangeReasonOuterClass.PropChangeReason.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
        public float getCurValue() {
            return this.curValue_;
        }

        @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
        public float getOldValue() {
            return this.oldValue_;
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
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(3, this.avatarGuid_);
            }
            if (this.propType_ != 0) {
                output.writeUInt32(7, this.propType_);
            }
            if (this.oldValue_ != 0.0f) {
                output.writeFloat(13, this.oldValue_);
            }
            if (this.curValue_ != 0.0f) {
                output.writeFloat(14, this.curValue_);
            }
            if (this.reason_ != PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_NONE.getNumber()) {
                output.writeEnum(15, this.reason_);
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
            if (this.avatarGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(3, this.avatarGuid_);
            }
            if (this.propType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.propType_);
            }
            if (this.oldValue_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(13, this.oldValue_);
            }
            if (this.curValue_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(14, this.curValue_);
            }
            if (this.reason_ != PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(15, this.reason_);
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
            if (!(obj instanceof AvatarPropChangeReasonNotify)) {
                return equals(obj);
            }
            AvatarPropChangeReasonNotify other = (AvatarPropChangeReasonNotify) obj;
            return getPropType() == other.getPropType() && this.reason_ == other.reason_ && Float.floatToIntBits(getCurValue()) == Float.floatToIntBits(other.getCurValue()) && getAvatarGuid() == other.getAvatarGuid() && Float.floatToIntBits(getOldValue()) == Float.floatToIntBits(other.getOldValue()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getPropType())) + 15)) + this.reason_)) + 14)) + Float.floatToIntBits(getCurValue()))) + 3)) + Internal.hashLong(getAvatarGuid()))) + 13)) + Float.floatToIntBits(getOldValue()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarPropChangeReasonNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarPropChangeReasonNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarPropChangeReasonNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarPropChangeReasonNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarPropChangeReasonNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarPropChangeReasonNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarPropChangeReasonNotify parseFrom(InputStream input) throws IOException {
            return (AvatarPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarPropChangeReasonNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarPropChangeReasonNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarPropChangeReasonNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarPropChangeReasonNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarPropChangeReasonNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarPropChangeReasonNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarPropChangeReasonNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarPropChangeReasonNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarPropChangeReasonNotifyOuterClass$AvatarPropChangeReasonNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarPropChangeReasonNotifyOrBuilder {
            private int propType_;
            private int reason_ = 0;
            private float curValue_;
            private long avatarGuid_;
            private float oldValue_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarPropChangeReasonNotifyOuterClass.internal_static_AvatarPropChangeReasonNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarPropChangeReasonNotifyOuterClass.internal_static_AvatarPropChangeReasonNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarPropChangeReasonNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarPropChangeReasonNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.propType_ = 0;
                this.reason_ = 0;
                this.curValue_ = 0.0f;
                this.avatarGuid_ = 0;
                this.oldValue_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarPropChangeReasonNotifyOuterClass.internal_static_AvatarPropChangeReasonNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarPropChangeReasonNotify getDefaultInstanceForType() {
                return AvatarPropChangeReasonNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarPropChangeReasonNotify build() {
                AvatarPropChangeReasonNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarPropChangeReasonNotify buildPartial() {
                AvatarPropChangeReasonNotify result = new AvatarPropChangeReasonNotify(this);
                result.propType_ = this.propType_;
                result.reason_ = this.reason_;
                result.curValue_ = this.curValue_;
                result.avatarGuid_ = this.avatarGuid_;
                result.oldValue_ = this.oldValue_;
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
                if (other instanceof AvatarPropChangeReasonNotify) {
                    return mergeFrom((AvatarPropChangeReasonNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarPropChangeReasonNotify other) {
                if (other == AvatarPropChangeReasonNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getPropType() != 0) {
                    setPropType(other.getPropType());
                }
                if (other.reason_ != 0) {
                    setReasonValue(other.getReasonValue());
                }
                if (other.getCurValue() != 0.0f) {
                    setCurValue(other.getCurValue());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getOldValue() != 0.0f) {
                    setOldValue(other.getOldValue());
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
                AvatarPropChangeReasonNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarPropChangeReasonNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarPropChangeReasonNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
            public int getPropType() {
                return this.propType_;
            }

            public Builder setPropType(int value) {
                this.propType_ = value;
                onChanged();
                return this;
            }

            public Builder clearPropType() {
                this.propType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
            public int getReasonValue() {
                return this.reason_;
            }

            public Builder setReasonValue(int value) {
                this.reason_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
            public PropChangeReasonOuterClass.PropChangeReason getReason() {
                PropChangeReasonOuterClass.PropChangeReason result = PropChangeReasonOuterClass.PropChangeReason.valueOf(this.reason_);
                return result == null ? PropChangeReasonOuterClass.PropChangeReason.UNRECOGNIZED : result;
            }

            public Builder setReason(PropChangeReasonOuterClass.PropChangeReason value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.reason_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
            public float getCurValue() {
                return this.curValue_;
            }

            public Builder setCurValue(float value) {
                this.curValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurValue() {
                this.curValue_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarPropChangeReasonNotifyOuterClass.AvatarPropChangeReasonNotifyOrBuilder
            public float getOldValue() {
                return this.oldValue_;
            }

            public Builder setOldValue(float value) {
                this.oldValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearOldValue() {
                this.oldValue_ = 0.0f;
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

        public static AvatarPropChangeReasonNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarPropChangeReasonNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarPropChangeReasonNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarPropChangeReasonNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PropChangeReasonOuterClass.getDescriptor();
    }
}
