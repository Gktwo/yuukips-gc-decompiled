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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DungeonSettleInfoOuterClass.class */
public final class SummerTimeV2DungeonSettleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#SummerTimeV2DungeonSettleInfo.proto\"l\n\u001dSummerTimeV2DungeonSettleInfo\u0012\u001b\n\u0013Unk3300_JHBCHFHAGFO\u0018\f \u0001(\r\u0012\u001b\n\u0013Unk3300_BNNMNCKEHHO\u0018\t \u0001(\r\u0012\u0011\n\tisSuccess\u0018\n \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SummerTimeV2DungeonSettleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SummerTimeV2DungeonSettleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeV2DungeonSettleInfo_descriptor, new String[]{"Unk3300JHBCHFHAGFO", "Unk3300BNNMNCKEHHO", "IsSuccess"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DungeonSettleInfoOuterClass$SummerTimeV2DungeonSettleInfoOrBuilder.class */
    public interface SummerTimeV2DungeonSettleInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300JHBCHFHAGFO();

        int getUnk3300BNNMNCKEHHO();

        boolean getIsSuccess();
    }

    private SummerTimeV2DungeonSettleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DungeonSettleInfoOuterClass$SummerTimeV2DungeonSettleInfo.class */
    public static final class SummerTimeV2DungeonSettleInfo extends GeneratedMessageV3 implements SummerTimeV2DungeonSettleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_JHBCHFHAGFO_FIELD_NUMBER = 12;
        private int unk3300JHBCHFHAGFO_;
        public static final int UNK3300_BNNMNCKEHHO_FIELD_NUMBER = 9;
        private int unk3300BNNMNCKEHHO_;
        public static final int ISSUCCESS_FIELD_NUMBER = 10;
        private boolean isSuccess_;
        private byte memoizedIsInitialized;
        private static final SummerTimeV2DungeonSettleInfo DEFAULT_INSTANCE = new SummerTimeV2DungeonSettleInfo();
        private static final Parser<SummerTimeV2DungeonSettleInfo> PARSER = new AbstractParser<SummerTimeV2DungeonSettleInfo>() { // from class: emu.grasscutter.net.proto.SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfo.1
            @Override // com.google.protobuf.Parser
            public SummerTimeV2DungeonSettleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SummerTimeV2DungeonSettleInfo(input, extensionRegistry);
            }
        };

        private SummerTimeV2DungeonSettleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SummerTimeV2DungeonSettleInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SummerTimeV2DungeonSettleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SummerTimeV2DungeonSettleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 72:
                                    this.unk3300BNNMNCKEHHO_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.isSuccess_ = input.readBool();
                                    break;
                                case 96:
                                    this.unk3300JHBCHFHAGFO_ = input.readUInt32();
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
            return SummerTimeV2DungeonSettleInfoOuterClass.internal_static_SummerTimeV2DungeonSettleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SummerTimeV2DungeonSettleInfoOuterClass.internal_static_SummerTimeV2DungeonSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeV2DungeonSettleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder
        public int getUnk3300JHBCHFHAGFO() {
            return this.unk3300JHBCHFHAGFO_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder
        public int getUnk3300BNNMNCKEHHO() {
            return this.unk3300BNNMNCKEHHO_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
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
            if (this.unk3300BNNMNCKEHHO_ != 0) {
                output.writeUInt32(9, this.unk3300BNNMNCKEHHO_);
            }
            if (this.isSuccess_) {
                output.writeBool(10, this.isSuccess_);
            }
            if (this.unk3300JHBCHFHAGFO_ != 0) {
                output.writeUInt32(12, this.unk3300JHBCHFHAGFO_);
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
            if (this.unk3300BNNMNCKEHHO_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(9, this.unk3300BNNMNCKEHHO_);
            }
            if (this.isSuccess_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isSuccess_);
            }
            if (this.unk3300JHBCHFHAGFO_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300JHBCHFHAGFO_);
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
            if (!(obj instanceof SummerTimeV2DungeonSettleInfo)) {
                return equals(obj);
            }
            SummerTimeV2DungeonSettleInfo other = (SummerTimeV2DungeonSettleInfo) obj;
            return getUnk3300JHBCHFHAGFO() == other.getUnk3300JHBCHFHAGFO() && getUnk3300BNNMNCKEHHO() == other.getUnk3300BNNMNCKEHHO() && getIsSuccess() == other.getIsSuccess() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getUnk3300JHBCHFHAGFO())) + 9)) + getUnk3300BNNMNCKEHHO())) + 10)) + Internal.hashBoolean(getIsSuccess()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SummerTimeV2DungeonSettleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2DungeonSettleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2DungeonSettleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2DungeonSettleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2DungeonSettleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2DungeonSettleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2DungeonSettleInfo parseFrom(InputStream input) throws IOException {
            return (SummerTimeV2DungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeV2DungeonSettleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2DungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeV2DungeonSettleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SummerTimeV2DungeonSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SummerTimeV2DungeonSettleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2DungeonSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeV2DungeonSettleInfo parseFrom(CodedInputStream input) throws IOException {
            return (SummerTimeV2DungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeV2DungeonSettleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2DungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SummerTimeV2DungeonSettleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DungeonSettleInfoOuterClass$SummerTimeV2DungeonSettleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SummerTimeV2DungeonSettleInfoOrBuilder {
            private int unk3300JHBCHFHAGFO_;
            private int unk3300BNNMNCKEHHO_;
            private boolean isSuccess_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SummerTimeV2DungeonSettleInfoOuterClass.internal_static_SummerTimeV2DungeonSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SummerTimeV2DungeonSettleInfoOuterClass.internal_static_SummerTimeV2DungeonSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeV2DungeonSettleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SummerTimeV2DungeonSettleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300JHBCHFHAGFO_ = 0;
                this.unk3300BNNMNCKEHHO_ = 0;
                this.isSuccess_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SummerTimeV2DungeonSettleInfoOuterClass.internal_static_SummerTimeV2DungeonSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SummerTimeV2DungeonSettleInfo getDefaultInstanceForType() {
                return SummerTimeV2DungeonSettleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeV2DungeonSettleInfo build() {
                SummerTimeV2DungeonSettleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeV2DungeonSettleInfo buildPartial() {
                SummerTimeV2DungeonSettleInfo result = new SummerTimeV2DungeonSettleInfo(this);
                result.unk3300JHBCHFHAGFO_ = this.unk3300JHBCHFHAGFO_;
                result.unk3300BNNMNCKEHHO_ = this.unk3300BNNMNCKEHHO_;
                result.isSuccess_ = this.isSuccess_;
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
                if (other instanceof SummerTimeV2DungeonSettleInfo) {
                    return mergeFrom((SummerTimeV2DungeonSettleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SummerTimeV2DungeonSettleInfo other) {
                if (other == SummerTimeV2DungeonSettleInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300JHBCHFHAGFO() != 0) {
                    setUnk3300JHBCHFHAGFO(other.getUnk3300JHBCHFHAGFO());
                }
                if (other.getUnk3300BNNMNCKEHHO() != 0) {
                    setUnk3300BNNMNCKEHHO(other.getUnk3300BNNMNCKEHHO());
                }
                if (other.getIsSuccess()) {
                    setIsSuccess(other.getIsSuccess());
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
                SummerTimeV2DungeonSettleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SummerTimeV2DungeonSettleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SummerTimeV2DungeonSettleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder
            public int getUnk3300JHBCHFHAGFO() {
                return this.unk3300JHBCHFHAGFO_;
            }

            public Builder setUnk3300JHBCHFHAGFO(int value) {
                this.unk3300JHBCHFHAGFO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JHBCHFHAGFO() {
                this.unk3300JHBCHFHAGFO_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder
            public int getUnk3300BNNMNCKEHHO() {
                return this.unk3300BNNMNCKEHHO_;
            }

            public Builder setUnk3300BNNMNCKEHHO(int value) {
                this.unk3300BNNMNCKEHHO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BNNMNCKEHHO() {
                this.unk3300BNNMNCKEHHO_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonSettleInfoOuterClass.SummerTimeV2DungeonSettleInfoOrBuilder
            public boolean getIsSuccess() {
                return this.isSuccess_;
            }

            public Builder setIsSuccess(boolean value) {
                this.isSuccess_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSuccess() {
                this.isSuccess_ = false;
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

        public static SummerTimeV2DungeonSettleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SummerTimeV2DungeonSettleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SummerTimeV2DungeonSettleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SummerTimeV2DungeonSettleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
