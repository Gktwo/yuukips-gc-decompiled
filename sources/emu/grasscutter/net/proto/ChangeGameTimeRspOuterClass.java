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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeGameTimeRspOuterClass.class */
public final class ChangeGameTimeRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017ChangeGameTimeRsp.proto\"O\n\u0011ChangeGameTimeRsp\u0012\u000f\n\u0007retcode\u0018\n \u0001(\u0005\u0012\u0012\n\nextra_days\u0018\u0002 \u0001(\r\u0012\u0015\n\rcur_game_time\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChangeGameTimeRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChangeGameTimeRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChangeGameTimeRsp_descriptor, new String[]{"Retcode", "ExtraDays", "CurGameTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeGameTimeRspOuterClass$ChangeGameTimeRspOrBuilder.class */
    public interface ChangeGameTimeRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getExtraDays();

        int getCurGameTime();
    }

    private ChangeGameTimeRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeGameTimeRspOuterClass$ChangeGameTimeRsp.class */
    public static final class ChangeGameTimeRsp extends GeneratedMessageV3 implements ChangeGameTimeRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 10;
        private int retcode_;
        public static final int EXTRA_DAYS_FIELD_NUMBER = 2;
        private int extraDays_;
        public static final int CUR_GAME_TIME_FIELD_NUMBER = 8;
        private int curGameTime_;
        private byte memoizedIsInitialized;
        private static final ChangeGameTimeRsp DEFAULT_INSTANCE = new ChangeGameTimeRsp();
        private static final Parser<ChangeGameTimeRsp> PARSER = new AbstractParser<ChangeGameTimeRsp>() { // from class: emu.grasscutter.net.proto.ChangeGameTimeRspOuterClass.ChangeGameTimeRsp.1
            @Override // com.google.protobuf.Parser
            public ChangeGameTimeRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChangeGameTimeRsp(input, extensionRegistry);
            }
        };

        private ChangeGameTimeRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChangeGameTimeRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChangeGameTimeRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeGameTimeRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.extraDays_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.curGameTime_ = input.readUInt32();
                                    break;
                                case 80:
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
            return ChangeGameTimeRspOuterClass.internal_static_ChangeGameTimeRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChangeGameTimeRspOuterClass.internal_static_ChangeGameTimeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeGameTimeRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChangeGameTimeRspOuterClass.ChangeGameTimeRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.ChangeGameTimeRspOuterClass.ChangeGameTimeRspOrBuilder
        public int getExtraDays() {
            return this.extraDays_;
        }

        @Override // emu.grasscutter.net.proto.ChangeGameTimeRspOuterClass.ChangeGameTimeRspOrBuilder
        public int getCurGameTime() {
            return this.curGameTime_;
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
            if (this.extraDays_ != 0) {
                output.writeUInt32(2, this.extraDays_);
            }
            if (this.curGameTime_ != 0) {
                output.writeUInt32(8, this.curGameTime_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(10, this.retcode_);
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
            if (this.extraDays_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.extraDays_);
            }
            if (this.curGameTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.curGameTime_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.retcode_);
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
            if (!(obj instanceof ChangeGameTimeRsp)) {
                return equals(obj);
            }
            ChangeGameTimeRsp other = (ChangeGameTimeRsp) obj;
            return getRetcode() == other.getRetcode() && getExtraDays() == other.getExtraDays() && getCurGameTime() == other.getCurGameTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getRetcode())) + 2)) + getExtraDays())) + 8)) + getCurGameTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ChangeGameTimeRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeGameTimeRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeGameTimeRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeGameTimeRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeGameTimeRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeGameTimeRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeGameTimeRsp parseFrom(InputStream input) throws IOException {
            return (ChangeGameTimeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeGameTimeRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeGameTimeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeGameTimeRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeGameTimeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChangeGameTimeRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeGameTimeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeGameTimeRsp parseFrom(CodedInputStream input) throws IOException {
            return (ChangeGameTimeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeGameTimeRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeGameTimeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChangeGameTimeRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeGameTimeRspOuterClass$ChangeGameTimeRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChangeGameTimeRspOrBuilder {
            private int retcode_;
            private int extraDays_;
            private int curGameTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChangeGameTimeRspOuterClass.internal_static_ChangeGameTimeRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChangeGameTimeRspOuterClass.internal_static_ChangeGameTimeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeGameTimeRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChangeGameTimeRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.extraDays_ = 0;
                this.curGameTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChangeGameTimeRspOuterClass.internal_static_ChangeGameTimeRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChangeGameTimeRsp getDefaultInstanceForType() {
                return ChangeGameTimeRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeGameTimeRsp build() {
                ChangeGameTimeRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeGameTimeRsp buildPartial() {
                ChangeGameTimeRsp result = new ChangeGameTimeRsp(this);
                result.retcode_ = this.retcode_;
                result.extraDays_ = this.extraDays_;
                result.curGameTime_ = this.curGameTime_;
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
                if (other instanceof ChangeGameTimeRsp) {
                    return mergeFrom((ChangeGameTimeRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChangeGameTimeRsp other) {
                if (other == ChangeGameTimeRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getExtraDays() != 0) {
                    setExtraDays(other.getExtraDays());
                }
                if (other.getCurGameTime() != 0) {
                    setCurGameTime(other.getCurGameTime());
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
                ChangeGameTimeRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChangeGameTimeRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChangeGameTimeRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChangeGameTimeRspOuterClass.ChangeGameTimeRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChangeGameTimeRspOuterClass.ChangeGameTimeRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChangeGameTimeRspOuterClass.ChangeGameTimeRspOrBuilder
            public int getCurGameTime() {
                return this.curGameTime_;
            }

            public Builder setCurGameTime(int value) {
                this.curGameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurGameTime() {
                this.curGameTime_ = 0;
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

        public static ChangeGameTimeRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChangeGameTimeRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChangeGameTimeRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChangeGameTimeRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
