package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/google/protobuf/Field.class */
public final class Field extends GeneratedMessageV3 implements FieldOrBuilder {
    private static final long serialVersionUID = 0;
    public static final int KIND_FIELD_NUMBER = 1;
    private int kind_;
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private int cardinality_;
    public static final int NUMBER_FIELD_NUMBER = 3;
    private int number_;
    public static final int NAME_FIELD_NUMBER = 4;
    private volatile Object name_;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private volatile Object typeUrl_;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    private int oneofIndex_;
    public static final int PACKED_FIELD_NUMBER = 8;
    private boolean packed_;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    private List<Option> options_;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    private volatile Object jsonName_;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    private volatile Object defaultValue_;
    private byte memoizedIsInitialized;
    private static final Field DEFAULT_INSTANCE = new Field();
    private static final Parser<Field> PARSER = new AbstractParser<Field>() { // from class: com.google.protobuf.Field.1
        @Override // com.google.protobuf.Parser
        public Field parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return new Field(input, extensionRegistry);
        }
    };

    private Field(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private Field() {
        this.memoizedIsInitialized = -1;
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.options_ = Collections.emptyList();
        this.jsonName_ = "";
        this.defaultValue_ = "";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new Field();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: java.util.List<com.google.protobuf.Option> */
    /* JADX WARN: Multi-variable type inference failed */
    private Field(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        this();
        int mutable_bitField0_;
        UnknownFieldSet.Builder unknownFields;
        if (extensionRegistry == null) {
            throw new NullPointerException();
        }
        try {
            mutable_bitField0_ = 0;
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
                            case 8:
                                this.kind_ = input.readEnum();
                                break;
                            case 16:
                                this.cardinality_ = input.readEnum();
                                break;
                            case 24:
                                this.number_ = input.readInt32();
                                break;
                            case 34:
                                this.name_ = input.readStringRequireUtf8();
                                break;
                            case 50:
                                this.typeUrl_ = input.readStringRequireUtf8();
                                break;
                            case 56:
                                this.oneofIndex_ = input.readInt32();
                                break;
                            case 64:
                                this.packed_ = input.readBool();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.options_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.options_.add(input.readMessage(Option.parser(), extensionRegistry));
                                break;
                            case 82:
                                this.jsonName_ = input.readStringRequireUtf8();
                                break;
                            case 90:
                                this.defaultValue_ = input.readStringRequireUtf8();
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
            if ((mutable_bitField0_ & 1) != 0) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Field$Kind.class */
    public enum Kind implements ProtocolMessageEnum {
        TYPE_UNKNOWN(0),
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18),
        UNRECOGNIZED(-1);
        
        public static final int TYPE_UNKNOWN_VALUE = 0;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final int TYPE_INT64_VALUE = 3;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final int TYPE_INT32_VALUE = 5;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final int TYPE_BOOL_VALUE = 8;
        public static final int TYPE_STRING_VALUE = 9;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final int TYPE_SINT64_VALUE = 18;
        private static final Internal.EnumLiteMap<Kind> internalValueMap = new Internal.EnumLiteMap<Kind>() { // from class: com.google.protobuf.Field.Kind.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Kind findValueByNumber(int number) {
                return Kind.forNumber(number);
            }
        };
        private static final Kind[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Kind valueOf(int value) {
            return forNumber(value);
        }

        public static Kind forNumber(int value) {
            switch (value) {
                case 0:
                    return TYPE_UNKNOWN;
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return Field.getDescriptor().getEnumTypes().get(0);
        }

        public static Kind valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        Kind(int value) {
            this.value = value;
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Field$Cardinality.class */
    public enum Cardinality implements ProtocolMessageEnum {
        CARDINALITY_UNKNOWN(0),
        CARDINALITY_OPTIONAL(1),
        CARDINALITY_REQUIRED(2),
        CARDINALITY_REPEATED(3),
        UNRECOGNIZED(-1);
        
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        private static final Internal.EnumLiteMap<Cardinality> internalValueMap = new Internal.EnumLiteMap<Cardinality>() { // from class: com.google.protobuf.Field.Cardinality.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Cardinality findValueByNumber(int number) {
                return Cardinality.forNumber(number);
            }
        };
        private static final Cardinality[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Cardinality valueOf(int value) {
            return forNumber(value);
        }

        public static Cardinality forNumber(int value) {
            switch (value) {
                case 0:
                    return CARDINALITY_UNKNOWN;
                case 1:
                    return CARDINALITY_OPTIONAL;
                case 2:
                    return CARDINALITY_REQUIRED;
                case 3:
                    return CARDINALITY_REPEATED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return Field.getDescriptor().getEnumTypes().get(1);
        }

        public static Cardinality valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        Cardinality(int value) {
            this.value = value;
        }
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Kind getKind() {
        Kind result = Kind.valueOf(this.kind_);
        return result == null ? Kind.UNRECOGNIZED : result;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Cardinality getCardinality() {
        Cardinality result = Cardinality.valueOf(this.cardinality_);
        return result == null ? Cardinality.UNRECOGNIZED : result;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getName() {
        Object ref = this.name_;
        if (ref instanceof String) {
            return (String) ref;
        }
        String s = ((ByteString) ref).toStringUtf8();
        this.name_ = s;
        return s;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getNameBytes() {
        Object ref = this.name_;
        if (!(ref instanceof String)) {
            return (ByteString) ref;
        }
        ByteString b = ByteString.copyFromUtf8((String) ref);
        this.name_ = b;
        return b;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        Object ref = this.typeUrl_;
        if (ref instanceof String) {
            return (String) ref;
        }
        String s = ((ByteString) ref).toStringUtf8();
        this.typeUrl_ = s;
        return s;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getTypeUrlBytes() {
        Object ref = this.typeUrl_;
        if (!(ref instanceof String)) {
            return (ByteString) ref;
        }
        ByteString b = ByteString.copyFromUtf8((String) ref);
        this.typeUrl_ = b;
        return b;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public boolean getPacked() {
        return this.packed_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Option getOptions(int index) {
        return this.options_.get(index);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int index) {
        return this.options_.get(index);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getJsonName() {
        Object ref = this.jsonName_;
        if (ref instanceof String) {
            return (String) ref;
        }
        String s = ((ByteString) ref).toStringUtf8();
        this.jsonName_ = s;
        return s;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getJsonNameBytes() {
        Object ref = this.jsonName_;
        if (!(ref instanceof String)) {
            return (ByteString) ref;
        }
        ByteString b = ByteString.copyFromUtf8((String) ref);
        this.jsonName_ = b;
        return b;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getDefaultValue() {
        Object ref = this.defaultValue_;
        if (ref instanceof String) {
            return (String) ref;
        }
        String s = ((ByteString) ref).toStringUtf8();
        this.defaultValue_ = s;
        return s;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getDefaultValueBytes() {
        Object ref = this.defaultValue_;
        if (!(ref instanceof String)) {
            return (ByteString) ref;
        }
        ByteString b = ByteString.copyFromUtf8((String) ref);
        this.defaultValue_ = b;
        return b;
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
        if (this.kind_ != Kind.TYPE_UNKNOWN.getNumber()) {
            output.writeEnum(1, this.kind_);
        }
        if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            output.writeEnum(2, this.cardinality_);
        }
        if (this.number_ != 0) {
            output.writeInt32(3, this.number_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            GeneratedMessageV3.writeString(output, 4, this.name_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.typeUrl_)) {
            GeneratedMessageV3.writeString(output, 6, this.typeUrl_);
        }
        if (this.oneofIndex_ != 0) {
            output.writeInt32(7, this.oneofIndex_);
        }
        if (this.packed_) {
            output.writeBool(8, this.packed_);
        }
        for (int i = 0; i < this.options_.size(); i++) {
            output.writeMessage(9, this.options_.get(i));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.jsonName_)) {
            GeneratedMessageV3.writeString(output, 10, this.jsonName_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.defaultValue_)) {
            GeneratedMessageV3.writeString(output, 11, this.defaultValue_);
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
        if (this.kind_ != Kind.TYPE_UNKNOWN.getNumber()) {
            size2 = 0 + CodedOutputStream.computeEnumSize(1, this.kind_);
        }
        if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(2, this.cardinality_);
        }
        if (this.number_ != 0) {
            size2 += CodedOutputStream.computeInt32Size(3, this.number_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            size2 += GeneratedMessageV3.computeStringSize(4, this.name_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.typeUrl_)) {
            size2 += GeneratedMessageV3.computeStringSize(6, this.typeUrl_);
        }
        if (this.oneofIndex_ != 0) {
            size2 += CodedOutputStream.computeInt32Size(7, this.oneofIndex_);
        }
        if (this.packed_) {
            size2 += CodedOutputStream.computeBoolSize(8, this.packed_);
        }
        for (int i = 0; i < this.options_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(9, this.options_.get(i));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.jsonName_)) {
            size2 += GeneratedMessageV3.computeStringSize(10, this.jsonName_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.defaultValue_)) {
            size2 += GeneratedMessageV3.computeStringSize(11, this.defaultValue_);
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
        if (!(obj instanceof Field)) {
            return equals(obj);
        }
        Field other = (Field) obj;
        return this.kind_ == other.kind_ && this.cardinality_ == other.cardinality_ && getNumber() == other.getNumber() && getName().equals(other.getName()) && getTypeUrl().equals(other.getTypeUrl()) && getOneofIndex() == other.getOneofIndex() && getPacked() == other.getPacked() && getOptionsList().equals(other.getOptionsList()) && getJsonName().equals(other.getJsonName()) && getDefaultValue().equals(other.getDefaultValue()) && this.unknownFields.equals(other.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + this.kind_)) + 2)) + this.cardinality_)) + 3)) + getNumber())) + 4)) + getName().hashCode())) + 6)) + getTypeUrl().hashCode())) + 7)) + getOneofIndex())) + 8)) + Internal.hashBoolean(getPacked());
        if (getOptionsCount() > 0) {
            hash = (53 * ((37 * hash) + 9)) + getOptionsList().hashCode();
        }
        int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 10)) + getJsonName().hashCode())) + 11)) + getDefaultValue().hashCode())) + this.unknownFields.hashCode();
        this.memoizedHashCode = hash2;
        return hash2;
    }

    public static Field parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Field parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Field parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Field parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Field parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Field parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Field parseFrom(InputStream input) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static Field parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Field parseDelimitedFrom(InputStream input) throws IOException {
        return (Field) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static Field parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Field) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Field parseFrom(CodedInputStream input) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static Field parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Field prototype) {
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

    /* loaded from: grasscutter.jar:com/google/protobuf/Field$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FieldOrBuilder {
        private int bitField0_;
        private int kind_;
        private int cardinality_;
        private int number_;
        private Object name_;
        private Object typeUrl_;
        private int oneofIndex_;
        private boolean packed_;
        private List<Option> options_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private Object jsonName_;
        private Object defaultValue_;

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
        }

        private Builder() {
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getOptionsFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            clear();
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.number_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.oneofIndex_ = 0;
            this.packed_ = false;
            if (this.optionsBuilder_ == null) {
                this.options_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                this.optionsBuilder_.clear();
            }
            this.jsonName_ = "";
            this.defaultValue_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Field getDefaultInstanceForType() {
            return Field.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Field build() {
            Field result = buildPartial();
            if (result.isInitialized()) {
                return result;
            }
            throw newUninitializedMessageException((Message) result);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Field buildPartial() {
            Field result = new Field(this);
            int i = this.bitField0_;
            result.kind_ = this.kind_;
            result.cardinality_ = this.cardinality_;
            result.number_ = this.number_;
            result.name_ = this.name_;
            result.typeUrl_ = this.typeUrl_;
            result.oneofIndex_ = this.oneofIndex_;
            result.packed_ = this.packed_;
            if (this.optionsBuilder_ == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.options_ = Collections.unmodifiableList(this.options_);
                    this.bitField0_ &= -2;
                }
                result.options_ = this.options_;
            } else {
                result.options_ = this.optionsBuilder_.build();
            }
            result.jsonName_ = this.jsonName_;
            result.defaultValue_ = this.defaultValue_;
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
            if (other instanceof Field) {
                return mergeFrom((Field) other);
            }
            mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(Field other) {
            if (other == Field.getDefaultInstance()) {
                return this;
            }
            if (other.kind_ != 0) {
                setKindValue(other.getKindValue());
            }
            if (other.cardinality_ != 0) {
                setCardinalityValue(other.getCardinalityValue());
            }
            if (other.getNumber() != 0) {
                setNumber(other.getNumber());
            }
            if (!other.getName().isEmpty()) {
                this.name_ = other.name_;
                onChanged();
            }
            if (!other.getTypeUrl().isEmpty()) {
                this.typeUrl_ = other.typeUrl_;
                onChanged();
            }
            if (other.getOneofIndex() != 0) {
                setOneofIndex(other.getOneofIndex());
            }
            if (other.getPacked()) {
                setPacked(other.getPacked());
            }
            if (this.optionsBuilder_ == null) {
                if (!other.options_.isEmpty()) {
                    if (this.options_.isEmpty()) {
                        this.options_ = other.options_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOptionsIsMutable();
                        this.options_.addAll(other.options_);
                    }
                    onChanged();
                }
            } else if (!other.options_.isEmpty()) {
                if (this.optionsBuilder_.isEmpty()) {
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = other.options_;
                    this.bitField0_ &= -2;
                    this.optionsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getOptionsFieldBuilder() : null;
                } else {
                    this.optionsBuilder_.addAllMessages(other.options_);
                }
            }
            if (!other.getJsonName().isEmpty()) {
                this.jsonName_ = other.jsonName_;
                onChanged();
            }
            if (!other.getDefaultValue().isEmpty()) {
                this.defaultValue_ = other.defaultValue_;
                onChanged();
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
            Field parsedMessage = null;
            try {
                try {
                    parsedMessage = (Field) Field.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Field) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                }
            } catch (Throwable th) {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getKindValue() {
            return this.kind_;
        }

        public Builder setKindValue(int value) {
            this.kind_ = value;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Kind getKind() {
            Kind result = Kind.valueOf(this.kind_);
            return result == null ? Kind.UNRECOGNIZED : result;
        }

        public Builder setKind(Kind value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.kind_ = value.getNumber();
            onChanged();
            return this;
        }

        public Builder clearKind() {
            this.kind_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getCardinalityValue() {
            return this.cardinality_;
        }

        public Builder setCardinalityValue(int value) {
            this.cardinality_ = value;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Cardinality getCardinality() {
            Cardinality result = Cardinality.valueOf(this.cardinality_);
            return result == null ? Cardinality.UNRECOGNIZED : result;
        }

        public Builder setCardinality(Cardinality value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.cardinality_ = value.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCardinality() {
            this.cardinality_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getNumber() {
            return this.number_;
        }

        public Builder setNumber(int value) {
            this.number_ = value;
            onChanged();
            return this;
        }

        public Builder clearNumber() {
            this.number_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.name_ = s;
            return s;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        public Builder setName(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.name_ = value;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Field.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.name_ = value;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getTypeUrl() {
            Object ref = this.typeUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.typeUrl_ = s;
            return s;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getTypeUrlBytes() {
            Object ref = this.typeUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.typeUrl_ = b;
            return b;
        }

        public Builder setTypeUrl(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.typeUrl_ = value;
            onChanged();
            return this;
        }

        public Builder clearTypeUrl() {
            this.typeUrl_ = Field.getDefaultInstance().getTypeUrl();
            onChanged();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.typeUrl_ = value;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        public Builder setOneofIndex(int value) {
            this.oneofIndex_ = value;
            onChanged();
            return this;
        }

        public Builder clearOneofIndex() {
            this.oneofIndex_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public boolean getPacked() {
            return this.packed_;
        }

        public Builder setPacked(boolean value) {
            this.packed_ = value;
            onChanged();
            return this;
        }

        public Builder clearPacked() {
            this.packed_ = false;
            onChanged();
            return this;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.options_ = new ArrayList(this.options_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public List<Option> getOptionsList() {
            if (this.optionsBuilder_ == null) {
                return Collections.unmodifiableList(this.options_);
            }
            return this.optionsBuilder_.getMessageList();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOptionsCount() {
            if (this.optionsBuilder_ == null) {
                return this.options_.size();
            }
            return this.optionsBuilder_.getCount();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Option getOptions(int index) {
            if (this.optionsBuilder_ == null) {
                return this.options_.get(index);
            }
            return this.optionsBuilder_.getMessage(index);
        }

        public Builder setOptions(int index, Option value) {
            if (this.optionsBuilder_ != null) {
                this.optionsBuilder_.setMessage(index, value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureOptionsIsMutable();
                this.options_.set(index, value);
                onChanged();
            }
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            if (this.optionsBuilder_ == null) {
                ensureOptionsIsMutable();
                this.options_.set(index, builderForValue.build());
                onChanged();
            } else {
                this.optionsBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addOptions(Option value) {
            if (this.optionsBuilder_ != null) {
                this.optionsBuilder_.addMessage(value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureOptionsIsMutable();
                this.options_.add(value);
                onChanged();
            }
            return this;
        }

        public Builder addOptions(int index, Option value) {
            if (this.optionsBuilder_ != null) {
                this.optionsBuilder_.addMessage(index, value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureOptionsIsMutable();
                this.options_.add(index, value);
                onChanged();
            }
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            if (this.optionsBuilder_ == null) {
                ensureOptionsIsMutable();
                this.options_.add(builderForValue.build());
                onChanged();
            } else {
                this.optionsBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            if (this.optionsBuilder_ == null) {
                ensureOptionsIsMutable();
                this.options_.add(index, builderForValue.build());
                onChanged();
            } else {
                this.optionsBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            if (this.optionsBuilder_ == null) {
                ensureOptionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.options_);
                onChanged();
            } else {
                this.optionsBuilder_.addAllMessages(values);
            }
            return this;
        }

        public Builder clearOptions() {
            if (this.optionsBuilder_ == null) {
                this.options_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                this.optionsBuilder_.clear();
            }
            return this;
        }

        public Builder removeOptions(int index) {
            if (this.optionsBuilder_ == null) {
                ensureOptionsIsMutable();
                this.options_.remove(index);
                onChanged();
            } else {
                this.optionsBuilder_.remove(index);
            }
            return this;
        }

        public Option.Builder getOptionsBuilder(int index) {
            return getOptionsFieldBuilder().getBuilder(index);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int index) {
            if (this.optionsBuilder_ == null) {
                return this.options_.get(index);
            }
            return this.optionsBuilder_.getMessageOrBuilder(index);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            if (this.optionsBuilder_ != null) {
                return this.optionsBuilder_.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.options_);
        }

        public Option.Builder addOptionsBuilder() {
            return getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        public Option.Builder addOptionsBuilder(int index) {
            return getOptionsFieldBuilder().addBuilder(index, Option.getDefaultInstance());
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return getOptionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ == null) {
                this.optionsBuilder_ = new RepeatedFieldBuilderV3<>(this.options_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.options_ = null;
            }
            return this.optionsBuilder_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getJsonName() {
            Object ref = this.jsonName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.jsonName_ = s;
            return s;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getJsonNameBytes() {
            Object ref = this.jsonName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.jsonName_ = b;
            return b;
        }

        public Builder setJsonName(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.jsonName_ = value;
            onChanged();
            return this;
        }

        public Builder clearJsonName() {
            this.jsonName_ = Field.getDefaultInstance().getJsonName();
            onChanged();
            return this;
        }

        public Builder setJsonNameBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.jsonName_ = value;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getDefaultValue() {
            Object ref = this.defaultValue_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.defaultValue_ = s;
            return s;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getDefaultValueBytes() {
            Object ref = this.defaultValue_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.defaultValue_ = b;
            return b;
        }

        public Builder setDefaultValue(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.defaultValue_ = value;
            onChanged();
            return this;
        }

        public Builder clearDefaultValue() {
            this.defaultValue_ = Field.getDefaultInstance().getDefaultValue();
            onChanged();
            return this;
        }

        public Builder setDefaultValueBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.defaultValue_ = value;
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

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Field> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Field> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Field getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
