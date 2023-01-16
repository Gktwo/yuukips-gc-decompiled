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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineFormulaDataNotifyOuterClass.class */
public final class CombineFormulaDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eCombineFormulaDataNotify.proto\"A\n\u0018CombineFormulaDataNotify\u0012\u0012\n\ncombine_id\u0018\u0006 \u0001(\r\u0012\u0011\n\tis_locked\u0018\b \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CombineFormulaDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CombineFormulaDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CombineFormulaDataNotify_descriptor, new String[]{"CombineId", "IsLocked"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineFormulaDataNotifyOuterClass$CombineFormulaDataNotifyOrBuilder.class */
    public interface CombineFormulaDataNotifyOrBuilder extends MessageOrBuilder {
        int getCombineId();

        boolean getIsLocked();
    }

    private CombineFormulaDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineFormulaDataNotifyOuterClass$CombineFormulaDataNotify.class */
    public static final class CombineFormulaDataNotify extends GeneratedMessageV3 implements CombineFormulaDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMBINE_ID_FIELD_NUMBER = 6;
        private int combineId_;
        public static final int IS_LOCKED_FIELD_NUMBER = 8;
        private boolean isLocked_;
        private byte memoizedIsInitialized;
        private static final CombineFormulaDataNotify DEFAULT_INSTANCE = new CombineFormulaDataNotify();
        private static final Parser<CombineFormulaDataNotify> PARSER = new AbstractParser<CombineFormulaDataNotify>() { // from class: emu.grasscutter.net.proto.CombineFormulaDataNotifyOuterClass.CombineFormulaDataNotify.1
            @Override // com.google.protobuf.Parser
            public CombineFormulaDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CombineFormulaDataNotify(input, extensionRegistry);
            }
        };

        private CombineFormulaDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CombineFormulaDataNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CombineFormulaDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CombineFormulaDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                this.combineId_ = input.readUInt32();
                                break;
                            case 64:
                                this.isLocked_ = input.readBool();
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
            return CombineFormulaDataNotifyOuterClass.internal_static_CombineFormulaDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CombineFormulaDataNotifyOuterClass.internal_static_CombineFormulaDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CombineFormulaDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CombineFormulaDataNotifyOuterClass.CombineFormulaDataNotifyOrBuilder
        public int getCombineId() {
            return this.combineId_;
        }

        @Override // emu.grasscutter.net.proto.CombineFormulaDataNotifyOuterClass.CombineFormulaDataNotifyOrBuilder
        public boolean getIsLocked() {
            return this.isLocked_;
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
            if (this.combineId_ != 0) {
                output.writeUInt32(6, this.combineId_);
            }
            if (this.isLocked_) {
                output.writeBool(8, this.isLocked_);
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
            if (this.combineId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.combineId_);
            }
            if (this.isLocked_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isLocked_);
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
            if (!(obj instanceof CombineFormulaDataNotify)) {
                return equals(obj);
            }
            CombineFormulaDataNotify other = (CombineFormulaDataNotify) obj;
            return getCombineId() == other.getCombineId() && getIsLocked() == other.getIsLocked() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getCombineId())) + 8)) + Internal.hashBoolean(getIsLocked()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CombineFormulaDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineFormulaDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineFormulaDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineFormulaDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineFormulaDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineFormulaDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineFormulaDataNotify parseFrom(InputStream input) throws IOException {
            return (CombineFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombineFormulaDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombineFormulaDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CombineFormulaDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CombineFormulaDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineFormulaDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombineFormulaDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (CombineFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombineFormulaDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CombineFormulaDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineFormulaDataNotifyOuterClass$CombineFormulaDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CombineFormulaDataNotifyOrBuilder {
            private int combineId_;
            private boolean isLocked_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CombineFormulaDataNotifyOuterClass.internal_static_CombineFormulaDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CombineFormulaDataNotifyOuterClass.internal_static_CombineFormulaDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CombineFormulaDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CombineFormulaDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.combineId_ = 0;
                this.isLocked_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CombineFormulaDataNotifyOuterClass.internal_static_CombineFormulaDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CombineFormulaDataNotify getDefaultInstanceForType() {
                return CombineFormulaDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombineFormulaDataNotify build() {
                CombineFormulaDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombineFormulaDataNotify buildPartial() {
                CombineFormulaDataNotify result = new CombineFormulaDataNotify(this);
                result.combineId_ = this.combineId_;
                result.isLocked_ = this.isLocked_;
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
                if (other instanceof CombineFormulaDataNotify) {
                    return mergeFrom((CombineFormulaDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CombineFormulaDataNotify other) {
                if (other == CombineFormulaDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getCombineId() != 0) {
                    setCombineId(other.getCombineId());
                }
                if (other.getIsLocked()) {
                    setIsLocked(other.getIsLocked());
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
                CombineFormulaDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = CombineFormulaDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CombineFormulaDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CombineFormulaDataNotifyOuterClass.CombineFormulaDataNotifyOrBuilder
            public int getCombineId() {
                return this.combineId_;
            }

            public Builder setCombineId(int value) {
                this.combineId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombineId() {
                this.combineId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CombineFormulaDataNotifyOuterClass.CombineFormulaDataNotifyOrBuilder
            public boolean getIsLocked() {
                return this.isLocked_;
            }

            public Builder setIsLocked(boolean value) {
                this.isLocked_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsLocked() {
                this.isLocked_ = false;
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

        public static CombineFormulaDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CombineFormulaDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CombineFormulaDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CombineFormulaDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
