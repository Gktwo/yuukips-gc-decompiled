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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusFighterMonsterDetailOuterClass.class */
public final class FungusFighterMonsterDetailOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n FungusFighterMonsterDetail.proto\"X\n\u001aFungusFighterMonsterDetail\u0012\u0017\n\u000fcurHpPercentage\u0018\t \u0001(\u0002\u0012\u0010\n\bfungusId\u0018\n \u0001(\r\u0012\u000f\n\u0007isAlive\u0018\f \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FungusFighterMonsterDetail_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FungusFighterMonsterDetail_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FungusFighterMonsterDetail_descriptor, new String[]{"CurHpPercentage", "FungusId", "IsAlive"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusFighterMonsterDetailOuterClass$FungusFighterMonsterDetailOrBuilder.class */
    public interface FungusFighterMonsterDetailOrBuilder extends MessageOrBuilder {
        float getCurHpPercentage();

        int getFungusId();

        boolean getIsAlive();
    }

    private FungusFighterMonsterDetailOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusFighterMonsterDetailOuterClass$FungusFighterMonsterDetail.class */
    public static final class FungusFighterMonsterDetail extends GeneratedMessageV3 implements FungusFighterMonsterDetailOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CURHPPERCENTAGE_FIELD_NUMBER = 9;
        private float curHpPercentage_;
        public static final int FUNGUSID_FIELD_NUMBER = 10;
        private int fungusId_;
        public static final int ISALIVE_FIELD_NUMBER = 12;
        private boolean isAlive_;
        private byte memoizedIsInitialized;
        private static final FungusFighterMonsterDetail DEFAULT_INSTANCE = new FungusFighterMonsterDetail();
        private static final Parser<FungusFighterMonsterDetail> PARSER = new AbstractParser<FungusFighterMonsterDetail>() { // from class: emu.grasscutter.net.proto.FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.1
            @Override // com.google.protobuf.Parser
            public FungusFighterMonsterDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FungusFighterMonsterDetail(input, extensionRegistry);
            }
        };

        private FungusFighterMonsterDetail(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FungusFighterMonsterDetail() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FungusFighterMonsterDetail();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FungusFighterMonsterDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 77:
                                    this.curHpPercentage_ = input.readFloat();
                                    break;
                                case 80:
                                    this.fungusId_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.isAlive_ = input.readBool();
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
            return FungusFighterMonsterDetailOuterClass.internal_static_FungusFighterMonsterDetail_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FungusFighterMonsterDetailOuterClass.internal_static_FungusFighterMonsterDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(FungusFighterMonsterDetail.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder
        public float getCurHpPercentage() {
            return this.curHpPercentage_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder
        public int getFungusId() {
            return this.fungusId_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder
        public boolean getIsAlive() {
            return this.isAlive_;
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
            if (this.curHpPercentage_ != 0.0f) {
                output.writeFloat(9, this.curHpPercentage_);
            }
            if (this.fungusId_ != 0) {
                output.writeUInt32(10, this.fungusId_);
            }
            if (this.isAlive_) {
                output.writeBool(12, this.isAlive_);
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
            if (this.curHpPercentage_ != 0.0f) {
                size2 = 0 + CodedOutputStream.computeFloatSize(9, this.curHpPercentage_);
            }
            if (this.fungusId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.fungusId_);
            }
            if (this.isAlive_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isAlive_);
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
            if (!(obj instanceof FungusFighterMonsterDetail)) {
                return equals(obj);
            }
            FungusFighterMonsterDetail other = (FungusFighterMonsterDetail) obj;
            return Float.floatToIntBits(getCurHpPercentage()) == Float.floatToIntBits(other.getCurHpPercentage()) && getFungusId() == other.getFungusId() && getIsAlive() == other.getIsAlive() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + Float.floatToIntBits(getCurHpPercentage()))) + 10)) + getFungusId())) + 12)) + Internal.hashBoolean(getIsAlive()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FungusFighterMonsterDetail parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusFighterMonsterDetail parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusFighterMonsterDetail parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusFighterMonsterDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusFighterMonsterDetail parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusFighterMonsterDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusFighterMonsterDetail parseFrom(InputStream input) throws IOException {
            return (FungusFighterMonsterDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusFighterMonsterDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusFighterMonsterDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusFighterMonsterDetail parseDelimitedFrom(InputStream input) throws IOException {
            return (FungusFighterMonsterDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FungusFighterMonsterDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusFighterMonsterDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusFighterMonsterDetail parseFrom(CodedInputStream input) throws IOException {
            return (FungusFighterMonsterDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusFighterMonsterDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusFighterMonsterDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FungusFighterMonsterDetail prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusFighterMonsterDetailOuterClass$FungusFighterMonsterDetail$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FungusFighterMonsterDetailOrBuilder {
            private float curHpPercentage_;
            private int fungusId_;
            private boolean isAlive_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FungusFighterMonsterDetailOuterClass.internal_static_FungusFighterMonsterDetail_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FungusFighterMonsterDetailOuterClass.internal_static_FungusFighterMonsterDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(FungusFighterMonsterDetail.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FungusFighterMonsterDetail.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.curHpPercentage_ = 0.0f;
                this.fungusId_ = 0;
                this.isAlive_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FungusFighterMonsterDetailOuterClass.internal_static_FungusFighterMonsterDetail_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FungusFighterMonsterDetail getDefaultInstanceForType() {
                return FungusFighterMonsterDetail.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusFighterMonsterDetail build() {
                FungusFighterMonsterDetail result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusFighterMonsterDetail buildPartial() {
                FungusFighterMonsterDetail result = new FungusFighterMonsterDetail(this);
                result.curHpPercentage_ = this.curHpPercentage_;
                result.fungusId_ = this.fungusId_;
                result.isAlive_ = this.isAlive_;
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
                if (other instanceof FungusFighterMonsterDetail) {
                    return mergeFrom((FungusFighterMonsterDetail) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FungusFighterMonsterDetail other) {
                if (other == FungusFighterMonsterDetail.getDefaultInstance()) {
                    return this;
                }
                if (other.getCurHpPercentage() != 0.0f) {
                    setCurHpPercentage(other.getCurHpPercentage());
                }
                if (other.getFungusId() != 0) {
                    setFungusId(other.getFungusId());
                }
                if (other.getIsAlive()) {
                    setIsAlive(other.getIsAlive());
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
                FungusFighterMonsterDetail parsedMessage = null;
                try {
                    try {
                        parsedMessage = FungusFighterMonsterDetail.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FungusFighterMonsterDetail) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder
            public float getCurHpPercentage() {
                return this.curHpPercentage_;
            }

            public Builder setCurHpPercentage(float value) {
                this.curHpPercentage_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurHpPercentage() {
                this.curHpPercentage_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder
            public int getFungusId() {
                return this.fungusId_;
            }

            public Builder setFungusId(int value) {
                this.fungusId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFungusId() {
                this.fungusId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static FungusFighterMonsterDetail getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FungusFighterMonsterDetail> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FungusFighterMonsterDetail> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FungusFighterMonsterDetail getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
