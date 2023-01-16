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
import emu.grasscutter.net.proto.MusicGameGetBeatmapReqTypeOuterClass;
import emu.grasscutter.net.proto.MusicGameUnknown1EnumOuterClass;
import emu.grasscutter.net.proto.MusicGameUnknown2EnumOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapReqOuterClass.class */
public final class MusicGameGetBeatmapReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cMusicGameGetBeatmapReq.proto\u001a\u001bMusicGameUnknown2Enum.proto\u001a MusicGameGetBeatmapReqType.proto\u001a\u001bMusicGameUnknown1Enum.proto\"Ò\u0001\n\u0016MusicGameGetBeatmapReq\u0012-\n\runknown_enum1\u0018\u0001 \u0001(\u000e2\u0016.MusicGameUnknown1Enum\u0012\u0016\n\u000emusic_share_id\u0018\n \u0001(\u0004\u0012-\n\runknown_enum2\u0018\f \u0001(\u000e2\u0016.MusicGameUnknown2Enum\u0012\u0013\n\u000bCDFOGGDLKNA\u0018\u000f \u0001(\b\u0012-\n\breq_type\u0018\u000b \u0001(\u000e2\u001b.MusicGameGetBeatmapReqTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MusicGameUnknown2EnumOuterClass.getDescriptor(), MusicGameGetBeatmapReqTypeOuterClass.getDescriptor(), MusicGameUnknown1EnumOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicGameGetBeatmapReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicGameGetBeatmapReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameGetBeatmapReq_descriptor, new String[]{"UnknownEnum1", "MusicShareId", "UnknownEnum2", "CDFOGGDLKNA", "ReqType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapReqOuterClass$MusicGameGetBeatmapReqOrBuilder.class */
    public interface MusicGameGetBeatmapReqOrBuilder extends MessageOrBuilder {
        int getUnknownEnum1Value();

        MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1();

        long getMusicShareId();

        int getUnknownEnum2Value();

        MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum getUnknownEnum2();

        boolean getCDFOGGDLKNA();

        int getReqTypeValue();

        MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType getReqType();
    }

    private MusicGameGetBeatmapReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapReqOuterClass$MusicGameGetBeatmapReq.class */
    public static final class MusicGameGetBeatmapReq extends GeneratedMessageV3 implements MusicGameGetBeatmapReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNKNOWN_ENUM1_FIELD_NUMBER = 1;
        private int unknownEnum1_;
        public static final int MUSIC_SHARE_ID_FIELD_NUMBER = 10;
        private long musicShareId_;
        public static final int UNKNOWN_ENUM2_FIELD_NUMBER = 12;
        private int unknownEnum2_;
        public static final int CDFOGGDLKNA_FIELD_NUMBER = 15;
        private boolean cDFOGGDLKNA_;
        public static final int REQ_TYPE_FIELD_NUMBER = 11;
        private int reqType_;
        private byte memoizedIsInitialized;
        private static final MusicGameGetBeatmapReq DEFAULT_INSTANCE = new MusicGameGetBeatmapReq();
        private static final Parser<MusicGameGetBeatmapReq> PARSER = new AbstractParser<MusicGameGetBeatmapReq>() { // from class: emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReq.1
            @Override // com.google.protobuf.Parser
            public MusicGameGetBeatmapReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameGetBeatmapReq(input, extensionRegistry);
            }
        };

        private MusicGameGetBeatmapReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MusicGameGetBeatmapReq() {
            this.memoizedIsInitialized = -1;
            this.unknownEnum1_ = 0;
            this.unknownEnum2_ = 0;
            this.reqType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameGetBeatmapReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicGameGetBeatmapReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.unknownEnum1_ = input.readEnum();
                                    break;
                                case 80:
                                    this.musicShareId_ = input.readUInt64();
                                    break;
                                case 88:
                                    this.reqType_ = input.readEnum();
                                    break;
                                case 96:
                                    this.unknownEnum2_ = input.readEnum();
                                    break;
                                case 120:
                                    this.cDFOGGDLKNA_ = input.readBool();
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
            return MusicGameGetBeatmapReqOuterClass.internal_static_MusicGameGetBeatmapReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameGetBeatmapReqOuterClass.internal_static_MusicGameGetBeatmapReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameGetBeatmapReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
        public int getUnknownEnum1Value() {
            return this.unknownEnum1_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
        public MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1() {
            MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum result = MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.valueOf(this.unknownEnum1_);
            return result == null ? MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
        public long getMusicShareId() {
            return this.musicShareId_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
        public int getUnknownEnum2Value() {
            return this.unknownEnum2_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
        public MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum getUnknownEnum2() {
            MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum result = MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum.valueOf(this.unknownEnum2_);
            return result == null ? MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
        public boolean getCDFOGGDLKNA() {
            return this.cDFOGGDLKNA_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
        public int getReqTypeValue() {
            return this.reqType_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
        public MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType getReqType() {
            MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType result = MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.valueOf(this.reqType_);
            return result == null ? MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.UNRECOGNIZED : result;
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
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                output.writeEnum(1, this.unknownEnum1_);
            }
            if (this.musicShareId_ != 0) {
                output.writeUInt64(10, this.musicShareId_);
            }
            if (this.reqType_ != MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.MusicGameGetBeatmapReqType_u1.getNumber()) {
                output.writeEnum(11, this.reqType_);
            }
            if (this.unknownEnum2_ != MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum.MusicGameUnknown2Enum_u1.getNumber()) {
                output.writeEnum(12, this.unknownEnum2_);
            }
            if (this.cDFOGGDLKNA_) {
                output.writeBool(15, this.cDFOGGDLKNA_);
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
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.unknownEnum1_);
            }
            if (this.musicShareId_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(10, this.musicShareId_);
            }
            if (this.reqType_ != MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.MusicGameGetBeatmapReqType_u1.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(11, this.reqType_);
            }
            if (this.unknownEnum2_ != MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum.MusicGameUnknown2Enum_u1.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.unknownEnum2_);
            }
            if (this.cDFOGGDLKNA_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.cDFOGGDLKNA_);
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
            if (!(obj instanceof MusicGameGetBeatmapReq)) {
                return equals(obj);
            }
            MusicGameGetBeatmapReq other = (MusicGameGetBeatmapReq) obj;
            return this.unknownEnum1_ == other.unknownEnum1_ && getMusicShareId() == other.getMusicShareId() && this.unknownEnum2_ == other.unknownEnum2_ && getCDFOGGDLKNA() == other.getCDFOGGDLKNA() && this.reqType_ == other.reqType_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + this.unknownEnum1_)) + 10)) + Internal.hashLong(getMusicShareId()))) + 12)) + this.unknownEnum2_)) + 15)) + Internal.hashBoolean(getCDFOGGDLKNA()))) + 11)) + this.reqType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MusicGameGetBeatmapReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameGetBeatmapReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameGetBeatmapReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameGetBeatmapReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameGetBeatmapReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameGetBeatmapReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameGetBeatmapReq parseFrom(InputStream input) throws IOException {
            return (MusicGameGetBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameGetBeatmapReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameGetBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameGetBeatmapReq parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameGetBeatmapReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameGetBeatmapReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameGetBeatmapReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameGetBeatmapReq parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameGetBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameGetBeatmapReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameGetBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameGetBeatmapReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapReqOuterClass$MusicGameGetBeatmapReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameGetBeatmapReqOrBuilder {
            private long musicShareId_;
            private boolean cDFOGGDLKNA_;
            private int unknownEnum1_ = 0;
            private int unknownEnum2_ = 0;
            private int reqType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameGetBeatmapReqOuterClass.internal_static_MusicGameGetBeatmapReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameGetBeatmapReqOuterClass.internal_static_MusicGameGetBeatmapReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameGetBeatmapReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameGetBeatmapReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unknownEnum1_ = 0;
                this.musicShareId_ = 0;
                this.unknownEnum2_ = 0;
                this.cDFOGGDLKNA_ = false;
                this.reqType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameGetBeatmapReqOuterClass.internal_static_MusicGameGetBeatmapReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameGetBeatmapReq getDefaultInstanceForType() {
                return MusicGameGetBeatmapReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameGetBeatmapReq build() {
                MusicGameGetBeatmapReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameGetBeatmapReq buildPartial() {
                MusicGameGetBeatmapReq result = new MusicGameGetBeatmapReq(this);
                result.unknownEnum1_ = this.unknownEnum1_;
                result.musicShareId_ = this.musicShareId_;
                result.unknownEnum2_ = this.unknownEnum2_;
                result.cDFOGGDLKNA_ = this.cDFOGGDLKNA_;
                result.reqType_ = this.reqType_;
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
                if (other instanceof MusicGameGetBeatmapReq) {
                    return mergeFrom((MusicGameGetBeatmapReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameGetBeatmapReq other) {
                if (other == MusicGameGetBeatmapReq.getDefaultInstance()) {
                    return this;
                }
                if (other.unknownEnum1_ != 0) {
                    setUnknownEnum1Value(other.getUnknownEnum1Value());
                }
                if (other.getMusicShareId() != 0) {
                    setMusicShareId(other.getMusicShareId());
                }
                if (other.unknownEnum2_ != 0) {
                    setUnknownEnum2Value(other.getUnknownEnum2Value());
                }
                if (other.getCDFOGGDLKNA()) {
                    setCDFOGGDLKNA(other.getCDFOGGDLKNA());
                }
                if (other.reqType_ != 0) {
                    setReqTypeValue(other.getReqTypeValue());
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
                MusicGameGetBeatmapReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameGetBeatmapReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameGetBeatmapReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
            public int getUnknownEnum1Value() {
                return this.unknownEnum1_;
            }

            public Builder setUnknownEnum1Value(int value) {
                this.unknownEnum1_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
            public int getUnknownEnum2Value() {
                return this.unknownEnum2_;
            }

            public Builder setUnknownEnum2Value(int value) {
                this.unknownEnum2_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
            public MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum getUnknownEnum2() {
                MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum result = MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum.valueOf(this.unknownEnum2_);
                return result == null ? MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum.UNRECOGNIZED : result;
            }

            public Builder setUnknownEnum2(MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unknownEnum2_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearUnknownEnum2() {
                this.unknownEnum2_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
            public boolean getCDFOGGDLKNA() {
                return this.cDFOGGDLKNA_;
            }

            public Builder setCDFOGGDLKNA(boolean value) {
                this.cDFOGGDLKNA_ = value;
                onChanged();
                return this;
            }

            public Builder clearCDFOGGDLKNA() {
                this.cDFOGGDLKNA_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
            public int getReqTypeValue() {
                return this.reqType_;
            }

            public Builder setReqTypeValue(int value) {
                this.reqType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReqOrBuilder
            public MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType getReqType() {
                MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType result = MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.valueOf(this.reqType_);
                return result == null ? MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.UNRECOGNIZED : result;
            }

            public Builder setReqType(MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.reqType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearReqType() {
                this.reqType_ = 0;
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

        public static MusicGameGetBeatmapReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameGetBeatmapReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameGetBeatmapReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameGetBeatmapReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MusicGameUnknown2EnumOuterClass.getDescriptor();
        MusicGameGetBeatmapReqTypeOuterClass.getDescriptor();
        MusicGameUnknown1EnumOuterClass.getDescriptor();
    }
}
