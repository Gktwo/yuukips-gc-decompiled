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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineReqOuterClass.class */
public final class CombineReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010CombineReq.proto\"I\n\nCombineReq\u0012\u0014\n\fcombineCount\u0018\n \u0001(\r\u0012\u0011\n\tcombineId\u0018\b \u0001(\r\u0012\u0012\n\navatarGuid\u0018\u000f \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CombineReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CombineReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CombineReq_descriptor, new String[]{"CombineCount", "CombineId", "AvatarGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineReqOuterClass$CombineReqOrBuilder.class */
    public interface CombineReqOrBuilder extends MessageOrBuilder {
        int getCombineCount();

        int getCombineId();

        long getAvatarGuid();
    }

    private CombineReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineReqOuterClass$CombineReq.class */
    public static final class CombineReq extends GeneratedMessageV3 implements CombineReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMBINECOUNT_FIELD_NUMBER = 10;
        private int combineCount_;
        public static final int COMBINEID_FIELD_NUMBER = 8;
        private int combineId_;
        public static final int AVATARGUID_FIELD_NUMBER = 15;
        private long avatarGuid_;
        private byte memoizedIsInitialized;
        private static final CombineReq DEFAULT_INSTANCE = new CombineReq();
        private static final Parser<CombineReq> PARSER = new AbstractParser<CombineReq>() { // from class: emu.grasscutter.net.proto.CombineReqOuterClass.CombineReq.1
            @Override // com.google.protobuf.Parser
            public CombineReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CombineReq(input, extensionRegistry);
            }
        };

        private CombineReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CombineReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CombineReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CombineReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 64:
                                    this.combineId_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.combineCount_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.avatarGuid_ = input.readUInt64();
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
            return CombineReqOuterClass.internal_static_CombineReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CombineReqOuterClass.internal_static_CombineReq_fieldAccessorTable.ensureFieldAccessorsInitialized(CombineReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CombineReqOuterClass.CombineReqOrBuilder
        public int getCombineCount() {
            return this.combineCount_;
        }

        @Override // emu.grasscutter.net.proto.CombineReqOuterClass.CombineReqOrBuilder
        public int getCombineId() {
            return this.combineId_;
        }

        @Override // emu.grasscutter.net.proto.CombineReqOuterClass.CombineReqOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
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
            if (this.combineId_ != 0) {
                output.writeUInt32(8, this.combineId_);
            }
            if (this.combineCount_ != 0) {
                output.writeUInt32(10, this.combineCount_);
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(15, this.avatarGuid_);
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
            if (this.combineId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.combineId_);
            }
            if (this.combineCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.combineCount_);
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(15, this.avatarGuid_);
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
            if (!(obj instanceof CombineReq)) {
                return equals(obj);
            }
            CombineReq other = (CombineReq) obj;
            return getCombineCount() == other.getCombineCount() && getCombineId() == other.getCombineId() && getAvatarGuid() == other.getAvatarGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getCombineCount())) + 8)) + getCombineId())) + 15)) + Internal.hashLong(getAvatarGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CombineReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineReq parseFrom(InputStream input) throws IOException {
            return (CombineReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombineReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombineReq parseDelimitedFrom(InputStream input) throws IOException {
            return (CombineReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CombineReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombineReq parseFrom(CodedInputStream input) throws IOException {
            return (CombineReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombineReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CombineReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineReqOuterClass$CombineReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CombineReqOrBuilder {
            private int combineCount_;
            private int combineId_;
            private long avatarGuid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CombineReqOuterClass.internal_static_CombineReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CombineReqOuterClass.internal_static_CombineReq_fieldAccessorTable.ensureFieldAccessorsInitialized(CombineReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CombineReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.combineCount_ = 0;
                this.combineId_ = 0;
                this.avatarGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CombineReqOuterClass.internal_static_CombineReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CombineReq getDefaultInstanceForType() {
                return CombineReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombineReq build() {
                CombineReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombineReq buildPartial() {
                CombineReq result = new CombineReq(this);
                result.combineCount_ = this.combineCount_;
                result.combineId_ = this.combineId_;
                result.avatarGuid_ = this.avatarGuid_;
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
                if (other instanceof CombineReq) {
                    return mergeFrom((CombineReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CombineReq other) {
                if (other == CombineReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getCombineCount() != 0) {
                    setCombineCount(other.getCombineCount());
                }
                if (other.getCombineId() != 0) {
                    setCombineId(other.getCombineId());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
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
                CombineReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = CombineReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CombineReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CombineReqOuterClass.CombineReqOrBuilder
            public int getCombineCount() {
                return this.combineCount_;
            }

            public Builder setCombineCount(int value) {
                this.combineCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombineCount() {
                this.combineCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CombineReqOuterClass.CombineReqOrBuilder
            public int getCombineId() {
                return this.combineId_;
            }

            public Builder setCombineId(int value) {
                this.combineId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombineId() {
                this.combineId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CombineReqOuterClass.CombineReqOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
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

        public static CombineReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CombineReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CombineReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CombineReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
