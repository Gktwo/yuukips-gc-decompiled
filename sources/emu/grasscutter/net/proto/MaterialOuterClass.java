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
import emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialOuterClass.class */
public final class MaterialOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eMaterial.proto\u001a\u0018MaterialDeleteInfo.proto\"C\n\bMaterial\u0012\r\n\u0005count\u0018\u0001 \u0001(\r\u0012(\n\u000bdelete_info\u0018\u0002 \u0001(\u000b2\u0013.MaterialDeleteInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MaterialDeleteInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_Material_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Material_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Material_descriptor, new String[]{"Count", "DeleteInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialOuterClass$MaterialOrBuilder.class */
    public interface MaterialOrBuilder extends MessageOrBuilder {
        int getCount();

        boolean hasDeleteInfo();

        MaterialDeleteInfoOuterClass.MaterialDeleteInfo getDeleteInfo();

        MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder getDeleteInfoOrBuilder();
    }

    private MaterialOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialOuterClass$Material.class */
    public static final class Material extends GeneratedMessageV3 implements MaterialOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COUNT_FIELD_NUMBER = 1;
        private int count_;
        public static final int DELETE_INFO_FIELD_NUMBER = 2;
        private MaterialDeleteInfoOuterClass.MaterialDeleteInfo deleteInfo_;
        private byte memoizedIsInitialized;
        private static final Material DEFAULT_INSTANCE = new Material();
        private static final Parser<Material> PARSER = new AbstractParser<Material>() { // from class: emu.grasscutter.net.proto.MaterialOuterClass.Material.1
            @Override // com.google.protobuf.Parser
            public Material parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Material(input, extensionRegistry);
            }
        };

        private Material(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private Material() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new Material();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Material(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.count_ = input.readUInt32();
                                    break;
                                case 18:
                                    MaterialDeleteInfoOuterClass.MaterialDeleteInfo.Builder subBuilder = this.deleteInfo_ != null ? this.deleteInfo_.toBuilder() : null;
                                    this.deleteInfo_ = (MaterialDeleteInfoOuterClass.MaterialDeleteInfo) input.readMessage(MaterialDeleteInfoOuterClass.MaterialDeleteInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.deleteInfo_);
                                        this.deleteInfo_ = subBuilder.buildPartial();
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
            return MaterialOuterClass.internal_static_Material_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MaterialOuterClass.internal_static_Material_fieldAccessorTable.ensureFieldAccessorsInitialized(Material.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MaterialOuterClass.MaterialOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // emu.grasscutter.net.proto.MaterialOuterClass.MaterialOrBuilder
        public boolean hasDeleteInfo() {
            return this.deleteInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.MaterialOuterClass.MaterialOrBuilder
        public MaterialDeleteInfoOuterClass.MaterialDeleteInfo getDeleteInfo() {
            return this.deleteInfo_ == null ? MaterialDeleteInfoOuterClass.MaterialDeleteInfo.getDefaultInstance() : this.deleteInfo_;
        }

        @Override // emu.grasscutter.net.proto.MaterialOuterClass.MaterialOrBuilder
        public MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder getDeleteInfoOrBuilder() {
            return getDeleteInfo();
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
            if (this.count_ != 0) {
                output.writeUInt32(1, this.count_);
            }
            if (this.deleteInfo_ != null) {
                output.writeMessage(2, getDeleteInfo());
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
            if (this.count_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.count_);
            }
            if (this.deleteInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getDeleteInfo());
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
            if (!(obj instanceof Material)) {
                return equals(obj);
            }
            Material other = (Material) obj;
            if (getCount() == other.getCount() && hasDeleteInfo() == other.hasDeleteInfo()) {
                return (!hasDeleteInfo() || getDeleteInfo().equals(other.getDeleteInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getCount();
            if (hasDeleteInfo()) {
                hash = (53 * ((37 * hash) + 2)) + getDeleteInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static Material parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Material parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Material parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Material parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Material parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Material parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Material parseFrom(InputStream input) throws IOException {
            return (Material) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Material parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Material) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Material parseDelimitedFrom(InputStream input) throws IOException {
            return (Material) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static Material parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Material) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Material parseFrom(CodedInputStream input) throws IOException {
            return (Material) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Material parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Material) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Material prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialOuterClass$Material$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MaterialOrBuilder {
            private int count_;
            private MaterialDeleteInfoOuterClass.MaterialDeleteInfo deleteInfo_;
            private SingleFieldBuilderV3<MaterialDeleteInfoOuterClass.MaterialDeleteInfo, MaterialDeleteInfoOuterClass.MaterialDeleteInfo.Builder, MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder> deleteInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MaterialOuterClass.internal_static_Material_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MaterialOuterClass.internal_static_Material_fieldAccessorTable.ensureFieldAccessorsInitialized(Material.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Material.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.count_ = 0;
                if (this.deleteInfoBuilder_ == null) {
                    this.deleteInfo_ = null;
                } else {
                    this.deleteInfo_ = null;
                    this.deleteInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MaterialOuterClass.internal_static_Material_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Material getDefaultInstanceForType() {
                return Material.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Material build() {
                Material result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Material buildPartial() {
                Material result = new Material(this);
                result.count_ = this.count_;
                if (this.deleteInfoBuilder_ == null) {
                    result.deleteInfo_ = this.deleteInfo_;
                } else {
                    result.deleteInfo_ = this.deleteInfoBuilder_.build();
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
                if (other instanceof Material) {
                    return mergeFrom((Material) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Material other) {
                if (other == Material.getDefaultInstance()) {
                    return this;
                }
                if (other.getCount() != 0) {
                    setCount(other.getCount());
                }
                if (other.hasDeleteInfo()) {
                    mergeDeleteInfo(other.getDeleteInfo());
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
                Material parsedMessage = null;
                try {
                    try {
                        parsedMessage = Material.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Material) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MaterialOuterClass.MaterialOrBuilder
            public int getCount() {
                return this.count_;
            }

            public Builder setCount(int value) {
                this.count_ = value;
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MaterialOuterClass.MaterialOrBuilder
            public boolean hasDeleteInfo() {
                return (this.deleteInfoBuilder_ == null && this.deleteInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MaterialOuterClass.MaterialOrBuilder
            public MaterialDeleteInfoOuterClass.MaterialDeleteInfo getDeleteInfo() {
                if (this.deleteInfoBuilder_ == null) {
                    return this.deleteInfo_ == null ? MaterialDeleteInfoOuterClass.MaterialDeleteInfo.getDefaultInstance() : this.deleteInfo_;
                }
                return this.deleteInfoBuilder_.getMessage();
            }

            public Builder setDeleteInfo(MaterialDeleteInfoOuterClass.MaterialDeleteInfo value) {
                if (this.deleteInfoBuilder_ != null) {
                    this.deleteInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.deleteInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDeleteInfo(MaterialDeleteInfoOuterClass.MaterialDeleteInfo.Builder builderForValue) {
                if (this.deleteInfoBuilder_ == null) {
                    this.deleteInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.deleteInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDeleteInfo(MaterialDeleteInfoOuterClass.MaterialDeleteInfo value) {
                if (this.deleteInfoBuilder_ == null) {
                    if (this.deleteInfo_ != null) {
                        this.deleteInfo_ = MaterialDeleteInfoOuterClass.MaterialDeleteInfo.newBuilder(this.deleteInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.deleteInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.deleteInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDeleteInfo() {
                if (this.deleteInfoBuilder_ == null) {
                    this.deleteInfo_ = null;
                    onChanged();
                } else {
                    this.deleteInfo_ = null;
                    this.deleteInfoBuilder_ = null;
                }
                return this;
            }

            public MaterialDeleteInfoOuterClass.MaterialDeleteInfo.Builder getDeleteInfoBuilder() {
                onChanged();
                return getDeleteInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MaterialOuterClass.MaterialOrBuilder
            public MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder getDeleteInfoOrBuilder() {
                if (this.deleteInfoBuilder_ != null) {
                    return this.deleteInfoBuilder_.getMessageOrBuilder();
                }
                return this.deleteInfo_ == null ? MaterialDeleteInfoOuterClass.MaterialDeleteInfo.getDefaultInstance() : this.deleteInfo_;
            }

            private SingleFieldBuilderV3<MaterialDeleteInfoOuterClass.MaterialDeleteInfo, MaterialDeleteInfoOuterClass.MaterialDeleteInfo.Builder, MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder> getDeleteInfoFieldBuilder() {
                if (this.deleteInfoBuilder_ == null) {
                    this.deleteInfoBuilder_ = new SingleFieldBuilderV3<>(getDeleteInfo(), getParentForChildren(), isClean());
                    this.deleteInfo_ = null;
                }
                return this.deleteInfoBuilder_;
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

        public static Material getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Material> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Material> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Material getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MaterialDeleteInfoOuterClass.getDescriptor();
    }
}
