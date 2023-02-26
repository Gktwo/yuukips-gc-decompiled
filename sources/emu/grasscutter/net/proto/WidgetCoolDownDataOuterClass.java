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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCoolDownDataOuterClass.class */
public final class WidgetCoolDownDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018WidgetCoolDownData.proto\"I\n\u0012WidgetCoolDownData\u0012\n\n\u0002id\u0018\b \u0001(\r\u0012\u0014\n\fcoolDownTime\u0018\u000f \u0001(\u0004\u0012\u0011\n\tisSuccess\u0018\f \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_WidgetCoolDownData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WidgetCoolDownData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WidgetCoolDownData_descriptor, new String[]{"Id", "CoolDownTime", "IsSuccess"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCoolDownDataOuterClass$WidgetCoolDownDataOrBuilder.class */
    public interface WidgetCoolDownDataOrBuilder extends MessageOrBuilder {
        int getId();

        long getCoolDownTime();

        boolean getIsSuccess();
    }

    private WidgetCoolDownDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCoolDownDataOuterClass$WidgetCoolDownData.class */
    public static final class WidgetCoolDownData extends GeneratedMessageV3 implements WidgetCoolDownDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ID_FIELD_NUMBER = 8;
        private int id_;
        public static final int COOLDOWNTIME_FIELD_NUMBER = 15;
        private long coolDownTime_;
        public static final int ISSUCCESS_FIELD_NUMBER = 12;
        private boolean isSuccess_;
        private byte memoizedIsInitialized;
        private static final WidgetCoolDownData DEFAULT_INSTANCE = new WidgetCoolDownData();
        private static final Parser<WidgetCoolDownData> PARSER = new AbstractParser<WidgetCoolDownData>() { // from class: emu.grasscutter.net.proto.WidgetCoolDownDataOuterClass.WidgetCoolDownData.1
            @Override // com.google.protobuf.Parser
            public WidgetCoolDownData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WidgetCoolDownData(input, extensionRegistry);
            }
        };

        private WidgetCoolDownData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WidgetCoolDownData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WidgetCoolDownData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WidgetCoolDownData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.id_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.isSuccess_ = input.readBool();
                                    break;
                                case 120:
                                    this.coolDownTime_ = input.readUInt64();
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
            return WidgetCoolDownDataOuterClass.internal_static_WidgetCoolDownData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WidgetCoolDownDataOuterClass.internal_static_WidgetCoolDownData_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetCoolDownData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder
        public long getCoolDownTime() {
            return this.coolDownTime_;
        }

        @Override // emu.grasscutter.net.proto.WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder
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
            if (this.id_ != 0) {
                output.writeUInt32(8, this.id_);
            }
            if (this.isSuccess_) {
                output.writeBool(12, this.isSuccess_);
            }
            if (this.coolDownTime_ != 0) {
                output.writeUInt64(15, this.coolDownTime_);
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
            if (this.id_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.id_);
            }
            if (this.isSuccess_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isSuccess_);
            }
            if (this.coolDownTime_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(15, this.coolDownTime_);
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
            if (!(obj instanceof WidgetCoolDownData)) {
                return equals(obj);
            }
            WidgetCoolDownData other = (WidgetCoolDownData) obj;
            return getId() == other.getId() && getCoolDownTime() == other.getCoolDownTime() && getIsSuccess() == other.getIsSuccess() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getId())) + 15)) + Internal.hashLong(getCoolDownTime()))) + 12)) + Internal.hashBoolean(getIsSuccess()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static WidgetCoolDownData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetCoolDownData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetCoolDownData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetCoolDownData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetCoolDownData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetCoolDownData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetCoolDownData parseFrom(InputStream input) throws IOException {
            return (WidgetCoolDownData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetCoolDownData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetCoolDownData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetCoolDownData parseDelimitedFrom(InputStream input) throws IOException {
            return (WidgetCoolDownData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WidgetCoolDownData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetCoolDownData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetCoolDownData parseFrom(CodedInputStream input) throws IOException {
            return (WidgetCoolDownData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetCoolDownData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetCoolDownData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WidgetCoolDownData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCoolDownDataOuterClass$WidgetCoolDownData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WidgetCoolDownDataOrBuilder {
            private int id_;
            private long coolDownTime_;
            private boolean isSuccess_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WidgetCoolDownDataOuterClass.internal_static_WidgetCoolDownData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WidgetCoolDownDataOuterClass.internal_static_WidgetCoolDownData_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetCoolDownData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WidgetCoolDownData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.id_ = 0;
                this.coolDownTime_ = 0;
                this.isSuccess_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WidgetCoolDownDataOuterClass.internal_static_WidgetCoolDownData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WidgetCoolDownData getDefaultInstanceForType() {
                return WidgetCoolDownData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetCoolDownData build() {
                WidgetCoolDownData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetCoolDownData buildPartial() {
                WidgetCoolDownData result = new WidgetCoolDownData(this);
                result.id_ = this.id_;
                result.coolDownTime_ = this.coolDownTime_;
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
                if (other instanceof WidgetCoolDownData) {
                    return mergeFrom((WidgetCoolDownData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WidgetCoolDownData other) {
                if (other == WidgetCoolDownData.getDefaultInstance()) {
                    return this;
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (other.getCoolDownTime() != 0) {
                    setCoolDownTime(other.getCoolDownTime());
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
                WidgetCoolDownData parsedMessage = null;
                try {
                    try {
                        parsedMessage = WidgetCoolDownData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WidgetCoolDownData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder
            public long getCoolDownTime() {
                return this.coolDownTime_;
            }

            public Builder setCoolDownTime(long value) {
                this.coolDownTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearCoolDownTime() {
                this.coolDownTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder
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

        public static WidgetCoolDownData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WidgetCoolDownData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WidgetCoolDownData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WidgetCoolDownData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
