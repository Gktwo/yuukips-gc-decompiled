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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeGameTimeReqOuterClass.class */
public final class ChangeGameTimeReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017ChangeGameTimeReq.proto\"L\n\u0011ChangeGameTimeReq\u0012\u0011\n\textraDays\u0018\u0007 \u0001(\r\u0012\u0012\n\nisForceSet\u0018\u0006 \u0001(\b\u0012\u0010\n\bgameTime\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChangeGameTimeReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChangeGameTimeReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChangeGameTimeReq_descriptor, new String[]{"ExtraDays", "IsForceSet", "GameTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeGameTimeReqOuterClass$ChangeGameTimeReqOrBuilder.class */
    public interface ChangeGameTimeReqOrBuilder extends MessageOrBuilder {
        int getExtraDays();

        boolean getIsForceSet();

        int getGameTime();
    }

    private ChangeGameTimeReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeGameTimeReqOuterClass$ChangeGameTimeReq.class */
    public static final class ChangeGameTimeReq extends GeneratedMessageV3 implements ChangeGameTimeReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EXTRADAYS_FIELD_NUMBER = 7;
        private int extraDays_;
        public static final int ISFORCESET_FIELD_NUMBER = 6;
        private boolean isForceSet_;
        public static final int GAMETIME_FIELD_NUMBER = 9;
        private int gameTime_;
        private byte memoizedIsInitialized;
        private static final ChangeGameTimeReq DEFAULT_INSTANCE = new ChangeGameTimeReq();
        private static final Parser<ChangeGameTimeReq> PARSER = new AbstractParser<ChangeGameTimeReq>() { // from class: emu.grasscutter.net.proto.ChangeGameTimeReqOuterClass.ChangeGameTimeReq.1
            @Override // com.google.protobuf.Parser
            public ChangeGameTimeReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChangeGameTimeReq(input, extensionRegistry);
            }
        };

        private ChangeGameTimeReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChangeGameTimeReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChangeGameTimeReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeGameTimeReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.isForceSet_ = input.readBool();
                                    break;
                                case 56:
                                    this.extraDays_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.gameTime_ = input.readUInt32();
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
            return ChangeGameTimeReqOuterClass.internal_static_ChangeGameTimeReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChangeGameTimeReqOuterClass.internal_static_ChangeGameTimeReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeGameTimeReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChangeGameTimeReqOuterClass.ChangeGameTimeReqOrBuilder
        public int getExtraDays() {
            return this.extraDays_;
        }

        @Override // emu.grasscutter.net.proto.ChangeGameTimeReqOuterClass.ChangeGameTimeReqOrBuilder
        public boolean getIsForceSet() {
            return this.isForceSet_;
        }

        @Override // emu.grasscutter.net.proto.ChangeGameTimeReqOuterClass.ChangeGameTimeReqOrBuilder
        public int getGameTime() {
            return this.gameTime_;
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
            if (this.isForceSet_) {
                output.writeBool(6, this.isForceSet_);
            }
            if (this.extraDays_ != 0) {
                output.writeUInt32(7, this.extraDays_);
            }
            if (this.gameTime_ != 0) {
                output.writeUInt32(9, this.gameTime_);
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
            if (this.isForceSet_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(6, this.isForceSet_);
            }
            if (this.extraDays_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.extraDays_);
            }
            if (this.gameTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.gameTime_);
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
            if (!(obj instanceof ChangeGameTimeReq)) {
                return equals(obj);
            }
            ChangeGameTimeReq other = (ChangeGameTimeReq) obj;
            return getExtraDays() == other.getExtraDays() && getIsForceSet() == other.getIsForceSet() && getGameTime() == other.getGameTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getExtraDays())) + 6)) + Internal.hashBoolean(getIsForceSet()))) + 9)) + getGameTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ChangeGameTimeReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeGameTimeReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeGameTimeReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeGameTimeReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeGameTimeReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeGameTimeReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeGameTimeReq parseFrom(InputStream input) throws IOException {
            return (ChangeGameTimeReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeGameTimeReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeGameTimeReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeGameTimeReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeGameTimeReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChangeGameTimeReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeGameTimeReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeGameTimeReq parseFrom(CodedInputStream input) throws IOException {
            return (ChangeGameTimeReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeGameTimeReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeGameTimeReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChangeGameTimeReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeGameTimeReqOuterClass$ChangeGameTimeReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChangeGameTimeReqOrBuilder {
            private int extraDays_;
            private boolean isForceSet_;
            private int gameTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChangeGameTimeReqOuterClass.internal_static_ChangeGameTimeReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChangeGameTimeReqOuterClass.internal_static_ChangeGameTimeReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeGameTimeReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChangeGameTimeReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.extraDays_ = 0;
                this.isForceSet_ = false;
                this.gameTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChangeGameTimeReqOuterClass.internal_static_ChangeGameTimeReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChangeGameTimeReq getDefaultInstanceForType() {
                return ChangeGameTimeReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeGameTimeReq build() {
                ChangeGameTimeReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeGameTimeReq buildPartial() {
                ChangeGameTimeReq result = new ChangeGameTimeReq(this);
                result.extraDays_ = this.extraDays_;
                result.isForceSet_ = this.isForceSet_;
                result.gameTime_ = this.gameTime_;
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
                if (other instanceof ChangeGameTimeReq) {
                    return mergeFrom((ChangeGameTimeReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChangeGameTimeReq other) {
                if (other == ChangeGameTimeReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getExtraDays() != 0) {
                    setExtraDays(other.getExtraDays());
                }
                if (other.getIsForceSet()) {
                    setIsForceSet(other.getIsForceSet());
                }
                if (other.getGameTime() != 0) {
                    setGameTime(other.getGameTime());
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
                ChangeGameTimeReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChangeGameTimeReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChangeGameTimeReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChangeGameTimeReqOuterClass.ChangeGameTimeReqOrBuilder
            public int getExtraDays() {
                return this.extraDays_;
            }

            public Builder setExtraDays(int value) {
                this.extraDays_ = value;
                onChanged();
                return this;
            }

            public Builder clearExtraDays() {
                this.extraDays_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChangeGameTimeReqOuterClass.ChangeGameTimeReqOrBuilder
            public boolean getIsForceSet() {
                return this.isForceSet_;
            }

            public Builder setIsForceSet(boolean value) {
                this.isForceSet_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsForceSet() {
                this.isForceSet_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChangeGameTimeReqOuterClass.ChangeGameTimeReqOrBuilder
            public int getGameTime() {
                return this.gameTime_;
            }

            public Builder setGameTime(int value) {
                this.gameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearGameTime() {
                this.gameTime_ = 0;
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

        public static ChangeGameTimeReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChangeGameTimeReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChangeGameTimeReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChangeGameTimeReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
