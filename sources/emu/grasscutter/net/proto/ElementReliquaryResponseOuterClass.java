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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.GameplayRecommendationReliquaryMainPropDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ElementReliquaryResponseOuterClass.class */
public final class ElementReliquaryResponseOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eElementReliquaryResponse.proto\u001a1GameplayRecommendationReliquaryMainPropData.proto\"\u0001\n\u0018ElementReliquaryResponse\u0012\u0013\n\u000belementType\u0018\u0004 \u0001(\r\u0012A\n\u000bnbbpegfkpac\u0018\u0003 \u0003(\u000b2,.GameplayRecommendationReliquaryMainPropData\u0012\u0011\n\tequipType\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GameplayRecommendationReliquaryMainPropDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ElementReliquaryResponse_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ElementReliquaryResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ElementReliquaryResponse_descriptor, new String[]{"ElementType", "Nbbpegfkpac", "EquipType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ElementReliquaryResponseOuterClass$ElementReliquaryResponseOrBuilder.class */
    public interface ElementReliquaryResponseOrBuilder extends MessageOrBuilder {
        int getElementType();

        List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getNbbpegfkpacList();

        GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getNbbpegfkpac(int i);

        int getNbbpegfkpacCount();

        List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getNbbpegfkpacOrBuilderList();

        GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getNbbpegfkpacOrBuilder(int i);

        int getEquipType();
    }

    private ElementReliquaryResponseOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ElementReliquaryResponseOuterClass$ElementReliquaryResponse.class */
    public static final class ElementReliquaryResponse extends GeneratedMessageV3 implements ElementReliquaryResponseOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ELEMENTTYPE_FIELD_NUMBER = 4;
        private int elementType_;
        public static final int NBBPEGFKPAC_FIELD_NUMBER = 3;
        private List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> nbbpegfkpac_;
        public static final int EQUIPTYPE_FIELD_NUMBER = 7;
        private int equipType_;
        private byte memoizedIsInitialized;
        private static final ElementReliquaryResponse DEFAULT_INSTANCE = new ElementReliquaryResponse();
        private static final Parser<ElementReliquaryResponse> PARSER = new AbstractParser<ElementReliquaryResponse>() { // from class: emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponse.1
            @Override // com.google.protobuf.Parser
            public ElementReliquaryResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ElementReliquaryResponse(input, extensionRegistry);
            }
        };

        private ElementReliquaryResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ElementReliquaryResponse() {
            this.memoizedIsInitialized = -1;
            this.nbbpegfkpac_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ElementReliquaryResponse();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ElementReliquaryResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.nbbpegfkpac_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.nbbpegfkpac_.add((GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData) input.readMessage(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.parser(), extensionRegistry));
                                break;
                            case 32:
                                this.elementType_ = input.readUInt32();
                                break;
                            case 56:
                                this.equipType_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.nbbpegfkpac_ = Collections.unmodifiableList(this.nbbpegfkpac_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ElementReliquaryResponseOuterClass.internal_static_ElementReliquaryResponse_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ElementReliquaryResponseOuterClass.internal_static_ElementReliquaryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ElementReliquaryResponse.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
        public int getElementType() {
            return this.elementType_;
        }

        @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
        public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getNbbpegfkpacList() {
            return this.nbbpegfkpac_;
        }

        @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
        public List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getNbbpegfkpacOrBuilderList() {
            return this.nbbpegfkpac_;
        }

        @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
        public int getNbbpegfkpacCount() {
            return this.nbbpegfkpac_.size();
        }

        @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
        public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getNbbpegfkpac(int index) {
            return this.nbbpegfkpac_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
        public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getNbbpegfkpacOrBuilder(int index) {
            return this.nbbpegfkpac_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
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
            for (int i = 0; i < this.nbbpegfkpac_.size(); i++) {
                output.writeMessage(3, this.nbbpegfkpac_.get(i));
            }
            if (this.elementType_ != 0) {
                output.writeUInt32(4, this.elementType_);
            }
            if (this.equipType_ != 0) {
                output.writeUInt32(7, this.equipType_);
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
            for (int i = 0; i < this.nbbpegfkpac_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.nbbpegfkpac_.get(i));
            }
            if (this.elementType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.elementType_);
            }
            if (this.equipType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.equipType_);
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
            if (!(obj instanceof ElementReliquaryResponse)) {
                return equals(obj);
            }
            ElementReliquaryResponse other = (ElementReliquaryResponse) obj;
            return getElementType() == other.getElementType() && getNbbpegfkpacList().equals(other.getNbbpegfkpacList()) && getEquipType() == other.getEquipType() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getElementType();
            if (getNbbpegfkpacCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getNbbpegfkpacList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 7)) + getEquipType())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ElementReliquaryResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ElementReliquaryResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ElementReliquaryResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ElementReliquaryResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ElementReliquaryResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ElementReliquaryResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ElementReliquaryResponse parseFrom(InputStream input) throws IOException {
            return (ElementReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ElementReliquaryResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ElementReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ElementReliquaryResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ElementReliquaryResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ElementReliquaryResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ElementReliquaryResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ElementReliquaryResponse parseFrom(CodedInputStream input) throws IOException {
            return (ElementReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ElementReliquaryResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ElementReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ElementReliquaryResponse prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ElementReliquaryResponseOuterClass$ElementReliquaryResponse$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ElementReliquaryResponseOrBuilder {
            private int bitField0_;
            private int elementType_;
            private List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> nbbpegfkpac_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> nbbpegfkpacBuilder_;
            private int equipType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ElementReliquaryResponseOuterClass.internal_static_ElementReliquaryResponse_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ElementReliquaryResponseOuterClass.internal_static_ElementReliquaryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ElementReliquaryResponse.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ElementReliquaryResponse.alwaysUseFieldBuilders) {
                    getNbbpegfkpacFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.elementType_ = 0;
                if (this.nbbpegfkpacBuilder_ == null) {
                    this.nbbpegfkpac_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.nbbpegfkpacBuilder_.clear();
                }
                this.equipType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ElementReliquaryResponseOuterClass.internal_static_ElementReliquaryResponse_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ElementReliquaryResponse getDefaultInstanceForType() {
                return ElementReliquaryResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ElementReliquaryResponse build() {
                ElementReliquaryResponse result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ElementReliquaryResponse buildPartial() {
                ElementReliquaryResponse result = new ElementReliquaryResponse(this);
                int i = this.bitField0_;
                result.elementType_ = this.elementType_;
                if (this.nbbpegfkpacBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.nbbpegfkpac_ = Collections.unmodifiableList(this.nbbpegfkpac_);
                        this.bitField0_ &= -2;
                    }
                    result.nbbpegfkpac_ = this.nbbpegfkpac_;
                } else {
                    result.nbbpegfkpac_ = this.nbbpegfkpacBuilder_.build();
                }
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
                if (other instanceof ElementReliquaryResponse) {
                    return mergeFrom((ElementReliquaryResponse) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ElementReliquaryResponse other) {
                if (other == ElementReliquaryResponse.getDefaultInstance()) {
                    return this;
                }
                if (other.getElementType() != 0) {
                    setElementType(other.getElementType());
                }
                if (this.nbbpegfkpacBuilder_ == null) {
                    if (!other.nbbpegfkpac_.isEmpty()) {
                        if (this.nbbpegfkpac_.isEmpty()) {
                            this.nbbpegfkpac_ = other.nbbpegfkpac_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureNbbpegfkpacIsMutable();
                            this.nbbpegfkpac_.addAll(other.nbbpegfkpac_);
                        }
                        onChanged();
                    }
                } else if (!other.nbbpegfkpac_.isEmpty()) {
                    if (this.nbbpegfkpacBuilder_.isEmpty()) {
                        this.nbbpegfkpacBuilder_.dispose();
                        this.nbbpegfkpacBuilder_ = null;
                        this.nbbpegfkpac_ = other.nbbpegfkpac_;
                        this.bitField0_ &= -2;
                        this.nbbpegfkpacBuilder_ = ElementReliquaryResponse.alwaysUseFieldBuilders ? getNbbpegfkpacFieldBuilder() : null;
                    } else {
                        this.nbbpegfkpacBuilder_.addAllMessages(other.nbbpegfkpac_);
                    }
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
                ElementReliquaryResponse parsedMessage = null;
                try {
                    try {
                        parsedMessage = ElementReliquaryResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ElementReliquaryResponse) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
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

            private void ensureNbbpegfkpacIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.nbbpegfkpac_ = new ArrayList(this.nbbpegfkpac_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
            public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getNbbpegfkpacList() {
                if (this.nbbpegfkpacBuilder_ == null) {
                    return Collections.unmodifiableList(this.nbbpegfkpac_);
                }
                return this.nbbpegfkpacBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
            public int getNbbpegfkpacCount() {
                if (this.nbbpegfkpacBuilder_ == null) {
                    return this.nbbpegfkpac_.size();
                }
                return this.nbbpegfkpacBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getNbbpegfkpac(int index) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    return this.nbbpegfkpac_.get(index);
                }
                return this.nbbpegfkpacBuilder_.getMessage(index);
            }

            public Builder setNbbpegfkpac(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData value) {
                if (this.nbbpegfkpacBuilder_ != null) {
                    this.nbbpegfkpacBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setNbbpegfkpac(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder builderForValue) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addNbbpegfkpac(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData value) {
                if (this.nbbpegfkpacBuilder_ != null) {
                    this.nbbpegfkpacBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addNbbpegfkpac(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData value) {
                if (this.nbbpegfkpacBuilder_ != null) {
                    this.nbbpegfkpacBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addNbbpegfkpac(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder builderForValue) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addNbbpegfkpac(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder builderForValue) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllNbbpegfkpac(Iterable<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> values) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    ensureNbbpegfkpacIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.nbbpegfkpac_);
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNbbpegfkpac() {
                if (this.nbbpegfkpacBuilder_ == null) {
                    this.nbbpegfkpac_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.clear();
                }
                return this;
            }

            public Builder removeNbbpegfkpac(int index) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.remove(index);
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.remove(index);
                }
                return this;
            }

            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder getNbbpegfkpacBuilder(int index) {
                return getNbbpegfkpacFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getNbbpegfkpacOrBuilder(int index) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    return this.nbbpegfkpac_.get(index);
                }
                return this.nbbpegfkpacBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
            public List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getNbbpegfkpacOrBuilderList() {
                if (this.nbbpegfkpacBuilder_ != null) {
                    return this.nbbpegfkpacBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.nbbpegfkpac_);
            }

            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder addNbbpegfkpacBuilder() {
                return getNbbpegfkpacFieldBuilder().addBuilder(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.getDefaultInstance());
            }

            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder addNbbpegfkpacBuilder(int index) {
                return getNbbpegfkpacFieldBuilder().addBuilder(index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.getDefaultInstance());
            }

            public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder> getNbbpegfkpacBuilderList() {
                return getNbbpegfkpacFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getNbbpegfkpacFieldBuilder() {
                if (this.nbbpegfkpacBuilder_ == null) {
                    this.nbbpegfkpacBuilder_ = new RepeatedFieldBuilderV3<>(this.nbbpegfkpac_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.nbbpegfkpac_ = null;
                }
                return this.nbbpegfkpacBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ElementReliquaryResponseOuterClass.ElementReliquaryResponseOrBuilder
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

        public static ElementReliquaryResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ElementReliquaryResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ElementReliquaryResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ElementReliquaryResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GameplayRecommendationReliquaryMainPropDataOuterClass.getDescriptor();
    }
}
