package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnimatorParameterValueInfoOuterClass.class */
public final class AnimatorParameterValueInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n AnimatorParameterValueInfo.proto\"w\n\u001aAnimatorParameterValueInfo\u0012\u0011\n\tpara_type\u0018\u0001 \u0001(\r\u0012\u0011\n\u0007int_val\u0018\u0002 \u0001(\u0005H��\u0012\u0013\n\tfloat_val\u0018\u0003 \u0001(\u0002H��\u0012\u0012\n\bbool_val\u0018\u0004 \u0001(\bH��B\n\n\bpara_valB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AnimatorParameterValueInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AnimatorParameterValueInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AnimatorParameterValueInfo_descriptor, new String[]{"ParaType", "IntVal", "FloatVal", "BoolVal", "ParaVal"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnimatorParameterValueInfoOuterClass$AnimatorParameterValueInfoOrBuilder.class */
    public interface AnimatorParameterValueInfoOrBuilder extends MessageOrBuilder {
        int getParaType();

        boolean hasIntVal();

        int getIntVal();

        boolean hasFloatVal();

        float getFloatVal();

        boolean hasBoolVal();

        boolean getBoolVal();

        AnimatorParameterValueInfo.ParaValCase getParaValCase();
    }

    private AnimatorParameterValueInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnimatorParameterValueInfoOuterClass$AnimatorParameterValueInfo.class */
    public static final class AnimatorParameterValueInfo extends GeneratedMessageV3 implements AnimatorParameterValueInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int paraValCase_;
        private Object paraVal_;
        public static final int PARA_TYPE_FIELD_NUMBER = 1;
        private int paraType_;
        public static final int INT_VAL_FIELD_NUMBER = 2;
        public static final int FLOAT_VAL_FIELD_NUMBER = 3;
        public static final int BOOL_VAL_FIELD_NUMBER = 4;
        private byte memoizedIsInitialized;
        private static final AnimatorParameterValueInfo DEFAULT_INSTANCE = new AnimatorParameterValueInfo();
        private static final Parser<AnimatorParameterValueInfo> PARSER = new AbstractParser<AnimatorParameterValueInfo>() { // from class: emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.1
            @Override // com.google.protobuf.Parser
            public AnimatorParameterValueInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AnimatorParameterValueInfo(input, extensionRegistry);
            }
        };

        private AnimatorParameterValueInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.paraValCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private AnimatorParameterValueInfo() {
            this.paraValCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AnimatorParameterValueInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AnimatorParameterValueInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.paraType_ = input.readUInt32();
                                break;
                            case 16:
                                this.paraValCase_ = 2;
                                this.paraVal_ = Integer.valueOf(input.readInt32());
                                break;
                            case 29:
                                this.paraValCase_ = 3;
                                this.paraVal_ = Float.valueOf(input.readFloat());
                                break;
                            case 32:
                                this.paraValCase_ = 4;
                                this.paraVal_ = Boolean.valueOf(input.readBool());
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
            return AnimatorParameterValueInfoOuterClass.internal_static_AnimatorParameterValueInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AnimatorParameterValueInfoOuterClass.internal_static_AnimatorParameterValueInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AnimatorParameterValueInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnimatorParameterValueInfoOuterClass$AnimatorParameterValueInfo$ParaValCase.class */
        public enum ParaValCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            INT_VAL(2),
            FLOAT_VAL(3),
            BOOL_VAL(4),
            PARAVAL_NOT_SET(0);
            
            private final int value;

            ParaValCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ParaValCase valueOf(int value) {
                return forNumber(value);
            }

            public static ParaValCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return PARAVAL_NOT_SET;
                    case 1:
                    default:
                        return null;
                    case 2:
                        return INT_VAL;
                    case 3:
                        return FLOAT_VAL;
                    case 4:
                        return BOOL_VAL;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
        public ParaValCase getParaValCase() {
            return ParaValCase.forNumber(this.paraValCase_);
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
        public int getParaType() {
            return this.paraType_;
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
        public boolean hasIntVal() {
            return this.paraValCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
        public int getIntVal() {
            if (this.paraValCase_ == 2) {
                return ((Integer) this.paraVal_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
        public boolean hasFloatVal() {
            return this.paraValCase_ == 3;
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
        public float getFloatVal() {
            if (this.paraValCase_ == 3) {
                return ((Float) this.paraVal_).floatValue();
            }
            return 0.0f;
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
        public boolean hasBoolVal() {
            return this.paraValCase_ == 4;
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
        public boolean getBoolVal() {
            if (this.paraValCase_ == 4) {
                return ((Boolean) this.paraVal_).booleanValue();
            }
            return false;
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
            if (this.paraType_ != 0) {
                output.writeUInt32(1, this.paraType_);
            }
            if (this.paraValCase_ == 2) {
                output.writeInt32(2, ((Integer) this.paraVal_).intValue());
            }
            if (this.paraValCase_ == 3) {
                output.writeFloat(3, ((Float) this.paraVal_).floatValue());
            }
            if (this.paraValCase_ == 4) {
                output.writeBool(4, ((Boolean) this.paraVal_).booleanValue());
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
            if (this.paraType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.paraType_);
            }
            if (this.paraValCase_ == 2) {
                size2 += CodedOutputStream.computeInt32Size(2, ((Integer) this.paraVal_).intValue());
            }
            if (this.paraValCase_ == 3) {
                size2 += CodedOutputStream.computeFloatSize(3, ((Float) this.paraVal_).floatValue());
            }
            if (this.paraValCase_ == 4) {
                size2 += CodedOutputStream.computeBoolSize(4, ((Boolean) this.paraVal_).booleanValue());
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
            if (!(obj instanceof AnimatorParameterValueInfo)) {
                return equals(obj);
            }
            AnimatorParameterValueInfo other = (AnimatorParameterValueInfo) obj;
            if (getParaType() != other.getParaType() || !getParaValCase().equals(other.getParaValCase())) {
                return false;
            }
            switch (this.paraValCase_) {
                case 2:
                    if (getIntVal() != other.getIntVal()) {
                        return false;
                    }
                    break;
                case 3:
                    if (Float.floatToIntBits(getFloatVal()) != Float.floatToIntBits(other.getFloatVal())) {
                        return false;
                    }
                    break;
                case 4:
                    if (getBoolVal() != other.getBoolVal()) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getParaType();
            switch (this.paraValCase_) {
                case 2:
                    hash = (53 * ((37 * hash) + 2)) + getIntVal();
                    break;
                case 3:
                    hash = (53 * ((37 * hash) + 3)) + Float.floatToIntBits(getFloatVal());
                    break;
                case 4:
                    hash = (53 * ((37 * hash) + 4)) + Internal.hashBoolean(getBoolVal());
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AnimatorParameterValueInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AnimatorParameterValueInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AnimatorParameterValueInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AnimatorParameterValueInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AnimatorParameterValueInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AnimatorParameterValueInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AnimatorParameterValueInfo parseFrom(InputStream input) throws IOException {
            return (AnimatorParameterValueInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AnimatorParameterValueInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AnimatorParameterValueInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AnimatorParameterValueInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AnimatorParameterValueInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AnimatorParameterValueInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AnimatorParameterValueInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AnimatorParameterValueInfo parseFrom(CodedInputStream input) throws IOException {
            return (AnimatorParameterValueInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AnimatorParameterValueInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AnimatorParameterValueInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AnimatorParameterValueInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnimatorParameterValueInfoOuterClass$AnimatorParameterValueInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnimatorParameterValueInfoOrBuilder {
            private int paraValCase_ = 0;
            private Object paraVal_;
            private int paraType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AnimatorParameterValueInfoOuterClass.internal_static_AnimatorParameterValueInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AnimatorParameterValueInfoOuterClass.internal_static_AnimatorParameterValueInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AnimatorParameterValueInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AnimatorParameterValueInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.paraType_ = 0;
                this.paraValCase_ = 0;
                this.paraVal_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AnimatorParameterValueInfoOuterClass.internal_static_AnimatorParameterValueInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AnimatorParameterValueInfo getDefaultInstanceForType() {
                return AnimatorParameterValueInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AnimatorParameterValueInfo build() {
                AnimatorParameterValueInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AnimatorParameterValueInfo buildPartial() {
                AnimatorParameterValueInfo result = new AnimatorParameterValueInfo(this);
                result.paraType_ = this.paraType_;
                if (this.paraValCase_ == 2) {
                    result.paraVal_ = this.paraVal_;
                }
                if (this.paraValCase_ == 3) {
                    result.paraVal_ = this.paraVal_;
                }
                if (this.paraValCase_ == 4) {
                    result.paraVal_ = this.paraVal_;
                }
                result.paraValCase_ = this.paraValCase_;
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
                if (other instanceof AnimatorParameterValueInfo) {
                    return mergeFrom((AnimatorParameterValueInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AnimatorParameterValueInfo other) {
                if (other == AnimatorParameterValueInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getParaType() != 0) {
                    setParaType(other.getParaType());
                }
                switch (other.getParaValCase()) {
                    case INT_VAL:
                        setIntVal(other.getIntVal());
                        break;
                    case FLOAT_VAL:
                        setFloatVal(other.getFloatVal());
                        break;
                    case BOOL_VAL:
                        setBoolVal(other.getBoolVal());
                        break;
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
                AnimatorParameterValueInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AnimatorParameterValueInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AnimatorParameterValueInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
            public ParaValCase getParaValCase() {
                return ParaValCase.forNumber(this.paraValCase_);
            }

            public Builder clearParaVal() {
                this.paraValCase_ = 0;
                this.paraVal_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
            public int getParaType() {
                return this.paraType_;
            }

            public Builder setParaType(int value) {
                this.paraType_ = value;
                onChanged();
                return this;
            }

            public Builder clearParaType() {
                this.paraType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
            public boolean hasIntVal() {
                return this.paraValCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
            public int getIntVal() {
                if (this.paraValCase_ == 2) {
                    return ((Integer) this.paraVal_).intValue();
                }
                return 0;
            }

            public Builder setIntVal(int value) {
                this.paraValCase_ = 2;
                this.paraVal_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearIntVal() {
                if (this.paraValCase_ == 2) {
                    this.paraValCase_ = 0;
                    this.paraVal_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
            public boolean hasFloatVal() {
                return this.paraValCase_ == 3;
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
            public float getFloatVal() {
                if (this.paraValCase_ == 3) {
                    return ((Float) this.paraVal_).floatValue();
                }
                return 0.0f;
            }

            public Builder setFloatVal(float value) {
                this.paraValCase_ = 3;
                this.paraVal_ = Float.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearFloatVal() {
                if (this.paraValCase_ == 3) {
                    this.paraValCase_ = 0;
                    this.paraVal_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
            public boolean hasBoolVal() {
                return this.paraValCase_ == 4;
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder
            public boolean getBoolVal() {
                if (this.paraValCase_ == 4) {
                    return ((Boolean) this.paraVal_).booleanValue();
                }
                return false;
            }

            public Builder setBoolVal(boolean value) {
                this.paraValCase_ = 4;
                this.paraVal_ = Boolean.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearBoolVal() {
                if (this.paraValCase_ == 4) {
                    this.paraValCase_ = 0;
                    this.paraVal_ = null;
                    onChanged();
                }
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

        public static AnimatorParameterValueInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AnimatorParameterValueInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AnimatorParameterValueInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AnimatorParameterValueInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
