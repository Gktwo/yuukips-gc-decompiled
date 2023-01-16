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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSearchBeatmapReqOuterClass.class */
public final class MusicGameSearchBeatmapReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fMusicGameSearchBeatmapReq.proto\u001a\u001bMusicGameUnknown1Enum.proto\"b\n\u0019MusicGameSearchBeatmapReq\u0012-\n\runknown_enum1\u0018\n \u0001(\u000e2\u0016.MusicGameUnknown1Enum\u0012\u0016\n\u000emusic_share_id\u0018\u0006 \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MusicGameUnknown1EnumOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicGameSearchBeatmapReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicGameSearchBeatmapReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameSearchBeatmapReq_descriptor, new String[]{"UnknownEnum1", "MusicShareId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSearchBeatmapReqOuterClass$MusicGameSearchBeatmapReqOrBuilder.class */
    public interface MusicGameSearchBeatmapReqOrBuilder extends MessageOrBuilder {
        int getUnknownEnum1Value();

        MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1();

        long getMusicShareId();
    }

    private MusicGameSearchBeatmapReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSearchBeatmapReqOuterClass$MusicGameSearchBeatmapReq.class */
    public static final class MusicGameSearchBeatmapReq extends GeneratedMessageV3 implements MusicGameSearchBeatmapReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNKNOWN_ENUM1_FIELD_NUMBER = 10;
        private int unknownEnum1_;
        public static final int MUSIC_SHARE_ID_FIELD_NUMBER = 6;
        private long musicShareId_;
        private byte memoizedIsInitialized;
        private static final MusicGameSearchBeatmapReq DEFAULT_INSTANCE = new MusicGameSearchBeatmapReq();
        private static final Parser<MusicGameSearchBeatmapReq> PARSER = new AbstractParser<MusicGameSearchBeatmapReq>() { // from class: emu.grasscutter.net.proto.MusicGameSearchBeatmapReqOuterClass.MusicGameSearchBeatmapReq.1
            @Override // com.google.protobuf.Parser
            public MusicGameSearchBeatmapReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameSearchBeatmapReq(input, extensionRegistry);
            }
        };

        private MusicGameSearchBeatmapReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MusicGameSearchBeatmapReq() {
            this.memoizedIsInitialized = -1;
            this.unknownEnum1_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameSearchBeatmapReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicGameSearchBeatmapReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.musicShareId_ = input.readUInt64();
                                    break;
                                case 80:
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
            return MusicGameSearchBeatmapReqOuterClass.internal_static_MusicGameSearchBeatmapReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameSearchBeatmapReqOuterClass.internal_static_MusicGameSearchBeatmapReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameSearchBeatmapReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapReqOuterClass.MusicGameSearchBeatmapReqOrBuilder
        public int getUnknownEnum1Value() {
            return this.unknownEnum1_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapReqOuterClass.MusicGameSearchBeatmapReqOrBuilder
        public MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1() {
            MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum result = MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.valueOf(this.unknownEnum1_);
            return result == null ? MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapReqOuterClass.MusicGameSearchBeatmapReqOrBuilder
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
                output.writeUInt64(6, this.musicShareId_);
            }
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                output.writeEnum(10, this.unknownEnum1_);
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
                size2 = 0 + CodedOutputStream.computeUInt64Size(6, this.musicShareId_);
            }
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(10, this.unknownEnum1_);
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
            if (!(obj instanceof MusicGameSearchBeatmapReq)) {
                return equals(obj);
            }
            MusicGameSearchBeatmapReq other = (MusicGameSearchBeatmapReq) obj;
            return this.unknownEnum1_ == other.unknownEnum1_ && getMusicShareId() == other.getMusicShareId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + this.unknownEnum1_)) + 6)) + Internal.hashLong(getMusicShareId()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MusicGameSearchBeatmapReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSearchBeatmapReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSearchBeatmapReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSearchBeatmapReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSearchBeatmapReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSearchBeatmapReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSearchBeatmapReq parseFrom(InputStream input) throws IOException {
            return (MusicGameSearchBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameSearchBeatmapReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSearchBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameSearchBeatmapReq parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameSearchBeatmapReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameSearchBeatmapReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSearchBeatmapReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameSearchBeatmapReq parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameSearchBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameSearchBeatmapReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSearchBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameSearchBeatmapReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSearchBeatmapReqOuterClass$MusicGameSearchBeatmapReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameSearchBeatmapReqOrBuilder {
            private int unknownEnum1_ = 0;
            private long musicShareId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameSearchBeatmapReqOuterClass.internal_static_MusicGameSearchBeatmapReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameSearchBeatmapReqOuterClass.internal_static_MusicGameSearchBeatmapReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameSearchBeatmapReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameSearchBeatmapReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unknownEnum1_ = 0;
                this.musicShareId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameSearchBeatmapReqOuterClass.internal_static_MusicGameSearchBeatmapReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameSearchBeatmapReq getDefaultInstanceForType() {
                return MusicGameSearchBeatmapReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameSearchBeatmapReq build() {
                MusicGameSearchBeatmapReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameSearchBeatmapReq buildPartial() {
                MusicGameSearchBeatmapReq result = new MusicGameSearchBeatmapReq(this);
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
                if (other instanceof MusicGameSearchBeatmapReq) {
                    return mergeFrom((MusicGameSearchBeatmapReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameSearchBeatmapReq other) {
                if (other == MusicGameSearchBeatmapReq.getDefaultInstance()) {
                    return this;
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
                MusicGameSearchBeatmapReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameSearchBeatmapReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameSearchBeatmapReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapReqOuterClass.MusicGameSearchBeatmapReqOrBuilder
            public int getUnknownEnum1Value() {
                return this.unknownEnum1_;
            }

            public Builder setUnknownEnum1Value(int value) {
                this.unknownEnum1_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapReqOuterClass.MusicGameSearchBeatmapReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapReqOuterClass.MusicGameSearchBeatmapReqOrBuilder
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

        public static MusicGameSearchBeatmapReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameSearchBeatmapReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameSearchBeatmapReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameSearchBeatmapReq getDefaultInstanceForType() {
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
