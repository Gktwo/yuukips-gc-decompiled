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
import emu.grasscutter.net.proto.BalloonInfoOuterClass;
import emu.grasscutter.net.proto.FallInfoOuterClass;
import emu.grasscutter.net.proto.MusicInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Uint32.class */
public final class Uint32 {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\fuint32.proto\u001a\u0011BalloonInfo.proto\u001a\u000eFallInfo.proto\u001a\u000fMusicInfo.proto\"°\u0001\n\u0006uint32\u0012\u0012\n\nminigameId\u0018\u000e \u0001(\r\u0012\u000e\n\u0006isOpen\u0018\u0003 \u0001(\b\u0012\u0010\n\bopenTime\u0018\u0006 \u0001(\r\u0012$\n\fballoon_info\u0018\r \u0001(\u000b2\f.BalloonInfoH��\u0012\u001e\n\tfall_info\u0018\u000b \u0001(\u000b2\t.FallInfoH��\u0012 \n\nmusic_info\u0018\t \u0001(\u000b2\n.MusicInfoH��B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BalloonInfoOuterClass.getDescriptor(), FallInfoOuterClass.getDescriptor(), MusicInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_uint32_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_uint32_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_uint32_descriptor, new String[]{"MinigameId", "IsOpen", "OpenTime", "BalloonInfo", "FallInfo", "MusicInfo", "Detail"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Uint32$uint32OrBuilder.class */
    public interface uint32OrBuilder extends MessageOrBuilder {
        int getMinigameId();

        boolean getIsOpen();

        int getOpenTime();

        boolean hasBalloonInfo();

        BalloonInfoOuterClass.BalloonInfo getBalloonInfo();

        BalloonInfoOuterClass.BalloonInfoOrBuilder getBalloonInfoOrBuilder();

        boolean hasFallInfo();

        FallInfoOuterClass.FallInfo getFallInfo();

        FallInfoOuterClass.FallInfoOrBuilder getFallInfoOrBuilder();

        boolean hasMusicInfo();

        MusicInfoOuterClass.MusicInfo getMusicInfo();

        MusicInfoOuterClass.MusicInfoOrBuilder getMusicInfoOrBuilder();

        uint32.DetailCase getDetailCase();
    }

    private Uint32() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Uint32$uint32.class */
    public static final class uint32 extends GeneratedMessageV3 implements uint32OrBuilder {
        private static final long serialVersionUID = 0;
        private int detailCase_;
        private Object detail_;
        public static final int MINIGAMEID_FIELD_NUMBER = 14;
        private int minigameId_;
        public static final int ISOPEN_FIELD_NUMBER = 3;
        private boolean isOpen_;
        public static final int OPENTIME_FIELD_NUMBER = 6;
        private int openTime_;
        public static final int BALLOON_INFO_FIELD_NUMBER = 13;
        public static final int FALL_INFO_FIELD_NUMBER = 11;
        public static final int MUSIC_INFO_FIELD_NUMBER = 9;
        private byte memoizedIsInitialized;
        private static final uint32 DEFAULT_INSTANCE = new uint32();
        private static final Parser<uint32> PARSER = new AbstractParser<uint32>() { // from class: emu.grasscutter.net.proto.Uint32.uint32.1
            @Override // com.google.protobuf.Parser
            public uint32 parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new uint32(input, extensionRegistry);
            }
        };

