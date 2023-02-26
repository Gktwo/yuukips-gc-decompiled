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
import emu.grasscutter.net.proto.PropChangeReasonOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerPropChangeReasonNotifyOuterClass.class */
public final class PlayerPropChangeReasonNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"PlayerPropChangeReasonNotify.proto\u001a\u0016PropChangeReason.proto\"w\n\u001cPlayerPropChangeReasonNotify\u0012\u0010\n\bpropType\u0018\u0006 \u0001(\r\u0012\u0010\n\boldValue\u0018\f \u0001(\u0002\u0012\u0010\n\bcurValue\u0018\t \u0001(\u0002\u0012!\n\u0006reason\u0018\u0001 \u0001(\u000e2\u0011.PropChangeReasonB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PropChangeReasonOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerPropChangeReasonNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerPropChangeReasonNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerPropChangeReasonNotify_descriptor, new String[]{"PropType", "OldValue", "CurValue", "Reason"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerPropChangeReasonNotifyOuterClass$PlayerPropChangeReasonNotifyOrBuilder.class */
    public interface PlayerPropChangeReasonNotifyOrBuilder extends MessageOrBuilder {
        int getPropType();

        float getOldValue();

        float getCurValue();

        int getReasonValue();

        PropChangeReasonOuterClass.PropChangeReason getReason();
    }

    private PlayerPropChangeReasonNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerPropChangeReasonNotifyOuterClass$PlayerPropChangeReasonNotify.class */
    public static final class PlayerPropChangeReasonNotify extends GeneratedMessageV3 implements PlayerPropChangeReasonNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PROPTYPE_FIELD_NUMBER = 6;
        private int propType_;
        public static final int OLDVALUE_FIELD_NUMBER = 12;
        private float oldValue_;
        public static final int CURVALUE_FIELD_NUMBER = 9;
        private float curValue_;
        public static final int REASON_FIELD_NUMBER = 1;
        private int reason_;
        private byte memoizedIsInitialized;
        private static final PlayerPropChangeReasonNotify DEFAULT_INSTANCE = new PlayerPropChangeReasonNotify();
        private static final Parser<PlayerPropChangeReasonNotify> PARSER = new AbstractParser<PlayerPropChangeReasonNotify>() { // from class: emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerPropChangeReasonNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerPropChangeReasonNotify(input, extensionRegistry);
            }
        };

        private PlayerPropChangeReasonNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerPropChangeReasonNotify() {
            this.memoizedIsInitialized = -1;
            this.reason_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerPropChangeReasonNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerPropChangeReasonNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.reason_ = input.readEnum();
                                break;
                            case 48:
                                this.propType_ = input.readUInt32();
                                break;
                            case 77:
                                this.curValue_ = input.readFloat();
                                break;
                            case 101:
                                this.oldValue_ = input.readFloat();
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
            return PlayerPropChangeReasonNotifyOuterClass.internal_static_PlayerPropChangeReasonNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerPropChangeReasonNotifyOuterClass.internal_static_PlayerPropChangeReasonNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerPropChangeReasonNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotifyOrBuilder
        public int getPropType() {
            return this.propType_;
        }

        @Override // emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotifyOrBuilder
        public float getOldValue() {
            return this.oldValue_;
        }

        @Override // emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotifyOrBuilder
        public float getCurValue() {
            return this.curValue_;
        }

        @Override // emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotifyOrBuilder
        public int getReasonValue() {
            return this.reason_;
        }

        @Override // emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotifyOrBuilder
        public PropChangeReasonOuterClass.PropChangeReason getReason() {
            PropChangeReasonOuterClass.PropChangeReason result = PropChangeReasonOuterClass.PropChangeReason.valueOf(this.reason_);
            return result == null ? PropChangeReasonOuterClass.PropChangeReason.UNRECOGNIZED : result;
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
            if (this.reason_ != PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_NONE.getNumber()) {
                output.writeEnum(1, this.reason_);
            }
            if (this.propType_ != 0) {
                output.writeUInt32(6, this.propType_);
            }
            if (this.curValue_ != 0.0f) {
                output.writeFloat(9, this.curValue_);
            }
            if (this.oldValue_ != 0.0f) {
                output.writeFloat(12, this.oldValue_);
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
            if (this.reason_ != PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.reason_);
            }
            if (this.propType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.propType_);
            }
            if (this.curValue_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(9, this.curValue_);
            }
            if (this.oldValue_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(12, this.oldValue_);
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
            if (!(obj instanceof PlayerPropChangeReasonNotify)) {
                return equals(obj);
            }
            PlayerPropChangeReasonNotify other = (PlayerPropChangeReasonNotify) obj;
            return getPropType() == other.getPropType() && Float.floatToIntBits(getOldValue()) == Float.floatToIntBits(other.getOldValue()) && Float.floatToIntBits(getCurValue()) == Float.floatToIntBits(other.getCurValue()) && this.reason_ == other.reason_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getPropType())) + 12)) + Float.floatToIntBits(getOldValue()))) + 9)) + Float.floatToIntBits(getCurValue()))) + 1)) + this.reason_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerPropChangeReasonNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerPropChangeReasonNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerPropChangeReasonNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerPropChangeReasonNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerPropChangeReasonNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerPropChangeReasonNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerPropChangeReasonNotify parseFrom(InputStream input) throws IOException {
            return (PlayerPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerPropChangeReasonNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerPropChangeReasonNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerPropChangeReasonNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerPropChangeReasonNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerPropChangeReasonNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerPropChangeReasonNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerPropChangeReasonNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerPropChangeReasonNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerPropChangeReasonNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerPropChangeReasonNotifyOuterClass$PlayerPropChangeReasonNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerPropChangeReasonNotifyOrBuilder {
            private int propType_;
            private float oldValue_;
            private float curValue_;
            private int reason_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerPropChangeReasonNotifyOuterClass.internal_static_PlayerPropChangeReasonNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerPropChangeReasonNotifyOuterClass.internal_static_PlayerPropChangeReasonNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerPropChangeReasonNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerPropChangeReasonNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.propType_ = 0;
                this.oldValue_ = 0.0f;
                this.curValue_ = 0.0f;
                this.reason_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerPropChangeReasonNotifyOuterClass.internal_static_PlayerPropChangeReasonNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerPropChangeReasonNotify getDefaultInstanceForType() {
                return PlayerPropChangeReasonNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerPropChangeReasonNotify build() {
                PlayerPropChangeReasonNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerPropChangeReasonNotify buildPartial() {
                PlayerPropChangeReasonNotify result = new PlayerPropChangeReasonNotify(this);
                result.propType_ = this.propType_;
                result.oldValue_ = this.oldValue_;
                result.curValue_ = this.curValue_;
                result.reason_ = this.reason_;
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
                if (other instanceof PlayerPropChangeReasonNotify) {
                    return mergeFrom((PlayerPropChangeReasonNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerPropChangeReasonNotify other) {
                if (other == PlayerPropChangeReasonNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getPropType() != 0) {
                    setPropType(other.getPropType());
                }
                if (other.getOldValue() != 0.0f) {
                    setOldValue(other.getOldValue());
                }
                if (other.getCurValue() != 0.0f) {
                    setCurValue(other.getCurValue());
                }
                if (other.reason_ != 0) {
                    setReasonValue(other.getReasonValue());
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
                PlayerPropChangeReasonNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerPropChangeReasonNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerPropChangeReasonNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotifyOrBuilder
            public int getReasonValue() {
                return this.reason_;
            }

            public Builder setReasonValue(int value) {
                this.reason_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotifyOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static PlayerPropChangeReasonNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerPropChangeReasonNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerPropChangeReasonNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerPropChangeReasonNotify getDefaultInstanceForType() {
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
