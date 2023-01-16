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
import emu.grasscutter.net.proto.CombatTypeArgumentOuterClass;
import emu.grasscutter.net.proto.ForwardTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombatInvokeEntryOuterClass.class */
public final class CombatInvokeEntryOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017CombatInvokeEntry.proto\u001a\u0018CombatTypeArgument.proto\u001a\u0011ForwardType.proto\"x\n\u0011CombatInvokeEntry\u0012\"\n\fforward_type\u0018\u000b \u0001(\u000e2\f.ForwardType\u0012*\n\rargument_type\u0018\t \u0001(\u000e2\u0013.CombatTypeArgument\u0012\u0013\n\u000bcombat_data\u0018\u0007 \u0001(\fB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CombatTypeArgumentOuterClass.getDescriptor(), ForwardTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CombatInvokeEntry_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CombatInvokeEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CombatInvokeEntry_descriptor, new String[]{"ForwardType", "ArgumentType", "CombatData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombatInvokeEntryOuterClass$CombatInvokeEntryOrBuilder.class */
    public interface CombatInvokeEntryOrBuilder extends MessageOrBuilder {
        int getForwardTypeValue();

        ForwardTypeOuterClass.ForwardType getForwardType();

        int getArgumentTypeValue();

        CombatTypeArgumentOuterClass.CombatTypeArgument getArgumentType();

        ByteString getCombatData();
    }

    private CombatInvokeEntryOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombatInvokeEntryOuterClass$CombatInvokeEntry.class */
    public static final class CombatInvokeEntry extends GeneratedMessageV3 implements CombatInvokeEntryOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FORWARD_TYPE_FIELD_NUMBER = 11;
        private int forwardType_;
        public static final int ARGUMENT_TYPE_FIELD_NUMBER = 9;
        private int argumentType_;
        public static final int COMBAT_DATA_FIELD_NUMBER = 7;
        private ByteString combatData_;
        private byte memoizedIsInitialized;
        private static final CombatInvokeEntry DEFAULT_INSTANCE = new CombatInvokeEntry();
        private static final Parser<CombatInvokeEntry> PARSER = new AbstractParser<CombatInvokeEntry>() { // from class: emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntry.1
            @Override // com.google.protobuf.Parser
            public CombatInvokeEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CombatInvokeEntry(input, extensionRegistry);
            }
        };

        private CombatInvokeEntry(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CombatInvokeEntry() {
            this.memoizedIsInitialized = -1;
            this.forwardType_ = 0;
            this.argumentType_ = 0;
            this.combatData_ = ByteString.EMPTY;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CombatInvokeEntry();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CombatInvokeEntry(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 58:
                                this.combatData_ = input.readBytes();
                                break;
                            case 72:
                                this.argumentType_ = input.readEnum();
                                break;
                            case 88:
                                this.forwardType_ = input.readEnum();
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
            return CombatInvokeEntryOuterClass.internal_static_CombatInvokeEntry_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CombatInvokeEntryOuterClass.internal_static_CombatInvokeEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(CombatInvokeEntry.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder
        public int getForwardTypeValue() {
            return this.forwardType_;
        }

        @Override // emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder
        public ForwardTypeOuterClass.ForwardType getForwardType() {
            ForwardTypeOuterClass.ForwardType result = ForwardTypeOuterClass.ForwardType.valueOf(this.forwardType_);
            return result == null ? ForwardTypeOuterClass.ForwardType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder
        public int getArgumentTypeValue() {
            return this.argumentType_;
        }

        @Override // emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder
        public CombatTypeArgumentOuterClass.CombatTypeArgument getArgumentType() {
            CombatTypeArgumentOuterClass.CombatTypeArgument result = CombatTypeArgumentOuterClass.CombatTypeArgument.valueOf(this.argumentType_);
            return result == null ? CombatTypeArgumentOuterClass.CombatTypeArgument.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder
        public ByteString getCombatData() {
            return this.combatData_;
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
            if (!this.combatData_.isEmpty()) {
                output.writeBytes(7, this.combatData_);
            }
            if (this.argumentType_ != CombatTypeArgumentOuterClass.CombatTypeArgument.COMBAT_TYPE_ARGUMENT_NONE.getNumber()) {
                output.writeEnum(9, this.argumentType_);
            }
            if (this.forwardType_ != ForwardTypeOuterClass.ForwardType.FORWARD_TYPE_LOCAL.getNumber()) {
                output.writeEnum(11, this.forwardType_);
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
            if (!this.combatData_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeBytesSize(7, this.combatData_);
            }
            if (this.argumentType_ != CombatTypeArgumentOuterClass.CombatTypeArgument.COMBAT_TYPE_ARGUMENT_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(9, this.argumentType_);
            }
            if (this.forwardType_ != ForwardTypeOuterClass.ForwardType.FORWARD_TYPE_LOCAL.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(11, this.forwardType_);
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
            if (!(obj instanceof CombatInvokeEntry)) {
                return equals(obj);
            }
            CombatInvokeEntry other = (CombatInvokeEntry) obj;
            return this.forwardType_ == other.forwardType_ && this.argumentType_ == other.argumentType_ && getCombatData().equals(other.getCombatData()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + this.forwardType_)) + 9)) + this.argumentType_)) + 7)) + getCombatData().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CombatInvokeEntry parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombatInvokeEntry parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombatInvokeEntry parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombatInvokeEntry parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombatInvokeEntry parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombatInvokeEntry parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombatInvokeEntry parseFrom(InputStream input) throws IOException {
            return (CombatInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombatInvokeEntry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombatInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombatInvokeEntry parseDelimitedFrom(InputStream input) throws IOException {
            return (CombatInvokeEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CombatInvokeEntry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombatInvokeEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombatInvokeEntry parseFrom(CodedInputStream input) throws IOException {
            return (CombatInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombatInvokeEntry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombatInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CombatInvokeEntry prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombatInvokeEntryOuterClass$CombatInvokeEntry$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CombatInvokeEntryOrBuilder {
            private int forwardType_ = 0;
            private int argumentType_ = 0;
            private ByteString combatData_ = ByteString.EMPTY;

            public static final Descriptors.Descriptor getDescriptor() {
                return CombatInvokeEntryOuterClass.internal_static_CombatInvokeEntry_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CombatInvokeEntryOuterClass.internal_static_CombatInvokeEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(CombatInvokeEntry.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CombatInvokeEntry.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.forwardType_ = 0;
                this.argumentType_ = 0;
                this.combatData_ = ByteString.EMPTY;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CombatInvokeEntryOuterClass.internal_static_CombatInvokeEntry_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CombatInvokeEntry getDefaultInstanceForType() {
                return CombatInvokeEntry.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombatInvokeEntry build() {
                CombatInvokeEntry result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombatInvokeEntry buildPartial() {
                CombatInvokeEntry result = new CombatInvokeEntry(this);
                result.forwardType_ = this.forwardType_;
                result.argumentType_ = this.argumentType_;
                result.combatData_ = this.combatData_;
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
                if (other instanceof CombatInvokeEntry) {
                    return mergeFrom((CombatInvokeEntry) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CombatInvokeEntry other) {
                if (other == CombatInvokeEntry.getDefaultInstance()) {
                    return this;
                }
                if (other.forwardType_ != 0) {
                    setForwardTypeValue(other.getForwardTypeValue());
                }
                if (other.argumentType_ != 0) {
                    setArgumentTypeValue(other.getArgumentTypeValue());
                }
                if (other.getCombatData() != ByteString.EMPTY) {
                    setCombatData(other.getCombatData());
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
                CombatInvokeEntry parsedMessage = null;
                try {
                    try {
                        parsedMessage = CombatInvokeEntry.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CombatInvokeEntry) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder
            public int getForwardTypeValue() {
                return this.forwardType_;
            }

            public Builder setForwardTypeValue(int value) {
                this.forwardType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder
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

            @Override // emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder
            public int getArgumentTypeValue() {
                return this.argumentType_;
            }

            public Builder setArgumentTypeValue(int value) {
                this.argumentType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder
            public CombatTypeArgumentOuterClass.CombatTypeArgument getArgumentType() {
                CombatTypeArgumentOuterClass.CombatTypeArgument result = CombatTypeArgumentOuterClass.CombatTypeArgument.valueOf(this.argumentType_);
                return result == null ? CombatTypeArgumentOuterClass.CombatTypeArgument.UNRECOGNIZED : result;
            }

            public Builder setArgumentType(CombatTypeArgumentOuterClass.CombatTypeArgument value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.argumentType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearArgumentType() {
                this.argumentType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder
            public ByteString getCombatData() {
                return this.combatData_;
            }

            public Builder setCombatData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.combatData_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombatData() {
                this.combatData_ = CombatInvokeEntry.getDefaultInstance().getCombatData();
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

        public static CombatInvokeEntry getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CombatInvokeEntry> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CombatInvokeEntry> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CombatInvokeEntry getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CombatTypeArgumentOuterClass.getDescriptor();
        ForwardTypeOuterClass.getDescriptor();
    }
}
