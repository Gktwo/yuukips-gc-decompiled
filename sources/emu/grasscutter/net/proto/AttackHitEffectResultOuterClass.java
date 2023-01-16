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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackHitEffectResultOuterClass.class */
public final class AttackHitEffectResultOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bAttackHitEffectResult.proto\"µ\u0001\n\u0015AttackHitEffectResult\u0012\u0014\n\fair_strength\u0018\r \u0001(\u0002\u0012\u001b\n\u0013hit_halt_time_scale\u0018\n \u0001(\u0002\u0012\u0015\n\rhit_halt_time\u0018\t \u0001(\u0002\u0012\u001b\n\u0013Unk3300_LCKECJCKKJK\u0018\b \u0001(\r\u0012\u001b\n\u0013Unk3300_KLNGDAMMFIF\u0018\u0001 \u0001(\r\u0012\u0018\n\u0010retreat_strength\u0018\u0003 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AttackHitEffectResult_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AttackHitEffectResult_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AttackHitEffectResult_descriptor, new String[]{"AirStrength", "HitHaltTimeScale", "HitHaltTime", "Unk3300LCKECJCKKJK", "Unk3300KLNGDAMMFIF", "RetreatStrength"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackHitEffectResultOuterClass$AttackHitEffectResultOrBuilder.class */
    public interface AttackHitEffectResultOrBuilder extends MessageOrBuilder {
        float getAirStrength();

        float getHitHaltTimeScale();

        float getHitHaltTime();

        int getUnk3300LCKECJCKKJK();

        int getUnk3300KLNGDAMMFIF();

        float getRetreatStrength();
    }

    private AttackHitEffectResultOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackHitEffectResultOuterClass$AttackHitEffectResult.class */
    public static final class AttackHitEffectResult extends GeneratedMessageV3 implements AttackHitEffectResultOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AIR_STRENGTH_FIELD_NUMBER = 13;
        private float airStrength_;
        public static final int HIT_HALT_TIME_SCALE_FIELD_NUMBER = 10;
        private float hitHaltTimeScale_;
        public static final int HIT_HALT_TIME_FIELD_NUMBER = 9;
        private float hitHaltTime_;
        public static final int UNK3300_LCKECJCKKJK_FIELD_NUMBER = 8;
        private int unk3300LCKECJCKKJK_;
        public static final int UNK3300_KLNGDAMMFIF_FIELD_NUMBER = 1;
        private int unk3300KLNGDAMMFIF_;
        public static final int RETREAT_STRENGTH_FIELD_NUMBER = 3;
        private float retreatStrength_;
        private byte memoizedIsInitialized;
        private static final AttackHitEffectResult DEFAULT_INSTANCE = new AttackHitEffectResult();
        private static final Parser<AttackHitEffectResult> PARSER = new AbstractParser<AttackHitEffectResult>() { // from class: emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResult.1
            @Override // com.google.protobuf.Parser
            public AttackHitEffectResult parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttackHitEffectResult(input, extensionRegistry);
            }
        };

        private AttackHitEffectResult(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttackHitEffectResult() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AttackHitEffectResult();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttackHitEffectResult(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.unk3300KLNGDAMMFIF_ = input.readUInt32();
                                break;
                            case 29:
                                this.retreatStrength_ = input.readFloat();
                                break;
                            case 64:
                                this.unk3300LCKECJCKKJK_ = input.readUInt32();
                                break;
                            case 77:
                                this.hitHaltTime_ = input.readFloat();
                                break;
                            case 85:
                                this.hitHaltTimeScale_ = input.readFloat();
                                break;
                            case 109:
                                this.airStrength_ = input.readFloat();
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
            return AttackHitEffectResultOuterClass.internal_static_AttackHitEffectResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttackHitEffectResultOuterClass.internal_static_AttackHitEffectResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AttackHitEffectResult.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
        public float getAirStrength() {
            return this.airStrength_;
        }

        @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
        public float getHitHaltTimeScale() {
            return this.hitHaltTimeScale_;
        }

        @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
        public float getHitHaltTime() {
            return this.hitHaltTime_;
        }

        @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
        public int getUnk3300LCKECJCKKJK() {
            return this.unk3300LCKECJCKKJK_;
        }

        @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
        public int getUnk3300KLNGDAMMFIF() {
            return this.unk3300KLNGDAMMFIF_;
        }

        @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
        public float getRetreatStrength() {
            return this.retreatStrength_;
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
            if (this.unk3300KLNGDAMMFIF_ != 0) {
                output.writeUInt32(1, this.unk3300KLNGDAMMFIF_);
            }
            if (this.retreatStrength_ != 0.0f) {
                output.writeFloat(3, this.retreatStrength_);
            }
            if (this.unk3300LCKECJCKKJK_ != 0) {
                output.writeUInt32(8, this.unk3300LCKECJCKKJK_);
            }
            if (this.hitHaltTime_ != 0.0f) {
                output.writeFloat(9, this.hitHaltTime_);
            }
            if (this.hitHaltTimeScale_ != 0.0f) {
                output.writeFloat(10, this.hitHaltTimeScale_);
            }
            if (this.airStrength_ != 0.0f) {
                output.writeFloat(13, this.airStrength_);
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
            if (this.unk3300KLNGDAMMFIF_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300KLNGDAMMFIF_);
            }
            if (this.retreatStrength_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(3, this.retreatStrength_);
            }
            if (this.unk3300LCKECJCKKJK_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.unk3300LCKECJCKKJK_);
            }
            if (this.hitHaltTime_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(9, this.hitHaltTime_);
            }
            if (this.hitHaltTimeScale_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(10, this.hitHaltTimeScale_);
            }
            if (this.airStrength_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(13, this.airStrength_);
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
            if (!(obj instanceof AttackHitEffectResult)) {
                return equals(obj);
            }
            AttackHitEffectResult other = (AttackHitEffectResult) obj;
            return Float.floatToIntBits(getAirStrength()) == Float.floatToIntBits(other.getAirStrength()) && Float.floatToIntBits(getHitHaltTimeScale()) == Float.floatToIntBits(other.getHitHaltTimeScale()) && Float.floatToIntBits(getHitHaltTime()) == Float.floatToIntBits(other.getHitHaltTime()) && getUnk3300LCKECJCKKJK() == other.getUnk3300LCKECJCKKJK() && getUnk3300KLNGDAMMFIF() == other.getUnk3300KLNGDAMMFIF() && Float.floatToIntBits(getRetreatStrength()) == Float.floatToIntBits(other.getRetreatStrength()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Float.floatToIntBits(getAirStrength()))) + 10)) + Float.floatToIntBits(getHitHaltTimeScale()))) + 9)) + Float.floatToIntBits(getHitHaltTime()))) + 8)) + getUnk3300LCKECJCKKJK())) + 1)) + getUnk3300KLNGDAMMFIF())) + 3)) + Float.floatToIntBits(getRetreatStrength()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AttackHitEffectResult parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AttackHitEffectResult parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttackHitEffectResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AttackHitEffectResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttackHitEffectResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AttackHitEffectResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttackHitEffectResult parseFrom(InputStream input) throws IOException {
            return (AttackHitEffectResult) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AttackHitEffectResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttackHitEffectResult) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AttackHitEffectResult parseDelimitedFrom(InputStream input) throws IOException {
            return (AttackHitEffectResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AttackHitEffectResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttackHitEffectResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AttackHitEffectResult parseFrom(CodedInputStream input) throws IOException {
            return (AttackHitEffectResult) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AttackHitEffectResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttackHitEffectResult) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttackHitEffectResult prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackHitEffectResultOuterClass$AttackHitEffectResult$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttackHitEffectResultOrBuilder {
            private float airStrength_;
            private float hitHaltTimeScale_;
            private float hitHaltTime_;
            private int unk3300LCKECJCKKJK_;
            private int unk3300KLNGDAMMFIF_;
            private float retreatStrength_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AttackHitEffectResultOuterClass.internal_static_AttackHitEffectResult_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttackHitEffectResultOuterClass.internal_static_AttackHitEffectResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AttackHitEffectResult.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AttackHitEffectResult.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.airStrength_ = 0.0f;
                this.hitHaltTimeScale_ = 0.0f;
                this.hitHaltTime_ = 0.0f;
                this.unk3300LCKECJCKKJK_ = 0;
                this.unk3300KLNGDAMMFIF_ = 0;
                this.retreatStrength_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AttackHitEffectResultOuterClass.internal_static_AttackHitEffectResult_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AttackHitEffectResult getDefaultInstanceForType() {
                return AttackHitEffectResult.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AttackHitEffectResult build() {
                AttackHitEffectResult result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AttackHitEffectResult buildPartial() {
                AttackHitEffectResult result = new AttackHitEffectResult(this);
                result.airStrength_ = this.airStrength_;
                result.hitHaltTimeScale_ = this.hitHaltTimeScale_;
                result.hitHaltTime_ = this.hitHaltTime_;
                result.unk3300LCKECJCKKJK_ = this.unk3300LCKECJCKKJK_;
                result.unk3300KLNGDAMMFIF_ = this.unk3300KLNGDAMMFIF_;
                result.retreatStrength_ = this.retreatStrength_;
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
                if (other instanceof AttackHitEffectResult) {
                    return mergeFrom((AttackHitEffectResult) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AttackHitEffectResult other) {
                if (other == AttackHitEffectResult.getDefaultInstance()) {
                    return this;
                }
                if (other.getAirStrength() != 0.0f) {
                    setAirStrength(other.getAirStrength());
                }
                if (other.getHitHaltTimeScale() != 0.0f) {
                    setHitHaltTimeScale(other.getHitHaltTimeScale());
                }
                if (other.getHitHaltTime() != 0.0f) {
                    setHitHaltTime(other.getHitHaltTime());
                }
                if (other.getUnk3300LCKECJCKKJK() != 0) {
                    setUnk3300LCKECJCKKJK(other.getUnk3300LCKECJCKKJK());
                }
                if (other.getUnk3300KLNGDAMMFIF() != 0) {
                    setUnk3300KLNGDAMMFIF(other.getUnk3300KLNGDAMMFIF());
                }
                if (other.getRetreatStrength() != 0.0f) {
                    setRetreatStrength(other.getRetreatStrength());
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
                AttackHitEffectResult parsedMessage = null;
                try {
                    try {
                        parsedMessage = AttackHitEffectResult.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AttackHitEffectResult) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
            public float getAirStrength() {
                return this.airStrength_;
            }

            public Builder setAirStrength(float value) {
                this.airStrength_ = value;
                onChanged();
                return this;
            }

            public Builder clearAirStrength() {
                this.airStrength_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
            public float getHitHaltTimeScale() {
                return this.hitHaltTimeScale_;
            }

            public Builder setHitHaltTimeScale(float value) {
                this.hitHaltTimeScale_ = value;
                onChanged();
                return this;
            }

            public Builder clearHitHaltTimeScale() {
                this.hitHaltTimeScale_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
            public float getHitHaltTime() {
                return this.hitHaltTime_;
            }

            public Builder setHitHaltTime(float value) {
                this.hitHaltTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearHitHaltTime() {
                this.hitHaltTime_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
            public int getUnk3300LCKECJCKKJK() {
                return this.unk3300LCKECJCKKJK_;
            }

            public Builder setUnk3300LCKECJCKKJK(int value) {
                this.unk3300LCKECJCKKJK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LCKECJCKKJK() {
                this.unk3300LCKECJCKKJK_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
            public int getUnk3300KLNGDAMMFIF() {
                return this.unk3300KLNGDAMMFIF_;
            }

            public Builder setUnk3300KLNGDAMMFIF(int value) {
                this.unk3300KLNGDAMMFIF_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KLNGDAMMFIF() {
                this.unk3300KLNGDAMMFIF_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder
            public float getRetreatStrength() {
                return this.retreatStrength_;
            }

            public Builder setRetreatStrength(float value) {
                this.retreatStrength_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetreatStrength() {
                this.retreatStrength_ = 0.0f;
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

        public static AttackHitEffectResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttackHitEffectResult> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AttackHitEffectResult> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AttackHitEffectResult getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
