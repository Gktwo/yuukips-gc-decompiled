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
import emu.grasscutter.net.proto.MusicGameUnknown1EnumOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameCreateBeatmapRspOuterClass.class */
public final class MusicGameCreateBeatmapRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fMusicGameCreateBeatmapRsp.proto\u001a\u001bMusicGameUnknown1Enum.proto\"s\n\u0019MusicGameCreateBeatmapRsp\u0012\u000f\n\u0007retcode\u0018\n \u0001(\u0005\u0012-\n\runknown_enum1\u0018\f \u0001(\u000e2\u0016.MusicGameUnknown1Enum\u0012\u0016\n\u000emusic_share_id\u0018\u0005 \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MusicGameUnknown1EnumOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicGameCreateBeatmapRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicGameCreateBeatmapRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameCreateBeatmapRsp_descriptor, new String[]{"Retcode", "UnknownEnum1", "MusicShareId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameCreateBeatmapRspOuterClass$MusicGameCreateBeatmapRspOrBuilder.class */
    public interface MusicGameCreateBeatmapRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getUnknownEnum1Value();

        MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1();

        long getMusicShareId();
    }

    private MusicGameCreateBeatmapRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameCreateBeatmapRspOuterClass$MusicGameCreateBeatmapRsp.class */
    public static final class MusicGameCreateBeatmapRsp extends GeneratedMessageV3 implements MusicGameCreateBeatmapRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 10;
        private int retcode_;
        public static final int UNKNOWN_ENUM1_FIELD_NUMBER = 12;
        private int unknownEnum1_;
        public static final int MUSIC_SHARE_ID_FIELD_NUMBER = 5;
        private long musicShareId_;
        private byte memoizedIsInitialized;
        private static final MusicGameCreateBeatmapRsp DEFAULT_INSTANCE = new MusicGameCreateBeatmapRsp();
        private static final Parser<MusicGameCreateBeatmapRsp> PARSER = new AbstractParser<MusicGameCreateBeatmapRsp>() { // from class: emu.grasscutter.net.proto.MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRsp.1
            @Override // com.google.protobuf.Parser
            public MusicGameCreateBeatmapRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameCreateBeatmapRsp(input, extensionRegistry);
            }
        };

        private MusicGameCreateBeatmapRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MusicGameCreateBeatmapRsp() {
            this.memoizedIsInitialized = -1;
            this.unknownEnum1_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameCreateBeatmapRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicGameCreateBeatmapRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.musicShareId_ = input.readUInt64();
                                break;
                            case 80:
                                this.retcode_ = input.readInt32();
                                break;
                            case 96:
                                this.unknownEnum1_ = input.readEnum();
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
            return MusicGameCreateBeatmapRspOuterClass.internal_static_MusicGameCreateBeatmapRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameCreateBeatmapRspOuterClass.internal_static_MusicGameCreateBeatmapRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameCreateBeatmapRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRspOrBuilder
        public int getUnknownEnum1Value() {
            return this.unknownEnum1_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRspOrBuilder
        public MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1() {
            MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum result = MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.valueOf(this.unknownEnum1_);
            return result == null ? MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRspOrBuilder
        public long getMusicShareId() {
            return this.musicShareId_;
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
            if (this.musicShareId_ != 0) {
                output.writeUInt64(5, this.musicShareId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(10, this.retcode_);
            }
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                output.writeEnum(12, this.unknownEnum1_);
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
            if (this.musicShareId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(5, this.musicShareId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.retcode_);
            }
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.unknownEnum1_);
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
            if (!(obj instanceof MusicGameCreateBeatmapRsp)) {
                return equals(obj);
            }
            MusicGameCreateBeatmapRsp other = (MusicGameCreateBeatmapRsp) obj;
            return getRetcode() == other.getRetcode() && this.unknownEnum1_ == other.unknownEnum1_ && getMusicShareId() == other.getMusicShareId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getRetcode())) + 12)) + this.unknownEnum1_)) + 5)) + Internal.hashLong(getMusicShareId()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MusicGameCreateBeatmapRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameCreateBeatmapRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameCreateBeatmapRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameCreateBeatmapRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameCreateBeatmapRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameCreateBeatmapRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameCreateBeatmapRsp parseFrom(InputStream input) throws IOException {
            return (MusicGameCreateBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameCreateBeatmapRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameCreateBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameCreateBeatmapRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameCreateBeatmapRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameCreateBeatmapRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameCreateBeatmapRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameCreateBeatmapRsp parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameCreateBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameCreateBeatmapRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameCreateBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameCreateBeatmapRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameCreateBeatmapRspOuterClass$MusicGameCreateBeatmapRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameCreateBeatmapRspOrBuilder {
            private int retcode_;
            private int unknownEnum1_ = 0;
            private long musicShareId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameCreateBeatmapRspOuterClass.internal_static_MusicGameCreateBeatmapRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameCreateBeatmapRspOuterClass.internal_static_MusicGameCreateBeatmapRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameCreateBeatmapRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameCreateBeatmapRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.unknownEnum1_ = 0;
                this.musicShareId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameCreateBeatmapRspOuterClass.internal_static_MusicGameCreateBeatmapRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameCreateBeatmapRsp getDefaultInstanceForType() {
                return MusicGameCreateBeatmapRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameCreateBeatmapRsp build() {
                MusicGameCreateBeatmapRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameCreateBeatmapRsp buildPartial() {
                MusicGameCreateBeatmapRsp result = new MusicGameCreateBeatmapRsp(this);
                result.retcode_ = this.retcode_;
                result.unknownEnum1_ = this.unknownEnum1_;
                result.musicShareId_ = this.musicShareId_;
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
                if (other instanceof MusicGameCreateBeatmapRsp) {
                    return mergeFrom((MusicGameCreateBeatmapRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameCreateBeatmapRsp other) {
                if (other == MusicGameCreateBeatmapRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.unknownEnum1_ != 0) {
                    setUnknownEnum1Value(other.getUnknownEnum1Value());
                }
                if (other.getMusicShareId() != 0) {
                    setMusicShareId(other.getMusicShareId());
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
                MusicGameCreateBeatmapRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameCreateBeatmapRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameCreateBeatmapRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRspOrBuilder
            public int getUnknownEnum1Value() {
                return this.unknownEnum1_;
            }

            public Builder setUnknownEnum1Value(int value) {
                this.unknownEnum1_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRspOrBuilder
            public MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1() {
                MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum result = MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.valueOf(this.unknownEnum1_);
                return result == null ? MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.UNRECOGNIZED : result;
            }

            public Builder setUnknownEnum1(MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unknownEnum1_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearUnknownEnum1() {
                this.unknownEnum1_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRspOrBuilder
            public long getMusicShareId() {
                return this.musicShareId_;
            }

            public Builder setMusicShareId(long value) {
                this.musicShareId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMusicShareId() {
                this.musicShareId_ = 0;
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

        public static MusicGameCreateBeatmapRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameCreateBeatmapRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameCreateBeatmapRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameCreateBeatmapRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MusicGameUnknown1EnumOuterClass.getDescriptor();
    }
}
