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
import emu.grasscutter.net.proto.CookRecipeDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookRecipeDataNotifyOuterClass.class */
public final class CookRecipeDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aCookRecipeDataNotify.proto\u001a\u0014CookRecipeData.proto\"<\n\u0014CookRecipeDataNotify\u0012$\n\u000brecipe_data\u0018\u0001 \u0001(\u000b2\u000f.CookRecipeDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CookRecipeDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CookRecipeDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CookRecipeDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CookRecipeDataNotify_descriptor, new String[]{"RecipeData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookRecipeDataNotifyOuterClass$CookRecipeDataNotifyOrBuilder.class */
    public interface CookRecipeDataNotifyOrBuilder extends MessageOrBuilder {
        boolean hasRecipeData();

        CookRecipeDataOuterClass.CookRecipeData getRecipeData();

        CookRecipeDataOuterClass.CookRecipeDataOrBuilder getRecipeDataOrBuilder();
    }

    private CookRecipeDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookRecipeDataNotifyOuterClass$CookRecipeDataNotify.class */
    public static final class CookRecipeDataNotify extends GeneratedMessageV3 implements CookRecipeDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RECIPE_DATA_FIELD_NUMBER = 1;
        private CookRecipeDataOuterClass.CookRecipeData recipeData_;
        private byte memoizedIsInitialized;
        private static final CookRecipeDataNotify DEFAULT_INSTANCE = new CookRecipeDataNotify();
        private static final Parser<CookRecipeDataNotify> PARSER = new AbstractParser<CookRecipeDataNotify>() { // from class: emu.grasscutter.net.proto.CookRecipeDataNotifyOuterClass.CookRecipeDataNotify.1
            @Override // com.google.protobuf.Parser
            public CookRecipeDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CookRecipeDataNotify(input, extensionRegistry);
            }
        };

        private CookRecipeDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CookRecipeDataNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CookRecipeDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CookRecipeDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                CookRecipeDataOuterClass.CookRecipeData.Builder subBuilder = this.recipeData_ != null ? this.recipeData_.toBuilder() : null;
                                this.recipeData_ = (CookRecipeDataOuterClass.CookRecipeData) input.readMessage(CookRecipeDataOuterClass.CookRecipeData.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.recipeData_);
                                    this.recipeData_ = subBuilder.buildPartial();
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
            return CookRecipeDataNotifyOuterClass.internal_static_CookRecipeDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CookRecipeDataNotifyOuterClass.internal_static_CookRecipeDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CookRecipeDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CookRecipeDataNotifyOuterClass.CookRecipeDataNotifyOrBuilder
        public boolean hasRecipeData() {
            return this.recipeData_ != null;
        }

        @Override // emu.grasscutter.net.proto.CookRecipeDataNotifyOuterClass.CookRecipeDataNotifyOrBuilder
        public CookRecipeDataOuterClass.CookRecipeData getRecipeData() {
            return this.recipeData_ == null ? CookRecipeDataOuterClass.CookRecipeData.getDefaultInstance() : this.recipeData_;
        }

        @Override // emu.grasscutter.net.proto.CookRecipeDataNotifyOuterClass.CookRecipeDataNotifyOrBuilder
        public CookRecipeDataOuterClass.CookRecipeDataOrBuilder getRecipeDataOrBuilder() {
            return getRecipeData();
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
            if (this.recipeData_ != null) {
                output.writeMessage(1, getRecipeData());
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
            if (this.recipeData_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getRecipeData());
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
            if (!(obj instanceof CookRecipeDataNotify)) {
                return equals(obj);
            }
            CookRecipeDataNotify other = (CookRecipeDataNotify) obj;
            if (hasRecipeData() != other.hasRecipeData()) {
                return false;
            }
            return (!hasRecipeData() || getRecipeData().equals(other.getRecipeData())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasRecipeData()) {
                hash = (53 * ((37 * hash) + 1)) + getRecipeData().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CookRecipeDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CookRecipeDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CookRecipeDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CookRecipeDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CookRecipeDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CookRecipeDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CookRecipeDataNotify parseFrom(InputStream input) throws IOException {
            return (CookRecipeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CookRecipeDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CookRecipeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CookRecipeDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CookRecipeDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CookRecipeDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CookRecipeDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CookRecipeDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (CookRecipeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CookRecipeDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CookRecipeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CookRecipeDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookRecipeDataNotifyOuterClass$CookRecipeDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CookRecipeDataNotifyOrBuilder {
            private CookRecipeDataOuterClass.CookRecipeData recipeData_;
            private SingleFieldBuilderV3<CookRecipeDataOuterClass.CookRecipeData, CookRecipeDataOuterClass.CookRecipeData.Builder, CookRecipeDataOuterClass.CookRecipeDataOrBuilder> recipeDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CookRecipeDataNotifyOuterClass.internal_static_CookRecipeDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CookRecipeDataNotifyOuterClass.internal_static_CookRecipeDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CookRecipeDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CookRecipeDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.recipeDataBuilder_ == null) {
                    this.recipeData_ = null;
                } else {
                    this.recipeData_ = null;
                    this.recipeDataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CookRecipeDataNotifyOuterClass.internal_static_CookRecipeDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CookRecipeDataNotify getDefaultInstanceForType() {
                return CookRecipeDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CookRecipeDataNotify build() {
                CookRecipeDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CookRecipeDataNotify buildPartial() {
                CookRecipeDataNotify result = new CookRecipeDataNotify(this);
                if (this.recipeDataBuilder_ == null) {
                    result.recipeData_ = this.recipeData_;
                } else {
                    result.recipeData_ = this.recipeDataBuilder_.build();
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
                if (other instanceof CookRecipeDataNotify) {
                    return mergeFrom((CookRecipeDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CookRecipeDataNotify other) {
                if (other == CookRecipeDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasRecipeData()) {
                    mergeRecipeData(other.getRecipeData());
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
                CookRecipeDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = CookRecipeDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CookRecipeDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CookRecipeDataNotifyOuterClass.CookRecipeDataNotifyOrBuilder
            public boolean hasRecipeData() {
                return (this.recipeDataBuilder_ == null && this.recipeData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.CookRecipeDataNotifyOuterClass.CookRecipeDataNotifyOrBuilder
            public CookRecipeDataOuterClass.CookRecipeData getRecipeData() {
                if (this.recipeDataBuilder_ == null) {
                    return this.recipeData_ == null ? CookRecipeDataOuterClass.CookRecipeData.getDefaultInstance() : this.recipeData_;
                }
                return this.recipeDataBuilder_.getMessage();
            }

            public Builder setRecipeData(CookRecipeDataOuterClass.CookRecipeData value) {
                if (this.recipeDataBuilder_ != null) {
                    this.recipeDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.recipeData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRecipeData(CookRecipeDataOuterClass.CookRecipeData.Builder builderForValue) {
                if (this.recipeDataBuilder_ == null) {
                    this.recipeData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.recipeDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRecipeData(CookRecipeDataOuterClass.CookRecipeData value) {
                if (this.recipeDataBuilder_ == null) {
                    if (this.recipeData_ != null) {
                        this.recipeData_ = CookRecipeDataOuterClass.CookRecipeData.newBuilder(this.recipeData_).mergeFrom(value).buildPartial();
                    } else {
                        this.recipeData_ = value;
                    }
                    onChanged();
                } else {
                    this.recipeDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRecipeData() {
                if (this.recipeDataBuilder_ == null) {
                    this.recipeData_ = null;
                    onChanged();
                } else {
                    this.recipeData_ = null;
                    this.recipeDataBuilder_ = null;
                }
                return this;
            }

            public CookRecipeDataOuterClass.CookRecipeData.Builder getRecipeDataBuilder() {
                onChanged();
                return getRecipeDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.CookRecipeDataNotifyOuterClass.CookRecipeDataNotifyOrBuilder
            public CookRecipeDataOuterClass.CookRecipeDataOrBuilder getRecipeDataOrBuilder() {
                if (this.recipeDataBuilder_ != null) {
                    return this.recipeDataBuilder_.getMessageOrBuilder();
                }
                return this.recipeData_ == null ? CookRecipeDataOuterClass.CookRecipeData.getDefaultInstance() : this.recipeData_;
            }

            private SingleFieldBuilderV3<CookRecipeDataOuterClass.CookRecipeData, CookRecipeDataOuterClass.CookRecipeData.Builder, CookRecipeDataOuterClass.CookRecipeDataOrBuilder> getRecipeDataFieldBuilder() {
                if (this.recipeDataBuilder_ == null) {
                    this.recipeDataBuilder_ = new SingleFieldBuilderV3<>(getRecipeData(), getParentForChildren(), isClean());
                    this.recipeData_ = null;
                }
                return this.recipeDataBuilder_;
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

        public static CookRecipeDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CookRecipeDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CookRecipeDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CookRecipeDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CookRecipeDataOuterClass.getDescriptor();
    }
}
