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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakePlayerLevelRewardRspOuterClass.class */
public final class TakePlayerLevelRewardRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eTakePlayerLevelRewardRsp.proto\"L\n\u0018TakePlayerLevelRewardRsp\u0012\r\n\u0005level\u0018\u0007 \u0001(\r\u0012\u0010\n\brewardId\u0018\u0004 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TakePlayerLevelRewardRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakePlayerLevelRewardRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakePlayerLevelRewardRsp_descriptor, new String[]{"Level", "RewardId", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakePlayerLevelRewardRspOuterClass$TakePlayerLevelRewardRspOrBuilder.class */
    public interface TakePlayerLevelRewardRspOrBuilder extends MessageOrBuilder {
        int getLevel();

        int getRewardId();

        int getRetcode();
    }

    private TakePlayerLevelRewardRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakePlayerLevelRewardRspOuterClass$TakePlayerLevelRewardRsp.class */
    public static final class TakePlayerLevelRewardRsp extends GeneratedMessageV3 implements TakePlayerLevelRewardRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVEL_FIELD_NUMBER = 7;
        private int level_;
        public static final int REWARDID_FIELD_NUMBER = 4;
        private int rewardId_;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final TakePlayerLevelRewardRsp DEFAULT_INSTANCE = new TakePlayerLevelRewardRsp();
        private static final Parser<TakePlayerLevelRewardRsp> PARSER = new AbstractParser<TakePlayerLevelRewardRsp>() { // from class: emu.grasscutter.net.proto.TakePlayerLevelRewardRspOuterClass.TakePlayerLevelRewardRsp.1
            @Override // com.google.protobuf.Parser
            public TakePlayerLevelRewardRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakePlayerLevelRewardRsp(input, extensionRegistry);
            }
        };

        private TakePlayerLevelRewardRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TakePlayerLevelRewardRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakePlayerLevelRewardRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TakePlayerLevelRewardRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.rewardId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 56:
                                    this.level_ = input.readUInt32();
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
            return TakePlayerLevelRewardRspOuterClass.internal_static_TakePlayerLevelRewardRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakePlayerLevelRewardRspOuterClass.internal_static_TakePlayerLevelRewardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TakePlayerLevelRewardRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakePlayerLevelRewardRspOuterClass.TakePlayerLevelRewardRspOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.TakePlayerLevelRewardRspOuterClass.TakePlayerLevelRewardRspOrBuilder
        public int getRewardId() {
            return this.rewardId_;
        }

        @Override // emu.grasscutter.net.proto.TakePlayerLevelRewardRspOuterClass.TakePlayerLevelRewardRspOrBuilder
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
            if (this.rewardId_ != 0) {
                output.writeUInt32(4, this.rewardId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(7, this.level_);
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
            if (this.rewardId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.rewardId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.level_);
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
            if (!(obj instanceof TakePlayerLevelRewardRsp)) {
                return equals(obj);
            }
            TakePlayerLevelRewardRsp other = (TakePlayerLevelRewardRsp) obj;
            return getLevel() == other.getLevel() && getRewardId() == other.getRewardId() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getLevel())) + 4)) + getRewardId())) + 5)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TakePlayerLevelRewardRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakePlayerLevelRewardRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakePlayerLevelRewardRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakePlayerLevelRewardRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakePlayerLevelRewardRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakePlayerLevelRewardRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakePlayerLevelRewardRsp parseFrom(InputStream input) throws IOException {
            return (TakePlayerLevelRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakePlayerLevelRewardRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakePlayerLevelRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakePlayerLevelRewardRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (TakePlayerLevelRewardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakePlayerLevelRewardRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakePlayerLevelRewardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakePlayerLevelRewardRsp parseFrom(CodedInputStream input) throws IOException {
            return (TakePlayerLevelRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakePlayerLevelRewardRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakePlayerLevelRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakePlayerLevelRewardRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakePlayerLevelRewardRspOuterClass$TakePlayerLevelRewardRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakePlayerLevelRewardRspOrBuilder {
            private int level_;
            private int rewardId_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TakePlayerLevelRewardRspOuterClass.internal_static_TakePlayerLevelRewardRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakePlayerLevelRewardRspOuterClass.internal_static_TakePlayerLevelRewardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TakePlayerLevelRewardRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakePlayerLevelRewardRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.level_ = 0;
                this.rewardId_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakePlayerLevelRewardRspOuterClass.internal_static_TakePlayerLevelRewardRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakePlayerLevelRewardRsp getDefaultInstanceForType() {
                return TakePlayerLevelRewardRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakePlayerLevelRewardRsp build() {
                TakePlayerLevelRewardRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakePlayerLevelRewardRsp buildPartial() {
                TakePlayerLevelRewardRsp result = new TakePlayerLevelRewardRsp(this);
                result.level_ = this.level_;
                result.rewardId_ = this.rewardId_;
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
                if (other instanceof TakePlayerLevelRewardRsp) {
                    return mergeFrom((TakePlayerLevelRewardRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakePlayerLevelRewardRsp other) {
                if (other == TakePlayerLevelRewardRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.getRewardId() != 0) {
                    setRewardId(other.getRewardId());
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
                TakePlayerLevelRewardRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakePlayerLevelRewardRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakePlayerLevelRewardRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TakePlayerLevelRewardRspOuterClass.TakePlayerLevelRewardRspOrBuilder
            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TakePlayerLevelRewardRspOuterClass.TakePlayerLevelRewardRspOrBuilder
            public int getRewardId() {
                return this.rewardId_;
            }

            public Builder setRewardId(int value) {
                this.rewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRewardId() {
                this.rewardId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TakePlayerLevelRewardRspOuterClass.TakePlayerLevelRewardRspOrBuilder
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

        public static TakePlayerLevelRewardRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakePlayerLevelRewardRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakePlayerLevelRewardRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakePlayerLevelRewardRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
