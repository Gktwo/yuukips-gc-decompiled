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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSettleRspOuterClass.class */
public final class MusicGameSettleRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018MusicGameSettleRsp.proto\"|\n\u0012MusicGameSettleRsp\u0012\u000f\n\u0007retcode\u0018\t \u0001(\u0005\u0012\u0019\n\u0011isUnlockNextLevel\u0018\u0001 \u0001(\b\u0012\u000f\n\u0007ugcGuid\u0018\u0007 \u0001(\u0004\u0012\u0014\n\fmusicBasicId\u0018\u0004 \u0001(\r\u0012\u0013\n\u000bisNewRecord\u0018\u000e \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MusicGameSettleRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicGameSettleRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameSettleRsp_descriptor, new String[]{"Retcode", "IsUnlockNextLevel", "UgcGuid", "MusicBasicId", "IsNewRecord"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSettleRspOuterClass$MusicGameSettleRspOrBuilder.class */
    public interface MusicGameSettleRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        boolean getIsUnlockNextLevel();

        long getUgcGuid();

        int getMusicBasicId();

        boolean getIsNewRecord();
    }

    private MusicGameSettleRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSettleRspOuterClass$MusicGameSettleRsp.class */
    public static final class MusicGameSettleRsp extends GeneratedMessageV3 implements MusicGameSettleRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 9;
        private int retcode_;
        public static final int ISUNLOCKNEXTLEVEL_FIELD_NUMBER = 1;
        private boolean isUnlockNextLevel_;
        public static final int UGCGUID_FIELD_NUMBER = 7;
        private long ugcGuid_;
        public static final int MUSICBASICID_FIELD_NUMBER = 4;
        private int musicBasicId_;
        public static final int ISNEWRECORD_FIELD_NUMBER = 14;
        private boolean isNewRecord_;
        private byte memoizedIsInitialized;
        private static final MusicGameSettleRsp DEFAULT_INSTANCE = new MusicGameSettleRsp();
        private static final Parser<MusicGameSettleRsp> PARSER = new AbstractParser<MusicGameSettleRsp>() { // from class: emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRsp.1
            @Override // com.google.protobuf.Parser
            public MusicGameSettleRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameSettleRsp(input, extensionRegistry);
            }
        };

        private MusicGameSettleRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MusicGameSettleRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameSettleRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicGameSettleRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isUnlockNextLevel_ = input.readBool();
                                break;
                            case 32:
                                this.musicBasicId_ = input.readUInt32();
                                break;
                            case 56:
                                this.ugcGuid_ = input.readUInt64();
                                break;
                            case 72:
                                this.retcode_ = input.readInt32();
                                break;
                            case 112:
                                this.isNewRecord_ = input.readBool();
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
            return MusicGameSettleRspOuterClass.internal_static_MusicGameSettleRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameSettleRspOuterClass.internal_static_MusicGameSettleRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameSettleRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRspOrBuilder
        public boolean getIsUnlockNextLevel() {
            return this.isUnlockNextLevel_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRspOrBuilder
        public long getUgcGuid() {
            return this.ugcGuid_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRspOrBuilder
        public int getMusicBasicId() {
            return this.musicBasicId_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRspOrBuilder
        public boolean getIsNewRecord() {
            return this.isNewRecord_;
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
            if (this.isUnlockNextLevel_) {
                output.writeBool(1, this.isUnlockNextLevel_);
            }
            if (this.musicBasicId_ != 0) {
                output.writeUInt32(4, this.musicBasicId_);
            }
            if (this.ugcGuid_ != 0) {
                output.writeUInt64(7, this.ugcGuid_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(9, this.retcode_);
            }
            if (this.isNewRecord_) {
                output.writeBool(14, this.isNewRecord_);
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
            if (this.isUnlockNextLevel_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isUnlockNextLevel_);
            }
            if (this.musicBasicId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.musicBasicId_);
            }
            if (this.ugcGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(7, this.ugcGuid_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.retcode_);
            }
            if (this.isNewRecord_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isNewRecord_);
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
            if (!(obj instanceof MusicGameSettleRsp)) {
                return equals(obj);
            }
            MusicGameSettleRsp other = (MusicGameSettleRsp) obj;
            return getRetcode() == other.getRetcode() && getIsUnlockNextLevel() == other.getIsUnlockNextLevel() && getUgcGuid() == other.getUgcGuid() && getMusicBasicId() == other.getMusicBasicId() && getIsNewRecord() == other.getIsNewRecord() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getRetcode())) + 1)) + Internal.hashBoolean(getIsUnlockNextLevel()))) + 7)) + Internal.hashLong(getUgcGuid()))) + 4)) + getMusicBasicId())) + 14)) + Internal.hashBoolean(getIsNewRecord()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MusicGameSettleRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSettleRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSettleRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSettleRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSettleRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSettleRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSettleRsp parseFrom(InputStream input) throws IOException {
            return (MusicGameSettleRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameSettleRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSettleRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameSettleRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameSettleRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameSettleRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSettleRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameSettleRsp parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameSettleRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameSettleRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSettleRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameSettleRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSettleRspOuterClass$MusicGameSettleRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameSettleRspOrBuilder {
            private int retcode_;
            private boolean isUnlockNextLevel_;
            private long ugcGuid_;
            private int musicBasicId_;
            private boolean isNewRecord_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameSettleRspOuterClass.internal_static_MusicGameSettleRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameSettleRspOuterClass.internal_static_MusicGameSettleRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameSettleRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameSettleRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.isUnlockNextLevel_ = false;
                this.ugcGuid_ = 0;
                this.musicBasicId_ = 0;
                this.isNewRecord_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameSettleRspOuterClass.internal_static_MusicGameSettleRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameSettleRsp getDefaultInstanceForType() {
                return MusicGameSettleRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameSettleRsp build() {
                MusicGameSettleRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameSettleRsp buildPartial() {
                MusicGameSettleRsp result = new MusicGameSettleRsp(this);
                result.retcode_ = this.retcode_;
                result.isUnlockNextLevel_ = this.isUnlockNextLevel_;
                result.ugcGuid_ = this.ugcGuid_;
                result.musicBasicId_ = this.musicBasicId_;
                result.isNewRecord_ = this.isNewRecord_;
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
                if (other instanceof MusicGameSettleRsp) {
                    return mergeFrom((MusicGameSettleRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameSettleRsp other) {
                if (other == MusicGameSettleRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getIsUnlockNextLevel()) {
                    setIsUnlockNextLevel(other.getIsUnlockNextLevel());
                }
                if (other.getUgcGuid() != 0) {
                    setUgcGuid(other.getUgcGuid());
                }
                if (other.getMusicBasicId() != 0) {
                    setMusicBasicId(other.getMusicBasicId());
                }
                if (other.getIsNewRecord()) {
                    setIsNewRecord(other.getIsNewRecord());
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
                MusicGameSettleRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameSettleRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameSettleRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRspOrBuilder
            public boolean getIsUnlockNextLevel() {
                return this.isUnlockNextLevel_;
            }

            public Builder setIsUnlockNextLevel(boolean value) {
                this.isUnlockNextLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsUnlockNextLevel() {
                this.isUnlockNextLevel_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRspOrBuilder
            public long getUgcGuid() {
                return this.ugcGuid_;
            }

            public Builder setUgcGuid(long value) {
                this.ugcGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUgcGuid() {
                this.ugcGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRspOrBuilder
            public int getMusicBasicId() {
                return this.musicBasicId_;
            }

            public Builder setMusicBasicId(int value) {
                this.musicBasicId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMusicBasicId() {
                this.musicBasicId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleRspOuterClass.MusicGameSettleRspOrBuilder
            public boolean getIsNewRecord() {
                return this.isNewRecord_;
            }

            public Builder setIsNewRecord(boolean value) {
                this.isNewRecord_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsNewRecord() {
                this.isNewRecord_ = false;
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

        public static MusicGameSettleRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameSettleRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameSettleRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameSettleRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
