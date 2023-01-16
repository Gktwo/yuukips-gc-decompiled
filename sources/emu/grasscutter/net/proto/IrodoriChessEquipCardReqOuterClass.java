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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEquipCardReqOuterClass.class */
public final class IrodoriChessEquipCardReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eIrodoriChessEquipCardReq.proto\"R\n\u0018IrodoriChessEquipCardReq\u0012\u0013\n\u000bis_hard_map\u0018\b \u0001(\b\u0012\u0010\n\blevel_id\u0018\u0001 \u0001(\r\u0012\u000f\n\u0007card_id\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_IrodoriChessEquipCardReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriChessEquipCardReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriChessEquipCardReq_descriptor, new String[]{"IsHardMap", "LevelId", "CardId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEquipCardReqOuterClass$IrodoriChessEquipCardReqOrBuilder.class */
    public interface IrodoriChessEquipCardReqOrBuilder extends MessageOrBuilder {
        boolean getIsHardMap();

        int getLevelId();

        int getCardId();
    }

    private IrodoriChessEquipCardReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEquipCardReqOuterClass$IrodoriChessEquipCardReq.class */
    public static final class IrodoriChessEquipCardReq extends GeneratedMessageV3 implements IrodoriChessEquipCardReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_HARD_MAP_FIELD_NUMBER = 8;
        private boolean isHardMap_;
        public static final int LEVEL_ID_FIELD_NUMBER = 1;
        private int levelId_;
        public static final int CARD_ID_FIELD_NUMBER = 3;
        private int cardId_;
        private byte memoizedIsInitialized;
        private static final IrodoriChessEquipCardReq DEFAULT_INSTANCE = new IrodoriChessEquipCardReq();
        private static final Parser<IrodoriChessEquipCardReq> PARSER = new AbstractParser<IrodoriChessEquipCardReq>() { // from class: emu.grasscutter.net.proto.IrodoriChessEquipCardReqOuterClass.IrodoriChessEquipCardReq.1
            @Override // com.google.protobuf.Parser
            public IrodoriChessEquipCardReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriChessEquipCardReq(input, extensionRegistry);
            }
        };

        private IrodoriChessEquipCardReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriChessEquipCardReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriChessEquipCardReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriChessEquipCardReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.levelId_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.cardId_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.isHardMap_ = input.readBool();
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
            return IrodoriChessEquipCardReqOuterClass.internal_static_IrodoriChessEquipCardReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriChessEquipCardReqOuterClass.internal_static_IrodoriChessEquipCardReq_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessEquipCardReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardReqOuterClass.IrodoriChessEquipCardReqOrBuilder
        public boolean getIsHardMap() {
            return this.isHardMap_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardReqOuterClass.IrodoriChessEquipCardReqOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardReqOuterClass.IrodoriChessEquipCardReqOrBuilder
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
            if (this.levelId_ != 0) {
                output.writeUInt32(1, this.levelId_);
            }
            if (this.cardId_ != 0) {
                output.writeUInt32(3, this.cardId_);
            }
            if (this.isHardMap_) {
                output.writeBool(8, this.isHardMap_);
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
            if (this.levelId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.levelId_);
            }
            if (this.cardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.cardId_);
            }
            if (this.isHardMap_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isHardMap_);
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
            if (!(obj instanceof IrodoriChessEquipCardReq)) {
                return equals(obj);
            }
            IrodoriChessEquipCardReq other = (IrodoriChessEquipCardReq) obj;
            return getIsHardMap() == other.getIsHardMap() && getLevelId() == other.getLevelId() && getCardId() == other.getCardId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashBoolean(getIsHardMap()))) + 1)) + getLevelId())) + 3)) + getCardId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static IrodoriChessEquipCardReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEquipCardReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEquipCardReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEquipCardReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEquipCardReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEquipCardReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEquipCardReq parseFrom(InputStream input) throws IOException {
            return (IrodoriChessEquipCardReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessEquipCardReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEquipCardReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessEquipCardReq parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriChessEquipCardReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriChessEquipCardReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEquipCardReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessEquipCardReq parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriChessEquipCardReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessEquipCardReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEquipCardReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriChessEquipCardReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEquipCardReqOuterClass$IrodoriChessEquipCardReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriChessEquipCardReqOrBuilder {
            private boolean isHardMap_;
            private int levelId_;
            private int cardId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriChessEquipCardReqOuterClass.internal_static_IrodoriChessEquipCardReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriChessEquipCardReqOuterClass.internal_static_IrodoriChessEquipCardReq_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessEquipCardReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriChessEquipCardReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isHardMap_ = false;
                this.levelId_ = 0;
                this.cardId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriChessEquipCardReqOuterClass.internal_static_IrodoriChessEquipCardReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriChessEquipCardReq getDefaultInstanceForType() {
                return IrodoriChessEquipCardReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessEquipCardReq build() {
                IrodoriChessEquipCardReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessEquipCardReq buildPartial() {
                IrodoriChessEquipCardReq result = new IrodoriChessEquipCardReq(this);
                result.isHardMap_ = this.isHardMap_;
                result.levelId_ = this.levelId_;
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
                if (other instanceof IrodoriChessEquipCardReq) {
                    return mergeFrom((IrodoriChessEquipCardReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriChessEquipCardReq other) {
                if (other == IrodoriChessEquipCardReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsHardMap()) {
                    setIsHardMap(other.getIsHardMap());
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
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
                IrodoriChessEquipCardReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriChessEquipCardReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriChessEquipCardReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardReqOuterClass.IrodoriChessEquipCardReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardReqOuterClass.IrodoriChessEquipCardReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.IrodoriChessEquipCardReqOuterClass.IrodoriChessEquipCardReqOrBuilder
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

        public static IrodoriChessEquipCardReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriChessEquipCardReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriChessEquipCardReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriChessEquipCardReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
