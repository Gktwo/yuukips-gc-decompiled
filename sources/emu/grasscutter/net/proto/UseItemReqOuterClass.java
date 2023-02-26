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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UseItemReqOuterClass.class */
public final class UseItemReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010UseItemReq.proto\"n\n\nUseItemReq\u0012\f\n\u0004guid\u0018\b \u0001(\u0004\u0012\u0011\n\toptionIdx\u0018\u000e \u0001(\r\u0012\r\n\u0005count\u0018\f \u0001(\r\u0012\u001c\n\u0014isEnterMpDungeonTeam\u0018\r \u0001(\b\u0012\u0012\n\ntargetGuid\u0018\u0006 \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UseItemReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UseItemReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UseItemReq_descriptor, new String[]{"Guid", "OptionIdx", "Count", "IsEnterMpDungeonTeam", "TargetGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UseItemReqOuterClass$UseItemReqOrBuilder.class */
    public interface UseItemReqOrBuilder extends MessageOrBuilder {
        long getGuid();

        int getOptionIdx();

        int getCount();

        boolean getIsEnterMpDungeonTeam();

        long getTargetGuid();
    }

    private UseItemReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UseItemReqOuterClass$UseItemReq.class */
    public static final class UseItemReq extends GeneratedMessageV3 implements UseItemReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GUID_FIELD_NUMBER = 8;
        private long guid_;
        public static final int OPTIONIDX_FIELD_NUMBER = 14;
        private int optionIdx_;
        public static final int COUNT_FIELD_NUMBER = 12;
        private int count_;
        public static final int ISENTERMPDUNGEONTEAM_FIELD_NUMBER = 13;
        private boolean isEnterMpDungeonTeam_;
        public static final int TARGETGUID_FIELD_NUMBER = 6;
        private long targetGuid_;
        private byte memoizedIsInitialized;
        private static final UseItemReq DEFAULT_INSTANCE = new UseItemReq();
        private static final Parser<UseItemReq> PARSER = new AbstractParser<UseItemReq>() { // from class: emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReq.1
            @Override // com.google.protobuf.Parser
            public UseItemReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UseItemReq(input, extensionRegistry);
            }
        };

        private UseItemReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private UseItemReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UseItemReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UseItemReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.targetGuid_ = input.readUInt64();
                                break;
                            case 64:
                                this.guid_ = input.readUInt64();
                                break;
                            case 96:
                                this.count_ = input.readUInt32();
                                break;
                            case 104:
                                this.isEnterMpDungeonTeam_ = input.readBool();
                                break;
                            case 112:
                                this.optionIdx_ = input.readUInt32();
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
            return UseItemReqOuterClass.internal_static_UseItemReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UseItemReqOuterClass.internal_static_UseItemReq_fieldAccessorTable.ensureFieldAccessorsInitialized(UseItemReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReqOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReqOrBuilder
        public int getOptionIdx() {
            return this.optionIdx_;
        }

        @Override // emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReqOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReqOrBuilder
        public boolean getIsEnterMpDungeonTeam() {
            return this.isEnterMpDungeonTeam_;
        }

        @Override // emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReqOrBuilder
        public long getTargetGuid() {
            return this.targetGuid_;
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
            if (this.targetGuid_ != 0) {
                output.writeUInt64(6, this.targetGuid_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(8, this.guid_);
            }
            if (this.count_ != 0) {
                output.writeUInt32(12, this.count_);
            }
            if (this.isEnterMpDungeonTeam_) {
                output.writeBool(13, this.isEnterMpDungeonTeam_);
            }
            if (this.optionIdx_ != 0) {
                output.writeUInt32(14, this.optionIdx_);
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
            if (this.targetGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(6, this.targetGuid_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(8, this.guid_);
            }
            if (this.count_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.count_);
            }
            if (this.isEnterMpDungeonTeam_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isEnterMpDungeonTeam_);
            }
            if (this.optionIdx_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.optionIdx_);
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
            if (!(obj instanceof UseItemReq)) {
                return equals(obj);
            }
            UseItemReq other = (UseItemReq) obj;
            return getGuid() == other.getGuid() && getOptionIdx() == other.getOptionIdx() && getCount() == other.getCount() && getIsEnterMpDungeonTeam() == other.getIsEnterMpDungeonTeam() && getTargetGuid() == other.getTargetGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashLong(getGuid()))) + 14)) + getOptionIdx())) + 12)) + getCount())) + 13)) + Internal.hashBoolean(getIsEnterMpDungeonTeam()))) + 6)) + Internal.hashLong(getTargetGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static UseItemReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UseItemReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UseItemReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UseItemReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UseItemReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UseItemReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UseItemReq parseFrom(InputStream input) throws IOException {
            return (UseItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UseItemReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UseItemReq parseDelimitedFrom(InputStream input) throws IOException {
            return (UseItemReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UseItemReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UseItemReq parseFrom(CodedInputStream input) throws IOException {
            return (UseItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UseItemReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UseItemReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UseItemReqOuterClass$UseItemReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UseItemReqOrBuilder {
            private long guid_;
            private int optionIdx_;
            private int count_;
            private boolean isEnterMpDungeonTeam_;
            private long targetGuid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UseItemReqOuterClass.internal_static_UseItemReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UseItemReqOuterClass.internal_static_UseItemReq_fieldAccessorTable.ensureFieldAccessorsInitialized(UseItemReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UseItemReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.guid_ = 0;
                this.optionIdx_ = 0;
                this.count_ = 0;
                this.isEnterMpDungeonTeam_ = false;
                this.targetGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UseItemReqOuterClass.internal_static_UseItemReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UseItemReq getDefaultInstanceForType() {
                return UseItemReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UseItemReq build() {
                UseItemReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UseItemReq buildPartial() {
                UseItemReq result = new UseItemReq(this);
                result.guid_ = this.guid_;
                result.optionIdx_ = this.optionIdx_;
                result.count_ = this.count_;
                result.isEnterMpDungeonTeam_ = this.isEnterMpDungeonTeam_;
                result.targetGuid_ = this.targetGuid_;
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
                if (other instanceof UseItemReq) {
                    return mergeFrom((UseItemReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UseItemReq other) {
                if (other == UseItemReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getOptionIdx() != 0) {
                    setOptionIdx(other.getOptionIdx());
                }
                if (other.getCount() != 0) {
                    setCount(other.getCount());
                }
                if (other.getIsEnterMpDungeonTeam()) {
                    setIsEnterMpDungeonTeam(other.getIsEnterMpDungeonTeam());
                }
                if (other.getTargetGuid() != 0) {
                    setTargetGuid(other.getTargetGuid());
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
                UseItemReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = UseItemReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UseItemReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReqOrBuilder
            public int getCount() {
                return this.count_;
            }

            public Builder setCount(int value) {
                this.count_ = value;
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReqOrBuilder
            public boolean getIsEnterMpDungeonTeam() {
                return this.isEnterMpDungeonTeam_;
            }

            public Builder setIsEnterMpDungeonTeam(boolean value) {
                this.isEnterMpDungeonTeam_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEnterMpDungeonTeam() {
                this.isEnterMpDungeonTeam_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UseItemReqOuterClass.UseItemReqOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static UseItemReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UseItemReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UseItemReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UseItemReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
