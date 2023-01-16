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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityStringOuterClass.class */
public final class AbilityStringOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013AbilityString.proto\"6\n\rAbilityString\u0012\r\n\u0003str\u0018\u0001 \u0001(\tH��\u0012\u000e\n\u0004hash\u0018\u0002 \u0001(\rH��B\u0006\n\u0004typeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AbilityString_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityString_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityString_descriptor, new String[]{"Str", "Hash", "Type"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityStringOuterClass$AbilityStringOrBuilder.class */
    public interface AbilityStringOrBuilder extends MessageOrBuilder {
        boolean hasStr();

        String getStr();

        ByteString getStrBytes();

        boolean hasHash();

        int getHash();

        AbilityString.TypeCase getTypeCase();
    }

    private AbilityStringOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityStringOuterClass$AbilityString.class */
    public static final class AbilityString extends GeneratedMessageV3 implements AbilityStringOrBuilder {
        private static final long serialVersionUID = 0;
        private int typeCase_;
        private Object type_;
        public static final int STR_FIELD_NUMBER = 1;
        public static final int HASH_FIELD_NUMBER = 2;
        private byte memoizedIsInitialized;
        private static final AbilityString DEFAULT_INSTANCE = new AbilityString();
        private static final Parser<AbilityString> PARSER = new AbstractParser<AbilityString>() { // from class: emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityString.1
            @Override // com.google.protobuf.Parser
            public AbilityString parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityString(input, extensionRegistry);
            }
        };

        private AbilityString(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.typeCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private AbilityString() {
            this.typeCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityString();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityString(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                String s = input.readStringRequireUtf8();
                                this.typeCase_ = 1;
                                this.type_ = s;
                                break;
                            case 16:
                                this.typeCase_ = 2;
                                this.type_ = Integer.valueOf(input.readUInt32());
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
            return AbilityStringOuterClass.internal_static_AbilityString_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityStringOuterClass.internal_static_AbilityString_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityString.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityStringOuterClass$AbilityString$TypeCase.class */
        public enum TypeCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            STR(1),
            HASH(2),
            TYPE_NOT_SET(0);
            
            private final int value;

            TypeCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static TypeCase valueOf(int value) {
                return forNumber(value);
            }

            public static TypeCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return TYPE_NOT_SET;
                    case 1:
                        return STR;
                    case 2:
                        return HASH;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
        public TypeCase getTypeCase() {
            return TypeCase.forNumber(this.typeCase_);
        }

        @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
        public boolean hasStr() {
            return this.typeCase_ == 1;
        }

        @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
        public String getStr() {
            Object ref = "";
            if (this.typeCase_ == 1) {
                ref = this.type_;
            }
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            if (this.typeCase_ == 1) {
                this.type_ = s;
            }
            return s;
        }

        @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
        public ByteString getStrBytes() {
            Object ref = "";
            if (this.typeCase_ == 1) {
                ref = this.type_;
            }
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            if (this.typeCase_ == 1) {
                this.type_ = b;
            }
            return b;
        }

        @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
        public boolean hasHash() {
            return this.typeCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
        public int getHash() {
            if (this.typeCase_ == 2) {
                return ((Integer) this.type_).intValue();
            }
            return 0;
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
            if (this.typeCase_ == 1) {
                GeneratedMessageV3.writeString(output, 1, this.type_);
            }
            if (this.typeCase_ == 2) {
                output.writeUInt32(2, ((Integer) this.type_).intValue());
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
            if (this.typeCase_ == 1) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.type_);
            }
            if (this.typeCase_ == 2) {
                size2 += CodedOutputStream.computeUInt32Size(2, ((Integer) this.type_).intValue());
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
            if (!(obj instanceof AbilityString)) {
                return equals(obj);
            }
            AbilityString other = (AbilityString) obj;
            if (!getTypeCase().equals(other.getTypeCase())) {
                return false;
            }
            switch (this.typeCase_) {
                case 1:
                    if (!getStr().equals(other.getStr())) {
                        return false;
                    }
                    break;
                case 2:
                    if (getHash() != other.getHash()) {
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
            int hash = (19 * 41) + getDescriptor().hashCode();
            switch (this.typeCase_) {
                case 1:
                    hash = (53 * ((37 * hash) + 1)) + getStr().hashCode();
                    break;
                case 2:
                    hash = (53 * ((37 * hash) + 2)) + getHash();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AbilityString parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityString parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityString parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityString parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityString parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityString parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityString parseFrom(InputStream input) throws IOException {
            return (AbilityString) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityString parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityString) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityString parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityString) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityString parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityString) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityString parseFrom(CodedInputStream input) throws IOException {
            return (AbilityString) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityString parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityString) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityString prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityStringOuterClass$AbilityString$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityStringOrBuilder {
            private int typeCase_ = 0;
            private Object type_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityStringOuterClass.internal_static_AbilityString_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityStringOuterClass.internal_static_AbilityString_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityString.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityString.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.typeCase_ = 0;
                this.type_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityStringOuterClass.internal_static_AbilityString_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityString getDefaultInstanceForType() {
                return AbilityString.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityString build() {
                AbilityString result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityString buildPartial() {
                AbilityString result = new AbilityString(this);
                if (this.typeCase_ == 1) {
                    result.type_ = this.type_;
                }
                if (this.typeCase_ == 2) {
                    result.type_ = this.type_;
                }
                result.typeCase_ = this.typeCase_;
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
                if (other instanceof AbilityString) {
                    return mergeFrom((AbilityString) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityString other) {
                if (other == AbilityString.getDefaultInstance()) {
                    return this;
                }
                switch (other.getTypeCase()) {
                    case STR:
                        this.typeCase_ = 1;
                        this.type_ = other.type_;
                        onChanged();
                        break;
                    case HASH:
                        setHash(other.getHash());
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
                AbilityString parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityString.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityString) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
            public TypeCase getTypeCase() {
                return TypeCase.forNumber(this.typeCase_);
            }

            public Builder clearType() {
                this.typeCase_ = 0;
                this.type_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
            public boolean hasStr() {
                return this.typeCase_ == 1;
            }

            @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
            public String getStr() {
                Object ref = "";
                if (this.typeCase_ == 1) {
                    ref = this.type_;
                }
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                if (this.typeCase_ == 1) {
                    this.type_ = s;
                }
                return s;
            }

            @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
            public ByteString getStrBytes() {
                Object ref = "";
                if (this.typeCase_ == 1) {
                    ref = this.type_;
                }
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                if (this.typeCase_ == 1) {
                    this.type_ = b;
                }
                return b;
            }

            public Builder setStr(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.typeCase_ = 1;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearStr() {
                if (this.typeCase_ == 1) {
                    this.typeCase_ = 0;
                    this.type_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder setStrBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AbilityString.checkByteStringIsUtf8(value);
                this.typeCase_ = 1;
                this.type_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
            public boolean hasHash() {
                return this.typeCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityStringOrBuilder
            public int getHash() {
                if (this.typeCase_ == 2) {
                    return ((Integer) this.type_).intValue();
                }
                return 0;
            }

            public Builder setHash(int value) {
                this.typeCase_ = 2;
                this.type_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearHash() {
                if (this.typeCase_ == 2) {
                    this.typeCase_ = 0;
                    this.type_ = null;
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

        public static AbilityString getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityString> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityString> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityString getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
