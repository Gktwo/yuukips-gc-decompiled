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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeSettleCoinInfoOuterClass.class */
public final class RoguelikeSettleCoinInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dRoguelikeSettleCoinInfo.proto\"b\n\u0017RoguelikeSettleCoinInfo\u0012\u001b\n\u0013Unk3300_MFKOIMONCLA\u0018\f \u0001(\r\u0012\r\n\u0005coinC\u0018\u0007 \u0001(\r\u0012\u001b\n\u0013Unk3300_LFEKGBBAMHE\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RoguelikeSettleCoinInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RoguelikeSettleCoinInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RoguelikeSettleCoinInfo_descriptor, new String[]{"Unk3300MFKOIMONCLA", "CoinC", "Unk3300LFEKGBBAMHE"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeSettleCoinInfoOuterClass$RoguelikeSettleCoinInfoOrBuilder.class */
    public interface RoguelikeSettleCoinInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300MFKOIMONCLA();

        int getCoinC();

        int getUnk3300LFEKGBBAMHE();
    }

    private RoguelikeSettleCoinInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeSettleCoinInfoOuterClass$RoguelikeSettleCoinInfo.class */
    public static final class RoguelikeSettleCoinInfo extends GeneratedMessageV3 implements RoguelikeSettleCoinInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_MFKOIMONCLA_FIELD_NUMBER = 12;
        private int unk3300MFKOIMONCLA_;
        public static final int COINC_FIELD_NUMBER = 7;
        private int coinC_;
        public static final int UNK3300_LFEKGBBAMHE_FIELD_NUMBER = 15;
        private int unk3300LFEKGBBAMHE_;
        private byte memoizedIsInitialized;
        private static final RoguelikeSettleCoinInfo DEFAULT_INSTANCE = new RoguelikeSettleCoinInfo();
        private static final Parser<RoguelikeSettleCoinInfo> PARSER = new AbstractParser<RoguelikeSettleCoinInfo>() { // from class: emu.grasscutter.net.proto.RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo.1
            @Override // com.google.protobuf.Parser
            public RoguelikeSettleCoinInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RoguelikeSettleCoinInfo(input, extensionRegistry);
            }
        };

        private RoguelikeSettleCoinInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RoguelikeSettleCoinInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RoguelikeSettleCoinInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RoguelikeSettleCoinInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.coinC_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.unk3300MFKOIMONCLA_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.unk3300LFEKGBBAMHE_ = input.readUInt32();
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
            return RoguelikeSettleCoinInfoOuterClass.internal_static_RoguelikeSettleCoinInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RoguelikeSettleCoinInfoOuterClass.internal_static_RoguelikeSettleCoinInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RoguelikeSettleCoinInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfoOrBuilder
        public int getUnk3300MFKOIMONCLA() {
            return this.unk3300MFKOIMONCLA_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfoOrBuilder
        public int getCoinC() {
            return this.coinC_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfoOrBuilder
        public int getUnk3300LFEKGBBAMHE() {
            return this.unk3300LFEKGBBAMHE_;
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
            if (this.coinC_ != 0) {
                output.writeUInt32(7, this.coinC_);
            }
            if (this.unk3300MFKOIMONCLA_ != 0) {
                output.writeUInt32(12, this.unk3300MFKOIMONCLA_);
            }
            if (this.unk3300LFEKGBBAMHE_ != 0) {
                output.writeUInt32(15, this.unk3300LFEKGBBAMHE_);
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
            if (this.coinC_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.coinC_);
            }
            if (this.unk3300MFKOIMONCLA_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300MFKOIMONCLA_);
            }
            if (this.unk3300LFEKGBBAMHE_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.unk3300LFEKGBBAMHE_);
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
            if (!(obj instanceof RoguelikeSettleCoinInfo)) {
                return equals(obj);
            }
            RoguelikeSettleCoinInfo other = (RoguelikeSettleCoinInfo) obj;
            return getUnk3300MFKOIMONCLA() == other.getUnk3300MFKOIMONCLA() && getCoinC() == other.getCoinC() && getUnk3300LFEKGBBAMHE() == other.getUnk3300LFEKGBBAMHE() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getUnk3300MFKOIMONCLA())) + 7)) + getCoinC())) + 15)) + getUnk3300LFEKGBBAMHE())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static RoguelikeSettleCoinInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeSettleCoinInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeSettleCoinInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeSettleCoinInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeSettleCoinInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeSettleCoinInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeSettleCoinInfo parseFrom(InputStream input) throws IOException {
            return (RoguelikeSettleCoinInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeSettleCoinInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeSettleCoinInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeSettleCoinInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RoguelikeSettleCoinInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RoguelikeSettleCoinInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeSettleCoinInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeSettleCoinInfo parseFrom(CodedInputStream input) throws IOException {
            return (RoguelikeSettleCoinInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeSettleCoinInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeSettleCoinInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RoguelikeSettleCoinInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeSettleCoinInfoOuterClass$RoguelikeSettleCoinInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RoguelikeSettleCoinInfoOrBuilder {
            private int unk3300MFKOIMONCLA_;
            private int coinC_;
            private int unk3300LFEKGBBAMHE_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RoguelikeSettleCoinInfoOuterClass.internal_static_RoguelikeSettleCoinInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RoguelikeSettleCoinInfoOuterClass.internal_static_RoguelikeSettleCoinInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RoguelikeSettleCoinInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RoguelikeSettleCoinInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300MFKOIMONCLA_ = 0;
                this.coinC_ = 0;
                this.unk3300LFEKGBBAMHE_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RoguelikeSettleCoinInfoOuterClass.internal_static_RoguelikeSettleCoinInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RoguelikeSettleCoinInfo getDefaultInstanceForType() {
                return RoguelikeSettleCoinInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeSettleCoinInfo build() {
                RoguelikeSettleCoinInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeSettleCoinInfo buildPartial() {
                RoguelikeSettleCoinInfo result = new RoguelikeSettleCoinInfo(this);
                result.unk3300MFKOIMONCLA_ = this.unk3300MFKOIMONCLA_;
                result.coinC_ = this.coinC_;
                result.unk3300LFEKGBBAMHE_ = this.unk3300LFEKGBBAMHE_;
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
                if (other instanceof RoguelikeSettleCoinInfo) {
                    return mergeFrom((RoguelikeSettleCoinInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RoguelikeSettleCoinInfo other) {
                if (other == RoguelikeSettleCoinInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300MFKOIMONCLA() != 0) {
                    setUnk3300MFKOIMONCLA(other.getUnk3300MFKOIMONCLA());
                }
                if (other.getCoinC() != 0) {
                    setCoinC(other.getCoinC());
                }
                if (other.getUnk3300LFEKGBBAMHE() != 0) {
                    setUnk3300LFEKGBBAMHE(other.getUnk3300LFEKGBBAMHE());
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
                RoguelikeSettleCoinInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RoguelikeSettleCoinInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RoguelikeSettleCoinInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfoOrBuilder
            public int getUnk3300MFKOIMONCLA() {
                return this.unk3300MFKOIMONCLA_;
            }

            public Builder setUnk3300MFKOIMONCLA(int value) {
                this.unk3300MFKOIMONCLA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MFKOIMONCLA() {
                this.unk3300MFKOIMONCLA_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfoOrBuilder
            public int getCoinC() {
                return this.coinC_;
            }

            public Builder setCoinC(int value) {
                this.coinC_ = value;
                onChanged();
                return this;
            }

            public Builder clearCoinC() {
                this.coinC_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfoOrBuilder
            public int getUnk3300LFEKGBBAMHE() {
                return this.unk3300LFEKGBBAMHE_;
            }

            public Builder setUnk3300LFEKGBBAMHE(int value) {
                this.unk3300LFEKGBBAMHE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LFEKGBBAMHE() {
                this.unk3300LFEKGBBAMHE_ = 0;
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

        public static RoguelikeSettleCoinInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RoguelikeSettleCoinInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RoguelikeSettleCoinInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RoguelikeSettleCoinInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
