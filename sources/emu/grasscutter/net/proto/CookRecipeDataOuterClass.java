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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookRecipeDataOuterClass.class */
public final class CookRecipeDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014CookRecipeData.proto\"7\n\u000eCookRecipeData\u0012\u0013\n\u000bproficiency\u0018\u0001 \u0001(\r\u0012\u0010\n\brecipeId\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CookRecipeData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CookRecipeData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CookRecipeData_descriptor, new String[]{"Proficiency", "RecipeId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookRecipeDataOuterClass$CookRecipeDataOrBuilder.class */
    public interface CookRecipeDataOrBuilder extends MessageOrBuilder {
        int getProficiency();

        int getRecipeId();
    }

    private CookRecipeDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookRecipeDataOuterClass$CookRecipeData.class */
    public static final class CookRecipeData extends GeneratedMessageV3 implements CookRecipeDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PROFICIENCY_FIELD_NUMBER = 1;
        private int proficiency_;
        public static final int RECIPEID_FIELD_NUMBER = 6;
        private int recipeId_;
        private byte memoizedIsInitialized;
        private static final CookRecipeData DEFAULT_INSTANCE = new CookRecipeData();
        private static final Parser<CookRecipeData> PARSER = new AbstractParser<CookRecipeData>() { // from class: emu.grasscutter.net.proto.CookRecipeDataOuterClass.CookRecipeData.1
            @Override // com.google.protobuf.Parser
            public CookRecipeData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CookRecipeData(input, extensionRegistry);
            }
        };

        private CookRecipeData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CookRecipeData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CookRecipeData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CookRecipeData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.proficiency_ = input.readUInt32();
                                break;
                            case 48:
                                this.recipeId_ = input.readUInt32();
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
            return CookRecipeDataOuterClass.internal_static_CookRecipeData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CookRecipeDataOuterClass.internal_static_CookRecipeData_fieldAccessorTable.ensureFieldAccessorsInitialized(CookRecipeData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CookRecipeDataOuterClass.CookRecipeDataOrBuilder
        public int getProficiency() {
            return this.proficiency_;
        }

        @Override // emu.grasscutter.net.proto.CookRecipeDataOuterClass.CookRecipeDataOrBuilder
        public int getRecipeId() {
            return this.recipeId_;
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
            if (this.proficiency_ != 0) {
                output.writeUInt32(1, this.proficiency_);
            }
            if (this.recipeId_ != 0) {
                output.writeUInt32(6, this.recipeId_);
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
            if (this.proficiency_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.proficiency_);
            }
            if (this.recipeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.recipeId_);
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
            if (!(obj instanceof CookRecipeData)) {
                return equals(obj);
            }
            CookRecipeData other = (CookRecipeData) obj;
            return getProficiency() == other.getProficiency() && getRecipeId() == other.getRecipeId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getProficiency())) + 6)) + getRecipeId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CookRecipeData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CookRecipeData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CookRecipeData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CookRecipeData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CookRecipeData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CookRecipeData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CookRecipeData parseFrom(InputStream input) throws IOException {
            return (CookRecipeData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CookRecipeData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CookRecipeData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CookRecipeData parseDelimitedFrom(InputStream input) throws IOException {
            return (CookRecipeData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CookRecipeData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CookRecipeData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CookRecipeData parseFrom(CodedInputStream input) throws IOException {
            return (CookRecipeData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CookRecipeData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CookRecipeData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CookRecipeData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookRecipeDataOuterClass$CookRecipeData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CookRecipeDataOrBuilder {
            private int proficiency_;
            private int recipeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CookRecipeDataOuterClass.internal_static_CookRecipeData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CookRecipeDataOuterClass.internal_static_CookRecipeData_fieldAccessorTable.ensureFieldAccessorsInitialized(CookRecipeData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CookRecipeData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.proficiency_ = 0;
                this.recipeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CookRecipeDataOuterClass.internal_static_CookRecipeData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CookRecipeData getDefaultInstanceForType() {
                return CookRecipeData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CookRecipeData build() {
                CookRecipeData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CookRecipeData buildPartial() {
                CookRecipeData result = new CookRecipeData(this);
                result.proficiency_ = this.proficiency_;
                result.recipeId_ = this.recipeId_;
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
                if (other instanceof CookRecipeData) {
                    return mergeFrom((CookRecipeData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CookRecipeData other) {
                if (other == CookRecipeData.getDefaultInstance()) {
                    return this;
                }
                if (other.getProficiency() != 0) {
                    setProficiency(other.getProficiency());
                }
                if (other.getRecipeId() != 0) {
                    setRecipeId(other.getRecipeId());
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
                CookRecipeData parsedMessage = null;
                try {
                    try {
                        parsedMessage = CookRecipeData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CookRecipeData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CookRecipeDataOuterClass.CookRecipeDataOrBuilder
            public int getProficiency() {
                return this.proficiency_;
            }

            public Builder setProficiency(int value) {
                this.proficiency_ = value;
                onChanged();
                return this;
            }

            public Builder clearProficiency() {
                this.proficiency_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CookRecipeDataOuterClass.CookRecipeDataOrBuilder
            public int getRecipeId() {
                return this.recipeId_;
            }

            public Builder setRecipeId(int value) {
                this.recipeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRecipeId() {
                this.recipeId_ = 0;
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

        public static CookRecipeData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CookRecipeData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CookRecipeData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CookRecipeData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
