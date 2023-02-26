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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponPromoteRspOuterClass.class */
public final class WeaponPromoteRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016WeaponPromoteRsp.proto\"o\n\u0010WeaponPromoteRsp\u0012\u0017\n\u000fcurPromoteLevel\u0018\r \u0001(\r\u0012\u0018\n\u0010targetWeaponGuid\u0018\u0002 \u0001(\u0004\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005\u0012\u0017\n\u000foldPromoteLevel\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_WeaponPromoteRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WeaponPromoteRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WeaponPromoteRsp_descriptor, new String[]{"CurPromoteLevel", "TargetWeaponGuid", "Retcode", "OldPromoteLevel"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponPromoteRspOuterClass$WeaponPromoteRspOrBuilder.class */
    public interface WeaponPromoteRspOrBuilder extends MessageOrBuilder {
        int getCurPromoteLevel();

        long getTargetWeaponGuid();

        int getRetcode();

        int getOldPromoteLevel();
    }

    private WeaponPromoteRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponPromoteRspOuterClass$WeaponPromoteRsp.class */
    public static final class WeaponPromoteRsp extends GeneratedMessageV3 implements WeaponPromoteRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CURPROMOTELEVEL_FIELD_NUMBER = 13;
        private int curPromoteLevel_;
        public static final int TARGETWEAPONGUID_FIELD_NUMBER = 2;
        private long targetWeaponGuid_;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        public static final int OLDPROMOTELEVEL_FIELD_NUMBER = 10;
        private int oldPromoteLevel_;
        private byte memoizedIsInitialized;
        private static final WeaponPromoteRsp DEFAULT_INSTANCE = new WeaponPromoteRsp();
        private static final Parser<WeaponPromoteRsp> PARSER = new AbstractParser<WeaponPromoteRsp>() { // from class: emu.grasscutter.net.proto.WeaponPromoteRspOuterClass.WeaponPromoteRsp.1
            @Override // com.google.protobuf.Parser
            public WeaponPromoteRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WeaponPromoteRsp(input, extensionRegistry);
            }
        };

        private WeaponPromoteRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WeaponPromoteRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WeaponPromoteRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WeaponPromoteRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.targetWeaponGuid_ = input.readUInt64();
                                    break;
                                case 80:
                                    this.oldPromoteLevel_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.curPromoteLevel_ = input.readUInt32();
                                    break;
                                case 112:
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WeaponPromoteRspOuterClass.internal_static_WeaponPromoteRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WeaponPromoteRspOuterClass.internal_static_WeaponPromoteRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WeaponPromoteRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WeaponPromoteRspOuterClass.WeaponPromoteRspOrBuilder
        public int getCurPromoteLevel() {
            return this.curPromoteLevel_;
        }

        @Override // emu.grasscutter.net.proto.WeaponPromoteRspOuterClass.WeaponPromoteRspOrBuilder
        public long getTargetWeaponGuid() {
            return this.targetWeaponGuid_;
        }

        @Override // emu.grasscutter.net.proto.WeaponPromoteRspOuterClass.WeaponPromoteRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.WeaponPromoteRspOuterClass.WeaponPromoteRspOrBuilder
        public int getOldPromoteLevel() {
            return this.oldPromoteLevel_;
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
            if (this.targetWeaponGuid_ != 0) {
                output.writeUInt64(2, this.targetWeaponGuid_);
            }
            if (this.oldPromoteLevel_ != 0) {
                output.writeUInt32(10, this.oldPromoteLevel_);
            }
            if (this.curPromoteLevel_ != 0) {
                output.writeUInt32(13, this.curPromoteLevel_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
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
            if (this.targetWeaponGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(2, this.targetWeaponGuid_);
            }
            if (this.oldPromoteLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.oldPromoteLevel_);
            }
            if (this.curPromoteLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.curPromoteLevel_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
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
            if (!(obj instanceof WeaponPromoteRsp)) {
                return equals(obj);
            }
            WeaponPromoteRsp other = (WeaponPromoteRsp) obj;
            return getCurPromoteLevel() == other.getCurPromoteLevel() && getTargetWeaponGuid() == other.getTargetWeaponGuid() && getRetcode() == other.getRetcode() && getOldPromoteLevel() == other.getOldPromoteLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getCurPromoteLevel())) + 2)) + Internal.hashLong(getTargetWeaponGuid()))) + 14)) + getRetcode())) + 10)) + getOldPromoteLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static WeaponPromoteRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponPromoteRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponPromoteRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponPromoteRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponPromoteRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponPromoteRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponPromoteRsp parseFrom(InputStream input) throws IOException {
            return (WeaponPromoteRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeaponPromoteRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponPromoteRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeaponPromoteRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (WeaponPromoteRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WeaponPromoteRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponPromoteRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeaponPromoteRsp parseFrom(CodedInputStream input) throws IOException {
            return (WeaponPromoteRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeaponPromoteRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponPromoteRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WeaponPromoteRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponPromoteRspOuterClass$WeaponPromoteRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WeaponPromoteRspOrBuilder {
            private int curPromoteLevel_;
            private long targetWeaponGuid_;
            private int retcode_;
            private int oldPromoteLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WeaponPromoteRspOuterClass.internal_static_WeaponPromoteRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WeaponPromoteRspOuterClass.internal_static_WeaponPromoteRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WeaponPromoteRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WeaponPromoteRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.curPromoteLevel_ = 0;
                this.targetWeaponGuid_ = 0;
                this.retcode_ = 0;
                this.oldPromoteLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WeaponPromoteRspOuterClass.internal_static_WeaponPromoteRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WeaponPromoteRsp getDefaultInstanceForType() {
                return WeaponPromoteRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeaponPromoteRsp build() {
                WeaponPromoteRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeaponPromoteRsp buildPartial() {
                WeaponPromoteRsp result = new WeaponPromoteRsp(this);
                result.curPromoteLevel_ = this.curPromoteLevel_;
                result.targetWeaponGuid_ = this.targetWeaponGuid_;
                result.retcode_ = this.retcode_;
                result.oldPromoteLevel_ = this.oldPromoteLevel_;
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
                if (other instanceof WeaponPromoteRsp) {
                    return mergeFrom((WeaponPromoteRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WeaponPromoteRsp other) {
                if (other == WeaponPromoteRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getCurPromoteLevel() != 0) {
                    setCurPromoteLevel(other.getCurPromoteLevel());
                }
                if (other.getTargetWeaponGuid() != 0) {
                    setTargetWeaponGuid(other.getTargetWeaponGuid());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getOldPromoteLevel() != 0) {
                    setOldPromoteLevel(other.getOldPromoteLevel());
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
                WeaponPromoteRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = WeaponPromoteRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WeaponPromoteRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WeaponPromoteRspOuterClass.WeaponPromoteRspOrBuilder
            public int getCurPromoteLevel() {
                return this.curPromoteLevel_;
            }

            public Builder setCurPromoteLevel(int value) {
                this.curPromoteLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurPromoteLevel() {
                this.curPromoteLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WeaponPromoteRspOuterClass.WeaponPromoteRspOrBuilder
            public long getTargetWeaponGuid() {
                return this.targetWeaponGuid_;
            }

            public Builder setTargetWeaponGuid(long value) {
                this.targetWeaponGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetWeaponGuid() {
                this.targetWeaponGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WeaponPromoteRspOuterClass.WeaponPromoteRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.WeaponPromoteRspOuterClass.WeaponPromoteRspOrBuilder
            public int getOldPromoteLevel() {
                return this.oldPromoteLevel_;
            }

            public Builder setOldPromoteLevel(int value) {
                this.oldPromoteLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearOldPromoteLevel() {
                this.oldPromoteLevel_ = 0;
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

        public static WeaponPromoteRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WeaponPromoteRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WeaponPromoteRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WeaponPromoteRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