        private uint32(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private uint32() {
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new uint32();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private uint32(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 48:
                                    this.openTime_ = input.readUInt32();
                                    break;
                                case 74:
                                    MusicInfoOuterClass.MusicInfo.Builder subBuilder = this.detailCase_ == 9 ? ((MusicInfoOuterClass.MusicInfo) this.detail_).toBuilder() : null;
                                    this.detail_ = input.readMessage(MusicInfoOuterClass.MusicInfo.parser(), extensionRegistry);
                                    if (subBuilder != null) {
                                        subBuilder.mergeFrom((MusicInfoOuterClass.MusicInfo) this.detail_);
                                        this.detail_ = subBuilder.buildPartial();
                                    }
                                    this.detailCase_ = 9;
                                    break;
                                case 90:
                                    FallInfoOuterClass.FallInfo.Builder subBuilder2 = this.detailCase_ == 11 ? ((FallInfoOuterClass.FallInfo) this.detail_).toBuilder() : null;
                                    this.detail_ = input.readMessage(FallInfoOuterClass.FallInfo.parser(), extensionRegistry);
                                    if (subBuilder2 != null) {
                                        subBuilder2.mergeFrom((FallInfoOuterClass.FallInfo) this.detail_);
                                        this.detail_ = subBuilder2.buildPartial();
                                    }
                                    this.detailCase_ = 11;
                                    break;
                                case 106:
                                    BalloonInfoOuterClass.BalloonInfo.Builder subBuilder3 = this.detailCase_ == 13 ? ((BalloonInfoOuterClass.BalloonInfo) this.detail_).toBuilder() : null;
                                    this.detail_ = input.readMessage(BalloonInfoOuterClass.BalloonInfo.parser(), extensionRegistry);
                                    if (subBuilder3 != null) {
                                        subBuilder3.mergeFrom((BalloonInfoOuterClass.BalloonInfo) this.detail_);
                                        this.detail_ = subBuilder3.buildPartial();
                                    }
                                    this.detailCase_ = 13;
                                    break;
                                case 112:
                                    this.minigameId_ = input.readUInt32();
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
            return Uint32.internal_static_uint32_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Uint32.internal_static_uint32_fieldAccessorTable.ensureFieldAccessorsInitialized(uint32.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Uint32$uint32$DetailCase.class */
        public enum DetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            BALLOON_INFO(13),
            FALL_INFO(11),
            MUSIC_INFO(9),
            DETAIL_NOT_SET(0);
            
            private final int value;

            DetailCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DetailCase valueOf(int value) {
                return forNumber(value);
            }

            public static DetailCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return DETAIL_NOT_SET;
                    case 9:
                        return MUSIC_INFO;
                    case 11:
                        return FALL_INFO;
                    case 13:
                        return BALLOON_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public DetailCase getDetailCase() {
            return DetailCase.forNumber(this.detailCase_);
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public int getMinigameId() {
            return this.minigameId_;
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public boolean hasBalloonInfo() {
            return this.detailCase_ == 13;
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public BalloonInfoOuterClass.BalloonInfo getBalloonInfo() {
            if (this.detailCase_ == 13) {
                return (BalloonInfoOuterClass.BalloonInfo) this.detail_;
            }
            return BalloonInfoOuterClass.BalloonInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public BalloonInfoOuterClass.BalloonInfoOrBuilder getBalloonInfoOrBuilder() {
            if (this.detailCase_ == 13) {
                return (BalloonInfoOuterClass.BalloonInfo) this.detail_;
            }
            return BalloonInfoOuterClass.BalloonInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public boolean hasFallInfo() {
            return this.detailCase_ == 11;
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public FallInfoOuterClass.FallInfo getFallInfo() {
            if (this.detailCase_ == 11) {
                return (FallInfoOuterClass.FallInfo) this.detail_;
            }
            return FallInfoOuterClass.FallInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public FallInfoOuterClass.FallInfoOrBuilder getFallInfoOrBuilder() {
            if (this.detailCase_ == 11) {
                return (FallInfoOuterClass.FallInfo) this.detail_;
            }
            return FallInfoOuterClass.FallInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public boolean hasMusicInfo() {
            return this.detailCase_ == 9;
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public MusicInfoOuterClass.MusicInfo getMusicInfo() {
            if (this.detailCase_ == 9) {
                return (MusicInfoOuterClass.MusicInfo) this.detail_;
            }
            return MusicInfoOuterClass.MusicInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
        public MusicInfoOuterClass.MusicInfoOrBuilder getMusicInfoOrBuilder() {
            if (this.detailCase_ == 9) {
                return (MusicInfoOuterClass.MusicInfo) this.detail_;
            }
            return MusicInfoOuterClass.MusicInfo.getDefaultInstance();
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
            if (this.isOpen_) {
                output.writeBool(3, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(6, this.openTime_);
            }
            if (this.detailCase_ == 9) {
                output.writeMessage(9, (MusicInfoOuterClass.MusicInfo) this.detail_);
            }
            if (this.detailCase_ == 11) {
                output.writeMessage(11, (FallInfoOuterClass.FallInfo) this.detail_);
            }
            if (this.detailCase_ == 13) {
                output.writeMessage(13, (BalloonInfoOuterClass.BalloonInfo) this.detail_);
            }
            if (this.minigameId_ != 0) {
                output.writeUInt32(14, this.minigameId_);
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
            if (this.isOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.openTime_);
            }
            if (this.detailCase_ == 9) {
                size2 += CodedOutputStream.computeMessageSize(9, (MusicInfoOuterClass.MusicInfo) this.detail_);
            }
            if (this.detailCase_ == 11) {
                size2 += CodedOutputStream.computeMessageSize(11, (FallInfoOuterClass.FallInfo) this.detail_);
            }
            if (this.detailCase_ == 13) {
                size2 += CodedOutputStream.computeMessageSize(13, (BalloonInfoOuterClass.BalloonInfo) this.detail_);
            }
            if (this.minigameId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.minigameId_);
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
            if (!(obj instanceof uint32)) {
                return equals(obj);
            }
            uint32 other = (uint32) obj;
            if (getMinigameId() != other.getMinigameId() || getIsOpen() != other.getIsOpen() || getOpenTime() != other.getOpenTime() || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 9:
                    if (!getMusicInfo().equals(other.getMusicInfo())) {
                        return false;
                    }
                    break;
                case 11:
                    if (!getFallInfo().equals(other.getFallInfo())) {
                        return false;
                    }
                    break;
                case 13:
                    if (!getBalloonInfo().equals(other.getBalloonInfo())) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getMinigameId())) + 3)) + Internal.hashBoolean(getIsOpen()))) + 6)) + getOpenTime();
            switch (this.detailCase_) {
                case 9:
                    hash = (53 * ((37 * hash) + 9)) + getMusicInfo().hashCode();
                    break;
                case 11:
                    hash = (53 * ((37 * hash) + 11)) + getFallInfo().hashCode();
                    break;
                case 13:
                    hash = (53 * ((37 * hash) + 13)) + getBalloonInfo().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static uint32 parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static uint32 parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static uint32 parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static uint32 parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static uint32 parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static uint32 parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static uint32 parseFrom(InputStream input) throws IOException {
            return (uint32) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static uint32 parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (uint32) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static uint32 parseDelimitedFrom(InputStream input) throws IOException {
            return (uint32) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static uint32 parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (uint32) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static uint32 parseFrom(CodedInputStream input) throws IOException {
            return (uint32) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static uint32 parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (uint32) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(uint32 prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Uint32$uint32$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements uint32OrBuilder {
            private int detailCase_ = 0;
            private Object detail_;
            private int minigameId_;
            private boolean isOpen_;
            private int openTime_;
            private SingleFieldBuilderV3<BalloonInfoOuterClass.BalloonInfo, BalloonInfoOuterClass.BalloonInfo.Builder, BalloonInfoOuterClass.BalloonInfoOrBuilder> balloonInfoBuilder_;
            private SingleFieldBuilderV3<FallInfoOuterClass.FallInfo, FallInfoOuterClass.FallInfo.Builder, FallInfoOuterClass.FallInfoOrBuilder> fallInfoBuilder_;
            private SingleFieldBuilderV3<MusicInfoOuterClass.MusicInfo, MusicInfoOuterClass.MusicInfo.Builder, MusicInfoOuterClass.MusicInfoOrBuilder> musicInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Uint32.internal_static_uint32_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Uint32.internal_static_uint32_fieldAccessorTable.ensureFieldAccessorsInitialized(uint32.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (uint32.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.minigameId_ = 0;
                this.isOpen_ = false;
                this.openTime_ = 0;
                this.detailCase_ = 0;
                this.detail_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Uint32.internal_static_uint32_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public uint32 getDefaultInstanceForType() {
                return uint32.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public uint32 build() {
                uint32 result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public uint32 buildPartial() {
                uint32 result = new uint32(this);
                result.minigameId_ = this.minigameId_;
                result.isOpen_ = this.isOpen_;
                result.openTime_ = this.openTime_;
                if (this.detailCase_ == 13) {
                    if (this.balloonInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.balloonInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 11) {
                    if (this.fallInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.fallInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 9) {
                    if (this.musicInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.musicInfoBuilder_.build();
                    }
                }
                result.detailCase_ = this.detailCase_;
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
                if (other instanceof uint32) {
                    return mergeFrom((uint32) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(uint32 other) {
                if (other == uint32.getDefaultInstance()) {
                    return this;
                }
                if (other.getMinigameId() != 0) {
                    setMinigameId(other.getMinigameId());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                switch (other.getDetailCase()) {
                    case BALLOON_INFO:
                        mergeBalloonInfo(other.getBalloonInfo());
                        break;
                    case FALL_INFO:
                        mergeFallInfo(other.getFallInfo());
                        break;
                    case MUSIC_INFO:
                        mergeMusicInfo(other.getMusicInfo());
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
                uint32 parsedMessage = null;
                try {
                    try {
                        parsedMessage = uint32.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (uint32) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public DetailCase getDetailCase() {
                return DetailCase.forNumber(this.detailCase_);
            }

            public Builder clearDetail() {
                this.detailCase_ = 0;
                this.detail_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public int getMinigameId() {
                return this.minigameId_;
            }

            public Builder setMinigameId(int value) {
                this.minigameId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMinigameId() {
                this.minigameId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public boolean hasBalloonInfo() {
                return this.detailCase_ == 13;
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public BalloonInfoOuterClass.BalloonInfo getBalloonInfo() {
                if (this.balloonInfoBuilder_ == null) {
                    if (this.detailCase_ == 13) {
                        return (BalloonInfoOuterClass.BalloonInfo) this.detail_;
                    }
                    return BalloonInfoOuterClass.BalloonInfo.getDefaultInstance();
                } else if (this.detailCase_ == 13) {
                    return this.balloonInfoBuilder_.getMessage();
                } else {
                    return BalloonInfoOuterClass.BalloonInfo.getDefaultInstance();
                }
            }

            public Builder setBalloonInfo(BalloonInfoOuterClass.BalloonInfo value) {
                if (this.balloonInfoBuilder_ != null) {
                    this.balloonInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 13;
                return this;
            }

            public Builder setBalloonInfo(BalloonInfoOuterClass.BalloonInfo.Builder builderForValue) {
                if (this.balloonInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.balloonInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 13;
                return this;
            }

            public Builder mergeBalloonInfo(BalloonInfoOuterClass.BalloonInfo value) {
                if (this.balloonInfoBuilder_ == null) {
                    if (this.detailCase_ != 13 || this.detail_ == BalloonInfoOuterClass.BalloonInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BalloonInfoOuterClass.BalloonInfo.newBuilder((BalloonInfoOuterClass.BalloonInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 13) {
                        this.balloonInfoBuilder_.mergeFrom(value);
                    }
                    this.balloonInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 13;
                return this;
            }

            public Builder clearBalloonInfo() {
                if (this.balloonInfoBuilder_ != null) {
                    if (this.detailCase_ == 13) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.balloonInfoBuilder_.clear();
                } else if (this.detailCase_ == 13) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BalloonInfoOuterClass.BalloonInfo.Builder getBalloonInfoBuilder() {
                return getBalloonInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public BalloonInfoOuterClass.BalloonInfoOrBuilder getBalloonInfoOrBuilder() {
                if (this.detailCase_ == 13 && this.balloonInfoBuilder_ != null) {
                    return this.balloonInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 13) {
                    return (BalloonInfoOuterClass.BalloonInfo) this.detail_;
                }
                return BalloonInfoOuterClass.BalloonInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BalloonInfoOuterClass.BalloonInfo, BalloonInfoOuterClass.BalloonInfo.Builder, BalloonInfoOuterClass.BalloonInfoOrBuilder> getBalloonInfoFieldBuilder() {
                if (this.balloonInfoBuilder_ == null) {
                    if (this.detailCase_ != 13) {
                        this.detail_ = BalloonInfoOuterClass.BalloonInfo.getDefaultInstance();
                    }
                    this.balloonInfoBuilder_ = new SingleFieldBuilderV3<>((BalloonInfoOuterClass.BalloonInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 13;
                onChanged();
                return this.balloonInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public boolean hasFallInfo() {
                return this.detailCase_ == 11;
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public FallInfoOuterClass.FallInfo getFallInfo() {
                if (this.fallInfoBuilder_ == null) {
                    if (this.detailCase_ == 11) {
                        return (FallInfoOuterClass.FallInfo) this.detail_;
                    }
                    return FallInfoOuterClass.FallInfo.getDefaultInstance();
                } else if (this.detailCase_ == 11) {
                    return this.fallInfoBuilder_.getMessage();
                } else {
                    return FallInfoOuterClass.FallInfo.getDefaultInstance();
                }
            }

            public Builder setFallInfo(FallInfoOuterClass.FallInfo value) {
                if (this.fallInfoBuilder_ != null) {
                    this.fallInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 11;
                return this;
            }

            public Builder setFallInfo(FallInfoOuterClass.FallInfo.Builder builderForValue) {
                if (this.fallInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fallInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 11;
                return this;
            }

            public Builder mergeFallInfo(FallInfoOuterClass.FallInfo value) {
                if (this.fallInfoBuilder_ == null) {
                    if (this.detailCase_ != 11 || this.detail_ == FallInfoOuterClass.FallInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FallInfoOuterClass.FallInfo.newBuilder((FallInfoOuterClass.FallInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 11) {
                        this.fallInfoBuilder_.mergeFrom(value);
                    }
                    this.fallInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 11;
                return this;
            }

            public Builder clearFallInfo() {
                if (this.fallInfoBuilder_ != null) {
                    if (this.detailCase_ == 11) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.fallInfoBuilder_.clear();
                } else if (this.detailCase_ == 11) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FallInfoOuterClass.FallInfo.Builder getFallInfoBuilder() {
                return getFallInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public FallInfoOuterClass.FallInfoOrBuilder getFallInfoOrBuilder() {
                if (this.detailCase_ == 11 && this.fallInfoBuilder_ != null) {
                    return this.fallInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 11) {
                    return (FallInfoOuterClass.FallInfo) this.detail_;
                }
                return FallInfoOuterClass.FallInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FallInfoOuterClass.FallInfo, FallInfoOuterClass.FallInfo.Builder, FallInfoOuterClass.FallInfoOrBuilder> getFallInfoFieldBuilder() {
                if (this.fallInfoBuilder_ == null) {
                    if (this.detailCase_ != 11) {
                        this.detail_ = FallInfoOuterClass.FallInfo.getDefaultInstance();
                    }
                    this.fallInfoBuilder_ = new SingleFieldBuilderV3<>((FallInfoOuterClass.FallInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 11;
                onChanged();
                return this.fallInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public boolean hasMusicInfo() {
                return this.detailCase_ == 9;
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public MusicInfoOuterClass.MusicInfo getMusicInfo() {
                if (this.musicInfoBuilder_ == null) {
                    if (this.detailCase_ == 9) {
                        return (MusicInfoOuterClass.MusicInfo) this.detail_;
                    }
                    return MusicInfoOuterClass.MusicInfo.getDefaultInstance();
                } else if (this.detailCase_ == 9) {
                    return this.musicInfoBuilder_.getMessage();
                } else {
                    return MusicInfoOuterClass.MusicInfo.getDefaultInstance();
                }
            }

            public Builder setMusicInfo(MusicInfoOuterClass.MusicInfo value) {
                if (this.musicInfoBuilder_ != null) {
                    this.musicInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 9;
                return this;
            }

            public Builder setMusicInfo(MusicInfoOuterClass.MusicInfo.Builder builderForValue) {
                if (this.musicInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 9;
                return this;
            }

            public Builder mergeMusicInfo(MusicInfoOuterClass.MusicInfo value) {
                if (this.musicInfoBuilder_ == null) {
                    if (this.detailCase_ != 9 || this.detail_ == MusicInfoOuterClass.MusicInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MusicInfoOuterClass.MusicInfo.newBuilder((MusicInfoOuterClass.MusicInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 9) {
                        this.musicInfoBuilder_.mergeFrom(value);
                    }
                    this.musicInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 9;
                return this;
            }

            public Builder clearMusicInfo() {
                if (this.musicInfoBuilder_ != null) {
                    if (this.detailCase_ == 9) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.musicInfoBuilder_.clear();
                } else if (this.detailCase_ == 9) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MusicInfoOuterClass.MusicInfo.Builder getMusicInfoBuilder() {
                return getMusicInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.Uint32.uint32OrBuilder
            public MusicInfoOuterClass.MusicInfoOrBuilder getMusicInfoOrBuilder() {
                if (this.detailCase_ == 9 && this.musicInfoBuilder_ != null) {
                    return this.musicInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 9) {
                    return (MusicInfoOuterClass.MusicInfo) this.detail_;
                }
                return MusicInfoOuterClass.MusicInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MusicInfoOuterClass.MusicInfo, MusicInfoOuterClass.MusicInfo.Builder, MusicInfoOuterClass.MusicInfoOrBuilder> getMusicInfoFieldBuilder() {
                if (this.musicInfoBuilder_ == null) {
                    if (this.detailCase_ != 9) {
                        this.detail_ = MusicInfoOuterClass.MusicInfo.getDefaultInstance();
                    }
                    this.musicInfoBuilder_ = new SingleFieldBuilderV3<>((MusicInfoOuterClass.MusicInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 9;
                onChanged();
                return this.musicInfoBuilder_;
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

        public static uint32 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<uint32> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<uint32> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public uint32 getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BalloonInfoOuterClass.getDescriptor();
        FallInfoOuterClass.getDescriptor();
        MusicInfoOuterClass.getDescriptor();
    }
}
