package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.MusicBriefInfoOuterClass;
import emu.grasscutter.net.proto.MusicGameUnknown1EnumOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSearchBeatmapRspOuterClass.class */
public final class MusicGameSearchBeatmapRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fMusicGameSearchBeatmapRsp.proto\u001a\u0014MusicBriefInfo.proto\u001a\u001bMusicGameUnknown1Enum.proto\"¯\u0001\n\u0019MusicGameSearchBeatmapRsp\u0012\u000f\n\u0007retcode\u0018\t \u0001(\u0005\u0012-\n\runknown_enum1\u0018\u0003 \u0001(\u000e2\u0016.MusicGameUnknown1Enum\u0012\u0016\n\u000emusic_share_id\u0018\u0004 \u0001(\u0004\u0012+\n\u0010music_brief_info\u0018\u000b \u0001(\u000b2\u000f.MusicBriefInfoH��B\r\n\u000bELBEIFGDBMMB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MusicBriefInfoOuterClass.getDescriptor(), MusicGameUnknown1EnumOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicGameSearchBeatmapRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicGameSearchBeatmapRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameSearchBeatmapRsp_descriptor, new String[]{"Retcode", "UnknownEnum1", "MusicShareId", "MusicBriefInfo", "ELBEIFGDBMM"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSearchBeatmapRspOuterClass$MusicGameSearchBeatmapRspOrBuilder.class */
    public interface MusicGameSearchBeatmapRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getUnknownEnum1Value();

        MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1();

        long getMusicShareId();

        boolean hasMusicBriefInfo();

        MusicBriefInfoOuterClass.MusicBriefInfo getMusicBriefInfo();

        MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder();

        MusicGameSearchBeatmapRsp.ELBEIFGDBMMCase getELBEIFGDBMMCase();
    }

    private MusicGameSearchBeatmapRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSearchBeatmapRspOuterClass$MusicGameSearchBeatmapRsp.class */
    public static final class MusicGameSearchBeatmapRsp extends GeneratedMessageV3 implements MusicGameSearchBeatmapRspOrBuilder {
        private static final long serialVersionUID = 0;
        private int eLBEIFGDBMMCase_;
        private Object eLBEIFGDBMM_;
        public static final int RETCODE_FIELD_NUMBER = 9;
        private int retcode_;
        public static final int UNKNOWN_ENUM1_FIELD_NUMBER = 3;
        private int unknownEnum1_;
        public static final int MUSIC_SHARE_ID_FIELD_NUMBER = 4;
        private long musicShareId_;
        public static final int MUSIC_BRIEF_INFO_FIELD_NUMBER = 11;
        private byte memoizedIsInitialized;
        private static final MusicGameSearchBeatmapRsp DEFAULT_INSTANCE = new MusicGameSearchBeatmapRsp();
        private static final Parser<MusicGameSearchBeatmapRsp> PARSER = new AbstractParser<MusicGameSearchBeatmapRsp>() { // from class: emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRsp.1
            @Override // com.google.protobuf.Parser
            public MusicGameSearchBeatmapRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameSearchBeatmapRsp(input, extensionRegistry);
            }
        };

        private MusicGameSearchBeatmapRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.eLBEIFGDBMMCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private MusicGameSearchBeatmapRsp() {
            this.eLBEIFGDBMMCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.unknownEnum1_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameSearchBeatmapRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicGameSearchBeatmapRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.unknownEnum1_ = input.readEnum();
                                break;
                            case 32:
                                this.musicShareId_ = input.readUInt64();
                                break;
                            case 72:
                                this.retcode_ = input.readInt32();
                                break;
                            case 90:
                                MusicBriefInfoOuterClass.MusicBriefInfo.Builder subBuilder = this.eLBEIFGDBMMCase_ == 11 ? ((MusicBriefInfoOuterClass.MusicBriefInfo) this.eLBEIFGDBMM_).toBuilder() : null;
                                this.eLBEIFGDBMM_ = input.readMessage(MusicBriefInfoOuterClass.MusicBriefInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((MusicBriefInfoOuterClass.MusicBriefInfo) this.eLBEIFGDBMM_);
                                    this.eLBEIFGDBMM_ = subBuilder.buildPartial();
                                }
                                this.eLBEIFGDBMMCase_ = 11;
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
            return MusicGameSearchBeatmapRspOuterClass.internal_static_MusicGameSearchBeatmapRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameSearchBeatmapRspOuterClass.internal_static_MusicGameSearchBeatmapRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameSearchBeatmapRsp.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSearchBeatmapRspOuterClass$MusicGameSearchBeatmapRsp$ELBEIFGDBMMCase.class */
        public enum ELBEIFGDBMMCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            MUSIC_BRIEF_INFO(11),
            ELBEIFGDBMM_NOT_SET(0);
            
            private final int value;

            ELBEIFGDBMMCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ELBEIFGDBMMCase valueOf(int value) {
                return forNumber(value);
            }

            public static ELBEIFGDBMMCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return ELBEIFGDBMM_NOT_SET;
                    case 11:
                        return MUSIC_BRIEF_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
        public ELBEIFGDBMMCase getELBEIFGDBMMCase() {
            return ELBEIFGDBMMCase.forNumber(this.eLBEIFGDBMMCase_);
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
        public int getUnknownEnum1Value() {
            return this.unknownEnum1_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
        public MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1() {
            MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum result = MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.valueOf(this.unknownEnum1_);
            return result == null ? MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
        public long getMusicShareId() {
            return this.musicShareId_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
        public boolean hasMusicBriefInfo() {
            return this.eLBEIFGDBMMCase_ == 11;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
        public MusicBriefInfoOuterClass.MusicBriefInfo getMusicBriefInfo() {
            if (this.eLBEIFGDBMMCase_ == 11) {
                return (MusicBriefInfoOuterClass.MusicBriefInfo) this.eLBEIFGDBMM_;
            }
            return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
        public MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder() {
            if (this.eLBEIFGDBMMCase_ == 11) {
                return (MusicBriefInfoOuterClass.MusicBriefInfo) this.eLBEIFGDBMM_;
            }
            return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
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
                output.writeEnum(3, this.unknownEnum1_);
            }
            if (this.musicShareId_ != 0) {
                output.writeUInt64(4, this.musicShareId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(9, this.retcode_);
            }
            if (this.eLBEIFGDBMMCase_ == 11) {
                output.writeMessage(11, (MusicBriefInfoOuterClass.MusicBriefInfo) this.eLBEIFGDBMM_);
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
                size2 = 0 + CodedOutputStream.computeEnumSize(3, this.unknownEnum1_);
            }
            if (this.musicShareId_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(4, this.musicShareId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.retcode_);
            }
            if (this.eLBEIFGDBMMCase_ == 11) {
                size2 += CodedOutputStream.computeMessageSize(11, (MusicBriefInfoOuterClass.MusicBriefInfo) this.eLBEIFGDBMM_);
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
            if (!(obj instanceof MusicGameSearchBeatmapRsp)) {
                return equals(obj);
            }
            MusicGameSearchBeatmapRsp other = (MusicGameSearchBeatmapRsp) obj;
            if (getRetcode() != other.getRetcode() || this.unknownEnum1_ != other.unknownEnum1_ || getMusicShareId() != other.getMusicShareId() || !getELBEIFGDBMMCase().equals(other.getELBEIFGDBMMCase())) {
                return false;
            }
            switch (this.eLBEIFGDBMMCase_) {
                case 11:
                    if (!getMusicBriefInfo().equals(other.getMusicBriefInfo())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getRetcode())) + 3)) + this.unknownEnum1_)) + 4)) + Internal.hashLong(getMusicShareId());
            switch (this.eLBEIFGDBMMCase_) {
                case 11:
                    hash = (53 * ((37 * hash) + 11)) + getMusicBriefInfo().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MusicGameSearchBeatmapRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSearchBeatmapRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSearchBeatmapRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSearchBeatmapRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSearchBeatmapRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSearchBeatmapRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSearchBeatmapRsp parseFrom(InputStream input) throws IOException {
            return (MusicGameSearchBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameSearchBeatmapRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSearchBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameSearchBeatmapRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameSearchBeatmapRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameSearchBeatmapRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSearchBeatmapRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameSearchBeatmapRsp parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameSearchBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameSearchBeatmapRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSearchBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameSearchBeatmapRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSearchBeatmapRspOuterClass$MusicGameSearchBeatmapRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameSearchBeatmapRspOrBuilder {
            private Object eLBEIFGDBMM_;
            private int retcode_;
            private long musicShareId_;
            private SingleFieldBuilderV3<MusicBriefInfoOuterClass.MusicBriefInfo, MusicBriefInfoOuterClass.MusicBriefInfo.Builder, MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> musicBriefInfoBuilder_;
            private int eLBEIFGDBMMCase_ = 0;
            private int unknownEnum1_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameSearchBeatmapRspOuterClass.internal_static_MusicGameSearchBeatmapRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameSearchBeatmapRspOuterClass.internal_static_MusicGameSearchBeatmapRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameSearchBeatmapRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameSearchBeatmapRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.unknownEnum1_ = 0;
                this.musicShareId_ = 0;
                this.eLBEIFGDBMMCase_ = 0;
                this.eLBEIFGDBMM_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameSearchBeatmapRspOuterClass.internal_static_MusicGameSearchBeatmapRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameSearchBeatmapRsp getDefaultInstanceForType() {
                return MusicGameSearchBeatmapRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameSearchBeatmapRsp build() {
                MusicGameSearchBeatmapRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameSearchBeatmapRsp buildPartial() {
                MusicGameSearchBeatmapRsp result = new MusicGameSearchBeatmapRsp(this);
                result.retcode_ = this.retcode_;
                result.unknownEnum1_ = this.unknownEnum1_;
                result.musicShareId_ = this.musicShareId_;
                if (this.eLBEIFGDBMMCase_ == 11) {
                    if (this.musicBriefInfoBuilder_ == null) {
                        result.eLBEIFGDBMM_ = this.eLBEIFGDBMM_;
                    } else {
                        result.eLBEIFGDBMM_ = this.musicBriefInfoBuilder_.build();
                    }
                }
                result.eLBEIFGDBMMCase_ = this.eLBEIFGDBMMCase_;
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
                if (other instanceof MusicGameSearchBeatmapRsp) {
                    return mergeFrom((MusicGameSearchBeatmapRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameSearchBeatmapRsp other) {
                if (other == MusicGameSearchBeatmapRsp.getDefaultInstance()) {
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
                switch (other.getELBEIFGDBMMCase()) {
                    case MUSIC_BRIEF_INFO:
                        mergeMusicBriefInfo(other.getMusicBriefInfo());
                        break;
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
                MusicGameSearchBeatmapRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameSearchBeatmapRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameSearchBeatmapRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
            public ELBEIFGDBMMCase getELBEIFGDBMMCase() {
                return ELBEIFGDBMMCase.forNumber(this.eLBEIFGDBMMCase_);
            }

            public Builder clearELBEIFGDBMM() {
                this.eLBEIFGDBMMCase_ = 0;
                this.eLBEIFGDBMM_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
            public int getUnknownEnum1Value() {
                return this.unknownEnum1_;
            }

            public Builder setUnknownEnum1Value(int value) {
                this.unknownEnum1_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
            public boolean hasMusicBriefInfo() {
                return this.eLBEIFGDBMMCase_ == 11;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
            public MusicBriefInfoOuterClass.MusicBriefInfo getMusicBriefInfo() {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.eLBEIFGDBMMCase_ == 11) {
                        return (MusicBriefInfoOuterClass.MusicBriefInfo) this.eLBEIFGDBMM_;
                    }
                    return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
                } else if (this.eLBEIFGDBMMCase_ == 11) {
                    return this.musicBriefInfoBuilder_.getMessage();
                } else {
                    return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
                }
            }

            public Builder setMusicBriefInfo(MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.musicBriefInfoBuilder_ != null) {
                    this.musicBriefInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.eLBEIFGDBMM_ = value;
                    onChanged();
                }
                this.eLBEIFGDBMMCase_ = 11;
                return this;
            }

            public Builder setMusicBriefInfo(MusicBriefInfoOuterClass.MusicBriefInfo.Builder builderForValue) {
                if (this.musicBriefInfoBuilder_ == null) {
                    this.eLBEIFGDBMM_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicBriefInfoBuilder_.setMessage(builderForValue.build());
                }
                this.eLBEIFGDBMMCase_ = 11;
                return this;
            }

            public Builder mergeMusicBriefInfo(MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.eLBEIFGDBMMCase_ != 11 || this.eLBEIFGDBMM_ == MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance()) {
                        this.eLBEIFGDBMM_ = value;
                    } else {
                        this.eLBEIFGDBMM_ = MusicBriefInfoOuterClass.MusicBriefInfo.newBuilder((MusicBriefInfoOuterClass.MusicBriefInfo) this.eLBEIFGDBMM_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.eLBEIFGDBMMCase_ == 11) {
                        this.musicBriefInfoBuilder_.mergeFrom(value);
                    }
                    this.musicBriefInfoBuilder_.setMessage(value);
                }
                this.eLBEIFGDBMMCase_ = 11;
                return this;
            }

            public Builder clearMusicBriefInfo() {
                if (this.musicBriefInfoBuilder_ != null) {
                    if (this.eLBEIFGDBMMCase_ == 11) {
                        this.eLBEIFGDBMMCase_ = 0;
                        this.eLBEIFGDBMM_ = null;
                    }
                    this.musicBriefInfoBuilder_.clear();
                } else if (this.eLBEIFGDBMMCase_ == 11) {
                    this.eLBEIFGDBMMCase_ = 0;
                    this.eLBEIFGDBMM_ = null;
                    onChanged();
                }
                return this;
            }

            public MusicBriefInfoOuterClass.MusicBriefInfo.Builder getMusicBriefInfoBuilder() {
                return getMusicBriefInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRspOrBuilder
            public MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder() {
                if (this.eLBEIFGDBMMCase_ == 11 && this.musicBriefInfoBuilder_ != null) {
                    return this.musicBriefInfoBuilder_.getMessageOrBuilder();
                }
                if (this.eLBEIFGDBMMCase_ == 11) {
                    return (MusicBriefInfoOuterClass.MusicBriefInfo) this.eLBEIFGDBMM_;
                }
                return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MusicBriefInfoOuterClass.MusicBriefInfo, MusicBriefInfoOuterClass.MusicBriefInfo.Builder, MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getMusicBriefInfoFieldBuilder() {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.eLBEIFGDBMMCase_ != 11) {
                        this.eLBEIFGDBMM_ = MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
                    }
                    this.musicBriefInfoBuilder_ = new SingleFieldBuilderV3<>((MusicBriefInfoOuterClass.MusicBriefInfo) this.eLBEIFGDBMM_, getParentForChildren(), isClean());
                    this.eLBEIFGDBMM_ = null;
                }
                this.eLBEIFGDBMMCase_ = 11;
                onChanged();
                return this.musicBriefInfoBuilder_;
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

        public static MusicGameSearchBeatmapRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameSearchBeatmapRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameSearchBeatmapRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameSearchBeatmapRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MusicBriefInfoOuterClass.getDescriptor();
        MusicGameUnknown1EnumOuterClass.getDescriptor();
    }
}
