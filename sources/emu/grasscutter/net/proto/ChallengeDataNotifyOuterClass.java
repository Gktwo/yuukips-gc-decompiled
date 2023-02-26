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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallengeDataNotifyOuterClass.class */
public final class ChallengeDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019ChallengeDataNotify.proto\"P\n\u0013ChallengeDataNotify\u0012\u0012\n\nparamIndex\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u000b \u0001(\r\u0012\u0016\n\u000echallengeIndex\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChallengeDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChallengeDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChallengeDataNotify_descriptor, new String[]{"ParamIndex", "Value", "ChallengeIndex"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallengeDataNotifyOuterClass$ChallengeDataNotifyOrBuilder.class */
    public interface ChallengeDataNotifyOrBuilder extends MessageOrBuilder {
        int getParamIndex();

        int getValue();

        int getChallengeIndex();
    }

    private ChallengeDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallengeDataNotifyOuterClass$ChallengeDataNotify.class */
    public static final class ChallengeDataNotify extends GeneratedMessageV3 implements ChallengeDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARAMINDEX_FIELD_NUMBER = 1;
        private int paramIndex_;
        public static final int VALUE_FIELD_NUMBER = 11;
        private int value_;
        public static final int CHALLENGEINDEX_FIELD_NUMBER = 8;
        private int challengeIndex_;
        private byte memoizedIsInitialized;
        private static final ChallengeDataNotify DEFAULT_INSTANCE = new ChallengeDataNotify();
        private static final Parser<ChallengeDataNotify> PARSER = new AbstractParser<ChallengeDataNotify>() { // from class: emu.grasscutter.net.proto.ChallengeDataNotifyOuterClass.ChallengeDataNotify.1
            @Override // com.google.protobuf.Parser
            public ChallengeDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChallengeDataNotify(input, extensionRegistry);
            }
        };

        private ChallengeDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChallengeDataNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChallengeDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChallengeDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.paramIndex_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.challengeIndex_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.value_ = input.readUInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChallengeDataNotifyOuterClass.internal_static_ChallengeDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChallengeDataNotifyOuterClass.internal_static_ChallengeDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChallengeDataNotifyOuterClass.ChallengeDataNotifyOrBuilder
        public int getParamIndex() {
            return this.paramIndex_;
        }

        @Override // emu.grasscutter.net.proto.ChallengeDataNotifyOuterClass.ChallengeDataNotifyOrBuilder
        public int getValue() {
            return this.value_;
        }

        @Override // emu.grasscutter.net.proto.ChallengeDataNotifyOuterClass.ChallengeDataNotifyOrBuilder
        public int getChallengeIndex() {
            return this.challengeIndex_;
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
            if (this.paramIndex_ != 0) {
                output.writeUInt32(1, this.paramIndex_);
            }
            if (this.challengeIndex_ != 0) {
                output.writeUInt32(8, this.challengeIndex_);
            }
            if (this.value_ != 0) {
                output.writeUInt32(11, this.value_);
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
            if (this.paramIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.paramIndex_);
            }
            if (this.challengeIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.challengeIndex_);
            }
            if (this.value_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.value_);
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
            if (!(obj instanceof ChallengeDataNotify)) {
                return equals(obj);
            }
            ChallengeDataNotify other = (ChallengeDataNotify) obj;
            return getParamIndex() == other.getParamIndex() && getValue() == other.getValue() && getChallengeIndex() == other.getChallengeIndex() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getParamIndex())) + 11)) + getValue())) + 8)) + getChallengeIndex())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ChallengeDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChallengeDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChallengeDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChallengeDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChallengeDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChallengeDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChallengeDataNotify parseFrom(InputStream input) throws IOException {
            return (ChallengeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChallengeDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChallengeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChallengeDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ChallengeDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChallengeDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChallengeDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChallengeDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (ChallengeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChallengeDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChallengeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChallengeDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallengeDataNotifyOuterClass$ChallengeDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeDataNotifyOrBuilder {
            private int paramIndex_;
            private int value_;
            private int challengeIndex_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChallengeDataNotifyOuterClass.internal_static_ChallengeDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChallengeDataNotifyOuterClass.internal_static_ChallengeDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChallengeDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.paramIndex_ = 0;
                this.value_ = 0;
                this.challengeIndex_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChallengeDataNotifyOuterClass.internal_static_ChallengeDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChallengeDataNotify getDefaultInstanceForType() {
                return ChallengeDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChallengeDataNotify build() {
                ChallengeDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChallengeDataNotify buildPartial() {
                ChallengeDataNotify result = new ChallengeDataNotify(this);
                result.paramIndex_ = this.paramIndex_;
                result.value_ = this.value_;
                result.challengeIndex_ = this.challengeIndex_;
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
                if (other instanceof ChallengeDataNotify) {
                    return mergeFrom((ChallengeDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChallengeDataNotify other) {
                if (other == ChallengeDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getParamIndex() != 0) {
                    setParamIndex(other.getParamIndex());
                }
                if (other.getValue() != 0) {
                    setValue(other.getValue());
                }
                if (other.getChallengeIndex() != 0) {
                    setChallengeIndex(other.getChallengeIndex());
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
                ChallengeDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChallengeDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChallengeDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChallengeDataNotifyOuterClass.ChallengeDataNotifyOrBuilder
            public int getParamIndex() {
                return this.paramIndex_;
            }

            public Builder setParamIndex(int value) {
                this.paramIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearParamIndex() {
                this.paramIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChallengeDataNotifyOuterClass.ChallengeDataNotifyOrBuilder
            public int getValue() {
                return this.value_;
            }

            public Builder setValue(int value) {
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.value_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChallengeDataNotifyOuterClass.ChallengeDataNotifyOrBuilder
            public int getChallengeIndex() {
                return this.challengeIndex_;
            }

            public Builder setChallengeIndex(int value) {
                this.challengeIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeIndex() {
                this.challengeIndex_ = 0;
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

        public static ChallengeDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChallengeDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChallengeDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChallengeDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
