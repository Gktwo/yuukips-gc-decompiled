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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterWorldAreaRspOuterClass.class */
public final class EnterWorldAreaRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017EnterWorldAreaRsp.proto\"H\n\u0011EnterWorldAreaRsp\u0012\u0011\n\tarea_type\u0018\u000f \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005\u0012\u000f\n\u0007area_id\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EnterWorldAreaRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EnterWorldAreaRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EnterWorldAreaRsp_descriptor, new String[]{"AreaType", "Retcode", "AreaId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterWorldAreaRspOuterClass$EnterWorldAreaRspOrBuilder.class */
    public interface EnterWorldAreaRspOrBuilder extends MessageOrBuilder {
        int getAreaType();

        int getRetcode();

        int getAreaId();
    }

    private EnterWorldAreaRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterWorldAreaRspOuterClass$EnterWorldAreaRsp.class */
    public static final class EnterWorldAreaRsp extends GeneratedMessageV3 implements EnterWorldAreaRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AREA_TYPE_FIELD_NUMBER = 15;
        private int areaType_;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        public static final int AREA_ID_FIELD_NUMBER = 1;
        private int areaId_;
        private byte memoizedIsInitialized;
        private static final EnterWorldAreaRsp DEFAULT_INSTANCE = new EnterWorldAreaRsp();
        private static final Parser<EnterWorldAreaRsp> PARSER = new AbstractParser<EnterWorldAreaRsp>() { // from class: emu.grasscutter.net.proto.EnterWorldAreaRspOuterClass.EnterWorldAreaRsp.1
            @Override // com.google.protobuf.Parser
            public EnterWorldAreaRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EnterWorldAreaRsp(input, extensionRegistry);
            }
        };

        private EnterWorldAreaRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EnterWorldAreaRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EnterWorldAreaRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EnterWorldAreaRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.areaId_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 120:
                                    this.areaType_ = input.readUInt32();
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
            return EnterWorldAreaRspOuterClass.internal_static_EnterWorldAreaRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EnterWorldAreaRspOuterClass.internal_static_EnterWorldAreaRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterWorldAreaRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EnterWorldAreaRspOuterClass.EnterWorldAreaRspOrBuilder
        public int getAreaType() {
            return this.areaType_;
        }

        @Override // emu.grasscutter.net.proto.EnterWorldAreaRspOuterClass.EnterWorldAreaRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.EnterWorldAreaRspOuterClass.EnterWorldAreaRspOrBuilder
        public int getAreaId() {
            return this.areaId_;
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
            if (this.areaId_ != 0) {
                output.writeUInt32(1, this.areaId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
            }
            if (this.areaType_ != 0) {
                output.writeUInt32(15, this.areaType_);
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
            if (this.areaId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.areaId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(11, this.retcode_);
            }
            if (this.areaType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.areaType_);
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
            if (!(obj instanceof EnterWorldAreaRsp)) {
                return equals(obj);
            }
            EnterWorldAreaRsp other = (EnterWorldAreaRsp) obj;
            return getAreaType() == other.getAreaType() && getRetcode() == other.getRetcode() && getAreaId() == other.getAreaId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getAreaType())) + 11)) + getRetcode())) + 1)) + getAreaId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EnterWorldAreaRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EnterWorldAreaRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterWorldAreaRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EnterWorldAreaRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterWorldAreaRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EnterWorldAreaRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterWorldAreaRsp parseFrom(InputStream input) throws IOException {
            return (EnterWorldAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EnterWorldAreaRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterWorldAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EnterWorldAreaRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (EnterWorldAreaRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EnterWorldAreaRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterWorldAreaRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EnterWorldAreaRsp parseFrom(CodedInputStream input) throws IOException {
            return (EnterWorldAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EnterWorldAreaRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterWorldAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnterWorldAreaRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterWorldAreaRspOuterClass$EnterWorldAreaRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EnterWorldAreaRspOrBuilder {
            private int areaType_;
            private int retcode_;
            private int areaId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EnterWorldAreaRspOuterClass.internal_static_EnterWorldAreaRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EnterWorldAreaRspOuterClass.internal_static_EnterWorldAreaRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterWorldAreaRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EnterWorldAreaRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.areaType_ = 0;
                this.retcode_ = 0;
                this.areaId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EnterWorldAreaRspOuterClass.internal_static_EnterWorldAreaRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EnterWorldAreaRsp getDefaultInstanceForType() {
                return EnterWorldAreaRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnterWorldAreaRsp build() {
                EnterWorldAreaRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnterWorldAreaRsp buildPartial() {
                EnterWorldAreaRsp result = new EnterWorldAreaRsp(this);
                result.areaType_ = this.areaType_;
                result.retcode_ = this.retcode_;
                result.areaId_ = this.areaId_;
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
                if (other instanceof EnterWorldAreaRsp) {
                    return mergeFrom((EnterWorldAreaRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnterWorldAreaRsp other) {
                if (other == EnterWorldAreaRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getAreaType() != 0) {
                    setAreaType(other.getAreaType());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getAreaId() != 0) {
                    setAreaId(other.getAreaId());
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
                EnterWorldAreaRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = EnterWorldAreaRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EnterWorldAreaRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EnterWorldAreaRspOuterClass.EnterWorldAreaRspOrBuilder
            public int getAreaType() {
                return this.areaType_;
            }

            public Builder setAreaType(int value) {
                this.areaType_ = value;
                onChanged();
                return this;
            }

            public Builder clearAreaType() {
                this.areaType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EnterWorldAreaRspOuterClass.EnterWorldAreaRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EnterWorldAreaRspOuterClass.EnterWorldAreaRspOrBuilder
            public int getAreaId() {
                return this.areaId_;
            }

            public Builder setAreaId(int value) {
                this.areaId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAreaId() {
                this.areaId_ = 0;
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

        public static EnterWorldAreaRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnterWorldAreaRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EnterWorldAreaRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EnterWorldAreaRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
