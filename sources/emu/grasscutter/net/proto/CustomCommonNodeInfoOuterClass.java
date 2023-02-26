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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomCommonNodeInfoOuterClass.class */
public final class CustomCommonNodeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aCustomCommonNodeInfo.proto\"U\n\u0014CustomCommonNodeInfo\u0012\u0013\n\u000bparentIndex\u0018\u0001 \u0001(\u0005\u0012\u0010\n\bconfigId\u0018\u0002 \u0001(\r\u0012\u0016\n\u000eslotIdentifier\u0018\u0003 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CustomCommonNodeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CustomCommonNodeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CustomCommonNodeInfo_descriptor, new String[]{"ParentIndex", "ConfigId", "SlotIdentifier"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomCommonNodeInfoOuterClass$CustomCommonNodeInfoOrBuilder.class */
    public interface CustomCommonNodeInfoOrBuilder extends MessageOrBuilder {
        int getParentIndex();

        int getConfigId();

        String getSlotIdentifier();

        ByteString getSlotIdentifierBytes();
    }

    private CustomCommonNodeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomCommonNodeInfoOuterClass$CustomCommonNodeInfo.class */
    public static final class CustomCommonNodeInfo extends GeneratedMessageV3 implements CustomCommonNodeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARENTINDEX_FIELD_NUMBER = 1;
        private int parentIndex_;
        public static final int CONFIGID_FIELD_NUMBER = 2;
        private int configId_;
        public static final int SLOTIDENTIFIER_FIELD_NUMBER = 3;
        private volatile Object slotIdentifier_;
        private byte memoizedIsInitialized;
        private static final CustomCommonNodeInfo DEFAULT_INSTANCE = new CustomCommonNodeInfo();
        private static final Parser<CustomCommonNodeInfo> PARSER = new AbstractParser<CustomCommonNodeInfo>() { // from class: emu.grasscutter.net.proto.CustomCommonNodeInfoOuterClass.CustomCommonNodeInfo.1
            @Override // com.google.protobuf.Parser
            public CustomCommonNodeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CustomCommonNodeInfo(input, extensionRegistry);
            }
        };

        private CustomCommonNodeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CustomCommonNodeInfo() {
            this.memoizedIsInitialized = -1;
            this.slotIdentifier_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CustomCommonNodeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CustomCommonNodeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.parentIndex_ = input.readInt32();
                                break;
                            case 16:
                                this.configId_ = input.readUInt32();
                                break;
                            case 26:
                                this.slotIdentifier_ = input.readStringRequireUtf8();
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
            return CustomCommonNodeInfoOuterClass.internal_static_CustomCommonNodeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CustomCommonNodeInfoOuterClass.internal_static_CustomCommonNodeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomCommonNodeInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder
        public int getParentIndex() {
            return this.parentIndex_;
        }

        @Override // emu.grasscutter.net.proto.CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder
        public int getConfigId() {
            return this.configId_;
        }

        @Override // emu.grasscutter.net.proto.CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder
        public String getSlotIdentifier() {
            Object ref = this.slotIdentifier_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.slotIdentifier_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder
        public ByteString getSlotIdentifierBytes() {
            Object ref = this.slotIdentifier_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.slotIdentifier_ = b;
            return b;
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
            if (this.parentIndex_ != 0) {
                output.writeInt32(1, this.parentIndex_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(2, this.configId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.slotIdentifier_)) {
                GeneratedMessageV3.writeString(output, 3, this.slotIdentifier_);
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
            if (this.parentIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.parentIndex_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.configId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.slotIdentifier_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.slotIdentifier_);
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
            if (!(obj instanceof CustomCommonNodeInfo)) {
                return equals(obj);
            }
            CustomCommonNodeInfo other = (CustomCommonNodeInfo) obj;
            return getParentIndex() == other.getParentIndex() && getConfigId() == other.getConfigId() && getSlotIdentifier().equals(other.getSlotIdentifier()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getParentIndex())) + 2)) + getConfigId())) + 3)) + getSlotIdentifier().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CustomCommonNodeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CustomCommonNodeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CustomCommonNodeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CustomCommonNodeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CustomCommonNodeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CustomCommonNodeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CustomCommonNodeInfo parseFrom(InputStream input) throws IOException {
            return (CustomCommonNodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CustomCommonNodeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CustomCommonNodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CustomCommonNodeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CustomCommonNodeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CustomCommonNodeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CustomCommonNodeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CustomCommonNodeInfo parseFrom(CodedInputStream input) throws IOException {
            return (CustomCommonNodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CustomCommonNodeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CustomCommonNodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CustomCommonNodeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomCommonNodeInfoOuterClass$CustomCommonNodeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CustomCommonNodeInfoOrBuilder {
            private int parentIndex_;
            private int configId_;
            private Object slotIdentifier_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return CustomCommonNodeInfoOuterClass.internal_static_CustomCommonNodeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CustomCommonNodeInfoOuterClass.internal_static_CustomCommonNodeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomCommonNodeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CustomCommonNodeInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.parentIndex_ = 0;
                this.configId_ = 0;
                this.slotIdentifier_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CustomCommonNodeInfoOuterClass.internal_static_CustomCommonNodeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CustomCommonNodeInfo getDefaultInstanceForType() {
                return CustomCommonNodeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CustomCommonNodeInfo build() {
                CustomCommonNodeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CustomCommonNodeInfo buildPartial() {
                CustomCommonNodeInfo result = new CustomCommonNodeInfo(this);
                result.parentIndex_ = this.parentIndex_;
                result.configId_ = this.configId_;
                result.slotIdentifier_ = this.slotIdentifier_;
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
                if (other instanceof CustomCommonNodeInfo) {
                    return mergeFrom((CustomCommonNodeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CustomCommonNodeInfo other) {
                if (other == CustomCommonNodeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getParentIndex() != 0) {
                    setParentIndex(other.getParentIndex());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
                }
                if (!other.getSlotIdentifier().isEmpty()) {
                    this.slotIdentifier_ = other.slotIdentifier_;
                    onChanged();
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
                CustomCommonNodeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CustomCommonNodeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CustomCommonNodeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder
            public int getParentIndex() {
                return this.parentIndex_;
            }

            public Builder setParentIndex(int value) {
                this.parentIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentIndex() {
                this.parentIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder
            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.configId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder
            public String getSlotIdentifier() {
                Object ref = this.slotIdentifier_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.slotIdentifier_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.CustomCommonNodeInfoOuterClass.CustomCommonNodeInfoOrBuilder
            public ByteString getSlotIdentifierBytes() {
                Object ref = this.slotIdentifier_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.slotIdentifier_ = b;
                return b;
            }

            public Builder setSlotIdentifier(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.slotIdentifier_ = value;
                onChanged();
                return this;
            }

            public Builder clearSlotIdentifier() {
                this.slotIdentifier_ = CustomCommonNodeInfo.getDefaultInstance().getSlotIdentifier();
                onChanged();
                return this;
            }

            public Builder setSlotIdentifierBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                CustomCommonNodeInfo.checkByteStringIsUtf8(value);
                this.slotIdentifier_ = value;
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

        public static CustomCommonNodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CustomCommonNodeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CustomCommonNodeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CustomCommonNodeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
