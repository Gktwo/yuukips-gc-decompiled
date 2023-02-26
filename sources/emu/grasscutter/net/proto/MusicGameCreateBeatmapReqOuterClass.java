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
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicBeatmapOuterClass;
import emu.grasscutter.net.proto.MusicBriefInfoOuterClass;
import emu.grasscutter.net.proto.MusicGameUnknown1EnumOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameCreateBeatmapReqOuterClass.class */
public final class MusicGameCreateBeatmapReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fMusicGameCreateBeatmapReq.proto\u001a\u0012MusicBeatmap.proto\u001a\u0014MusicBriefInfo.proto\u001a\u001bMusicGameUnknown1Enum.proto\"¸\u0001\n\u0019MusicGameCreateBeatmapReq\u0012-\n\runknown_enum1\u0018\f \u0001(\u000e2\u0016.MusicGameUnknown1Enum\u0012%\n\fmusic_record\u0018\n \u0001(\u000b2\r.MusicBeatmapH��\u0012,\n\u0010music_brief_info\u0018ý\u0007 \u0001(\u000b2\u000f.MusicBriefInfoH\u0001B\t\n\u0007beatmapB\f\n\nbrief_infoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MusicBeatmapOuterClass.getDescriptor(), MusicBriefInfoOuterClass.getDescriptor(), MusicGameUnknown1EnumOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicGameCreateBeatmapReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicGameCreateBeatmapReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameCreateBeatmapReq_descriptor, new String[]{"UnknownEnum1", "MusicRecord", "MusicBriefInfo", "Beatmap", "BriefInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameCreateBeatmapReqOuterClass$MusicGameCreateBeatmapReqOrBuilder.class */
    public interface MusicGameCreateBeatmapReqOrBuilder extends MessageOrBuilder {
        int getUnknownEnum1Value();

        MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1();

        boolean hasMusicRecord();

        MusicBeatmapOuterClass.MusicBeatmap getMusicRecord();

        MusicBeatmapOuterClass.MusicBeatmapOrBuilder getMusicRecordOrBuilder();

        boolean hasMusicBriefInfo();

        MusicBriefInfoOuterClass.MusicBriefInfo getMusicBriefInfo();

        MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder();

        MusicGameCreateBeatmapReq.BeatmapCase getBeatmapCase();

        MusicGameCreateBeatmapReq.BriefInfoCase getBriefInfoCase();
    }

    private MusicGameCreateBeatmapReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameCreateBeatmapReqOuterClass$MusicGameCreateBeatmapReq.class */
    public static final class MusicGameCreateBeatmapReq extends GeneratedMessageV3 implements MusicGameCreateBeatmapReqOrBuilder {
        private static final long serialVersionUID = 0;
        private int beatmapCase_;
        private Object beatmap_;
        private int briefInfoCase_;
        private Object briefInfo_;
        public static final int UNKNOWN_ENUM1_FIELD_NUMBER = 12;
        private int unknownEnum1_;
        public static final int MUSIC_RECORD_FIELD_NUMBER = 10;
        public static final int MUSIC_BRIEF_INFO_FIELD_NUMBER = 1021;
        private byte memoizedIsInitialized;
        private static final MusicGameCreateBeatmapReq DEFAULT_INSTANCE = new MusicGameCreateBeatmapReq();
        private static final Parser<MusicGameCreateBeatmapReq> PARSER = new AbstractParser<MusicGameCreateBeatmapReq>() { // from class: emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReq.1
            @Override // com.google.protobuf.Parser
            public MusicGameCreateBeatmapReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameCreateBeatmapReq(input, extensionRegistry);
            }
        };

        private MusicGameCreateBeatmapReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.beatmapCase_ = 0;
            this.briefInfoCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private MusicGameCreateBeatmapReq() {
            this.beatmapCase_ = 0;
            this.briefInfoCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.unknownEnum1_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameCreateBeatmapReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicGameCreateBeatmapReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 82:
                                    MusicBeatmapOuterClass.MusicBeatmap.Builder subBuilder = this.beatmapCase_ == 10 ? ((MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_).toBuilder() : null;
                                    this.beatmap_ = input.readMessage(MusicBeatmapOuterClass.MusicBeatmap.parser(), extensionRegistry);
                                    if (subBuilder != null) {
                                        subBuilder.mergeFrom((MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_);
                                        this.beatmap_ = subBuilder.buildPartial();
                                    }
                                    this.beatmapCase_ = 10;
                                    break;
                                case 96:
                                    this.unknownEnum1_ = input.readEnum();
                                    break;
                                case PacketOpcodes.WinterCampEditSnowmanCombinationReq:
                                    MusicBriefInfoOuterClass.MusicBriefInfo.Builder subBuilder2 = this.briefInfoCase_ == 1021 ? ((MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_).toBuilder() : null;
                                    this.briefInfo_ = input.readMessage(MusicBriefInfoOuterClass.MusicBriefInfo.parser(), extensionRegistry);
                                    if (subBuilder2 != null) {
                                        subBuilder2.mergeFrom((MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_);
                                        this.briefInfo_ = subBuilder2.buildPartial();
                                    }
                                    this.briefInfoCase_ = 1021;
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
                        }
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
            return MusicGameCreateBeatmapReqOuterClass.internal_static_MusicGameCreateBeatmapReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameCreateBeatmapReqOuterClass.internal_static_MusicGameCreateBeatmapReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameCreateBeatmapReq.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameCreateBeatmapReqOuterClass$MusicGameCreateBeatmapReq$BeatmapCase.class */
        public enum BeatmapCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            MUSIC_RECORD(10),
            BEATMAP_NOT_SET(0);
            
            private final int value;

            BeatmapCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static BeatmapCase valueOf(int value) {
                return forNumber(value);
            }

            public static BeatmapCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return BEATMAP_NOT_SET;
                    case 10:
                        return MUSIC_RECORD;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
        public BeatmapCase getBeatmapCase() {
            return BeatmapCase.forNumber(this.beatmapCase_);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameCreateBeatmapReqOuterClass$MusicGameCreateBeatmapReq$BriefInfoCase.class */
        public enum BriefInfoCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            MUSIC_BRIEF_INFO(1021),
            BRIEFINFO_NOT_SET(0);
            
            private final int value;

            BriefInfoCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static BriefInfoCase valueOf(int value) {
                return forNumber(value);
            }

            public static BriefInfoCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return BRIEFINFO_NOT_SET;
                    case 1021:
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

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
        public BriefInfoCase getBriefInfoCase() {
            return BriefInfoCase.forNumber(this.briefInfoCase_);
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
        public int getUnknownEnum1Value() {
            return this.unknownEnum1_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
        public MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1() {
            MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum result = MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.valueOf(this.unknownEnum1_);
            return result == null ? MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
        public boolean hasMusicRecord() {
            return this.beatmapCase_ == 10;
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
        public MusicBeatmapOuterClass.MusicBeatmap getMusicRecord() {
            if (this.beatmapCase_ == 10) {
                return (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_;
            }
            return MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
        public MusicBeatmapOuterClass.MusicBeatmapOrBuilder getMusicRecordOrBuilder() {
            if (this.beatmapCase_ == 10) {
                return (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_;
            }
            return MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
        public boolean hasMusicBriefInfo() {
            return this.briefInfoCase_ == 1021;
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
        public MusicBriefInfoOuterClass.MusicBriefInfo getMusicBriefInfo() {
            if (this.briefInfoCase_ == 1021) {
                return (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_;
            }
            return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
        public MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder() {
            if (this.briefInfoCase_ == 1021) {
                return (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_;
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
            if (this.beatmapCase_ == 10) {
                output.writeMessage(10, (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_);
            }
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                output.writeEnum(12, this.unknownEnum1_);
            }
            if (this.briefInfoCase_ == 1021) {
                output.writeMessage(1021, (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_);
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
            if (this.beatmapCase_ == 10) {
                size2 = 0 + CodedOutputStream.computeMessageSize(10, (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_);
            }
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.unknownEnum1_);
            }
            if (this.briefInfoCase_ == 1021) {
                size2 += CodedOutputStream.computeMessageSize(1021, (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_);
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
            if (!(obj instanceof MusicGameCreateBeatmapReq)) {
                return equals(obj);
            }
            MusicGameCreateBeatmapReq other = (MusicGameCreateBeatmapReq) obj;
            if (this.unknownEnum1_ != other.unknownEnum1_ || !getBeatmapCase().equals(other.getBeatmapCase())) {
                return false;
            }
            switch (this.beatmapCase_) {
                case 10:
                    if (!getMusicRecord().equals(other.getMusicRecord())) {
                        return false;
                    }
                    break;
            }
            if (!getBriefInfoCase().equals(other.getBriefInfoCase())) {
                return false;
            }
            switch (this.briefInfoCase_) {
                case 1021:
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
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + this.unknownEnum1_;
            switch (this.beatmapCase_) {
                case 10:
                    hash = (53 * ((37 * hash) + 10)) + getMusicRecord().hashCode();
                    break;
            }
            switch (this.briefInfoCase_) {
                case 1021:
                    hash = (53 * ((37 * hash) + 1021)) + getMusicBriefInfo().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MusicGameCreateBeatmapReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameCreateBeatmapReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameCreateBeatmapReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameCreateBeatmapReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameCreateBeatmapReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameCreateBeatmapReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameCreateBeatmapReq parseFrom(InputStream input) throws IOException {
            return (MusicGameCreateBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameCreateBeatmapReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameCreateBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameCreateBeatmapReq parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameCreateBeatmapReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameCreateBeatmapReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameCreateBeatmapReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameCreateBeatmapReq parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameCreateBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameCreateBeatmapReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameCreateBeatmapReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameCreateBeatmapReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameCreateBeatmapReqOuterClass$MusicGameCreateBeatmapReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameCreateBeatmapReqOrBuilder {
            private Object beatmap_;
            private Object briefInfo_;
            private SingleFieldBuilderV3<MusicBeatmapOuterClass.MusicBeatmap, MusicBeatmapOuterClass.MusicBeatmap.Builder, MusicBeatmapOuterClass.MusicBeatmapOrBuilder> musicRecordBuilder_;
            private SingleFieldBuilderV3<MusicBriefInfoOuterClass.MusicBriefInfo, MusicBriefInfoOuterClass.MusicBriefInfo.Builder, MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> musicBriefInfoBuilder_;
            private int beatmapCase_ = 0;
            private int briefInfoCase_ = 0;
            private int unknownEnum1_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameCreateBeatmapReqOuterClass.internal_static_MusicGameCreateBeatmapReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameCreateBeatmapReqOuterClass.internal_static_MusicGameCreateBeatmapReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameCreateBeatmapReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameCreateBeatmapReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unknownEnum1_ = 0;
                this.beatmapCase_ = 0;
                this.beatmap_ = null;
                this.briefInfoCase_ = 0;
                this.briefInfo_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameCreateBeatmapReqOuterClass.internal_static_MusicGameCreateBeatmapReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameCreateBeatmapReq getDefaultInstanceForType() {
                return MusicGameCreateBeatmapReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameCreateBeatmapReq build() {
                MusicGameCreateBeatmapReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameCreateBeatmapReq buildPartial() {
                MusicGameCreateBeatmapReq result = new MusicGameCreateBeatmapReq(this);
                result.unknownEnum1_ = this.unknownEnum1_;
                if (this.beatmapCase_ == 10) {
                    if (this.musicRecordBuilder_ == null) {
                        result.beatmap_ = this.beatmap_;
                    } else {
                        result.beatmap_ = this.musicRecordBuilder_.build();
                    }
                }
                if (this.briefInfoCase_ == 1021) {
                    if (this.musicBriefInfoBuilder_ == null) {
                        result.briefInfo_ = this.briefInfo_;
                    } else {
                        result.briefInfo_ = this.musicBriefInfoBuilder_.build();
                    }
                }
                result.beatmapCase_ = this.beatmapCase_;
                result.briefInfoCase_ = this.briefInfoCase_;
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
                if (other instanceof MusicGameCreateBeatmapReq) {
                    return mergeFrom((MusicGameCreateBeatmapReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameCreateBeatmapReq other) {
                if (other == MusicGameCreateBeatmapReq.getDefaultInstance()) {
                    return this;
                }
                if (other.unknownEnum1_ != 0) {
                    setUnknownEnum1Value(other.getUnknownEnum1Value());
                }
                switch (other.getBeatmapCase()) {
                    case MUSIC_RECORD:
                        mergeMusicRecord(other.getMusicRecord());
                        break;
                }
                switch (other.getBriefInfoCase()) {
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
                MusicGameCreateBeatmapReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameCreateBeatmapReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameCreateBeatmapReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
            public BeatmapCase getBeatmapCase() {
                return BeatmapCase.forNumber(this.beatmapCase_);
            }

            public Builder clearBeatmap() {
                this.beatmapCase_ = 0;
                this.beatmap_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
            public BriefInfoCase getBriefInfoCase() {
                return BriefInfoCase.forNumber(this.briefInfoCase_);
            }

            public Builder clearBriefInfo() {
                this.briefInfoCase_ = 0;
                this.briefInfo_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
            public int getUnknownEnum1Value() {
                return this.unknownEnum1_;
            }

            public Builder setUnknownEnum1Value(int value) {
                this.unknownEnum1_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
            public boolean hasMusicRecord() {
                return this.beatmapCase_ == 10;
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
            public MusicBeatmapOuterClass.MusicBeatmap getMusicRecord() {
                if (this.musicRecordBuilder_ == null) {
                    if (this.beatmapCase_ == 10) {
                        return (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_;
                    }
                    return MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
                } else if (this.beatmapCase_ == 10) {
                    return this.musicRecordBuilder_.getMessage();
                } else {
                    return MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
                }
            }

            public Builder setMusicRecord(MusicBeatmapOuterClass.MusicBeatmap value) {
                if (this.musicRecordBuilder_ != null) {
                    this.musicRecordBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.beatmap_ = value;
                    onChanged();
                }
                this.beatmapCase_ = 10;
                return this;
            }

            public Builder setMusicRecord(MusicBeatmapOuterClass.MusicBeatmap.Builder builderForValue) {
                if (this.musicRecordBuilder_ == null) {
                    this.beatmap_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicRecordBuilder_.setMessage(builderForValue.build());
                }
                this.beatmapCase_ = 10;
                return this;
            }

            public Builder mergeMusicRecord(MusicBeatmapOuterClass.MusicBeatmap value) {
                if (this.musicRecordBuilder_ == null) {
                    if (this.beatmapCase_ != 10 || this.beatmap_ == MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance()) {
                        this.beatmap_ = value;
                    } else {
                        this.beatmap_ = MusicBeatmapOuterClass.MusicBeatmap.newBuilder((MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.beatmapCase_ == 10) {
                        this.musicRecordBuilder_.mergeFrom(value);
                    }
                    this.musicRecordBuilder_.setMessage(value);
                }
                this.beatmapCase_ = 10;
                return this;
            }

            public Builder clearMusicRecord() {
                if (this.musicRecordBuilder_ != null) {
                    if (this.beatmapCase_ == 10) {
                        this.beatmapCase_ = 0;
                        this.beatmap_ = null;
                    }
                    this.musicRecordBuilder_.clear();
                } else if (this.beatmapCase_ == 10) {
                    this.beatmapCase_ = 0;
                    this.beatmap_ = null;
                    onChanged();
                }
                return this;
            }

            public MusicBeatmapOuterClass.MusicBeatmap.Builder getMusicRecordBuilder() {
                return getMusicRecordFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
            public MusicBeatmapOuterClass.MusicBeatmapOrBuilder getMusicRecordOrBuilder() {
                if (this.beatmapCase_ == 10 && this.musicRecordBuilder_ != null) {
                    return this.musicRecordBuilder_.getMessageOrBuilder();
                }
                if (this.beatmapCase_ == 10) {
                    return (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_;
                }
                return MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MusicBeatmapOuterClass.MusicBeatmap, MusicBeatmapOuterClass.MusicBeatmap.Builder, MusicBeatmapOuterClass.MusicBeatmapOrBuilder> getMusicRecordFieldBuilder() {
                if (this.musicRecordBuilder_ == null) {
                    if (this.beatmapCase_ != 10) {
                        this.beatmap_ = MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
                    }
                    this.musicRecordBuilder_ = new SingleFieldBuilderV3<>((MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_, getParentForChildren(), isClean());
                    this.beatmap_ = null;
                }
                this.beatmapCase_ = 10;
                onChanged();
                return this.musicRecordBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
            public boolean hasMusicBriefInfo() {
                return this.briefInfoCase_ == 1021;
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
            public MusicBriefInfoOuterClass.MusicBriefInfo getMusicBriefInfo() {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.briefInfoCase_ == 1021) {
                        return (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_;
                    }
                    return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
                } else if (this.briefInfoCase_ == 1021) {
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
                    this.briefInfo_ = value;
                    onChanged();
                }
                this.briefInfoCase_ = 1021;
                return this;
            }

            public Builder setMusicBriefInfo(MusicBriefInfoOuterClass.MusicBriefInfo.Builder builderForValue) {
                if (this.musicBriefInfoBuilder_ == null) {
                    this.briefInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicBriefInfoBuilder_.setMessage(builderForValue.build());
                }
                this.briefInfoCase_ = 1021;
                return this;
            }

            public Builder mergeMusicBriefInfo(MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.briefInfoCase_ != 1021 || this.briefInfo_ == MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance()) {
                        this.briefInfo_ = value;
                    } else {
                        this.briefInfo_ = MusicBriefInfoOuterClass.MusicBriefInfo.newBuilder((MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.briefInfoCase_ == 1021) {
                        this.musicBriefInfoBuilder_.mergeFrom(value);
                    }
                    this.musicBriefInfoBuilder_.setMessage(value);
                }
                this.briefInfoCase_ = 1021;
                return this;
            }

            public Builder clearMusicBriefInfo() {
                if (this.musicBriefInfoBuilder_ != null) {
                    if (this.briefInfoCase_ == 1021) {
                        this.briefInfoCase_ = 0;
                        this.briefInfo_ = null;
                    }
                    this.musicBriefInfoBuilder_.clear();
                } else if (this.briefInfoCase_ == 1021) {
                    this.briefInfoCase_ = 0;
                    this.briefInfo_ = null;
                    onChanged();
                }
                return this;
            }

            public MusicBriefInfoOuterClass.MusicBriefInfo.Builder getMusicBriefInfoBuilder() {
                return getMusicBriefInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReqOrBuilder
            public MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder() {
                if (this.briefInfoCase_ == 1021 && this.musicBriefInfoBuilder_ != null) {
                    return this.musicBriefInfoBuilder_.getMessageOrBuilder();
                }
                if (this.briefInfoCase_ == 1021) {
                    return (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_;
                }
                return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MusicBriefInfoOuterClass.MusicBriefInfo, MusicBriefInfoOuterClass.MusicBriefInfo.Builder, MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getMusicBriefInfoFieldBuilder() {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.briefInfoCase_ != 1021) {
                        this.briefInfo_ = MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
                    }
                    this.musicBriefInfoBuilder_ = new SingleFieldBuilderV3<>((MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_, getParentForChildren(), isClean());
                    this.briefInfo_ = null;
                }
                this.briefInfoCase_ = 1021;
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

        public static MusicGameCreateBeatmapReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameCreateBeatmapReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameCreateBeatmapReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameCreateBeatmapReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MusicBeatmapOuterClass.getDescriptor();
        MusicBriefInfoOuterClass.getDescriptor();
        MusicGameUnknown1EnumOuterClass.getDescriptor();
    }
}
