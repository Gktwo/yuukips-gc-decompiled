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
import emu.grasscutter.net.proto.CompoundQueueDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialRspOuterClass.class */
public final class PlayerCompoundMaterialRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fPlayerCompoundMaterialRsp.proto\u001a\u0017CompoundQueueData.proto\"[\n\u0019PlayerCompoundMaterialRsp\u0012-\n\u0011compoundQueueData\u0018\b \u0001(\u000b2\u0012.CompoundQueueData\u0012\u000f\n\u0007retcode\u0018\u000f \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CompoundQueueDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerCompoundMaterialRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerCompoundMaterialRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerCompoundMaterialRsp_descriptor, new String[]{"CompoundQueueData", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialRspOuterClass$PlayerCompoundMaterialRspOrBuilder.class */
    public interface PlayerCompoundMaterialRspOrBuilder extends MessageOrBuilder {
        boolean hasCompoundQueueData();

        CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueData();

        CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataOrBuilder();

        int getRetcode();
    }

    private PlayerCompoundMaterialRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialRspOuterClass$PlayerCompoundMaterialRsp.class */
    public static final class PlayerCompoundMaterialRsp extends GeneratedMessageV3 implements PlayerCompoundMaterialRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMPOUNDQUEUEDATA_FIELD_NUMBER = 8;
        private CompoundQueueDataOuterClass.CompoundQueueData compoundQueueData_;
        public static final int RETCODE_FIELD_NUMBER = 15;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final PlayerCompoundMaterialRsp DEFAULT_INSTANCE = new PlayerCompoundMaterialRsp();
        private static final Parser<PlayerCompoundMaterialRsp> PARSER = new AbstractParser<PlayerCompoundMaterialRsp>() { // from class: emu.grasscutter.net.proto.PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRsp.1
            @Override // com.google.protobuf.Parser
            public PlayerCompoundMaterialRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerCompoundMaterialRsp(input, extensionRegistry);
            }
        };

        private PlayerCompoundMaterialRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerCompoundMaterialRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerCompoundMaterialRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerCompoundMaterialRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 66:
                                    CompoundQueueDataOuterClass.CompoundQueueData.Builder subBuilder = this.compoundQueueData_ != null ? this.compoundQueueData_.toBuilder() : null;
                                    this.compoundQueueData_ = (CompoundQueueDataOuterClass.CompoundQueueData) input.readMessage(CompoundQueueDataOuterClass.CompoundQueueData.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.compoundQueueData_);
                                        this.compoundQueueData_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 120:
                                    this.retcode_ = input.readInt32();
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
            return PlayerCompoundMaterialRspOuterClass.internal_static_PlayerCompoundMaterialRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerCompoundMaterialRspOuterClass.internal_static_PlayerCompoundMaterialRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerCompoundMaterialRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRspOrBuilder
        public boolean hasCompoundQueueData() {
            return this.compoundQueueData_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRspOrBuilder
        public CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueData() {
            return this.compoundQueueData_ == null ? CompoundQueueDataOuterClass.CompoundQueueData.getDefaultInstance() : this.compoundQueueData_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRspOrBuilder
        public CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataOrBuilder() {
            return getCompoundQueueData();
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.compoundQueueData_ != null) {
                output.writeMessage(8, getCompoundQueueData());
            }
            if (this.retcode_ != 0) {
                output.writeInt32(15, this.retcode_);
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
            if (this.compoundQueueData_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(8, getCompoundQueueData());
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(15, this.retcode_);
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
            if (!(obj instanceof PlayerCompoundMaterialRsp)) {
                return equals(obj);
            }
            PlayerCompoundMaterialRsp other = (PlayerCompoundMaterialRsp) obj;
            if (hasCompoundQueueData() != other.hasCompoundQueueData()) {
                return false;
            }
            return (!hasCompoundQueueData() || getCompoundQueueData().equals(other.getCompoundQueueData())) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasCompoundQueueData()) {
                hash = (53 * ((37 * hash) + 8)) + getCompoundQueueData().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerCompoundMaterialRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialRsp parseFrom(InputStream input) throws IOException {
            return (PlayerCompoundMaterialRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCompoundMaterialRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerCompoundMaterialRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCompoundMaterialRsp parseFrom(CodedInputStream input) throws IOException {
            return (PlayerCompoundMaterialRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerCompoundMaterialRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialRspOuterClass$PlayerCompoundMaterialRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerCompoundMaterialRspOrBuilder {
            private CompoundQueueDataOuterClass.CompoundQueueData compoundQueueData_;
            private SingleFieldBuilderV3<CompoundQueueDataOuterClass.CompoundQueueData, CompoundQueueDataOuterClass.CompoundQueueData.Builder, CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> compoundQueueDataBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerCompoundMaterialRspOuterClass.internal_static_PlayerCompoundMaterialRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerCompoundMaterialRspOuterClass.internal_static_PlayerCompoundMaterialRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerCompoundMaterialRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerCompoundMaterialRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.compoundQueueDataBuilder_ == null) {
                    this.compoundQueueData_ = null;
                } else {
                    this.compoundQueueData_ = null;
                    this.compoundQueueDataBuilder_ = null;
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerCompoundMaterialRspOuterClass.internal_static_PlayerCompoundMaterialRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerCompoundMaterialRsp getDefaultInstanceForType() {
                return PlayerCompoundMaterialRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCompoundMaterialRsp build() {
                PlayerCompoundMaterialRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCompoundMaterialRsp buildPartial() {
                PlayerCompoundMaterialRsp result = new PlayerCompoundMaterialRsp(this);
                if (this.compoundQueueDataBuilder_ == null) {
                    result.compoundQueueData_ = this.compoundQueueData_;
                } else {
                    result.compoundQueueData_ = this.compoundQueueDataBuilder_.build();
                }
                result.retcode_ = this.retcode_;
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
                if (other instanceof PlayerCompoundMaterialRsp) {
                    return mergeFrom((PlayerCompoundMaterialRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerCompoundMaterialRsp other) {
                if (other == PlayerCompoundMaterialRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.hasCompoundQueueData()) {
                    mergeCompoundQueueData(other.getCompoundQueueData());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                PlayerCompoundMaterialRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerCompoundMaterialRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerCompoundMaterialRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRspOrBuilder
            public boolean hasCompoundQueueData() {
                return (this.compoundQueueDataBuilder_ == null && this.compoundQueueData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRspOrBuilder
            public CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueData() {
                if (this.compoundQueueDataBuilder_ == null) {
                    return this.compoundQueueData_ == null ? CompoundQueueDataOuterClass.CompoundQueueData.getDefaultInstance() : this.compoundQueueData_;
                }
                return this.compoundQueueDataBuilder_.getMessage();
            }

            public Builder setCompoundQueueData(CompoundQueueDataOuterClass.CompoundQueueData value) {
                if (this.compoundQueueDataBuilder_ != null) {
                    this.compoundQueueDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.compoundQueueData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCompoundQueueData(CompoundQueueDataOuterClass.CompoundQueueData.Builder builderForValue) {
                if (this.compoundQueueDataBuilder_ == null) {
                    this.compoundQueueData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.compoundQueueDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCompoundQueueData(CompoundQueueDataOuterClass.CompoundQueueData value) {
                if (this.compoundQueueDataBuilder_ == null) {
                    if (this.compoundQueueData_ != null) {
                        this.compoundQueueData_ = CompoundQueueDataOuterClass.CompoundQueueData.newBuilder(this.compoundQueueData_).mergeFrom(value).buildPartial();
                    } else {
                        this.compoundQueueData_ = value;
                    }
                    onChanged();
                } else {
                    this.compoundQueueDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCompoundQueueData() {
                if (this.compoundQueueDataBuilder_ == null) {
                    this.compoundQueueData_ = null;
                    onChanged();
                } else {
                    this.compoundQueueData_ = null;
                    this.compoundQueueDataBuilder_ = null;
                }
                return this;
            }

            public CompoundQueueDataOuterClass.CompoundQueueData.Builder getCompoundQueueDataBuilder() {
                onChanged();
                return getCompoundQueueDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRspOrBuilder
            public CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataOrBuilder() {
                if (this.compoundQueueDataBuilder_ != null) {
                    return this.compoundQueueDataBuilder_.getMessageOrBuilder();
                }
                return this.compoundQueueData_ == null ? CompoundQueueDataOuterClass.CompoundQueueData.getDefaultInstance() : this.compoundQueueData_;
            }

            private SingleFieldBuilderV3<CompoundQueueDataOuterClass.CompoundQueueData, CompoundQueueDataOuterClass.CompoundQueueData.Builder, CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataFieldBuilder() {
                if (this.compoundQueueDataBuilder_ == null) {
                    this.compoundQueueDataBuilder_ = new SingleFieldBuilderV3<>(getCompoundQueueData(), getParentForChildren(), isClean());
                    this.compoundQueueData_ = null;
                }
                return this.compoundQueueDataBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static PlayerCompoundMaterialRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerCompoundMaterialRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerCompoundMaterialRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerCompoundMaterialRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CompoundQueueDataOuterClass.getDescriptor();
    }
}
