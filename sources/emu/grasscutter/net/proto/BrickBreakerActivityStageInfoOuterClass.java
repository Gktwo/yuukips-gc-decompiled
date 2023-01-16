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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerActivityStageInfoOuterClass.class */
public final class BrickBreakerActivityStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#BrickBreakerActivityStageInfo.proto\"k\n\u001dBrickBreakerActivityStageInfo\u0012\u0010\n\bstage_id\u0018\u0003 \u0001(\r\u0012\u001b\n\u0013Unk3300_ALOGIKNHEIM\u0018\u0002 \u0001(\b\u0012\u001b\n\u0013Unk3300_FFKIEDNGNGK\u0018\n \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BrickBreakerActivityStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BrickBreakerActivityStageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BrickBreakerActivityStageInfo_descriptor, new String[]{"StageId", "Unk3300ALOGIKNHEIM", "Unk3300FFKIEDNGNGK"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerActivityStageInfoOuterClass$BrickBreakerActivityStageInfoOrBuilder.class */
    public interface BrickBreakerActivityStageInfoOrBuilder extends MessageOrBuilder {
        int getStageId();

        boolean getUnk3300ALOGIKNHEIM();

        boolean getUnk3300FFKIEDNGNGK();
    }

    private BrickBreakerActivityStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerActivityStageInfoOuterClass$BrickBreakerActivityStageInfo.class */
    public static final class BrickBreakerActivityStageInfo extends GeneratedMessageV3 implements BrickBreakerActivityStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_ID_FIELD_NUMBER = 3;
        private int stageId_;
        public static final int UNK3300_ALOGIKNHEIM_FIELD_NUMBER = 2;
        private boolean unk3300ALOGIKNHEIM_;
        public static final int UNK3300_FFKIEDNGNGK_FIELD_NUMBER = 10;
        private boolean unk3300FFKIEDNGNGK_;
        private byte memoizedIsInitialized;
        private static final BrickBreakerActivityStageInfo DEFAULT_INSTANCE = new BrickBreakerActivityStageInfo();
        private static final Parser<BrickBreakerActivityStageInfo> PARSER = new AbstractParser<BrickBreakerActivityStageInfo>() { // from class: emu.grasscutter.net.proto.BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.1
            @Override // com.google.protobuf.Parser
            public BrickBreakerActivityStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BrickBreakerActivityStageInfo(input, extensionRegistry);
            }
        };

        private BrickBreakerActivityStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BrickBreakerActivityStageInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BrickBreakerActivityStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BrickBreakerActivityStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.unk3300ALOGIKNHEIM_ = input.readBool();
                                    break;
                                case 24:
                                    this.stageId_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.unk3300FFKIEDNGNGK_ = input.readBool();
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
            return BrickBreakerActivityStageInfoOuterClass.internal_static_BrickBreakerActivityStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BrickBreakerActivityStageInfoOuterClass.internal_static_BrickBreakerActivityStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BrickBreakerActivityStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder
        public boolean getUnk3300ALOGIKNHEIM() {
            return this.unk3300ALOGIKNHEIM_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder
        public boolean getUnk3300FFKIEDNGNGK() {
            return this.unk3300FFKIEDNGNGK_;
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
            if (this.unk3300ALOGIKNHEIM_) {
                output.writeBool(2, this.unk3300ALOGIKNHEIM_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(3, this.stageId_);
            }
            if (this.unk3300FFKIEDNGNGK_) {
                output.writeBool(10, this.unk3300FFKIEDNGNGK_);
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
            if (this.unk3300ALOGIKNHEIM_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.unk3300ALOGIKNHEIM_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.stageId_);
            }
            if (this.unk3300FFKIEDNGNGK_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.unk3300FFKIEDNGNGK_);
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
            if (!(obj instanceof BrickBreakerActivityStageInfo)) {
                return equals(obj);
            }
            BrickBreakerActivityStageInfo other = (BrickBreakerActivityStageInfo) obj;
            return getStageId() == other.getStageId() && getUnk3300ALOGIKNHEIM() == other.getUnk3300ALOGIKNHEIM() && getUnk3300FFKIEDNGNGK() == other.getUnk3300FFKIEDNGNGK() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getStageId())) + 2)) + Internal.hashBoolean(getUnk3300ALOGIKNHEIM()))) + 10)) + Internal.hashBoolean(getUnk3300FFKIEDNGNGK()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BrickBreakerActivityStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BrickBreakerActivityStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BrickBreakerActivityStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BrickBreakerActivityStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BrickBreakerActivityStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BrickBreakerActivityStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BrickBreakerActivityStageInfo parseFrom(InputStream input) throws IOException {
            return (BrickBreakerActivityStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BrickBreakerActivityStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BrickBreakerActivityStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BrickBreakerActivityStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BrickBreakerActivityStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BrickBreakerActivityStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BrickBreakerActivityStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BrickBreakerActivityStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (BrickBreakerActivityStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BrickBreakerActivityStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BrickBreakerActivityStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BrickBreakerActivityStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerActivityStageInfoOuterClass$BrickBreakerActivityStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BrickBreakerActivityStageInfoOrBuilder {
            private int stageId_;
            private boolean unk3300ALOGIKNHEIM_;
            private boolean unk3300FFKIEDNGNGK_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BrickBreakerActivityStageInfoOuterClass.internal_static_BrickBreakerActivityStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BrickBreakerActivityStageInfoOuterClass.internal_static_BrickBreakerActivityStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BrickBreakerActivityStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BrickBreakerActivityStageInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.stageId_ = 0;
                this.unk3300ALOGIKNHEIM_ = false;
                this.unk3300FFKIEDNGNGK_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BrickBreakerActivityStageInfoOuterClass.internal_static_BrickBreakerActivityStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BrickBreakerActivityStageInfo getDefaultInstanceForType() {
                return BrickBreakerActivityStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BrickBreakerActivityStageInfo build() {
                BrickBreakerActivityStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BrickBreakerActivityStageInfo buildPartial() {
                BrickBreakerActivityStageInfo result = new BrickBreakerActivityStageInfo(this);
                result.stageId_ = this.stageId_;
                result.unk3300ALOGIKNHEIM_ = this.unk3300ALOGIKNHEIM_;
                result.unk3300FFKIEDNGNGK_ = this.unk3300FFKIEDNGNGK_;
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
                if (other instanceof BrickBreakerActivityStageInfo) {
                    return mergeFrom((BrickBreakerActivityStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BrickBreakerActivityStageInfo other) {
                if (other == BrickBreakerActivityStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getUnk3300ALOGIKNHEIM()) {
                    setUnk3300ALOGIKNHEIM(other.getUnk3300ALOGIKNHEIM());
                }
                if (other.getUnk3300FFKIEDNGNGK()) {
                    setUnk3300FFKIEDNGNGK(other.getUnk3300FFKIEDNGNGK());
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
                BrickBreakerActivityStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BrickBreakerActivityStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BrickBreakerActivityStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder
            public int getStageId() {
                return this.stageId_;
            }

            public Builder setStageId(int value) {
                this.stageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearStageId() {
                this.stageId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder
            public boolean getUnk3300ALOGIKNHEIM() {
                return this.unk3300ALOGIKNHEIM_;
            }

            public Builder setUnk3300ALOGIKNHEIM(boolean value) {
                this.unk3300ALOGIKNHEIM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ALOGIKNHEIM() {
                this.unk3300ALOGIKNHEIM_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder
            public boolean getUnk3300FFKIEDNGNGK() {
                return this.unk3300FFKIEDNGNGK_;
            }

            public Builder setUnk3300FFKIEDNGNGK(boolean value) {
                this.unk3300FFKIEDNGNGK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FFKIEDNGNGK() {
                this.unk3300FFKIEDNGNGK_ = false;
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

        public static BrickBreakerActivityStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BrickBreakerActivityStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BrickBreakerActivityStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BrickBreakerActivityStageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
