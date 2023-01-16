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
import emu.grasscutter.net.proto.PropValueOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropPairOuterClass.class */
public final class PropPairOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000ePropPair.proto\u001a\u000fPropValue.proto\"8\n\bPropPair\u0012\f\n\u0004type\u0018\u0001 \u0001(\r\u0012\u001e\n\nprop_value\u0018\u0002 \u0001(\u000b2\n.PropValueB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PropValueOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PropPair_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PropPair_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PropPair_descriptor, new String[]{"Type", "PropValue"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropPairOuterClass$PropPairOrBuilder.class */
    public interface PropPairOrBuilder extends MessageOrBuilder {
        int getType();

        boolean hasPropValue();

        PropValueOuterClass.PropValue getPropValue();

        PropValueOuterClass.PropValueOrBuilder getPropValueOrBuilder();
    }

    private PropPairOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropPairOuterClass$PropPair.class */
    public static final class PropPair extends GeneratedMessageV3 implements PropPairOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int PROP_VALUE_FIELD_NUMBER = 2;
        private PropValueOuterClass.PropValue propValue_;
        private byte memoizedIsInitialized;
        private static final PropPair DEFAULT_INSTANCE = new PropPair();
        private static final Parser<PropPair> PARSER = new AbstractParser<PropPair>() { // from class: emu.grasscutter.net.proto.PropPairOuterClass.PropPair.1
            @Override // com.google.protobuf.Parser
            public PropPair parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PropPair(input, extensionRegistry);
            }
        };

        private PropPair(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PropPair() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PropPair();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PropPair(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.type_ = input.readUInt32();
                                    break;
                                case 18:
                                    PropValueOuterClass.PropValue.Builder subBuilder = this.propValue_ != null ? this.propValue_.toBuilder() : null;
                                    this.propValue_ = (PropValueOuterClass.PropValue) input.readMessage(PropValueOuterClass.PropValue.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.propValue_);
                                        this.propValue_ = subBuilder.buildPartial();
                                        break;
                                    }
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
            return PropPairOuterClass.internal_static_PropPair_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PropPairOuterClass.internal_static_PropPair_fieldAccessorTable.ensureFieldAccessorsInitialized(PropPair.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PropPairOuterClass.PropPairOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.PropPairOuterClass.PropPairOrBuilder
        public boolean hasPropValue() {
            return this.propValue_ != null;
        }

        @Override // emu.grasscutter.net.proto.PropPairOuterClass.PropPairOrBuilder
        public PropValueOuterClass.PropValue getPropValue() {
            return this.propValue_ == null ? PropValueOuterClass.PropValue.getDefaultInstance() : this.propValue_;
        }

        @Override // emu.grasscutter.net.proto.PropPairOuterClass.PropPairOrBuilder
        public PropValueOuterClass.PropValueOrBuilder getPropValueOrBuilder() {
            return getPropValue();
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
            if (this.type_ != 0) {
                output.writeUInt32(1, this.type_);
            }
            if (this.propValue_ != null) {
                output.writeMessage(2, getPropValue());
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
            if (this.type_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.type_);
            }
            if (this.propValue_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getPropValue());
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
            if (!(obj instanceof PropPair)) {
                return equals(obj);
            }
            PropPair other = (PropPair) obj;
            if (getType() == other.getType() && hasPropValue() == other.hasPropValue()) {
                return (!hasPropValue() || getPropValue().equals(other.getPropValue())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getType();
            if (hasPropValue()) {
                hash = (53 * ((37 * hash) + 2)) + getPropValue().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PropPair parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PropPair parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PropPair parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PropPair parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PropPair parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PropPair parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PropPair parseFrom(InputStream input) throws IOException {
            return (PropPair) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PropPair parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PropPair) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PropPair parseDelimitedFrom(InputStream input) throws IOException {
            return (PropPair) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PropPair parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PropPair) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PropPair parseFrom(CodedInputStream input) throws IOException {
            return (PropPair) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PropPair parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PropPair) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PropPair prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropPairOuterClass$PropPair$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PropPairOrBuilder {
            private int type_;
            private PropValueOuterClass.PropValue propValue_;
            private SingleFieldBuilderV3<PropValueOuterClass.PropValue, PropValueOuterClass.PropValue.Builder, PropValueOuterClass.PropValueOrBuilder> propValueBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PropPairOuterClass.internal_static_PropPair_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PropPairOuterClass.internal_static_PropPair_fieldAccessorTable.ensureFieldAccessorsInitialized(PropPair.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PropPair.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.type_ = 0;
                if (this.propValueBuilder_ == null) {
                    this.propValue_ = null;
                } else {
                    this.propValue_ = null;
                    this.propValueBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PropPairOuterClass.internal_static_PropPair_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PropPair getDefaultInstanceForType() {
                return PropPair.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PropPair build() {
                PropPair result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PropPair buildPartial() {
                PropPair result = new PropPair(this);
                result.type_ = this.type_;
                if (this.propValueBuilder_ == null) {
                    result.propValue_ = this.propValue_;
                } else {
                    result.propValue_ = this.propValueBuilder_.build();
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
                if (other instanceof PropPair) {
                    return mergeFrom((PropPair) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PropPair other) {
                if (other == PropPair.getDefaultInstance()) {
                    return this;
                }
                if (other.getType() != 0) {
                    setType(other.getType());
                }
                if (other.hasPropValue()) {
                    mergePropValue(other.getPropValue());
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
                PropPair parsedMessage = null;
                try {
                    try {
                        parsedMessage = PropPair.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PropPair) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PropPairOuterClass.PropPairOrBuilder
            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PropPairOuterClass.PropPairOrBuilder
            public boolean hasPropValue() {
                return (this.propValueBuilder_ == null && this.propValue_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PropPairOuterClass.PropPairOrBuilder
            public PropValueOuterClass.PropValue getPropValue() {
                if (this.propValueBuilder_ == null) {
                    return this.propValue_ == null ? PropValueOuterClass.PropValue.getDefaultInstance() : this.propValue_;
                }
                return this.propValueBuilder_.getMessage();
            }

            public Builder setPropValue(PropValueOuterClass.PropValue value) {
                if (this.propValueBuilder_ != null) {
                    this.propValueBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.propValue_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPropValue(PropValueOuterClass.PropValue.Builder builderForValue) {
                if (this.propValueBuilder_ == null) {
                    this.propValue_ = builderForValue.build();
                    onChanged();
                } else {
                    this.propValueBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePropValue(PropValueOuterClass.PropValue value) {
                if (this.propValueBuilder_ == null) {
                    if (this.propValue_ != null) {
                        this.propValue_ = PropValueOuterClass.PropValue.newBuilder(this.propValue_).mergeFrom(value).buildPartial();
                    } else {
                        this.propValue_ = value;
                    }
                    onChanged();
                } else {
                    this.propValueBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPropValue() {
                if (this.propValueBuilder_ == null) {
                    this.propValue_ = null;
                    onChanged();
                } else {
                    this.propValue_ = null;
                    this.propValueBuilder_ = null;
                }
                return this;
            }

            public PropValueOuterClass.PropValue.Builder getPropValueBuilder() {
                onChanged();
                return getPropValueFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PropPairOuterClass.PropPairOrBuilder
            public PropValueOuterClass.PropValueOrBuilder getPropValueOrBuilder() {
                if (this.propValueBuilder_ != null) {
                    return this.propValueBuilder_.getMessageOrBuilder();
                }
                return this.propValue_ == null ? PropValueOuterClass.PropValue.getDefaultInstance() : this.propValue_;
            }

            private SingleFieldBuilderV3<PropValueOuterClass.PropValue, PropValueOuterClass.PropValue.Builder, PropValueOuterClass.PropValueOrBuilder> getPropValueFieldBuilder() {
                if (this.propValueBuilder_ == null) {
                    this.propValueBuilder_ = new SingleFieldBuilderV3<>(getPropValue(), getParentForChildren(), isClean());
                    this.propValue_ = null;
                }
                return this.propValueBuilder_;
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

        public static PropPair getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PropPair> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PropPair> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PropPair getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PropValueOuterClass.getDescriptor();
    }
}
