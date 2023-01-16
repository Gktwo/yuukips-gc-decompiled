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
import emu.grasscutter.net.proto.CodexTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexDataUpdateNotifyOuterClass.class */
public final class CodexDataUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bCodexDataUpdateNotify.proto\u001a\u000fCodexType.proto\"_\n\u0015CodexDataUpdateNotify\u0012 \n\u0018weapon_max_promote_level\u0018\n \u0001(\r\u0012\u0018\n\u0004type\u0018\u0005 \u0001(\u000e2\n.CodexType\u0012\n\n\u0002id\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CodexTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CodexDataUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CodexDataUpdateNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CodexDataUpdateNotify_descriptor, new String[]{"WeaponMaxPromoteLevel", "Type", "Id"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexDataUpdateNotifyOuterClass$CodexDataUpdateNotifyOrBuilder.class */
    public interface CodexDataUpdateNotifyOrBuilder extends MessageOrBuilder {
        int getWeaponMaxPromoteLevel();

        int getTypeValue();

        CodexTypeOuterClass.CodexType getType();

        int getId();
    }

    private CodexDataUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexDataUpdateNotifyOuterClass$CodexDataUpdateNotify.class */
    public static final class CodexDataUpdateNotify extends GeneratedMessageV3 implements CodexDataUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int WEAPON_MAX_PROMOTE_LEVEL_FIELD_NUMBER = 10;
        private int weaponMaxPromoteLevel_;
        public static final int TYPE_FIELD_NUMBER = 5;
        private int type_;
        public static final int ID_FIELD_NUMBER = 3;
        private int id_;
        private byte memoizedIsInitialized;
        private static final CodexDataUpdateNotify DEFAULT_INSTANCE = new CodexDataUpdateNotify();
        private static final Parser<CodexDataUpdateNotify> PARSER = new AbstractParser<CodexDataUpdateNotify>() { // from class: emu.grasscutter.net.proto.CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public CodexDataUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CodexDataUpdateNotify(input, extensionRegistry);
            }
        };

        private CodexDataUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CodexDataUpdateNotify() {
            this.memoizedIsInitialized = -1;
            this.type_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CodexDataUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CodexDataUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.id_ = input.readUInt32();
                                break;
                            case 40:
                                this.type_ = input.readEnum();
                                break;
                            case 80:
                                this.weaponMaxPromoteLevel_ = input.readUInt32();
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
            return CodexDataUpdateNotifyOuterClass.internal_static_CodexDataUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CodexDataUpdateNotifyOuterClass.internal_static_CodexDataUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CodexDataUpdateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotifyOrBuilder
        public int getWeaponMaxPromoteLevel() {
            return this.weaponMaxPromoteLevel_;
        }

        @Override // emu.grasscutter.net.proto.CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotifyOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotifyOrBuilder
        public CodexTypeOuterClass.CodexType getType() {
            CodexTypeOuterClass.CodexType result = CodexTypeOuterClass.CodexType.valueOf(this.type_);
            return result == null ? CodexTypeOuterClass.CodexType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotifyOrBuilder
        public int getId() {
            return this.id_;
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
            if (this.id_ != 0) {
                output.writeUInt32(3, this.id_);
            }
            if (this.type_ != CodexTypeOuterClass.CodexType.CODEX_TYPE_NONE.getNumber()) {
                output.writeEnum(5, this.type_);
            }
            if (this.weaponMaxPromoteLevel_ != 0) {
                output.writeUInt32(10, this.weaponMaxPromoteLevel_);
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
            if (this.id_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.id_);
            }
            if (this.type_ != CodexTypeOuterClass.CodexType.CODEX_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(5, this.type_);
            }
            if (this.weaponMaxPromoteLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.weaponMaxPromoteLevel_);
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
            if (!(obj instanceof CodexDataUpdateNotify)) {
                return equals(obj);
            }
            CodexDataUpdateNotify other = (CodexDataUpdateNotify) obj;
            return getWeaponMaxPromoteLevel() == other.getWeaponMaxPromoteLevel() && this.type_ == other.type_ && getId() == other.getId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getWeaponMaxPromoteLevel())) + 5)) + this.type_)) + 3)) + getId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CodexDataUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodexDataUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodexDataUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodexDataUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodexDataUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodexDataUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodexDataUpdateNotify parseFrom(InputStream input) throws IOException {
            return (CodexDataUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CodexDataUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodexDataUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CodexDataUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CodexDataUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CodexDataUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodexDataUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CodexDataUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (CodexDataUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CodexDataUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodexDataUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodexDataUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexDataUpdateNotifyOuterClass$CodexDataUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CodexDataUpdateNotifyOrBuilder {
            private int weaponMaxPromoteLevel_;
            private int type_ = 0;
            private int id_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CodexDataUpdateNotifyOuterClass.internal_static_CodexDataUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CodexDataUpdateNotifyOuterClass.internal_static_CodexDataUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CodexDataUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CodexDataUpdateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.weaponMaxPromoteLevel_ = 0;
                this.type_ = 0;
                this.id_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CodexDataUpdateNotifyOuterClass.internal_static_CodexDataUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodexDataUpdateNotify getDefaultInstanceForType() {
                return CodexDataUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodexDataUpdateNotify build() {
                CodexDataUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodexDataUpdateNotify buildPartial() {
                CodexDataUpdateNotify result = new CodexDataUpdateNotify(this);
                result.weaponMaxPromoteLevel_ = this.weaponMaxPromoteLevel_;
                result.type_ = this.type_;
                result.id_ = this.id_;
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
                if (other instanceof CodexDataUpdateNotify) {
                    return mergeFrom((CodexDataUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CodexDataUpdateNotify other) {
                if (other == CodexDataUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getWeaponMaxPromoteLevel() != 0) {
                    setWeaponMaxPromoteLevel(other.getWeaponMaxPromoteLevel());
                }
                if (other.type_ != 0) {
                    setTypeValue(other.getTypeValue());
                }
                if (other.getId() != 0) {
                    setId(other.getId());
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
                CodexDataUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = CodexDataUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CodexDataUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotifyOrBuilder
            public int getWeaponMaxPromoteLevel() {
                return this.weaponMaxPromoteLevel_;
            }

            public Builder setWeaponMaxPromoteLevel(int value) {
                this.weaponMaxPromoteLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearWeaponMaxPromoteLevel() {
                this.weaponMaxPromoteLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotifyOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public Builder setTypeValue(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotifyOrBuilder
            public CodexTypeOuterClass.CodexType getType() {
                CodexTypeOuterClass.CodexType result = CodexTypeOuterClass.CodexType.valueOf(this.type_);
                return result == null ? CodexTypeOuterClass.CodexType.UNRECOGNIZED : result;
            }

            public Builder setType(CodexTypeOuterClass.CodexType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.type_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotifyOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
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

        public static CodexDataUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodexDataUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodexDataUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodexDataUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CodexTypeOuterClass.getDescriptor();
    }
}
