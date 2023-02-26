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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExhibitionDisplayInfoOuterClass.class */
public final class ExhibitionDisplayInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bExhibitionDisplayInfo.proto\"G\n\u0015ExhibitionDisplayInfo\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012\r\n\u0005param\u0018\u0002 \u0001(\r\u0012\u0013\n\u000bdetailParam\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ExhibitionDisplayInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ExhibitionDisplayInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ExhibitionDisplayInfo_descriptor, new String[]{"Id", "Param", "DetailParam"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExhibitionDisplayInfoOuterClass$ExhibitionDisplayInfoOrBuilder.class */
    public interface ExhibitionDisplayInfoOrBuilder extends MessageOrBuilder {
        int getId();

        int getParam();

        int getDetailParam();
    }

    private ExhibitionDisplayInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExhibitionDisplayInfoOuterClass$ExhibitionDisplayInfo.class */
    public static final class ExhibitionDisplayInfo extends GeneratedMessageV3 implements ExhibitionDisplayInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int PARAM_FIELD_NUMBER = 2;
        private int param_;
        public static final int DETAILPARAM_FIELD_NUMBER = 3;
        private int detailParam_;
        private byte memoizedIsInitialized;
        private static final ExhibitionDisplayInfo DEFAULT_INSTANCE = new ExhibitionDisplayInfo();
        private static final Parser<ExhibitionDisplayInfo> PARSER = new AbstractParser<ExhibitionDisplayInfo>() { // from class: emu.grasscutter.net.proto.ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.1
            @Override // com.google.protobuf.Parser
            public ExhibitionDisplayInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExhibitionDisplayInfo(input, extensionRegistry);
            }
        };

        private ExhibitionDisplayInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ExhibitionDisplayInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ExhibitionDisplayInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ExhibitionDisplayInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.id_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.param_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.detailParam_ = input.readUInt32();
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
            return ExhibitionDisplayInfoOuterClass.internal_static_ExhibitionDisplayInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExhibitionDisplayInfoOuterClass.internal_static_ExhibitionDisplayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExhibitionDisplayInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder
        public int getParam() {
            return this.param_;
        }

        @Override // emu.grasscutter.net.proto.ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder
        public int getDetailParam() {
            return this.detailParam_;
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
            if (this.id_ != 0) {
                output.writeUInt32(1, this.id_);
            }
            if (this.param_ != 0) {
                output.writeUInt32(2, this.param_);
            }
            if (this.detailParam_ != 0) {
                output.writeUInt32(3, this.detailParam_);
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
            if (this.id_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.id_);
            }
            if (this.param_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.param_);
            }
            if (this.detailParam_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.detailParam_);
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
            if (!(obj instanceof ExhibitionDisplayInfo)) {
                return equals(obj);
            }
            ExhibitionDisplayInfo other = (ExhibitionDisplayInfo) obj;
            return getId() == other.getId() && getParam() == other.getParam() && getDetailParam() == other.getDetailParam() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getId())) + 2)) + getParam())) + 3)) + getDetailParam())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ExhibitionDisplayInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExhibitionDisplayInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExhibitionDisplayInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExhibitionDisplayInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExhibitionDisplayInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExhibitionDisplayInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExhibitionDisplayInfo parseFrom(InputStream input) throws IOException {
            return (ExhibitionDisplayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ExhibitionDisplayInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExhibitionDisplayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ExhibitionDisplayInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ExhibitionDisplayInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ExhibitionDisplayInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExhibitionDisplayInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ExhibitionDisplayInfo parseFrom(CodedInputStream input) throws IOException {
            return (ExhibitionDisplayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ExhibitionDisplayInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExhibitionDisplayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExhibitionDisplayInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExhibitionDisplayInfoOuterClass$ExhibitionDisplayInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExhibitionDisplayInfoOrBuilder {
            private int id_;
            private int param_;
            private int detailParam_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExhibitionDisplayInfoOuterClass.internal_static_ExhibitionDisplayInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExhibitionDisplayInfoOuterClass.internal_static_ExhibitionDisplayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExhibitionDisplayInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExhibitionDisplayInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.id_ = 0;
                this.param_ = 0;
                this.detailParam_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ExhibitionDisplayInfoOuterClass.internal_static_ExhibitionDisplayInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ExhibitionDisplayInfo getDefaultInstanceForType() {
                return ExhibitionDisplayInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ExhibitionDisplayInfo build() {
                ExhibitionDisplayInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ExhibitionDisplayInfo buildPartial() {
                ExhibitionDisplayInfo result = new ExhibitionDisplayInfo(this);
                result.id_ = this.id_;
                result.param_ = this.param_;
                result.detailParam_ = this.detailParam_;
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
                if (other instanceof ExhibitionDisplayInfo) {
                    return mergeFrom((ExhibitionDisplayInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExhibitionDisplayInfo other) {
                if (other == ExhibitionDisplayInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
                }
                if (other.getDetailParam() != 0) {
                    setDetailParam(other.getDetailParam());
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
                ExhibitionDisplayInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ExhibitionDisplayInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ExhibitionDisplayInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder
            public int getParam() {
                return this.param_;
            }

            public Builder setParam(int value) {
                this.param_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam() {
                this.param_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder
            public int getDetailParam() {
                return this.detailParam_;
            }

            public Builder setDetailParam(int value) {
                this.detailParam_ = value;
                onChanged();
                return this;
            }

            public Builder clearDetailParam() {
                this.detailParam_ = 0;
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

        public static ExhibitionDisplayInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExhibitionDisplayInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ExhibitionDisplayInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ExhibitionDisplayInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
