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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UseItemRspOuterClass.class */
public final class UseItemRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010UseItemRsp.proto\"b\n\nUseItemRsp\u0012\f\n\u0004guid\u0018\f \u0001(\u0004\u0012\u000f\n\u0007retcode\u0018\u0007 \u0001(\u0005\u0012\u000e\n\u0006itemId\u0018\u0004 \u0001(\r\u0012\u0012\n\ntargetGuid\u0018\u000b \u0001(\u0004\u0012\u0011\n\toptionIdx\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UseItemRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UseItemRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UseItemRsp_descriptor, new String[]{"Guid", "Retcode", "ItemId", "TargetGuid", "OptionIdx"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UseItemRspOuterClass$UseItemRspOrBuilder.class */
    public interface UseItemRspOrBuilder extends MessageOrBuilder {
        long getGuid();

        int getRetcode();

        int getItemId();

        long getTargetGuid();

        int getOptionIdx();
    }

    private UseItemRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UseItemRspOuterClass$UseItemRsp.class */
    public static final class UseItemRsp extends GeneratedMessageV3 implements UseItemRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GUID_FIELD_NUMBER = 12;
        private long guid_;
        public static final int RETCODE_FIELD_NUMBER = 7;
        private int retcode_;
        public static final int ITEMID_FIELD_NUMBER = 4;
        private int itemId_;
        public static final int TARGETGUID_FIELD_NUMBER = 11;
        private long targetGuid_;
        public static final int OPTIONIDX_FIELD_NUMBER = 3;
        private int optionIdx_;
        private byte memoizedIsInitialized;
        private static final UseItemRsp DEFAULT_INSTANCE = new UseItemRsp();
        private static final Parser<UseItemRsp> PARSER = new AbstractParser<UseItemRsp>() { // from class: emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRsp.1
            @Override // com.google.protobuf.Parser
            public UseItemRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UseItemRsp(input, extensionRegistry);
            }
        };

        private UseItemRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private UseItemRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UseItemRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UseItemRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.optionIdx_ = input.readUInt32();
                                break;
                            case 32:
                                this.itemId_ = input.readUInt32();
                                break;
                            case 56:
                                this.retcode_ = input.readInt32();
                                break;
                            case 88:
                                this.targetGuid_ = input.readUInt64();
                                break;
                            case 96:
                                this.guid_ = input.readUInt64();
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
            return UseItemRspOuterClass.internal_static_UseItemRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UseItemRspOuterClass.internal_static_UseItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(UseItemRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRspOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRspOrBuilder
        public int getItemId() {
            return this.itemId_;
        }

        @Override // emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRspOrBuilder
        public long getTargetGuid() {
            return this.targetGuid_;
        }

        @Override // emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRspOrBuilder
        public int getOptionIdx() {
            return this.optionIdx_;
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
            if (this.optionIdx_ != 0) {
                output.writeUInt32(3, this.optionIdx_);
            }
            if (this.itemId_ != 0) {
                output.writeUInt32(4, this.itemId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(7, this.retcode_);
            }
            if (this.targetGuid_ != 0) {
                output.writeUInt64(11, this.targetGuid_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(12, this.guid_);
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
            if (this.optionIdx_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.optionIdx_);
            }
            if (this.itemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.itemId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(7, this.retcode_);
            }
            if (this.targetGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(11, this.targetGuid_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(12, this.guid_);
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
            if (!(obj instanceof UseItemRsp)) {
                return equals(obj);
            }
            UseItemRsp other = (UseItemRsp) obj;
            return getGuid() == other.getGuid() && getRetcode() == other.getRetcode() && getItemId() == other.getItemId() && getTargetGuid() == other.getTargetGuid() && getOptionIdx() == other.getOptionIdx() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + Internal.hashLong(getGuid()))) + 7)) + getRetcode())) + 4)) + getItemId())) + 11)) + Internal.hashLong(getTargetGuid()))) + 3)) + getOptionIdx())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static UseItemRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UseItemRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UseItemRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UseItemRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UseItemRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UseItemRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UseItemRsp parseFrom(InputStream input) throws IOException {
            return (UseItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UseItemRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UseItemRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (UseItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UseItemRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UseItemRsp parseFrom(CodedInputStream input) throws IOException {
            return (UseItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UseItemRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UseItemRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UseItemRspOuterClass$UseItemRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UseItemRspOrBuilder {
            private long guid_;
            private int retcode_;
            private int itemId_;
            private long targetGuid_;
            private int optionIdx_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UseItemRspOuterClass.internal_static_UseItemRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UseItemRspOuterClass.internal_static_UseItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(UseItemRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UseItemRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.guid_ = 0;
                this.retcode_ = 0;
                this.itemId_ = 0;
                this.targetGuid_ = 0;
                this.optionIdx_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UseItemRspOuterClass.internal_static_UseItemRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UseItemRsp getDefaultInstanceForType() {
                return UseItemRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UseItemRsp build() {
                UseItemRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UseItemRsp buildPartial() {
                UseItemRsp result = new UseItemRsp(this);
                result.guid_ = this.guid_;
                result.retcode_ = this.retcode_;
                result.itemId_ = this.itemId_;
                result.targetGuid_ = this.targetGuid_;
                result.optionIdx_ = this.optionIdx_;
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
                if (other instanceof UseItemRsp) {
                    return mergeFrom((UseItemRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UseItemRsp other) {
                if (other == UseItemRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getItemId() != 0) {
                    setItemId(other.getItemId());
                }
                if (other.getTargetGuid() != 0) {
                    setTargetGuid(other.getTargetGuid());
                }
                if (other.getOptionIdx() != 0) {
                    setOptionIdx(other.getOptionIdx());
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
                UseItemRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = UseItemRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UseItemRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRspOrBuilder
            public long getGuid() {
                return this.guid_;
            }

            public Builder setGuid(long value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRspOrBuilder
            public int getItemId() {
                return this.itemId_;
            }

            public Builder setItemId(int value) {
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.itemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRspOrBuilder
            public long getTargetGuid() {
                return this.targetGuid_;
            }

            public Builder setTargetGuid(long value) {
                this.targetGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetGuid() {
                this.targetGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UseItemRspOuterClass.UseItemRspOrBuilder
            public int getOptionIdx() {
                return this.optionIdx_;
            }

            public Builder setOptionIdx(int value) {
                this.optionIdx_ = value;
                onChanged();
                return this;
            }

            public Builder clearOptionIdx() {
                this.optionIdx_ = 0;
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

        public static UseItemRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UseItemRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UseItemRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UseItemRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
