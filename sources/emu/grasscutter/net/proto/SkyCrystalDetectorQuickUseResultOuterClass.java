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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SkyCrystalDetectorQuickUseResultOuterClass.class */
public final class SkyCrystalDetectorQuickUseResultOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&SkyCrystalDetectorQuickUseResult.proto\u001a\u001cSkyCrystalDetectorData.proto\"l\n SkyCrystalDetectorQuickUseResult\u00127\n\u0016skyCrystalDetectorData\u0018\u000e \u0001(\u000b2\u0017.SkyCrystalDetectorData\u0012\u000f\n\u0007retcode\u0018\u0007 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SkyCrystalDetectorDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SkyCrystalDetectorQuickUseResult_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_SkyCrystalDetectorQuickUseResult_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f854xe4e27beb = new GeneratedMessageV3.FieldAccessorTable(internal_static_SkyCrystalDetectorQuickUseResult_descriptor, new String[]{"SkyCrystalDetectorData", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SkyCrystalDetectorQuickUseResultOuterClass$SkyCrystalDetectorQuickUseResultOrBuilder.class */
    public interface SkyCrystalDetectorQuickUseResultOrBuilder extends MessageOrBuilder {
        boolean hasSkyCrystalDetectorData();

        SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData getSkyCrystalDetectorData();

        SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder getSkyCrystalDetectorDataOrBuilder();

        int getRetcode();
    }

    private SkyCrystalDetectorQuickUseResultOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SkyCrystalDetectorQuickUseResultOuterClass$SkyCrystalDetectorQuickUseResult.class */
    public static final class SkyCrystalDetectorQuickUseResult extends GeneratedMessageV3 implements SkyCrystalDetectorQuickUseResultOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SKYCRYSTALDETECTORDATA_FIELD_NUMBER = 14;
        private SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData skyCrystalDetectorData_;
        public static final int RETCODE_FIELD_NUMBER = 7;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final SkyCrystalDetectorQuickUseResult DEFAULT_INSTANCE = new SkyCrystalDetectorQuickUseResult();
        private static final Parser<SkyCrystalDetectorQuickUseResult> PARSER = new AbstractParser<SkyCrystalDetectorQuickUseResult>() { // from class: emu.grasscutter.net.proto.SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.1
            @Override // com.google.protobuf.Parser
            public SkyCrystalDetectorQuickUseResult parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SkyCrystalDetectorQuickUseResult(input, extensionRegistry);
            }
        };

        private SkyCrystalDetectorQuickUseResult(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SkyCrystalDetectorQuickUseResult() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SkyCrystalDetectorQuickUseResult();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SkyCrystalDetectorQuickUseResult(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 114:
                                    SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.Builder subBuilder = this.skyCrystalDetectorData_ != null ? this.skyCrystalDetectorData_.toBuilder() : null;
                                    this.skyCrystalDetectorData_ = (SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData) input.readMessage(SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.skyCrystalDetectorData_);
                                        this.skyCrystalDetectorData_ = subBuilder.buildPartial();
                                        break;
                                    }
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
            return SkyCrystalDetectorQuickUseResultOuterClass.internal_static_SkyCrystalDetectorQuickUseResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SkyCrystalDetectorQuickUseResultOuterClass.f854xe4e27beb.ensureFieldAccessorsInitialized(SkyCrystalDetectorQuickUseResult.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder
        public boolean hasSkyCrystalDetectorData() {
            return this.skyCrystalDetectorData_ != null;
        }

        @Override // emu.grasscutter.net.proto.SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder
        public SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData getSkyCrystalDetectorData() {
            return this.skyCrystalDetectorData_ == null ? SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.getDefaultInstance() : this.skyCrystalDetectorData_;
        }

        @Override // emu.grasscutter.net.proto.SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder
        public SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder getSkyCrystalDetectorDataOrBuilder() {
            return getSkyCrystalDetectorData();
        }

        @Override // emu.grasscutter.net.proto.SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder
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
            if (this.retcode_ != 0) {
                output.writeInt32(7, this.retcode_);
            }
            if (this.skyCrystalDetectorData_ != null) {
                output.writeMessage(14, getSkyCrystalDetectorData());
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(7, this.retcode_);
            }
            if (this.skyCrystalDetectorData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getSkyCrystalDetectorData());
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
            if (!(obj instanceof SkyCrystalDetectorQuickUseResult)) {
                return equals(obj);
            }
            SkyCrystalDetectorQuickUseResult other = (SkyCrystalDetectorQuickUseResult) obj;
            if (hasSkyCrystalDetectorData() != other.hasSkyCrystalDetectorData()) {
                return false;
            }
            return (!hasSkyCrystalDetectorData() || getSkyCrystalDetectorData().equals(other.getSkyCrystalDetectorData())) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasSkyCrystalDetectorData()) {
                hash = (53 * ((37 * hash) + 14)) + getSkyCrystalDetectorData().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 7)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SkyCrystalDetectorQuickUseResult parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SkyCrystalDetectorQuickUseResult parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SkyCrystalDetectorQuickUseResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SkyCrystalDetectorQuickUseResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SkyCrystalDetectorQuickUseResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SkyCrystalDetectorQuickUseResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SkyCrystalDetectorQuickUseResult parseFrom(InputStream input) throws IOException {
            return (SkyCrystalDetectorQuickUseResult) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SkyCrystalDetectorQuickUseResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkyCrystalDetectorQuickUseResult) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SkyCrystalDetectorQuickUseResult parseDelimitedFrom(InputStream input) throws IOException {
            return (SkyCrystalDetectorQuickUseResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SkyCrystalDetectorQuickUseResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkyCrystalDetectorQuickUseResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SkyCrystalDetectorQuickUseResult parseFrom(CodedInputStream input) throws IOException {
            return (SkyCrystalDetectorQuickUseResult) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SkyCrystalDetectorQuickUseResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkyCrystalDetectorQuickUseResult) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SkyCrystalDetectorQuickUseResult prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SkyCrystalDetectorQuickUseResultOuterClass$SkyCrystalDetectorQuickUseResult$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SkyCrystalDetectorQuickUseResultOrBuilder {
            private SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData skyCrystalDetectorData_;
            private SingleFieldBuilderV3<SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData, SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.Builder, SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder> skyCrystalDetectorDataBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SkyCrystalDetectorQuickUseResultOuterClass.internal_static_SkyCrystalDetectorQuickUseResult_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SkyCrystalDetectorQuickUseResultOuterClass.f854xe4e27beb.ensureFieldAccessorsInitialized(SkyCrystalDetectorQuickUseResult.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SkyCrystalDetectorQuickUseResult.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    this.skyCrystalDetectorData_ = null;
                } else {
                    this.skyCrystalDetectorData_ = null;
                    this.skyCrystalDetectorDataBuilder_ = null;
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SkyCrystalDetectorQuickUseResultOuterClass.internal_static_SkyCrystalDetectorQuickUseResult_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SkyCrystalDetectorQuickUseResult getDefaultInstanceForType() {
                return SkyCrystalDetectorQuickUseResult.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SkyCrystalDetectorQuickUseResult build() {
                SkyCrystalDetectorQuickUseResult result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SkyCrystalDetectorQuickUseResult buildPartial() {
                SkyCrystalDetectorQuickUseResult result = new SkyCrystalDetectorQuickUseResult(this);
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    result.skyCrystalDetectorData_ = this.skyCrystalDetectorData_;
                } else {
                    result.skyCrystalDetectorData_ = this.skyCrystalDetectorDataBuilder_.build();
                }
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
                if (other instanceof SkyCrystalDetectorQuickUseResult) {
                    return mergeFrom((SkyCrystalDetectorQuickUseResult) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SkyCrystalDetectorQuickUseResult other) {
                if (other == SkyCrystalDetectorQuickUseResult.getDefaultInstance()) {
                    return this;
                }
                if (other.hasSkyCrystalDetectorData()) {
                    mergeSkyCrystalDetectorData(other.getSkyCrystalDetectorData());
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
                SkyCrystalDetectorQuickUseResult parsedMessage = null;
                try {
                    try {
                        parsedMessage = SkyCrystalDetectorQuickUseResult.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SkyCrystalDetectorQuickUseResult) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder
            public boolean hasSkyCrystalDetectorData() {
                return (this.skyCrystalDetectorDataBuilder_ == null && this.skyCrystalDetectorData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder
            public SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData getSkyCrystalDetectorData() {
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    return this.skyCrystalDetectorData_ == null ? SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.getDefaultInstance() : this.skyCrystalDetectorData_;
                }
                return this.skyCrystalDetectorDataBuilder_.getMessage();
            }

            public Builder setSkyCrystalDetectorData(SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData value) {
                if (this.skyCrystalDetectorDataBuilder_ != null) {
                    this.skyCrystalDetectorDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.skyCrystalDetectorData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSkyCrystalDetectorData(SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.Builder builderForValue) {
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    this.skyCrystalDetectorData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.skyCrystalDetectorDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSkyCrystalDetectorData(SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData value) {
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    if (this.skyCrystalDetectorData_ != null) {
                        this.skyCrystalDetectorData_ = SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.newBuilder(this.skyCrystalDetectorData_).mergeFrom(value).buildPartial();
                    } else {
                        this.skyCrystalDetectorData_ = value;
                    }
                    onChanged();
                } else {
                    this.skyCrystalDetectorDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSkyCrystalDetectorData() {
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    this.skyCrystalDetectorData_ = null;
                    onChanged();
                } else {
                    this.skyCrystalDetectorData_ = null;
                    this.skyCrystalDetectorDataBuilder_ = null;
                }
                return this;
            }

            public SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.Builder getSkyCrystalDetectorDataBuilder() {
                onChanged();
                return getSkyCrystalDetectorDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder
            public SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder getSkyCrystalDetectorDataOrBuilder() {
                if (this.skyCrystalDetectorDataBuilder_ != null) {
                    return this.skyCrystalDetectorDataBuilder_.getMessageOrBuilder();
                }
                return this.skyCrystalDetectorData_ == null ? SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.getDefaultInstance() : this.skyCrystalDetectorData_;
            }

            private SingleFieldBuilderV3<SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData, SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.Builder, SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder> getSkyCrystalDetectorDataFieldBuilder() {
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    this.skyCrystalDetectorDataBuilder_ = new SingleFieldBuilderV3<>(getSkyCrystalDetectorData(), getParentForChildren(), isClean());
                    this.skyCrystalDetectorData_ = null;
                }
                return this.skyCrystalDetectorDataBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder
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

        public static SkyCrystalDetectorQuickUseResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SkyCrystalDetectorQuickUseResult> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SkyCrystalDetectorQuickUseResult> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SkyCrystalDetectorQuickUseResult getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SkyCrystalDetectorDataOuterClass.getDescriptor();
    }
}
