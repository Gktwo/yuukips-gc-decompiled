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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ElementReliquaryRequestOuterClass.class */
public final class ElementReliquaryRequestOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dElementReliquaryRequest.proto\"A\n\u0017ElementReliquaryRequest\u0012\u0013\n\u000belementType\u0018\f \u0001(\r\u0012\u0011\n\tequipType\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ElementReliquaryRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ElementReliquaryRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ElementReliquaryRequest_descriptor, new String[]{"ElementType", "EquipType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ElementReliquaryRequestOuterClass$ElementReliquaryRequestOrBuilder.class */
    public interface ElementReliquaryRequestOrBuilder extends MessageOrBuilder {
        int getElementType();

        int getEquipType();
    }

    private ElementReliquaryRequestOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ElementReliquaryRequestOuterClass$ElementReliquaryRequest.class */
    public static final class ElementReliquaryRequest extends GeneratedMessageV3 implements ElementReliquaryRequestOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ELEMENTTYPE_FIELD_NUMBER = 12;
        private int elementType_;
        public static final int EQUIPTYPE_FIELD_NUMBER = 7;
        private int equipType_;
        private byte memoizedIsInitialized;
        private static final ElementReliquaryRequest DEFAULT_INSTANCE = new ElementReliquaryRequest();
        private static final Parser<ElementReliquaryRequest> PARSER = new AbstractParser<ElementReliquaryRequest>() { // from class: emu.grasscutter.net.proto.ElementReliquaryRequestOuterClass.ElementReliquaryRequest.1
            @Override // com.google.protobuf.Parser
            public ElementReliquaryRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ElementReliquaryRequest(input, extensionRegistry);
            }
        };

        private ElementReliquaryRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ElementReliquaryRequest() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ElementReliquaryRequest();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ElementReliquaryRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 56:
                                this.equipType_ = input.readUInt32();
                                break;
                            case 96:
                                this.elementType_ = input.readUInt32();
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
            return ElementReliquaryRequestOuterClass.internal_static_ElementReliquaryRequest_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ElementReliquaryRequestOuterClass.internal_static_ElementReliquaryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ElementReliquaryRequest.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ElementReliquaryRequestOuterClass.ElementReliquaryRequestOrBuilder
        public int getElementType() {
            return this.elementType_;
        }

        @Override // emu.grasscutter.net.proto.ElementReliquaryRequestOuterClass.ElementReliquaryRequestOrBuilder
        public int getEquipType() {
            return this.equipType_;
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
            if (this.equipType_ != 0) {
                output.writeUInt32(7, this.equipType_);
            }
            if (this.elementType_ != 0) {
                output.writeUInt32(12, this.elementType_);
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
            if (this.equipType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.equipType_);
            }
            if (this.elementType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.elementType_);
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
            if (!(obj instanceof ElementReliquaryRequest)) {
                return equals(obj);
            }
            ElementReliquaryRequest other = (ElementReliquaryRequest) obj;
            return getElementType() == other.getElementType() && getEquipType() == other.getEquipType() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getElementType())) + 7)) + getEquipType())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ElementReliquaryRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ElementReliquaryRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ElementReliquaryRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ElementReliquaryRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ElementReliquaryRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ElementReliquaryRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ElementReliquaryRequest parseFrom(InputStream input) throws IOException {
            return (ElementReliquaryRequest) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ElementReliquaryRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ElementReliquaryRequest) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ElementReliquaryRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ElementReliquaryRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ElementReliquaryRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ElementReliquaryRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ElementReliquaryRequest parseFrom(CodedInputStream input) throws IOException {
            return (ElementReliquaryRequest) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ElementReliquaryRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ElementReliquaryRequest) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ElementReliquaryRequest prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ElementReliquaryRequestOuterClass$ElementReliquaryRequest$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ElementReliquaryRequestOrBuilder {
            private int elementType_;
            private int equipType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ElementReliquaryRequestOuterClass.internal_static_ElementReliquaryRequest_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ElementReliquaryRequestOuterClass.internal_static_ElementReliquaryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ElementReliquaryRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ElementReliquaryRequest.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.elementType_ = 0;
                this.equipType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ElementReliquaryRequestOuterClass.internal_static_ElementReliquaryRequest_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ElementReliquaryRequest getDefaultInstanceForType() {
                return ElementReliquaryRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ElementReliquaryRequest build() {
                ElementReliquaryRequest result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ElementReliquaryRequest buildPartial() {
                ElementReliquaryRequest result = new ElementReliquaryRequest(this);
                result.elementType_ = this.elementType_;
                result.equipType_ = this.equipType_;
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
                if (other instanceof ElementReliquaryRequest) {
                    return mergeFrom((ElementReliquaryRequest) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ElementReliquaryRequest other) {
                if (other == ElementReliquaryRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.getElementType() != 0) {
                    setElementType(other.getElementType());
                }
                if (other.getEquipType() != 0) {
                    setEquipType(other.getEquipType());
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
                ElementReliquaryRequest parsedMessage = null;
                try {
                    try {
                        parsedMessage = ElementReliquaryRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ElementReliquaryRequest) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ElementReliquaryRequestOuterClass.ElementReliquaryRequestOrBuilder
            public int getElementType() {
                return this.elementType_;
            }

            public Builder setElementType(int value) {
                this.elementType_ = value;
                onChanged();
                return this;
            }

            public Builder clearElementType() {
                this.elementType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ElementReliquaryRequestOuterClass.ElementReliquaryRequestOrBuilder
            public int getEquipType() {
                return this.equipType_;
            }

            public Builder setEquipType(int value) {
                this.equipType_ = value;
                onChanged();
                return this;
            }

            public Builder clearEquipType() {
                this.equipType_ = 0;
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

        public static ElementReliquaryRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ElementReliquaryRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ElementReliquaryRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ElementReliquaryRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
