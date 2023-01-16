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
import emu.grasscutter.net.proto.FleurFairBalloonInfoOuterClass;
import emu.grasscutter.net.proto.FleurFairFallInfoOuterClass;
import emu.grasscutter.net.proto.FleurFairMusicGameInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMinigameInfoOuterClass.class */
public final class FleurFairMinigameInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bFleurFairMinigameInfo.proto\u001a\u001aFleurFairBalloonInfo.proto\u001a\u0017FleurFairFallInfo.proto\u001a\u001cFleurFairMusicGameInfo.proto\"á\u0001\n\u0015FleurFairMinigameInfo\u0012\u0013\n\u000bminigame_id\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007is_open\u0018\u000f \u0001(\b\u0012\u0011\n\topen_time\u0018\r \u0001(\r\u0012-\n\fballoon_info\u0018\u0001 \u0001(\u000b2\u0015.FleurFairBalloonInfoH��\u0012'\n\tfall_info\u0018\n \u0001(\u000b2\u0012.FleurFairFallInfoH��\u0012-\n\nmusic_info\u0018\u000e \u0001(\u000b2\u0017.FleurFairMusicGameInfoH��B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FleurFairBalloonInfoOuterClass.getDescriptor(), FleurFairFallInfoOuterClass.getDescriptor(), FleurFairMusicGameInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FleurFairMinigameInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FleurFairMinigameInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FleurFairMinigameInfo_descriptor, new String[]{"MinigameId", "IsOpen", "OpenTime", "BalloonInfo", "FallInfo", "MusicInfo", "Detail"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMinigameInfoOuterClass$FleurFairMinigameInfoOrBuilder.class */
    public interface FleurFairMinigameInfoOrBuilder extends MessageOrBuilder {
        int getMinigameId();

        boolean getIsOpen();

        int getOpenTime();

        boolean hasBalloonInfo();

        FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo getBalloonInfo();

        FleurFairBalloonInfoOuterClass.FleurFairBalloonInfoOrBuilder getBalloonInfoOrBuilder();

        boolean hasFallInfo();

        FleurFairFallInfoOuterClass.FleurFairFallInfo getFallInfo();

        FleurFairFallInfoOuterClass.FleurFairFallInfoOrBuilder getFallInfoOrBuilder();

        boolean hasMusicInfo();

        FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo getMusicInfo();

        FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfoOrBuilder getMusicInfoOrBuilder();

        FleurFairMinigameInfo.DetailCase getDetailCase();
    }

    private FleurFairMinigameInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMinigameInfoOuterClass$FleurFairMinigameInfo.class */
    public static final class FleurFairMinigameInfo extends GeneratedMessageV3 implements FleurFairMinigameInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int detailCase_;
        private Object detail_;
        public static final int MINIGAME_ID_FIELD_NUMBER = 3;
        private int minigameId_;
        public static final int IS_OPEN_FIELD_NUMBER = 15;
        private boolean isOpen_;
        public static final int OPEN_TIME_FIELD_NUMBER = 13;
        private int openTime_;
        public static final int BALLOON_INFO_FIELD_NUMBER = 1;
        public static final int FALL_INFO_FIELD_NUMBER = 10;
        public static final int MUSIC_INFO_FIELD_NUMBER = 14;
        private byte memoizedIsInitialized;
        private static final FleurFairMinigameInfo DEFAULT_INSTANCE = new FleurFairMinigameInfo();
        private static final Parser<FleurFairMinigameInfo> PARSER = new AbstractParser<FleurFairMinigameInfo>() { // from class: emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo.1
            @Override // com.google.protobuf.Parser
            public FleurFairMinigameInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FleurFairMinigameInfo(input, extensionRegistry);
            }
        };

        private FleurFairMinigameInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private FleurFairMinigameInfo() {
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FleurFairMinigameInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FleurFairMinigameInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.Builder subBuilder = this.detailCase_ == 1 ? ((FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo) this.detail_);
                                    this.detail_ = subBuilder.buildPartial();
                                }
                                this.detailCase_ = 1;
                                break;
                            case 24:
                                this.minigameId_ = input.readUInt32();
                                break;
                            case 82:
                                FleurFairFallInfoOuterClass.FleurFairFallInfo.Builder subBuilder2 = this.detailCase_ == 10 ? ((FleurFairFallInfoOuterClass.FleurFairFallInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FleurFairFallInfoOuterClass.FleurFairFallInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((FleurFairFallInfoOuterClass.FleurFairFallInfo) this.detail_);
                                    this.detail_ = subBuilder2.buildPartial();
                                }
                                this.detailCase_ = 10;
                                break;
                            case 104:
                                this.openTime_ = input.readUInt32();
                                break;
                            case 114:
                                FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.Builder subBuilder3 = this.detailCase_ == 14 ? ((FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo) this.detail_);
                                    this.detail_ = subBuilder3.buildPartial();
                                }
                                this.detailCase_ = 14;
                                break;
                            case 120:
                                this.isOpen_ = input.readBool();
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
            return FleurFairMinigameInfoOuterClass.internal_static_FleurFairMinigameInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FleurFairMinigameInfoOuterClass.internal_static_FleurFairMinigameInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairMinigameInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMinigameInfoOuterClass$FleurFairMinigameInfo$DetailCase.class */
        public enum DetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            BALLOON_INFO(1),
            FALL_INFO(10),
            MUSIC_INFO(14),
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
                    case 1:
                        return BALLOON_INFO;
                    case 10:
                        return FALL_INFO;
                    case 14:
                        return MUSIC_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public DetailCase getDetailCase() {
            return DetailCase.forNumber(this.detailCase_);
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public int getMinigameId() {
            return this.minigameId_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public boolean hasBalloonInfo() {
            return this.detailCase_ == 1;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo getBalloonInfo() {
            if (this.detailCase_ == 1) {
                return (FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo) this.detail_;
            }
            return FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public FleurFairBalloonInfoOuterClass.FleurFairBalloonInfoOrBuilder getBalloonInfoOrBuilder() {
            if (this.detailCase_ == 1) {
                return (FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo) this.detail_;
            }
            return FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public boolean hasFallInfo() {
            return this.detailCase_ == 10;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public FleurFairFallInfoOuterClass.FleurFairFallInfo getFallInfo() {
            if (this.detailCase_ == 10) {
                return (FleurFairFallInfoOuterClass.FleurFairFallInfo) this.detail_;
            }
            return FleurFairFallInfoOuterClass.FleurFairFallInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public FleurFairFallInfoOuterClass.FleurFairFallInfoOrBuilder getFallInfoOrBuilder() {
            if (this.detailCase_ == 10) {
                return (FleurFairFallInfoOuterClass.FleurFairFallInfo) this.detail_;
            }
            return FleurFairFallInfoOuterClass.FleurFairFallInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public boolean hasMusicInfo() {
            return this.detailCase_ == 14;
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo getMusicInfo() {
            if (this.detailCase_ == 14) {
                return (FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo) this.detail_;
            }
            return FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
        public FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfoOrBuilder getMusicInfoOrBuilder() {
            if (this.detailCase_ == 14) {
                return (FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo) this.detail_;
            }
            return FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.getDefaultInstance();
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
            if (this.detailCase_ == 1) {
                output.writeMessage(1, (FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo) this.detail_);
            }
            if (this.minigameId_ != 0) {
                output.writeUInt32(3, this.minigameId_);
            }
            if (this.detailCase_ == 10) {
                output.writeMessage(10, (FleurFairFallInfoOuterClass.FleurFairFallInfo) this.detail_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(13, this.openTime_);
            }
            if (this.detailCase_ == 14) {
                output.writeMessage(14, (FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo) this.detail_);
            }
            if (this.isOpen_) {
                output.writeBool(15, this.isOpen_);
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
            if (this.detailCase_ == 1) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, (FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo) this.detail_);
            }
            if (this.minigameId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.minigameId_);
            }
            if (this.detailCase_ == 10) {
                size2 += CodedOutputStream.computeMessageSize(10, (FleurFairFallInfoOuterClass.FleurFairFallInfo) this.detail_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.openTime_);
            }
            if (this.detailCase_ == 14) {
                size2 += CodedOutputStream.computeMessageSize(14, (FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo) this.detail_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isOpen_);
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
            if (!(obj instanceof FleurFairMinigameInfo)) {
                return equals(obj);
            }
            FleurFairMinigameInfo other = (FleurFairMinigameInfo) obj;
            if (getMinigameId() != other.getMinigameId() || getIsOpen() != other.getIsOpen() || getOpenTime() != other.getOpenTime() || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 1:
                    if (!getBalloonInfo().equals(other.getBalloonInfo())) {
                        return false;
                    }
                    break;
                case 10:
                    if (!getFallInfo().equals(other.getFallInfo())) {
                        return false;
                    }
                    break;
                case 14:
                    if (!getMusicInfo().equals(other.getMusicInfo())) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getMinigameId())) + 15)) + Internal.hashBoolean(getIsOpen()))) + 13)) + getOpenTime();
            switch (this.detailCase_) {
                case 1:
                    hash = (53 * ((37 * hash) + 1)) + getBalloonInfo().hashCode();
                    break;
                case 10:
                    hash = (53 * ((37 * hash) + 10)) + getFallInfo().hashCode();
                    break;
                case 14:
                    hash = (53 * ((37 * hash) + 14)) + getMusicInfo().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FleurFairMinigameInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairMinigameInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairMinigameInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairMinigameInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairMinigameInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairMinigameInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairMinigameInfo parseFrom(InputStream input) throws IOException {
            return (FleurFairMinigameInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairMinigameInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairMinigameInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairMinigameInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FleurFairMinigameInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FleurFairMinigameInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairMinigameInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairMinigameInfo parseFrom(CodedInputStream input) throws IOException {
            return (FleurFairMinigameInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairMinigameInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairMinigameInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FleurFairMinigameInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairMinigameInfoOuterClass$FleurFairMinigameInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FleurFairMinigameInfoOrBuilder {
            private int detailCase_ = 0;
            private Object detail_;
            private int minigameId_;
            private boolean isOpen_;
            private int openTime_;
            private SingleFieldBuilderV3<FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo, FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.Builder, FleurFairBalloonInfoOuterClass.FleurFairBalloonInfoOrBuilder> balloonInfoBuilder_;
            private SingleFieldBuilderV3<FleurFairFallInfoOuterClass.FleurFairFallInfo, FleurFairFallInfoOuterClass.FleurFairFallInfo.Builder, FleurFairFallInfoOuterClass.FleurFairFallInfoOrBuilder> fallInfoBuilder_;
            private SingleFieldBuilderV3<FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo, FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.Builder, FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfoOrBuilder> musicInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FleurFairMinigameInfoOuterClass.internal_static_FleurFairMinigameInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FleurFairMinigameInfoOuterClass.internal_static_FleurFairMinigameInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairMinigameInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FleurFairMinigameInfo.alwaysUseFieldBuilders) {
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
                return FleurFairMinigameInfoOuterClass.internal_static_FleurFairMinigameInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FleurFairMinigameInfo getDefaultInstanceForType() {
                return FleurFairMinigameInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairMinigameInfo build() {
                FleurFairMinigameInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairMinigameInfo buildPartial() {
                FleurFairMinigameInfo result = new FleurFairMinigameInfo(this);
                result.minigameId_ = this.minigameId_;
                result.isOpen_ = this.isOpen_;
                result.openTime_ = this.openTime_;
                if (this.detailCase_ == 1) {
                    if (this.balloonInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.balloonInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 10) {
                    if (this.fallInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.fallInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 14) {
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
                if (other instanceof FleurFairMinigameInfo) {
                    return mergeFrom((FleurFairMinigameInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FleurFairMinigameInfo other) {
                if (other == FleurFairMinigameInfo.getDefaultInstance()) {
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
                FleurFairMinigameInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FleurFairMinigameInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FleurFairMinigameInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
            public DetailCase getDetailCase() {
                return DetailCase.forNumber(this.detailCase_);
            }

            public Builder clearDetail() {
                this.detailCase_ = 0;
                this.detail_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
            public boolean hasBalloonInfo() {
                return this.detailCase_ == 1;
            }

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
            public FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo getBalloonInfo() {
                if (this.balloonInfoBuilder_ == null) {
                    if (this.detailCase_ == 1) {
                        return (FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo) this.detail_;
                    }
                    return FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1) {
                    return this.balloonInfoBuilder_.getMessage();
                } else {
                    return FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.getDefaultInstance();
                }
            }

            public Builder setBalloonInfo(FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo value) {
                if (this.balloonInfoBuilder_ != null) {
                    this.balloonInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1;
                return this;
            }

            public Builder setBalloonInfo(FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.Builder builderForValue) {
                if (this.balloonInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.balloonInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1;
                return this;
            }

            public Builder mergeBalloonInfo(FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo value) {
                if (this.balloonInfoBuilder_ == null) {
                    if (this.detailCase_ != 1 || this.detail_ == FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.newBuilder((FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1) {
                        this.balloonInfoBuilder_.mergeFrom(value);
                    }
                    this.balloonInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1;
                return this;
            }

            public Builder clearBalloonInfo() {
                if (this.balloonInfoBuilder_ != null) {
                    if (this.detailCase_ == 1) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.balloonInfoBuilder_.clear();
                } else if (this.detailCase_ == 1) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.Builder getBalloonInfoBuilder() {
                return getBalloonInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
            public FleurFairBalloonInfoOuterClass.FleurFairBalloonInfoOrBuilder getBalloonInfoOrBuilder() {
                if (this.detailCase_ == 1 && this.balloonInfoBuilder_ != null) {
                    return this.balloonInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1) {
                    return (FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo) this.detail_;
                }
                return FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo, FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.Builder, FleurFairBalloonInfoOuterClass.FleurFairBalloonInfoOrBuilder> getBalloonInfoFieldBuilder() {
                if (this.balloonInfoBuilder_ == null) {
                    if (this.detailCase_ != 1) {
                        this.detail_ = FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo.getDefaultInstance();
                    }
                    this.balloonInfoBuilder_ = new SingleFieldBuilderV3<>((FleurFairBalloonInfoOuterClass.FleurFairBalloonInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1;
                onChanged();
                return this.balloonInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
            public boolean hasFallInfo() {
                return this.detailCase_ == 10;
            }

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
            public FleurFairFallInfoOuterClass.FleurFairFallInfo getFallInfo() {
                if (this.fallInfoBuilder_ == null) {
                    if (this.detailCase_ == 10) {
                        return (FleurFairFallInfoOuterClass.FleurFairFallInfo) this.detail_;
                    }
                    return FleurFairFallInfoOuterClass.FleurFairFallInfo.getDefaultInstance();
                } else if (this.detailCase_ == 10) {
                    return this.fallInfoBuilder_.getMessage();
                } else {
                    return FleurFairFallInfoOuterClass.FleurFairFallInfo.getDefaultInstance();
                }
            }

            public Builder setFallInfo(FleurFairFallInfoOuterClass.FleurFairFallInfo value) {
                if (this.fallInfoBuilder_ != null) {
                    this.fallInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 10;
                return this;
            }

            public Builder setFallInfo(FleurFairFallInfoOuterClass.FleurFairFallInfo.Builder builderForValue) {
                if (this.fallInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fallInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 10;
                return this;
            }

            public Builder mergeFallInfo(FleurFairFallInfoOuterClass.FleurFairFallInfo value) {
                if (this.fallInfoBuilder_ == null) {
                    if (this.detailCase_ != 10 || this.detail_ == FleurFairFallInfoOuterClass.FleurFairFallInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FleurFairFallInfoOuterClass.FleurFairFallInfo.newBuilder((FleurFairFallInfoOuterClass.FleurFairFallInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 10) {
                        this.fallInfoBuilder_.mergeFrom(value);
                    }
                    this.fallInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 10;
                return this;
            }

            public Builder clearFallInfo() {
                if (this.fallInfoBuilder_ != null) {
                    if (this.detailCase_ == 10) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.fallInfoBuilder_.clear();
                } else if (this.detailCase_ == 10) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FleurFairFallInfoOuterClass.FleurFairFallInfo.Builder getFallInfoBuilder() {
                return getFallInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
            public FleurFairFallInfoOuterClass.FleurFairFallInfoOrBuilder getFallInfoOrBuilder() {
                if (this.detailCase_ == 10 && this.fallInfoBuilder_ != null) {
                    return this.fallInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 10) {
                    return (FleurFairFallInfoOuterClass.FleurFairFallInfo) this.detail_;
                }
                return FleurFairFallInfoOuterClass.FleurFairFallInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FleurFairFallInfoOuterClass.FleurFairFallInfo, FleurFairFallInfoOuterClass.FleurFairFallInfo.Builder, FleurFairFallInfoOuterClass.FleurFairFallInfoOrBuilder> getFallInfoFieldBuilder() {
                if (this.fallInfoBuilder_ == null) {
                    if (this.detailCase_ != 10) {
                        this.detail_ = FleurFairFallInfoOuterClass.FleurFairFallInfo.getDefaultInstance();
                    }
                    this.fallInfoBuilder_ = new SingleFieldBuilderV3<>((FleurFairFallInfoOuterClass.FleurFairFallInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 10;
                onChanged();
                return this.fallInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
            public boolean hasMusicInfo() {
                return this.detailCase_ == 14;
            }

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
            public FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo getMusicInfo() {
                if (this.musicInfoBuilder_ == null) {
                    if (this.detailCase_ == 14) {
                        return (FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo) this.detail_;
                    }
                    return FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.getDefaultInstance();
                } else if (this.detailCase_ == 14) {
                    return this.musicInfoBuilder_.getMessage();
                } else {
                    return FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.getDefaultInstance();
                }
            }

            public Builder setMusicInfo(FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo value) {
                if (this.musicInfoBuilder_ != null) {
                    this.musicInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 14;
                return this;
            }

            public Builder setMusicInfo(FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.Builder builderForValue) {
                if (this.musicInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 14;
                return this;
            }

            public Builder mergeMusicInfo(FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo value) {
                if (this.musicInfoBuilder_ == null) {
                    if (this.detailCase_ != 14 || this.detail_ == FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.newBuilder((FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 14) {
                        this.musicInfoBuilder_.mergeFrom(value);
                    }
                    this.musicInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 14;
                return this;
            }

            public Builder clearMusicInfo() {
                if (this.musicInfoBuilder_ != null) {
                    if (this.detailCase_ == 14) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.musicInfoBuilder_.clear();
                } else if (this.detailCase_ == 14) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.Builder getMusicInfoBuilder() {
                return getMusicInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass.FleurFairMinigameInfoOrBuilder
            public FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfoOrBuilder getMusicInfoOrBuilder() {
                if (this.detailCase_ == 14 && this.musicInfoBuilder_ != null) {
                    return this.musicInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 14) {
                    return (FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo) this.detail_;
                }
                return FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo, FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.Builder, FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfoOrBuilder> getMusicInfoFieldBuilder() {
                if (this.musicInfoBuilder_ == null) {
                    if (this.detailCase_ != 14) {
                        this.detail_ = FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo.getDefaultInstance();
                    }
                    this.musicInfoBuilder_ = new SingleFieldBuilderV3<>((FleurFairMusicGameInfoOuterClass.FleurFairMusicGameInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 14;
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

        public static FleurFairMinigameInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FleurFairMinigameInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FleurFairMinigameInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FleurFairMinigameInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FleurFairBalloonInfoOuterClass.getDescriptor();
        FleurFairFallInfoOuterClass.getDescriptor();
        FleurFairMusicGameInfoOuterClass.getDescriptor();
    }
}
