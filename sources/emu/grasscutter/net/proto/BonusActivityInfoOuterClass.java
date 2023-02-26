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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BonusActivityInfoOuterClass.class */
public final class BonusActivityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017BonusActivityInfo.proto\";\n\u0011BonusActivityInfo\u0012\u0017\n\u000fbonusActivityId\u0018\u0005 \u0001(\r\u0012\r\n\u0005state\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BonusActivityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BonusActivityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BonusActivityInfo_descriptor, new String[]{"BonusActivityId", "State"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BonusActivityInfoOuterClass$BonusActivityInfoOrBuilder.class */
    public interface BonusActivityInfoOrBuilder extends MessageOrBuilder {
        int getBonusActivityId();

        int getState();
    }

    private BonusActivityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BonusActivityInfoOuterClass$BonusActivityInfo.class */
    public static final class BonusActivityInfo extends GeneratedMessageV3 implements BonusActivityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BONUSACTIVITYID_FIELD_NUMBER = 5;
        private int bonusActivityId_;
        public static final int STATE_FIELD_NUMBER = 4;
        private int state_;
        private byte memoizedIsInitialized;
        private static final BonusActivityInfo DEFAULT_INSTANCE = new BonusActivityInfo();
        private static final Parser<BonusActivityInfo> PARSER = new AbstractParser<BonusActivityInfo>() { // from class: emu.grasscutter.net.proto.BonusActivityInfoOuterClass.BonusActivityInfo.1
            @Override // com.google.protobuf.Parser
            public BonusActivityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BonusActivityInfo(input, extensionRegistry);
            }
        };

        private BonusActivityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BonusActivityInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BonusActivityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BonusActivityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.state_ = input.readUInt32();
                                break;
                            case 40:
                                this.bonusActivityId_ = input.readUInt32();
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
            return BonusActivityInfoOuterClass.internal_static_BonusActivityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BonusActivityInfoOuterClass.internal_static_BonusActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BonusActivityInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder
        public int getBonusActivityId() {
            return this.bonusActivityId_;
        }

        @Override // emu.grasscutter.net.proto.BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder
        public int getState() {
            return this.state_;
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
            if (this.state_ != 0) {
                output.writeUInt32(4, this.state_);
            }
            if (this.bonusActivityId_ != 0) {
                output.writeUInt32(5, this.bonusActivityId_);
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
            if (this.state_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.state_);
            }
            if (this.bonusActivityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.bonusActivityId_);
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
            if (!(obj instanceof BonusActivityInfo)) {
                return equals(obj);
            }
            BonusActivityInfo other = (BonusActivityInfo) obj;
            return getBonusActivityId() == other.getBonusActivityId() && getState() == other.getState() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getBonusActivityId())) + 4)) + getState())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BonusActivityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BonusActivityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BonusActivityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BonusActivityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BonusActivityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BonusActivityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BonusActivityInfo parseFrom(InputStream input) throws IOException {
            return (BonusActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BonusActivityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BonusActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BonusActivityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BonusActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BonusActivityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BonusActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BonusActivityInfo parseFrom(CodedInputStream input) throws IOException {
            return (BonusActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BonusActivityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BonusActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BonusActivityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BonusActivityInfoOuterClass$BonusActivityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BonusActivityInfoOrBuilder {
            private int bonusActivityId_;
            private int state_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BonusActivityInfoOuterClass.internal_static_BonusActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BonusActivityInfoOuterClass.internal_static_BonusActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BonusActivityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BonusActivityInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.bonusActivityId_ = 0;
                this.state_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BonusActivityInfoOuterClass.internal_static_BonusActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BonusActivityInfo getDefaultInstanceForType() {
                return BonusActivityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BonusActivityInfo build() {
                BonusActivityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BonusActivityInfo buildPartial() {
                BonusActivityInfo result = new BonusActivityInfo(this);
                result.bonusActivityId_ = this.bonusActivityId_;
                result.state_ = this.state_;
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
                if (other instanceof BonusActivityInfo) {
                    return mergeFrom((BonusActivityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BonusActivityInfo other) {
                if (other == BonusActivityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getBonusActivityId() != 0) {
                    setBonusActivityId(other.getBonusActivityId());
                }
                if (other.getState() != 0) {
                    setState(other.getState());
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
                BonusActivityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BonusActivityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BonusActivityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder
            public int getBonusActivityId() {
                return this.bonusActivityId_;
            }

            public Builder setBonusActivityId(int value) {
                this.bonusActivityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBonusActivityId() {
                this.bonusActivityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder
            public int getState() {
                return this.state_;
            }

            public Builder setState(int value) {
                this.state_ = value;
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.state_ = 0;
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

        public static BonusActivityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BonusActivityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BonusActivityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BonusActivityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
