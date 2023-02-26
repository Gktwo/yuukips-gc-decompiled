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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingDungeonDetailOuterClass.class */
public final class FungusTrainingDungeonDetailOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!FungusTrainingDungeonDetail.proto\"S\n\u001bFungusTrainingDungeonDetail\u0012\u000e\n\u0006isOpen\u0018\b \u0001(\b\u0012\u0011\n\tbestScore\u0018\u0007 \u0001(\r\u0012\u0011\n\tdungeonId\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FungusTrainingDungeonDetail_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FungusTrainingDungeonDetail_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FungusTrainingDungeonDetail_descriptor, new String[]{"IsOpen", "BestScore", "DungeonId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingDungeonDetailOuterClass$FungusTrainingDungeonDetailOrBuilder.class */
    public interface FungusTrainingDungeonDetailOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        int getBestScore();

        int getDungeonId();
    }

    private FungusTrainingDungeonDetailOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingDungeonDetailOuterClass$FungusTrainingDungeonDetail.class */
    public static final class FungusTrainingDungeonDetail extends GeneratedMessageV3 implements FungusTrainingDungeonDetailOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISOPEN_FIELD_NUMBER = 8;
        private boolean isOpen_;
        public static final int BESTSCORE_FIELD_NUMBER = 7;
        private int bestScore_;
        public static final int DUNGEONID_FIELD_NUMBER = 6;
        private int dungeonId_;
        private byte memoizedIsInitialized;
        private static final FungusTrainingDungeonDetail DEFAULT_INSTANCE = new FungusTrainingDungeonDetail();
        private static final Parser<FungusTrainingDungeonDetail> PARSER = new AbstractParser<FungusTrainingDungeonDetail>() { // from class: emu.grasscutter.net.proto.FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.1
            @Override // com.google.protobuf.Parser
            public FungusTrainingDungeonDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FungusTrainingDungeonDetail(input, extensionRegistry);
            }
        };

        private FungusTrainingDungeonDetail(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FungusTrainingDungeonDetail() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FungusTrainingDungeonDetail();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FungusTrainingDungeonDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.dungeonId_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.bestScore_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.isOpen_ = input.readBool();
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
            return FungusTrainingDungeonDetailOuterClass.internal_static_FungusTrainingDungeonDetail_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FungusTrainingDungeonDetailOuterClass.internal_static_FungusTrainingDungeonDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(FungusTrainingDungeonDetail.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder
        public int getBestScore() {
            return this.bestScore_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder
        public int getDungeonId() {
            return this.dungeonId_;
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
            if (this.dungeonId_ != 0) {
                output.writeUInt32(6, this.dungeonId_);
            }
            if (this.bestScore_ != 0) {
                output.writeUInt32(7, this.bestScore_);
            }
            if (this.isOpen_) {
                output.writeBool(8, this.isOpen_);
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
            if (this.dungeonId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.dungeonId_);
            }
            if (this.bestScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.bestScore_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isOpen_);
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
            if (!(obj instanceof FungusTrainingDungeonDetail)) {
                return equals(obj);
            }
            FungusTrainingDungeonDetail other = (FungusTrainingDungeonDetail) obj;
            return getIsOpen() == other.getIsOpen() && getBestScore() == other.getBestScore() && getDungeonId() == other.getDungeonId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashBoolean(getIsOpen()))) + 7)) + getBestScore())) + 6)) + getDungeonId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FungusTrainingDungeonDetail parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingDungeonDetail parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingDungeonDetail parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingDungeonDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingDungeonDetail parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingDungeonDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingDungeonDetail parseFrom(InputStream input) throws IOException {
            return (FungusTrainingDungeonDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusTrainingDungeonDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingDungeonDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusTrainingDungeonDetail parseDelimitedFrom(InputStream input) throws IOException {
            return (FungusTrainingDungeonDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FungusTrainingDungeonDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingDungeonDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusTrainingDungeonDetail parseFrom(CodedInputStream input) throws IOException {
            return (FungusTrainingDungeonDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusTrainingDungeonDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingDungeonDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FungusTrainingDungeonDetail prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingDungeonDetailOuterClass$FungusTrainingDungeonDetail$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FungusTrainingDungeonDetailOrBuilder {
            private boolean isOpen_;
            private int bestScore_;
            private int dungeonId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FungusTrainingDungeonDetailOuterClass.internal_static_FungusTrainingDungeonDetail_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FungusTrainingDungeonDetailOuterClass.internal_static_FungusTrainingDungeonDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(FungusTrainingDungeonDetail.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FungusTrainingDungeonDetail.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                this.bestScore_ = 0;
                this.dungeonId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FungusTrainingDungeonDetailOuterClass.internal_static_FungusTrainingDungeonDetail_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FungusTrainingDungeonDetail getDefaultInstanceForType() {
                return FungusTrainingDungeonDetail.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusTrainingDungeonDetail build() {
                FungusTrainingDungeonDetail result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusTrainingDungeonDetail buildPartial() {
                FungusTrainingDungeonDetail result = new FungusTrainingDungeonDetail(this);
                result.isOpen_ = this.isOpen_;
                result.bestScore_ = this.bestScore_;
                result.dungeonId_ = this.dungeonId_;
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
                if (other instanceof FungusTrainingDungeonDetail) {
                    return mergeFrom((FungusTrainingDungeonDetail) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FungusTrainingDungeonDetail other) {
                if (other == FungusTrainingDungeonDetail.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getBestScore() != 0) {
                    setBestScore(other.getBestScore());
                }
                if (other.getDungeonId() != 0) {
                    setDungeonId(other.getDungeonId());
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
                FungusTrainingDungeonDetail parsedMessage = null;
                try {
                    try {
                        parsedMessage = FungusTrainingDungeonDetail.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FungusTrainingDungeonDetail) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder
            public int getBestScore() {
                return this.bestScore_;
            }

            public Builder setBestScore(int value) {
                this.bestScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearBestScore() {
                this.bestScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder
            public int getDungeonId() {
                return this.dungeonId_;
            }

            public Builder setDungeonId(int value) {
                this.dungeonId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonId() {
                this.dungeonId_ = 0;
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

        public static FungusTrainingDungeonDetail getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FungusTrainingDungeonDetail> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FungusTrainingDungeonDetail> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FungusTrainingDungeonDetail getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
