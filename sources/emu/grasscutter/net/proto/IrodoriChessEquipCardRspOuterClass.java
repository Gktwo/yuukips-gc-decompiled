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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEquipCardRspOuterClass.class */
public final class IrodoriChessEquipCardRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eIrodoriChessEquipCardRsp.proto\"_\n\u0018IrodoriChessEquipCardRsp\u0012\u000f\n\u0007levelId\u0018\u000f \u0001(\r\u0012\u0011\n\tisHardMap\u0018\b \u0001(\b\u0012\u000f\n\u0007retcode\u0018\t \u0001(\u0005\u0012\u000e\n\u0006cardId\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_IrodoriChessEquipCardRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriChessEquipCardRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriChessEquipCardRsp_descriptor, new String[]{"LevelId", "IsHardMap", "Retcode", "CardId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEquipCardRspOuterClass$IrodoriChessEquipCardRspOrBuilder.class */
    public interface IrodoriChessEquipCardRspOrBuilder extends MessageOrBuilder {
        int getLevelId();

        boolean getIsHardMap();

        int getRetcode();

        int getCardId();
    }

    private IrodoriChessEquipCardRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEquipCardRspOuterClass$IrodoriChessEquipCardRsp.class */
    public static final class IrodoriChessEquipCardRsp extends GeneratedMessageV3 implements IrodoriChessEquipCardRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVELID_FIELD_NUMBER = 15;
        private int levelId_;
        public static final int ISHARDMAP_FIELD_NUMBER = 8;
        private boolean isHardMap_;
        public static final int RETCODE_FIELD_NUMBER = 9;
        private int retcode_;
        public static final int CARDID_FIELD_NUMBER = 14;
        private int cardId_;
        private byte memoizedIsInitialized;
        private static final IrodoriChessEquipCardRsp DEFAULT_INSTANCE = new IrodoriChessEquipCardRsp();
        private static final Parser<IrodoriChessEquipCardRsp> PARSER = new AbstractParser<IrodoriChessEquipCardRsp>() { // from class: emu.grasscutter.net.proto.IrodoriChessEquipCardRspOuterClass.IrodoriChessEquipCardRsp.1
            @Override // com.google.protobuf.Parser
            public IrodoriChessEquipCardRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriChessEquipCardRsp(input, extensionRegistry);
            }
        };

        private IrodoriChessEquipCardRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriChessEquipCardRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriChessEquipCardRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriChessEquipCardRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.isHardMap_ = input.readBool();
                                    break;
                                case 72:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 112:
                                    this.cardId_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.levelId_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriChessEquipCardRspOuterClass.internal_static_IrodoriChessEquipCardRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriChessEquipCardRspOuterClass.internal_static_IrodoriChessEquipCardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessEquipCardRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardRspOuterClass.IrodoriChessEquipCardRspOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardRspOuterClass.IrodoriChessEquipCardRspOrBuilder
        public boolean getIsHardMap() {
            return this.isHardMap_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardRspOuterClass.IrodoriChessEquipCardRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardRspOuterClass.IrodoriChessEquipCardRspOrBuilder
        public int getCardId() {
            return this.cardId_;
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
            if (this.isHardMap_) {
                output.writeBool(8, this.isHardMap_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(9, this.retcode_);
            }
            if (this.cardId_ != 0) {
                output.writeUInt32(14, this.cardId_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(15, this.levelId_);
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
            if (this.isHardMap_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(8, this.isHardMap_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.retcode_);
            }
            if (this.cardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.cardId_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.levelId_);
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
            if (!(obj instanceof IrodoriChessEquipCardRsp)) {
                return equals(obj);
            }
            IrodoriChessEquipCardRsp other = (IrodoriChessEquipCardRsp) obj;
            return getLevelId() == other.getLevelId() && getIsHardMap() == other.getIsHardMap() && getRetcode() == other.getRetcode() && getCardId() == other.getCardId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getLevelId())) + 8)) + Internal.hashBoolean(getIsHardMap()))) + 9)) + getRetcode())) + 14)) + getCardId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static IrodoriChessEquipCardRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEquipCardRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEquipCardRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEquipCardRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEquipCardRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEquipCardRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEquipCardRsp parseFrom(InputStream input) throws IOException {
            return (IrodoriChessEquipCardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessEquipCardRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEquipCardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessEquipCardRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriChessEquipCardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriChessEquipCardRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEquipCardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessEquipCardRsp parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriChessEquipCardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessEquipCardRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEquipCardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriChessEquipCardRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEquipCardRspOuterClass$IrodoriChessEquipCardRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriChessEquipCardRspOrBuilder {
            private int levelId_;
            private boolean isHardMap_;
            private int retcode_;
            private int cardId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriChessEquipCardRspOuterClass.internal_static_IrodoriChessEquipCardRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriChessEquipCardRspOuterClass.internal_static_IrodoriChessEquipCardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessEquipCardRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriChessEquipCardRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.levelId_ = 0;
                this.isHardMap_ = false;
                this.retcode_ = 0;
                this.cardId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriChessEquipCardRspOuterClass.internal_static_IrodoriChessEquipCardRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriChessEquipCardRsp getDefaultInstanceForType() {
                return IrodoriChessEquipCardRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessEquipCardRsp build() {
                IrodoriChessEquipCardRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessEquipCardRsp buildPartial() {
                IrodoriChessEquipCardRsp result = new IrodoriChessEquipCardRsp(this);
                result.levelId_ = this.levelId_;
                result.isHardMap_ = this.isHardMap_;
                result.retcode_ = this.retcode_;
                result.cardId_ = this.cardId_;
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
                if (other instanceof IrodoriChessEquipCardRsp) {
                    return mergeFrom((IrodoriChessEquipCardRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriChessEquipCardRsp other) {
                if (other == IrodoriChessEquipCardRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getIsHardMap()) {
                    setIsHardMap(other.getIsHardMap());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getCardId() != 0) {
                    setCardId(other.getCardId());
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
                IrodoriChessEquipCardRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriChessEquipCardRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriChessEquipCardRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardRspOuterClass.IrodoriChessEquipCardRspOrBuilder
            public int getLevelId() {
                return this.levelId_;
            }

            public Builder setLevelId(int value) {
                this.levelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelId() {
                this.levelId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardRspOuterClass.IrodoriChessEquipCardRspOrBuilder
            public boolean getIsHardMap() {
                return this.isHardMap_;
            }

            public Builder setIsHardMap(boolean value) {
                this.isHardMap_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsHardMap() {
                this.isHardMap_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardRspOuterClass.IrodoriChessEquipCardRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardRspOuterClass.IrodoriChessEquipCardRspOrBuilder
            public int getCardId() {
                return this.cardId_;
            }

            public Builder setCardId(int value) {
                this.cardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCardId() {
                this.cardId_ = 0;
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

        public static IrodoriChessEquipCardRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriChessEquipCardRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriChessEquipCardRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriChessEquipCardRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
