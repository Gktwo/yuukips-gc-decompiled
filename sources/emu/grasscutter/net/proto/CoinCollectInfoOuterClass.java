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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectInfoOuterClass.class */
public final class CoinCollectInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015CoinCollectInfo.proto\"K\n\u000fCoinCollectInfo\u0012\u001b\n\u0013Unk3300_CPLDPCMBHOE\u0018\u000b \u0001(\r\u0012\u001b\n\u0013Unk3300_DKBJMLJGLIB\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CoinCollectInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CoinCollectInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CoinCollectInfo_descriptor, new String[]{"Unk3300CPLDPCMBHOE", "Unk3300DKBJMLJGLIB"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectInfoOuterClass$CoinCollectInfoOrBuilder.class */
    public interface CoinCollectInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300CPLDPCMBHOE();

        int getUnk3300DKBJMLJGLIB();
    }

    private CoinCollectInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectInfoOuterClass$CoinCollectInfo.class */
    public static final class CoinCollectInfo extends GeneratedMessageV3 implements CoinCollectInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_CPLDPCMBHOE_FIELD_NUMBER = 11;
        private int unk3300CPLDPCMBHOE_;
        public static final int UNK3300_DKBJMLJGLIB_FIELD_NUMBER = 9;
        private int unk3300DKBJMLJGLIB_;
        private byte memoizedIsInitialized;
        private static final CoinCollectInfo DEFAULT_INSTANCE = new CoinCollectInfo();
        private static final Parser<CoinCollectInfo> PARSER = new AbstractParser<CoinCollectInfo>() { // from class: emu.grasscutter.net.proto.CoinCollectInfoOuterClass.CoinCollectInfo.1
            @Override // com.google.protobuf.Parser
            public CoinCollectInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CoinCollectInfo(input, extensionRegistry);
            }
        };

        private CoinCollectInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CoinCollectInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CoinCollectInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CoinCollectInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 72:
                                this.unk3300DKBJMLJGLIB_ = input.readUInt32();
                                break;
                            case 88:
                                this.unk3300CPLDPCMBHOE_ = input.readUInt32();
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
            return CoinCollectInfoOuterClass.internal_static_CoinCollectInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CoinCollectInfoOuterClass.internal_static_CoinCollectInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CoinCollectInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CoinCollectInfoOuterClass.CoinCollectInfoOrBuilder
        public int getUnk3300CPLDPCMBHOE() {
            return this.unk3300CPLDPCMBHOE_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectInfoOuterClass.CoinCollectInfoOrBuilder
        public int getUnk3300DKBJMLJGLIB() {
            return this.unk3300DKBJMLJGLIB_;
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
            if (this.unk3300DKBJMLJGLIB_ != 0) {
                output.writeUInt32(9, this.unk3300DKBJMLJGLIB_);
            }
            if (this.unk3300CPLDPCMBHOE_ != 0) {
                output.writeUInt32(11, this.unk3300CPLDPCMBHOE_);
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
            if (this.unk3300DKBJMLJGLIB_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(9, this.unk3300DKBJMLJGLIB_);
            }
            if (this.unk3300CPLDPCMBHOE_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.unk3300CPLDPCMBHOE_);
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
            if (!(obj instanceof CoinCollectInfo)) {
                return equals(obj);
            }
            CoinCollectInfo other = (CoinCollectInfo) obj;
            return getUnk3300CPLDPCMBHOE() == other.getUnk3300CPLDPCMBHOE() && getUnk3300DKBJMLJGLIB() == other.getUnk3300DKBJMLJGLIB() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getUnk3300CPLDPCMBHOE())) + 9)) + getUnk3300DKBJMLJGLIB())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CoinCollectInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectInfo parseFrom(InputStream input) throws IOException {
            return (CoinCollectInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CoinCollectInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CoinCollectInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CoinCollectInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CoinCollectInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CoinCollectInfo parseFrom(CodedInputStream input) throws IOException {
            return (CoinCollectInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CoinCollectInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CoinCollectInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectInfoOuterClass$CoinCollectInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CoinCollectInfoOrBuilder {
            private int unk3300CPLDPCMBHOE_;
            private int unk3300DKBJMLJGLIB_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CoinCollectInfoOuterClass.internal_static_CoinCollectInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CoinCollectInfoOuterClass.internal_static_CoinCollectInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CoinCollectInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CoinCollectInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300CPLDPCMBHOE_ = 0;
                this.unk3300DKBJMLJGLIB_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CoinCollectInfoOuterClass.internal_static_CoinCollectInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CoinCollectInfo getDefaultInstanceForType() {
                return CoinCollectInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CoinCollectInfo build() {
                CoinCollectInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CoinCollectInfo buildPartial() {
                CoinCollectInfo result = new CoinCollectInfo(this);
                result.unk3300CPLDPCMBHOE_ = this.unk3300CPLDPCMBHOE_;
                result.unk3300DKBJMLJGLIB_ = this.unk3300DKBJMLJGLIB_;
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
                if (other instanceof CoinCollectInfo) {
                    return mergeFrom((CoinCollectInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CoinCollectInfo other) {
                if (other == CoinCollectInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300CPLDPCMBHOE() != 0) {
                    setUnk3300CPLDPCMBHOE(other.getUnk3300CPLDPCMBHOE());
                }
                if (other.getUnk3300DKBJMLJGLIB() != 0) {
                    setUnk3300DKBJMLJGLIB(other.getUnk3300DKBJMLJGLIB());
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
                CoinCollectInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CoinCollectInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CoinCollectInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CoinCollectInfoOuterClass.CoinCollectInfoOrBuilder
            public int getUnk3300CPLDPCMBHOE() {
                return this.unk3300CPLDPCMBHOE_;
            }

            public Builder setUnk3300CPLDPCMBHOE(int value) {
                this.unk3300CPLDPCMBHOE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CPLDPCMBHOE() {
                this.unk3300CPLDPCMBHOE_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectInfoOuterClass.CoinCollectInfoOrBuilder
            public int getUnk3300DKBJMLJGLIB() {
                return this.unk3300DKBJMLJGLIB_;
            }

            public Builder setUnk3300DKBJMLJGLIB(int value) {
                this.unk3300DKBJMLJGLIB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DKBJMLJGLIB() {
                this.unk3300DKBJMLJGLIB_ = 0;
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

        public static CoinCollectInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CoinCollectInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CoinCollectInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CoinCollectInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
