package emu.grasscutter.net.proto;

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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InferenceWordInfoOuterClass.class */
public final class InferenceWordInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017InferenceWordInfo.proto\"w\n\u0011InferenceWordInfo\u0012\u0013\n\u000bisAssociate\u0018\u0003 \u0001(\b\u0012\u000e\n\u0006wordId\u0018\u0005 \u0001(\r\u0012\u0016\n\u000eunlockByWordId\u0018\r \u0001(\r\u0012\u0010\n\bisSubmit\u0018\u0004 \u0001(\b\u0012\u0013\n\u000bisInterpret\u0018\u0007 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_InferenceWordInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_InferenceWordInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_InferenceWordInfo_descriptor, new String[]{"IsAssociate", "WordId", "UnlockByWordId", "IsSubmit", "IsInterpret"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InferenceWordInfoOuterClass$InferenceWordInfoOrBuilder.class */
    public interface InferenceWordInfoOrBuilder extends MessageOrBuilder {
        boolean getIsAssociate();

        int getWordId();

        int getUnlockByWordId();

        boolean getIsSubmit();

        boolean getIsInterpret();
    }

    private InferenceWordInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InferenceWordInfoOuterClass$InferenceWordInfo.class */
    public static final class InferenceWordInfo extends GeneratedMessageV3 implements InferenceWordInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISASSOCIATE_FIELD_NUMBER = 3;
        private boolean isAssociate_;
        public static final int WORDID_FIELD_NUMBER = 5;
        private int wordId_;
        public static final int UNLOCKBYWORDID_FIELD_NUMBER = 13;
        private int unlockByWordId_;
        public static final int ISSUBMIT_FIELD_NUMBER = 4;
        private boolean isSubmit_;
        public static final int ISINTERPRET_FIELD_NUMBER = 7;
        private boolean isInterpret_;
        private byte memoizedIsInitialized;
        private static final InferenceWordInfo DEFAULT_INSTANCE = new InferenceWordInfo();
        private static final Parser<InferenceWordInfo> PARSER = new AbstractParser<InferenceWordInfo>() { // from class: emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfo.1
            @Override // com.google.protobuf.Parser
            public InferenceWordInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InferenceWordInfo(input, extensionRegistry);
            }
        };

        private InferenceWordInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private InferenceWordInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new InferenceWordInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InferenceWordInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isAssociate_ = input.readBool();
                                break;
                            case 32:
                                this.isSubmit_ = input.readBool();
                                break;
                            case 40:
                                this.wordId_ = input.readUInt32();
                                break;
                            case 56:
                                this.isInterpret_ = input.readBool();
                                break;
                            case 104:
                                this.unlockByWordId_ = input.readUInt32();
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
            return InferenceWordInfoOuterClass.internal_static_InferenceWordInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InferenceWordInfoOuterClass.internal_static_InferenceWordInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(InferenceWordInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder
        public boolean getIsAssociate() {
            return this.isAssociate_;
        }

        @Override // emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder
        public int getWordId() {
            return this.wordId_;
        }

        @Override // emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder
        public int getUnlockByWordId() {
            return this.unlockByWordId_;
        }

        @Override // emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder
        public boolean getIsSubmit() {
            return this.isSubmit_;
        }

        @Override // emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder
        public boolean getIsInterpret() {
            return this.isInterpret_;
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
            if (this.isAssociate_) {
                output.writeBool(3, this.isAssociate_);
            }
            if (this.isSubmit_) {
                output.writeBool(4, this.isSubmit_);
            }
            if (this.wordId_ != 0) {
                output.writeUInt32(5, this.wordId_);
            }
            if (this.isInterpret_) {
                output.writeBool(7, this.isInterpret_);
            }
            if (this.unlockByWordId_ != 0) {
                output.writeUInt32(13, this.unlockByWordId_);
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
            if (this.isAssociate_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.isAssociate_);
            }
            if (this.isSubmit_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isSubmit_);
            }
            if (this.wordId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.wordId_);
            }
            if (this.isInterpret_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isInterpret_);
            }
            if (this.unlockByWordId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.unlockByWordId_);
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
            if (!(obj instanceof InferenceWordInfo)) {
                return equals(obj);
            }
            InferenceWordInfo other = (InferenceWordInfo) obj;
            return getIsAssociate() == other.getIsAssociate() && getWordId() == other.getWordId() && getUnlockByWordId() == other.getUnlockByWordId() && getIsSubmit() == other.getIsSubmit() && getIsInterpret() == other.getIsInterpret() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + Internal.hashBoolean(getIsAssociate()))) + 5)) + getWordId())) + 13)) + getUnlockByWordId())) + 4)) + Internal.hashBoolean(getIsSubmit()))) + 7)) + Internal.hashBoolean(getIsInterpret()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static InferenceWordInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InferenceWordInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InferenceWordInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InferenceWordInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InferenceWordInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InferenceWordInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InferenceWordInfo parseFrom(InputStream input) throws IOException {
            return (InferenceWordInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InferenceWordInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InferenceWordInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static InferenceWordInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (InferenceWordInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static InferenceWordInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InferenceWordInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static InferenceWordInfo parseFrom(CodedInputStream input) throws IOException {
            return (InferenceWordInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InferenceWordInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InferenceWordInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(InferenceWordInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InferenceWordInfoOuterClass$InferenceWordInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InferenceWordInfoOrBuilder {
            private boolean isAssociate_;
            private int wordId_;
            private int unlockByWordId_;
            private boolean isSubmit_;
            private boolean isInterpret_;

            public static final Descriptors.Descriptor getDescriptor() {
                return InferenceWordInfoOuterClass.internal_static_InferenceWordInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InferenceWordInfoOuterClass.internal_static_InferenceWordInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(InferenceWordInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (InferenceWordInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isAssociate_ = false;
                this.wordId_ = 0;
                this.unlockByWordId_ = 0;
                this.isSubmit_ = false;
                this.isInterpret_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InferenceWordInfoOuterClass.internal_static_InferenceWordInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public InferenceWordInfo getDefaultInstanceForType() {
                return InferenceWordInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InferenceWordInfo build() {
                InferenceWordInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InferenceWordInfo buildPartial() {
                InferenceWordInfo result = new InferenceWordInfo(this);
                result.isAssociate_ = this.isAssociate_;
                result.wordId_ = this.wordId_;
                result.unlockByWordId_ = this.unlockByWordId_;
                result.isSubmit_ = this.isSubmit_;
                result.isInterpret_ = this.isInterpret_;
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
                if (other instanceof InferenceWordInfo) {
                    return mergeFrom((InferenceWordInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InferenceWordInfo other) {
                if (other == InferenceWordInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsAssociate()) {
                    setIsAssociate(other.getIsAssociate());
                }
                if (other.getWordId() != 0) {
                    setWordId(other.getWordId());
                }
                if (other.getUnlockByWordId() != 0) {
                    setUnlockByWordId(other.getUnlockByWordId());
                }
                if (other.getIsSubmit()) {
                    setIsSubmit(other.getIsSubmit());
                }
                if (other.getIsInterpret()) {
                    setIsInterpret(other.getIsInterpret());
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
                InferenceWordInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = InferenceWordInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (InferenceWordInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder
            public boolean getIsAssociate() {
                return this.isAssociate_;
            }

            public Builder setIsAssociate(boolean value) {
                this.isAssociate_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAssociate() {
                this.isAssociate_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder
            public int getWordId() {
                return this.wordId_;
            }

            public Builder setWordId(int value) {
                this.wordId_ = value;
                onChanged();
                return this;
            }

            public Builder clearWordId() {
                this.wordId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder
            public int getUnlockByWordId() {
                return this.unlockByWordId_;
            }

            public Builder setUnlockByWordId(int value) {
                this.unlockByWordId_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnlockByWordId() {
                this.unlockByWordId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder
            public boolean getIsSubmit() {
                return this.isSubmit_;
            }

            public Builder setIsSubmit(boolean value) {
                this.isSubmit_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSubmit() {
                this.isSubmit_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder
            public boolean getIsInterpret() {
                return this.isInterpret_;
            }

            public Builder setIsInterpret(boolean value) {
                this.isInterpret_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsInterpret() {
                this.isInterpret_ = false;
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

        public static InferenceWordInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InferenceWordInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<InferenceWordInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public InferenceWordInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
